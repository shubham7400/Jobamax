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
import com.google.gson.Gson
import com.jobamax.appjobamax.R
import com.jobamax.appjobamax.base.BaseFragment
import com.jobamax.appjobamax.databinding.FragmentPersonalizeFilterBinding
import com.jobamax.appjobamax.dialog.BasicDialog
import com.jobamax.appjobamax.enums.ParseTableFields
import com.jobamax.appjobamax.extensions.toast
import com.jobamax.appjobamax.jobseeker.search.ManualAndPersonalizeActivity
import com.jobamax.appjobamax.jobseeker.view_model.SeekerHomeViewModel
import com.jobamax.appjobamax.model.JobSeeker
import com.jobamax.appjobamax.model.PersonalizeCriteria
 import com.jobamax.appjobamax.util.contractMap
import com.jobamax.appjobamax.util.experienceMap
import com.jobamax.appjobamax.util.loadImageFromUrl
import com.parse.ParseGeoPoint
import com.pushwoosh.internal.platform.AndroidPlatformModule
import java.util.*
import kotlin.math.max


class PersonalizeFilterFragment : BaseFragment() {
    lateinit var binding: FragmentPersonalizeFilterBinding

    lateinit var jobSeeker: JobSeeker
    val viewModel: SeekerHomeViewModel by activityViewModels()

    lateinit var autocompleteFragment: AutocompleteSupportFragment
    var lat: Double? = null
    var lng: Double? = null

    var experience = ArrayList<String>()
    private var interestedIn= ArrayList<String>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentPersonalizeFilterBinding.inflate(inflater, container, false)
        configureUi()
        return  binding.root
    }

    private fun configureUi() {
        setClickListeners()
        initializeJobSeeker()
        setPlaceAutocompleteFragment()
        setData()
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
        binding.btnModifyCv.setOnClickListener {
            val manualFilterMainFragment = (this.parentFragment as ManualFilterMainFragment)
            manualFilterMainFragment.goToModifyCv()
        }
        binding.tvJobLocation.setOnClickListener {
            autocompleteFragment.requireView().findViewById<View>(R.id.places_autocomplete_search_input).performClick()
        }
        binding.btnSave.setOnClickListener {

            if (binding.tvJobLocation.text.isNullOrEmpty()){
                BasicDialog(requireActivity(),"L'emplacement ne peut pas être vide"){}.show()
                return@setOnClickListener
            }

            if (interestedIn.isEmpty()){
                BasicDialog(requireActivity(),"Veuillez sélectionner au moins un type de travail."){}.show()
                return@setOnClickListener
            }

            val personalizeCriteria = PersonalizeCriteria().also {
                it.location = binding.tvJobLocation.text.toString()
                it.experience = experience
                it.typeOfWork = interestedIn
                it.latitude = lat ?: 0.0
                it.longitude = lng ?: 0.0
            }

            viewModel.jobSeekerObject?.put(ParseTableFields.CITY.value, binding.tvJobLocation.text.toString())
            viewModel.jobSeekerObject?.put(ParseTableFields.EXPERIENCE.value, experience)
            viewModel.jobSeekerObject?.put(ParseTableFields.INTERESTED_IN.value, interestedIn)
            viewModel.jobSeekerObject?.put(ParseTableFields.LAT.value, lat ?: 0.0)
            viewModel.jobSeekerObject?.put(ParseTableFields.LNG.value, lng ?: 0.0)
            val gp = ParseGeoPoint().also {
                it.latitude = lat ?: 0.0
                it.longitude = lng ?: 0.0
            }
            viewModel.jobSeekerObject?.put(ParseTableFields.GEO_LOCATION.value, gp)
            progressHud.show()
            viewModel.jobSeekerObject?.saveInBackground { exception ->
                progressHud.dismiss()
                if (exception == null) {
                    try {
                        (requireActivity() as BuildProfileActivity).onBackPressed()
                    }catch (e: Exception){
                        val intent = Intent()
                        intent.putExtra("personalize_criteria", personalizeCriteria)
                        intent.putExtra("check_box_state", 0)
                        requireActivity().setResult(123, intent)
                        requireActivity().finish()
                    }
                }else{
                    toast(exception.message.toString())
                }
            }

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
    }

    private fun initializeJobSeeker() {
        jobSeeker = viewModel.jobSeeker
        if (viewModel.jobSeekerObject == null) {
            (requireActivity() as ManualAndPersonalizeActivity).getJobSeeker {
                if (it) {
                    jobSeeker = viewModel.jobSeeker
                    setData()
                }
            }
        }
    }

    private fun setData() {
        loadImageFromUrl(binding.circleImageView, jobSeeker.profilePicUrl, R.drawable.default_user_img)
        binding.tvJobLocation.text = jobSeeker.city
        experience.clear()
        jobSeeker.experience.forEach {
            experience.add(it)
        }
        interestedIn.clear()
        jobSeeker.interestedIn.forEach { interestedIn.add(it) }
        createExperienceCheap()
        createWorkTypeCheap()
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
            binding.cgContractType.addView(createChip(it.value, interestedIn.contains(it.value), WORK_TYPE_CHEAP))
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
                                interestedIn.remove(it.value)
                            }
                        }
                    }else{
                        contractMap.forEach {
                            if (tag == it.value){
                                interestedIn.add(it.value)
                            }
                        }
                    }
                    createWorkTypeCheap()
                }
            }
        }
        return chip
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