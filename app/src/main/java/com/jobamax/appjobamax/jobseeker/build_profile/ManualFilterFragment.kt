package com.jobamax.appjobamax.jobseeker.build_profile


 import android.animation.Animator
 import android.animation.AnimatorListenerAdapter
 import android.content.Intent
 import android.os.Bundle
 import android.view.LayoutInflater
 import android.view.View
 import android.view.ViewAnimationUtils
 import android.view.ViewGroup
 import android.widget.ImageView
 import android.widget.TextView
 import androidx.core.view.isVisible
 import androidx.core.view.updatePadding
 import androidx.fragment.app.activityViewModels
 import com.google.android.gms.common.api.Status
 import com.google.android.libraries.places.api.Places
 import com.google.android.libraries.places.api.model.Place
 import com.google.android.libraries.places.widget.AutocompleteSupportFragment
 import com.google.android.libraries.places.widget.listener.PlaceSelectionListener
 import com.google.android.material.chip.ChipGroup
 import com.jobamax.appjobamax.R
 import com.jobamax.appjobamax.base.BaseFragment
 import com.jobamax.appjobamax.databinding.FragmentManualFilterBinding
 import com.jobamax.appjobamax.dialog.BasicDialog
 import com.jobamax.appjobamax.enums.ParseTableFields
 import com.jobamax.appjobamax.extensions.toast
 import com.jobamax.appjobamax.jobseeker.search.ManualAndPersonalizeActivity
 import com.jobamax.appjobamax.jobseeker.view_model.SeekerHomeViewModel
 import com.jobamax.appjobamax.model.JobSeeker
 import com.jobamax.appjobamax.model.ManualCriteria
 import com.jobamax.appjobamax.util.companySizeList
 import com.jobamax.appjobamax.util.contractMap
 import com.jobamax.appjobamax.util.experienceMap
 import com.pushwoosh.internal.platform.AndroidPlatformModule
 import java.util.*
 import kotlin.math.max


const val EXPERIENCE_CHEAP = 1
const val WORK_TYPE_CHEAP = 2
const val COMPANY_SIZE_CHEAP = 3
class ManualFilterFragment : BaseFragment() {
    lateinit var binding: FragmentManualFilterBinding

    lateinit var jobSeeker: JobSeeker
    val viewModel: SeekerHomeViewModel by activityViewModels()

    lateinit var manualCriteria: ManualCriteria
    var experience = ArrayList<String>()
    private var workType= ArrayList<String>()
    private var companySize= ArrayList<String>()
    private var companies= ArrayList<String>()

    lateinit var autocompleteFragment: AutocompleteSupportFragment
    var lat: Double? = null
    var lng: Double? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentManualFilterBinding.inflate(inflater, container, false)
        configureUi()
        return binding.root
    }



    private fun configureUi() {
        setClickListeners()
        setPlaceAutocompleteFragment()
        initializeJobSeeker()
    }

    private fun setData() {
        manualCriteria = jobSeeker.manualCriteria!!

        binding.scIsJobamaxJob.isChecked = manualCriteria.isJobamaxJob
        lat = manualCriteria.lat
        lng = manualCriteria.long
        binding.tvJobLocation.text = manualCriteria.location
        experience.clear()
        manualCriteria.experience.forEach { experience.add(it) }
        workType.clear()
        manualCriteria.typeOfWork.forEach { workType.add(it) }
        companySize.clear()
        manualCriteria.companySize.forEach { companySize.add(it) }
        companies.clear()
        manualCriteria.companyName.forEach { companies.add(it) }
        companies.forEach { createCompanyTags(it) }
        createWorkTypeCheap()
        createExperienceCheap()
        createCompanySizeCheap()
    }

    private fun createCompanySizeCheap() {
        binding.cgCompanySize.removeAllViews()
        companySizeList.forEach {
            binding.cgCompanySize.addView(createChip(it, companySize.contains(it), COMPANY_SIZE_CHEAP))
        }
    }

    private fun createExperienceCheap() {
        binding.cgWorkExperience.removeAllViews()
        experienceMap.forEach {
            binding.cgWorkExperience.addView(createChip(it.value, experience.contains(it.key), EXPERIENCE_CHEAP))
        }
    }

    private fun createWorkTypeCheap() {
        binding.cgContractType.removeAllViews()
        contractMap.forEach {
            binding.cgContractType.addView(createChip(it.value, workType.contains(it.value), WORK_TYPE_CHEAP))
        }
    }

    private fun initializeJobSeeker() {
        if (viewModel.jobSeekerObject == null) {
            try {
                (requireActivity() as BuildProfileActivity).getJobSeeker {
                    if (it) {
                        jobSeeker = viewModel.jobSeeker
                        setData()
                    }
                }
            }catch (e: Exception){
                try {
                    (requireActivity() as ManualAndPersonalizeActivity).getJobSeeker {
                        if (it) {
                            jobSeeker = viewModel.jobSeeker
                            setData()
                        }
                    }
                }catch (e: Exception){ }
            }
        }else{
            jobSeeker = viewModel.jobSeeker
            setData()
        }
    }

    private fun createChip(tag: String, isSelected: Boolean, cheapType: Int): View {
        val chip: View = layoutInflater.inflate(R.layout.item_chip_white_box_gradient_border, null, false)
        val tvContract = chip.findViewById<TextView>(R.id.tv_tag)
        val state = chip.findViewById<TextView>(R.id.tv_chip_state)
        tvContract.text = tag
        if (isSelected){
            tvContract.background = resources.getDrawable(R.drawable.rounded_bottom_purple_top_blue_50, null)
            tvContract.updatePadding(30, 0,30,0)
            state.text = "1"
            tvContract.setTextColor(resources.getColor(R.color.white, null))
        }else{
            tvContract.background = resources.getDrawable(R.drawable.rounded_white_box_gradient_border_50, null)
            tvContract.updatePadding(30, 0,30,0)
            state.text = "0"
            tvContract.setTextColor(resources.getColor(R.color.navi_blue, null))
        }
        tvContract.setOnClickListener {
            when(cheapType){
                EXPERIENCE_CHEAP -> {
                    if (isSelected){
                        experienceMap.forEach {
                            if (tag == it.value){
                                experience.remove(it.key)
                            }
                        }
                    }else{
                        experienceMap.forEach {
                            if (tag == it.value){
                                experience.add(it.key)
                            }
                        }
                    }
                    createExperienceCheap()
                }
                WORK_TYPE_CHEAP -> {
                    if (isSelected){
                        contractMap.forEach {
                            if (tag == it.value){
                                workType.remove(it.value)
                            }
                        }
                    }else{
                        contractMap.forEach {
                            if (tag == it.value){
                                workType.add(it.value)
                            }
                        }
                    }
                    createWorkTypeCheap()
                }
                COMPANY_SIZE_CHEAP -> {
                    if (isSelected){
                        companySize.remove(tag)
                    }else{
                        companySize.add(tag)
                    }
                    createCompanySizeCheap()
                }
            }
        }
        return chip
    }

    private fun setPlaceAutocompleteFragment() {
        if (!Places.isInitialized()) {
            Places.initialize(AndroidPlatformModule.getApplicationContext(), getString(R.string.google_maps_key), Locale.US)
        }
        autocompleteFragment = childFragmentManager.findFragmentById(R.id.autocomplete_fragment) as AutocompleteSupportFragment
        autocompleteFragment.setPlaceFields(listOf(Place.Field.ID, Place.Field.ADDRESS, Place.Field.LAT_LNG))
        autocompleteFragment.setOnPlaceSelectedListener(object : PlaceSelectionListener {
            override fun onPlaceSelected(place: Place) {
                 lat = place.latLng?.latitude
                 lng = place.latLng?.longitude
                binding.tvJobLocation.text = place.address
            }
            override fun onError(status: Status) {}
        })
    }

    private fun setClickListeners() {
        binding.tvCriteriaCategory.setOnClickListener {
            val manualFilterMainFragment = (this.parentFragment as ManualFilterMainFragment)
            manualFilterMainFragment.goToFilterJobSearchTag()
        }

        binding.tvJobLocation.setOnClickListener {
            autocompleteFragment.requireView().findViewById<View>(R.id.places_autocomplete_search_input).performClick()
        }

        binding.clWorkType.setOnClickListener {
            if (binding.cgContractType.isVisible){
                viewHideAnimation(binding.cgContractType, binding.ivArrowWork)
            }else{
                showViewAnimation(binding.cgContractType, binding.ivArrowWork)
            }
        }
        binding.clExperience.setOnClickListener {
            if (binding.cgWorkExperience.isVisible){
                viewHideAnimation(binding.cgWorkExperience, binding.ivArrowExp)
            }else{
                showViewAnimation(binding.cgWorkExperience, binding.ivArrowExp)
            }
        }

        binding.btnSave.setOnClickListener {

            if (binding.tvJobLocation.text.isNullOrEmpty()){
                BasicDialog(requireActivity(),"L'emplacement ne peut pas être vide"){}.show()
                return@setOnClickListener
            }

            if (workType.isEmpty()){
                BasicDialog(requireActivity(),"Veuillez sélectionner au moins un type de travail."){}.show()
                return@setOnClickListener
            }

            manualCriteria.location = binding.tvJobLocation.text.toString()
            manualCriteria.isJobamaxJob = binding.scIsJobamaxJob.isChecked
            manualCriteria.lat = lat ?: 0.0
            manualCriteria.long = lng ?: 0.0
            manualCriteria.experience.clear()
            experience.forEach { manualCriteria.experience.add(it) }
            manualCriteria.typeOfWork.clear()
            workType.forEach { manualCriteria.typeOfWork.add(it) }
            manualCriteria.companySize.clear()
            companySize.forEach { manualCriteria.companySize.add(it) }
            manualCriteria.companyName.clear()
            companies.forEach { manualCriteria.companyName.add(it) }
            viewModel.jobSeekerObject?.put(ParseTableFields.MANUAL_CRITERIA.value, gson.toJson(manualCriteria))
            progressHud.show()
            viewModel.jobSeekerObject?.saveInBackground { exception ->
                progressHud.dismiss()
                if (exception == null){
                    try {
                        (requireActivity() as BuildProfileActivity).onBackPressed()
                    }catch (e: Exception){
                        val intent = Intent()
                        intent.putExtra("manual_criteria", manualCriteria)
                        intent.putExtra("check_box_state", 1)
                        requireActivity().setResult(123, intent)
                        requireActivity().finish()
                    }
                }else{
                    toast(exception.message.toString())
                }
            }
        }
        binding.ivAddCompany.setOnClickListener {
            val tag = binding.etCompanyName.text.toString().trim()
            if (companies.contains(tag)){
                toast("Company already exist.")
            }else{
                createCompanyTags(tag)
                companies.add(tag)
                binding.etCompanyName.text.clear()
            }
        }
    }

    private fun createCompanyTags(tag: String) {
        val chip: View = layoutInflater.inflate(R.layout.item_chip_white_box_gradient_border_close_icon, null, false)
        val tvContract = chip.findViewById<TextView>(R.id.tv_tag)
        val ivRemoveTag = chip.findViewById<ImageView>(R.id.iv_remove_tag)
        ivRemoveTag.setOnClickListener {
            try {
                binding.cgCompanyTags.removeView(chip)
                companies.remove(tag)
            }catch (e: Exception){}
        }
        tvContract.text = tag
        tvContract.updatePadding(30, 0,30,0)
        binding.cgCompanyTags.addView(chip)
    }

    private fun showViewAnimation(cgContractType: ChipGroup, iv: ImageView) {
        val finalRadius = max(cgContractType.width, cgContractType.height)
        val anim = ViewAnimationUtils.createCircularReveal(cgContractType, 0, 0, 0f, finalRadius.toFloat())
        cgContractType.visibility = View.VISIBLE
        iv.setImageResource(R.drawable.ic_arrow_up_navi_blue)
        anim.start()
    }

    private fun viewHideAnimation(cgContractType: ChipGroup, iv: ImageView) {
        val anim = ViewAnimationUtils.createCircularReveal(cgContractType, 0, 0, cgContractType.width.toFloat(), 0f)
        anim.addListener(object : AnimatorListenerAdapter() {
            override fun onAnimationEnd(animation: Animator) {
                super.onAnimationEnd(animation)
                cgContractType.visibility = View.GONE
                iv.setImageResource(R.drawable.ic_arrow_down_navi_blue)
            }
        })
        anim.start()
    }

}