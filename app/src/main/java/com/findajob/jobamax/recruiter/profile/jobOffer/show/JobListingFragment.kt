package com.findajob.jobamax.recruiter.profile.jobOffer.show

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.findajob.jobamax.R
import com.findajob.jobamax.base.BaseFragmentMain
import com.findajob.jobamax.databinding.FragmentJobListingBinding
import com.findajob.jobamax.dialog.NewConfirmationDialog
import com.findajob.jobamax.dialog.JobOfferCommunicationDialog
import com.findajob.jobamax.extensions.observe
import com.findajob.jobamax.recruiter.home.RecruiterHomeViewModel
import com.findajob.jobamax.recruiter.profile.jobOffer.create.JobOfferDetailsState
import com.findajob.jobamax.util.log
import com.findajob.jobamax.util.toast
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

@AndroidEntryPoint
class JobListingFragment : BaseFragmentMain<FragmentJobListingBinding>(),
    ShowAllJobOfferController {

    val viewModel: RecruiterHomeViewModel by activityViewModels()
    override fun getViewModel(): ViewModel = viewModel

    private lateinit var navController: NavController

    private var showArchivedJobs = false

    override val layoutRes: Int
        get() = R.layout.fragment_job_listing

    private lateinit var jobOfferAdapter: JobOfferAdapter

    override fun onCreated(savedInstance: Bundle?) {
        configureViewModel()
        initView()
        subscribeObserver()
    }

    private fun configureViewModel() {
        viewModel.getCurrentRecruiter()

        observe(viewModel.errorText) { errorMessage ->
            toast(errorMessage ?: "An error occurred")
            log("configureViewModel: $errorMessage", Exception())
        }
    }

    private fun initView() {
        progressHud.show()

        jobOfferAdapter = JobOfferAdapter { jobOfferPo ->
            viewModel.currentJobOffer = jobOfferPo
            viewModel.selectedJobOfferObjectId = jobOfferPo.objectId
            navController.navigate(R.id.action_showAllJobOfferFragment_to_createJobOfferFragment)
        }

        binding.apply {
            handler = this@JobListingFragment
            rvActiveJobOffers.layoutManager = LinearLayoutManager(context)
            rvActiveJobOffers.adapter = jobOfferAdapter

            showContactDialog()
        }

        viewModel.jobOfferDetailsState = JobOfferDetailsState()

        navController = findNavController()

    }

    private fun showContactDialog() {
        val contactDialog = JobOfferCommunicationDialog(
            requireActivity(),
            getString(R.string.jobamax_contact_header),
            getString(R.string.contact_us_to_find_out),
            getString(R.string.contact),
            getString(R.string.skip),
            {
                log("The contact button was clicked")
                showContactMeDialog()
            },
            {
                log("the contact dialog was skipped by the user")
            },
        )

        contactDialog.show()
    }

    private fun showContactMeDialog() {
        observe(viewModel.currentRecruiterObservable) { recruiter ->
            val contactMeDialog = JobOfferCommunicationDialog(
                requireActivity(),
                getString(R.string.phone_number_email_confirmation),
                "If not modify them and come back.\n${recruiter?.phoneNumber}, ${recruiter?.email}",
                getString(R.string.contact_me),
                getString(R.string.modify),
                {
                    toast("You will be contacted by Jobamax team.")
                },
                {
                    navController.navigate(R.id.action_showAllJobOfferFragment_to_createJobOfferFragment)
                },
            )
            contactMeDialog.show()
        }

    }

    private fun subscribeObserver() {
        viewModel.apply {
            loadActiveJobOffers()
            observe(filteredJobOffers) { jobOfferList ->
                jobOfferAdapter.submitList(jobOfferList!!)

                if (jobOfferList.isEmpty()) binding.noOffersLabel.visibility = View.VISIBLE
                else binding.noOffersLabel.visibility = View.INVISIBLE

                progressHud.dismiss()
            }
        }
    }


    override fun onCreateButtonClicked() {
        val dialog = NewConfirmationDialog(
            requireActivity(),
            getString(R.string.you_want_to_add_a_job)
        ) { clickedYes ->
            if (clickedYes) prepareForAndNavigateToCreateJobOffer()
        }
        dialog.show()
    }

    private fun prepareForAndNavigateToCreateJobOffer() {
        viewModel.currentJobOffer = null
        viewModel.selectedJobOfferObjectId = ""
        navController.navigate(R.id.action_showAllJobOfferFragment_to_createJobOfferFragment)
    }

    override fun onBackButtonClicked() {
        navController.navigateUp()
    }

    override fun onArchivedToggleClicked() {
        if (!showArchivedJobs) {
            binding.btnArchivedJobOffers.text = getString(R.string.active)
            binding.tvJobOfferLabel.text = getString(R.string.archived_job_offers)
            showArchivedJobs = true
        } else {
            binding.btnArchivedJobOffers.text = getString(R.string.archived)
            binding.tvJobOfferLabel.text = getString(R.string.active_job_offers)
            showArchivedJobs = false
        }

        loadJobOffers()

    }

    private fun loadJobOffers() {
        progressHud.show()
        lifecycleScope.launch(Dispatchers.IO) {
            if (!showArchivedJobs)
                viewModel.loadActiveJobOffers()
            else viewModel.loadArchivedJobOffers()
        }
    }

}

interface ShowAllJobOfferController {

    fun onBackButtonClicked()

    fun onCreateButtonClicked()

    fun onArchivedToggleClicked()
}