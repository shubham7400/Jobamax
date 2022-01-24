package com.findajob.jobamax.util

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.FileProvider
import com.findajob.jobamax.BuildConfig
import com.findajob.jobamax.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import java.io.File
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*

class ImagePicker constructor(var getImage: GetImage) : BottomSheetDialogFragment() {


    lateinit var cameraImage: File
    private var cameraFilePath: String? = null

    private val CAMERA_REQUEST_CODE: Int = 1021
    private val GALARY_REQUEST_CODE: Int = 1056

    public override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val view: View = inflater.inflate(R.layout.layout_image_picker, container, false)

        view.findViewById<View>(R.id.camera).setOnClickListener {
            if (requireActivity().checkForPermissions()) {
                captureFromCamera()
            }
        }
        view.findViewById<View>(R.id.gallery).setOnClickListener {
            if (requireActivity().checkForPermissions()) {
                startGallery()
            }
        }
        return view
    }

    interface GetImage {
        fun setGalleryImage(imageUri: Uri?)
        fun setCameraImage(filePath: String?)
        fun setImageFile(file: File?)
    }

    public override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == GALARY_REQUEST_CODE) {
                val returnUri: Uri? = data!!.data
                getImage.setGalleryImage(returnUri)
            }
            if (requestCode == CAMERA_REQUEST_CODE) {
                getImage.setImageFile(cameraImage)
                getImage.setCameraImage(cameraFilePath)
            }
            dismiss()
        }
    }

    private fun startGallery() {
        val cameraIntent: Intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        cameraIntent.type = "image/*"
        if (cameraIntent.resolveActivity(requireActivity().packageManager) != null) {
            startActivityForResult(cameraIntent, GALARY_REQUEST_CODE)
        }
    }


    @Throws(IOException::class)
    private fun createImageFile(): File {
        val timeStamp: String = SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
        val imageFileName: String = "JPEG_" + timeStamp + "_"
        val storageDir: File = File(requireContext().getExternalFilesDir(Environment.DIRECTORY_DCIM), "Camera")
        val image: File = File.createTempFile(imageFileName,  /* prefix */".jpg",  /* suffix */storageDir /* directory */)
        cameraFilePath = "file://" + image.absolutePath
        cameraImage = image
        return image
    }

    private fun captureFromCamera() {
        try {
            val intent: Intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
              intent.putExtra(MediaStore.EXTRA_OUTPUT, FileProvider.getUriForFile((context)!!, BuildConfig.APPLICATION_ID + ".provider", createImageFile()))
            startActivityForResult(intent, CAMERA_REQUEST_CODE)
        } catch (ex: IOException) {
            ex.printStackTrace()
        }
    }
}