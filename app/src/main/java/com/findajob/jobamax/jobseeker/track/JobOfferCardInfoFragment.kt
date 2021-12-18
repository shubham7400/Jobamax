package com.findajob.jobamax.jobseeker.track

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.findajob.jobamax.R
import com.findajob.jobamax.base.BaseFragmentMain
import com.findajob.jobamax.databinding.FragmentJobOfferCardInfoBinding
import com.findajob.jobamax.databinding.ItemTextChipBinding
import com.findajob.jobamax.jobseeker.home.JobSeekerHomeViewModel
import com.findajob.jobamax.jobseeker.home.JobSeekerHomeViewModel.JobOfferButtonCallback
import com.findajob.jobamax.model.Company
import com.findajob.jobamax.model.JobOffer
import com.findajob.jobamax.recruiter.profile.jobOffer.create.ViewBenefitsAdapter
import com.findajob.jobamax.util.ARG_VIDEO_URL
import com.findajob.jobamax.util.isVisible
import com.findajob.jobamax.util.log
import com.parse.ParseObject
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class JobOfferCardInfoFragment : BaseFragmentMain<FragmentJobOfferCardInfoBinding>() {

    val viewModel: JobSeekerApplyViewModel by activityViewModels()
    val jobSeekerHomeViewModel: JobSeekerHomeViewModel by activityViewModels()
    lateinit var navController: NavController
    lateinit var parseObject: ParseObject

    private fun initViews() {
        jobSeekerHomeViewModel.loadAppliedJobs()
        parseObject =
            jobSeekerHomeViewModel.jobOffers[jobSeekerHomeViewModel.currentIndex]
        val jobOffer = JobOffer(parseObject)
        binding.offer = jobOffer
//            binding.jobsource = when(jobOffer.jobOfferId) {
//				REMOTIVE_JOB -> R.drawable.remotive_logo
//				ADZUNA_JOB -> R.drawable.adzuna_logo
//				JOOBLE_JOB -> R.drawable.jooble_logo
//				JOBSPIKR_JOB -> R.drawable.logo_jobspikr
//				else -> R.drawable.get_started_logo
//			}


        refreshChips(jobOffer.keySkills)
        binding.overlayLayout.visibility = View.GONE
        binding.companyVideoLayout.visibility = View.GONE

        binding.benefitsLayout.isVisible(jobOffer.benefits.isNotEmpty())
        binding.benefitsRecycler.layoutManager = LinearLayoutManager(requireContext())
        binding.benefitsRecycler.isNestedScrollingEnabled = false
        binding.benefitsRecycler.adapter = ViewBenefitsAdapter(jobOffer.benefits)
        binding.backButton.setOnClickListener {
            navController.popBackStack()
        }

        binding.rejectButton.setOnClickListener {
            jobSeekerHomeViewModel.jobOfferButtonCallback = JobOfferButtonCallback.REJECT
            navController.popBackStack()
        }

        binding.acceptButton.setOnClickListener {
            jobSeekerHomeViewModel.jobOfferButtonCallback = JobOfferButtonCallback.ACCEPT
            navController.popBackStack()
        }

        binding.chatButton.setOnClickListener {
            jobSeekerHomeViewModel.jobOfferButtonCallback = JobOfferButtonCallback.CHAT
            navController.popBackStack()
        }

        try {
            val companyParseObject =
                parseObject.getParseObject("company")?.fetchIfNeeded<ParseObject>()
            if (companyParseObject != null) {
                loadCompanyData(Company(companyParseObject))
            }
        } catch (e: Exception) {
            log("could not get the company data", e)
        }

        navController = findNavController()
    }

    private fun loadCompanyData(company: Company) {
        if (company.logoUrl.isNotEmpty())
            Picasso.get().load(company.logoUrl).into(binding.companyIcon)
        if (company.videoPresentationThumbLink.isNotEmpty()) {
            try {
                binding.playIcon.visibility = View.GONE
                binding.thumbProgressBar.visibility = View.VISIBLE
                Picasso.get().load(company.videoPresentationThumbLink)
                    .into(binding.videoThumbnailIcon, object : Callback {
                        override fun onSuccess() {
                            binding.thumbProgressBar.visibility = View.GONE
                            binding.playIcon.visibility = View.VISIBLE
                            binding.companyVideoLayout.visibility = View.VISIBLE
                        }

                        override fun onError(e: java.lang.Exception?) {
                            binding.thumbProgressBar.visibility = View.GONE
                        }

                    })
            } catch (e: Exception) {
                binding.companyVideoLayout.visibility = View.GONE
            }

            binding.companyVideoLayout.setOnClickListener {
                navController.navigate(
                    R.id.action_jobOfferCardInfoFragment_to_playVideoFragment2,
                    bundleOf(ARG_VIDEO_URL to company.videoPresentationUrl)
                )
            }
        }
    }

    private fun refreshChips(keySkills: List<String>) {
        binding.keySkillChipGroup.removeAllViews()
        keySkills.forEach { skill ->
            val chipBinding: ItemTextChipBinding = ItemTextChipBinding.inflate(
                LayoutInflater.from(requireContext()),
                binding.keySkillChipGroup,
                false
            )
            chipBinding.label.text = skill.trim()
            binding.keySkillChipGroup.addView(chipBinding.root)
        }
    }

    override fun onCreated(savedInstance: Bundle?) {
        initViews()
    }


    override val layoutRes: Int
        get() = R.layout.fragment_job_offer_card_info


    override fun getViewModel(): ViewModel = viewModel
}

