package com.jobamax.appjobamax.recruiter.message

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.view.updatePadding
import androidx.fragment.app.DialogFragment
import com.google.gson.Gson
import com.jobamax.appjobamax.R
import com.jobamax.appjobamax.databinding.FragmentRecruiterRecruitmentSeekerProfileDialogBinding
import com.jobamax.appjobamax.enums.LinkType
import com.jobamax.appjobamax.jobseeker.build_profile.SeekerEducationAdapter
import com.jobamax.appjobamax.jobseeker.build_profile.SeekerExperienceListAdapter
import com.jobamax.appjobamax.jobseeker.build_profile.SeekerVolunteeringAdapter
import com.jobamax.appjobamax.model.*
import com.jobamax.appjobamax.recruiter.home.PortfolioLinksAdapter
import com.jobamax.appjobamax.recruiter.home.SeekerHardSkillAdapter
import com.jobamax.appjobamax.recruiter.model.RecruitmentSeeker
import com.jobamax.appjobamax.recruiter.search.PortfolioImageAdapter2
import com.jobamax.appjobamax.util.StudentStatus
import com.jobamax.appjobamax.util.loadImageFromUrl
import org.json.JSONArray
import org.json.JSONObject


class RecruiterRecruitmentSeekerProfileDialogFragment : DialogFragment() {
    lateinit var binding: FragmentRecruiterRecruitmentSeekerProfileDialogBinding

    var recruitmentSeeker: RecruitmentSeeker? = null
    val gson = Gson()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        recruitmentSeeker = arguments?.getSerializable("recruitment_seeker") as RecruitmentSeeker
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentRecruiterRecruitmentSeekerProfileDialogBinding.inflate(inflater, container, false)
        configureUi()
        return binding.root
    }

    private fun configureUi() {
        setClickListeners()
        setData()
    }

    private fun setData() {
        recruitmentSeeker?.let { rs ->
            binding.tvSeekerName.text = "${rs.firstName} ${rs.lastName}"
            binding.tvMatchedPer.text = "${rs.matchedPercentage}%"
            binding.tvJobLocation.text = rs.city.trim()
            loadImageFromUrl(binding.circleImageView, rs.profileURL, R.drawable.default_user_img)

            try {
                val university = gson.fromJson(JSONObject(rs.university).toString(), University::class.java)
                binding.tvUniversityName.text = university.name
                if (university.isCurrent) {
                    binding.tvEducation.text = StudentStatus.CURRENT.status
                } else {
                    binding.tvEducation.text = StudentStatus.NON_CURRENT.status
                }
            } catch (e: Exception) { }

            val experiences = arrayListOf<Experience>()
            val experienceJsonArray = JSONObject(rs.experiences).getJSONArray("list")
            for (i in 0 until experienceJsonArray.length()) {
                experiences.add(
                    gson.fromJson(
                        experienceJsonArray.getJSONObject(i).toString(),
                        Experience::class.java
                    )
                )
            }
            binding.rvExperience.adapter = SeekerExperienceListAdapter(experiences, requireActivity(), true)

            if (experiences.isNotEmpty()) {
                binding.tvJobName.text = "${experiences[0].job} - ${experiences[0].company}"
            }

            if (rs.interestedIn.isNotEmpty()) {
                binding.tvWorkTypes.text = rs.interestedIn.joinToString(", ")
            }

            binding.cgSoftSkillTags.removeAllViews()
            val softSkills = gson.fromJson(JSONArray(rs.softSkills).toString(), ArrayList::class.java)
            softSkills.forEach { tag ->
                binding.cgSoftSkillTags.addView(createChip(tag.toString()))
            }

            try {
                val hardSkills = arrayListOf<HardSkill>()
                val hardSkillsObject = JSONObject(rs.hardSkills)
                hardSkillsObject.keys().forEach {
                    hardSkills.add(HardSkill(it, hardSkillsObject.get(it).toString().toInt()))
                }
                binding.rvHardSkill.adapter = SeekerHardSkillAdapter(hardSkills, requireContext(), true)
            } catch (e: Exception) { }

            if (rs.elevatorPitch.isNotEmpty()) {
                binding.tvBio.text = rs.elevatorPitch
            }

            val educations = arrayListOf<Education>()
            val educationJsonArray = JSONObject(rs.educations).getJSONArray("list")
            for (i in 0 until educationJsonArray.length()) {
                educations.add(gson.fromJson(educationJsonArray.getJSONObject(i).toString(), Education::class.java))
            }
            binding.rvEducation.adapter = SeekerEducationAdapter(educations, requireActivity(), true)

            try {
                val volunteerings = arrayListOf<Volunteering>()
                val volunteeringJsonArray =
                    JSONObject(rs.volunteerings).getJSONArray("list")
                for (i in 0 until volunteeringJsonArray.length()) {
                    volunteerings.add(gson.fromJson(volunteeringJsonArray.getJSONObject(i).toString(), Volunteering::class.java))
                }
                binding.rvVolunteering.adapter = SeekerVolunteeringAdapter(volunteerings, requireActivity(), true)
            } catch (e: Exception) { }

            binding.cgInterests.removeAllViews()
            rs.interests.forEach { tag ->
                binding.cgInterests.addView(createChip(tag))
            }

            binding.rvPortfolioLink.adapter = PortfolioLinksAdapter(
                rs.portfolioLinks as ArrayList<String>,
                isStaticView = true,
                requireContext(),
                showIcon = false,
                LinkType.Link.value
            )
            binding.rvPortfolioDocLink.adapter = PortfolioLinksAdapter(
                rs.portfolioDocLinks as ArrayList<String>,
                isStaticView = true,
                requireContext(),
                showIcon = false,
                LinkType.Doc.value
            )

            binding.cgWorkspace.removeAllViews()
            rs.workspaces.forEach { tag ->
                binding.cgWorkspace.addView(createChip(tag))
            }

            binding.rvPortfolioImages.adapter = PortfolioImageAdapter2(rs.images)
        }
    }



    private fun createChip(tag: String): View {
        val chip: View = layoutInflater.inflate(R.layout.item_chip_white_box_gradient_border, null, false)
        val tvContract = chip.findViewById<TextView>(R.id.tv_tag)
        tvContract.text = tag
        tvContract.background = resources.getDrawable(R.drawable.rounded_white_box_gradient_border_50, null)
        tvContract.updatePadding(30, 0, 30, 0)
        tvContract.setTextColor(resources.getColor(R.color.navi_blue, null))
        return chip
    }

    private fun setClickListeners() {
        binding.ivClose.setOnClickListener { dismiss() }
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    }

    companion object {
        fun getInstance(rs: RecruitmentSeeker) : RecruiterRecruitmentSeekerProfileDialogFragment {
            val fragment = RecruiterRecruitmentSeekerProfileDialogFragment()
            val bundle = Bundle()
            bundle.putSerializable("recruitment_seeker", rs)
            fragment.arguments = bundle
            return fragment
        }
    }

 }