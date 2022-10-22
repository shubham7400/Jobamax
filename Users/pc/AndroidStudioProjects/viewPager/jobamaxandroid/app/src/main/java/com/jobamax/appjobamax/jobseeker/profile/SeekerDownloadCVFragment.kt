package com.jobamax.appjobamax.jobseeker.profile

import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.LayerDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.ContextThemeWrapper
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.jobamax.appjobamax.R
import com.jobamax.appjobamax.base.BaseFragment
import com.jobamax.appjobamax.databinding.*
import com.jobamax.appjobamax.dialog.YesNoDialog
import com.jobamax.appjobamax.enums.SeekerProfileTheme
import com.jobamax.appjobamax.extensions.log
import com.jobamax.appjobamax.jobseeker.build_profile.SeekerEducationAdapter
import com.jobamax.appjobamax.jobseeker.build_profile.SeekerExperienceListAdapter
import com.jobamax.appjobamax.jobseeker.build_profile.SeekerVolunteeringAdapter
import com.jobamax.appjobamax.jobseeker.search.ManualAndPersonalizeActivity
import com.jobamax.appjobamax.jobseeker.view_model.SeekerHomeViewModel
import com.jobamax.appjobamax.model.*
import com.jobamax.appjobamax.preference.getThemeColor
import com.jobamax.appjobamax.preference.getViewOrder
import com.jobamax.appjobamax.preference.setThemeColor
import com.jobamax.appjobamax.recruiter.home.PortfolioLinksAdapter
import com.jobamax.appjobamax.recruiter.home.SeekerHardSkillAdapter
import com.jobamax.appjobamax.util.*
import org.json.JSONObject
import java.lang.reflect.Type
import kotlin.collections.ArrayList


class SeekerDownloadCVFragment : BaseFragment() {
    lateinit var mainBinding: FragmentSeekerDownloadCvBinding

    private lateinit var bioBinding: ItemProfileBioBinding
    private lateinit var educationBinding: ItemProfileEducationBinding
    private lateinit var experienceBinding: ItemProfileExperienceBinding
    private lateinit var skillBinding: ItemProfileSkillBinding
    private lateinit var volunteeringBinding: ItemProfileVolunteeringBinding
    private lateinit var portfolioBinding: ItemProfilePortfolioBinding
    private lateinit var idealWorkspaceBinding: ItemProfileIdealWorkspaceBinding
    private lateinit var interestBinding: ItemProfileInterestBinding
    private lateinit var imagesBinding: ItemProfileImagesBinding


    val viewModel: SeekerHomeViewModel by activityViewModels()

    lateinit var jobSeeker: JobSeeker

    lateinit var hardSkillAdapter: SeekerHardSkillAdapter
    private var ownedHardSkills = ArrayList<HardSkill>()
    private var ownedSoftSkills = ArrayList<String>()

    var experiences = ArrayList<Experience>()
    private lateinit var experienceAdapter: SeekerExperienceListAdapter

    private lateinit var educationAdapter: SeekerEducationAdapter
    private var educations = ArrayList<Education>()

    lateinit var volunteeringAdapter: SeekerVolunteeringAdapter
    var volunteerings = ArrayList<Volunteering>()

    lateinit var imagesAdapter: ImageAdapter
    var imagesUrl = ArrayList<String>()

    private val imageViewAndDrawableIdMap = hashMapOf<Int, ImageView>()

    private var layoutIds = ArrayList<Int>()
    var list = ArrayList<View>()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        mainBinding = FragmentSeekerDownloadCvBinding.inflate(inflater, container, false)
        configureUi()
        return mainBinding.root
    }


    private fun configureUi() {
        setLayoutIds()
        confirmAllLayoutIds()
        setChildViews()
        setClickListeners()
        setObserver()
        setJobSeeker()
        setExperienceAdapter()
        setEducationAdapter()
        setVolunteeringAdapter()
        setHardSkillAdapter()
        setImageAdapter()

        imageViewAndDrawableIdMap[R.drawable.ic_search_gradient] = bioBinding.ivSearch
        imageViewAndDrawableIdMap[R.drawable.ic_education] = bioBinding.ivCollage
        imageViewAndDrawableIdMap[R.drawable.ic_bag_gradient] = bioBinding.ivJobPost
        imageViewAndDrawableIdMap[R.drawable.ic_location] = bioBinding.ivLocationPoint
        imageViewAndDrawableIdMap[R.drawable.ic_student_gradient] = bioBinding.ivEducation

        setData()
    }

    private fun confirmAllLayoutIds() {
        if (!layoutIds.contains(R.layout.item_profile_bio))
            layoutIds.add(R.layout.item_profile_bio)
        if (!layoutIds.contains(R.layout.item_profile_education))
            layoutIds.add(R.layout.item_profile_education)
        if (!layoutIds.contains(R.layout.item_profile_experience))
            layoutIds.add(R.layout.item_profile_experience)
        if (!layoutIds.contains(R.layout.item_profile_interest))
            layoutIds.add(R.layout.item_profile_interest)
        if (!layoutIds.contains(R.layout.item_profile_portfolio))
            layoutIds.add(R.layout.item_profile_portfolio)
        if (!layoutIds.contains(R.layout.item_profile_ideal_workspace))
            layoutIds.add(R.layout.item_profile_ideal_workspace)
        if (!layoutIds.contains(R.layout.item_profile_skill))
            layoutIds.add(R.layout.item_profile_skill)
        if (!layoutIds.contains(R.layout.item_profile_volunteering))
            layoutIds.add(R.layout.item_profile_volunteering)
        if (!layoutIds.contains(R.layout.item_profile_images))
            layoutIds.add(R.layout.item_profile_images)
    }


    private fun setLayoutIds() {
        layoutIds.clear()
        if (requireContext().getViewOrder() != "") {
            val type: Type = object : TypeToken<ArrayList<Int>>() {}.type
            val ids: List<Int> = gson.fromJson(requireContext().getViewOrder(), type)
            ids.forEach {
                layoutIds.add(it)
            }
        } else {
            layoutIds.add(R.layout.item_profile_bio)
            layoutIds.add(R.layout.item_profile_education)
            layoutIds.add(R.layout.item_profile_experience)
            layoutIds.add(R.layout.item_profile_interest)
            layoutIds.add(R.layout.item_profile_portfolio)
            layoutIds.add(R.layout.item_profile_ideal_workspace)
            layoutIds.add(R.layout.item_profile_skill)
            layoutIds.add(R.layout.item_profile_volunteering)
            layoutIds.add(R.layout.item_profile_images)
        }
    }


    private fun setCardVisibility() {
        if (jobSeeker.educations.isEmpty())
            educationBinding.clParent.visibility = View.GONE
        else
            educationBinding.clParent.visibility = View.VISIBLE

        if (jobSeeker.experiences.isEmpty())
            experienceBinding.clParent.visibility = View.GONE
        else
            experienceBinding.clParent.visibility = View.VISIBLE

        if (jobSeeker.volunteerings.isEmpty())
            volunteeringBinding.clParent.visibility = View.GONE
        else
            volunteeringBinding.clParent.visibility = View.VISIBLE

        if (jobSeeker.interests.isEmpty())
            interestBinding.clParent.visibility = View.GONE
        else
            interestBinding.clParent.visibility = View.VISIBLE

        if (jobSeeker.workspaces.isEmpty())
            idealWorkspaceBinding.clParent.visibility = View.GONE
        else
            idealWorkspaceBinding.clParent.visibility = View.VISIBLE

        if (jobSeeker.hardSkills.isEmpty() && jobSeeker.softSkills.isEmpty())
            skillBinding.clParent.visibility = View.GONE
        else
            skillBinding.clParent.visibility = View.VISIBLE

        if (jobSeeker.portfolioDocLinks.isEmpty() && jobSeeker.portfolioLinks.isEmpty())
            portfolioBinding.clParent.visibility = View.GONE
        else
            portfolioBinding.clParent.visibility = View.VISIBLE

        if (jobSeeker.images.isEmpty())
            imagesBinding.clParent.visibility = View.GONE
        else
            imagesBinding.clParent.visibility = View.VISIBLE

    }


    private fun setChildViews() {
        list.clear()
        mainBinding.llParent.removeAllViews()
        layoutIds.forEach { layoutId ->
            when (layoutId) {
                R.layout.item_profile_bio -> {
                    bioBinding = ItemProfileBioBinding.inflate(layoutInflater, null, false)
                    bioBinding.root.tag = R.layout.item_profile_bio
                    list.add(bioBinding.root)
                    mainBinding.llParent.addView(bioBinding.root)
                }
                R.layout.item_profile_education -> {
                    educationBinding =
                        ItemProfileEducationBinding.inflate(layoutInflater, null, false)
                    educationBinding.root.tag = R.layout.item_profile_education
                    list.add(educationBinding.root)
                    mainBinding.llParent.addView(educationBinding.root)
                }
                R.layout.item_profile_experience -> {
                    experienceBinding =
                        ItemProfileExperienceBinding.inflate(layoutInflater, null, false)
                    experienceBinding.root.tag = R.layout.item_profile_experience
                    list.add(experienceBinding.root)
                    mainBinding.llParent.addView(experienceBinding.root)
                }
                R.layout.item_profile_interest -> {
                    interestBinding =
                        ItemProfileInterestBinding.inflate(layoutInflater, null, false)
                    interestBinding.root.tag = R.layout.item_profile_interest
                    list.add(interestBinding.root)
                    mainBinding.llParent.addView(interestBinding.root)
                }
                R.layout.item_profile_portfolio -> {
                    portfolioBinding =
                        ItemProfilePortfolioBinding.inflate(layoutInflater, null, false)
                    portfolioBinding.root.tag = R.layout.item_profile_portfolio
                    list.add(portfolioBinding.root)
                    mainBinding.llParent.addView(portfolioBinding.root)
                }
                R.layout.item_profile_ideal_workspace -> {
                    idealWorkspaceBinding =
                        ItemProfileIdealWorkspaceBinding.inflate(layoutInflater, null, false)
                    idealWorkspaceBinding.root.tag = R.layout.item_profile_ideal_workspace
                    list.add(idealWorkspaceBinding.root)
                    mainBinding.llParent.addView(idealWorkspaceBinding.root)
                }
                R.layout.item_profile_skill -> {
                    skillBinding = ItemProfileSkillBinding.inflate(layoutInflater, null, false)
                    skillBinding.root.tag = R.layout.item_profile_skill
                    list.add(skillBinding.root)
                    mainBinding.llParent.addView(skillBinding.root)
                }
                R.layout.item_profile_volunteering -> {
                    volunteeringBinding = ItemProfileVolunteeringBinding.inflate(layoutInflater, null, false)
                    volunteeringBinding.root.tag = R.layout.item_profile_volunteering
                    list.add(volunteeringBinding.root)
                    mainBinding.llParent.addView(volunteeringBinding.root)
                }
                R.layout.item_profile_images -> {
                    imagesBinding = ItemProfileImagesBinding.inflate(layoutInflater, null, false)
                    imagesBinding.root.tag = R.layout.item_profile_images
                    list.add(imagesBinding.root)
                    mainBinding.llParent.addView(imagesBinding.root)
                }
            }
        }
    }


    private fun setTheme() {
        when (requireContext().getThemeColor()) {
            SeekerProfileTheme.SALMON.colorName -> {
                mainBinding.ivThemeIconSalmon.performClick()
            }
            SeekerProfileTheme.BLUE.colorName -> {
                mainBinding.ivThemeIconBlue.performClick()
            }
            SeekerProfileTheme.AQUAMARINE.colorName -> {
                mainBinding.ivThemeIconAquamarine.performClick()
            }
            SeekerProfileTheme.SALMON_LIGHT.colorName -> {
                mainBinding.ivThemeIconLightSalmon.performClick()
            }
            SeekerProfileTheme.GREEN.colorName -> {
                mainBinding.ivThemeIconGreen.performClick()
            }
            SeekerProfileTheme.YELLOW.colorName -> {
                mainBinding.ivThemeIconYellow.performClick()
            }
            SeekerProfileTheme.RED.colorName -> {
                mainBinding.ivThemeIconRed.performClick()
            }
            SeekerProfileTheme.GREY.colorName -> {
                mainBinding.ivThemeIconGrey.performClick()
            }
            SeekerProfileTheme.NORMAL.colorName -> {
                mainBinding.ivThemeIconNormal.performClick()
            }
        }
    }

    private fun changeSingleIconTheme(imageView: ImageView, drawableId: Int, themeId: Int) {
        val wrapper = ContextThemeWrapper(requireContext(), themeId)
        val drawable = ResourcesCompat.getDrawable(resources, drawableId, wrapper.theme)
        imageView.setImageDrawable(drawable)
    }

    private fun setJobSeeker() {
        jobSeeker = viewModel.jobSeeker
        if (viewModel.jobSeekerObject == null) {
            try {
                (requireActivity() as ManualAndPersonalizeActivity).getJobSeeker {
                    if (it) {
                        jobSeeker = viewModel.jobSeeker
                        setData()
                    }
                }
            } catch (e: Exception) {
                (requireActivity() as SeekerCreateCvActivity).getJobSeeker {
                    if (it) {
                        jobSeeker = viewModel.jobSeeker
                        setData()
                    }
                }
            }
        }
    }

    private fun setObserver() {
        viewModel.isJobSeekerUpdated.observe(viewLifecycleOwner) {
            if (it) {
                jobSeeker = viewModel.jobSeeker
                setData()
            }
        }
    }

    private fun setData() {
        loadImageFromUrl(
            bioBinding.circleImageView,
            jobSeeker.profilePicUrl,
            R.drawable.default_user_img
        )
        if (jobSeeker.firstName.isEmpty()) {
            bioBinding.tvUserName.visibility = View.GONE
            bioBinding.tvUserName.text = jobSeeker.firstName + " " + jobSeeker.lastName
        } else {
            bioBinding.tvUserName.visibility = View.VISIBLE
            bioBinding.tvUserName.text = jobSeeker.firstName + " " + jobSeeker.lastName
        }
        if (jobSeeker.university.isEmpty()) {
            bioBinding.llUniversity.visibility = View.GONE
            bioBinding.tvUniversityName.text = jobSeeker.university
        } else {
            bioBinding.llUniversity.visibility = View.VISIBLE
            val university = gson.fromJson(jobSeeker.university, University::class.java)
            if (university != null) {
                bioBinding.tvUniversityName.text = university.name
            }
        }
        if (jobSeeker.interestedIn.isNotEmpty()) {
            bioBinding.llInterestedIn.visibility = View.VISIBLE
            bioBinding.tvInterestedIn.text = jobSeeker.interestedIn.joinToString(", ")
        } else {
            bioBinding.llInterestedIn.visibility = View.GONE
        }
        try {
            if (jobSeeker.jobLocation.isNotEmpty()) {
                val jobLocation = gson.fromJson(
                    JSONObject(jobSeeker.jobLocation).toString(),
                    JobLocation::class.java
                )
                bioBinding.llJobLocation.visibility = View.VISIBLE
                bioBinding.tvJobLocation.text = jobLocation.city
            } else {
                bioBinding.llJobLocation.visibility = View.GONE
            }
        } catch (e: Exception) {
        }
        try {
            val university =
                gson.fromJson(JSONObject(jobSeeker.university).toString(), University::class.java)
            bioBinding.tvEducation.text = university.name
            if (university.isCurrent) {
                bioBinding.tvEducation.text = StudentStatus.CURRENT.status
            } else {
                bioBinding.tvEducation.text = StudentStatus.NON_CURRENT.status
            }
        } catch (e: Exception) {
            bioBinding.llEducation.visibility = View.GONE
        }


        experiences = jobSeeker.experiences
        experienceAdapter.submitList(experiences)
        experienceAdapter.notifyDataSetChanged()

        if (experiences.isNotEmpty()) {
            bioBinding.llJobTitle.visibility = View.VISIBLE
            bioBinding.tvJobName.text = "${experiences[0].job} - ${experiences[0].company}"
        } else {
            bioBinding.llJobTitle.visibility = View.GONE
        }

        imagesUrl = jobSeeker.images
        imagesAdapter.submitList(imagesUrl)
        imagesAdapter.notifyDataSetChanged()

        educations = jobSeeker.educations
        educationAdapter.submitList(educations)
        educationAdapter.notifyDataSetChanged()

        volunteerings = jobSeeker.volunteerings
        volunteeringAdapter.submitList(volunteerings)
        volunteeringAdapter.notifyDataSetChanged()

        bioBinding.tvBio.text = jobSeeker.elevatorPitch

        setSoftSkillTags(R.color.theme_light_blue, R.color.theme_dark_blue)

        ownedHardSkills = jobSeeker.hardSkills
        hardSkillAdapter.submitList(ownedHardSkills)
        hardSkillAdapter.notifyDataSetChanged()

        setInterestTags(R.color.theme_light_blue, R.color.theme_dark_blue)
        setWorkspaceTags(R.color.theme_light_blue, R.color.theme_dark_blue)

        setPortfolio()

        setTheme()

        setCardVisibility()
    }

    private fun setPortfolio() {
        val portfolioDocLinks = ArrayList(jobSeeker.portfolioDocLinks)
        val portfolioDocLinkAdapter = PortfolioLinksAdapter(portfolioDocLinks)
        portfolioBinding.rvPortfolioDocLink.adapter = portfolioDocLinkAdapter

        val portfolioLinks = ArrayList(jobSeeker.portfolioLinks)
        val portfolioLinkAdapter = PortfolioLinksAdapter(portfolioLinks)
        portfolioBinding.rvPortfolioLink.adapter = portfolioLinkAdapter
    }

    private fun setSoftSkillTags(firstColor: Int, secondColor: Int) {
        skillBinding.cgSoftSkill.removeAllViews()
        getOwnedSoftSkills()
        ownedSoftSkills.forEach {
            skillBinding.cgSoftSkill.addView(
                createChip(
                    it,
                    firstColor,
                    secondColor
                )
            )
        }
    }

    private fun setWorkspaceTags(firstColor: Int, secondColor: Int) {
        idealWorkspaceBinding.cgWorkspace.removeAllViews()
        jobSeeker.workspaces.forEach {
            idealWorkspaceBinding.cgWorkspace.addView(
                createChip(
                    it,
                    firstColor,
                    secondColor
                )
            )
        }
    }

    private fun setInterestTags(firstColor: Int, secondColor: Int) {
        interestBinding.cgInterests.removeAllViews()
        jobSeeker.interests.forEach {
            interestBinding.cgInterests.addView(
                createChip(
                    it,
                    firstColor,
                    secondColor
                )
            )
        }
    }

    private fun setHardSkillAdapter() {
        hardSkillAdapter = SeekerHardSkillAdapter(ownedHardSkills, requireContext(), true)
        skillBinding.rvHardSkill.adapter = hardSkillAdapter
        hardSkillAdapter.clickListener = {
            YesNoDialog(requireActivity(), resources.getString(R.string.are_you_sure), {
                ownedHardSkills.remove(it)
                hardSkillAdapter.submitList(ownedHardSkills)
                hardSkillAdapter.notifyDataSetChanged()
            }, {}).show()
        }
        hardSkillAdapter.skillLevelChangeListener = { hardSkill, skillLevelNewValue ->
            val index = ownedHardSkills.indexOf(hardSkill)
            if (ownedHardSkills.indexOf(hardSkill) != -1) {
                ownedHardSkills[index].skillLevel = skillLevelNewValue
            }
        }
    }

    private fun getOwnedSoftSkills() {
        ownedSoftSkills = jobSeeker.softSkills
    }

    private fun createChip(label: String, firstColor: Int, secondColor: Int): View {
        val chip = layoutInflater.inflate(R.layout.item_chip_white_box_gradient_border, null, false)
        val tag = chip.findViewById<TextView>(R.id.tv_tag)
        tag.text = label
        changeStrokeColor(tag, firstColor, secondColor)
        return chip
    }

    private fun changeStrokeColor(tag: View, firstColor: Int, secondColor: Int) {
        val drawable = tag.background.mutate() as LayerDrawable
        val item1 = drawable.getDrawable(0) as GradientDrawable
        item1.colors =
            intArrayOf(resources.getColor(firstColor, null), resources.getColor(secondColor, null))
    }

    private fun setExperienceAdapter() {
        experienceAdapter = SeekerExperienceListAdapter(experiences, requireContext(), true)
        experienceBinding.rvExperience.adapter = experienceAdapter
    }

    private fun setEducationAdapter() {
        educationAdapter = SeekerEducationAdapter(educations, requireContext(), true)
        educationBinding.rvEducation.adapter = educationAdapter
    }

    private fun setVolunteeringAdapter() {
        volunteeringAdapter = SeekerVolunteeringAdapter(volunteerings, requireContext(), true)
        volunteeringBinding.rvVolunteering.adapter = volunteeringAdapter
    }

    private fun setImageAdapter() {
        imagesAdapter = ImageAdapter(imagesUrl)
        imagesBinding.rvImages.adapter = imagesAdapter
    }

    private fun setClickListeners() {
        mainBinding.ivSetting.setOnClickListener {
            findNavController().navigate(
                R.id.action_seekerDownloadCVFragment_to_nav_seeker_account,
                null
            )
        }
        mainBinding.ivBackButton.setOnClickListener { requireActivity().onBackPressed() }
        mainBinding.btnModifyCv.setOnClickListener {
            findNavController().navigate(
                R.id.action_seekerDownloadCVFragment_to_modifyCVFragment,
                null
            )
        }



        mainBinding.ivThemeIconGreen.setOnClickListener {
            requireContext().setThemeColor(SeekerProfileTheme.GREEN.colorName)
            educationAdapter.changeCardBackgroundColor(
                R.color.background_green,
                R.color.theme_light_green,
                R.color.theme_dark_green
            )
            educationAdapter.notifyDataSetChanged()
            experienceAdapter.changeCardBackgroundColor(
                R.color.background_green,
                R.color.theme_light_green,
                R.color.theme_dark_green
            )
            experienceAdapter.notifyDataSetChanged()
            volunteeringAdapter.changeCardBackgroundColor(
                R.color.background_green,
                R.color.theme_light_green,
                R.color.theme_dark_green
            )
            volunteeringAdapter.notifyDataSetChanged()
            hardSkillAdapter.changeCardBackgroundColor(
                R.color.background_green,
                R.color.theme_light_green,
                R.color.theme_dark_green
            )
            hardSkillAdapter.notifyDataSetChanged()
            setSoftSkillTags(R.color.theme_light_green, R.color.theme_dark_green)
            setInterestTags(R.color.theme_light_green, R.color.theme_dark_green)
            setWorkspaceTags(R.color.theme_light_green, R.color.theme_dark_green)
            changeStrokeColor(
                bioBinding.clProfileIv,
                R.color.theme_light_green,
                R.color.theme_dark_green
            )
            mainBinding.clTopParent.setBackgroundColor(
                resources.getColor(
                    R.color.background_green,
                    null
                )
            )
            imageViewAndDrawableIdMap.forEach { (drawableId, imageView) ->
                changeSingleIconTheme(imageView, drawableId, R.style.theme_green)
            }
        }
        mainBinding.ivThemeIconBlue.setOnClickListener {
            requireContext().setThemeColor(SeekerProfileTheme.BLUE.colorName)
            educationAdapter.changeCardBackgroundColor(
                R.color.background_light_blue,
                R.color.theme_light_blue,
                R.color.theme_dark_blue
            )
            educationAdapter.notifyDataSetChanged()
            experienceAdapter.changeCardBackgroundColor(
                R.color.background_light_blue,
                R.color.theme_light_blue,
                R.color.theme_dark_blue
            )
            experienceAdapter.notifyDataSetChanged()
            volunteeringAdapter.changeCardBackgroundColor(
                R.color.background_light_blue,
                R.color.theme_light_blue,
                R.color.theme_dark_blue
            )
            volunteeringAdapter.notifyDataSetChanged()
            hardSkillAdapter.changeCardBackgroundColor(
                R.color.background_light_blue,
                R.color.theme_light_blue,
                R.color.theme_dark_blue
            )
            hardSkillAdapter.notifyDataSetChanged()
            setSoftSkillTags(R.color.theme_light_blue, R.color.theme_dark_blue)
            setInterestTags(R.color.theme_light_blue, R.color.theme_dark_blue)
            setWorkspaceTags(R.color.theme_light_blue, R.color.theme_dark_blue)
            changeStrokeColor(
                bioBinding.clProfileIv,
                R.color.theme_light_blue,
                R.color.theme_dark_blue
            )
            mainBinding.clTopParent.setBackgroundColor(
                resources.getColor(
                    R.color.background_light_blue,
                    null
                )
            )
            imageViewAndDrawableIdMap.forEach { (drawableId, imageView) ->
                changeSingleIconTheme(imageView, drawableId, R.style.theme_blue)
            }
        }
        mainBinding.ivThemeIconRed.setOnClickListener {
            requireContext().setThemeColor(SeekerProfileTheme.RED.colorName)
            educationAdapter.changeCardBackgroundColor(
                R.color.background_red,
                R.color.theme_light_red,
                R.color.theme_dark_red
            )
            educationAdapter.notifyDataSetChanged()
            experienceAdapter.changeCardBackgroundColor(
                R.color.background_red,
                R.color.theme_light_red,
                R.color.theme_dark_red
            )
            experienceAdapter.notifyDataSetChanged()
            volunteeringAdapter.changeCardBackgroundColor(
                R.color.background_red,
                R.color.theme_light_red,
                R.color.theme_dark_red
            )
            volunteeringAdapter.notifyDataSetChanged()
            hardSkillAdapter.changeCardBackgroundColor(
                R.color.background_red,
                R.color.theme_light_red,
                R.color.theme_dark_red
            )
            hardSkillAdapter.notifyDataSetChanged()
            setSoftSkillTags(R.color.theme_light_red, R.color.theme_dark_red)
            setInterestTags(R.color.theme_light_red, R.color.theme_dark_red)
            setWorkspaceTags(R.color.theme_light_red, R.color.theme_dark_red)
            changeStrokeColor(
                bioBinding.clProfileIv,
                R.color.theme_light_red,
                R.color.theme_dark_red
            )
            mainBinding.clTopParent.setBackgroundColor(
                resources.getColor(
                    R.color.background_red,
                    null
                )
            )
            imageViewAndDrawableIdMap.forEach { (drawableId, imageView) ->
                changeSingleIconTheme(imageView, drawableId, R.style.theme_red)
            }
        }
        mainBinding.ivThemeIconGrey.setOnClickListener {
            requireContext().setThemeColor(SeekerProfileTheme.GREY.colorName)
            educationAdapter.changeCardBackgroundColor(
                R.color.background_grey,
                R.color.theme_light_grey,
                R.color.theme_dark_grey
            )
            educationAdapter.notifyDataSetChanged()
            experienceAdapter.changeCardBackgroundColor(
                R.color.background_grey,
                R.color.theme_light_grey,
                R.color.theme_dark_grey
            )
            experienceAdapter.notifyDataSetChanged()
            volunteeringAdapter.changeCardBackgroundColor(
                R.color.background_grey,
                R.color.theme_light_grey,
                R.color.theme_dark_grey
            )
            volunteeringAdapter.notifyDataSetChanged()
            hardSkillAdapter.changeCardBackgroundColor(
                R.color.background_grey,
                R.color.theme_light_grey,
                R.color.theme_dark_grey
            )
            hardSkillAdapter.notifyDataSetChanged()
            setSoftSkillTags(R.color.theme_light_grey, R.color.theme_dark_grey)
            setInterestTags(R.color.theme_light_grey, R.color.theme_dark_grey)
            setWorkspaceTags(R.color.theme_light_grey, R.color.theme_dark_grey)
            changeStrokeColor(
                bioBinding.clProfileIv,
                R.color.theme_light_grey,
                R.color.theme_dark_grey
            )
            mainBinding.clTopParent.setBackgroundColor(
                resources.getColor(
                    R.color.background_grey,
                    null
                )
            )
            imageViewAndDrawableIdMap.forEach { (drawableId, imageView) ->
                changeSingleIconTheme(imageView, drawableId, R.style.theme_grey)
            }
        }
        mainBinding.ivThemeIconYellow.setOnClickListener {
            requireContext().setThemeColor(SeekerProfileTheme.YELLOW.colorName)
            educationAdapter.changeCardBackgroundColor(
                R.color.background_yellow,
                R.color.theme_light_yellow,
                R.color.theme_dark_yellow
            )
            educationAdapter.notifyDataSetChanged()
            experienceAdapter.changeCardBackgroundColor(
                R.color.background_yellow,
                R.color.theme_light_yellow,
                R.color.theme_dark_yellow
            )
            experienceAdapter.notifyDataSetChanged()
            volunteeringAdapter.changeCardBackgroundColor(
                R.color.background_yellow,
                R.color.theme_light_yellow,
                R.color.theme_dark_yellow
            )
            volunteeringAdapter.notifyDataSetChanged()
            hardSkillAdapter.changeCardBackgroundColor(
                R.color.background_yellow,
                R.color.theme_light_yellow,
                R.color.theme_dark_yellow
            )
            hardSkillAdapter.notifyDataSetChanged()
            setSoftSkillTags(R.color.theme_light_yellow, R.color.theme_dark_yellow)
            setInterestTags(R.color.theme_light_yellow, R.color.theme_dark_yellow)
            setWorkspaceTags(R.color.theme_light_yellow, R.color.theme_dark_yellow)
            changeStrokeColor(
                bioBinding.clProfileIv,
                R.color.theme_light_yellow,
                R.color.theme_dark_yellow
            )
            mainBinding.clTopParent.setBackgroundColor(
                resources.getColor(
                    R.color.background_yellow,
                    null
                )
            )
            imageViewAndDrawableIdMap.forEach { (drawableId, imageView) ->
                changeSingleIconTheme(imageView, drawableId, R.style.theme_yellow)
            }
        }

        mainBinding.ivThemeIconSalmon.setOnClickListener {
            requireContext().setThemeColor(SeekerProfileTheme.SALMON.colorName)
            educationAdapter.changeCardBackgroundColor(
                R.color.background_salmon,
                R.color.theme_light_salmon,
                R.color.theme_dark_salmon
            )
            educationAdapter.notifyDataSetChanged()
            experienceAdapter.changeCardBackgroundColor(
                R.color.background_salmon,
                R.color.theme_light_salmon,
                R.color.theme_dark_salmon
            )
            experienceAdapter.notifyDataSetChanged()
            volunteeringAdapter.changeCardBackgroundColor(
                R.color.background_salmon,
                R.color.theme_light_salmon,
                R.color.theme_dark_salmon
            )
            volunteeringAdapter.notifyDataSetChanged()
            hardSkillAdapter.changeCardBackgroundColor(
                R.color.background_salmon,
                R.color.theme_light_salmon,
                R.color.theme_dark_salmon
            )
            hardSkillAdapter.notifyDataSetChanged()
            setSoftSkillTags(R.color.theme_light_salmon, R.color.theme_dark_salmon)
            setInterestTags(R.color.theme_light_salmon, R.color.theme_dark_salmon)
            setWorkspaceTags(R.color.theme_light_salmon, R.color.theme_dark_salmon)
            changeStrokeColor(
                bioBinding.clProfileIv,
                R.color.theme_light_salmon,
                R.color.theme_dark_salmon
            )
            mainBinding.clTopParent.setBackgroundColor(
                resources.getColor(
                    R.color.background_salmon,
                    null
                )
            )
            imageViewAndDrawableIdMap.forEach { (drawableId, imageView) ->
                changeSingleIconTheme(imageView, drawableId, R.style.theme_salmon)
            }
        }
        mainBinding.ivThemeIconLightSalmon.setOnClickListener {
            requireContext().setThemeColor(SeekerProfileTheme.SALMON_LIGHT.colorName)
            educationAdapter.changeCardBackgroundColor(
                R.color.background_light_salmon,
                R.color.theme_light_light_salmon,
                R.color.theme_dark_light_salmon
            )
            educationAdapter.notifyDataSetChanged()
            experienceAdapter.changeCardBackgroundColor(
                R.color.background_light_salmon,
                R.color.theme_light_light_salmon,
                R.color.theme_dark_light_salmon
            )
            experienceAdapter.notifyDataSetChanged()
            volunteeringAdapter.changeCardBackgroundColor(
                R.color.background_light_salmon,
                R.color.theme_light_light_salmon,
                R.color.theme_dark_light_salmon
            )
            volunteeringAdapter.notifyDataSetChanged()
            hardSkillAdapter.changeCardBackgroundColor(
                R.color.background_light_salmon,
                R.color.theme_light_light_salmon,
                R.color.theme_dark_light_salmon
            )
            hardSkillAdapter.notifyDataSetChanged()
            setSoftSkillTags(R.color.theme_light_light_salmon, R.color.theme_dark_light_salmon)
            setInterestTags(R.color.theme_light_light_salmon, R.color.theme_dark_light_salmon)
            setWorkspaceTags(R.color.theme_light_light_salmon, R.color.theme_dark_light_salmon)
            changeStrokeColor(
                bioBinding.clProfileIv,
                R.color.theme_light_light_salmon,
                R.color.theme_dark_light_salmon
            )
            mainBinding.clTopParent.setBackgroundColor(
                resources.getColor(
                    R.color.background_light_salmon,
                    null
                )
            )
            imageViewAndDrawableIdMap.forEach { (drawableId, imageView) ->
                changeSingleIconTheme(imageView, drawableId, R.style.theme_light_salmon)
            }
        }
        mainBinding.ivThemeIconAquamarine.setOnClickListener {
            requireContext().setThemeColor(SeekerProfileTheme.AQUAMARINE.colorName)
            educationAdapter.changeCardBackgroundColor(
                R.color.background_aquamarine,
                R.color.theme_light_aquamarine,
                R.color.theme_dark_aquamarine
            )
            educationAdapter.notifyDataSetChanged()
            experienceAdapter.changeCardBackgroundColor(
                R.color.background_aquamarine,
                R.color.theme_light_aquamarine,
                R.color.theme_dark_aquamarine
            )
            experienceAdapter.notifyDataSetChanged()
            volunteeringAdapter.changeCardBackgroundColor(
                R.color.background_aquamarine,
                R.color.theme_light_aquamarine,
                R.color.theme_dark_aquamarine
            )
            volunteeringAdapter.notifyDataSetChanged()
            hardSkillAdapter.changeCardBackgroundColor(
                R.color.background_aquamarine,
                R.color.theme_light_aquamarine,
                R.color.theme_dark_aquamarine
            )
            hardSkillAdapter.notifyDataSetChanged()
            setSoftSkillTags(R.color.theme_light_aquamarine, R.color.theme_dark_aquamarine)
            setInterestTags(R.color.theme_light_aquamarine, R.color.theme_dark_aquamarine)
            setWorkspaceTags(R.color.theme_light_aquamarine, R.color.theme_dark_aquamarine)
            changeStrokeColor(
                bioBinding.clProfileIv,
                R.color.theme_light_aquamarine,
                R.color.theme_dark_aquamarine
            )
            mainBinding.clTopParent.setBackgroundColor(
                resources.getColor(
                    R.color.background_aquamarine,
                    null
                )
            )
            imageViewAndDrawableIdMap.forEach { (drawableId, imageView) ->
                changeSingleIconTheme(imageView, drawableId, R.style.theme_aquamarine)
            }
        }
        mainBinding.ivThemeIconNormal.setOnClickListener {
            requireContext().setThemeColor(SeekerProfileTheme.NORMAL.colorName)
            educationAdapter.changeCardBackgroundColor(
                R.color.screen_background,
                R.color.theme_light_blue,
                R.color.theme_dark_blue
            )
            educationAdapter.notifyDataSetChanged()
            experienceAdapter.changeCardBackgroundColor(
                R.color.screen_background,
                R.color.theme_light_blue,
                R.color.theme_dark_blue
            )
            experienceAdapter.notifyDataSetChanged()
            volunteeringAdapter.changeCardBackgroundColor(
                R.color.screen_background,
                R.color.theme_light_blue,
                R.color.theme_dark_blue
            )
            volunteeringAdapter.notifyDataSetChanged()
            hardSkillAdapter.changeCardBackgroundColor(
                R.color.screen_background,
                R.color.theme_light_blue,
                R.color.theme_dark_blue
            )
            hardSkillAdapter.notifyDataSetChanged()
            setSoftSkillTags(R.color.theme_light_blue, R.color.theme_dark_blue)
            setInterestTags(R.color.theme_light_blue, R.color.theme_dark_blue)
            setWorkspaceTags(R.color.theme_light_blue, R.color.theme_dark_blue)
            changeStrokeColor(
                bioBinding.clProfileIv,
                R.color.theme_light_blue,
                R.color.theme_dark_blue
            )
            mainBinding.clTopParent.setBackgroundColor(
                resources.getColor(
                    R.color.screen_background,
                    null
                )
            )
            imageViewAndDrawableIdMap.forEach { (drawableId, imageView) ->
                changeSingleIconTheme(imageView, drawableId, R.style.theme_normal)
            }
        }
    }
}

class ImageAdapter(var list: ArrayList<String>) : RecyclerView.Adapter<ImageAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(ItemImageBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val url = list[position]
        loadImageFromUrl(holder.binding.ivMessageImage, url, R.drawable.default_user_img)
    }

    override fun getItemCount(): Int = list.size
    fun submitList(imagesUrl: ArrayList<String>) {
        list = imagesUrl
    }

    class ViewHolder(val binding: ItemImageBinding) : RecyclerView.ViewHolder(binding.root)
}

