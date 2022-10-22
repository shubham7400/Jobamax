package com.jobamax.appjobamax.recruiter.search

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.location.Address
import android.location.Geocoder
import android.os.Bundle
import android.view.*
import android.widget.AdapterView
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.updatePadding
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.activityViewModels
import com.google.android.gms.common.api.Status
import com.google.android.libraries.places.api.Places
import com.google.android.libraries.places.api.model.Place
import com.google.android.libraries.places.widget.AutocompleteSupportFragment
import com.google.android.libraries.places.widget.listener.PlaceSelectionListener
import com.google.android.material.chip.ChipGroup
import com.google.gson.Gson
import com.jobamax.appjobamax.R
import com.jobamax.appjobamax.databinding.FragmentRecruiterAddJobSourcingCriteriaBinding
import com.jobamax.appjobamax.enums.ParseCloudFunction
import com.jobamax.appjobamax.enums.ParseTableFields
import com.jobamax.appjobamax.extensions.toast
import com.jobamax.appjobamax.model.Recruiter
import com.jobamax.appjobamax.preference.getUserId
import com.jobamax.appjobamax.recruiter.RecruiterHomeActivity
import com.jobamax.appjobamax.recruiter.RecruiterHomeViewModel
import com.jobamax.appjobamax.recruiter.dialog.DialogWorkExperience
import com.jobamax.appjobamax.recruiter.dialog.DialogWorkType2
import com.jobamax.appjobamax.recruiter.model.SourcingCriteria
import com.jobamax.appjobamax.util.experienceMap
import com.parse.FunctionCallback
import com.parse.ParseCloud
import com.pushwoosh.internal.platform.AndroidPlatformModule
import org.json.JSONArray
import java.util.*

class RecruiterAddJobSourcingCriteriaDialogFragment : DialogFragment() {
    lateinit var binding: FragmentRecruiterAddJobSourcingCriteriaBinding

    val viewModel: RecruiterHomeViewModel by activityViewModels()
    lateinit var recruiter: Recruiter

    val gson = Gson()

    lateinit var autocompleteFragment: AutocompleteSupportFragment

    var selectedSourcingCriteria: SourcingCriteria? = null
    var selectedCity = ""
    var selectedWorkTypes = arrayListOf<String>()
    var selectedWorkExperience = ""

    var lat: Double?  = null
    var lng: Double? = null

    lateinit var spinnerAdapter: SourcingCriteriaSpinnerAdapter
    private val sourcingCriteriaListTitleObject = SourcingCriteria(arrayListOf(),"", arrayListOf(), arrayListOf(), "", arrayListOf(), "", "ajouter un tag sourcing", arrayListOf(),"", 0.0,0.0)
    private val sourcingCriteriaListAddMoreObject = SourcingCriteria(arrayListOf(),"", arrayListOf(), arrayListOf(), "", arrayListOf(), "", "ajouter un tag sourcing", arrayListOf(),"", 0.0, 0.0)
    var sourcingCriteriaList = arrayListOf(sourcingCriteriaListTitleObject, sourcingCriteriaListAddMoreObject)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentRecruiterAddJobSourcingCriteriaBinding.inflate(inflater, container, false)
        configureUi()
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    }

    private fun configureUi() {
        setClickListeners()
        setPlaceAutocompleteFragment()
        setObserver()
        initializeRecruiter()

        spinnerAdapter = SourcingCriteriaSpinnerAdapter(requireActivity(),R.layout.item_textview, sourcingCriteriaList)
        binding.sp1.adapter = spinnerAdapter
        binding.sp1.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, view: View?, position: Int, p3: Long) {
                updateUi(sourcingCriteriaList[position])
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {}
        }
        spinnerAdapter. onTitleClick = {
            binding.sp1.onDetachedFromWindow()
        }
        spinnerAdapter.onAddSourcingClick = {
            clearAllFields()

            binding.sp1.onDetachedFromWindow()
            binding.sp1.setSelection(0)
            spinnerAdapter.sourcingId = ""
            spinnerAdapter.notifyDataSetChanged()
        }

        if (viewModel.sourcingCriteriaList.value!!.isEmpty()){
            getSourcingCriteria()
        }else{
            updateJobCriteriaList()
        }
    }

    private fun clearAllFields() {
        selectedSourcingCriteria = null
        selectedCity = ""
        selectedWorkTypes.clear()

        binding.etTitle.setText("")
        binding.tvLocation.text = ""
        binding.tvTypeOfWork.text = ""
        binding.tvExperience.text = ""
        binding.etJobTitle.text.clear()
        binding.cgUniversityTags.removeAllViews()
        binding.cgSkillTags.removeAllViews()
        binding.cgCompanyTags.removeAllViews()
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
                    lat = place.latLng.latitude
                    lng = place.latLng.longitude
                    val addresses: List<Address> =
                        place.latLng?.let { place.latLng?.let { it1 -> geocoder.getFromLocation( it.latitude, it1.longitude, 1) } } as List<Address>
                    selectedCity = addresses[0].locality
                    binding.tvLocation.text = selectedCity
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
            override fun onError(status: Status) {}
        })
    }


    private fun updateUi(sourcingCriteria: SourcingCriteria) {
        selectedSourcingCriteria = sourcingCriteria

        selectedCity = sourcingCriteria.location
        selectedWorkTypes.clear()
        sourcingCriteria.typeOfWork.forEach { selectedWorkTypes.add(it) }

        binding.etTitle.setText( sourcingCriteria.title  )
        selectedSourcingCriteria?.sourcingId?.ifEmpty { binding.etTitle.text.clear() }
        binding.tvLocation.text = sourcingCriteria.location
        binding.tvTypeOfWork.text = sourcingCriteria.typeOfWork.joinToString(",")
        binding.tvExperience.text =  experienceMap.getOrElse(sourcingCriteria.experience) { "" }
        binding.cgJobTitleTags.removeAllViews()
        binding.cgUniversityTags.removeAllViews()
        binding.cgSkillTags.removeAllViews()
        binding.cgCompanyTags.removeAllViews()

        sourcingCriteria.jobTitles.forEach { createChip(it, binding.cgJobTitleTags) }
        sourcingCriteria.universities.forEach { createChip(it, binding.cgUniversityTags) }
        sourcingCriteria.skills.forEach { createChip(it, binding.cgSkillTags) }
        sourcingCriteria.companies.forEach { createChip(it, binding.cgCompanyTags) }
    }

    private fun getSourcingCriteria() {
        ParseCloud.callFunctionInBackground(ParseCloudFunction.GET_SOURCING_CRITERIA_V1.value, hashMapOf(ParseTableFields.COMPANY_ID.value to recruiter.companyId, ParseTableFields.RECRUITER_ID.value to requireContext().getUserId()), FunctionCallback<Any> { result, e ->
            when {
                e != null -> { toast(e.message.toString()) }
                result != null -> {
                    val list = arrayListOf<SourcingCriteria>()
                    val mainObject = JSONArray( gson.toJson(result))
                    for (i in 0 until mainObject.length()){
                        list.add(gson.fromJson(mainObject.getJSONObject(i).toString(), SourcingCriteria::class.java))
                    }
                    viewModel.setSourcingCriteriaList(list)
                }
                else -> { toast("Something Went Wrong.")}
            }
        })
    }

    private fun initializeRecruiter() {
        recruiter = viewModel.recruiter
        if (viewModel.recruiterObject == null) {
            (requireActivity() as RecruiterHomeActivity).getRecruiter {
                if (it) {
                    recruiter = viewModel.recruiter
                    setData()
                }
            }
        }
    }

    private fun setData() {

    }

    private fun setObserver() {
        viewModel.isRecruiterUpdated.observe(viewLifecycleOwner){
            if (it){
                recruiter = viewModel.recruiter
                setData()
            }
        }
        viewModel.sourcingCriteriaList.observe(viewLifecycleOwner){
            updateJobCriteriaList()
        }
    }

    private fun updateJobCriteriaList() {
        sourcingCriteriaList.clear()
        sourcingCriteriaList.add(sourcingCriteriaListTitleObject)
        viewModel.sourcingCriteriaList.value?.forEach { sourcingCriteria ->
            sourcingCriteriaList.add(sourcingCriteria)
        }
        sourcingCriteriaList.add(sourcingCriteriaListAddMoreObject)
        spinnerAdapter.submitList(sourcingCriteriaList)
        spinnerAdapter.notifyDataSetChanged()
        spinnerAdapter.sourcingId = sourcingCriteriaList[0].sourcingId
    }


    private fun setClickListeners() {
        binding.ivBackButton.setOnClickListener { dismiss() }
        binding.ivAddJobTitle.setOnClickListener { addJobTitleTags() }
        binding.ivAddUniversity.setOnClickListener { addUniversityTags() }
        binding.ivAddSkill.setOnClickListener { addSkillTags() }
        binding.ivAddCompany.setOnClickListener { addCompanyTags() }
        binding.btnAddSourcingCriteria.setOnClickListener {
            val skillTags = arrayListOf<String>()
            for (i in 0 until binding.cgSkillTags.childCount){
                val cl = binding.cgSkillTags.getChildAt(i) as ConstraintLayout
                skillTags.add(cl.findViewById<TextView>(R.id.tv_tag).text.toString())
            }

            val universityTags = arrayListOf<String>()
            for (i in 0 until binding.cgUniversityTags.childCount){
                val cl = binding.cgUniversityTags.getChildAt(i) as ConstraintLayout
                universityTags.add(cl.findViewById<TextView>(R.id.tv_tag).text.toString())
            }

            val jobTitleTags = arrayListOf<String>()
            for (i in 0 until binding.cgJobTitleTags.childCount){
                val cl = binding.cgJobTitleTags.getChildAt(i) as ConstraintLayout
                jobTitleTags.add(cl.findViewById<TextView>(R.id.tv_tag).text.toString())
            }

            val companyTags = arrayListOf<String>()
            for (i in 0 until binding.cgCompanyTags.childCount){
                val cl = binding.cgCompanyTags.getChildAt(i) as ConstraintLayout
                companyTags.add(cl.findViewById<TextView>(R.id.tv_tag).text.toString())
            }
            val title = binding.etTitle.text?.toString() ?: ""
            val request = HashMap<String, Any>()

            request["title"] = title
            request["location"] = selectedCity
            request["jobTitles"] = jobTitleTags
            request["typeOfWork"] = selectedWorkTypes
            request["experience"] = selectedWorkExperience
            request["skills"] = skillTags
            request["universities"] = universityTags
            request["companies"] = companyTags
            request["recruiterId"] = requireContext().getUserId()
            lat?.let { request["latitude"] = it }
            lng?.let { request["longitude"] = it }

            if (selectedSourcingCriteria == null || selectedSourcingCriteria!!.sourcingId.isEmpty()){
                request["companyId"] = recruiter.companyId
                request["sourcingId"] = ""
                addSourcingCriteria(request)
            }else{
                request["companyId"] = selectedSourcingCriteria!!.companyId
                request["sourcingId"] = selectedSourcingCriteria!!.sourcingId
                updateSourcingCriteria(request)
            }
        }

        binding.clLocation.setOnClickListener {
            autocompleteFragment.requireView().findViewById<View>(R.id.places_autocomplete_search_input).performClick()
        }
        binding.clWorkType.setOnClickListener {
            val dialog = DialogWorkType2(requireActivity(), selectedWorkTypes)
            dialog.onWorkClick = { workTypes ->
                selectedWorkTypes.clear()
                workTypes.forEach { selectedWorkTypes.add(it) }
                binding.tvTypeOfWork.text = selectedWorkTypes.joinToString(",")
            }
            val window: Window? = dialog.window
            window?.let {
                val wlp = it.attributes
                wlp.gravity = Gravity.BOTTOM
                it.attributes = wlp
            }
            dialog.show()
        }

        binding.clExperience.setOnClickListener {
            val dialog = DialogWorkExperience(requireActivity(), selectedWorkExperience)
            dialog.onExperienceClick = { experience ->
               selectedWorkExperience = experience
                experienceMap.forEach {
                    if (selectedWorkExperience == it.key){
                        binding.tvExperience.text = it.value
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



    private fun updateSourcingCriteria(request: HashMap<String, Any>) {
        ParseCloud.callFunctionInBackground(ParseCloudFunction.EDIT_SOURCING_CRITERIA_V1.value, request, FunctionCallback<Any> { result, e ->
            when {
                e != null -> { toast(e.message.toString()) }
                result != null -> {
                    val sourcingCriteria = gson.fromJson(gson.toJson(result).toString(), SourcingCriteria::class.java)
                    if (sourcingCriteria != null) {
                        viewModel.shouldBeSelectedSourcingCriteriaSourcingId.value = sourcingCriteria.sourcingId
                    }
                    getSourcingCriteria()
                    toast("sourcing criteria updated.")
                }
                else -> { toast("Something Went Wrong.")}
            }
            dismiss()
        })
    }

    private fun addSourcingCriteria(request: HashMap<String, Any>) {
        ParseCloud.callFunctionInBackground(ParseCloudFunction.SAVE_SOURCING_CRITERIA_V1.value, request, FunctionCallback<Any> { result, e ->
            when {
                e != null -> { toast(e.message.toString()) }
                result != null -> {
                    val sourcingCriteria = gson.fromJson(gson.toJson(result).toString(), SourcingCriteria::class.java)
                    if (sourcingCriteria != null) {
                        viewModel.shouldBeSelectedSourcingCriteriaSourcingId.value = sourcingCriteria.sourcingId
                    }
                    getSourcingCriteria()
                    clearAllFields()
                    toast("sourcing criteria added.")
                }
                else -> { toast("Something Went Wrong.")}
            }
            dismiss()
        })
    }


    private fun addCompanyTags() {
        if (binding.etAddCompany.text.isNullOrEmpty()){
            toast("Please enter tag first")
        }else{
            createChip(binding.etAddCompany.text.toString(), binding.cgCompanyTags)
            binding.etAddCompany.text.clear()
        }
    }

    private fun addSkillTags() {
        if (binding.etAddSkill.text.isNullOrEmpty()){
            toast("Please enter tag first")
        }else{
            createChip(binding.etAddSkill.text.toString(), binding.cgSkillTags)
            binding.etAddSkill.text.clear()
        }
    }

    private fun addUniversityTags() {
        if (binding.etAddUniversity.text.isNullOrEmpty()){
            toast("Please enter tag first")
        }else{
            createChip(binding.etAddUniversity.text.toString(), binding.cgUniversityTags)
            binding.etAddUniversity.text.clear()
        }
    }

    private fun addJobTitleTags() {
        if (binding.etJobTitle.text.isNullOrEmpty()){
            toast("Please enter tag first")
        }else{
            createChip(binding.etJobTitle.text.toString(), binding.cgJobTitleTags)
            binding.etJobTitle.text.clear()
        }
    }

    private fun createChip(tag: String, tagGroup: ChipGroup) {
        var isSelected = false
        val chip: View = layoutInflater.inflate(R.layout.item_chip_white_box_gradient_border_close_icon, null, false)
        val tvContract = chip.findViewById<TextView>(R.id.tv_tag)
        val background = chip.findViewById<ConstraintLayout>(R.id.cl_background)
        val removeTag = chip.findViewById<ImageView>(R.id.iv_remove_tag)
        val state = chip.findViewById<TextView>(R.id.tv_chip_state)
        tvContract.text = tag
        tvContract.setOnClickListener {
            if (isSelected){
                background.background = resources.getDrawable(R.drawable.rounded_bottom_purple_top_blue_50, null)
                background.updatePadding(10, 0,10,0)
                state.text = "1"
                removeTag.setImageResource(R.drawable.close_white)
                tvContract.setTextColor(resources.getColor(R.color.white, null))
                isSelected = false
            }else{
                background.background = resources.getDrawable(R.drawable.rounded_white_box_gradient_border_50, null)
                background.updatePadding(10, 0,10,0)
                state.text = "0"
                removeTag.setImageResource(R.drawable.close_black)
                tvContract.setTextColor(resources.getColor(R.color.navi_blue, null))
                isSelected = true
            }
        }
        removeTag.setOnClickListener { tagGroup.removeView(chip) }
        tagGroup.addView(chip)
    }

}