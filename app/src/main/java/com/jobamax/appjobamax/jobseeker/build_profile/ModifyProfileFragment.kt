package com.jobamax.appjobamax.jobseeker.build_profile

import android.Manifest
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.LayerDrawable
import android.location.Address
import android.location.Geocoder
import android.net.Uri
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.view.*
import android.widget.*
import androidx.activity.result.contract.ActivityResultContracts.StartActivityForResult
import androidx.core.view.updatePadding
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.google.android.gms.common.api.Status
import com.google.android.libraries.places.api.Places
import com.google.android.libraries.places.api.model.Place
import com.google.android.libraries.places.widget.AutocompleteSupportFragment
import com.google.android.libraries.places.widget.listener.PlaceSelectionListener
import com.jobamax.appjobamax.R
import com.jobamax.appjobamax.base.BaseFragment
import com.jobamax.appjobamax.databinding.*
import com.jobamax.appjobamax.dialog.*
import com.jobamax.appjobamax.enums.LinkType
import com.jobamax.appjobamax.enums.ParseTableFields
import com.jobamax.appjobamax.enums.ParseTableName
import com.jobamax.appjobamax.extensions.*
import com.jobamax.appjobamax.jobseeker.JobSeekerHomeActivity
import com.jobamax.appjobamax.jobseeker.dialog.DialogAddDocument
import com.jobamax.appjobamax.jobseeker.dialog.DialogAddLink
import com.jobamax.appjobamax.jobseeker.dialog.DialogWorkType
import com.jobamax.appjobamax.jobseeker.profile.SeekerCreateCvActivity
import com.jobamax.appjobamax.jobseeker.search.ManualAndPersonalizeActivity
import com.jobamax.appjobamax.jobseeker.view_model.SeekerHomeViewModel
import com.jobamax.appjobamax.model.*
import com.jobamax.appjobamax.preference.getLanguage
import com.jobamax.appjobamax.preference.setSeenOnBoarding
import com.jobamax.appjobamax.recruiter.home.PortfolioLinksAdapter
import com.jobamax.appjobamax.recruiter.home.SeekerHardSkillAdapter
import com.jobamax.appjobamax.util.*
import com.parse.*
import com.pushwoosh.internal.platform.AndroidPlatformModule
import org.json.JSONArray
import org.json.JSONObject
import java.io.InputStream
import java.util.*


const val PROFILE_IMAGE_REQUEST_CODE = 1
const val USER_IMAGES_REQUEST_CODE = 2
const val PORTFOLIO_IMAGES_REQUEST_CODE = 3
class ModifyProfileFragment : BaseFragment()  , ImagePicker.GetImage{
    lateinit var binding: FragmentModifyProfileBinding


    lateinit var autocompleteFragment: AutocompleteSupportFragment

    lateinit var portfolioLinkAdapter: PortfolioLinksAdapter
    lateinit var portfolioDocLinkAdapter: PortfolioLinksAdapter
    val portfolioLinks = arrayListOf<String>()
    val portfolioDocLinks = arrayListOf<String>()

    lateinit var photosAdapter: PhotosAdapter

    lateinit var hardSkillAdapter: SeekerHardSkillAdapter
    private var ownedHardSkills = ArrayList<HardSkill>()
    private var hardSkillSuggestions = ArrayList<String>()

    private var ownedSoftSkills = ArrayList<String>()
    var softSkillSuggestions = ArrayList<String>()

    private var ownedInterest = ArrayList<String>()
    private var interestTagsSuggestions = ArrayList<String>()

    private var ownedWorkspace = ArrayList<String>()

    lateinit var jobSeeker: JobSeeker

    val viewModel: SeekerHomeViewModel by activityViewModels()

    var experiences = ArrayList<Experience>()
    private lateinit var experienceAdapter: SeekerExperienceListAdapter

    private lateinit var educationAdapter: SeekerEducationAdapter
    private var educations = ArrayList<Education>()

    lateinit var volunteeringAdapter: SeekerVolunteeringAdapter
    var volunteerings = ArrayList<Volunteering>()

    lateinit var imagePicker: ImagePicker

    var imagePosition = 0
    var imagesUrl = arrayListOf<String>()

    private val itemTouchHelper by lazy {
        val simpleItemTouchCallback = object : ItemTouchHelper.SimpleCallback(ItemTouchHelper.UP or ItemTouchHelper.DOWN or ItemTouchHelper.START or ItemTouchHelper.END, 0) {
            override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder): Boolean {
                val adapter = recyclerView.adapter as PhotosAdapter
                val from = viewHolder.adapterPosition
                val to = target.adapterPosition
                adapter.notifyItemMoved(from, to)
                Collections.swap(imagesUrl, from, to)
                viewModel.jobSeekerObject?.put("images", ArrayList(imagesUrl.filter { it.isNotEmpty() }))
                saveJobSeeker {}
                return true
            }
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {}

            override fun onSelectedChanged(viewHolder: RecyclerView.ViewHolder?, actionState: Int) {
                super.onSelectedChanged(viewHolder, actionState)
                if (actionState == ItemTouchHelper.ACTION_STATE_DRAG) {
                    viewHolder?.itemView?.alpha = 0.5f
                }
            }
            override fun clearView(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder) {
                super.clearView(recyclerView, viewHolder)
                viewHolder.itemView.alpha = 1.0f
            }
        }

        ItemTouchHelper(simpleItemTouchCallback)
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentModifyProfileBinding.inflate(inflater, container, false)
        configureUi()
        return binding.root
    }

    private fun configureUi() {
        setClickListeners()
        setPlaceAutocompleteFragment()
        setPortfolioLinkAdapter()
        setPortfolioDocLinkAdapter()
        setEducationAdapter()
        setExperienceAdapter()
        setVolunteeringAdapter()
        setPhotosAdapter()
        setHardSkillAdapter()
        initializeJobSeeker()
        getExistingHardSkillTags()
        getExistingSoftSkillTags()
        getExistingInterestTags()
        setObserver()
        setData()
        changeDrawableColor(binding.llImportProfile, R.color.light_blue_color)
        binding.tvProfileMatchPer.paint.shader = getShader(binding.tvProfileMatchPer)
        changeDrawableColor(binding.clVideoIntro, R.color.light_blue_color)
        changeDrawableColor(binding.clAudioIntro, R.color.light_blue_color)
    }


    private fun getExistingSoftSkillTags() {
        val query = ParseQuery.getQuery<ParseObject>(ParseTableName.SOFT_SKILL.value)
        query.findInBackground { it, e ->
            when {
                e != null -> {
                    toast(e.message.toString())
                }
                else -> {
                    softSkillSuggestions.clear()
                    it.forEach {
                        it.getString("name")?.let { tag -> softSkillSuggestions.add(tag) }
                    }
                    try {
                        binding.actvSoftSkill.setAdapter(ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, softSkillSuggestions))
                    }catch (e: Exception){
                        log(e.message.toString()+" Womething went wrong.")
                    }
                }
            }
        }
    }

    private val resultLauncher = registerForActivityResult(StartActivityForResult()) { result ->
        val data = result.data
        if (data != null) {
            val sUri = data.data
            sUri?.let {
                uploadImage(sUri){
                    it?.let { url ->
                        portfolioDocLinks.add(it)
                        savePortfolioDocLinks()
                    }
                }
            }
        }
    }

    private fun savePortfolioDocLinks() {
        viewModel.jobSeekerObject?.put(ParseTableFields.PORTFOLIO_DOC_LINKS.value, portfolioDocLinks)
        viewModel.jobSeekerObject?.saveInBackground { exception ->
            if (exception == null) {
                (requireActivity() as BuildProfileActivity).getJobSeeker { }
            }
        }
    }
    private fun savePortfolioLinks() {
        viewModel.jobSeekerObject?.put(ParseTableFields.PORTFOLIO_LINKS.value, portfolioLinks)
        viewModel.jobSeekerObject?.saveInBackground { exception ->
            if (exception == null) {
                (requireActivity() as BuildProfileActivity).getJobSeeker { }
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

        loadImageFromUrl(binding.civUser, jobSeeker.profilePicUrl, R.drawable.default_user_img)

        binding.tvWorkTypes.text = "Recherche : ${jobSeeker.interestedIn.joinToString()}"

        val university = gson.fromJson(jobSeeker.university, University::class.java)
        university?.let { binding.cbUniversityStatus.isChecked = it.isCurrent }

        val jobLocation = gson.fromJson(jobSeeker.jobLocation, JobLocation::class.java)
        if (jobLocation != null) {
            binding.tvJobLocation.text = "Localisation : "+jobLocation.city
        }

        binding.etBio.setText(jobSeeker.elevatorPitch)
        binding.tvBioLength.text = "${jobSeeker.elevatorPitch.length}/1500"
        if (jobSeeker.firstName.isEmpty() && jobSeeker.lastName.isEmpty()){
            binding.etName.setText("")
        }else{
            binding.etName.setText(jobSeeker.firstName+" "+jobSeeker.lastName)
        }

        portfolioLinks.clear()
        viewModel.jobSeeker.portfolioLinks.forEach {
            portfolioLinks.add(it)
        }
        portfolioLinkAdapter.submitList(portfolioLinks)
        portfolioLinkAdapter.notifyDataSetChanged()

        portfolioDocLinks.clear()
        viewModel.jobSeeker.portfolioDocLinks.forEach {
            portfolioDocLinks.add(it)
        }
        portfolioDocLinkAdapter.submitList(portfolioDocLinks)
        portfolioDocLinkAdapter.notifyDataSetChanged()


        experiences = jobSeeker.experiences
        experienceAdapter.submitList(experiences)
        experienceAdapter.notifyDataSetChanged()

        educations = jobSeeker.educations
        educationAdapter.submitList(educations)
        educationAdapter.notifyDataSetChanged()

        volunteerings = jobSeeker.volunteerings
        volunteeringAdapter.submitList(volunteerings)
        volunteeringAdapter.notifyDataSetChanged()

        val customDropDownAdapter = if (educations.isNotEmpty()){
            CustomDropDownEducationAdapter(requireContext(), educations)
        }else{
            if (university != null){
                CustomDropDownEducationAdapter(requireContext(), arrayListOf(Education().also {
                    it.name = university.name
                }))
            }else {
                CustomDropDownEducationAdapter(requireContext(), arrayListOf())
            }
        }
        binding.spEducation.adapter = customDropDownAdapter
        binding.spEducation.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, position: Int, p3: Long) {
                if (educations.isNotEmpty()){
                    if (educations[position] != educations[0]){
                        Collections.swap(educations, educations.indexOf(educations[position]), 0)
                        viewModel.jobSeekerObject?.put(ParseTableFields.EDUCATIONS.value, gson.toJson(EducationGroup(educations)) )
                        saveJobSeeker {  }
                    }
                }
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {}
        }

        imagesUrl.clear()
        jobSeeker.images.forEach { imagesUrl.add(it) }
        while (imagesUrl.size < 6){
            imagesUrl.add("")
        }
        photosAdapter.submitList(imagesUrl)
        photosAdapter.notifyDataSetChanged()

        ownedHardSkills = jobSeeker.hardSkills

        hardSkillAdapter.submitList(ownedHardSkills)
        hardSkillAdapter.notifyDataSetChanged()

        binding.cgSoftSkill.removeAllViews()
        getOwnedSoftSkills()
        ownedSoftSkills.forEach { createSoftSkillTag(it) }

        binding.cgInterests.removeAllViews()
        ownedInterest.clear()
        jobSeeker.interests.forEach { ownedInterest.add(it) }
        ownedInterest.forEach { createInterestTag(it) }

        binding.cgWorkspace.removeAllViews()
        ownedWorkspace.clear()
        jobSeeker.workspaces.forEach { ownedWorkspace.add(it) }
        ownedWorkspace.forEach { createWorkspaceTag(it) }


        binding.tvProfileMatchPer.text = "complété à ${calculateCompleteProfile(jobSeeker)}%"
    }




    private fun getOwnedSoftSkills() {
        ownedSoftSkills = jobSeeker.softSkills
    }

    private fun setPortfolioLinkAdapter() {
        portfolioLinkAdapter = PortfolioLinksAdapter(
            portfolioLinks,
            isStaticView = false,
            requireContext = requireContext(),
            showIcon = false,
            LinkType.Link.value
        )
        binding.rvPortfolioLink.adapter = portfolioLinkAdapter
        portfolioLinkAdapter.onRemoveLinkClick = {
            portfolioLinks.remove(it)
            savePortfolioLinks()
            portfolioLinkAdapter.submitList(portfolioLinks)
            portfolioLinkAdapter.notifyDataSetChanged()
        }
    }

    private fun setPortfolioDocLinkAdapter() {
        portfolioDocLinkAdapter = PortfolioLinksAdapter(
            portfolioDocLinks,
            isStaticView = false,
            requireContext = requireContext(),
            showIcon = false,
            LinkType.Doc.value
        )
        binding.rvPortfolioDocLink.adapter = portfolioDocLinkAdapter
        portfolioDocLinkAdapter.onRemoveLinkClick = {
            portfolioDocLinks.remove(it)
            portfolioDocLinkAdapter.submitList(portfolioDocLinks)
            portfolioDocLinkAdapter.notifyDataSetChanged()
            savePortfolioDocLinks()
        }
    }

    private fun setExperienceAdapter() {
        experienceAdapter = SeekerExperienceListAdapter(experiences, requireContext(), false)
        binding.rvExperience.adapter = experienceAdapter
        experienceAdapter.clickListener = { experience ->
            YesNoDialog(requireActivity(), resources.getString(R.string.are_you_sure), {
                experiences.remove(experience)
                val experienceGroup = ExperienceGroup(experiences)
                viewModel.jobSeekerObject?.put(ParseTableFields.COMPANY_NAMES.value, ArrayList(experienceGroup.list.map { it.company.lowercase() }.filter { it.isNotEmpty() }))
                viewModel.jobSeekerObject?.put(ParseTableFields.EXPERIENCES.value, gson.toJson(experienceGroup))
                viewModel.jobSeekerObject!!.saveInBackground {
                    if (it != null) {
                        toast(it.message.toString())
                    }
                    (requireActivity() as BuildProfileActivity).getJobSeeker {  }
                }
            }, {}).show()
        }
        experienceAdapter.onItemClick = {   experience ->
            val bundle = Bundle()
            bundle.putSerializable("experience", experience)
            findNavController().navigate(R.id.action_modifyProfileFragment_to_addNewExperienceFragment, bundle)
        }
    }

    private fun setEducationAdapter() {
        educationAdapter = SeekerEducationAdapter(educations, requireContext(), false)
        binding.rvEducation.adapter = educationAdapter
        educationAdapter.clickListener = { education ->
            YesNoDialog(requireActivity(), resources.getString(R.string.are_you_sure),{
                educations.remove(education)
                val educationGroup = EducationGroup(educations)
                viewModel.jobSeekerObject?.put(ParseTableFields.EDUCATIONS.value, gson.toJson(educationGroup))
                viewModel.jobSeekerObject!!.saveInBackground {
                    if (it != null) {
                        toast(it.message.toString())
                    }
                    (requireActivity() as BuildProfileActivity).getJobSeeker {  }
                }
            }, {}).show()
        }
        educationAdapter.onItemClick = {    education ->
            val bundle = Bundle()
            bundle.putSerializable("education", education)
            findNavController().navigate(R.id.action_modifyProfileFragment_to_addNewEducationFragment, bundle)
        }
    }

    private fun setVolunteeringAdapter() {
        volunteeringAdapter = SeekerVolunteeringAdapter(volunteerings, requireContext(), false)
        binding.rvVolunteering.adapter = volunteeringAdapter
        volunteeringAdapter.clickListener = {   volunteering ->
            YesNoDialog(requireActivity(), resources.getString(R.string.are_you_sure), {
                volunteerings.remove(volunteering)
                val volunteeringGroup = VolunteeringGroup(volunteerings)
                viewModel.jobSeekerObject?.put(ParseTableFields.VOLUNTEERINGS.value, gson.toJson(volunteeringGroup))
                viewModel.jobSeekerObject!!.saveInBackground {
                    if (it != null) {
                        toast(it.message.toString())
                    }
                    (requireActivity() as BuildProfileActivity).getJobSeeker {  }
                }
            }, {}).show()
        }
        volunteeringAdapter.onItemClick = { volunteering ->
            val bundle = Bundle()
            bundle.putSerializable("volunteering", volunteering)
            findNavController().navigate(R.id.action_modifyProfileFragment_to_addNewVolunteeringFragment, bundle)
        }
    }

    private fun initializeJobSeeker() {
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

    private fun setPhotosAdapter() {
        photosAdapter = PhotosAdapter(imagesUrl, false)
        binding.rvPhotos.adapter = photosAdapter
        itemTouchHelper.attachToRecyclerView(binding.rvPhotos)
        photosAdapter.onImageClick = {  position ->
            imagePosition = position
            setupImagePicker(USER_IMAGES_REQUEST_CODE)
        }
    }


    private fun setHardSkillAdapter() {
        hardSkillAdapter = SeekerHardSkillAdapter(ownedHardSkills, requireContext(), false)
        binding.rvHardSkill.adapter = hardSkillAdapter
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








    private fun createSoftSkillTag(label: String) {
        val chip: View = layoutInflater.inflate(R.layout.item_chip_white_box_gradient_border_close_icon, null, false)
        val tvContract = chip.findViewById<TextView>(R.id.tv_tag)
        val ivRemoveTag = chip.findViewById<ImageView>(R.id.iv_remove_tag)
        ivRemoveTag.setOnClickListener {
            try {
                binding.cgSoftSkill.removeView(chip)
                ownedSoftSkills.remove(label)
            }catch (e: Exception){}
        }
        tvContract.text = label
        tvContract.updatePadding(30, 0,30,0)
        binding.cgSoftSkill.addView(chip)
    }

    private fun createInterestTag(label: String)  {
        val chip: View = layoutInflater.inflate(R.layout.item_chip_white_box_gradient_border_close_icon, null, false)
        val tvContract = chip.findViewById<TextView>(R.id.tv_tag)
        val ivRemoveTag = chip.findViewById<ImageView>(R.id.iv_remove_tag)
        ivRemoveTag.setOnClickListener {
            try {
                binding.cgInterests.removeView(chip)
                ownedInterest.remove(label)
            }catch (e: Exception){}
        }
        tvContract.text = label
        tvContract.updatePadding(30, 0,30,0)
        binding.cgInterests.addView(chip)
    }

    private fun createWorkspaceTag(label: String) {
        val chip: View = layoutInflater.inflate(R.layout.item_chip_white_box_gradient_border_close_icon, null, false)
        val tvContract = chip.findViewById<TextView>(R.id.tv_tag)
        val ivRemoveTag = chip.findViewById<ImageView>(R.id.iv_remove_tag)
        ivRemoveTag.setOnClickListener {
            try {
                binding.cgWorkspace.removeView(chip)
                ownedWorkspace.remove(label)
            }catch (e: Exception){}
        }
        tvContract.text = label
        tvContract.updatePadding(30, 0,30,0)
        binding.cgWorkspace.addView(chip)
    }

    private fun setClickListeners() {
        binding.ivBackButton.setOnClickListener { requireActivity().onBackPressed() }
        binding.ivSkillInfo.setOnClickListener {
            SkillSuggestionDialog(requireActivity()).show()
        }
        binding.etBio.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                binding.tvBioLength.text = "${binding.etBio.text.toString().length}/1500"
            }
            override fun afterTextChanged(p0: Editable?) {}
        })
        binding.llImportProfile.setOnClickListener { findNavController().navigate(R.id.action_modifyProfileFragment_to_importProfileFromLinkedIn, null) }
        binding.ivAddWorkspaceBtn.setOnClickListener { addIdealWorkspace() }
        binding.clAudioIntro.setOnClickListener { findNavController().navigate(R.id.action_modifyProfileFragment_to_audioDemoFragment, null) }
        binding.clVideoIntro.setOnClickListener { findNavController().navigate(R.id.action_modifyProfileFragment_to_videoDemoFragment, null) }
        binding.ivAddEducation.setOnClickListener { findNavController().navigate(R.id.action_modifyProfileFragment_to_addNewEducationFragment, null) }
        binding.ivAddExperience.setOnClickListener { findNavController().navigate(R.id.action_modifyProfileFragment_to_addNewExperienceFragment, null) }
        binding.ivAddVolunteering.setOnClickListener { findNavController().navigate(R.id.action_modifyProfileFragment_to_addNewVolunteeringFragment, null) }
        binding.ivAddHardSkill.setOnClickListener {
            if (binding.actvHardSkill.text.isNullOrEmpty()){
                toast("Please first enter the tag.")
            }else{
                addHardSkill()
            }
        }
        binding.ivAddSoftSkill.setOnClickListener { addSoftSkill() }
        binding.ivAddAreaOfInterest.setOnClickListener {
            addInterest()
        }
        binding.cbUniversityStatus.setOnCheckedChangeListener { view, isChecked ->
            val university = gson.fromJson(jobSeeker.university, University::class.java)
            university?.let {
                it.isCurrent = isChecked
                viewModel.jobSeekerObject?.put(ParseTableFields.UNIVERSITY.value, gson.toJson(it))
            }
        }
        binding.tvGoToValidateCv.setOnClickListener { saveChanges(true) }
        binding.cvUpdateImage.setOnClickListener {
            if (requireActivity().checkForPermissions(arrayOf(Manifest.permission.CAMERA))) {
                setupImagePicker(PROFILE_IMAGE_REQUEST_CODE)
            }
        }
        binding.civUser.setOnClickListener {
            if (requireActivity().checkForPermissions(arrayOf(Manifest.permission.CAMERA))) {
                setupImagePicker(PROFILE_IMAGE_REQUEST_CODE)
            }
        }
        binding.clAddLink.setOnClickListener {
            DialogAddLink(requireActivity()).also {
                it.onAddLinkClick = { link ->
                    portfolioLinks.add(link)
                    savePortfolioLinks()
                }
            }.show()
        }
        binding.clAddDocument.setOnClickListener {
            DialogAddDocument(requireActivity()).also {
                it.onPdfClick = {
                    selectPDF()
                }
                it.onImageClick = {
                    setupImagePicker(PORTFOLIO_IMAGES_REQUEST_CODE)
                }
            }.show()
        }



        binding.clLocation.setOnClickListener {
            autocompleteFragment.requireView().findViewById<View>(R.id.places_autocomplete_search_input).performClick()
        }
        binding.clWorkType.setOnClickListener {
            val dialog = DialogWorkType(requireActivity())
            dialog.onWorkClick = { workTypes ->
                viewModel.jobSeekerObject?.put(ParseTableFields.INTERESTED_IN.value, workTypes)
                viewModel.jobSeekerObject?.saveInBackground { exception ->
                    if (exception == null) {
                        (requireActivity() as BuildProfileActivity).getJobSeeker {  }
                    }
                }
            }
            val window: Window? = dialog.window
            window?.let {
                val wlp = it.attributes
                wlp.gravity = Gravity.BOTTOM
                it.attributes = wlp
            }
            dialog.show()
        }

    }

    private fun addSoftSkill() {
        val softSkill =  binding.actvSoftSkill.text.toString().trim()
        if (! softSkillSuggestions.contains(softSkill)){
            saveSoftSkillTag(binding.actvSoftSkill.text.toString())
        }
        if (ownedSoftSkills.contains(softSkill)){
            toast("This Skill is already exist.")
        }else{
            ownedSoftSkills.add(softSkill)
            binding.cgSoftSkill.removeAllViews()
            ownedSoftSkills.forEach {
                createSoftSkillTag(it)
            }
            binding.actvSoftSkill.text.clear()
        }
    }

    private fun saveSoftSkillTag(tag: String) {
        val hardSkillParseObject = ParseObject(ParseTableName.SOFT_SKILL.value)
        hardSkillParseObject.put("name", tag)
        hardSkillParseObject.saveInBackground {
            softSkillSuggestions.add(tag)
        }
    }

    private fun addIdealWorkspace() {
        if (ownedWorkspace.size > 8){
            toast("You can not add more than 8 tags.")
        }else if(binding.actvWorkspace.text.isNullOrEmpty()) {
            toast("Please enter work space first.")
        }else if (ownedWorkspace.contains(binding.actvWorkspace.text.toString())){
                toast("This workspace is already exist.")
            }else{
                binding.cgWorkspace.removeAllViews()
                ownedWorkspace.add(binding.actvWorkspace.text.toString())
                ownedWorkspace.forEach { createWorkspaceTag(it)  }
                binding.actvWorkspace.text.clear()
            }

    }

    private fun addInterest() {
        if (binding.actvAreaOfInterest.text.isNullOrEmpty()) {
            toast("Please enter tag first.")
        } else {
            val interestTag = binding.actvAreaOfInterest.text.toString().trim()
            if (!interestTagsSuggestions.contains(interestTag)) {
                saveInterestTag(interestTag)
            }
            if (ownedInterest.contains(interestTag)) {
                toast("This Skill is already exist.")
            } else {
                binding.cgInterests.removeAllViews()
                ownedInterest.add(interestTag)
                ownedInterest.forEach {
                    createInterestTag(it)
                }
                binding.actvAreaOfInterest.text.clear()
            }
        }
    }

    private fun getExistingInterestTags() {
        val query = ParseQuery.getQuery<ParseObject>(ParseTableName.INTERESTS.value)
        query.findInBackground { it, e ->
            when {
                e != null -> {
                    toast(e.message.toString())
                }
                else -> {
                    interestTagsSuggestions.clear()
                    it.forEach {
                        it.getString("name")?.let { tag -> interestTagsSuggestions.add(tag) }
                    }
                    binding.actvAreaOfInterest.setAdapter(ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, interestTagsSuggestions))
                }
            }
        }
    }

    private fun saveInterestTag(tag: String) {
        val activitiesParseObject = ParseObject(ParseTableName.INTERESTS.value)
        activitiesParseObject.put("name", tag)
        activitiesParseObject.saveInBackground {
            if (it != null) {
                ownedInterest.add(tag)
            }
        }
    }

    private fun addHardSkill() {
        val hardSkill = binding.actvHardSkill.text.toString().trim()
        if (! hardSkillSuggestions.contains(hardSkill)){
            saveHardSkillTag(binding.actvHardSkill.text.toString())
        }
        if (ownedHardSkills.filter { it.skillName == hardSkill }.isNotEmpty()) {
            toast("This Skill is already exist.")
        }else{
            ownedHardSkills.add(HardSkill(hardSkill, 3))
            hardSkillAdapter.submitList(ownedHardSkills)
            hardSkillAdapter.notifyDataSetChanged()
            binding.actvHardSkill.text.clear()
        }
    }

    private fun saveHardSkillTag(tag: String) {
        val hardSkillParseObject = ParseObject(ParseTableName.HARD_SKILL.value)
        hardSkillParseObject.put("name", tag)
        hardSkillParseObject.saveInBackground {
            if (it == null){
                hardSkillSuggestions.add(tag)
            }
        }
    }

    private fun getExistingHardSkillTags() {
        val query = ParseQuery.getQuery<ParseObject>(ParseTableName.HARD_SKILL.value)
        query.findInBackground { it, e ->
            val jobSeeker = it?.firstOrNull()
            when {
                e != null -> {
                    toast(e.message.toString())
                }
                jobSeeker == null -> {
                    toast("User Not Found")
                }
                else -> {
                    hardSkillSuggestions.clear()
                    it.forEach {
                        it.getString("name")?.let { tag -> hardSkillSuggestions.add(tag) }
                    }
                    binding.actvHardSkill.setAdapter(ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, hardSkillSuggestions))
                }
            }
        }
    }



    private fun selectPDF() {
        val intent = Intent(Intent.ACTION_GET_CONTENT)
        intent.type = "application/pdf"
        resultLauncher.launch(intent)
    }

    override fun onDestroy() {
        super.onDestroy()
        saveChanges()
    }

    private fun saveChanges( validate: Boolean = false) {
        val hardSkillJsonObj = JSONObject()
        ownedHardSkills.forEach { hardSkillJsonObj.put(it.skillName, it.skillLevel) }
        viewModel.jobSeekerObject?.put(ParseTableFields.HARD_SKILLS.value, hardSkillJsonObj.toString())

        val softSkillJsonArray = JSONArray()
        ownedSoftSkills.forEach { softSkillJsonArray.put(it) }
        viewModel.jobSeekerObject?.put(ParseTableFields.SOFT_SKILLS.value, softSkillJsonArray.toString())

        val interestArray = JSONArray()
        ownedInterest.forEach { interestArray.put(it) }
        viewModel.jobSeekerObject?.put(ParseTableFields.INTERESTS.value, interestArray)

        val workspaceArray = JSONArray()
        ownedWorkspace.forEach { workspaceArray.put(it) }
        viewModel.jobSeekerObject?.put(ParseTableFields.WORKSPACES.value, workspaceArray)

        setName()

        if (binding.etBio.text.toString() != jobSeeker.elevatorPitch) {
            viewModel.jobSeekerObject?.put(ParseTableFields.ELEVATOR_PITCH.value, binding.etBio.text.toString())
        }
        saveJobSeeker {
            if (validate) {
                validate()
            }
        }
    }

    private fun validate() {
        viewModel.jobSeekerObject?.put("seenOnboarding", true)
        progressHud.show()
        viewModel.jobSeekerObject?.saveInBackground { it ->
            progressHud.dismiss()
            if (it == null) {
                requireContext().setSeenOnBoarding(true)
                startActivity(Intent(requireContext(), JobSeekerHomeActivity::class.java))
                requireActivity().finish()
            } else {
                toast(it.message.toString())
            }
        }
    }

    private fun setName() {
        val fullName = binding.etName.text?.toString()?.trim() ?: ""
        if (fullName.isEmpty()) {
            viewModel.jobSeekerObject?.put(ParseTableFields.FIRST_NAME.value, "")
            viewModel.jobSeekerObject?.put(ParseTableFields.LAST_NAME.value, "")
        } else {
            if (fullName.contains(" ")) {
                val nameArr = binding.etName.text.toString().trim().split(" ")
                viewModel.jobSeekerObject?.put(ParseTableFields.FIRST_NAME.value, nameArr[0])
                viewModel.jobSeekerObject?.put(ParseTableFields.LAST_NAME.value, nameArr[1])
            } else {
                viewModel.jobSeekerObject?.put(ParseTableFields.FIRST_NAME.value, fullName)
                viewModel.jobSeekerObject?.put(ParseTableFields.LAST_NAME.value, "")
            }
        }
    }

    private fun setupImagePicker(imageCode: Int) {
        imagePicker = ImagePicker(this, imageCode)
        imagePicker.show(requireActivity().supportFragmentManager, imagePicker.tag)
    }

    override fun setImageUri(imageUri: Uri?, imageCode: Int) {
        imageUri?.let { uri ->
            when(imageCode){
                PROFILE_IMAGE_REQUEST_CODE -> {
                    uploadImage(uri){ url ->
                        url?.let {
                            viewModel.jobSeekerObject?.put("profilePicUrl", url)
                            viewModel.jobSeekerObject?.saveInBackground { exception ->
                                if (exception == null){
                                    try {
                                        (requireActivity() as BuildProfileActivity).getJobSeeker { }
                                    }catch (e: Exception){
                                        try {
                                            (requireActivity() as SeekerCreateCvActivity).getJobSeeker { }
                                        }catch (e: java.lang.Exception){
                                            (requireActivity() as ManualAndPersonalizeActivity).getJobSeeker { }
                                        }
                                    }
                                }else{
                                    toast(exception.message.toString())
                                }
                            }
                        }
                    }
                }
                USER_IMAGES_REQUEST_CODE -> {
                    uploadImage(uri){ url ->
                        url?.let { it ->
                            imagesUrl[imagePosition] = it
                            photosAdapter.submitList(imagesUrl)
                            photosAdapter.notifyDataSetChanged()
                            viewModel.jobSeekerObject?.put("images", ArrayList(imagesUrl.filter { item -> item.isNotEmpty() }))
                            saveJobSeeker {}
                        }
                    }
                }
                PORTFOLIO_IMAGES_REQUEST_CODE -> {
                    uploadImage(uri){ url ->
                        url?.let { it ->
                            portfolioDocLinks.add(it)
                            savePortfolioDocLinks()
                        }
                    }
                }
            }

        }
    }

    private fun saveJobSeeker(callback: (Boolean) -> Unit) {
        progressHud.show()
        viewModel.jobSeekerObject?.saveInBackground { exception ->
            progressHud.dismiss()
            if (exception == null) {
                try {
                    (requireActivity() as BuildProfileActivity).getJobSeeker { }
                }catch (e: Exception){
                    try {
                        (requireActivity() as SeekerCreateCvActivity).getJobSeeker { }
                    }catch (e: java.lang.Exception){
                        try {
                            (requireActivity() as ManualAndPersonalizeActivity).getJobSeeker { }
                        }catch (e: Exception){ }
                    }
                }
                callback(true)
            } else {
                callback(false)
                toast(exception.message.toString())
            }
        }
    }


    private fun uploadImage(profilePicUri: Uri, callback: (String?) -> Unit) {
        val inputStream: InputStream? = requireContext().contentResolver.openInputStream(profilePicUri)
        var fileName = requireContext().getFileName(profilePicUri)
        if (fileName.isEmpty())
            fileName = Date().yyyyMMddHHmmss()
        val parseFile = ParseFile(fileName, inputStream?.readBytes())
        parseFile.saveInBackground(SaveCallback {
            if (it == null) { callback(parseFile.url) } else callback(null)
        })
    }

    private fun changeDrawableColor(tag: View, backgroundColor: Int) {
        val drawable = tag.background.mutate() as GradientDrawable
        drawable.setColor(resources.getColor(backgroundColor, null))
    }


    private fun setPlaceAutocompleteFragment() {
        if (!Places.isInitialized()) {
            Places.initialize(AndroidPlatformModule.getApplicationContext(), getString(R.string.google_maps_key), Locale.US)
        }
        autocompleteFragment = childFragmentManager.findFragmentById(R.id.autocomplete_fragment) as AutocompleteSupportFragment
        autocompleteFragment.setPlaceFields(listOf(Place.Field.ID, Place.Field.ADDRESS, Place.Field.LAT_LNG))
        autocompleteFragment.setOnPlaceSelectedListener(object : PlaceSelectionListener {
            override fun onPlaceSelected(place: Place) {
                val geocoder = Geocoder(requireContext(), Locale.getDefault())
                try {
                    val addresses: List<Address> = place.latLng?.let { place.latLng?.let { it1 -> geocoder.getFromLocation( it.latitude, it1.longitude, 1) } } as List<Address>
                    val city = addresses[0].locality
                    viewModel.jobSeekerObject?.put(ParseTableFields.CITY.value , city)
                    viewModel.jobSeekerObject?.put(ParseTableFields.LAT.value , place.latLng.latitude)
                    viewModel.jobSeekerObject?.put(ParseTableFields.LNG.value , place.latLng.longitude)
                    val gp = ParseGeoPoint().also {
                        it.latitude = place.latLng.latitude
                        it.longitude = place.latLng.longitude
                    }
                    viewModel.jobSeekerObject?.put(ParseTableFields.GEO_LOCATION.value, gp)
                    viewModel.jobSeekerObject?.saveInBackground()
                    binding.tvJobLocation.text = "Localisation : $city"
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
            override fun onError(status: Status) {}
        })
    }
}



class PhotosAdapter(var list: List<String>, val staticView: Boolean) : RecyclerView.Adapter<PhotosAdapter.ViewHolder>() {
    var onImageClick : (Int) -> Unit = {}
    var onRemoveClick : (String) -> Unit = {}
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(ItemPhotoBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.binding.apply {
            if (item.isNotEmpty()){
                loadImageFromUrl(this.ivImage, item,R.drawable.add_icon_image_holder)
            }else{
                loadImageFromUrl(this.ivImage, item,R.drawable.add_icon_image_holder)
            }
            this.ivImage.setOnClickListener {
                onImageClick(position)
            }
            this.ivRemove.setOnClickListener {
                onRemoveClick(item)
            }
            if (staticView) {
                this.ivRemove.visibility = View.GONE
                this.ivImage.isClickable = false
            }else{
                if (item.isEmpty()){
                    this.ivRemove.visibility = View.GONE
                }else{
                    this.ivRemove.visibility = View.VISIBLE
                }
            }
        }
    }
    override fun getItemCount(): Int = list.size
    fun submitList(idealJobImageUrlList: ArrayList<String>) {
        list = idealJobImageUrlList
    }

    class ViewHolder(val binding: ItemPhotoBinding) : RecyclerView.ViewHolder(binding.root)
}

class CustomDropDownEducationAdapter(val context: Context, val educations: ArrayList<Education>) : BaseAdapter() {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val binding = ItemEducationAdapterBinding.inflate(LayoutInflater.from(parent!!.context), parent, false)
        val item = educations[position]
        loadImageFromUrl(binding.ivUniversity, item.logo, R.drawable.school_dummy)
        binding.tvUniversityName.text = item.name

        return binding.root
    }

    override fun getItem(position: Int): Education = educations[position]
    override fun getCount(): Int = educations.size
    override fun getItemId(position: Int): Long = position.toLong()
}

class SeekerEducationAdapter(
    var list: ArrayList<Education>,
    val requireContext: Context,
    val staticView: Boolean
) : RecyclerView.Adapter<SeekerEducationAdapter.ViewHolder>(){
    var clickListener: (Education) -> Unit = {}
    var onItemClick: (Education) -> Unit = {}
    var cardShadowColor = R.color.screen_background
    var firstColor = R.color.theme_light_blue
    var secondColor = R.color.theme_dark_blue
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
        ItemSeekerEducationBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val education = list[position]
        holder.setIsRecyclable(false)
        holder.binding.apply {
            this.cvEducationItem.setCardBackgroundColor(requireContext.resources.getColor(cardShadowColor, null))
            changeStrokeColor(this.clIv, firstColor, secondColor)
            this.ivUser.borderColor = requireContext.resources.getColor(cardShadowColor, null)
            this.tvInstituteName.text = education.name
            this.tvProgramName.text = education.program
            this.tvDescription.text = education.description

            this.cvEducationItem.setOnClickListener {
                if (this.tvDescription.maxLines == 1){
                    this.tvDescription.maxLines = Integer.MAX_VALUE
                    this.tvDescription.ellipsize = null
                }else{
                    this.tvDescription.maxLines = 1
                    this.tvDescription.ellipsize = TextUtils.TruncateAt.END
                }
             }
            loadImageFromUrl(this.ivUser,education.logo ,R.drawable.school_dummy)
            when {
                education.startDate == "" -> {
                    this.tvDateDuration.visibility = View.GONE
                }
                education.endDate == "" -> {
                    this.tvDateDuration.text = convertDateToCurrentLanguage(education.startDate, requireContext.getLanguage()) +" - Present"
                }
                else -> {
                    this.tvDateDuration.text = convertDateToCurrentLanguage(education.startDate, requireContext.getLanguage()) +" - "+ convertDateToCurrentLanguage(education.endDate, requireContext.getLanguage())
                }
            }
            this.rlParent.setOnClickListener {
                onItemClick(education)
            }

            this.ivDeleteItem.setOnClickListener {
                clickListener(education)
            }
            if (staticView) {
                this.ivDeleteItem.visibility = View.GONE
                this.ivArrowRight.visibility = View.GONE
                this.rlParent.isClickable = false
            }
        }
    }
    override fun getItemCount(): Int  = list.size
    fun submitList(educations: ArrayList<Education>) {
        list = educations
    }

    fun changeCardBackgroundColor(shadowColor: Int, gradientFirstColor: Int, gradientSecondColor: Int) {
        cardShadowColor = shadowColor
        firstColor = gradientFirstColor
        secondColor = gradientSecondColor
    }

    private fun changeStrokeColor(tag: View, firstColor: Int, secondColor: Int) {
         if (android.os.Build.VERSION.SDK_INT > 28){
            val drawable = tag.background.mutate() as LayerDrawable
            val item1 = drawable.getDrawable(0) as GradientDrawable
            item1.colors = intArrayOf(requireContext.resources.getColor(firstColor, null) ,  requireContext.resources.getColor(secondColor, null))
        }else{
            val gd = GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, intArrayOf(requireContext.resources.getColor(firstColor, null) ,  requireContext.resources.getColor(secondColor, null)))
            gd.cornerRadius = 100f
            tag.background = gd
        }
    }

    class ViewHolder(val binding: ItemSeekerEducationBinding) : RecyclerView.ViewHolder(binding.root)
}


class SeekerExperienceListAdapter(
    var list: ArrayList<Experience>,
    val requireContext: Context,
    private val staticView: Boolean
) : RecyclerView.Adapter<SeekerExperienceListAdapter.ViewHolder>() {
    var clickListener: (Experience) -> Unit = {}
    var onItemClick: (Experience) -> Unit = {}
    var cardShadowColor = R.color.screen_background
    var firstColor = R.color.theme_light_blue
    var secondColor = R.color.theme_dark_blue
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(ItemSeekerExperienceBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val experience = list[position]
        holder.setIsRecyclable(false)
        holder.binding.apply {
            this.cvExperienceItem.setCardBackgroundColor(requireContext.resources.getColor(cardShadowColor, null))
            changeStrokeColor(this.clIv, firstColor, secondColor)
            this.ivCompany.borderColor = requireContext.resources.getColor(cardShadowColor, null)
            this.tvJobName.text = experience.job
            this.tvCompanyName.text = experience.company
            this.tvDescription.text = experience.description
            this.cvExperienceItem.setOnClickListener {
                if (this.tvDescription.maxLines == 1){
                    this.tvDescription.maxLines = Integer.MAX_VALUE
                    this.tvDescription.ellipsize = null
                }else{
                    this.tvDescription.maxLines = 1
                    this.tvDescription.ellipsize = TextUtils.TruncateAt.END
                }
            }
            loadImageFromUrl(this.ivCompany, experience.logo, R.drawable.experience_dummy)
            when {
                experience.startDate == "" -> {
                    this.tvDateDuration.visibility = View.GONE
                }
                experience.endDate == "" -> {
                    this.tvDateDuration.text = convertDateToCurrentLanguage(experience.startDate, requireContext.getLanguage()) +" - Present"
                }
                else -> {
                    this.tvDateDuration.text = convertDateToCurrentLanguage(experience.startDate, requireContext.getLanguage()) +" - "+ convertDateToCurrentLanguage(experience.endDate, requireContext.getLanguage())
                }
            }
            this.ivDeleteItem.setOnClickListener {
                clickListener(experience)
            }
            this.rlParent.setOnClickListener {
                onItemClick(experience)
            }

            if (staticView) {
                this.ivDeleteItem.visibility = View.GONE
                this.ivArrowRight.visibility = View.GONE
                this.rlParent.isClickable = false
            }
        }
    }
    override fun getItemCount(): Int = list.size
    fun submitList(experiences: ArrayList<Experience>) {
        list = experiences
    }

    fun changeCardBackgroundColor(shadowColor: Int, gradientFirstColor: Int, gradientSecondColor: Int) {
        cardShadowColor = shadowColor
        firstColor = gradientFirstColor
        secondColor = gradientSecondColor
    }

    private fun changeStrokeColor(tag: View, firstColor: Int, secondColor: Int) {
        if (android.os.Build.VERSION.SDK_INT > 28){
            val drawable = tag.background.mutate() as LayerDrawable
            val item1 = drawable.getDrawable(0) as GradientDrawable
            item1.colors = intArrayOf(requireContext.resources.getColor(firstColor, null) ,  requireContext.resources.getColor(secondColor, null))
        }else{
            val gd = GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, intArrayOf(requireContext.resources.getColor(firstColor, null) ,  requireContext.resources.getColor(secondColor, null)))
            gd.cornerRadius = 100f
            tag.background = gd
        }
    }

    class ViewHolder(val binding: ItemSeekerExperienceBinding) : RecyclerView.ViewHolder(binding.root)
}


class SeekerVolunteeringAdapter(
    var list: ArrayList<Volunteering>,
    val requireContext: Context,
    val staticView: Boolean
) : RecyclerView.Adapter<SeekerVolunteeringAdapter.ViewHolder>(){
    var clickListener: (Volunteering) -> Unit = {}
    var onItemClick: (Volunteering) -> Unit = {}
    var cardShadowColor = R.color.screen_background
    var firstColor = R.color.theme_light_blue
    var secondColor = R.color.theme_dark_blue
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(ItemSeekerVolunteeringBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val volunteering = list[position]
        holder.setIsRecyclable(false)
        holder.binding.apply {
            this.cvVolunteeringItem.setCardBackgroundColor(requireContext.resources.getColor(cardShadowColor, null))
            changeStrokeColor(this.clIv, firstColor, secondColor)
            this.ivCompany.borderColor = requireContext.resources.getColor(cardShadowColor, null)
            loadImageFromUrl(this.ivCompany, volunteering.logo, R.drawable.volunteering_dummy)
            this.tvCompanyName.text = volunteering.company
            this.tvJob.text = volunteering.job
            this.tvDescription.text = volunteering.description
            this.cvVolunteeringItem.setOnClickListener {
                if (this.tvDescription.maxLines == 1){
                    this.tvDescription.maxLines = Integer.MAX_VALUE
                    this.tvDescription.ellipsize = null
                }else{
                    this.tvDescription.maxLines = 1
                    this.tvDescription.ellipsize = TextUtils.TruncateAt.END
                }
            }
            when {
                volunteering.startDate == "" -> {
                    this.tvDateDuration.visibility = View.GONE
                }
                volunteering.endDate == "" -> {
                    this.tvDateDuration.text = convertDateToCurrentLanguage(volunteering.startDate, requireContext.getLanguage()) +" - Present"
                }
                else -> {
                    this.tvDateDuration.text = convertDateToCurrentLanguage(volunteering.startDate, requireContext.getLanguage()) +" - "+ convertDateToCurrentLanguage(volunteering.endDate, requireContext.getLanguage())
                }
            }
            this.rlParent.setOnClickListener {
                onItemClick(volunteering)
            }
            this.ivDeleteItem.setOnClickListener {
                clickListener(volunteering)
            }

            if (staticView) {
                this.ivDeleteItem.visibility = View.GONE
                this.ivArrowRight.visibility = View.GONE
                this.rlParent.isClickable = false
            }
        }
    }
    override fun getItemCount(): Int  = list.size
    fun submitList(volunteerings: ArrayList<Volunteering>) {
        list = volunteerings
    }

    fun changeCardBackgroundColor(shadowColor: Int, gradientFirstColor: Int, gradientSecondColor: Int) {
        cardShadowColor = shadowColor
        firstColor = gradientFirstColor
        secondColor = gradientSecondColor
    }

    private fun changeStrokeColor(tag: View, firstColor: Int, secondColor: Int) {
        if (android.os.Build.VERSION.SDK_INT > 28){
            val drawable = tag.background.mutate() as LayerDrawable
            val item1 = drawable.getDrawable(0) as GradientDrawable
            item1.colors = intArrayOf(requireContext.resources.getColor(firstColor, null) ,  requireContext.resources.getColor(secondColor, null))
        }else{
            val gd = GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, intArrayOf(requireContext.resources.getColor(firstColor, null) ,  requireContext.resources.getColor(secondColor, null)))
            gd.cornerRadius = 100f
            tag.background = gd
        }
    }

    class ViewHolder(val binding: ItemSeekerVolunteeringBinding) : RecyclerView.ViewHolder(binding.root)
}
