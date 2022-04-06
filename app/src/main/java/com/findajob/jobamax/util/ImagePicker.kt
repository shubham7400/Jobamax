package com.findajob.jobamax.util

import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.Intent
import android.graphics.Bitmap
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

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
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
        fun setImageUri(imageUri: Uri?)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == GALARY_REQUEST_CODE) {
                val uri: Uri? = data!!.data
                getImage.setImageUri(uri)
            }
            if (requestCode == CAMERA_REQUEST_CODE) {
                getImage.setImageUri(Uri.fromFile(cameraImage))
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
        val storageDir: File? = requireContext().getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        return File.createTempFile("JPEG_${timeStamp}_", ".jpg", storageDir).apply {
            cameraImage = this
            cameraFilePath = this.absolutePath
        }
    }

    private fun captureFromCamera() {
        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { takePictureIntent ->
            takePictureIntent.resolveActivity(requireActivity().packageManager)?.also {
                val photoFile: File? = try {
                    createImageFile()
                } catch (ex: IOException) {
                  log(ex.message.toString())
                    null
                }
                photoFile?.also {
                    val photoURI: Uri = FileProvider.getUriForFile(requireContext(), "com.findajob.jobamax.provider", it)
                    takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI)
                    startActivityForResult(takePictureIntent, CAMERA_REQUEST_CODE)
                }
            }
        }
    }
}