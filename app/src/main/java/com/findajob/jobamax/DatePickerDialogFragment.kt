package com.findajob.jobamax

import android.app.DatePickerDialog
import android.app.Dialog
import android.os.Bundle
import android.widget.DatePicker
import androidx.fragment.app.DialogFragment
import java.util.*


class DatePickerDialogFragment : DialogFragment(), DatePickerDialog.OnDateSetListener {
    var selectedDate: (date: Date) -> Unit = {}
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        return DatePickerDialog(requireActivity(), this, year, month, day)
    }

    override fun onDateSet(view: DatePicker, year: Int, month: Int, day: Int) {
        val c = Calendar.getInstance()
        c.set(Calendar.DAY_OF_MONTH,day)
        c.set(Calendar.MONTH,month)
        c.set(Calendar.YEAR,year)
        selectedDate(c.time)
    }
}