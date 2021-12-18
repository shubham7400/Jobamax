package com.findajob.jobamax.dialog.multiChoice

import android.content.Context
import androidx.appcompat.app.AlertDialog

class MultiChoiceDialog(val context: Context) {

    fun show(
        title: String? = null,
        data: ArrayList<Choice>,
        onResultListener: (ArrayList<Choice>) -> Unit = { _ -> }
    ) {
        if (data.isEmpty()) {
            return
        }
        val dialog = AlertDialog.Builder(context)

        val itemsList = arrayListOf<String>()
        val checkedItemsList = arrayListOf<Boolean>()

        data.forEach {
            itemsList.add(it.name)
            checkedItemsList.add(it.checked)
        }

        val mapTarget = HashMap<Int, Boolean>()
        title?.let {
            dialog.setTitle(it)
        }
        dialog.setMultiChoiceItems(
            itemsList.toTypedArray(),
            checkedItemsList.toBooleanArray()
        ) { _, which, checked ->
            mapTarget[which] = checked
        }
        dialog.setPositiveButton(context.getString(android.R.string.ok)) { _, _ ->
            mapTarget.forEach {
                data[it.key].checked = it.value
            }
            onResultListener(data)
        }
        dialog.setNegativeButton(context.getString(android.R.string.cancel)) { _, _ ->
        }
        dialog.show()
    }
}