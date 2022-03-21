package com.findajob.jobamax.jobseeker.track.newtrack

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import com.findajob.jobamax.R
import com.findajob.jobamax.base.BaseFragmentMain
import com.findajob.jobamax.databinding.FragmentSeekerTrackingJobDescriptionBinding
import com.findajob.jobamax.databinding.FragmentSeekerTrackingJobDetailsBinding
import com.findajob.jobamax.jobseeker.home.JobSeekerHomeViewModel
import com.findajob.jobamax.model.JobOffer
import com.findajob.jobamax.model.TrackingJob
import com.findajob.jobamax.util.loadImageFromUrl
import com.findajob.jobamax.util.log


class SeekerTrackingJobDescriptionFragment : BaseFragmentMain<FragmentSeekerTrackingJobDescriptionBinding>() {

    override val layoutRes: Int get() = R.layout.fragment_seeker_tracking_job_description
    val viewModel: JobSeekerHomeViewModel by activityViewModels()
    override fun getViewModel(): ViewModel = viewModel

    var trackingJob: TrackingJob? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentSeekerTrackingJobDescriptionBinding.inflate(inflater, container, false)
        configureUi()
        return binding.root
    }

    private fun configureUi() {
        arguments?.getSerializable("tracking_job")?.let {
            trackingJob = it as TrackingJob
        }
        trackingJob?.let {
            setData()
        }
    }

    private fun setData() {
        trackingJob?.job?.let {
            loadImageFromUrl(binding.ivCompany,it.getString("logo"), R.drawable.ic_company)
            binding.tvJobTitle.text = it.getString("jobTitle")
            binding.tvAboutJob.text = it.getString("description")
            binding.tvCompanyAddress.text = it.getString("city")
            binding.tvJobType.text = it.getString("typeOfWork")
            binding.tvCompanyName.text = it.getString("companyName")
        }
    }

    override fun onCreated(savedInstance: Bundle?) {
        if (viewModel.jobSeekerObject != null){
            binding.jobSeeker = viewModel.jobSeeker
        }
        setClickListeners()
    }

    private fun setClickListeners() {
        binding.ivBackButton.setOnClickListener {
            requireActivity().onBackPressed()
        }
        binding.ivUserProfile.setOnClickListener {
            requireActivity().finish()
        }
    }

}