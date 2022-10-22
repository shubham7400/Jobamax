package com.jobamax.appjobamax.recruiter.dialog

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
import com.jobamax.appjobamax.databinding.DialogQualifyingStepBinding
import com.jobamax.appjobamax.extensions.toast
import com.jobamax.appjobamax.recruiter.message.QualifyingStepSpinnerAdapter
import com.jobamax.appjobamax.recruiter.model.QualifyingStep
import com.jobamax.appjobamax.util.getShader

class QualifyingStepDialog(
    var activity: Activity,
    val qualifyingSteps: ArrayList<QualifyingStep>,
    val okButtonClicked: (QualifyingStep) -> Unit
) : Dialog(activity, R.style.DialogSlideAnim) {
    lateinit var binding: DialogQualifyingStepBinding

    var selectedQualifyingStep: QualifyingStep? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViews()
        setUpObservers()
    }


    private fun initViews() {
        setUpDialogView()
        val spinnerAdapter = QualifyingStepSpinnerAdapterV2(activity, R.layout.item_textview, qualifyingSteps)
        spinnerAdapter.item = qualifyingSteps[1].title
        binding.spQualifyingStep.adapter = spinnerAdapter
        binding.spQualifyingStep.setSelection(1)
        binding.spQualifyingStep.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, view: View?, position: Int, p3: Long) {
                if (qualifyingSteps[position].key.isNotEmpty()){
                    selectedQualifyingStep = qualifyingSteps[position]
                }
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {}
        }
        spinnerAdapter.onTitleClick = {
            binding.spQualifyingStep.onDetachedFromWindow()
        }
    }

    private fun setUpObservers() {
        binding.btnSort.setOnClickListener {
            if (selectedQualifyingStep == null) {
                activity.toast("Please select qualifying step")
            }else{
                okButtonClicked(selectedQualifyingStep!!)
                dismiss()
            }
        }
        binding.ivClose.setOnClickListener { dismiss() }
    }

    private fun setUpDialogView() {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        binding = DialogQualifyingStepBinding.inflate(LayoutInflater.from(activity), null, false)
        setContentView(binding.root)
        window?.setLayout(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT)
        window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    }
}

class QualifyingStepSpinnerAdapterV2(private val activity: Activity, id: Int, val list: ArrayList<QualifyingStep>) : ArrayAdapter<QualifyingStep>(activity, id, list) {
    var onTitleClick: () -> Unit = {}
    var item = ""
    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = super.getDropDownView(position, convertView, parent)
        val tv = view as TextView
        tv.text = list[position].title
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
        tv.text = list[position].title
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