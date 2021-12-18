package com.findajob.jobamax.dialog

import android.app.Activity
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Window
import android.widget.RelativeLayout
import com.findajob.jobamax.databinding.DialogJobamaxAnalyticsBinding


class JobamaxAnalyticsDialog(val activity: Activity, private val onContact: () -> Any) : Dialog(activity) {
    lateinit var binding: DialogJobamaxAnalyticsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        binding = DialogJobamaxAnalyticsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        window?.setLayout(
            RelativeLayout.LayoutParams.WRAP_CONTENT,
            RelativeLayout.LayoutParams.WRAP_CONTENT
        )
        window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        initUi()

    }

    private fun initUi() {
        initButton()
    }

    private fun initButton() {
        binding.apply {
            btnContact.setOnClickListener {
                onContact()
                dismiss()
            }
            tvSkip.setOnClickListener { dismiss() }
        }
    }
}
