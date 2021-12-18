package com.findajob.jobamax.recruiter.profile.jobOffer.view

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.findajob.jobamax.R
import com.findajob.jobamax.base.BaseFragmentMain
import com.findajob.jobamax.databinding.FragmentViewJobOfferBinding
import com.findajob.jobamax.dialog.ConfirmationDialog
import com.findajob.jobamax.extensions.observe
import com.findajob.jobamax.model.JobOffer
import com.findajob.jobamax.recruiter.home.RecruiterHomeViewModel
import com.findajob.jobamax.recruiter.profile.jobOffer.create.JobOfferDetailsState
import com.findajob.jobamax.util.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ViewJobOfferFragment : BaseFragmentMain<FragmentViewJobOfferBinding>(),
    ViewJobOfferInterface {

    lateinit var recruiterHomeViewModel: RecruiterHomeViewModel
    private lateinit var navController: NavController
    lateinit var state: ViewJobOfferState

    override val layoutRes: Int
        get() = R.layout.fragment_view_job_offer

    override fun getViewModel() = recruiterHomeViewModel

    override fun onCreated(savedInstance: Bundle?) {
        configureViewModel()
        initViews()
        subscribeObservers()
    }

    private fun configureViewModel() {
        recruiterHomeViewModel =
            ViewModelProvider(requireActivity()).get(RecruiterHomeViewModel::class.java)
    }

    private fun initViews() {
        binding.handler = this
        progressHud.show()
    }

    private fun subscribeObservers() {
        recruiterHomeViewModel.getJobOfferById(
            recruiterHomeViewModel.currentJobOffer?.objectId ?: ""
        )

        observe(recruiterHomeViewModel.selectedJobOfferObservable) { jobOffer ->
            if (jobOffer != null) loadUi(jobOffer)
            else navController.navigateUp()
        }
    }

    private fun loadUi(jobOffer: JobOffer) {

        state = ViewJobOfferState(jobOffer)
        binding.offer = state

        val benefitsNotEmpty = state.benefits.isNotEmpty()
        binding.tvBenefitsLabel.isVisible(benefitsNotEmpty)
        binding.cvBenefitsField.isVisible(benefitsNotEmpty)

        if (state.typeOfWork.contains(CONST_PERMANENT))
            binding.rbPermanent.isChecked = true
        else if (state.typeOfWork.contains(CONST_PART_TIME))
            binding.rbPartTime.isChecked = true
        else binding.rbInternship.isChecked = true

        navController = findNavController()

        recruiterHomeViewModel.jobOfferDetailsState = JobOfferDetailsState()

        lifecycleScope.launch(Dispatchers.IO) {
            var keySkills = ""

            for ((index, keySkill) in state.keySkills.withIndex()) {
                if (index != 0)
                    keySkills = "$keySkills, $keySkill"
                else keySkills = keySkill
            }

            withContext(Dispatchers.Main) {
                binding.etKeySkillsField.setText(keySkills)
            }

        }

        if (state.underOneWorkExSelectedFlag) binding.rbZeroToOne.isChecked = true
        else if (state.twoPlusWorkExSelectedFlag) binding.rbThreeMore.isChecked = true
        else binding.rbTwoToThree.isChecked = true

        if (state.monthlySalary.isNotEmpty()) binding.rbMonthly.isChecked = true

        if (state.companySize == "1-10") binding.rb1To10.isChecked = true
        else if (state.companySize == "11-50") binding.rb11To50.isChecked = true
        else if (state.companySize == "51-199") binding.rb51To199.isChecked = true
        else binding.rb500More.isChecked = true

        progressHud.dismiss()
    }


//    private fun showChips(chipGroup: ChipGroup, items: List<String>) {
////        chipGroup.removeAllViews()
////        items.forEach { skill ->
////            val chipBinding: ItemTextChipBinding =
////                ItemTextChipBinding.inflate(LayoutInflater.from(requireContext()), chipGroup, false)
////            chipBinding.label.text = skill
////            chipGroup.addView(chipBinding.root)
////        }
//    }


    override fun onBackButtonClicked() {
        navController.navigateUp()
    }

//    override fun onEditClicked() {
//        navController.navigate(R.id.action_viewJobOfferFragment_to_createJobOfferFragment)
//    }

    override fun onDeleteClicked() {
        observe(recruiterHomeViewModel.selectedJobOfferObservable) {
            it?.let { jobOffer ->
                if (state.isArchived) showUnArchiveDialog(jobOffer)
                else showArchiveDialog(jobOffer)
            }
        }
    }

    private fun showArchiveDialog(job: JobOffer) {
        ConfirmationDialog(
            requireActivity(),
            "Are you sure you want to archive your Job Offer?\nThe Job seeker's can't see your job offer any more.",
            "Archive",
            "Cancel",
            true,
        ) { buttonClicked ->
            if (buttonClicked == ConfirmationDialog.CallConfirmationButton.POSITIVE) {
                archiveJobOffer(job)
            } else {
                log("The recruiter decided not to archive this job offer.")
            }
        }.show()
    }

    private fun showUnArchiveDialog(job: JobOffer) {
        ConfirmationDialog(
            requireActivity(),
            "Do you want to reuse your job offer?",
            "Reuse",
            "Cancel",
            true,
        ) { buttonClicked ->
            if (buttonClicked == ConfirmationDialog.CallConfirmationButton.POSITIVE) {
                unarchiveJobOffer(job)
            } else {
                log("The recruiter decided not to reuse this job offer.")
            }
        }.show()
    }

    private fun archiveJobOffer(job: JobOffer) {
        recruiterHomeViewModel.archiveJobOffer(job.jobOfferId)

        observe(recruiterHomeViewModel.archiveJobOfferSuccess) {
            it?.let {
                if (it.second) {
                    state.isArchived = it.second
                    toast("Archived ${job.name} successfully.")
                    navController.navigateUp()
                } else toast("Could not archive ${job.name}.")
            }
        }
    }

    private fun unarchiveJobOffer(job: JobOffer) {
        recruiterHomeViewModel.unarchiveJobOffer(job.jobOfferId)


        observe(recruiterHomeViewModel.unarchiveJobOfferSuccess) {
            it?.let {
                if (it.second) {
                    toast("Reused ${job.name} successfully.")
                    state.isArchived = false
//                    binding.tvArchiveUnarchiveButton.text = "Archive"
                } else toast("Could not reuse ${job.name}.")
            }
        }
    }

    override fun onSaveClicked() {
        progressHud.show()
        lifecycleScope.launch(Dispatchers.IO) {
            log("save clicked")
            delay(1000)
            withContext(Dispatchers.Main) {
                progressHud.dismiss()
                navController.navigateUp()
            }
        }
    }


}

