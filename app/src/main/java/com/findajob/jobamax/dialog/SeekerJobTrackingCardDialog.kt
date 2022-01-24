package com.findajob.jobamax.dialog

import android.app.Activity
import android.app.DatePickerDialog
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.RelativeLayout
import android.widget.TextView
import com.findajob.jobamax.R
 import com.findajob.jobamax.util.toast
import kotlinx.android.synthetic.main.dialog_add_tracking_job_phase.*
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList


class SeekerJobTrackingCardDialog(val activity: Activity, private val phases: ArrayList<String>, val onSaveClickListener: (String, String) -> Unit) : Dialog(activity) {
    var selectedPhase: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.dialog_add_tracking_job_phase)
        window?.setLayout(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT)
        window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        iv_dismiss.setOnClickListener {
            dismiss()
        }
        tv_select_date.setOnClickListener {
            onDateClicked(tv_select_date)
        }
        btn_save.setOnClickListener {
            if (isValid()){
                onSaveClickListener(selectedPhase!!, tv_select_date.text.toString())
                dismiss()
            }
        }
        setSpinner()
    }

    private fun isValid(): Boolean {
        var valid = false
        when {
            tv_select_date.text.isNullOrEmpty() -> {
                activity.toast("Please select the date.")
            }
            selectedPhase == null -> {
                activity.toast("Please select the phase.")
            }
            else -> {
                valid = true
            }
        }
        return  valid
    }

    private fun setSpinner() {
        sp_phase.adapter = CustomArrayAdapter(activity, R.layout.item_textview, phases)
        sp_phase.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(adapterView: AdapterView<*>?, p1: View?, position: Int, p3: Long) {
                if (position > 0)
                    selectedPhase = phases[position]
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {}
        }
    }

    fun onDateClicked(view: View ) {
        val today = Calendar.getInstance()
        val year = today.get(Calendar.YEAR)
        val month = today.get(Calendar.MONTH)
        val day = today.get(Calendar.DAY_OF_MONTH)
         DatePickerDialog(activity, { v, year, monthOfYear, dayOfMonth ->
            val calendar = Calendar.getInstance()
                calendar.set(Calendar.MONTH, monthOfYear)
            val monthName = SimpleDateFormat("MMM").format(calendar.time)
            (view as TextView).text =  "$monthName  $dayOfMonth, $year"
        }, year, month, day).show()
    }

}

class CustomArrayAdapter(private val activity: Activity, id: Int, private var list: ArrayList<String>) : ArrayAdapter<String>(activity, id, list) {
    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = super.getDropDownView(position, convertView, parent)
        val tv = view as TextView
        if (position == 0){
            tv.setTextColor(activity.resources.getColor(R.color.colorHypeLink))
            tv.textSize = 20f
        }
        return  view
    }

    override fun isEnabled(position: Int): Boolean {
        super.isEnabled(position)
        return position != 0
    }
}