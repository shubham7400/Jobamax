package com.findajob.jobamax.dialog

import android.app.Activity
import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Window
import android.widget.RelativeLayout
import com.findajob.jobamax.R
import kotlinx.android.synthetic.main.dialog_subscription_plan.*


class SubscriptionDialog(val activity: Activity, val intent: Intent) : Dialog(activity) {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		requestWindowFeature(Window.FEATURE_NO_TITLE)
		setContentView(R.layout.dialog_subscription_plan)
		window?.setLayout(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT)
		window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        val title = intent.getStringExtra("title")
        val description = intent.getCharSequenceExtra("description")
		val price = intent.getCharSequenceExtra("price")

		titleText.text = title
		descriptionText.text = description
		priceText.text = price

		okButton.setOnClickListener {
			this@SubscriptionDialog.dismiss()
		}
	}
}
