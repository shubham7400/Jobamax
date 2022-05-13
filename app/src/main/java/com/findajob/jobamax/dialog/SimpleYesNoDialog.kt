package com.findajob.jobamax.dialog

import android.app.Activity
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.RelativeLayout
import com.findajob.jobamax.R
import kotlinx.android.synthetic.main.dialog_basic.*
import kotlinx.android.synthetic.main.dialog_yes_no.*


class SimpleYesNoDialog(var activity: Activity, val message: String, val onYesButtonClick: () -> Unit, val onNoButtonClick: () -> Unit) : Dialog(activity) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViews()
        setUpObservers()
    }


    private fun initViews() {
        setUpDialogView()
    }

    private fun setUpObservers() {
        tv_yes_btn.setOnClickListener {
            onYesButtonClick()
            dismiss()
        }
        tv_no_btn.setOnClickListener {
            onNoButtonClick()
            dismiss()
        }
    }

    private fun setUpDialogView() {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.dialog_simple_yes_no)
        window?.setLayout(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT)
        window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    }
}