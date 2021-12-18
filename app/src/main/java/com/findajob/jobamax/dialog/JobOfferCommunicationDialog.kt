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

class JobOfferCommunicationDialog(
    private val activity: Activity,
    private val notificationHeader: String,
    private val notificationBody: String,
    private val focusButtonText: String,
    private val nonfocusButtonText: String,
    private val onFocusButtonClicked: () -> Unit,
    private val onNonFocusButtonClicked: () -> Unit,
) : Dialog(activity) {

    lateinit var tvNotificationHeader: TextView
    lateinit var tvNotificationBody: TextView
    lateinit var btnContact: Button
    lateinit var tvSkipButton: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViews()
        initFields()
        setUpObservers()
    }

    private fun initFields() {
        tvNotificationHeader.text = notificationHeader
        tvNotificationBody.text = notificationBody

        btnContact.text = focusButtonText
        tvSkipButton.text = nonfocusButtonText
    }

    private fun setUpObservers() {
        btnContact.setOnClickListener {
            dismiss()
            onFocusButtonClicked()
        }

        tvSkipButton.setOnClickListener {
            dismiss()
            onNonFocusButtonClicked()
        }
    }

    private fun initViews() {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.dialog_job_offer_communication)
        window?.setLayout(
            RelativeLayout.LayoutParams.MATCH_PARENT,
            RelativeLayout.LayoutParams.WRAP_CONTENT
        )
        window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        tvNotificationHeader = findViewById(R.id.tv_notification_header)
        tvNotificationBody = findViewById(R.id.tv_notification_body)
        tvSkipButton = findViewById(R.id.tv_skip_button)

        btnContact = findViewById(R.id.btn_contact)

    }

}