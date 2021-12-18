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
import kotlinx.android.synthetic.main.dialog_new_confirmation_dialog.*

class NewConfirmationDialog(
    val activity: Activity,
    val description: String,
    val onButtonClicked: (continued: Boolean) -> Unit,
) : Dialog(activity) {

    private lateinit var btnYes: Button
    private lateinit var tvNo: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViews()
        setUpObserver()
    }


    private fun initViews() {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.dialog_new_confirmation_dialog)
        window?.setLayout(
            RelativeLayout.LayoutParams.MATCH_PARENT,
            RelativeLayout.LayoutParams.WRAP_CONTENT
        )
        window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        btnYes = findViewById(R.id.btnYes)
        tvNo = findViewById(R.id.tvNo)

        tvConfirmationMessage.text = description

    }

    private fun setUpObserver() {
        btnYes.setOnClickListener {
            dismiss()
            onButtonClicked(true)
        }
        tvNo.setOnClickListener {
            dismiss()
            onButtonClicked(false)
        }
    }
}