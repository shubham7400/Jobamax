package com.jobamax.appjobamax.dialog

import android.app.Activity
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.Window
import android.widget.RelativeLayout
import com.jobamax.appjobamax.R
import com.jobamax.appjobamax.databinding.DialogAddOrTakeVideoBinding

class AddOrTakeVideoDialog(var activity: Activity, val onCamera: () -> Unit, val onGallery: () -> Unit) : Dialog(activity, R.style.DialogSlideAnim) {
    lateinit var binding: DialogAddOrTakeVideoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window?.attributes?.gravity = Gravity.BOTTOM

        setUpDialogView()
        binding.tvGallery.setOnClickListener {
            onGallery()
            dismiss()
        }
        binding.tvCamera.setOnClickListener {
            onCamera()
            dismiss()
        }
    }

    private fun setUpDialogView() {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        binding = DialogAddOrTakeVideoBinding.inflate(LayoutInflater.from(activity), null, false)
        setContentView(binding.root)
        window?.setLayout(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT)
        window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    }
}