package com.jobamax.appjobamax.dialog

import android.app.Activity
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.RelativeLayout
import com.jobamax.appjobamax.R
import kotlinx.android.synthetic.main.dialog_basic.*
import kotlinx.android.synthetic.main.dialog_basic.primaryButton
import kotlinx.android.synthetic.main.dialog_basic.tv_message
import kotlinx.android.synthetic.main.dialog_message.*


class MessageDialog(var activity: Activity, val message: String, private val showLogo: Boolean = true, val okButtonClicked: () -> Unit) : Dialog(activity) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViews()
        setUpObservers()
        tv_message.text = message
        if (!showLogo){
            iv_logo.visibility = View.GONE
        }
    }


    private fun initViews() {
        setUpDialogView()
    }

    private fun setUpObservers() {
        primaryButton.setOnClickListener {
            okButtonClicked()
            dismiss()
        }
    }

    private fun setUpDialogView() {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.dialog_message)
        window?.setLayout(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT)
        window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    }
}