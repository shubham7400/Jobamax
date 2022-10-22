package com.jobamax.appjobamax.dialog

import android.app.Activity
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Window
import android.widget.RelativeLayout
import com.jobamax.appjobamax.R
import kotlinx.android.synthetic.main.dialog_basic_2.*

class BasicDialog2(var activity: Activity, val okButtonClicked: () -> Unit) : Dialog(activity) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViews()
        setUpObservers()
    }


    private fun initViews() {
        setUpDialogView()
    }

    private fun setUpObservers() {
        btn_ok.setOnClickListener {
            okButtonClicked()
        }
        btn_cancel.setOnClickListener {
           dismiss()
        }
    }

    private fun setUpDialogView() {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.dialog_basic_2)
        window?.setLayout(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT)
        window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    }
}