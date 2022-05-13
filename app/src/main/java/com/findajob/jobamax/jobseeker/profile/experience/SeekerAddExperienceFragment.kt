package com.findajob.jobamax.jobseeker.profile.experience

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
 import android.widget.TextView
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.findajob.jobamax.DatePickerDialogFragment
import com.findajob.jobamax.R
import com.findajob.jobamax.base.BaseFragmentMain
import com.findajob.jobamax.databinding.FragmentSeekerAddExperienceBinding
import com.findajob.jobamax.databinding.ItemSearchQueryCompanyBinding
import com.findajob.jobamax.jobseeker.home.JobSeekerHomeViewModel
import com.findajob.jobamax.jobseeker.profile.cv.model.Experience
import com.findajob.jobamax.jobseeker.profile.idealjob.IOnBackPressed
import com.findajob.jobamax.model.SearchQueryCompany
import com.findajob.jobamax.network.ApiFetchCompaniesService
import com.findajob.jobamax.preference.getLanguage
import com.findajob.jobamax.repos.SearchQueryCompanyRepo
import com.findajob.jobamax.util.MMM_d_yyyy
import com.findajob.jobamax.util.loadImageFromUrl
import com.findajob.jobamax.util.toast
import com.google.android.gms.common.api.Status
import com.google.android.libraries.places.api.Places
import com.google.android.libraries.places.api.model.Place
import com.google.android.libraries.places.widget.AutocompleteSupportFragment
import com.google.android.libraries.places.widget.listener.PlaceSelectionListener
 import com.pushwoosh.internal.platform.AndroidPlatformModule.getApplicationContext
 import java.util.*

class SeekerAddExperienceFragment : BaseFragmentMain<FragmentSeekerAddExperienceBinding>(), IOnBackPressed {

    override val layoutRes: Int get() = R.layout.fragment_seeker_add_experience
    val viewModel: JobSeekerHomeViewModel by activityViewModels()
    override fun getViewModel(): ViewModel = viewModel

    private lateinit var autocompleteFragment: AutocompleteSupportFragment
    var experienceOld: Experience? = null

    lateinit var searchQueryCompanyRepo: SearchQueryCompanyRepo
    var selectedCompany: SearchQueryCompany? = null
    lateinit var adapter: SearchQueryCompanySuggestionAdapter
    var canFetchList = true

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentSeekerAddExperienceBinding.inflate(inflater, container, false)
        configureUi()
        return binding.root
    }

    override fun onCreated(savedInstance: Bundle?) {
        arguments?.getSerializable("experience")?.let {
            experienceOld = arguments?.getSerializable("experience") as Experience
        }
        experienceOld?.let {
            canFetchList = false
            binding.etJob.setText(experienceOld!!.job)
            binding.etCompanyName.setText(experienceOld!!.company)
            binding.tvSelectLocation.text = experienceOld!!.location
            binding.etDescription.setText(experienceOld!!.description.toString())
            binding.tvSelectStartDate.text = experienceOld!!.startDate
            if (experienceOld!!.endDate == ""){
                val calendar = Calendar.getInstance(TimeZone.getDefault());
                binding.tvSelectEndDate.text = "${calendar.get(Calendar.DAY_OF_MONTH)}/ ${calendar.get(Calendar.MONTH) + 1}/ ${calendar.get(Calendar.YEAR)}"
            }else{
                binding.tvSelectEndDate.text = experienceOld!!.endDate
            }

            binding.rvCompanySuggestions.visibility = View.GONE
        }
    }

    private fun configureUi() {
        binding.jobSeeker = viewModel.jobSeeker
        setClickListeners()
        setPlaceAutocompleteFragment()
        setAdapterFunctionality()
    }

    private fun setAdapterFunctionality() {
        adapter = SearchQueryCompanySuggestionAdapter(arrayListOf())
        binding.rvCompanySuggestions.adapter = adapter
        adapter.onCompanyClick = { company ->
            selectedCompany = company
            binding.rvCompanySuggestions.visibility = View.GONE
            canFetchList = false
            binding.etCompanyName.setText(selectedCompany?.name)
        }
        searchQueryCompanyRepo = SearchQueryCompanyRepo(ApiFetchCompaniesService.getInstance(requireContext()).create(ApiFetchCompaniesService::class.java))
    }

    private fun setPlaceAutocompleteFragment() {
        if (!Places.isInitialized()) {
            Places.initialize(getApplicationContext(), getString(R.string.google_maps_key), Locale.US);
        }
        autocompleteFragment = childFragmentManager.findFragmentById(R.id.autocomplete_fragment) as AutocompleteSupportFragment
        autocompleteFragment.setPlaceFields(listOf(Place.Field.ID, Place.Field.ADDRESS))
        autocompleteFragment.setOnPlaceSelectedListener(object : PlaceSelectionListener {
            override fun onPlaceSelected(place: Place) {
                binding.tvSelectLocation.text = place.address
            }
            override fun onError(status: Status) {}
        })
    }

    private fun setClickListeners() {
        binding.ivUserProfile.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_seekerAddExperienceFragment_to_seekerProfileFragment, null))
        binding.ivClearStartDate.setOnClickListener {
            binding.tvSelectStartDate.text = ""
        }
        binding.ivClearEndDate.setOnClickListener {
            binding.tvSelectEndDate.text = ""
        }
        binding.ivBackButton.setOnClickListener {
            requireActivity().onBackPressed()
        }
        binding.tvSelectStartDate.setOnClickListener {
            onDateClicked(it)
        }
        binding.tvSelectEndDate.setOnClickListener {
            onDateClicked(it)
        }
        binding.tvSelectLocation.setOnClickListener {
            autocompleteFragment.requireView().findViewById<View>(R.id.places_autocomplete_search_input).performClick()
        }

        binding.etCompanyName.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (binding.etCompanyName.text.isNullOrEmpty()){
                    binding.rvCompanySuggestions.visibility = View.GONE
                }else{
                    if (canFetchList){
                        selectedCompany = null
                        getCompanySuggestions()
                    }
                    canFetchList = true
                }
            }
            override fun afterTextChanged(p0: Editable?) {}
        })

        binding.clMostParent.setOnClickListener {
            binding.rvCompanySuggestions.visibility = View.GONE
        }

    }

    private fun getCompanySuggestions() {
        searchQueryCompanyRepo.getCompanies(binding.etCompanyName.text.toString()){ list ->
            if (list.isEmpty()){
                binding.rvCompanySuggestions.visibility = View.GONE
            }else{
                adapter.submitList(list)
                binding.rvCompanySuggestions.visibility = View.VISIBLE
            }
        }
    }

    private fun addExperience(callback: () -> Unit) {
        when {
            binding.etJob.text.isNullOrEmpty() -> {
                toast("Please enter job.")
                callback()
            }
          /*  binding.etCompanyName.text.isNullOrEmpty() -> {
                toast("Please enter company name.")
                callback()
            }
            binding.etDescription.text.isNullOrEmpty() -> {
                toast("Please enter job description.")
                callback()
            }
            binding.tvSelectStartDate.text.isNullOrEmpty() -> {
                toast("Please select start date.")
                callback()
            }*/
            else -> {
                val experience = if (experienceOld == null) {
                    Experience()
                } else {
                    experienceOld
                }
                experience!!.job = binding.etJob.text.toString()
                experience.company = selectedCompany?.name ?: binding.etCompanyName.text.toString()
                experience.description = binding.etDescription.text.toString()
                if (binding.tvSelectLocation.text.isNullOrEmpty()) {
                    experience.location = ""
                } else {
                    experience.location = binding.tvSelectLocation.text.toString()
                }
                experience.startDate = binding.tvSelectStartDate.text.toString()
                if (binding.tvSelectEndDate.text.isNullOrEmpty()) {
                    experience.endDate = ""
                } else {
                    experience.endDate = binding.tvSelectEndDate.text.toString()
                }
                experience.logo = selectedCompany?.logo ?: ""
                progressHud.show()
                viewModel.addAndUpdateExperience(experience) {
                    progressHud.dismiss()
                    if (it == null) {
                        toast("Experience Added.")
                        callback()
                    } else {
                        toast("${it.message.toString()} Something Went Wrong.")
                        callback()
                    }
                }
            }
        }
    }


    private fun onDateClicked(view: View ) {
        val datePickerDialogFragment = DatePickerDialogFragment()
        datePickerDialogFragment.show(childFragmentManager, "datePicker")   
        datePickerDialogFragment.selectedDate = { date ->
            (view as TextView).text = date.MMM_d_yyyy(requireContext().getLanguage())
        }
    }

    override fun onBackPressed(callback: () -> Unit) {
        addExperience { callback()}
    }

}

class SearchQueryCompanySuggestionAdapter(var list: ArrayList<SearchQueryCompany>) : RecyclerView.Adapter<SearchQueryCompanySuggestionAdapter.ViewHolder>() {
    var onCompanyClick: (SearchQueryCompany) -> Unit = {}
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(ItemSearchQueryCompanyBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.binding.apply {
            this.tvCompanyName.text = item.name
            this.tvCompanyDomain.text = item.domain
            loadImageFromUrl(this.civCompanyLogo, item.logo, R.drawable.ic_company)
            this.clMostParent.setOnClickListener {
                onCompanyClick(item)
            }
        }
    }
    override fun getItemCount(): Int = list.size
    fun submitList(suggestions: ArrayList<SearchQueryCompany>) {
        this.list = suggestions
    }

    class ViewHolder(val binding: ItemSearchQueryCompanyBinding) : RecyclerView.ViewHolder(binding.root)
}