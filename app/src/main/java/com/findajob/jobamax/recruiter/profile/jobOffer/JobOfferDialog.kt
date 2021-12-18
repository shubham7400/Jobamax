package com.findajob.jobamax.recruiter.profile.jobOffer

import android.app.Activity
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View.GONE
import android.view.Window
import android.widget.RelativeLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.findajob.jobamax.R
import com.findajob.jobamax.recruiter.profile.jobOffer.show.JobOfferAdapter
import com.findajob.jobamax.recruiter.profile.jobOffer.show.JobOfferFilterAdapter
import com.parse.ParseObject
import kotlinx.android.synthetic.main.dialog_job_offer.*


class JobOfferDialog(
    val activity: Activity,
    val jobOffers: List<ParseObject>,
    val navCreateJob: () -> Unit,
    val onOfferSelected: (offer: ParseObject) -> Unit
) : Dialog(activity) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.dialog_job_offer)
        window?.setLayout(
            RelativeLayout.LayoutParams.MATCH_PARENT,
            RelativeLayout.LayoutParams.WRAP_CONTENT
        )
        window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        rv_location_list.layoutManager = LinearLayoutManager(activity)

        val jobOfferAdapter = JobOfferAdapter {
            this@JobOfferDialog.dismiss()
            onOfferSelected(it)
        }

        jobOfferAdapter.submitList(jobOffers)

        rv_location_list.adapter = jobOfferAdapter

        addButton.setOnClickListener {
            this@JobOfferDialog.dismiss()
            navCreateJob()
        }
    }
}


class MessageFilterJobOfferDialog(
    val activity: Activity,
    val jobOffers: List<ParseObject>,
    val onOfferSelected: (offer: ParseObject) -> Unit
) : Dialog(activity) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.dialog_job_offer)
        addButton.visibility = GONE
        window?.setLayout(
            RelativeLayout.LayoutParams.MATCH_PARENT,
            RelativeLayout.LayoutParams.WRAP_CONTENT
        )
        window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        rv_location_list.layoutManager = LinearLayoutManager(activity)

        val jobOfferAdapter = JobOfferFilterAdapter {
            this@MessageFilterJobOfferDialog.dismiss()
            onOfferSelected(it)
        }
        jobOfferAdapter.submitList(jobOffers)

        rv_location_list.adapter = jobOfferAdapter
    }
}
