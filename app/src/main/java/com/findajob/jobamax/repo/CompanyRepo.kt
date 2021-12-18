package com.findajob.jobamax.repo

import android.content.Context
import com.findajob.jobamax.preference.getUserId
import com.parse.ParseObject
import com.parse.ParseQuery

class CompanyRepo(val context: Context) {
	
	fun save(company: ParseObject, callback: SaveParseObjectCallback) {
		company.saveInBackground { e ->
			callback.onFinish(e == null)
		}
	}
	
	fun get(callback: GetCompanyCallback) {
		val query = ParseQuery.getQuery<ParseObject>("Company")
		query.whereEqualTo("recruiterId", context.getUserId())
		query.findInBackground { it, e ->
			val item = it?.firstOrNull()
			when {
				e != null -> callback.onFinish(null)
				else -> callback.onFinish(item)
			}
		}
	}
	
	fun get(recruiterId: String, callback: GetCompanyCallback) {
		val query = ParseQuery.getQuery<ParseObject>("Company")
		query.whereEqualTo("recruiterId", recruiterId)
		query.findInBackground { it, e ->
			val item = it?.firstOrNull()
			when {
				e != null -> callback.onFinish(null)
				else -> callback.onFinish(item)
			}
		}
	}
}

interface SaveParseObjectCallback {
	fun onFinish(isSuccessful: Boolean)
}

interface GetCompanyCallback {
	fun onFinish(company: ParseObject?)
}