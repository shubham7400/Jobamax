package com.jobamax.appjobamax.jobseeker.build_profile

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.google.gson.Gson
import com.jobamax.appjobamax.R
import com.jobamax.appjobamax.base.BaseFragment
import com.jobamax.appjobamax.databinding.FragmentProfilePreviewBinding
import com.jobamax.appjobamax.extensions.toast
import com.jobamax.appjobamax.jobseeker.JobSeekerHomeActivity
import com.jobamax.appjobamax.jobseeker.view_model.SeekerHomeViewModel
import com.jobamax.appjobamax.model.*
import com.jobamax.appjobamax.preference.setSeenOnBoarding
import com.jobamax.appjobamax.recruiter.home.PortfolioLinksAdapter
import com.jobamax.appjobamax.recruiter.home.SeekerHardSkillAdapter
import com.jobamax.appjobamax.recruiter.search.PortfolioImageAdapter2
import com.jobamax.appjobamax.util.loadImageFromUrl
import com.jobamax.appjobamax.util.openLink
import org.json.JSONArray
import org.json.JSONObject


class ProfilePreviewFragment : BaseFragment() {
    lateinit var binding: FragmentProfilePreviewBinding

    val viewModel: SeekerHomeViewModel by activityViewModels()

    lateinit var jobSeeker: JobSeeker

    lateinit var portfolioLinksAdapter: PortfolioLinksAdapter
    lateinit var portfolioDocLinkAdapter: PortfolioLinksAdapter

    var experiences = ArrayList<Experience>()
    private lateinit var experienceAdapter: SeekerExperienceListAdapter

    private lateinit var educationAdapter: SeekerEducationAdapter
    private var educations = ArrayList<Education>()

    lateinit var volunteeringAdapter: SeekerVolunteeringAdapter
    var volunteerings = ArrayList<Volunteering>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentProfilePreviewBinding.inflate(inflater, container, false)
        configureUi()
        return binding.root
    }

    private fun configureUi() {
        setClickListeners()
        setObserver()
        setJobSeeker()
        setExperienceAdapter()
        setEducationAdapter()
        setVolunteeringAdapter()
        setData()
    }

    private fun setJobSeeker() {
        jobSeeker = viewModel.jobSeeker
        if (viewModel.jobSeekerObject == null) {
            (requireActivity() as BuildProfileActivity).getJobSeeker {
                if (it) {
                    jobSeeker = viewModel.jobSeeker
                    setData()
                }
            }
        }
    }

    private fun setObserver() {
        viewModel.isJobSeekerUpdated.observe(viewLifecycleOwner){
            if (it){
                setData()
            }
        }
    }

    private fun setData() {
        loadImageFromUrl(binding.circleImageView, jobSeeker.profilePicUrl, R.drawable.default_user_img)

        binding.tvBio.text = jobSeeker.elevatorPitch

        binding.tvUserName.text = "${jobSeeker.firstName} ${jobSeeker.lastName}"

        if (jobSeeker.interestedIn.isEmpty()){
            binding.llInterestedIn.visibility = View.GONE
        }else{
            binding.llInterestedIn.visibility = View.VISIBLE
            binding.tvInterestedIn.text = jobSeeker.interestedIn.joinToString()
        }



        val loc = gson.fromJson(jobSeeker.jobLocation, Location::class.java)
        if (loc == null){
            binding.llJobLocation.visibility = View.GONE
        }else{
            binding.llJobLocation.visibility = View.VISIBLE
            loc.let { binding.tvCity.text = loc.city }
        }

        if (jobSeeker.profession.isEmpty()){
            binding.llProfession.visibility = View.GONE
        }else{
            binding.llProfession.visibility = View.VISIBLE
            binding.tvProfession.text = jobSeeker.profession
        }

        binding.cgInterests.removeAllViews()
        jobSeeker.interests.forEach { binding.cgInterests.addView(createChip(it)) }

        binding.cgWorkspace.removeAllViews()
        jobSeeker.workspaces.forEach { binding.cgWorkspace.addView(createChip(it)) }

        experiences = jobSeeker.experiences
        experienceAdapter.submitList(experiences)
        experienceAdapter.notifyDataSetChanged()

        educations = jobSeeker.educations
        educationAdapter.submitList(educations)
        educationAdapter.notifyDataSetChanged()

        volunteerings = jobSeeker.volunteerings
        volunteeringAdapter.submitList(volunteerings)
        volunteeringAdapter.notifyDataSetChanged()

        if (educations.isEmpty()){
            binding.llUniversity.visibility = View.GONE
        }else{
            binding.llUniversity.visibility = View.VISIBLE
            binding.tvUniversityName.text = educations[0].name
        }

        if (jobSeeker.portfolioLinks.isEmpty() && jobSeeker.portfolioDocLinks.isEmpty()){
            binding.llPortfolioLinks.visibility = View.GONE
            binding.tvPortfolioHint.visibility = View.VISIBLE
        }else{
            binding.tvPortfolioHint.visibility = View.GONE

            if (jobSeeker.portfolioDocLinks.isEmpty()){
                binding.llDocLinks.visibility = View.GONE
            }else{
                binding.llDocLinks.visibility = View.VISIBLE
                portfolioDocLinkAdapter = PortfolioLinksAdapter(ArrayList(jobSeeker.portfolioDocLinks) , true)
                binding.rvPortfolioDocLink.adapter = portfolioDocLinkAdapter
                portfolioDocLinkAdapter.onLinkClick = {
                    try { openLink(it) }catch (e: Exception){toast("${e.message.toString()} Something went wrong")}
                }
            }

            if (jobSeeker.portfolioLinks.isEmpty()){
                binding.llLinks.visibility = View.GONE
            }else{
                binding.llLinks.visibility = View.VISIBLE
                portfolioLinksAdapter = PortfolioLinksAdapter(ArrayList(jobSeeker.portfolioLinks) , true)
                binding.rvPortfolioLink.adapter = portfolioLinksAdapter
                portfolioLinksAdapter.onLinkClick = {
                    try { openLink(it) }catch (e: Exception){toast("${e.message.toString()} Something went wrong")}
                }
            }
        }

        // hard skills
        val ownedHardSkills = jobSeeker.hardSkills

        binding.rvHardSkill.adapter = SeekerHardSkillAdapter(ownedHardSkills, requireContext(), true)


        // soft skills
        val ownedSoftSkills = jobSeeker.softSkills
        binding.cgSoftSkill.removeAllViews()
        ownedSoftSkills.forEach { binding.cgSoftSkill.addView(createChip(it)) }

        if (ownedHardSkills.isEmpty() && ownedSoftSkills.isEmpty()){
            binding.tvSkillHint.visibility = View.VISIBLE
        }else{
            binding.tvSkillHint.visibility = View.GONE
            if (ownedHardSkills.isEmpty()){
                binding.llHardSkill.visibility = View.GONE
            }else{
                binding.llHardSkill.visibility = View.VISIBLE
            }
            if (ownedSoftSkills.isEmpty()){
                binding.llSoftSkill.visibility = View.GONE
            }else{
                binding.llSoftSkill.visibility = View.VISIBLE
            }
        }

        //portfolio images
        val images = ArrayList(jobSeeker.images)
        images.add("")
        val portfolioImageAdapter2 = PortfolioImageAdapter2(images )
        binding.rvPortfolioImages.adapter = portfolioImageAdapter2
        portfolioImageAdapter2.onAddMoreClick = {
            findNavController().navigate(R.id.action_profilePreviewFragment_to_modifyProfileFragment, null)
        }

    }

    private fun createChip(label: String): View {
        val chip: View = layoutInflater.inflate(R.layout.item_chip_white_box_gradient_border, null, false)
        chip.findViewById<TextView>(R.id.tv_tag).text = label
        return chip
    }

    private fun setExperienceAdapter() {
        experienceAdapter = SeekerExperienceListAdapter(experiences, requireContext(), true)
        binding.rvExperience.adapter = experienceAdapter
    }

    private fun setEducationAdapter() {
        educationAdapter = SeekerEducationAdapter(educations, requireContext(), true)
        binding.rvEducation.adapter = educationAdapter
    }

    private fun setVolunteeringAdapter() {
        volunteeringAdapter = SeekerVolunteeringAdapter(volunteerings, requireContext(), true)
        binding.rvVolunteering.adapter = volunteeringAdapter
    }

    private fun setClickListeners() {
         binding.btnModify.setOnClickListener {
             findNavController().navigate(R.id.action_profilePreviewFragment_to_modifyProfileFragment, null)
         }
         binding.btnValidate.setOnClickListener {
             viewModel.jobSeekerObject?.put("seenOnboarding", true)
             viewModel.jobSeekerObject?.saveInBackground { it ->
                 if (it == null){
                    (requireActivity() as BuildProfileActivity).getJobSeeker { it1 ->
                        if (it1){
                            requireContext().setSeenOnBoarding(true)
                            startActivity(Intent(requireContext(), JobSeekerHomeActivity::class.java))
                            requireActivity().finish()
                        }
                    }
                }else{
                    toast(it.message.toString())
                }
             }
         }

        binding.tvAddInterestHint.setOnClickListener {
            findNavController().navigate(R.id.action_profilePreviewFragment_to_modifyProfileFragment, null)
        }
        binding.tvAddWorkspaceHint.setOnClickListener {
            findNavController().navigate(R.id.action_profilePreviewFragment_to_modifyProfileFragment, null)
        }
        binding.clVideo.setOnClickListener {
            findNavController().navigate(R.id.action_profilePreviewFragment_to_videoDemoFragment, null)
        }
        binding.clAudio.setOnClickListener {
            findNavController().navigate(R.id.action_profilePreviewFragment_to_audioDemoFragment, null)
        }
    }

}