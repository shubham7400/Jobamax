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
import com.jobamax.appjobamax.databinding.DialogSimpleMessageBinding
import com.jobamax.appjobamax.databinding.DialogTitleMessageBinding

class TitleMessageDialog(var activity: Activity, val title: String, val message: String) : Dialog(activity, R.style.DialogSlideAnimFromCenter) {
    lateinit var binding: DialogTitleMessageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setUpDialogView()
        binding.tvTitle.text = title
        binding.tvMessage.text = message
        binding.btnOk.setOnClickListener { dismiss() }
    }

    private fun setUpDialogView() {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        binding = DialogTitleMessageBinding.inflate(LayoutInflater.from(activity), null, false)
        setContentView(binding.root)
        window?.setLayout(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT)
        window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    }
}