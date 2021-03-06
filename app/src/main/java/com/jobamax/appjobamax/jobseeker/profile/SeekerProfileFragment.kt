package com.jobamax.appjobamax.jobseeker.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation
import com.jobamax.appjobamax.R
import com.jobamax.appjobamax.base.BaseFragmentMain
import com.jobamax.appjobamax.databinding.FragmentSeekerProfileBinding
import com.jobamax.appjobamax.jobseeker.home.JobSeekerHomeViewModel
import com.jobamax.appjobamax.util.toast

import com.google.android.material.chip.Chip
import dagger.hilt.android.AndroidEntryPoint
import org.json.JSONArray
import com.jobamax.appjobamax.data.pojo.IdealJob
import com.jobamax.appjobamax.data.pojo.Portfolio
import com.jobamax.appjobamax.dialog.BasicDialog
import com.jobamax.appjobamax.dialog.YesNoDialog
import com.jobamax.appjobamax.enums.ParseTableFields
import com.jobamax.appjobamax.enums.ParseTableName
import com.jobamax.appjobamax.preference.getUserId
import com.parse.ParseObject
import com.parse.ParseQuery


@AndroidEntryPoint
class SeekerProfileFragment : BaseFragmentMain<FragmentSeekerProfileBinding>(), View.OnClickListener {

    override val layoutRes: Int get() = R.layout.fragment_seeker_profile
    val viewModel: JobSeekerHomeViewModel by activityViewModels()
    override fun getViewModel(): ViewModel = viewModel

    private var ownedWorkSpaces = ArrayList<String>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentSeekerProfileBinding.inflate(inflater, container, false)
        configureUi()
        return binding.root
    }


    override fun onCreated(savedInstance: Bundle?) {
        if (viewModel.jobSeekerObject == null){
            getCurrent()
        }else{
            setProfile()
        }
        binding.jobSeeker = viewModel.jobSeeker
    }

    private fun getCurrent( ) {
        val query = ParseQuery.getQuery<ParseObject>(ParseTableName.JOB_SEEKER.value)
        query.whereEqualTo(ParseTableFields.JOB_SEEKER_ID.value, context?.getUserId())
        query.include("portfolio")
        query.include("idealJob")
        progressHud.show()
        query.findInBackground { it, e ->
            progressHud.dismiss()
            val jobSeeker = it?.firstOrNull()
            when {
                e != null -> {
                    toast(e.message.toString())
                }
                jobSeeker == null -> {
                    toast("User Not Found.")
                }
                else -> {
                    viewModel.jobSeekerObject = jobSeeker
                    viewModel.isJobSeekerUpdated.value = true
                }
            }
        }
    }


    private fun configureUi() {
        setClickListeners()
        viewModelObserver()
    }

    private fun viewModelObserver() {
         viewModel.isJobSeekerUpdated.observe(viewLifecycleOwner) {
             progressHud.dismiss()
             if (it) {
                 setProfile()
             }
         }
    }

    private fun setProfile() {
        binding.jobSeeker = viewModel.jobSeeker
        val jobSeeker = viewModel.jobSeeker
        ownedWorkSpaces.clear()
        if (jobSeeker.workspaces.isNotEmpty()) {
            val workSpaces = JSONArray(jobSeeker.workspaces)
            var i = 0
            while (i < workSpaces.length()) {
                ownedWorkSpaces.add(workSpaces.getString(i))
                i++
            }
        }
        binding.cgIdealWorkspace.removeAllViews()
        ownedWorkSpaces.forEach {
            val chip = layoutInflater.inflate(R.layout.item_custom_chip, binding.cgIdealWorkspace, false) as Chip
            chip.text = it
            chip.setOnCloseIconClickListener { c ->
                ownedWorkSpaces.remove((c as Chip).text)
                binding.cgIdealWorkspace.removeView(c)
                progressHud.show()
                viewModel.addWorkSpace(ownedWorkSpaces) { exception ->
                    progressHud.dismiss()
                    if (exception != null) {
                        toast("${exception.message.toString()} Something went wrong")
                    }
                }
            }
            chip.setCloseIconResource(R.drawable.close_white)
            chip.setCloseIconTintResource(R.color.white)
            chip.isCloseIconVisible = true
            binding.cgIdealWorkspace.addView(chip)
        }

        val idealJob = jobSeeker.idealJob?.let {
            IdealJob(it)
        }

        idealJob?.let {
            if (idealJob.videoURL != ""){
                binding.tvIdealJobVideoTitle.text = "Video 1/1"
            }else{
                binding.tvIdealJobVideoTitle.text = "Video 0/1"
            }

            if (idealJob.audioUrl != ""){
                binding.tvIdealJobAudioTitle.text = "Audio 1/1"
            }else{
                binding.tvIdealJobAudioTitle.text = "Audio 0/1"
            }
        }

        val portfolio = jobSeeker.portfolio?.let { Portfolio(it) }

        portfolio?.let {
            if (portfolio.videoURL != ""){
                binding.tvPortfolioVideoTitle.text = "Video 1/1"
            }else{
                binding.tvPortfolioVideoTitle.text = "Video 0/1"
            }

            if (portfolio.arrImages.isNotEmpty()){
                binding.tvPortfolioImagesTitle.text = "Photos ${portfolio.arrImages.size}/5"
            }else{
                binding.tvPortfolioImagesTitle.text = "Photos 0/1"
            }
        }
        if (jobSeeker.elevatorPitch == ""){
            binding.tvElevetorPitchSection.visibility = View.VISIBLE
        }else{
            binding.tvElevetorPitchSection.visibility = View.GONE
        }
    }

    private fun setClickListeners() {
        binding.ivIdealJobInfo.setOnClickListener(this)
        binding.ivPortfolioInfo.setOnClickListener(this)
        binding.ivBackButton.setOnClickListener(this)
        binding.ivAddIdealWorkspaceBtn.setOnClickListener(this)
        binding.tvAboutMeBtn.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_seekerProfileFragment_to_seekerAboutMeFragment, null))
        binding.ivUser.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_seekerProfileFragment_to_seekerAboutMeFragment, null))
        binding.clEducation.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_seekerProfileFragment_to_seekerEducationFragment, null))
        binding.clSkills.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_seekerProfileFragment_to_seekerMySkillFragment, null))
        binding.clImages.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_seekerProfileFragment_to_idealJobImagesFragment, null))
        binding.clInterest.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_seekerProfileFragment_to_seekerInterestFragment, null))
        binding.clJobs.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_seekerProfileFragment_to_seekerExperienceListFragment, null))
        binding.ivPreview.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_seekerProfileFragment_to_seekerPreviewFragment, null))
        binding.tvImportResumeBtn.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_seekerProfileFragment_to_seekerImportResumeFragment, null))
        binding.clVolunteering.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_seekerProfileFragment_to_seekerVolunteeringListFragment, null))


        binding.rlIdealJobVideo.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_seekerProfileFragment_to_idealJobVideoFragment, null))
        binding.rlIdealJobMessage.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_seekerProfileFragment_to_idealJobDescriptionFragment, null))

        binding.rlIdealJobAudio.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_seekerProfileFragment_to_idealJobAudioFragment, null))
        binding.rlPortfolioVideo.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_seekerProfileFragment_to_portfolioVideoFragment, null))
        binding.rlPortfolioMessage.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_seekerProfileFragment_to_portfolioDescriptionFragment, null))
        binding.rlPortfolioImage.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_seekerProfileFragment_to_portfolioImageFragment, null))
        binding.ivJobSearch.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_seekerProfileFragment_to_nav_job_search, null))
    }


    override fun onClick(view: View?) {
        when(view){
            binding.ivIdealJobInfo -> {
                BasicDialog(requireActivity(), getString(R.string.ideal_job_info), false){}.show()
            }
            binding.ivPortfolioInfo -> {
                BasicDialog(requireActivity(), getString(R.string.portfolio_info), false){}.show()
            }
            binding.ivBackButton -> {
                requireActivity().onBackPressed()
            }
            binding.ivAddIdealWorkspaceBtn -> {
                if (binding.etIdealWorkspace.text.isNullOrEmpty()){
                    toast("Please first enter the tag.")
                }else{
                    addIdealWorkspace()
                }
            }
        }
     }



    private fun addIdealWorkspace() {
        if (ownedWorkSpaces.size > 8){
            toast("You can not add more than 8 tags.")
        }else{
            ownedWorkSpaces.add(binding.etIdealWorkspace.text.toString())
            val chip = layoutInflater.inflate(R.layout.item_custom_chip, binding.cgIdealWorkspace, false) as Chip
            chip.text = binding.etIdealWorkspace.text.toString()
            chip.setOnCloseIconClickListener { c ->
                YesNoDialog(requireActivity(), resources.getString(R.string.are_you_sure), {
                    ownedWorkSpaces.remove((c as Chip).text)
                    binding.cgIdealWorkspace.removeView(c)
                    progressHud.show()
                    viewModel.addWorkSpace(ownedWorkSpaces){
                        progressHud.dismiss()
                        if (it != null){
                            toast("${it.message.toString()} Something went wrong")
                        }
                    }
                },{}).show()
            }
            chip.isCloseIconVisible = true
            chip.setCloseIconResource(R.drawable.close_white)
            chip.setCloseIconTintResource(R.color.white)
            binding.cgIdealWorkspace.addView(chip)
            binding.etIdealWorkspace.text.clear()
            progressHud.show()
            viewModel.addWorkSpace(ownedWorkSpaces){
                progressHud.dismiss()
                if (it != null){
                    toast("${it.message.toString()} Something went wrong")
                }
            }
        }
    }

}