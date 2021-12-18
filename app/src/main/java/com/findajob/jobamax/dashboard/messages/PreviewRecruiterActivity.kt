package com.findajob.jobamax.dashboard.messages

import android.content.Context
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.findajob.jobamax.R
import com.findajob.jobamax.base.BaseActivityMain
import com.findajob.jobamax.base.BaseViewModel
import com.findajob.jobamax.databinding.ItemRecruiterJobOffersBinding
import com.findajob.jobamax.jobseeker.track.JobSeekerTrackAdapter
import com.findajob.jobamax.model.Recruiter
import com.findajob.jobamax.repo.GetAllJobOfferCallback
import com.parse.ParseObject
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.item_recruiter_job_offers.*

@AndroidEntryPoint
class PreviewRecruiterActivity : BaseActivityMain<ItemRecruiterJobOffersBinding>() {

    private val viewModel: PreviewRecruiterViewModel by viewModels()

    override val layoutRes: Int
        get() = R.layout.item_recruiter_job_offers

    lateinit var recruiter: Recruiter
    lateinit var context: Context

    lateinit var jobSeekerTrackAdapter: JobSeekerTrackAdapter

    override fun getViewModel(): BaseViewModel = viewModel

    override fun onCreated(instance: Bundle?) {

        initViews()
        checkExtras()

    }

    private fun initViews() {
        jobSeekerTrackAdapter = JobSeekerTrackAdapter("")
        offerRecycler.layoutManager = LinearLayoutManager(this)
        offerRecycler.isNestedScrollingEnabled = false
        offerRecycler.adapter = jobSeekerTrackAdapter

    }

    private fun checkExtras() {
        intent.extras?.apply {
            if (containsKey(EXTRA_RECRUITER_ID)) {

                with(getString(EXTRA_RECRUITER_ID, "")) {
                    val recruiterObject = viewModel.getRecruiter(this)
                    recruiter = Recruiter(recruiterObject.first())
                    viewModel.loadJobOffers(recruiter.recruiterId, object : GetAllJobOfferCallback {
                        override fun onFinish(parseObjects: List<ParseObject>) {
                            jobSeekerTrackAdapter.submitJobOffers(parseObjects)
                        }
                    })
                }
            } else {
                finish()
            }
        }
    }

    companion object {
        const val EXTRA_RECRUITER_ID = "user_id"
    }
}