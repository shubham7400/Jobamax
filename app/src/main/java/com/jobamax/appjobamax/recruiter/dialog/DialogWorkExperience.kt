package com.jobamax.appjobamax.recruiter.dialog

import android.app.Activity
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Window
import android.widget.RelativeLayout
import com.jobamax.appjobamax.R
import com.jobamax.appjobamax.databinding.DialogWorkExperienceBinding
import com.jobamax.appjobamax.enums.WorkType
import com.jobamax.appjobamax.util.ONE_OR_WTO
import com.jobamax.appjobamax.util.TWO_OR_THREE
import com.jobamax.appjobamax.util.UNDER_ONE
import com.jobamax.appjobamax.util.experienceMap

class DialogWorkExperience(var activity: Activity, var selectedWorkExperience: String)  : Dialog(activity, R.style.DialogSlideAnim) {
    lateinit var binding: DialogWorkExperienceBinding
    var onExperienceClick: (String) -> Unit = {}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViews()
        setUpObservers()
    }

    private fun initViews() {
        setUpDialogView()

        if (UNDER_ONE == selectedWorkExperience){
            binding.cbUnderOne.isChecked = true
        }
        if (ONE_OR_WTO == selectedWorkExperience){
            binding.cbOneOrTwo.isChecked = true
        }
        if (TWO_OR_THREE == selectedWorkExperience){
            binding.cbTwoOrTree.isChecked = true
        }
    }

    private fun setUpObservers() {
        binding.tvCancel.setOnClickListener { dismiss() }
        binding.cbUnderOne.setOnClickListener {
            if (binding.cbUnderOne.isChecked){
                onExperienceClick(UNDER_ONE)
            }else{
                onExperienceClick("")
            }
            binding.cbOneOrTwo.isChecked = false
            binding.cbTwoOrTree.isChecked = false
        }
        binding.cbOneOrTwo.setOnClickListener {
            if (binding.cbOneOrTwo.isChecked){
                onExperienceClick(ONE_OR_WTO)
            }else{
                onExperienceClick("")
            }
            binding.cbUnderOne.isChecked = false
            binding.cbTwoOrTree.isChecked = false
        }
        binding.cbTwoOrTree.setOnClickListener {
            if (binding.cbTwoOrTree.isChecked){
                onExperienceClick(TWO_OR_THREE)
            }else{
                onExperienceClick("")
            }
            binding.cbOneOrTwo.isChecked = false
            binding.cbUnderOne.isChecked = false
        }
    }



    private fun setUpDialogView() {
        requestWindowFeature(Window.FEATURE_NO_TITLE)

        binding = DialogWorkExperienceBinding.inflate(LayoutInflater.from(activity), null, false)
        setContentView(binding.root)
        window?.setLayout(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT)
        window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    }
}