package com.findajob.jobamax.jobseeker.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import com.findajob.jobamax.R
import com.findajob.jobamax.base.BaseFragmentMain
import com.findajob.jobamax.databinding.FragmentJobSeekerAccountBinding
import com.findajob.jobamax.databinding.FragmentSeekerProfileBinding
import com.findajob.jobamax.jobseeker.home.JobSeekerHomeViewModel
import com.findajob.jobamax.util.toast

import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipDrawable
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.coroutineScope
import org.json.JSONArray

@AndroidEntryPoint
class SeekerProfileFragment : BaseFragmentMain<FragmentSeekerProfileBinding>(), View.OnClickListener {

    override val layoutRes: Int get() = R.layout.fragment_seeker_profile
    val viewModel: JobSeekerHomeViewModel by activityViewModels()
    override fun getViewModel(): ViewModel = viewModel

    var ownedWorkSpaces = ArrayList<String>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentSeekerProfileBinding.inflate(inflater, container, false)
        configureUi()
        return binding.root
    }

    override fun onCreated(savedInstance: Bundle?) {
        if (viewModel.jobSeekerObject == null){
            progressHud.show()
            viewModel.getJobSeeker()
        }else{
            setProfile()
        }
        binding.jobSeeker = viewModel.jobSeeker
    }

    private fun configureUi() {
        setClickListeners()
        viewModelObserver()
    }

    private fun viewModelObserver() {
         viewModel.isJobSeekerUpdated.observe(viewLifecycleOwner, {
             progressHud.dismiss()
             if (it){
                 setProfile()
             }
         })
    }

    private fun setProfile() {
        binding.jobSeeker = viewModel.jobSeeker
        ownedWorkSpaces.clear()
        if (viewModel.jobSeeker.workspaces.isNotEmpty()) {
            val workSpaces = JSONArray(viewModel.jobSeeker.workspaces)
            var i = 0
            while (i < workSpaces.length()) {
                ownedWorkSpaces.add(workSpaces.getString(i))
                i++
            }
        }
        binding.cgIdealWorkspace.removeAllViews()
        ownedWorkSpaces.forEach {
            val chip = layoutInflater.inflate(
                R.layout.item_custom_chip,
                binding.cgIdealWorkspace,
                false
            ) as Chip
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
    }

    private fun setClickListeners() {
        binding.ivInfo.setOnClickListener(this)
        binding.ivBackButton.setOnClickListener(this)
        binding.ivAddIdealWorkspaceBtn.setOnClickListener(this)
        binding.tvAboutMeBtn.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.seekerAboutMeFragment, null))
        binding.ivUser.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.seekerAboutMeFragment, null))
        binding.clEducation.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.seekerEducationFragment, null))
        binding.clSkills.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.seekerMySkillFragment, null))
        binding.clInterest.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_seekerProfileFragment_to_seekerInterestFragment, null))
        binding.clJobs.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_seekerProfileFragment_to_seekerExperienceListFragment, null))
        binding.ivPreview.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_seekerProfileFragment_to_seekerPreviewFragment, null))
        binding.tvImportResumeBtn.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_seekerProfileFragment_to_seekerImportResumeFragment, null))
        binding.clVolunteering.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_seekerProfileFragment_to_seekerVolunteeringListFragment, null))


        binding.rlIdealJobVideo.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_seekerProfileFragment_to_idealJobVideoFragment, null))
        binding.rlIdealJobMessage.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_seekerProfileFragment_to_idealJobDescriptionFragment, null))
        binding.rlIdealJobImage.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_seekerProfileFragment_to_idealJobImagesFragment, null))
        binding.rlIdealJobAudio.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_seekerProfileFragment_to_idealJobAudioFragment, null))
        binding.rlPortfolioVideo.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_seekerProfileFragment_to_portfolioVideoFragment, null))
        binding.rlPortfolioMessage.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_seekerProfileFragment_to_portfolioDescriptionFragment, null))
        binding.rlPortfolioImage.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_seekerProfileFragment_to_portfolioImageFragment, null))
    }


    override fun onClick(view: View?) {
        when(view){
            binding.ivInfo -> {
                binding.ivInfo.performLongClick()
            }
            binding.ivBackButton -> {
                (activity as SeekerProfileActivity).onBackPressed()
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
        ownedWorkSpaces.add(binding.etIdealWorkspace.text.toString())
        val chip = layoutInflater.inflate(R.layout.item_custom_chip, binding.cgIdealWorkspace, false) as Chip
        chip.text = binding.etIdealWorkspace.text.toString()
        chip.setOnCloseIconClickListener { c ->
            ownedWorkSpaces.remove((c as Chip).text)
            binding.cgIdealWorkspace.removeView(c)
            progressHud.show()
            viewModel.addWorkSpace(ownedWorkSpaces){
                progressHud.dismiss()
                if (it != null){
                    toast("${it.message.toString()} Something went wrong")
                }
            }
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