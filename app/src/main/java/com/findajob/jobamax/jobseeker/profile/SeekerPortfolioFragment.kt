package com.findajob.jobamax.jobseeker.profile

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.media.MediaPlayer
import android.media.MediaRecorder
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import com.findajob.jobamax.R
import com.findajob.jobamax.base.BaseFragmentMain
import com.findajob.jobamax.databinding.FragmentSeekerPortfolioBinding
import com.findajob.jobamax.jobseeker.home.JobSeekerHomeViewModel
import java.io.IOException
import androidx.documentfile.provider.DocumentFile
import androidx.recyclerview.widget.RecyclerView
import com.findajob.jobamax.cropper.CropImage
import com.findajob.jobamax.cropper.CropImageView
import com.findajob.jobamax.databinding.ItemPortfolioImageBinding
import com.findajob.jobamax.repo.SaveParseObjectCallback
import com.findajob.jobamax.util.ImagePicker
import com.findajob.jobamax.util.errorToast
import com.findajob.jobamax.util.log
import com.findajob.jobamax.util.toast
import com.squareup.picasso.Picasso
import jp.wasabeef.picasso.transformations.CropCircleTransformation
import kotlinx.android.synthetic.main.fragment_job_seeker_profile.*
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.FileInputStream
import java.util.*
import kotlin.collections.ArrayList


private const val LOG_TAG = "AudioRecordTest"
private const val REQUEST_RECORD_AUDIO_PERMISSION = 200
const val ADD_NEW_ITEM = "addNewItem"

class SeekerPortfolioFragment : BaseFragmentMain<FragmentSeekerPortfolioBinding>(), ImagePicker.GetImage {

    override val layoutRes: Int get() = R.layout.fragment_seeker_portfolio
    val viewModel: JobSeekerHomeViewModel by activityViewModels()
    override fun getViewModel(): ViewModel = viewModel


    private var fileName: String = ""
    private var recorder: MediaRecorder? = null
    var audioUrl = ""
    private var player: MediaPlayer? = null
    var mStartRecording = true
    var mStartPlaying = true

    lateinit var imagePicker: ImagePicker
    lateinit var adapter: PortfolioImageAdapter

    val portfolioImageUrlList = arrayListOf<String>(ADD_NEW_ITEM)

    // Requesting permission to RECORD_AUDIO
    private var permissionToRecordAccepted = false
    private var permissions: Array<String> = arrayOf(Manifest.permission.RECORD_AUDIO)

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        permissionToRecordAccepted = if (requestCode == REQUEST_RECORD_AUDIO_PERMISSION) {
            grantResults[0] == PackageManager.PERMISSION_GRANTED
        } else {
            false
        }
        if (!permissionToRecordAccepted)
             requireActivity().onBackPressed()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentSeekerPortfolioBinding.inflate(inflater, container, false)
        configureUi()
        return binding.root
    }

    private fun configureUi() {
        setAdapter()
        setClickListeners()
        viewModelObserver()
    }

    private fun setAdapter() {
         adapter = PortfolioImageAdapter(portfolioImageUrlList)
        binding.rvImageAndVideo.adapter = adapter
        adapter.addImage = {
            setupImagePicker()
        }
        adapter.removeImage = {
            portfolioImageUrlList.remove(it)
            adapter.submitList(portfolioImageUrlList)
            adapter.notifyDataSetChanged()
        }
    }

    private fun setupImagePicker() {
        imagePicker = ImagePicker(this)
        imagePicker.show(requireActivity().supportFragmentManager, imagePicker.tag);
    }

    private fun viewModelObserver() {

    }

    private fun setClickListeners() {
        binding.btnPlay.setOnClickListener {
            onPlay(mStartPlaying)
            mStartPlaying = !mStartPlaying
        }
        binding.btnRetake.setOnClickListener {
            onRecord(mStartRecording)
            mStartRecording = !mStartRecording
        }
    }

    private fun onRecord(start: Boolean) = if (start) { startRecording() } else { stopRecording() }
    private fun onPlay(start: Boolean) = if (start) { startPlaying() } else { stopPlaying() }
    private fun startPlaying() {
        player = MediaPlayer().apply {
            try {
                setDataSource(audioUrl)
                prepare()
                start()
            } catch (e: IOException) {
                Log.e(LOG_TAG, "prepare() failed")
            }
        }
    }

    private fun stopPlaying() {
        player?.release()
        player = null
    }
    private fun startRecording() {
        recorder = MediaRecorder().apply {
            setAudioSource(MediaRecorder.AudioSource.MIC)
            setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP)
            setOutputFile(fileName)
            setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB)
            try {
                prepare()
            } catch (e: IOException) {
                Log.e(LOG_TAG, "prepare() failed")
            }
            start()
        }
    }

    private fun stopRecording() {
        recorder?.apply {
            stop()
            release()
        }
        recorder = null
        uploadAudio()
    }

    private fun uploadAudio() {
         viewModel.uploadUserAudio(convert(fileName), {
             if (it != null) {
                 toast("${it.message.toString()}")
             }
         }, {
             if (it != null) {
                 audioUrl = it
             }
         })
    }

    @Throws(IOException::class)
    fun convert(path: String): ByteArray? {
        val fis = FileInputStream(path)
        val bos = ByteArrayOutputStream()
        val b = ByteArray(1024)
        var readNum: Int
        while (fis.read(b).also { readNum = it } != -1) {
            bos.write(b, 0, readNum)
        }
        return bos.toByteArray()
    }

    override fun onCreated(savedInstance: Bundle?) {
        fileName = "${requireActivity().filesDir!!.absolutePath}/userAudio.3gp"
        ActivityCompat.requestPermissions(requireActivity(), permissions, REQUEST_RECORD_AUDIO_PERMISSION)
    }
    override fun onStop() {
        super.onStop()
        recorder?.release()
        recorder = null
        player?.release()
        player = null
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK && data != null) {
                val result = CropImage.getActivityResult(data)
                val profilePicUri = result.uri
                if (profilePicUri != null) {
                   viewModel.uploadImage(profilePicUri, {
                       if (it != null) {
                           toast("${it.message.toString()}")
                       }
                   },{
                       if (it != null) {
                           portfolioImageUrlList.add(it)
                           adapter.submitList(portfolioImageUrlList)
                           adapter.notifyDataSetChanged()
                       }
                   })
                }

            } else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {
                requireContext().errorToast()
            }
        }
    }


    override fun setGalleryImage(imageUri: Uri?) {
        imageUri?.let { cropImageFromUri(it) }
    }

    override fun setCameraImage(filePath: String?) {
        filePath?.let { cropImageFromUri(Uri.fromFile(File(filePath))) }

    }

    override fun setImageFile(file: File?) {
        file?.let { cropImageFromUri(Uri.fromFile(file)) }
    }

    private fun cropImageFromUri(uri: Uri) {
        CropImage.activity(uri)
            .setGuidelines(CropImageView.Guidelines.ON)
            .setCropShape(CropImageView.CropShape.RECTANGLE)
            .setAspectRatio(1, 1)
            .setRequestedSize(480, 0, CropImageView.RequestSizeOptions.RESIZE_FIT)
            .start(this)
    }
}

class PortfolioImageAdapter(var list : ArrayList<String>) : RecyclerView.Adapter<PortfolioImageAdapter.ViewHolder>() {
    var addImage : () -> Unit = {}
    var removeImage : (String) -> Unit = {}
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(ItemPortfolioImageBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.binding.apply {
            when (item) {
                ADD_NEW_ITEM -> {
                    this.ivAction.setImageResource(R.drawable.add_blue)
                    this.roundedImageView.setImageBitmap(null)
                    this.ivAction.setOnClickListener {
                        addImage()
                    }
                }
                else -> {
                    this.ivAction.setImageResource(R.drawable.close_blue_white_background)
                    Picasso.get().load(item).transform(CropCircleTransformation()).into(this.roundedImageView)
                    this.ivAction.setOnClickListener {
                        removeImage(item)
                    }
                }
            }
        }
    }
    override fun getItemCount(): Int = list.size
    fun submitList(portfolioImageUrlList: ArrayList<String>) {
        if (portfolioImageUrlList.isNotEmpty() && portfolioImageUrlList.size > 1){
            Collections.swap(portfolioImageUrlList, portfolioImageUrlList.indexOf(ADD_NEW_ITEM),portfolioImageUrlList.lastIndex)
        }
        list = portfolioImageUrlList
    }

    class ViewHolder(val binding: ItemPortfolioImageBinding) : RecyclerView.ViewHolder(binding.root)
}