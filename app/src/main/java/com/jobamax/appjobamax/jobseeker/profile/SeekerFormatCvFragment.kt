package com.jobamax.appjobamax.jobseeker.profile

import android.content.ClipData
import android.content.ClipDescription
import android.content.Intent
import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.LayerDrawable
import android.media.MediaPlayer
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.view.DragEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.view.ContextThemeWrapper
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.google.gson.reflect.TypeToken
import com.jobamax.appjobamax.R
import com.jobamax.appjobamax.VideoPlayActivity
import com.jobamax.appjobamax.base.BaseFragment
import com.jobamax.appjobamax.databinding.*
import com.jobamax.appjobamax.dialog.SimpleMessageDialog
import com.jobamax.appjobamax.dialog.YesNoDialog
import com.jobamax.appjobamax.enums.LinkType
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
import com.jobamax.appjobamax.preference.setViewOrder
import com.jobamax.appjobamax.recruiter.home.PortfolioLinksAdapter
import com.jobamax.appjobamax.recruiter.home.SeekerHardSkillAdapter
import com.jobamax.appjobamax.util.StudentStatus
import com.jobamax.appjobamax.util.convertMillisToMinuteAndSecond
import com.jobamax.appjobamax.util.loadImageFromUrl
import org.json.JSONObject
import java.io.IOException
import java.lang.reflect.Type
import java.util.*
import kotlin.collections.ArrayList


class SeekerFormatCvFragment : BaseFragment() {
    lateinit var mainBinding: FragmentSeekerFormatCvBinding

    private lateinit var bioBinding: ItemProfileBioBinding
    private lateinit var educationBinding: ItemProfileEducationBinding
    private lateinit var experienceBinding: ItemProfileExperienceBinding
    private lateinit var skillBinding: ItemProfileSkillBinding
    private lateinit var audioVideoBinding: ItemProfileAudioVideoBinding
    private lateinit var volunteeringBinding: ItemProfileVolunteeringBinding
    private lateinit var portfolioBinding: ItemProfilePortfolioBinding
    private lateinit var idealWorkspaceBinding: ItemProfileIdealWorkspaceBinding
    private lateinit var interestBinding: ItemProfileInterestBinding
    private lateinit var imagesBinding: ItemProfileImagesBinding

    var currentThemeIconStyle = R.style.theme_blue


    var player: MediaPlayer? = null
    private var mStartPlaying = true
    var mUpdateSeekbar: Runnable? = null
    private val mSeekbarUpdateHandler: Handler = Handler()


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

    private val imageViewAndDrawableIdMap = hashMapOf<Int, ImageView>()

    private var layoutIds = ArrayList<Int>()
    var list = ArrayList<View>()
    var scrolledY = 0

    lateinit var imagesAdapter: ImageAdapter
    var imagesUrl = ArrayList<String>()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        mainBinding = FragmentSeekerFormatCvBinding.inflate(inflater, container, false)
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

        attachViewDragListener()
        mainBinding.llParent.setOnDragListener(maskDragListener)

        imageViewAndDrawableIdMap[R.drawable.ic_search_gradient] = bioBinding.ivSearch
        imageViewAndDrawableIdMap[R.drawable.ic_education] = bioBinding.ivCollage
        imageViewAndDrawableIdMap[R.drawable.ic_bag_gradient] = bioBinding.ivJobPost
        imageViewAndDrawableIdMap[R.drawable.ic_location] = bioBinding.ivLocationPoint
        imageViewAndDrawableIdMap[R.drawable.ic_student_gradient] = bioBinding.ivEducation
        imageViewAndDrawableIdMap[R.drawable.ic_play_gradient] = audioVideoBinding.ivPlayBtn
        imageViewAndDrawableIdMap[R.drawable.ic_pause] = audioVideoBinding.ivAudioPlayBtn
        imageViewAndDrawableIdMap[R.drawable.ic_play] = audioVideoBinding.ivAudioPlayBtn
        imageViewAndDrawableIdMap[R.drawable.ic_info_gradient_skill] = skillBinding.ivSkillInfo
        imageViewAndDrawableIdMap[R.drawable.ic_info_gradient_volunteering] = volunteeringBinding.ivVolunterringInfo
        imageViewAndDrawableIdMap[R.drawable.ic_info_gradient_interest] = interestBinding.ivInfoInterest

        setData()
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
            layoutIds.add(R.layout.item_profile_audio_video)
            layoutIds.add(R.layout.item_profile_experience)
            layoutIds.add(R.layout.item_profile_interest)
            layoutIds.add(R.layout.item_profile_portfolio)
            layoutIds.add(R.layout.item_profile_ideal_workspace)
            layoutIds.add(R.layout.item_profile_skill)
            layoutIds.add(R.layout.item_profile_volunteering)
            layoutIds.add(R.layout.item_profile_images)
        }
    }


    private fun confirmAllLayoutIds() {
        if (!layoutIds.contains(R.layout.item_profile_bio))
            layoutIds.add(R.layout.item_profile_bio)
        if (!layoutIds.contains(R.layout.item_profile_education))
            layoutIds.add(R.layout.item_profile_education)
        if (!layoutIds.contains(R.layout.item_profile_audio_video))
            layoutIds.add(R.layout.item_profile_audio_video)
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

    private val maskDragListener = View.OnDragListener { view, dragEvent ->

        val draggableItem = dragEvent.localState as View

        when (dragEvent.action) {
            DragEvent.ACTION_DRAG_STARTED -> {
                 true
            }
            DragEvent.ACTION_DRAG_ENTERED -> {
                true
            }
            DragEvent.ACTION_DRAG_LOCATION -> {
                val y = dragEvent.y
                val translatedY: Int = y.toInt() - scrolledY
                val threshold = 50
                if (translatedY < (threshold + 50)) {
                    mainBinding.scrollView.scrollBy(0, -30)
                }
                if (translatedY + threshold > 300) {
                    mainBinding.scrollView.scrollBy(0, 30)
                }

                list.forEach {
                    if (it != draggableItem){
                        if (dragEvent.y in it.y..(it.y + it.height)){
                            Collections.swap(layoutIds, layoutIds.indexOf(it.tag), layoutIds.indexOf(draggableItem.tag))
                        }
                    }
                }
                true
            }
            DragEvent.ACTION_DRAG_EXITED -> {
                true
            }
            DragEvent.ACTION_DROP -> {
                 true
            }
            DragEvent.ACTION_DRAG_ENDED -> {
                requireContext().setViewOrder(gson.toJson(layoutIds))
                configureUi()
                true
            }
            else -> {
                 false
            }

        }
    }



    private fun setChildViews() {
        list.clear()
        mainBinding.llParent.removeAllViews()
        layoutIds.forEach { layoutId ->
            when(layoutId){
                R.layout.item_profile_bio -> {
                    bioBinding = ItemProfileBioBinding.inflate(layoutInflater, null, false)
                    bioBinding.root.tag = R.layout.item_profile_bio
                    list.add(bioBinding.root)
                    mainBinding.llParent.addView(bioBinding.root)
                }
                R.layout.item_profile_education -> {
                    educationBinding = ItemProfileEducationBinding.inflate(layoutInflater, null, false)
                    educationBinding.root.tag = R.layout.item_profile_education
                    list.add(educationBinding.root)
                    mainBinding.llParent.addView(educationBinding.root)
                }
                R.layout.item_profile_experience -> {
                    experienceBinding = ItemProfileExperienceBinding.inflate(layoutInflater, null, false)
                    experienceBinding.root.tag = R.layout.item_profile_experience
                    list.add(experienceBinding.root)
                    mainBinding.llParent.addView(experienceBinding.root)
                }
                R.layout.item_profile_interest -> {
                    interestBinding = ItemProfileInterestBinding.inflate(layoutInflater, null, false)
                    interestBinding.root.tag = R.layout.item_profile_interest
                    list.add(interestBinding.root)
                    mainBinding.llParent.addView(interestBinding.root)
                }
                R.layout.item_profile_portfolio -> {
                    portfolioBinding = ItemProfilePortfolioBinding.inflate(layoutInflater, null, false)
                    portfolioBinding.root.tag = R.layout.item_profile_portfolio
                    list.add(portfolioBinding.root)
                    mainBinding.llParent.addView(portfolioBinding.root)
                }
                R.layout.item_profile_audio_video -> {
                    audioVideoBinding = ItemProfileAudioVideoBinding.inflate(layoutInflater, null, false)
                    audioVideoBinding.root.tag = R.layout.item_profile_audio_video
                    list.add(audioVideoBinding.root)
                    mainBinding.llParent.addView(audioVideoBinding.root)
                }
                R.layout.item_profile_ideal_workspace -> {
                    idealWorkspaceBinding = ItemProfileIdealWorkspaceBinding.inflate(layoutInflater, null, false)
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

    @RequiresApi(Build.VERSION_CODES.N)
    private fun attachViewDragListener() {
        list.forEach {
            if (it != mainBinding.llTheme && it != mainBinding.tvThemeTitle){
                it.setOnLongClickListener { view ->
                    val item = ClipData.Item("message")
                    val dataToDrag = ClipData("message", arrayOf(ClipDescription.MIMETYPE_TEXT_PLAIN), item)
                    val maskShadow = View.DragShadowBuilder(view)
                    view.startDragAndDrop(dataToDrag, maskShadow, view, 0)
                    true
                }
            }
        }
    }

    private fun setTheme() {
        when(requireContext().getThemeColor()){
            SeekerProfileTheme.SALMON.colorName -> { mainBinding.ivThemeIconSalmon.performClick() }
            SeekerProfileTheme.BLUE.colorName -> { mainBinding.ivThemeIconBlue.performClick() }
            SeekerProfileTheme.AQUAMARINE.colorName -> { mainBinding.ivThemeIconAquamarine.performClick() }
            SeekerProfileTheme.SALMON_LIGHT.colorName -> { mainBinding.ivThemeIconLightSalmon.performClick() }
            SeekerProfileTheme.GREEN.colorName -> { mainBinding.ivThemeIconGreen.performClick() }
            SeekerProfileTheme.YELLOW.colorName -> { mainBinding.ivThemeIconYellow.performClick() }
            SeekerProfileTheme.RED.colorName -> { mainBinding.ivThemeIconRed.performClick() }
            SeekerProfileTheme.GREY.colorName -> { mainBinding.ivThemeIconGrey.performClick() }
            SeekerProfileTheme.NORMAL.colorName -> {mainBinding.ivThemeIconNormal.performClick()
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
                (requireActivity() as SeekerCreateCvActivity).getJobSeeker {
                    if (it) {
                        jobSeeker = viewModel.jobSeeker
                        setData()
                    }
                }
            }catch (e: Exception){
                (requireActivity() as ManualAndPersonalizeActivity).getJobSeeker {
                    if (it) {
                        jobSeeker = viewModel.jobSeeker
                        setData()
                    }
                }
            }
        }
    }

    private fun setObserver() {
        viewModel.isJobSeekerUpdated.observe(viewLifecycleOwner){
            if (it){
                jobSeeker = viewModel.jobSeeker
                setData()
            }
        }
    }

    private fun setData() {
        loadImageFromUrl(bioBinding.circleImageView, jobSeeker.profilePicUrl, R.drawable.default_user_img)

        if (jobSeeker.introAudioUrl.isEmpty()){
            audioVideoBinding.clAudioPlayer.visibility = View.GONE
        }else{
            audioVideoBinding.clAudioPlayer.visibility = View.VISIBLE
            initializePlayer()
        }

        if (jobSeeker.introVideoUrl.isEmpty()){
            audioVideoBinding.clVideo.visibility = View.GONE
        }else{
            audioVideoBinding.clVideo.visibility = View.VISIBLE
        }

        if (jobSeeker.firstName.isEmpty()) {
            bioBinding.tvUserName.visibility = View.GONE
            bioBinding.tvUserName.text = jobSeeker.firstName+" "+jobSeeker.lastName
        }else{
            bioBinding.tvUserName.visibility = View.VISIBLE
            bioBinding.tvUserName.text = jobSeeker.firstName+" "+jobSeeker.lastName
        }

        if (jobSeeker.interestedIn.isNotEmpty()){
            bioBinding.llInterestedIn.visibility = View.VISIBLE
            bioBinding.tvInterestedIn.text = jobSeeker.interestedIn.joinToString(", ")
        }else{
            bioBinding.llInterestedIn.visibility = View.GONE
        }
        if (jobSeeker.city.isNotEmpty()) {
            bioBinding.tvJobLocation.text = jobSeeker.city
        } else {
            bioBinding.tvJobLocation.text = "-"
        }
        try {
            val university = gson.fromJson(JSONObject(jobSeeker.university).toString(), University::class.java)
            bioBinding.tvEducation.text = university.name
            if (university.isCurrent){
                bioBinding.tvEducation.text = StudentStatus.CURRENT.status
            }else{
                bioBinding.tvEducation.text = StudentStatus.NON_CURRENT.status
            }
        }catch (e: Exception){
            bioBinding.llEducation.visibility = View.GONE
        }

        imagesUrl = jobSeeker.images
        imagesAdapter.submitList(imagesUrl)
        imagesAdapter.notifyDataSetChanged()

        experiences = jobSeeker.experiences
        experienceAdapter.submitList(experiences)
        experienceAdapter.notifyDataSetChanged()

        if (experiences.isNotEmpty()){
            bioBinding.llJobTitle.visibility = View.VISIBLE
            bioBinding.tvJobName.text = "${experiences[0].job} - ${experiences[0].company}"
        }else{
            bioBinding.llJobTitle.visibility = View.GONE
        }

        educations = jobSeeker.educations
        educationAdapter.submitList(educations)
        educationAdapter.notifyDataSetChanged()

        if (jobSeeker.university.isEmpty()){
            bioBinding.llUniversity.visibility = View.GONE
            bioBinding.tvUniversityName.text = jobSeeker.university
        }else{
            bioBinding.llUniversity.visibility = View.VISIBLE
            val university = gson.fromJson(jobSeeker.university, University::class.java)
            if (educations.isEmpty()){
                if (university != null) {
                    bioBinding.tvUniversityName.text = university.name
                }
            }else{
                bioBinding.tvUniversityName.text = educations[0].name
            }
        }

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

    private fun setCardVisibility() {
        if (jobSeeker.educations.isEmpty())
            educationBinding.clParent.visibility = View.GONE
        else
            educationBinding.clParent.visibility = View.VISIBLE

        if (jobSeeker.introAudioUrl.isEmpty() && jobSeeker.introVideoUrl.isEmpty())
            audioVideoBinding.clParent.visibility = View.GONE
        else
            audioVideoBinding.clParent.visibility = View.VISIBLE

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


    private fun setPortfolio() {
        val portfolioDocLinks = ArrayList(jobSeeker.portfolioDocLinks)
        val portfolioDocLinkAdapter = PortfolioLinksAdapter(
            portfolioDocLinks,
            isStaticView = true,
            requireContext(),
            showIcon = false,
            LinkType.Doc.value
        )
        portfolioBinding.rvPortfolioDocLink.adapter = portfolioDocLinkAdapter

        val portfolioLinks = ArrayList(jobSeeker.portfolioLinks)
        val portfolioLinkAdapter = PortfolioLinksAdapter(
            portfolioLinks,
            isStaticView = true,
            requireContext(),
            showIcon = false,
            LinkType.Link.value
        )
        portfolioBinding.rvPortfolioLink .adapter = portfolioLinkAdapter
    }

    private fun setSoftSkillTags(firstColor: Int, secondColor: Int) {
        skillBinding.cgSoftSkill.removeAllViews()
        getOwnedSoftSkills()
        ownedSoftSkills.forEach { skillBinding.cgSoftSkill.addView(createChip(it, firstColor, secondColor)) }
    }

    private fun setWorkspaceTags(firstColor: Int, secondColor: Int) {
        idealWorkspaceBinding.cgWorkspace.removeAllViews()
        jobSeeker.workspaces.forEach { idealWorkspaceBinding.cgWorkspace.addView(createChip(it, firstColor, secondColor)) }
    }

    private fun setInterestTags(firstColor: Int, secondColor: Int) {
        interestBinding.cgInterests.removeAllViews()
        jobSeeker.interests.forEach { interestBinding.cgInterests.addView(createChip(it, firstColor, secondColor)) }
    }

    private fun setHardSkillAdapter() {
        hardSkillAdapter = SeekerHardSkillAdapter(ownedHardSkills, requireContext(), true)
        skillBinding.rvHardSkill.adapter = hardSkillAdapter
        hardSkillAdapter.clickListener = {
            YesNoDialog(requireActivity(), resources.getString(R.string.are_you_sure),{
                ownedHardSkills.remove(it)
                hardSkillAdapter.submitList(ownedHardSkills)
                hardSkillAdapter.notifyDataSetChanged()
            },{}).show()
        }
        hardSkillAdapter.skillLevelChangeListener = { hardSkill, skillLevelNewValue ->
            val index = ownedHardSkills.indexOf(hardSkill)
            if(ownedHardSkills.indexOf(hardSkill) != -1){
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
        if (android.os.Build.VERSION.SDK_INT > 28){
            val drawable = tag.background.mutate() as LayerDrawable
            val item1 = drawable.getDrawable(0) as GradientDrawable
            item1.colors = intArrayOf( resources.getColor(firstColor, null) ,  resources.getColor(secondColor, null))
        }else{
            val gd = GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, intArrayOf( resources.getColor(firstColor, null) ,   resources.getColor(secondColor, null)))
            gd.cornerRadius = 250f
            tag.background = gd
        }
    }

    private fun setImageAdapter() {
        imagesAdapter = ImageAdapter(imagesUrl)
        imagesBinding.rvImages.adapter = imagesAdapter
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

    private fun onPlay(start: Boolean) = if (start) {
        stopPlaying()
    } else {
        if (player != null){
            initializePlayer()
            audioVideoBinding.ivAudioPlayBtn.setImageResource(R.drawable.ic_pause)
            changeSingleIconTheme(audioVideoBinding.ivAudioPlayBtn, R.drawable.ic_pause, currentThemeIconStyle)
            player!!.start()
        }else{
            initializePlayer()
            audioVideoBinding.ivAudioPlayBtn.setImageResource(R.drawable.ic_pause)
            changeSingleIconTheme(audioVideoBinding.ivAudioPlayBtn, R.drawable.ic_pause, currentThemeIconStyle)
            player!!.start()
        }
    }

    private fun initializePlayer() {
        if (player == null){
            player = MediaPlayer().apply {
                try {
                    setDataSource(jobSeeker.introAudioUrl)
                    prepare()
                    mStartPlaying = false
                } catch (e: IOException) {
                    log(  "prepare() failed")
                }
            }
        }

        audioVideoBinding.tvAudioDuration.text = player?.duration?.toLong()?.let { convertMillisToMinuteAndSecond(it) }



        mUpdateSeekbar  = object : Runnable {
            override fun run() {
                audioVideoBinding.sbAudio.progress = player?.currentPosition ?: 0
                audioVideoBinding.tvAudioDurationProgress.text = convertMillisToMinuteAndSecond((audioVideoBinding.sbAudio.progress).toLong())
                mSeekbarUpdateHandler.postDelayed(this, 0)
            }
        }

        audioVideoBinding.sbAudio.max = player!!.duration
        mSeekbarUpdateHandler.postDelayed(mUpdateSeekbar!!, 0)

        player?.setOnCompletionListener {
            audioVideoBinding.sbAudio.progress = 0
            audioVideoBinding.tvAudioDurationProgress.text = "0:0"
            audioVideoBinding.ivAudioPlayBtn.setImageResource(R.drawable.ic_play)
            changeSingleIconTheme(audioVideoBinding.ivAudioPlayBtn, R.drawable.ic_play, currentThemeIconStyle)
            mStartPlaying = true
        }
    }

    private fun stopPlaying() {
        try {
            player?.pause()
            mStartPlaying = true
            audioVideoBinding.ivAudioPlayBtn.setImageResource(R.drawable.ic_play)
            changeSingleIconTheme(audioVideoBinding.ivAudioPlayBtn, R.drawable.ic_play, currentThemeIconStyle)
            mSeekbarUpdateHandler.removeCallbacks(mUpdateSeekbar!!)
        }catch (e: java.lang.Exception){}
    }


    private fun setClickListeners() {
        mainBinding.ivBackButton.setOnClickListener { requireActivity().onBackPressed() }
        mainBinding.btnModifyCv.setOnClickListener { findNavController().navigate(R.id.action_seekerFormatCvFragment_to_modifyCVFragment, null) }
        volunteeringBinding.ivVolunterringInfo.setOnClickListener { SimpleMessageDialog(requireActivity(),"Ajoute des experiences en tant que bénévole peut importe l'âge.").show() }
        mainBinding.scrollView.setOnScrollChangeListener { v, scrollX, scrollY, oldScrollX, oldScrollY ->
            scrolledY = scrollY
        }

        audioVideoBinding.ivAudioPlayBtn.setOnClickListener {
            if (player != null) {
                onPlay(player!!.isPlaying)
            }else{
                onPlay(mStartPlaying)
            }
        }

        mainBinding.ivSetting.setOnClickListener {
            findNavController().navigate(R.id.action_seekerFormatCvFragment_to_nav_seeker_account, null)
        }

        audioVideoBinding.ivPlayBtn.setOnClickListener {
            if (jobSeeker.introVideoUrl.isNotEmpty()){
                startActivity(Intent(requireContext(), VideoPlayActivity::class.java).putExtra("video_url", jobSeeker.introVideoUrl))
            }
        }

        mainBinding.ivThemeIconGreen.setOnClickListener {
            requireContext().setThemeColor(SeekerProfileTheme.GREEN.colorName)
            changeTheme(R.color.background_green, R.color.theme_light_green, R.color.theme_dark_green, R.style.theme_green, mainBinding.llThemeIconGreen)
        }
        mainBinding.ivThemeIconBlue.setOnClickListener {
            requireContext().setThemeColor(SeekerProfileTheme.BLUE.colorName)
            changeTheme(
                R.color.background_light_blue,
                R.color.theme_light_blue,
                R.color.theme_dark_blue,
                R.style.theme_blue,
                mainBinding.llThemeIconBlue
            )
        }
        mainBinding.ivThemeIconRed.setOnClickListener {
            requireContext().setThemeColor(SeekerProfileTheme.RED.colorName)
            changeTheme(
                R.color.background_red,
                R.color.theme_light_red,
                R.color.theme_dark_red,
                R.style.theme_red,
                mainBinding.llThemeIconRed
            )
        }
        mainBinding.ivThemeIconGrey.setOnClickListener {
            requireContext().setThemeColor(SeekerProfileTheme.GREY.colorName)
            changeTheme(
                R.color.background_grey,
                R.color.theme_light_grey,
                R.color.theme_dark_grey,
                R.style.theme_grey,
                mainBinding.llThemeIconGrey
            )
        }
        mainBinding.ivThemeIconYellow.setOnClickListener {
            requireContext().setThemeColor(SeekerProfileTheme.YELLOW.colorName)
            changeTheme(
                R.color.background_yellow,
                R.color.theme_light_yellow,
                R.color.theme_dark_yellow,
                R.style.theme_yellow,
                mainBinding.llThemeIconYellow
            )
        }

        mainBinding.ivThemeIconSalmon.setOnClickListener {
            requireContext().setThemeColor(SeekerProfileTheme.SALMON.colorName)
            changeTheme(
                R.color.background_salmon,
                R.color.theme_light_salmon,
                R.color.theme_dark_salmon,
                R.style.theme_salmon,
                mainBinding.llThemeIconSalmon
            )
        }
        mainBinding.ivThemeIconLightSalmon.setOnClickListener {
            requireContext().setThemeColor(SeekerProfileTheme.SALMON_LIGHT.colorName)
            changeTheme(
                R.color.background_light_salmon,
                R.color.theme_light_light_salmon,
                R.color.theme_dark_light_salmon,
                R.style.theme_light_salmon,
                mainBinding.llThemeIconLightSalmoe
            )
        }
        mainBinding.ivThemeIconAquamarine.setOnClickListener {
            requireContext().setThemeColor(SeekerProfileTheme.AQUAMARINE.colorName)
            changeTheme(
                R.color.background_aquamarine,
                R.color.theme_light_aquamarine,
                R.color.theme_dark_aquamarine,
                R.style.theme_aquamarine,
                mainBinding.llThemeIconAquamarine
            )
        }
        mainBinding.ivThemeIconNormal.setOnClickListener {
            requireContext().setThemeColor(SeekerProfileTheme.NORMAL.colorName)
            changeTheme(
                R.color.screen_background,
                R.color.theme_light_blue,
                R.color.theme_dark_blue,
                R.style.theme_blue,
                mainBinding.llThemeIconBlue
            )
        }
    }

    private fun changeTheme(backgroundColor: Int, themeLightColor: Int, themeDarkColor: Int, themeIconStyle: Int, llThemeIconView: LinearLayout) {
        currentThemeIconStyle = themeIconStyle
        educationAdapter.changeCardBackgroundColor( backgroundColor, themeLightColor, themeDarkColor)
        educationAdapter.notifyDataSetChanged()
        experienceAdapter.changeCardBackgroundColor( backgroundColor, themeLightColor, themeDarkColor)
        experienceAdapter.notifyDataSetChanged()
        volunteeringAdapter.changeCardBackgroundColor( backgroundColor, themeLightColor, themeDarkColor)
        volunteeringAdapter.notifyDataSetChanged()
        hardSkillAdapter.changeCardBackgroundColor( backgroundColor, themeLightColor, themeDarkColor)
        hardSkillAdapter.notifyDataSetChanged()
        setSoftSkillTags(themeLightColor, themeDarkColor)
        setInterestTags(themeLightColor, themeDarkColor)
        setWorkspaceTags(themeLightColor, themeDarkColor)
        changeStrokeColor(bioBinding.clProfileIv, themeLightColor, themeDarkColor )
        changeThemeButtonBackground(llThemeIconView, themeLightColor, themeDarkColor )
        mainBinding.clTopParent.setBackgroundColor(resources.getColor( backgroundColor, null) )
        imageViewAndDrawableIdMap.forEach{ (drawableId, imageView) ->
            changeSingleIconTheme(imageView, drawableId, themeIconStyle)
        }
        hardSkillAdapter.changeStrokeColor(audioVideoBinding.sbAudio)
    }

    private fun changeThemeButtonBackground(layout: LinearLayout, firstColor: Int, secondColor: Int) {
        removeBackgroundFromThemeButton()

        layout.setBackgroundResource(R.drawable.ovel_white_box_gradient_border)


        if (android.os.Build.VERSION.SDK_INT > 28){
            val drawable = layout.background.mutate() as LayerDrawable
            val item1 = drawable.getDrawable(0) as GradientDrawable
            item1.colors = intArrayOf( resources.getColor(firstColor, null) ,  resources.getColor(secondColor, null))
        }else{
            val gd = GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, intArrayOf( resources.getColor(firstColor, null) ,   resources.getColor(secondColor, null)))
            gd.cornerRadius = 100f
            layout.background = gd
        }
    }

    private fun removeBackgroundFromThemeButton() {
        mainBinding.llThemeIconSalmon.setBackgroundResource(0)
        mainBinding.llThemeIconBlue.setBackgroundResource(0)
        mainBinding.llThemeIconAquamarine.setBackgroundResource(0)
        mainBinding.llThemeIconLightSalmoe.setBackgroundResource(0)
        mainBinding.llThemeIconGreen.setBackgroundResource(0)
        mainBinding.llThemeIconYellow.setBackgroundResource(0)
        mainBinding.llThemeIconRed.setBackgroundResource(0)
        mainBinding.llThemeIconGrey.setBackgroundResource(0)
    }

}