package com.findajob.jobamax.jobseeker.track

import android.os.Bundle
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.findajob.jobamax.R
import com.findajob.jobamax.base.BaseAndroidViewModel
import com.findajob.jobamax.base.BaseFragmentMain
import com.findajob.jobamax.databinding.FragmentJobSeekerTrackBinding
import com.findajob.jobamax.extensions.observe
import com.findajob.jobamax.jobseeker.home.JobSeekerHomeViewModel
import com.findajob.jobamax.model.RejectReason
import com.findajob.jobamax.util.NODE_APPLICANTS
import com.findajob.jobamax.util.NODE_MATCHED
import com.findajob.jobamax.util.NODE_REFUSED
import com.findajob.jobamax.util.log
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class JobSeekerTrackFragment : BaseFragmentMain<FragmentJobSeekerTrackBinding>() {

    val viewModel: JobSeekerHomeViewModel by activityViewModels()

    private lateinit var matchedJobTrackAdapter: JobSeekerTrackAdapter
    private lateinit var pendingTrackAdapter: JobSeekerTrackAdapter
    private lateinit var refusedJobTrackAdapter: JobSeekerTrackAdapter

    override val layoutRes: Int get() = R.layout.fragment_job_seeker_track

    override fun onCreated(savedInstance: Bundle?) {
        initViews()
        subscribeObserver()
    }

    private fun initViews() {

        matchedJobTrackAdapter = JobSeekerTrackAdapter(NODE_MATCHED)
        pendingTrackAdapter = JobSeekerTrackAdapter(NODE_APPLICANTS)
        refusedJobTrackAdapter = JobSeekerTrackAdapter(NODE_REFUSED)

        binding.apply {
            rvMatchedJobs.layoutManager = LinearLayoutManager(context)
            rvPendingJobs.layoutManager = LinearLayoutManager(context)
            rvRefusedJobs.layoutManager = LinearLayoutManager(context)

            rvMatchedJobs.adapter = matchedJobTrackAdapter
            rvPendingJobs.adapter = pendingTrackAdapter
            rvRefusedJobs.adapter = refusedJobTrackAdapter
        }
    }

    private fun subscribeObserver() {

        viewModel.apply {

            loadAppliedJobs()
            observe(jobSeekerTrackStateLiveData) { state ->

                log("subscribeObserver: State has been loaded $state")

                matchedJobTrackAdapter.submitJobOffers(state?.matchedList ?: emptyList())
                pendingTrackAdapter.submitJobOffers(state?.appliedList ?: emptyList())

                refusedJobTrackAdapter.apply {

                    submitJobOffers(state?.refusedList ?: emptyList())

                    viewLifecycleOwner.lifecycleScope.launch(Dispatchers.IO) {
                        val refusedReasons = state?.refuseReasons?.map { rejectReasonPo ->
                            RejectReason(rejectReasonPo)
                        } ?: emptyList()
                        submitReasons(refusedReasons)
                    }
                }
            }
        }

    }

    override fun getViewModel(): BaseAndroidViewModel = viewModel
}

