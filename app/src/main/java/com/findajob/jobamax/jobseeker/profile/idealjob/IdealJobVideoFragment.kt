package com.findajob.jobamax.jobseeker.profile.idealjob

import android.app.Activity
import android.content.ContentResolver
import android.content.Intent
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
import androidx.lifecycle.ViewModel
import com.abedelazizshe.lightcompressorlibrary.CompressionListener
import com.abedelazizshe.lightcompressorlibrary.VideoCompressor
import com.abedelazizshe.lightcompressorlibrary.VideoQuality
import com.abedelazizshe.lightcompressorlibrary.config.Configuration
import com.findajob.jobamax.R
import com.findajob.jobamax.base.BaseFragmentMain
import com.findajob.jobamax.cropper.CropImage
import com.findajob.jobamax.data.pojo.IdealJob
import com.findajob.jobamax.databinding.FragmentIdealJobVideoBinding
import com.findajob.jobamax.enums.ParseTableFields
import com.findajob.jobamax.enums.ParseTableName
import com.findajob.jobamax.jobseeker.home.JobSeekerHomeViewModel
 import com.findajob.jobamax.jobseeker.profile.VideoPlayActivity
 import com.findajob.jobamax.util.log
import com.findajob.jobamax.util.toast
import com.google.android.gms.tasks.Task
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.parse.ParseObject
import com.parse.ParseQuery
import org.jetbrains.anko.support.v4.runOnUiThread
import java.io.File


class IdealJobVideoFragment : BaseFragmentMain<FragmentIdealJobVideoBinding>() {

    override val layoutRes: Int get() = R.layout.fragment_ideal_job_video
    val viewModel: JobSeekerHomeViewModel by activityViewModels()
    override fun getViewModel(): ViewModel = viewModel

    private var videoUrl = ""
    private val REQUEST_VIDEO_CAPTURE = 1
    var idealJob: IdealJob? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentIdealJobVideoBinding.inflate(inflater, container, false)
        configureUi()
        return binding.root
    }

    private fun configureUi() {
        setClickListeners()
    }

    private fun getIdealJobData() {
        val query = ParseQuery.getQuery<ParseObject>(ParseTableName.IdealJob.toString())
        query.whereEqualTo(ParseTableFields.jobSeeker.toString(), viewModel.jobSeeker.pfObject)
        query.include("jobSeeker")
        query.getFirstInBackground { result, e ->
            when {
                e != null -> {
                    toast("${e.message.toString()}")
                }
                result != null -> {
                    idealJob = IdealJob(result)
                    videoUrl = idealJob!!.videoUrl
                    setVideoImage()
                }
            }
        }
    }

    private fun saveDataToParse() {
         if (idealJob == null){
            val portfolioParseObject = ParseObject(ParseTableName.IdealJob.toString())
            viewModel.jobSeeker.pfObject?.let { it1 ->
                portfolioParseObject.put("jobSeeker", it1)
            }
            portfolioParseObject.put("videoUrl", videoUrl)
            progressHud.show()
            portfolioParseObject.saveInBackground {
                progressHud.dismiss()
                if(it != null){
                    toast("${it.message.toString()}")
                }
            }
        }else{
            val portfolioParseObject = idealJob!!.pfObject
            portfolioParseObject?.let {
                viewModel.jobSeeker.pfObject?.let { it1 -> it.put("jobSeeker", it1) }
                it.put("videoUrl", videoUrl)
            }
            progressHud.show()
            portfolioParseObject?.saveInBackground {
                progressHud.dismiss()
                if(it != null){
                    toast("${it.message.toString()}")
                }
            }
        }
    }


    private fun setClickListeners() {
        binding.ivAddVideo.setOnClickListener {
            dispatchTakeVideoIntent()
        }
        binding.ivBackButton.setOnClickListener {
            requireActivity().onBackPressed()
        }
        binding.roundedImageView.setOnClickListener {
            if (videoUrl != ""){
                startActivity(Intent(requireContext(), VideoPlayActivity::class.java).putExtra("video_url", videoUrl))
            }else{
                toast("Video does not exist.")
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
                                runOnUiThread {
                                    progressHud.show()
                                }
                            }
                            override fun onStart(index: Int) {
                                log(" started ")
                            }
                            override fun onSuccess(index: Int, size: Long, path: String?) {
                                log(" completed $path")
                                progressHud.dismiss()
                                uploadVideo(Uri.fromFile( File(path)))
                            }
                            override fun onFailure(index: Int, failureMessage: String) {
                                log(" failed ")
                                progressHud.dismiss()
                            }
                            override fun onCancelled(index: Int) {
                                progressHud.dismiss()
                                log(" Cancelled ")
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
        val reference: StorageReference = FirebaseStorage.getInstance().getReference("PortfolioVideos/" + System.currentTimeMillis() + "." + filetype(videoUri))
        reference.putFile(videoUri)
            .addOnSuccessListener { taskSnapshot ->
                progressHud.dismiss()
                val uriTask: Task<Uri> = taskSnapshot.storage.downloadUrl
                while (!uriTask.isSuccessful);
                videoUrl = uriTask.result.toString()
                setVideoImage()
                saveDataToParse()
                Toast.makeText(requireContext(), "Video Uploaded!!", Toast.LENGTH_SHORT).show()
            }.addOnFailureListener { e ->
                progressHud.dismiss()
                Toast.makeText(requireContext(), "Failed " + e.message, Toast.LENGTH_SHORT).show()
            }.addOnProgressListener {
                progressHud.show()
            }
    }

    private fun setVideoImage() {
        if (videoUrl != "") {
            binding.roundedImageView.setImageResource(R.drawable.ic_play_circle_filled)
        } else {
            binding.roundedImageView.setImageDrawable(null);
        }
    }


    override fun onCreated(savedInstance: Bundle?) {
        getIdealJobData()
        binding.jobSeeker = viewModel.jobSeeker
    }

}