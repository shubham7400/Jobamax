package com.findajob.jobamax.jobseeker.source

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.findNavController
import com.findajob.jobamax.R
import com.findajob.jobamax.base.BaseFragmentMain
import com.findajob.jobamax.databinding.FragmentJobSourceBinding
import com.findajob.jobamax.databinding.ItemChipBinding
import com.findajob.jobamax.dialog.multiChoice.Choice
import com.findajob.jobamax.dialog.multiChoice.MultiChoiceDialog
import com.findajob.jobamax.extensions.observe
import com.findajob.jobamax.location.ManageLocationActivity
import com.findajob.jobamax.model.JobSource
import com.findajob.jobamax.recruiter.home.RecruiterHomeActivity
import com.findajob.jobamax.recruiter.home.RecruiterHomeViewModel
import com.findajob.jobamax.util.*
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_job_source.*

@AndroidEntryPoint
class JobSourceFragment : BaseFragmentMain<FragmentJobSourceBinding>(), JobSourceInterface {

    val viewModel: RecruiterHomeViewModel by activityViewModels()
    lateinit var jobSourceState: JobSource

    private val choiceEmployment: ArrayList<Choice> by lazy {
        ArrayList()
    }
    private val choiceDuration: ArrayList<Choice> by lazy {
        ArrayList()
    }
    private val typeOfWorkSelected: ArrayList<String> by lazy {
        ArrayList()
    }
    private val multiChoiceDialog: MultiChoiceDialog by lazy {
        MultiChoiceDialog(requireContext())
    }

    override fun getViewModel(): ViewModel = viewModel

    override fun onCreated(savedInstance: Bundle?) {
        configureViewModel()
        initViews()
    }

    private fun configureViewModel() {
//        viewModel = ViewModelProvider(requireActivity()).get(RecruiterHomeViewModel::class.java)
    }

    private fun initViews() {
        observe(viewModel.jobSourceObservable) { jobSourcePo ->

            jobSourceState = JobSource(jobSourcePo!!)

            binding.apply {
                state = jobSourceState
                handler = this@JobSourceFragment
//
//                jobCheck.isChecked = jobSourceState.jobCategory.contains(CONST_JOB)
//                internshipCheck.isChecked = jobSourceState.jobCategory.contains(CONST_INTERNSHIP)
//                workStudyCheck.isChecked = jobSourceState.jobCategory.contains(CONST_WORK_STUDY)
//                otherCheck.isChecked = jobSourceState.jobCategory.contains(CONST_OTHER)

                etSourceField.setText(jobSourceState.source)
            }
//            initTypeOfWorkData()
            initFields()
        }
    }

//    private fun initTypeOfWorkData() {
//        val typeOfWork = jobSourceState.typeOfWork
//        choiceEmployment.add(
//            Choice(
//                type = CONST_FULL_TIME,
//                name = getString(R.string.full_time),
//                checked = typeOfWork.contains(CONST_FULL_TIME)
//            )
//        )
//        choiceEmployment.add(
//            Choice(
//                type = CONST_PART_TIME,
//                name = getString(R.string.part_time),
//                checked = typeOfWork.contains(CONST_PART_TIME)
//            )
//        )
//
//        choiceDuration.add(
//            Choice(
//                type = CONST_PERMANENT,
//                name = getString(R.string.permanent),
//                checked = typeOfWork.contains(CONST_PERMANENT)
//            )
//        )
//        choiceDuration.add(
//            Choice(
//                type = CONST_TEMPORARY,
//                name = getString(R.string.temporary),
//                checked = typeOfWork.contains(CONST_TEMPORARY)
//            )
//        )
//    }

    private fun initTypeOfWorkFields() {
        initEmployment()
        initDuration()
    }

    private fun initDuration() {
        onDurationField()
//        binding.etTypeOfWorkDuration.setOnClickListener {
//            multiChoiceDialog.show(getString(R.string.type_of_work), choiceDuration) {
//                onDurationField()
//            }
//        }
    }

    private fun initEmployment() {
        onEmploymentField()
//        binding.etTypeOfWorkEmployment.setOnClickListener {
//            multiChoiceDialog.show(getString(R.string.type_of_work), choiceEmployment) {
//                onEmploymentField()
//            }
//        }
    }

    private fun onEmploymentField() {
        typeOfWorkSelected.removeAll(listOf(CONST_FULL_TIME, CONST_PART_TIME))
        val result = ArrayList<String>()
        choiceEmployment.forEach { typeOfWork ->
            if (typeOfWork.checked) {
                typeOfWorkSelected.add(typeOfWork.type)
                result.add(typeOfWork.name)
            }
        }
//        binding.etTypeOfWorkEmployment.setText(result.joinToString(separator = ", "))
    }

    private fun onDurationField() {
        typeOfWorkSelected.removeAll(listOf(CONST_PERMANENT, CONST_TEMPORARY))
        val result = ArrayList<String>()
        choiceDuration.forEach { typeOfWork ->
            if (typeOfWork.checked) {
                typeOfWorkSelected.add(typeOfWork.type)
                result.add(typeOfWork.name)
            }
        }
//        binding.etTypeOfWorkDuration.setText(result.joinToString(separator = ", "))
    }


    override fun onAddLocationClicked() {
        if (binding.locationField.text.toString().trim().isNotEmpty()) {
            jobSourceState.locationList.add(binding.locationField.text.toString().trim())
            binding.locationField.setText("")
        } else toast(getString(R.string.enter_city_or_country))
    }


    private fun initFields() {
        refreshEducationChips()
        refreshExpChips()
        refreshKeySkillsChips()
        initTypeOfWorkFields()
    }


    override fun onAddExperienceClicked() {
        if (binding.experienceField.text.toString().trim().isNotEmpty()) {
            jobSourceState.experienceList.add(binding.experienceField.text.toString().trim())
            binding.experienceField.setText("")
            refreshExpChips()
        } else toast(getString(R.string.enter_experiences))
    }

    private fun refreshExpChips() {
        binding.expChipGroup.removeAllViews()
        jobSourceState.experienceList.forEach { item ->
            val chipBinding: ItemChipBinding = ItemChipBinding.inflate(
                LayoutInflater.from(requireContext()),
                binding.expChipGroup,
                false
            )
            chipBinding.label.text = item
            chipBinding.deleteButton.setOnClickListener {
                jobSourceState.experienceList.remove(item)
                refreshExpChips()
            }
            binding.expChipGroup.addView(chipBinding.root)
        }
    }

    override fun onAddEducationClicked() {
        if (binding.educationField.text.toString().trim().isNotEmpty()) {
            jobSourceState.educationList.add(binding.educationField.text.toString().trim())
            binding.educationField.setText("")
            refreshEducationChips()
        } else toast(getString(R.string.enter_education))
    }


    private fun refreshEducationChips() {
        binding.educationChipGroup.removeAllViews()
        jobSourceState.educationList.forEach { item ->
            val chipBinding: ItemChipBinding = ItemChipBinding.inflate(
                LayoutInflater.from(requireContext()),
                binding.educationChipGroup,
                false
            )
            chipBinding.label.text = item
            chipBinding.deleteButton.setOnClickListener {
                jobSourceState.educationList.remove(item)
                refreshEducationChips()
            }
            binding.educationChipGroup.addView(chipBinding.root)
        }
    }

    override fun onAddKeySkillClicked() {
        if (binding.skillField.text.toString().trim().isNotEmpty()) {
            jobSourceState.keySkillList.add(binding.skillField.text.toString().trim())
            binding.skillField.setText("")
            refreshKeySkillsChips()
        } else toast(getString(R.string.enter_skills))
    }


    private fun refreshKeySkillsChips() {
        binding.skillChipGroup.removeAllViews()
        jobSourceState.keySkillList.forEach { item ->
            val chipBinding: ItemChipBinding = ItemChipBinding.inflate(
                LayoutInflater.from(requireContext()),
                binding.skillChipGroup,
                false
            )
            chipBinding.label.text = item
            chipBinding.deleteButton.setOnClickListener {
                jobSourceState.keySkillList.remove(item)
                refreshKeySkillsChips()
            }
            binding.skillChipGroup.addView(chipBinding.root)
        }
    }

    override fun onSubmitButtonClicked() {
        progressHud.show()

        jobSourceState.source = binding.etSourceField.text.toString().trim()
        jobSourceState.distance = binding.seekBar.progress
        jobSourceState.location = locationField.text.toString()
        jobSourceState.locationList.add(locationField.text.toString())

        viewModel.saveJobSource(jobSourceState)

        progressHud.dismiss()
        findNavController().navigateUp()
    }

    override fun onBackButtonClicked() {
        (requireActivity() as RecruiterHomeActivity).onBackPressed()
    }


    override fun onResetClicked() {
        val newJobSourceParseObject = JobSource().toParseObject()
        viewModel.modifyJobSource(newJobSourceParseObject)
        jobSourceState = JobSource(newJobSourceParseObject)
        viewModel.saveJobSource(jobSourceState)
        (requireActivity() as RecruiterHomeActivity).onBackPressed()
    }

    override fun onCityClicked() {
        if (PLACE_API_KEY.isNotEmpty())
            startActivityForResult(
                Intent(
                    requireContext(),
                    ManageLocationActivity::class.java
                ).putExtra(ARG_CITY_FLAG, true), REQUEST_CITY_CODE
            )
        else toast("Place API Key Required!")
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CITY_CODE && resultCode == Activity.RESULT_OK && data != null) {
            val location = data.getStringExtra(ARG_LOCATION) ?: ""
            if (location.isNotEmpty()) {
                binding.locationField.setText(location)
            }
        }
    }

    override val layoutRes: Int
        get() = R.layout.fragment_job_source

}

