package com.findajob.jobamax.util

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import com.findajob.jobamax.BaseFragment
import com.findajob.jobamax.R
import com.ckdroid.dynamicpermissions.PermissionStatus
import com.ckdroid.dynamicpermissions.PermissionUtils
import kotlinx.android.synthetic.main.dialog_basic.view.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import java.io.ByteArrayOutputStream
import java.io.FileInputStream

fun Context.errorToast() {
    Toast.makeText(this, "Something went wrong", Toast.LENGTH_SHORT).show()
}

fun Context.errorToast(e: Throwable?) {
    Toast.makeText(this, e?.message ?: "Something went wrong", Toast.LENGTH_SHORT).show()
}

fun BaseFragment.errorToast(e: Throwable?) {
    requireActivity().errorToast(e)
}


fun Context.executeAfter(millis: Long, f: () -> Unit) {
    doAsync {
        Thread.sleep(millis)
        uiThread {
            f()
        }
    }
}

fun Activity.checkForPermissions(): Boolean {

    val STORAGE_AND_CAMERA_PERMISSIONS = arrayOf(
        Manifest.permission.WRITE_EXTERNAL_STORAGE,
        Manifest.permission.READ_EXTERNAL_STORAGE,
        Manifest.permission.CAMERA
    )
    val permissionResult = PermissionUtils.checkAndRequestPermissions(
        this,
        STORAGE_AND_CAMERA_PERMISSIONS.toMutableList(),
        102
    )
    when (permissionResult.finalStatus) {
        PermissionStatus.ALLOWED -> return true
        /*PermissionStatus.DENIED_PERMANENTLY -> {
            if (important) showPermissionGrantDialog()
            return false
        }*/
        else -> {
            ActivityCompat.requestPermissions(
                this,
                STORAGE_AND_CAMERA_PERMISSIONS,
                REQUEST_ALL_PERMISSIONS
            )
            return false
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

fun showBasicDialog(
    context: Context,
    message: String,
    buttonText: String?,
    buttonClick: DialogInterface.OnDismissListener?
) {
    //Inflate the dialog as custom view
    val dialogView = LayoutInflater.from(context).inflate(R.layout.dialog_basic, null)

    //AlertDialogBuilder
    val dialog = AlertDialog.Builder(context).setView(dialogView)

    //setting text values
    dialogView.tv_message.text = message
    if (!buttonText.isNullOrEmpty()) {
        dialogView.primaryButton.text = buttonText
    }

    //show dialog
    val dialogInstance = dialog.show()
    dialogInstance.window?.setBackgroundDrawableResource(android.R.color.transparent);

    if (buttonClick != null) {
        dialogInstance.setOnDismissListener(buttonClick)
    }

    dialogView.primaryButton.setOnClickListener {
        dialogInstance.dismiss()
    }
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
    return "$minutes min : $seconds sec"
}
