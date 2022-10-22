package com.jobamax.appjobamax.jobseeker.build_profile

import android.Manifest
import android.app.Activity
import android.content.ContentResolver
import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import android.media.MediaMetadataRetriever
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.MimeTypeMap
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.work.*
import com.abedelazizshe.lightcompressorlibrary.CompressionListener
import com.abedelazizshe.lightcompressorlibrary.VideoCompressor
import com.abedelazizshe.lightcompressorlibrary.VideoQuality
import com.abedelazizshe.lightcompressorlibrary.config.Configuration
import com.google.android.gms.tasks.Task
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.jobamax.appjobamax.R
import com.jobamax.appjobamax.base.BaseFragment
import com.jobamax.appjobamax.databinding.FragmentPickVideoBinding
import com.jobamax.appjobamax.extensions.checkForPermissions
import com.jobamax.appjobamax.extensions.log
import com.jobamax.appjobamax.extensions.toast
import com.jobamax.appjobamax.jobseeker.profile.SeekerCreateCvActivity
import com.jobamax.appjobamax.jobseeker.search.ManualAndPersonalizeActivity
import com.jobamax.appjobamax.jobseeker.view_model.SeekerHomeViewModel
import com.jobamax.appjobamax.model.JobSeeker
import java.io.File

const val REQUEST_VIDEO_CAPTURE = 1
class PickVideoFragment : BaseFragment() {
   lateinit var binding: FragmentPickVideoBinding

    private lateinit var rocketAnimation: AnimationDrawable

    lateinit var jobSeeker: JobSeeker

    val viewModel: SeekerHomeViewModel by activityViewModels()

    private var videoUrl = ""

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentPickVideoBinding.inflate(inflater, container, false)
        configureUi()
        return binding.root
    }

    private fun configureUi() {
        setClickListeners()
        initializeJobSeeker()
        setLoadingView()
    }

    private fun setLoadingView() {
        binding.ivLoading.apply {
            setBackgroundResource(R.drawable.animation_loading_import_resume)
            rocketAnimation = background as AnimationDrawable
        }
        rocketAnimation.start()
    }


    private fun initializeJobSeeker() {
        jobSeeker = viewModel.jobSeeker
        if (viewModel.jobSeekerObject == null) {
            (requireActivity() as BuildProfileActivity).getJobSeeker {
                if (it) {
                    jobSeeker = viewModel.jobSeeker
                }
            }
        }
    }

    private fun setClickListeners() {
        binding.clVideo.setOnClickListener {
            if (checkForPermissions(arrayOf(Manifest.permission.CAMERA))){
                dispatchTakeVideoIntent()
            }
        }
        binding.ivBackButton.setOnClickListener {
            requireActivity().onBackPressed()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_VIDEO_CAPTURE && resultCode == Activity.RESULT_OK) {
            val videoUri: Uri? = data?.data
            if (videoUri != null){
                if (isVideoDurationWithinOneMinute(videoUri)){
                    VideoCompressor.start(
                        context = requireActivity().applicationContext,
                        uris = listOf(videoUri),
                        isStreamable = true,
                        saveAt = Environment.DIRECTORY_MOVIES,
                        listener = object : CompressionListener {
                            override fun onProgress(index: Int, percent: Float) {

                            }
                            override fun onStart(index: Int) {
                                binding.llLoading.visibility = View.VISIBLE
                            }
                            override fun onSuccess(index: Int, size: Long, path: String?) {
                                binding.ivLoading.visibility = View.GONE
                                uploadVideo(Uri.fromFile( File(path)))
                            }
                            override fun onFailure(index: Int, failureMessage: String) {
                                binding.llLoading.visibility = View.GONE
                            }
                            override fun onCancelled(index: Int) {
                                binding.llLoading.visibility = View.GONE
                            }
                        },
                        configureWith = Configuration(
                            quality = VideoQuality.VERY_LOW,
                            frameRate = 20, /*Int, ignore, or null*/
                            isMinBitrateCheckEnabled = true,
                            videoBitrate = 2577198, /*Int, ignore, or null*/
                            disableAudio = false, /*Boolean, or ignore*/
                            keepOriginalResolution = false, /*Boolean, or ignore*/
                            /* videoWidth = 360.0, *//*Double, ignore, or null*//*
                       videoHeight = 480.0 *//*Double, ignore, or null*/
                        )
                    )

                }else{
                    toast("Video can not be more than 1 minute.")
                }
            }
        }
    }

    private fun isVideoDurationWithinOneMinute(videoUri: Uri): Boolean {
        var properDuration = false
        val retriever =   MediaMetadataRetriever()
        retriever.setDataSource(context, videoUri)
        val time = retriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DURATION)
        properDuration = time?.toLong()!! < 60000
        retriever.release()
        return properDuration
    }

    private fun filetype(videoUri: Uri): String? {
        val r: ContentResolver = requireActivity().contentResolver
        val mimeTypeMap = MimeTypeMap.getSingleton()
        return mimeTypeMap.getExtensionFromMimeType(r.getType(videoUri))
    }

    private fun uploadVideo(videoUri: Uri) {
        try {
            val reference: StorageReference = FirebaseStorage.getInstance().getReference("PortfolioVideos/" + System.currentTimeMillis() + "." + filetype(videoUri))
            binding.sbAudio.visibility = View.VISIBLE
            reference.putFile(videoUri)
                .addOnSuccessListener { taskSnapshot ->
                    val uriTask: Task<Uri> = taskSnapshot.storage.downloadUrl
                    while (!uriTask.isSuccessful);
                    videoUrl = uriTask.result.toString()
                    saveDataToParse()
                    binding.llLoading.visibility = View.GONE
                    Toast.makeText(requireContext(), "Video Uploaded!!", Toast.LENGTH_SHORT).show()
                }.addOnFailureListener { e ->
                    binding.llLoading.visibility = View.GONE
                    Toast.makeText(requireContext(), "Failed " + e.message, Toast.LENGTH_SHORT).show()
                }.addOnProgressListener { taskSnapshot ->
                    val progress = (100 * taskSnapshot.bytesTransferred / taskSnapshot.totalByteCount).toInt()
                    binding.sbAudio.progress = progress
                }
        }catch (e: Exception){ }
    }

    private fun saveDataToParse() {
        viewModel.jobSeekerObject?.put("introVideoUrl", videoUrl)
        viewModel.jobSeekerObject?.saveInBackground {
            if (it != null){
                log(it.message.toString())
            }else{
                try {
                    (requireActivity() as BuildProfileActivity).getJobSeeker {
                        findNavController().navigate(R.id.action_pickVideoFragment_to_addVideoFragment, null)
                    }
                }catch (e: Exception){
                    try {
                        (requireActivity() as SeekerCreateCvActivity).getJobSeeker {
                            findNavController().navigate(R.id.action_pickVideoFragment_to_addVideoFragment, null)
                        }
                    }catch (e: Exception){
                        (requireActivity() as ManualAndPersonalizeActivity).getJobSeeker {
                            findNavController().navigate(R.id.action_pickVideoFragment_to_addVideoFragment, null)
                        }
                    }
                }
            }
        }
    }


    private fun dispatchTakeVideoIntent() {
        Intent(MediaStore.ACTION_VIDEO_CAPTURE).also { takeVideoIntent ->
            takeVideoIntent.resolveActivity(requireActivity().packageManager)?.also {
                startActivityForResult(takeVideoIntent, REQUEST_VIDEO_CAPTURE)
            }
        }
    }
}