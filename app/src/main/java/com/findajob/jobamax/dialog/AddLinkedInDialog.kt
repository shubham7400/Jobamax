package com.findajob.jobamax.dialog

import android.app.Activity
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Window
import android.widget.*
import com.findajob.jobamax.R
import kotlinx.android.synthetic.main.dialog_add_linkedin.*

class AddLinkedInDialog(
    var activity: Activity,
    val onButtonClicked: (button: SubmitButton, username: String) -> Unit
) : Dialog(activity){


    private lateinit var tvBody: TextView
    private lateinit var btnPositive: Button
    private lateinit var btnNegative: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViews()
        setUpObservers()
    }

    private fun initViews() {
        setUpDialogView()
        tvBody = findViewById(R.id.tvBody)
        btnPositive = findViewById(R.id.btnPositive)
        btnNegative = findViewById(R.id.btnNegative)
    }

    private fun setUpObservers() {
        btnNegative.setOnClickListener {
            onButtonClicked(SubmitButton.NEGATIVE, "")
            dismiss()
        }

        btnPositive.setOnClickListener {
            onButtonClicked(SubmitButton.POSITIVE, et_linkedin.text.toString())
            dismiss()
        }
    }

    private fun setUpDialogView() {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.dialog_add_linkedin)
        window?.setLayout(
            RelativeLayout.LayoutParams.MATCH_PARENT,
            RelativeLayout.LayoutParams.WRAP_CONTENT
        )
        window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    }

    enum class SubmitButton {
        POSITIVE,
        NEGATIVE,
    }
}
