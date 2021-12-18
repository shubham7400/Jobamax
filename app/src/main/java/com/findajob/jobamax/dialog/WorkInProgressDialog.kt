package com.findajob.jobamax.dialog

import android.app.Activity
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Window
import android.widget.RelativeLayout
import com.findajob.jobamax.R
import kotlinx.android.synthetic.main.dialog_work_in_progress.*


class WorkInProgressDialog(val activity: Activity) : Dialog(activity) {
	
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		requestWindowFeature(Window.FEATURE_NO_TITLE)
		setContentView(R.layout.dialog_work_in_progress)
		window?.setLayout(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT)
		window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
		
		okButton.setOnClickListener {
			this@WorkInProgressDialog.dismiss()
		}
	}
}
