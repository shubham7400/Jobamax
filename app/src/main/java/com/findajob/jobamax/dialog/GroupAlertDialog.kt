package com.findajob.jobamax.dialog

import android.app.Activity
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.RelativeLayout
import android.widget.TextView
import com.findajob.jobamax.R

class GroupAlertDialog(
    val activity: Activity,
    val continueToGroup: (continued: Boolean) -> Unit
) : Dialog(activity) {

    lateinit var btnContinue: Button
    lateinit var tvSkip: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViews()
        setUpObserver()
    }

    private fun setUpObserver() {
        btnContinue.setOnClickListener {
            dismiss()
            continueToGroup(true)
        }

        tvSkip.setOnClickListener {
            dismiss()
            continueToGroup(false)
        }
    }


    private fun initViews() {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.dialog_group_alert)
        window?.setLayout(
            RelativeLayout.LayoutParams.MATCH_PARENT,
            RelativeLayout.LayoutParams.WRAP_CONTENT
        )
        window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        btnContinue = findViewById(R.id.btnContinue)
        tvSkip = findViewById(R.id.tvSkip)
    }
}