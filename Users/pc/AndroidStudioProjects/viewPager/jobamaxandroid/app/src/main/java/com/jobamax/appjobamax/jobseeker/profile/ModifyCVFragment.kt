package com.jobamax.appjobamax.jobseeker.profile

import android.Manifest
import android.content.Intent
import android.location.Address
import android.location.Geocoder
import android.net.Uri
import android.os.Bundle
import android.view.*
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
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
import com.jobamax.appjobamax.databinding.FragmentModifyCVBinding
import com.jobamax.appjobamax.dialog.*
import com.jobamax.appjobamax.enums.ParseTableFields
import com.jobamax.appjobamax.enums.ParseTableName
import com.jobamax.appjobamax.extensions.checkForPermissions
import com.jobamax.appjobamax.extensions.log
import com.jobamax.appjobamax.extensions.toast
import com.jobamax.appjobamax.extensions.yyyyMMddHHmmss
import com.jobamax.appjobamax.jobseeker.JobSeekerHomeActivity
import com.jobamax.appjobamax.jobseeker.build_profile.*
import com.jobamax.appjobamax.jobseeker.dialog.DialogAddDocument
import com.jobamax.appjobamax.jobseeker.dialog.DialogAddLink
import com.jobamax.appjobamax.jobseeker.dialog.DialogChangeUniversity
import com.jobamax.appjobamax.jobseeker.dialog.DialogWorkType
import com.jobamax.appjobamax.jobseeker.search.ManualAndPersonalizeActivity
import com.jobamax.appjobamax.jobseeker.view_model.SeekerHomeViewModel
import com.jobamax.appjobamax.model.Experience
import com.jobamax.appjobamax.model.ExperienceGroup
import com.jobamax.appjobamax.model.Volunteering
import com.jobamax.appjobamax.model.VolunteeringGroup
import com.jobamax.appjobamax.model.*
import com.jobamax.appjobamax.recruiter.home.PortfolioLinksAdapter
import com.jobamax.appjobamax.recruiter.home.SeekerHardSkillAdapter
import com.jobamax.appjobamax.util.*
import com.parse.*
import com.pushwoosh.internal.platform.AndroidPlatformModule
import org.json.JSONArray
import org.json.JSONObject
import java.io.InputStream
import java.util.*
import kotlin.collections.ArrayList


class ModifyCVFragment : BaseFragment(), ImagePicker.GetImage  {
    lateinit var binding: FragmentModifyCVBinding

    lateinit var autocompleteFragment: AutocompleteSupportFragment

    private lateinit var photosAdapter: PhotosAdapter

    lateinit var hardSkillAdapter: SeekerHardSkillAdapter
    private var ownedHardSkills = ArrayList<HardSkill>()
    private var hardSkillSuggestions = ArrayList<String>()

    private var ownedSoftSkills = ArrayList<String>()
    var softSkillSuggestions = ArrayList<String>()

    private var ownedInterest = ArrayList<String>()
    private var interestTagsSuggestions = java.util.ArrayList<String>()

    private var ownedWorkspace = ArrayList<String>()

    lateinit var portfolioLinkAdapter: PortfolioLinksAdapter
    lateinit var portfolioDocLinkAdapter: PortfolioLinksAdapter
    val portfolioLinks = arrayListOf<String>()
    val portfolioDocLinks = arrayListOf<String>()

    lateinit var jobSeeker: JobSeeker

    val viewModel: SeekerHomeViewModel by activityViewModels()

    var profileCompletePercentage = 0

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
        binding = FragmentModifyCVBinding.inflate(inflater, container, false)
        configureUi()
        return binding.root
    }

    private fun configureUi() {
        setClickListeners()
        setPlaceAutocompleteFragment()
        setPortfolioDocLinkAdapter()
        setPortfolioLinkAdapter()
        setEducationAdapter()
        setExperienceAdapter()
        setVolunteeringAdapter()
        setPhotosAdapter()
        setHardSkillAdapter()
        initializeJobSeeker()
        setObserver()
        getExistingHardSkillTags()
        getExistingSoftSkillTags()

        try {
            val updateAppBar = arguments?.getBoolean("arg_update_app_bar")
            updateAppBar?.let {
                if (updateAppBar){
                    binding.clAppBar1.visibility = View.GONE
                    binding.clAppBar2.visibility = View.VISIBLE
                }else{
                    binding.clAppBar1.visibility = View.VISIBLE
                    binding.clAppBar2.visibility = View.GONE
                }
            }
        }catch (e: Exception){
            binding.clAppBar1.visibility = View.VISIBLE
            binding.clAppBar2.visibility = View.GONE
        }
        binding.tvProfileMatchPer.paint.shader = getShader(binding.tvProfileMatchPer)
        changeDrawableColor(binding.llImportProfile, R.color.background_blue)
        changeDrawableColor(binding.clVideoIntro, R.color.background_blue)
        changeDrawableColor(binding.clAudioIntro, R.color.background_blue)
     }



    private fun setObserver() {
        viewModel.isJobSeekerUpdated.observe(viewLifecycleOwner){
            if (it){
                jobSeeker = viewModel.jobSeeker
                setData()
            }
        }
    }

    private fun setData()  {

        loadImageFromUrl(binding.civUser, jobSeeker.profilePicUrl, R.drawable.default_user_img)

        binding.tvWorkTypes.text = "Recherche : ${jobSeeker.interestedIn.joinToString()}"

        val university = gson.fromJson(jobSeeker.university, University::class.java)
        if (university != null) {
            if (university.isCurrent){
                binding.tvStatus.text = "Statut : étudiant"
            }else{
                binding.tvStatus.text = "Statut : jeune actif"
            }
        }

        val jobLocation = gson.fromJson(jobSeeker.jobLocation, JobLocation::class.java)
        if (jobLocation != null) {
            binding.tvJobLocation.text = "Localisation : "+jobLocation.city
        }

        binding.etBio.setText(jobSeeker.elevatorPitch)

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

        ownedInterest.clear()
        jobSeeker.interests.forEach { ownedInterest.add(it) }
        binding.cgInterests.removeAllViews()
        ownedInterest.forEach { createInterestTag(it) }

        ownedWorkspace.clear()
        jobSeeker.workspaces.forEach { ownedWorkspace.add(it) }
        binding.cgWorkspace.removeAllViews()
        jobSeeker.workspaces.forEach { createWorkspaceTag(it) }



        val customDropDownAdapter = CustomDropDownEducationAdapter(requireContext(), educations)
        binding.spEducation.adapter = customDropDownAdapter
        binding.spEducation.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, position: Int, p3: Long) {
                if (educations[position] != educations[0]){
                    Collections.swap(educations, educations.indexOf(educations[position]), 0)
                    viewModel.jobSeekerObject?.put(ParseTableFields.EDUCATIONS.value, gson.toJson(EducationGroup(educations)) )
                    saveJobSeeker {  }
                }
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {}
        }

        calculateCompleteProfile()
    }

    private fun calculateCompleteProfile() {
         val list = jobSeeker.run {
             arrayListOf(
                 this.profilePicUrl.isNotEmpty(),
                 this.firstName.isNotEmpty(),
                 this.university.isNotEmpty(),
                 this.interestedIn.isNotEmpty(),
                 this.city.isNotEmpty(),
                 this.elevatorPitch.isNotEmpty(),
                 this.educations.isNotEmpty(),
                 this.introVideoUrl.isNotEmpty(),
                 this.introAudioUrl.isNotEmpty(),
                 this.experiences.isNotEmpty(),
                 this.hardSkills.isNotEmpty(),
                 this.softSkills.isNotEmpty(),
                 this.volunteerings.isNotEmpty(),
                 this.interests.isNotEmpty(),
                 this.images.isNotEmpty(),
                 this.workspaces.isNotEmpty()
             )
         }
        profileCompletePercentage = (100 * list.filter { it }.size) / list.size
        binding.tvProfileMatchPer.text = "complété à $profileCompletePercentage%"
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


    private fun getOwnedSoftSkills() {
        ownedSoftSkills = jobSeeker.softSkills
    }

    private fun setExperienceAdapter() {
        experienceAdapter = SeekerExperienceListAdapter(experiences, requireContext(), false)
        binding.rvExperience.adapter = experienceAdapter
        experienceAdapter.clickListener = { experience ->
            YesNoDialog(requireActivity(), resources.getString(R.string.are_you_sure), {
                experiences.remove(experience)
                val experienceGroup = ExperienceGroup(experiences)
                viewModel.jobSeekerObject?.put(ParseTableFields.COMPANY_NAMES.value, java.util.ArrayList(experienceGroup.list.map { it.company.lowercase() }.filter { it.isNotEmpty() }))
                viewModel.jobSeekerObject?.put(ParseTableFields.EXPERIENCES.value, gson.toJson(experienceGroup))
                progressHud.show()
                viewModel.jobSeekerObject!!.saveInBackground {
                    progressHud.dismiss()
                    if (it != null) {
                        toast(it.message.toString())
                    }
                    try {
                        (requireActivity() as SeekerCreateCvActivity).getJobSeeker {  }
                    }catch (e: Exception){
                        try {
                            (requireActivity() as ManualAndPersonalizeActivity).getJobSeeker {  }
                        }catch (e: Exception){}
                    }
                }
            }, {}).show()
        }
        experienceAdapter.onItemClick = {   experience ->
            val bundle = Bundle()
            bundle.putSerializable("experience", experience)
            findNavController().navigate(R.id.action_modifyCVFragment_to_addNewExperienceFragment, bundle)
        }
    }

    private fun setEducationAdapter() {
        educationAdapter = SeekerEducationAdapter(educations, requireContext(), false)
        binding.rvEducation.adapter = educationAdapter
        educationAdapter.clickListener = {  education ->
            YesNoDialog(requireActivity(), resources.getString(R.string.are_you_sure),{
                educations.remove(education)
                val educationGroup = EducationGroup(educations)
                viewModel.jobSeekerObject?.put(ParseTableFields.EDUCATIONS.value, gson.toJson(educationGroup))
                progressHud.show()
                viewModel.jobSeekerObject!!.saveInBackground {
                    progressHud.dismiss()
                    if (it != null) {
                        toast(it.message.toString())
                    }
                    try {
                        (requireActivity() as SeekerCreateCvActivity).getJobSeeker {  }
                    }catch (e: Exception){
                        try {
                            (requireActivity() as ManualAndPersonalizeActivity).getJobSeeker {  }
                        }catch (e: Exception){}
                    }
                }
            }, {}).show()
        }
        educationAdapter.onItemClick = {    education ->
            val bundle = Bundle()
            bundle.putSerializable("education", education)
            findNavController().navigate(R.id.action_modifyCVFragment_to_addNewEducationFragment, bundle)
        }
    }

    private fun setVolunteeringAdapter() {
        volunteeringAdapter = SeekerVolunteeringAdapter(volunteerings, requireContext(), false)
        binding.rvVolunteering.adapter = volunteeringAdapter
        volunteeringAdapter.clickListener = { volunteering ->
            YesNoDialog(requireActivity(), resources.getString(R.string.are_you_sure), {
                volunteerings.remove(volunteering)
                val volunteeringGroup = VolunteeringGroup(volunteerings)
                viewModel.jobSeekerObject?.put(ParseTableFields.VOLUNTEERINGS.value, gson.toJson(volunteeringGroup))
                progressHud.show()
                viewModel.jobSeekerObject!!.saveInBackground {
                    progressHud.dismiss()
                    if (it != null) {
                        toast(it.message.toString())
                    }
                    try {
                        (requireActivity() as SeekerCreateCvActivity).getJobSeeker {  }
                    }catch (e: Exception){
                        try {
                            (requireActivity() as ManualAndPersonalizeActivity).getJobSeeker {  }
                        }catch (e: Exception){}
                    }
                }
            }, {}).show()
        }
        volunteeringAdapter.onItemClick = { volunteering ->
            val bundle = Bundle()
            bundle.putSerializable("volunteering", volunteering)
            findNavController().navigate(R.id.action_modifyCVFragment_to_addNewVolunteeringFragment, bundle)
        }
    }

    private fun initializeJobSeeker() {
        jobSeeker = viewModel.jobSeeker
        if (viewModel.jobSeekerObject == null) {
            try {
                (requireActivity() as ManualAndPersonalizeActivity).getJobSeeker {
                    if (it) {
                        jobSeeker = viewModel.jobSeeker
                    }
                }
            }catch (e: Exception){
                (requireActivity() as SeekerCreateCvActivity).getJobSeeker {
                    if (it) {
                        jobSeeker = viewModel.jobSeeker
                    }
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
        photosAdapter.onRemoveClick = { photoUrl ->
            imagesUrl.remove(photoUrl)
            while (imagesUrl.size < 6){
                imagesUrl.add("")
            }
            photosAdapter.submitList(imagesUrl)
            photosAdapter.notifyDataSetChanged()
            viewModel.jobSeekerObject?.put("images", ArrayList(imagesUrl.filter { item -> item.isNotEmpty() }))
            saveJobSeeker {}
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

    private fun setPortfolioLinkAdapter() {
        portfolioLinkAdapter = PortfolioLinksAdapter(portfolioLinks)
        binding.rvPortfolioLink.adapter = portfolioLinkAdapter
        portfolioLinkAdapter.onRemoveLinkClick = {
            portfolioLinks.remove(it)
            savePortfolioLinks()
            portfolioLinkAdapter.submitList(portfolioLinks)
            portfolioLinkAdapter.notifyDataSetChanged()
        }
    }

    private fun setPortfolioDocLinkAdapter() {
        portfolioDocLinkAdapter = PortfolioLinksAdapter(portfolioDocLinks)
        binding.rvPortfolioDocLink.adapter = portfolioDocLinkAdapter
        portfolioDocLinkAdapter.onRemoveLinkClick = {
            portfolioDocLinks.remove(it)
            portfolioDocLinkAdapter.submitList(portfolioDocLinks)
            portfolioDocLinkAdapter.notifyDataSetChanged()
            savePortfolioDocLinks()
        }
    }

    private fun savePortfolioDocLinks() {
        viewModel.jobSeekerObject?.put(ParseTableFields.PORTFOLIO_DOC_LINKS.value, portfolioDocLinks)
        viewModel.jobSeekerObject?.saveInBackground { exception ->
            if (exception == null) {
                try {
                    (requireActivity() as BuildProfileActivity ).getJobSeeker { }
                }catch (e: Exception){
                    try {
                        (requireActivity() as ManualAndPersonalizeActivity).getJobSeeker { }
                    }catch (e: Exception){
                        (requireActivity() as SeekerCreateCvActivity).getJobSeeker { }
                    }
                }
            }
        }
    }
    private fun savePortfolioLinks() {
        viewModel.jobSeekerObject?.put(ParseTableFields.PORTFOLIO_LINKS.value, portfolioLinks)
        viewModel.jobSeekerObject?.saveInBackground { exception ->
            if (exception == null) {
                try {
                    (requireActivity() as BuildProfileActivity).getJobSeeker { }
                }catch (e: Exception){
                    try {
                        (requireActivity() as ManualAndPersonalizeActivity).getJobSeeker { }
                    }catch (e: Exception){
                        (requireActivity() as SeekerCreateCvActivity).getJobSeeker { }
                    }
                }
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
        tvContract.updatePadding(20, 0,20,0)
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
        tvContract.updatePadding(20, 0,20,0)
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
        tvContract.updatePadding(20, 0,20,0)
        binding.cgWorkspace.addView(chip)
    }

    private fun setClickListeners() {
        binding.ivBackButton.setOnClickListener { requireActivity().onBackPressed() }
        binding.ivBackButton2.setOnClickListener { requireActivity().onBackPressed() }
        binding.btnFormateCv.setOnClickListener {
            saveChanges()
            findNavController().navigate(R.id.action_modifyCVFragment_to_seekerFormatCvFragment, null)
        }
        val b =  Bundle().also {
            it.putBoolean("is_return_back", true)
        }
        binding.ivImportResume.setOnClickListener { findNavController().navigate(R.id.action_modifyCVFragment_to_importProfileFromLinkedIn,  b)}
        binding.ivAddWorkspaceBtn.setOnClickListener { addIdealWorkspace() }
        binding.clAudioIntro.setOnClickListener { findNavController().navigate(R.id.action_modifyCVFragment_to_audioDemoFragment, null) }
        binding.clVideoIntro.setOnClickListener { findNavController().navigate(R.id.action_modifyCVFragment_to_videoDemoFragment, null) }
        binding.ivAddEducation.setOnClickListener { findNavController().navigate(R.id.action_modifyCVFragment_to_addNewEducationFragment, null) }
        binding.ivAddExperience.setOnClickListener { findNavController().navigate(R.id.action_modifyCVFragment_to_addNewExperienceFragment, null) }
        binding.ivAddVolunteering.setOnClickListener { findNavController().navigate(R.id.action_modifyCVFragment_to_addNewVolunteeringFragment, null) }
        binding.ivAddHardSkill.setOnClickListener {
            if (binding.actvHardSkill.text.isNullOrEmpty()){
                toast("Please first enter the tag.")
            }else{
                addHardSkill()
            }
        }
        binding.ivAddSoftSkill.setOnClickListener { addSoftSkill() }
        binding.ivAddAreaOfInterest.setOnClickListener { addInterest() }
        binding.cvUpdateImage.setOnClickListener {
            if (requireActivity().checkForPermissions(arrayOf(Manifest.permission.CAMERA))) {
                setupImagePicker(PROFILE_IMAGE_REQUEST_CODE)
            }
        }

        binding.clAddLink.setOnClickListener {
            val dialog = DialogAddLink(requireActivity())
            dialog.onAddLinkClick = {
                portfolioLinks.add(it)
                savePortfolioLinks()
            }
            val window: Window? = dialog.window
            window?.let {
                val wlp = it.attributes
                wlp.gravity = Gravity.BOTTOM
                it.attributes = wlp
            }
            dialog.show()
        }
        binding.clAddDocument.setOnClickListener {
            val dialog = DialogAddDocument(requireActivity())
            dialog.onPdfClick = {
                selectPDF()
            }
            dialog.onImageClick = {
                setupImagePicker(PORTFOLIO_IMAGES_REQUEST_CODE)
            }
            val window: Window? = dialog.window
            window?.let {
                val wlp = it.attributes
                wlp.gravity = Gravity.BOTTOM
                it.attributes = wlp
            }
            dialog.show()
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
                        try {
                            (requireActivity() as BuildProfileActivity).getJobSeeker {  }
                        }catch (e: Exception){
                            try {
                                (requireActivity() as ManualAndPersonalizeActivity).getJobSeeker {  }
                            }catch (e: Exception){
                                try {
                                    (requireActivity() as SeekerCreateCvActivity).getJobSeeker {  }
                                }catch (e: Exception){ }
                            }
                        }
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

        binding.clUniversity.setOnClickListener {
            val dialog = DialogChangeUniversity(requireActivity())
            dialog.onDoneClick = {  university ->
                viewModel.jobSeekerObject?.put(ParseTableFields.UNIVERSITY.value, gson.toJson(university))
                viewModel.jobSeekerObject?.saveInBackground { exception ->
                    if (exception == null) {
                        try {
                            (activity as BuildProfileActivity).getJobSeeker {  }
                        }catch (e: Exception){
                                try {
                                    (activity as ManualAndPersonalizeActivity).getJobSeeker {  }
                                }catch (e: Exception){
                                    try {
                                        (activity as SeekerCreateCvActivity).getJobSeeker {  }
                                    }catch (e: Exception){ }
                                }
                        }
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

    private fun addHardSkill() {
        val hardSkill = binding.actvHardSkill.text.toString()
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
                    try {
                        binding.actvHardSkill.setAdapter(ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, hardSkillSuggestions))
                    }catch (e: Exception){ log(e.message.toString()+" Something went wrong.") }
                }
            }
        }
    }



    private fun selectPDF() {
        val intent = Intent(Intent.ACTION_GET_CONTENT)
        intent.type = "application/pdf"
        resultLauncher.launch(intent)
    }

    private val resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
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

    override fun onDestroy() {
        super.onDestroy()
        saveChanges()
    }


    private fun saveChanges() {
        setName()

        viewModel.jobSeekerObject?.put(ParseTableFields.PROFILE_PERCENTAGE.value, profileCompletePercentage)

        if (binding.etBio.text.toString() != jobSeeker.elevatorPitch) {
            viewModel.jobSeekerObject?.put(ParseTableFields.ELEVATOR_PITCH.value, binding.etBio.text.toString())
        }
        val hardSkillJsonObj = JSONObject()
        ownedHardSkills.forEach { hardSkillJsonObj.put(it.skillName, it.skillLevel) }
        viewModel.jobSeekerObject?.put(ParseTableFields.HARD_SKILLS.value, hardSkillJsonObj.toString())

        val softSkillJsonArray = JSONArray()
        ownedSoftSkills.forEach { softSkillJsonArray.put(it) }
        viewModel.jobSeekerObject?.put(ParseTableFields.SOFT_SKILLS.value, softSkillJsonArray.toString())

        val softInterestArray = JSONArray()
        ownedInterest.forEach { softInterestArray.put(it) }
        viewModel.jobSeekerObject?.put(ParseTableFields.INTERESTS.value, softInterestArray)

        val softWorkspaceArray = JSONArray()
        ownedWorkspace.forEach { softWorkspaceArray.put(it) }
        viewModel.jobSeekerObject?.put(ParseTableFields.WORKSPACES.value, softWorkspaceArray)
        saveJobSeeker {  }
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
                                            (requireActivity() as ManualAndPersonalizeActivity).getJobSeeker { }
                                            (requireActivity() as JobSeekerHomeActivity).setData()
                                        }catch (e : Exception){
                                            (requireActivity() as SeekerCreateCvActivity).getJobSeeker { }
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
        viewModel.jobSeekerObject?.saveInBackground { exception ->
            if (exception == null) {
                callback(true)
                viewModel.isJobSeekerUpdated.value = true
            } else {
                callback(false)
                log(exception.message.toString()+" Something went wrong")
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




}
