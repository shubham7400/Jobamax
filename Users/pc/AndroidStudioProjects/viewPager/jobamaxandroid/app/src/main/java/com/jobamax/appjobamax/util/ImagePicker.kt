package com.jobamax.appjobamax.util

import android.Manifest
import android.content.Intent
import android.database.Cursor
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.provider.OpenableColumns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.FileProvider
import androidx.lifecycle.lifecycleScope
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.jobamax.appjobamax.R
import com.jobamax.appjobamax.extensions.checkForPermissions
import com.jobamax.appjobamax.extensions.log
import id.zelory.compressor.Compressor
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.io.InputStream
import java.text.SimpleDateFormat
import java.util.*

const val IMAGE_PICKER_TYPE_GALLERY = 1
const val IMAGE_PICKER_TYPE_CAMERA = 2
const val IMAGE_PICKER_TYPE_NONE = 3
class ImagePicker(var getImage: GetImage, private val imageCode: Int, private val imagePickerType: Int = IMAGE_PICKER_TYPE_NONE) : BottomSheetDialogFragment() {


    private lateinit var cameraImage: File

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val view: View = inflater.inflate(R.layout.layout_image_picker, container, false)

        val camera = view.findViewById<View>(R.id.camera)
        camera.setOnClickListener {
            if (requireActivity().checkForPermissions(arrayOf(Manifest.permission.CAMERA))) {
                captureFromCamera()
            }
        }
        val gallery = view.findViewById<View>(R.id.gallery)
        gallery.setOnClickListener {
            if (requireActivity().checkForPermissions(arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE))) {
                selectImageFromGallery()
            }
        }
        when(imagePickerType){
            IMAGE_PICKER_TYPE_GALLERY -> {
                view.visibility = View.GONE
                gallery.performClick()
            }
            IMAGE_PICKER_TYPE_CAMERA -> {
                view.visibility = View.GONE
                camera.performClick()
            }
            else -> { }
        }
        return view
    }


    interface GetImage {
        fun setImageUri(imageUri: Uri?, requestCode: Int)
    }





    // take image from gallery

    private fun selectImageFromGallery() = selectImageFromGalleryResult.launch("image/*")
    private val selectImageFromGalleryResult = registerForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
        uri?.let {
            val file = getFile(uri)
            compressImageAndSendCallback(file)
        }
    }

    private fun getFile(uri: Uri): File {
        val destinationFilename = File(requireContext().filesDir.path + File.separatorChar + queryName(uri))
        try {
            requireContext().contentResolver.openInputStream(uri).use { ins ->
                if (ins != null) {
                    createFileFromStream(ins, destinationFilename)
                }
            }
        } catch (ex: Exception) {
            log("Save File  ${ ex.message}" )
            ex.printStackTrace()
        }
        return destinationFilename
    }

    private fun queryName(uri: Uri): String {
        val returnCursor: Cursor = requireContext().contentResolver.query(uri, null, null, null, null)!!
        val nameIndex: Int = returnCursor.getColumnIndex(OpenableColumns.DISPLAY_NAME)
        returnCursor.moveToFirst()
        val name: String = returnCursor.getString(nameIndex)
        returnCursor.close()
        return name
    }

    private fun createFileFromStream(ins: InputStream, destination: File?) {
        try {
            FileOutputStream(destination).use { os ->
                val buffer = ByteArray(4096)
                var length: Int
                while (ins.read(buffer).also { length = it } > 0) {
                    os.write(buffer, 0, length)
                }
                os.flush()
            }
        } catch (ex: java.lang.Exception) {
            log("Save File ${ex.message}")
            ex.printStackTrace()
        }
    }


    // take image from camera

    private val takeImageResult = registerForActivityResult(ActivityResultContracts.TakePicture()) { isSuccess ->
        if (isSuccess) {
            compressImageAndSendCallback(cameraImage)
        }
    }

    private fun compressImageAndSendCallback(file: File) {
        var compressedImage: File? = null
        lifecycleScope.launch(Dispatchers.IO) {
            if (file.length() > 400000) {
                compressedImage = Compressor.compress(requireContext(), file)
            }
            val newUri = if (compressedImage != null) {
                Uri.fromFile(compressedImage)
            } else {
                Uri.fromFile(file)
            }
            getImage.setImageUri(newUri, imageCode)
            dismiss()
        }
    }

    @Throws(IOException::class)
    private fun createImageFile(): File {
        val timeStamp: String = SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
        val storageDir: File? = requireContext().getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        return File.createTempFile("JPEG_${timeStamp}_", ".jpg", storageDir).apply {
            cameraImage = this
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
                    val photoURI: Uri = FileProvider.getUriForFile(requireContext(), "com.jobamax.appjobamax.provider", it)
                    takeImageResult.launch(photoURI)
                }
            }
        }
    }

}