package com.findajob.jobamax.util

import android.content.Context
import android.database.Cursor
import android.net.Uri
import android.os.Environment
import android.os.ParcelFileDescriptor
import android.provider.OpenableColumns
import java.io.File
import java.io.FileOutputStream


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

fun Context.getFile(uri: Uri): File {
	val dir = File("${getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS)}/backups")
	if (!dir.exists())
		dir.mkdirs()
	val file = File("$dir/tempFile")
	writeFileContent(uri, file)
	return file
}


fun Context.writeFileContent(uri: Uri, file: File) {
	val pfd: ParcelFileDescriptor = contentResolver.openFileDescriptor(uri, "w")!!
	val fileOutputStream = FileOutputStream(pfd.fileDescriptor)
	fileOutputStream.write(file.readBytes())
	fileOutputStream.close()
	pfd.close()
}
