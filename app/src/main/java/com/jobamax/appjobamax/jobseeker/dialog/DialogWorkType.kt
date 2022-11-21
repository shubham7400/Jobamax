package com.jobamax.appjobamax.jobseeker.dialog

import android.app.Activity
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Window
import android.widget.RelativeLayout
import com.jobamax.appjobamax.R
import com.jobamax.appjobamax.databinding.DialogWorkTypeBinding
import com.jobamax.appjobamax.enums.WorkType
import com.jobamax.appjobamax.jobseeker.build_profile.BuildProfileActivity
import com.jobamax.appjobamax.jobseeker.profile.SeekerCreateCvActivity
import com.jobamax.appjobamax.jobseeker.search.ManualAndPersonalizeActivity

class DialogWorkType(var activity: Activity)  : Dialog(activity, R.style.DialogSlideAnim) {
    lateinit var binding: DialogWorkTypeBinding
    var onWorkClick: (ArrayList<String>) -> Unit = {}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViews()
        setUpObservers()
    }

    private fun initViews() {
        setUpDialogView()
        val workTypes: List<String>? = try {
            (activity as BuildProfileActivity).viewModel.jobSeeker.interestedIn
        }catch (e: Exception){
            try {
                (activity as SeekerCreateCvActivity).viewModel.jobSeeker.interestedIn
            }catch (e: Exception){
                (activity as ManualAndPersonalizeActivity).viewModel.jobSeeker.interestedIn
            }
        }
        workTypes?.forEach {
            if (it == WorkType.STAGE.value){
                binding.cbInternship.isChecked = true
            }
            if (it == WorkType.ALTERNANCE.value){
                binding.cbAlternation.isChecked = true
            }
            if (it == WorkType.CDI.value){
                binding.cbCdi.isChecked = true
            }
            if (it == WorkType.CDD.value){
                binding.cbCdd.isChecked = true
            }
        }
    }

    private fun setUpObservers() {
        binding.tvCancel.setOnClickListener { dismiss() }
    }

    override fun dismiss() {
        val workTypes = ArrayList<String>()
        if (binding.cbInternship.isChecked) {
            workTypes.add(WorkType.STAGE.value)
        }
        if (binding.cbAlternation.isChecked) {
            workTypes.add(WorkType.ALTERNANCE.value)
        }
        if (binding.cbCdi.isChecked) {
            workTypes.add(WorkType.CDI.value)
        }
        if (binding.cbCdd.isChecked) {
            workTypes.add(WorkType.CDD.value)
        }
        onWorkClick(workTypes)
        super.dismiss()
    }


    private fun setUpDialogView() {
        requestWindowFeature(Window.FEATURE_NO_TITLE)

        binding = DialogWorkTypeBinding.inflate(LayoutInflater.from(activity), null, false)
        setContentView(binding.root)
        window?.setLayout(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT)
        window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    }
}