package com.jobamax.appjobamax.util

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.LinearGradient
import android.graphics.Shader
import android.graphics.drawable.GradientDrawable
import android.location.Geocoder
import android.net.Uri
import android.text.SpannableString
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import android.util.Patterns
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.text.toSpannable
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.jobamax.appjobamax.R
import com.jobamax.appjobamax.extensions.yyyyMMddHHmmss
import com.jobamax.appjobamax.model.JobSeeker
import com.parse.ParseFile
import com.parse.SaveCallback
import java.io.ByteArrayOutputStream
import java.io.FileInputStream
import java.io.InputStream
import java.util.*
import kotlin.math.roundToInt




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
    val min = if (minutes.toString().length == 1) { "0$minutes" } else { minutes }
    val sec = if (seconds.toString().length == 1) { "0$seconds" } else { seconds }
    return "$min:$sec"
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
    return LinearGradient(0f, 0f, textView.width.toFloat(), textView.textSize, intArrayOf(resources.getColor(R.color.colorAccent,null), resources.getColor(R.color.new_purple,null)), floatArrayOf(0f, 1f), Shader.TileMode.CLAMP)
}
fun Activity.getShader(textView: TextView): LinearGradient {
    return LinearGradient(0f, 0f, textView.width.toFloat(), textView.textSize, intArrayOf(resources.getColor(R.color.colorAccent,null), resources.getColor(R.color.new_purple,null)), floatArrayOf(0f, 1f), Shader.TileMode.CLAMP)
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

fun changeColorOfSubString(msg: String, startIndex: Int, endIndex: Int, colorCode: Int): SpannableString {
    val spannableString = SpannableString(msg)
    val color = ForegroundColorSpan(colorCode)
    spannableString.setSpan(color, startIndex, endIndex, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
    return spannableString
}

fun calculateCompleteProfile(jobSeeker: JobSeeker): Int {
    val list = jobSeeker.run {
        arrayListOf(
            this.profilePicUrl.isNotEmpty(),
            this.firstName.isNotEmpty(),
            this.university.isNotEmpty(),
            this.interestedIn.isNotEmpty(),
            this.city.isNotEmpty(),
            this.elevatorPitch.isNotEmpty(),
            this.educations.isNotEmpty(),
            this.introVideoUrl.isNotEmpty(),
            this.introAudioUrl.isNotEmpty(),
            this.experiences.isNotEmpty(),
            this.hardSkills.isNotEmpty(),
            this.softSkills.isNotEmpty(),
            this.volunteerings.isNotEmpty(),
            this.interests.isNotEmpty(),
            this.images.isNotEmpty(),
            this.workspaces.isNotEmpty()
        )
    }
    return ((100 * list.filter { it }.size).toDouble() / list.size).roundToInt()
}

