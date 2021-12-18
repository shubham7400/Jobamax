package com.findajob.jobamax.dialog

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Window
import android.widget.RelativeLayout
import com.findajob.jobamax.R
import com.findajob.jobamax.recruiter.home.RecruiterHomeActivity
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.dialog_confirm.*



class ConfirmJobDeletionDialog(
    val activity: RecruiterHomeActivity,
    val job: String,
    val deleteJob: () -> Unit
) : BottomSheetDialog(activity, R.style.SheetDialog) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.dialog_confirm)
        window?.setLayout(
            RelativeLayout.LayoutParams.MATCH_PARENT,
            RelativeLayout.LayoutParams.WRAP_CONTENT
        )
        window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        label.text = "Do you confirm you found your ideal candidate for $job?"
        deleteButton.setOnClickListener {
            deleteJob()
            this@ConfirmJobDeletionDialog.dismiss()
        }
        cancelButton.setOnClickListener {
            this@ConfirmJobDeletionDialog.dismiss()
        }
    }
}
