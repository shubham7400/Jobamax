package com.findajob.jobamax.jobseeker.profile.cv

import android.os.Bundle
import android.view.LayoutInflater
import androidx.core.os.bundleOf
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.findajob.jobamax.R
import com.findajob.jobamax.base.BaseFragmentMain
import com.findajob.jobamax.base.underline
import com.findajob.jobamax.databinding.FragmentJobSeekerResumeBinding
import com.findajob.jobamax.databinding.ItemChipBinding
import com.findajob.jobamax.dialog.NewConfirmationDialog
import com.findajob.jobamax.extensions.observe
import com.findajob.jobamax.jobseeker.home.JobSeekerHomeViewModel
import com.findajob.jobamax.jobseeker.profile.cv.adapter.EducationAdapter
import com.findajob.jobamax.jobseeker.profile.cv.adapter.ExperienceAdapter
import com.findajob.jobamax.jobseeker.profile.cv.model.Education
import com.findajob.jobamax.jobseeker.profile.cv.model.Experience
import com.findajob.jobamax.util.*
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class JobSeekerResumeFragment : BaseFragmentMain<FragmentJobSeekerResumeBinding>(),
    JobSeekerResumeHandler {

    lateinit var navController: NavController

    @Inject
    lateinit var gsonConverter: Gson

    val viewModel: JobSeekerResumeViewModel by activityViewModels()
    private val homeViewModel: JobSeekerHomeViewModel by activityViewModels()

    override fun getViewModel(): ViewModel = viewModel

    private var educationAdapter = EducationAdapter({ education ->
        log("Selected education for editing is $education")
        navController.navigate(
            R.id.action_jobSeekerCvFragment_to_createEducationFragment,
            bundleOf(ARG_EDUCATION to gsonConverter.toJson(education))
        )
    }, { education ->
        log("Selected education for deleting is ${education.name}")
        showDeleteEducationDialog(education)
    })

    private var experienceAdapter = ExperienceAdapter({ experience ->
        log("Selected experience for experience is ${experience.job}")
        navController.navigate(
            R.id.action_jobSeekerCvFragment_to_createExperienceFragment2,
            bundleOf(ARG_EXPERIENCE to gsonConverter.toJson(experience))
        )
    }, { experience ->
        log("Selected experience for experience is ${experience.job}")
        showDeleteExperienceDialog(experience)
    })

    override val layoutRes: Int
        get() = R.layout.fragment_job_seeker_resume

    override fun onCreated(savedInstance: Bundle?) {
        configureViewModel()
        initViews()
        subscribeObserver()
    }

    private fun configureViewModel() {
        if (viewModel.jobSeekerParseObject == null) {
            viewModel.setJobSeeker(homeViewModel.jobSeekerObject)
            viewModel.loadResume()
        }
    }


    private fun initViews() {
        progressHud.show()

        binding.apply {
            binding.handler = this@JobSeekerResumeFragment
            navController = findNavController()

            educationRecycler.layoutManager = LinearLayoutManager(requireContext())
            educationRecycler.adapter = educationAdapter

            experienceRecycler.layoutManager = LinearLayoutManager(requireContext())
            experienceRecycler.adapter = experienceAdapter

            tvEducationsLabel.underline()
            tvExperiencesLabel.underline()
            tvSkillsLabel.underline()
            tvActivitiesLabel.underline()
            tvAboutMeLabel.underline()
        }

    }


    private fun subscribeObserver() {

        viewModel.apply {
            observe(experiencesObservable) { experiences ->
                progressHud.dismiss()
                if (experiences != null) experienceAdapter.submitExperienceList(experiences)
            }

            observe(educationObservable) { educations ->
                if (educations != null) educationAdapter.submitEducationList(educations)
            }

            observe(aboutMeObservable) { aboutMe ->
                if (aboutMe != null) binding.aboutMeField.setText(aboutMe)
            }

        }

        loadActivityChips()
        loadSkillChips()
    }

    override fun onAddEducationClicked() {
        navController.navigate(
            R.id.action_jobSeekerCvFragment_to_createEducationFragment,
            bundleOf(ARG_EDUCATION to "")
        )
    }

    override fun onAddExperienceClicked() {
        navController.navigate(
            R.id.action_jobSeekerCvFragment_to_createExperienceFragment2,
            bundleOf(ARG_EXPERIENCE to "")
        )
    }

    override fun onAddSkillsClicked() {

        val skill = binding.skillsField.text.toString().trim()

        if (skill.isEmpty()) {
            binding.skillsField.error = getString(R.string.enter_skills)
            toast(getString(R.string.enter_skills))
        } else {
            viewModel.addSkill(skill)
            binding.skillsField.setText("")
            loadSkillChips()
        }
    }

    private fun loadSkillChips() {

        binding.skillChipGroup.removeAllViews()

        observe(viewModel.skillsObservable) { skills ->
            binding.skillChipGroup.removeAllViews()
            skills?.forEach { skill ->
                val chipBinding: ItemChipBinding = ItemChipBinding.inflate(
                    LayoutInflater.from(requireContext()),
                    binding.skillChipGroup,
                    false
                )
                chipBinding.label.text = skill
                chipBinding.deleteButton.setOnClickListener {
                    viewModel.removeSkill(skill)
//                    viewModel.activities.remove(activity)
                    loadSkillChips()
                }
                binding.skillChipGroup.addView(chipBinding.root)
            }
        }
    }


    override fun onAddActivityClicked() {

        val activity = binding.activityField.text.toString().trim()
        if (activity.isEmpty()) {
            binding.activityField.error = getString(R.string.enter_activity)
            toast(getString(R.string.enter_activity))
        } else {
            viewModel.addActivity(activity)
            binding.activityField.setText("")
            loadActivityChips()
        }
    }


    private fun loadActivityChips() {
        binding.activityChipGroup.removeAllViews()

        observe(viewModel.activitiesObservable) { activities ->
            binding.activityChipGroup.removeAllViews()
            activities?.forEach { activity ->
                val chipBinding: ItemChipBinding = ItemChipBinding.inflate(
                    LayoutInflater.from(requireContext()),
                    binding.activityChipGroup,
                    false
                )
                chipBinding.label.text = activity
                chipBinding.deleteButton.setOnClickListener {
                    viewModel.removeActivity(activity)
//                    viewModel.activities.remove(activity)
                    loadActivityChips()
                }
                binding.activityChipGroup.addView(chipBinding.root)
            }
        }

    }

    override fun onBackButtonClicked() {
        viewModel.changeAboutMe(binding.aboutMeField.text.toString())

        progressHud.show()

        viewModel.saveResumeData()

        observe(viewModel.resumeSaveSuccess) {
            it?.let { isSuccessfullySaved ->
                progressHud.dismiss()
                if (isSuccessfullySaved) navController.navigateUp()
                else toast("Resume could not be saved.")
            }
        }
    }

    private fun showDeleteEducationDialog(education: Education) {
        val deleteEducationDialog =
            NewConfirmationDialog(
                requireActivity(),
                "Are you sure you want do delete this?"
            ) { shouldDelete ->
                if (shouldDelete) {
                    viewModel.removeEducation(education)
                }
            }

        deleteEducationDialog.show()
    }

    private fun showDeleteExperienceDialog(experience: Experience) {
        val deleteExperienceDialog =
            NewConfirmationDialog(
                requireActivity(),
                "Are you sure you want do delete this?"
            ) { shouldDelete ->
                if (shouldDelete) viewModel.removeExperience(experience)
            }

        deleteExperienceDialog.show()
    }

}