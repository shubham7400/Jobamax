package com.findajob.jobamax.dialog

import android.app.Activity
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.RelativeLayout
import android.widget.TextView
import com.findajob.jobamax.R
import org.jetbrains.anko.textColor

class ConfirmationDialog(
    var activity: Activity,
    var bodyText: String,
    var positiveButtonText: String,
    var negativeButtonText: String,
    private val isNegativeButtonUnfocused: Boolean,
    val onButtonClicked: (button: CallConfirmationButton) -> Unit
) : Dialog(activity) {


    private lateinit var tvNotificationBody: TextView
    private lateinit var btnPositive: Button
    private lateinit var btnNegative: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViews()
        setUpObservers()
    }


    private fun initViews() {
        setUpDialogView()

        tvNotificationBody = findViewById(R.id.tvNotificationBody)
        btnPositive = findViewById(R.id.btnPositive)
        btnNegative = findViewById(R.id.btnNegative)

        tvNotificationBody.text = bodyText
        btnPositive.text = positiveButtonText
        btnNegative.text = negativeButtonText

        if (isNegativeButtonUnfocused) {
            btnNegative.background = activity.getDrawable(R.drawable.bg_button_white)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                btnNegative.textColor = activity.getColor(R.color.black)
            }
        }

    }

    private fun setUpObservers() {
        btnNegative.setOnClickListener {
            dismiss()
            onButtonClicked(CallConfirmationButton.NEGATIVE)
        }

        btnPositive.setOnClickListener {
            dismiss()
            onButtonClicked(CallConfirmationButton.POSITIVE)
        }
    }

    private fun setUpDialogView() {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.dialog_confirmation)
        window?.setLayout(
            RelativeLayout.LayoutParams.MATCH_PARENT,
            RelativeLayout.LayoutParams.WRAP_CONTENT
        )
        window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    }

    enum class CallConfirmationButton {
        POSITIVE,
        NEGATIVE,
    }

}