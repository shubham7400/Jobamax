package com.findajob.jobamax.recruiter.profile.media

import android.app.Application
import android.graphics.Bitmap
import android.net.Uri
import android.util.Size
import com.findajob.jobamax.base.BaseAndroidViewModel
import com.findajob.jobamax.base.BaseViewModel
import com.findajob.jobamax.model.Company
import com.findajob.jobamax.model.Recruiter
import com.findajob.jobamax.recruiter.home.RecruiterHomeViewModel
import com.findajob.jobamax.repo.SaveParseObjectCallback
import com.findajob.jobamax.util.getFileName
import com.findajob.jobamax.util.yyyyMMddHHmmss
import com.parse.ParseFile
import com.parse.ParseObject
import com.parse.SaveCallback
import dagger.hilt.android.lifecycle.HiltViewModel
import java.io.ByteArrayOutputStream
import java.io.InputStream
import java.util.*
import javax.inject.Inject

@HiltViewModel
class RecruiterMediaViewModel @Inject constructor(
    val context: Application,
) : BaseAndroidViewModel(context) {

    var companyParseObject: ParseObject? = null
    var recruiterParseObject: ParseObject? = null


    val recruiter: Recruiter
        get() = if (recruiterParseObject == null) Recruiter() else Recruiter(recruiterParseObject!!)

    val company: Company
        get() = if (companyParseObject == null) Company() else Company(companyParseObject!!)

    var logoUri: Uri? = null
    var videoUri: Uri? = null


    fun uploadLogo(callback: SaveParseObjectCallback) {
        if (logoUri == null) {
            uploadVideoPresentation(callback)
        } else {
            val inputStream: InputStream? = context.contentResolver.openInputStream(logoUri!!)
            var fileName = context.getFileName(logoUri!!)
            if (fileName.isEmpty())
                fileName = Date().yyyyMMddHHmmss()
            val parseFile = ParseFile(fileName, inputStream?.readBytes())
            parseFile.saveInBackground(SaveCallback {
                if (it == null) {
                    companyParseObject?.put("logoUrl", parseFile.url)
                    uploadVideoPresentation(callback)
                } else callback.onFinish(false)
            })
        }
    }


    fun uploadVideoPresentation(callback: SaveParseObjectCallback) {
        if (videoUri == null) {
            saveCompany(callback)
        } else {
            val inputStream: InputStream? = context.contentResolver.openInputStream(videoUri!!)
            val fileName = context.getFileName(videoUri!!)
            var parseFile = ParseFile(fileName, inputStream?.readBytes())
            parseFile.saveInBackground(SaveCallback {
                if (it == null) {
                    companyParseObject?.put("videoPresentationUrl", parseFile.url)
                    val stream = ByteArrayOutputStream()

                    val thumbnail =
                        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.Q) {
                            context.contentResolver.loadThumbnail(videoUri!!, Size(480, 240), null)
                        } else null

                    thumbnail?.compress(Bitmap.CompressFormat.PNG, 100, stream)
                    parseFile = ParseFile("$fileName-thumb.png", stream.toByteArray())
                    parseFile.saveInBackground(SaveCallback {
                        companyParseObject?.put("videoPresentationThumbLink", parseFile.url)
                        saveCompany(callback)
                    })
                } else callback.onFinish(false)
            })
        }
    }

    fun saveCompany(callback: SaveParseObjectCallback) {
        companyParseObject?.saveInBackground {
            callback.onFinish(it == null)
        }
    }

}