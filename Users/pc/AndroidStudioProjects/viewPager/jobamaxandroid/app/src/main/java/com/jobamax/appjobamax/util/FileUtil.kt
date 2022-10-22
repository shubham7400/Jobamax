package com.jobamax.appjobamax.util

import android.content.Context
import android.database.Cursor
import android.net.Uri
import android.provider.OpenableColumns
import com.jobamax.appjobamax.extensions.log


fun Context.getFileName(uri: Uri): String {
	val cursor: Cursor? = contentResolver.query(uri, null, null, null, null, null)
	cursor.use {
		if (it != null && it.moveToFirst()) {
			val displayName = it.getString(it.getColumnIndex(OpenableColumns.DISPLAY_NAME))
			log("Display Name: $displayName")
			return displayName
		}
	}
	return ""
}





