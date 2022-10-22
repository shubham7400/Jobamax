package com.jobamax.appjobamax.dialog

import android.app.Activity
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Window
import android.widget.RelativeLayout
import com.jobamax.appjobamax.R
import com.jobamax.appjobamax.databinding.DialogYesNoSimpleBinding


class DialogYesNoSimple(var activity: Activity, val message: String, val onYesButtonClick: () -> Unit, val onNoButtonClick: () -> Unit) : Dialog(activity, R.style.DialogSlideAnim) {
    lateinit var binding: DialogYesNoSimpleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViews()
        setUpObservers()
        binding.tvMessage.text = message
    }


    private fun initViews() {
        setUpDialogView()
    }

    private fun setUpObservers() {
        binding.tvYesBtn.setOnClickListener {
            onYesButtonClick()
            dismiss()
        }
        binding.tvNoBtn.setOnClickListener {
            onNoButtonClick()
            dismiss()
        }
    }

    private fun setUpDialogView() {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        binding = DialogYesNoSimpleBinding.inflate(LayoutInflater.from(activity), null, false)
        setContentView(binding.root)
        window?.setLayout(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT)
        window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    }
}