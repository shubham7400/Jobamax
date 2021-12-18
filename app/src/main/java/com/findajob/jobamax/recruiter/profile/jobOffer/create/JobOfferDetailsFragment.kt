package com.findajob.jobamax.recruiter.profile.jobOffer.create

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.PopupMenu
import android.widget.SeekBar
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import coil.load
import com.findajob.jobamax.R
import com.findajob.jobamax.base.BaseFragmentMain
import com.findajob.jobamax.databinding.FragmentJobOfferDetailsBinding
import com.findajob.jobamax.databinding.ItemChipBinding
import com.findajob.jobamax.dialog.ConfirmationDialog
import com.findajob.jobamax.dialog.NewConfirmationDialog
import com.findajob.jobamax.extensions.observe
import com.findajob.jobamax.location.ManageLocationActivity
import com.findajob.jobamax.model.JobOffer
import com.findajob.jobamax.recruiter.home.RecruiterHomeViewModel
import com.findajob.jobamax.repo.SaveJobOfferCallback
import com.findajob.jobamax.util.*
import com.parse.ParseGeoPoint
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class JobOfferDetailsFragment : BaseFragmentMain<FragmentJobOfferDetailsBinding>(),
    JobOfferDetailsHandler {

    val viewModel: RecruiterHomeViewModel by activityViewModels()

    private lateinit var benefitsAdapter: SelectBenefitsAdapter
    private lateinit var navController: NavController
    private var fileUri: Uri? = null

    var jobOffer = JobOffer()


    override val layoutRes: Int
        get() = R.layout.fragment_job_offer_details

    override fun onCreated(savedInstance: Bundle?) {
        configureViewModel()
        initViews()
        initField()
    }

    override fun onHideJobClicked() {
        if (viewModel.jobOfferDetailsState.isArchived) showUnArchiveDialog(jobOffer)
        else showArchiveDialog(jobOffer)
//        observe(viewModel.selectedJobOfferObservable) {
//            it?.let { jobOffer ->
//                if (viewModel.selectedJobOffer != null) {
//                    if (jobOffer.isArchived) showUnArchiveDialog(jobOffer)
//                    else showArchiveDialog(jobOffer)
//                }
//            }
//        }
    }

    private fun showArchiveDialog(job: JobOffer) {
        val dialog = NewConfirmationDialog(
            requireActivity(),
            getString(R.string.you_want_to_end_this_job),
        ) { clickedYes ->
            if (clickedYes) {
                archiveJobOffer(job)
            } else log("The recruiter decided not to archive this job offer.")
        }
        dialog.show()

//        ConfirmationDialog(
//            requireActivity(),
//            "Are you sure you want to archive your Job Offer?\nThe Job seeker's can't see your job offer any more.",
//            "Archive",
//            "Cancel",
//            true,
//        ) { buttonClicked ->
//            if (buttonClicked == ConfirmationDialog.CallConfirmationButton.POSITIVE) {
//                archiveJobOffer(job)
//            } else {
//                log("The recruiter decided not to archive this job offer.")
//            }
//        }.show()
    }

    private fun showUnArchiveDialog(job: JobOffer) {
        val dialog = NewConfirmationDialog(
            requireActivity(),
            getString(R.string.you_want_to_restore_this_job)
        ) { clickedYes ->
            if (clickedYes) {
                unarchiveJobOffer(job)
            } else log("The recruiter decided not to unarchive this job offer.")
        }


        dialog.show()

//
//        ConfirmationDialog(
//            requireActivity(),
//            "Do you want to reuse your job offer?",
//            "Reuse",
//            "Cancel",
//            true,
//        ) { buttonClicked ->
//            if (buttonClicked == ConfirmationDialog.CallConfirmationButton.POSITIVE) {
//                unarchiveJobOffer(job)
//            } else {
//                log("The recruiter decided not to reuse this job offer.")
//            }
//        }.show()
    }

    private fun archiveJobOffer(job: JobOffer) {
        viewModel.archiveJobOffer(job.jobOfferId)

        observe(viewModel.archiveJobOfferSuccess) {
            it?.let {
                if (it.second) {
                    job.isArchived = it.second
                    toast("Archived ${job.name} successfully.")
                    navController.navigateUp()
                } else toast("Could not archive ${job.name}.")
            }
        }
    }

    private fun unarchiveJobOffer(job: JobOffer) {
        viewModel.unarchiveJobOffer(job.jobOfferId)
        observe(viewModel.unarchiveJobOfferSuccess) {
            it?.let {
                if (it.second) {
                    toast("Reused ${job.name} successfully.")
                    job.isArchived = false
//                    binding.tvArchiveUnarchiveButton.text = "Archive"
                } else toast("Could not reuse ${job.name}.")
            }
        }
    }


    private fun initField() {
        navController = findNavController()

        binding.offer = viewModel.jobOfferDetailsState

        binding.partTimeCheck.isChecked =
            viewModel.jobOfferDetailsState.typeOfWork.contains(CONST_PART_TIME)
        binding.fullTimeCheck.isChecked =
            viewModel.jobOfferDetailsState.typeOfWork.contains(CONST_FULL_TIME)

        binding.benefitsRecycler.isNestedScrollingEnabled = false
        binding.benefitsRecycler.layoutManager = LinearLayoutManager(requireContext())
        benefitsAdapter = SelectBenefitsAdapter(viewModel.jobOfferDetailsState.benefits)
        binding.benefitsRecycler.adapter = benefitsAdapter

        binding.ivHideJobButton.load(if (viewModel.jobOfferDetailsState.isArchived) R.drawable.ic_eye else R.drawable.ic_eye_off)

        binding.distanceLabel.text = "${viewModel.jobOfferDetailsState.distance} KM"

        refreshKeySkillChips()

        binding.seekBar.max = 100
        binding.seekBar.progress = viewModel.jobOfferDetailsState.distance
        binding.seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                binding.distanceLabel.text = "$progress KM"
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }
        })
    }

    private fun initViews() {
        binding.handler = this

        if (jobOffer.isArchived)
            binding.ivHideJobButton.load(R.drawable.ic_eye)
        else binding.ivHideJobButton.load(R.drawable.ic_eye_off)
    }

    private fun configureViewModel() {

        if (!viewModel.jobOfferDetailsState.isLoaded) {
            if (viewModel.currentJobOffer != null)
                viewModel.jobOfferDetailsState =
                    JobOfferDetailsState(JobOffer(viewModel.currentJobOffer!!))
            else {
                viewModel.jobOfferDetailsState = JobOfferDetailsState()
            }
            viewModel.jobOfferDetailsState.isLoaded = true
        }
    }

    override fun getViewModel(): ViewModel = viewModel

    override fun onBackButtonClicked() = requireActivity().onBackPressed()

    override fun onLocationClicked() {
        if (PLACE_API_KEY.isNotEmpty())
            startActivityForResult(
                Intent(
                    requireContext(),
                    ManageLocationActivity::class.java
                ).putExtra(ARG_CITY_FLAG, false), REQUEST_CURRENT_LOCATION_CODE
            )
        else toast("Place API Key Required!")
    }


    override fun onLevelOfHierarchyClicked(view: View) {
        val popupMenu = PopupMenu(requireActivity(), view)
        popupMenu.menuInflater.inflate(R.menu.menu_job_level_of_hierarchy, popupMenu.menu)
        popupMenu.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.lowItem -> viewModel.jobOfferDetailsState.hierarchyFlag = 0
                R.id.mediumItem -> viewModel.jobOfferDetailsState.hierarchyFlag = 1
                R.id.highItem -> viewModel.jobOfferDetailsState.hierarchyFlag = 2
            }
            binding.offer = viewModel.jobOfferDetailsState
            binding.levelOfHierarchyField.error = null
            true
        }
        popupMenu.show()
    }

    override fun onSubmitButtonClicked() {
        if (validateFields()) {
            progressHud.show()
            if (binding.partTimeCheck.isChecked && !viewModel.jobOfferDetailsState.typeOfWork.contains(
                    CONST_PART_TIME
                )
            )
                viewModel.jobOfferDetailsState.typeOfWork.add(CONST_PART_TIME)

            if (binding.fullTimeCheck.isChecked && !viewModel.jobOfferDetailsState.typeOfWork.contains(
                    CONST_FULL_TIME
                )
            )
                viewModel.jobOfferDetailsState.typeOfWork.add(CONST_FULL_TIME)
            viewModel.jobOfferDetailsState.benefits = benefitsAdapter.getBenefits()
            viewModel.jobOfferDetailsState.distance = binding.seekBar.progress
            viewModel.saveJobOffer(fileUri, object : SaveJobOfferCallback {
                override fun onFinish(isSuccessful: Boolean) {
                    progressHud.dismiss()
                    if (isSuccessful) {
                        navController.navigateUp()
                    } else {
                        requireActivity().toast("Could not save the job offer")
                    }
                }
            })
        }
    }

    override fun onAddKeySkillsClicked() {
        val skill = binding.keySkillsField.text.toString().trim()
        if (skill.isEmpty()) {
            binding.keySkillsField.error = getString(R.string.enter_skills)
            toast(getString(R.string.enter_skills))
        } else {
            viewModel.jobOfferDetailsState.keySkills.add(skill)
            binding.keySkillsField.setText("")
            refreshKeySkillChips()
        }
    }


    override fun onKeySkillsClicked() {
        val keySkill = binding.keySkillsField.text.toString().trim()
        if (keySkill.isEmpty()) {
            binding.keySkillsField.error = getString(R.string.enter_skills)
            toast(getString(R.string.enter_skills))
        } else {
            viewModel.jobOfferDetailsState.skills.add(keySkill)
            binding.keySkillsField.setText("")
            refreshKeySkillChips()
        }
    }

    private fun refreshKeySkillChips() {
        binding.keySkillChipGroup.removeAllViews()
        viewModel.jobOfferDetailsState.keySkills.forEach { skill ->
            val chipBinding: ItemChipBinding = ItemChipBinding.inflate(
                LayoutInflater.from(requireContext()),
                binding.keySkillChipGroup,
                false
            )
            chipBinding.label.text = skill
            chipBinding.deleteButton.setOnClickListener {
                viewModel.jobOfferDetailsState.keySkills.remove(skill)
                refreshKeySkillChips()
            }
            binding.keySkillChipGroup.addView(chipBinding.root)
        }
    }


    private fun validateFields(): Boolean {
        var validateFlag = true

        if (viewModel.jobOfferDetailsState.name.isEmpty()) {
            binding.nameField.error = getString(R.string.enter_job_name)
            validateFlag = false
        }
        if (viewModel.jobOfferDetailsState.company.isEmpty()) {
            binding.companyField.error = getString(R.string.enter_company_name)
            validateFlag = false
        }

        if (viewModel.jobOfferDetailsState.industry.isEmpty()) {
            binding.industryField.error = getString(R.string.enter_industry)
            validateFlag = false
        }

        if (viewModel.jobOfferDetailsState.hierarchyFlag == -1) {
            binding.levelOfHierarchyField.error = getString(R.string.select_high_medium_low)
            validateFlag = false
        }

        if (viewModel.jobOfferDetailsState.keySkills.isEmpty()) {
            binding.keySkillsField.error = getString(R.string.enter_skills)
            validateFlag = false
        }

        if (viewModel.jobOfferDetailsState.description.isEmpty()) {
            binding.descriptionField.error = getString(R.string.enter_job_details)
            validateFlag = false
        }

        if (viewModel.jobOfferDetailsState.monthlySalary.isEmpty()) {
            binding.monthlySalaryField.error = getString(R.string.enter_salary)
            validateFlag = false
        }

        return validateFlag
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == SAF_PERMISSIONS_REQUEST_CODE && resultCode == Activity.RESULT_OK && data != null) {
            fileUri = data.data!!
        } else if (requestCode == REQUEST_CURRENT_LOCATION_CODE && resultCode == Activity.RESULT_OK && data != null) {
            val location = data.getStringExtra(ARG_LOCATION) ?: ""
            val lat = data.getDoubleExtra(ARG_LAT, 0.0)
            val lng = data.getDoubleExtra(ARG_LNG, 0.0)
            viewModel.jobOfferDetailsState.geoLocation = ParseGeoPoint(lat, lng)
            if (location.isNotEmpty()) {
                viewModel.jobOfferDetailsState.location = location
                binding.offer = viewModel.jobOfferDetailsState
            }
        } else if (requestCode == REQUEST_CITY_CODE && resultCode == Activity.RESULT_OK && data != null) {
            val location = data.getStringExtra(ARG_LOCATION) ?: ""
            if (location.isNotEmpty()) {
                viewModel.jobOfferDetailsState.city = location
                binding.offer = viewModel.jobOfferDetailsState
            }
        }
    }


}

interface JobOfferDetailsHandler {

    fun onBackButtonClicked()

    fun onLocationClicked()

    fun onLevelOfHierarchyClicked(view: View)

    fun onSubmitButtonClicked()

    fun onAddKeySkillsClicked()

    fun onKeySkillsClicked()

    fun onHideJobClicked()
}