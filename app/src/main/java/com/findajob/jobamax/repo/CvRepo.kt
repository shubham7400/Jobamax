package com.findajob.jobamax.repo

import android.app.Application
import com.findajob.jobamax.preference.getUserId
import com.parse.ParseObject
import com.parse.ParseQuery

class CvRepo(val context: Application) {
	
	fun save(company: ParseObject, callback: SaveCvCallback) {
		company.saveInBackground { e ->
			callback.onFinish(e == null)
		}
	}
	
	fun get(callback: GetCvCallback) {
		val query = ParseQuery.getQuery<ParseObject>("CvModel")
		query.whereEqualTo("jobSeekerId", context.getUserId())
		query.findInBackground { it, e ->
			val item = it?.firstOrNull()
			when {
				e != null -> callback.onFinish(null)
				else -> callback.onFinish(item)
			}
		}
	}
}

interface SaveCvCallback {
	fun onFinish(isSuccessful: Boolean)
}

interface GetCvCallback {
	fun onFinish(cv: ParseObject?)
}