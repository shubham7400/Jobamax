package com.findajob.jobamax.jobseeker.track.newtrack

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintSet
import androidx.core.view.isVisible
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation
import com.findajob.jobamax.R
import com.findajob.jobamax.base.BaseFragmentMain
import com.findajob.jobamax.databinding.FragmentSeekerTrackingJobDescriptionBinding
import com.findajob.jobamax.jobseeker.home.JobSeekerHomeViewModel
import com.findajob.jobamax.model.TrackingJob
import com.findajob.jobamax.util.loadImageFromUrl


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
             if (it.getString("description").isNullOrEmpty()) {
                 binding.tvAboutJob.visibility = View.GONE
             }else{
                 binding.tvAboutJob.visibility = View.VISIBLE
                 binding.tvAboutJob.text = it.getString("description")
             }
            if (it.getString("industry").isNullOrEmpty()){
                binding.llIndustry.visibility = View.GONE
            }else{
                binding.llIndustry.visibility = View.VISIBLE
                binding.tvIndustry.text = it.getString("industry")
            }
            binding.tvCompanyAddress.text = it.getString("location")
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
        binding.ivUserProfile.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_seekerTrackingJobDescriptionFragment_to_nav_seeker_profile, null))
        binding.btnSeeMoreOrLess.setOnClickListener {

                if (binding.llBottomContent.isVisible){
                    binding.btnSeeMoreOrLess.text = resources.getString(R.string.see_job_description)
                    binding.llBottomContent.visibility = View.GONE
                    binding.tvAboutJob.maxLines = 8
                    val set = ConstraintSet()
                    set.clone(binding.clTopParent)
                    set.clear(binding.btnSeeMoreOrLess.id, ConstraintSet.TOP)
                    set.connect(binding.btnSeeMoreOrLess.id, ConstraintSet.TOP, binding.llAboutJob.id, ConstraintSet.BOTTOM , 10)
                    set.applyTo(binding.clTopParent)
                }else{
                    binding.btnSeeMoreOrLess.text = resources.getString(R.string.see_less)
                    binding.llBottomContent.visibility = View.VISIBLE
                    binding.tvAboutJob.maxLines = Int.MAX_VALUE
                    val set = ConstraintSet()
                    set.clone(binding.clTopParent)
                    set.clear(binding.btnSeeMoreOrLess.id, ConstraintSet.TOP)
                    set.connect(binding.btnSeeMoreOrLess.id, ConstraintSet.TOP, binding.llBottomContent.id, ConstraintSet.BOTTOM , 10)
                    set.applyTo(binding.clTopParent)
                }
        }
    }

}