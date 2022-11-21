package com.jobamax.appjobamax.dialog

import android.app.Activity
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Window
import android.widget.RelativeLayout
import com.jobamax.appjobamax.R
import kotlinx.android.synthetic.main.dialog_change_password.*

class ChangePasswordDialog(var activity: Activity, val message: String, private val emailId: String) : Dialog(activity) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViews()
        setUpObservers()
        this.tv_message.text = message
        this.tv_email.text = emailId
    }

    private fun initViews() {
        setUpDialogView()
    }

    private fun setUpObservers() {
        btn_ok.setOnClickListener {
            dismiss()
        }
    }

    private fun setUpDialogView() {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.dialog_change_password)
        window?.setLayout(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT)
        window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    }
}