package com.jobamax.appjobamax.recruiter.dialog

import android.app.Activity
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Window
import android.widget.RelativeLayout
import com.jobamax.appjobamax.R
import com.jobamax.appjobamax.databinding.DialogSeePostJobOfferInfoBinding


class DialogSeePostJobOfferInfo(var activity: Activity ) : Dialog(activity, R.style.DialogSlideAnim) {
    lateinit var binding: DialogSeePostJobOfferInfoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setUpDialogView()
    }


    private fun setUpDialogView() {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        binding = DialogSeePostJobOfferInfoBinding.inflate(LayoutInflater.from(activity), null, false)
        setContentView(binding.root)
        window?.setLayout(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT)
        window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    }



}