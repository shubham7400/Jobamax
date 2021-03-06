package com.jobamax.appjobamax.util

import android.app.Activity
import android.content.Context
import android.location.Geocoder
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.ckdroid.dynamicpermissions.PermissionStatus
import com.ckdroid.dynamicpermissions.PermissionUtils
import com.jobamax.appjobamax.BaseFragment
import com.jobamax.appjobamax.R
import com.jobamax.appjobamax.data.pojo.Categories
import com.jobamax.appjobamax.data.pojo.CategoryGroup
import com.jobamax.appjobamax.preference.getJobSearchFilterCategories
import com.google.gson.Gson
import com.parse.ParseFile
import com.parse.SaveCallback
import java.io.ByteArrayOutputStream
import java.io.FileInputStream
import java.io.InputStream
import java.util.*


fun Context.errorToast() {
    Toast.makeText(this, "Something went wrong", Toast.LENGTH_SHORT).show()
}

fun Context.errorToast(e: Throwable?) {
    Toast.makeText(this, e?.message ?: "Something went wrong", Toast.LENGTH_SHORT).show()
}

fun BaseFragment.errorToast(e: Throwable?) {
    requireActivity().errorToast(e)
}


fun Activity.checkForPermissions(permissions: Array<String>): Boolean {
    val permissionResult = PermissionUtils.checkAndRequestPermissions(this, permissions.toMutableList(), 102)
    return when (permissionResult.finalStatus) {
        PermissionStatus.ALLOWED -> true
        else -> {
            ActivityCompat.requestPermissions(this, permissions, REQUEST_ALL_PERMISSIONS)
            false
        }
    }
}

fun Fragment.checkForPermissions(permissions: Array<String>): Boolean {
    val permissionResult = PermissionUtils.checkAndRequestPermissions(requireActivity(), permissions.toMutableList(), 102)
    return when (permissionResult.finalStatus) {
        PermissionStatus.ALLOWED -> true
        else -> {
             requestPermissions(permissions, REQUEST_ALL_PERMISSIONS)
            false
        }
    }
}

fun Fragment.hideKeyboard() {
    view?.let { activity?.hideKeyboard(it) }
}

fun Activity.hideKeyboard() {
    hideKeyboard(currentFocus ?: View(this))
}

fun Context.hideKeyboard(view: View) {
    val inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
}




fun Activity.showDialog(
    message: String,
    okButton: String? = null,
    cancelButton: String? = null,
    onClick: (status: Boolean) -> Unit = { _ -> }
) {
    val dialogView = LayoutInflater.from(this).inflate(R.layout.dialog_basic_2, null)

    val tvMessage = dialogView.findViewById<AppCompatTextView>(R.id.tv_message)
    val btnOk = dialogView.findViewById<AppCompatButton>(R.id.btn_ok)
    val btnCancel = dialogView.findViewById<AppCompatButton>(R.id.btn_cancel)
    val dialog = AlertDialog.Builder(this).setView(dialogView)

    tvMessage.text = message
    okButton?.let {
        btnOk.text = it
    }
    cancelButton?.let {
        btnCancel.text = it
    }

    val dialogInstance = dialog.show()
    dialogInstance.window?.setBackgroundDrawableResource(android.R.color.transparent);

    btnOk.setOnClickListener {
        onClick(true)
        dialogInstance.dismiss()
    }
    btnCancel.setOnClickListener {
        onClick(false)
        dialogInstance.dismiss()
    }
}

fun convertAudioToByteArray(path: String): ByteArray? {
    val fis = FileInputStream(path)
    val bos = ByteArrayOutputStream()
    val b = ByteArray(1024)
    var readNum: Int
    while (fis.read(b).also { readNum = it } != -1) {
        bos.write(b, 0, readNum)
    }
    return bos.toByteArray()
}

fun convertMillisToMinuteAndSecond(millis: Long) : String {
    val milliseconds: Long = millis
    val minutes = milliseconds / 1000 / 60
    val seconds = milliseconds / 1000 % 60
    return "$minutes:$seconds"
}

fun loadImageFromUrl(imageView: ImageView, url: String?, defaultImage: Int ){
    Glide.with(imageView.context).applyDefaultRequestOptions( RequestOptions().placeholder(defaultImage).error(defaultImage)).load(url).into(imageView)
}

fun uploadImageToParse(uri: Uri, requireContext: Context, onException: (String) -> Unit, onSuccess: (String) -> Unit) {
    val inputStream: InputStream? = requireContext.contentResolver.openInputStream(uri)
    var fileName = requireContext.getFileName(uri)
    if (fileName.isEmpty())
        fileName = Date().yyyyMMddHHmmss()
    val parseFile = ParseFile(fileName, inputStream?.readBytes())
    parseFile.saveInBackground(SaveCallback { exception ->
        if (exception != null){
            onException(exception.message.toString())
        }else{
            onSuccess(parseFile.url)
        }
    })
}

fun getAddressByLatLng(lat: Double, lng: Double, requireContext: Context) : String {
    val geocoder = Geocoder(requireContext, Locale.getDefault())
    val addresses = geocoder.getFromLocation(lat, lng, 1)
    return try {
        addresses[0].getAddressLine(0)
    } catch (e: Exception) {
        ""
    }
}


fun getJobCategories(requireContext: Context): ArrayList<Categories> = if (requireContext.getJobSearchFilterCategories() == "") {
    Categories.getJobCategories(requireContext)
} else {
    val categoryGroup = Gson().fromJson(
        requireContext.getJobSearchFilterCategories(),
        CategoryGroup::class.java
    )
    categoryGroup.list
}

fun convertPhaseNameInCurrentLanguage(phaseName: String, languageCode: String) : String {
   return if (languageCode == FRENCH_LANG_CODE){
        return if (trackingEventMap.containsKey(phaseName)){
            trackingEventMap[phaseName]!!
        }else{
            phaseName
        }
    }else{
        if (trackingEventMap.containsKey(phaseName)){
            return phaseName
        }else{
            if (trackingEventMap.containsValue(phaseName)){
                trackingEventMap.forEach {
                    if (it.value == phaseName){
                        return it.key
                    }
                }
                phaseName
            }else{
                return phaseName
            }
        }
    }
}

fun getPasswordEncryptionTransformation() : String {
    return ALGORITHM
}
fun getPasswordEncryptionKey() : String {
    return KEY
}

