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
import com.jobamax.appjobamax.databinding.DialogAddLinkBinding
import com.jobamax.appjobamax.extensions.toast

class DialogAddLink(var activity: Activity) : Dialog(activity, R.style.DialogSlideAnim) {
    lateinit var binding: DialogAddLinkBinding

    var onAddLinkClick: (String) -> Unit = {}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViews()
        setUpObservers()
    }


    private fun initViews() {
        setUpDialogView()
    }

    private fun setUpObservers() {
        binding.tvAddLink.setOnClickListener {
            if (binding.etLink.text.isNullOrEmpty()) {
                activity.toast("please enter link.")
            }else{
                onAddLinkClick(binding.etLink.text.toString())
                dismiss()
            }
        }
        binding.tvDismiss.setOnClickListener { dismiss() }
    }

    private fun setUpDialogView() {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        binding = DialogAddLinkBinding.inflate(LayoutInflater.from(activity), null, false)
        setContentView(binding.root)
        window?.setLayout(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT)
        window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    }
}