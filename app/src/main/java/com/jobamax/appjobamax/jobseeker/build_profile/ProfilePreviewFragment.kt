package com.jobamax.appjobamax.jobseeker.build_profile

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.jobamax.appjobamax.R
import com.jobamax.appjobamax.base.BaseFragment
import com.jobamax.appjobamax.databinding.FragmentProfilePreviewBinding
import com.jobamax.appjobamax.dialog.BuildProfileSuggestionDialog
import com.jobamax.appjobamax.dialog.SkillSuggestionDialog
import com.jobamax.appjobamax.dialog.SimpleMessageDialog
import com.jobamax.appjobamax.enums.LinkType
import com.jobamax.appjobamax.extensions.toast
import com.jobamax.appjobamax.jobseeker.JobSeekerHomeActivity
import com.jobamax.appjobamax.jobseeker.view_model.SeekerHomeViewModel
import com.jobamax.appjobamax.model.*
import com.jobamax.appjobamax.preference.setSeenOnBoarding
import com.jobamax.appjobamax.recruiter.home.PortfolioLinksAdapter
import com.jobamax.appjobamax.recruiter.home.SeekerHardSkillAdapter
import com.jobamax.appjobamax.recruiter.search.PortfolioImageAdapter2
import com.jobamax.appjobamax.util.*


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

        if ((requireActivity() as BuildProfileActivity).showBuildProfileSuggestionDialog) {
            BuildProfileSuggestionDialog(requireActivity()).show()
            (requireActivity() as BuildProfileActivity).showBuildProfileSuggestionDialog = false
        }
        binding.tvProfileMatchPer.paint.shader = getShader(binding.tvProfileMatchPer)
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


        binding.cgInterests.removeAllViews()
        jobSeeker.interests.forEach { binding.cgInterests.addView(createChip(it)) }

        binding.cgWorkspace.removeAllViews()
        jobSeeker.workspaces.forEach { binding.cgWorkspace.addView(createChip(it)) }

        experiences = jobSeeker.experiences
        experienceAdapter.submitList(experiences)
        experienceAdapter.notifyDataSetChanged()

        if (experiences.isNotEmpty()){
            binding.tvProfession.text = experiences[0].job+" - "+experiences[0].company
        }else{
            binding.tvProfession.text = jobSeeker.profession.ifEmpty { "-" }
        }

        educations = jobSeeker.educations
        educationAdapter.submitList(educations)
        educationAdapter.notifyDataSetChanged()

        volunteerings = jobSeeker.volunteerings
        volunteeringAdapter.submitList(volunteerings)
        volunteeringAdapter.notifyDataSetChanged()

        val university = gson.fromJson(jobSeeker.university, University::class.java)
        university?.let {
            if (it.isCurrent) {
                binding.tvUniversityStatus.text = StudentStatus.CURRENT.status
            } else {
                binding.tvUniversityStatus.text = StudentStatus.NON_CURRENT.status
            }
        }

        if (educations.isEmpty()){
            university?.let {
                binding.tvUniversityName.text = it.name
            }
        }else{
            binding.tvUniversityName.text = educations[0].name.ifEmpty { "-" }
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
                portfolioDocLinkAdapter = PortfolioLinksAdapter(
                    ArrayList(jobSeeker.portfolioDocLinks),
                    isStaticView = true,
                    requireContext(),
                    false,
                    LinkType.Doc.value
                )
                binding.rvPortfolioDocLink.adapter = portfolioDocLinkAdapter
                portfolioDocLinkAdapter.onLinkClick = {
                    try { openLink(it) }catch (e: Exception){toast("${e.message.toString()} Something went wrong")}
                }
            }

            if (jobSeeker.portfolioLinks.isEmpty()){
                binding.llLinks.visibility = View.GONE
            }else{
                binding.llLinks.visibility = View.VISIBLE
                portfolioLinksAdapter = PortfolioLinksAdapter(
                    ArrayList(jobSeeker.portfolioLinks),
                    isStaticView = true,
                    requireContext(),
                    showIcon = false,
                    LinkType.Link.value
                )
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

        binding.tvProfileMatchPer.text = "complété à ${calculateCompleteProfile(jobSeeker)}%"
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
        binding.ivBackButton.setOnClickListener { requireActivity().onBackPressed() }
        binding.ivVolunterringInfo.setOnClickListener {
            SimpleMessageDialog(requireActivity(), "Ajoute des experiences en tant que bénévole peut importe l'âge.").show()
        }
        binding.ivPortfolioInfo.setOnClickListener {
            SimpleMessageDialog(requireActivity(), "Montre tes projects pro, concours, photos d'quipes, Diplômes ou parle tout simplement de tes réalisations.").show()
        }
        binding.ivSkillInfo.setOnClickListener {
            SkillSuggestionDialog(requireActivity()).show()
        }
         binding.btnModify.setOnClickListener {
             findNavController().navigate(R.id.action_profilePreviewFragment_to_modifyProfileFragment, null)
         }
         binding.btnValidate.setOnClickListener {
             validate()
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

    private fun validate() {
        viewModel.jobSeekerObject?.put("seenOnboarding", true)
        viewModel.jobSeekerObject?.saveInBackground { it ->
            try {
                if (it == null) {
                    (requireActivity() as BuildProfileActivity).getJobSeeker { it1 ->
                        requireContext().setSeenOnBoarding(true)
                        startActivity(Intent(requireContext(), JobSeekerHomeActivity::class.java))
                        requireActivity().finish()
                    }
                } else {
                    toast(it.message.toString())
                }
            }catch (e: Exception){}
        }
    }

}