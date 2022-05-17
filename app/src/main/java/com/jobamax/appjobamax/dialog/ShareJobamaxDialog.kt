package com.jobamax.appjobamax.dialog

import android.app.Activity
import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Window
import android.widget.RelativeLayout
import com.jobamax.appjobamax.R
import com.jobamax.appjobamax.util.JOBAMAX_DOWNLOAD_URL
import kotlinx.android.synthetic.main.dialog_share_jobamax.*

class ShareJobamaxDialog(val activity: Activity) : Dialog(activity) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.dialog_share_jobamax)
        window?.setLayout(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT)
        window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        shareButton.setOnClickListener {
            val sharingIntent = Intent()
            sharingIntent.action = Intent.ACTION_SEND
            sharingIntent.type = "text/plain"
            sharingIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            sharingIntent.putExtra(Intent.EXTRA_TEXT, "Download Jobamax! it's a fast, simple and secured app to look for a job! Get it at $JOBAMAX_DOWNLOAD_URL")
            activity.startActivity(Intent.createChooser(sharingIntent,"it is title"))
            this@ShareJobamaxDialog.dismiss()
        }
    }
}