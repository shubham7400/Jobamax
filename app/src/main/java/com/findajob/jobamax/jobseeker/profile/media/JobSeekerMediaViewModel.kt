package com.findajob.jobamax.jobseeker.profile.media

import android.app.Application
import android.graphics.Bitmap
import android.net.Uri
import android.util.Size
import androidx.lifecycle.AndroidViewModel
import com.findajob.jobamax.jobseeker.home.JobSeekerHomeViewModel
import com.findajob.jobamax.model.JobSeeker
import com.findajob.jobamax.preference.setProfilePicUrl
import com.findajob.jobamax.repo.SaveParseObjectCallback
import com.findajob.jobamax.util.getFileName
import com.findajob.jobamax.util.yyyyMMddHHmmss
import com.parse.ParseFile
import com.parse.ParseObject
import com.parse.SaveCallback
import java.io.ByteArrayOutputStream
import java.io.InputStream
import java.util.*


class JobSeekerMediaViewModel(val context: Application, val viewModel: JobSeekerHomeViewModel) : AndroidViewModel(context) {

	private var jobSeekerObject: ParseObject? = viewModel.jobSeekerObject

	val jobSeeker
		get() = if (jobSeekerObject == null) JobSeeker() else JobSeeker(jobSeekerObject!!)

	var profilePicUri: Uri? = null
	var personalPresentationUri: Uri? = null
	var attachmentUri: Uri? = null

	fun uploadProfilePicUri(callback: SaveParseObjectCallback) {
		if (profilePicUri == null) {
			uploadPersonalPresentation(callback)
		} else {
			val inputStream: InputStream? = context.contentResolver.openInputStream(profilePicUri!!)
			var fileName = context.getFileName(profilePicUri!!)

			if (fileName.isEmpty())
				fileName = Date().yyyyMMddHHmmss()
			val parseFile = ParseFile(fileName, inputStream?.readBytes())
			parseFile.saveInBackground(SaveCallback {
				if (it == null) {
					jobSeekerObject?.put("profilePicUrl", parseFile.url)
					val user = jobSeekerObject?.getParseObject("user")
					user?.put("profilePicUrl", parseFile.url)
					user?.saveInBackground()
					context.setProfilePicUrl(parseFile.url ?: "")
					uploadPersonalPresentation(callback)
				} else callback.onFinish(false)
			})
		}
	}

	fun uploadPersonalPresentation(callback: SaveParseObjectCallback) {
		if (personalPresentationUri == null) {
			uploadAttachment(callback)
		} else {
			val inputStream: InputStream? = context.contentResolver.openInputStream(personalPresentationUri!!)
			val fileName = context.getFileName(personalPresentationUri!!)
			var parseFile = ParseFile(fileName, inputStream?.readBytes())
			parseFile.saveInBackground(SaveCallback {
				if (it == null) {
					jobSeekerObject?.put("personalPresentationLink", parseFile.url)
					val stream = ByteArrayOutputStream()
					val thumbnail = if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.Q) {
						context.contentResolver.loadThumbnail(personalPresentationUri!!, Size(480, 240), null)
					} else {
						null
					}
					thumbnail?.compress(Bitmap.CompressFormat.PNG, 100, stream)
					parseFile = ParseFile("$fileName-thumb.png", stream.toByteArray())
					parseFile.saveInBackground(SaveCallback {
						jobSeekerObject?.put("videoThumbnailUrl", parseFile.url)
						uploadAttachment(callback)
					})
				} else callback.onFinish(false)
			})
		}
	}

	fun uploadAttachment(callback: SaveParseObjectCallback) {
		if (attachmentUri == null) {
			saveJobSeeker(callback)
		} else {
			val inputStream: InputStream? = context.contentResolver.openInputStream(attachmentUri!!)
			val fileName = context.getFileName(attachmentUri!!)
			val parseFile = ParseFile(fileName, inputStream?.readBytes())

			parseFile.saveInBackground(SaveCallback {
				if (it == null) {
					jobSeekerObject?.put("attachmentCVLink", parseFile.url)
					saveJobSeeker(callback)
				} else callback.onFinish(false)
			})
		}
	}

	fun saveJobSeeker(callback: SaveParseObjectCallback) {
		jobSeekerObject?.saveInBackground {
			callback.onFinish(it == null)
		}
	}

}