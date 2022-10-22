package com.jobamax.appjobamax.recruiter.dialog

import android.app.Activity
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.Window
import android.widget.AdapterView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.core.view.updatePadding
import com.jobamax.appjobamax.R
import com.jobamax.appjobamax.databinding.DialogFilterJobRoleWiseBinding
import com.jobamax.appjobamax.extensions.log
import com.jobamax.appjobamax.extensions.toast
import com.jobamax.appjobamax.recruiter.home.JobTitleFilterSpinnerAdapter
import com.jobamax.appjobamax.recruiter.model.JobTitleFilter
import com.jobamax.appjobamax.recruiter.model.SourcingCriteria

class FilterJobRoleWiseDialog(
    var activity: Activity,
    private val _jobTitleFilterList: List<JobTitleFilter>?,
    private val jobTitleFilter: JobTitleFilter?,
    val okButtonClicked: ( JobTitleFilter?) -> Unit
    ) : Dialog(activity, R.style.DialogSlideAnim) {
    lateinit var binding: DialogFilterJobRoleWiseBinding

    private val jobTitleFilterList = arrayListOf<JobTitleFilter>()
    var selectedJobTitleFilter: JobTitleFilter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        jobTitleFilterList.clear()
        jobTitleFilterList.add(JobTitleFilter("","Votre offre d'emploi: :"))
        _jobTitleFilterList?.forEach { jobTitleFilterList.add(it) }

        selectedJobTitleFilter = jobTitleFilter

        initViews()
    }


    private fun initViews() {
        setUpDialogView()
        setClickListeners()
        setJobTitleFilterSpinnerAdapter()
    }

    private fun setJobTitleFilterSpinnerAdapter() {
        val spinnerAdapter = JobTitleFilterSpinnerAdapter(activity, R.layout.item_textview, jobTitleFilterList)
        binding.spJobTitle.adapter = spinnerAdapter
        binding.spJobTitle.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(p0: AdapterView<*>?, view: View?, position: Int, p3: Long) {
                    if (jobTitleFilterList[position].jobOfferId.isNotEmpty()) {
                        selectedJobTitleFilter = jobTitleFilterList[position]
                    }
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {}
            }
        spinnerAdapter.onTitleClick = {
            binding.spJobTitle.onDetachedFromWindow()
        }
        jobTitleFilter?.let {
            val index = jobTitleFilterList.indexOf(jobTitleFilter)
            if (index > 0){
                binding.spJobTitle.setSelection(index)
            }
        }
    }



    private fun setClickListeners() {
        binding.btnSort.setOnClickListener {
            okButtonClicked( selectedJobTitleFilter)
            dismiss()
        }
        binding.ivClose.setOnClickListener { dismiss() }
    }

    private fun setUpDialogView() {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        binding = DialogFilterJobRoleWiseBinding.inflate(LayoutInflater.from(activity), null, false)
        setContentView(binding.root)
        window?.setLayout(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT)
        window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    }



}