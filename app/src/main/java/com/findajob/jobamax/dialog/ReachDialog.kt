package com.findajob.jobamax.dialog

import android.app.Activity
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Window
import android.widget.*
import com.findajob.jobamax.R

class ReachDialog(var activity: Activity, var companyName: String, val onButtonClicked: (button: SubmitButton) -> Unit) : Dialog(activity){


    private lateinit var tvNotificationBody: TextView
    private lateinit var tvBody: TextView
    private lateinit var btnPositive: Button
    private lateinit var btnNegative: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViews()
        setUpObservers()
        tvBody.text = "You and $companyName can now discuss with each other."
    }

    private fun initViews() {
        setUpDialogView()
        tvNotificationBody = findViewById(R.id.tvNotificationBody)
        tvBody = findViewById(R.id.tvBody)
        btnPositive = findViewById(R.id.btnPositive)
        btnNegative = findViewById(R.id.btnNegative)
    }

    private fun setUpObservers() {
        btnNegative.setOnClickListener {
            onButtonClicked(SubmitButton.NEGATIVE)
            dismiss()
        }

        btnPositive.setOnClickListener {
            onButtonClicked(SubmitButton.POSITIVE)
            dismiss()
        }
    }

    private fun setUpDialogView() {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.dialog_reach)
        window?.setLayout(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT)
        window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    }

    enum class SubmitButton {
        POSITIVE,
        NEGATIVE,
    }
}
