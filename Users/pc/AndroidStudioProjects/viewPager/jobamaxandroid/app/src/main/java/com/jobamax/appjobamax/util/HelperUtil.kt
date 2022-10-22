package com.jobamax.appjobamax.util

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.LinearGradient
import android.graphics.Shader.TileMode
import android.graphics.drawable.GradientDrawable
import android.location.Geocoder
import android.net.Uri
import android.util.Patterns
import android.view.View
import android.view.ViewAnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.google.gson.Gson
import com.jobamax.appjobamax.R
import com.jobamax.appjobamax.extensions.yyyyMMddHHmmss
import com.parse.ParseFile
import com.parse.SaveCallback
import java.io.ByteArrayOutputStream
import java.io.FileInputStream
import java.io.InputStream
import java.util.*
import kotlin.math.hypot


fun convertCustomObjectToJsonString(customObject: Any) : String {
    return Gson().toJson(customObject)
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
        addresses?.get(0)!!.getAddressLine(0)
    } catch (e: Exception) {
        ""
    }
}


fun Fragment.getShader(textView: TextView): LinearGradient {
    return LinearGradient(0f, 0f, textView.width.toFloat(), textView.textSize, intArrayOf(resources.getColor(R.color.colorAccent,null), resources.getColor(R.color.new_purple,null)), floatArrayOf(0f, 1f), TileMode.CLAMP)
}
fun Activity.getShader(textView: TextView): LinearGradient {
    return LinearGradient(0f, 0f, textView.width.toFloat(), textView.textSize, intArrayOf(resources.getColor(R.color.colorAccent,null), resources.getColor(R.color.new_purple,null)), floatArrayOf(0f, 1f), TileMode.CLAMP)
}

fun CharSequence?.isValidEmail() = !isNullOrEmpty() && Patterns.EMAIL_ADDRESS.matcher(this).matches()


fun changeDrawableColor(tag: View, backgroundColor: Int) {
    val drawable = tag.background.mutate() as GradientDrawable
    drawable.setColor(tag.resources.getColor(backgroundColor, null))
}

fun Fragment.openLink( link: String){
    val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(link))
    startActivity(browserIntent)
}

fun Activity.openLink( link: String){
    val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(link))
    startActivity(browserIntent)
}


