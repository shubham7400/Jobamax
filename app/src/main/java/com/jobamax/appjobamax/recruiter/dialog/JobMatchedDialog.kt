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
import com.jobamax.appjobamax.databinding.DialogJobMatchedBinding
import com.jobamax.appjobamax.util.loadImageFromUrl

class JobMatchedDialog(var activity: Activity, private val jobSeekerUrl: String, private val companyLogoUrl: String, val onSendMessageClick: () -> Unit) : Dialog(activity, R.style.DialogSlideAnimFromCenter) {
    lateinit var binding: DialogJobMatchedBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViews()
        setUpObservers()
    }


    private fun initViews() {
        setUpDialogView()
        loadImageFromUrl(binding.ivSeeker, jobSeekerUrl, R.drawable.default_user_img)
        loadImageFromUrl(binding.sivCompany, companyLogoUrl, R.drawable.default_user_img)
    }

    private fun setUpObservers() {
        binding.btnSendMgs.setOnClickListener {
            onSendMessageClick()
            dismiss()
        }
        binding.btnContinue.setOnClickListener {
            dismiss()
        }
    }

    private fun setUpDialogView() {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        binding = DialogJobMatchedBinding.inflate(LayoutInflater.from(activity), null, false)
        setContentView(binding.root)
        window?.setLayout(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT)
        window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    }
}