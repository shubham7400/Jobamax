package com.jobamax.appjobamax.dialog

import android.app.Activity
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Window
import android.widget.RelativeLayout
import com.jobamax.appjobamax.R
import kotlinx.android.synthetic.main.dialog_basic.*

class BasicDialog(var activity: Activity, val message: String, val listenClick: Boolean = false, val okButtonClicked: () -> Unit) : Dialog(activity) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViews()
        setUpObservers()
        tv_message.text = message
    }


    private fun initViews() {
        setUpDialogView()
    }

    private fun setUpObservers() {
        primaryButton.setOnClickListener {
            if(listenClick){
                okButtonClicked()
                dismiss()
            }else{
                dismiss()
            }
        }
    }

    private fun setUpDialogView() {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.dialog_basic)
        window?.setLayout(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT)
        window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    }
}