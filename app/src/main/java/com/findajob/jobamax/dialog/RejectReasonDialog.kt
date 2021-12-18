package com.findajob.jobamax.dialog

import android.app.Activity
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Window
import android.widget.RelativeLayout
import com.findajob.jobamax.R
import com.findajob.jobamax.util.hideKeyboard
import com.parse.ParseObject
import kotlinx.android.synthetic.main.dialog_reject_reason.*
import kotlinx.android.synthetic.main.item_job_seeker_track_offer.*

class RejectReasonDialog(val activity: Activity, val applicant: ParseObject, val addRejectReason: (reason: String, applicant: ParseObject) -> Unit) : Dialog(activity) {
	
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		requestWindowFeature(Window.FEATURE_NO_TITLE)
		setContentView(R.layout.dialog_reject_reason)
		window?.setLayout(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT)
		window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
		
		doneButton.setOnClickListener {
			if (reasonField.text.isEmpty()) {
				reasonField.error = "Enter Reason"
			} else {
				addRejectReason(reasonField.text.toString(), applicant)
				activity.hideKeyboard(reasonField)
				this@RejectReasonDialog.dismiss()
			}
		}
		
		cancelButton.setOnClickListener {
			this@RejectReasonDialog.dismiss()
		}
	}
}