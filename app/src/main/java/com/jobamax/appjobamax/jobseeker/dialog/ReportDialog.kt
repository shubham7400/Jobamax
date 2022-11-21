package com.jobamax.appjobamax.jobseeker.dialog

import android.app.Activity
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.RelativeLayout
import android.widget.TextView
import com.jobamax.appjobamax.R
import com.jobamax.appjobamax.databinding.DialogReportBinding
import com.jobamax.appjobamax.extensions.toast
import com.jobamax.appjobamax.util.getShader
import com.jobamax.appjobamax.util.reportReason

class ReportDialog(var activity: Activity, val onSubmitClick: (String) -> Unit) : Dialog(activity, R.style.DialogSlideAnim) {
    lateinit var binding: DialogReportBinding

    var selectedReason: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViews()
        setUpObservers()
    }

    private fun initViews() {
        setUpDialogView()

        validateReason()

        val spinnerAdapter = ReportReasonSpinnerAdapter(activity, R.layout.item_textview, reportReason)
        binding.spReportReason.adapter = spinnerAdapter
        spinnerAdapter.onTitleClick = {
            binding.spReportReason.onDetachedFromWindow()
        }
        binding.spReportReason.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, view: View?, position: Int, p3: Long) {
                if (position != 0){
                    selectedReason = reportReason[position]
                    validateReason()
                }
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {}
        }
    }

    private fun validateReason() {
        if (selectedReason.isNullOrEmpty() ) {
            binding.btnSubmit.isEnabled = false
            binding.btnSubmit.background = activity.resources.getDrawable(R.drawable.rounded_grey_box_50, null)
            binding.btnSubmit.setTextColor(activity.resources.getColor(R.color.navi_blue, null))
        } else {
            binding.btnSubmit.isEnabled = true
            binding.btnSubmit.background = activity.resources.getDrawable(R.drawable.rounded_bottom_purple_top_blue_50, null)
            binding.btnSubmit.setTextColor(activity.resources.getColor(R.color.white, null))
        }
    }

    private fun setUpObservers() {
        binding.ivCancel.setOnClickListener { dismiss() }
        binding.btnSubmit.setOnClickListener {
            if (selectedReason != null) {
                onSubmitClick(selectedReason!!)
                dismiss()
            }else{
                activity.toast("Sélectionner la raison")
            }
        }
    }

    private fun setUpDialogView() {
        requestWindowFeature(Window.FEATURE_NO_TITLE)

        binding = DialogReportBinding.inflate(LayoutInflater.from(activity), null, false)
        setContentView(binding.root)
        window?.setLayout(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT)
        window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    }
}

class ReportReasonSpinnerAdapter(private val activity: Activity, id: Int, list: ArrayList<String>) : ArrayAdapter<String>(activity, id, list) {
    var onTitleClick: () -> Unit = {}
    var item = ""
    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = super.getDropDownView(position, convertView, parent)
        val tv = view as TextView
        if (position == 0){
            tv.paint.shader = activity.getShader(tv)
            tv.textSize = 20f
            tv.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.ic_arrow_up_gradient,0)
            tv.setOnClickListener { onTitleClick() }
        }else{
            tv.setCompoundDrawablesWithIntrinsicBounds(0,0,0,0)
            if (item == tv.text.toString()){
                tv.setBackgroundColor( activity.resources.getColor(R.color.greyishWhite,null))
            }
        }
        return  view
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = super.getDropDownView(position, convertView, parent)
        val tv = view as TextView
        if (position != 0){
            item = tv.text.toString()
        }
        return view
    }


    override fun isEnabled(position: Int): Boolean {
        super.isEnabled(position)
        return position != 0
    }
}

