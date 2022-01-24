package com.findajob.jobamax.jobseeker.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.findajob.jobamax.R
import com.findajob.jobamax.base.BaseFragmentMain
import com.findajob.jobamax.databinding.FragmentSeekerVolunteeringAndActivitiesBinding
import com.findajob.jobamax.jobseeker.home.JobSeekerHomeViewModel
import com.findajob.jobamax.model.GetAllUserCallback
import com.findajob.jobamax.util.log
import com.findajob.jobamax.util.toast
import com.google.android.material.chip.Chip
import com.parse.ParseObject
import org.json.JSONArray


class SeekerVolunteeringAndActivitiesFragment : BaseFragmentMain<FragmentSeekerVolunteeringAndActivitiesBinding>() {

    override val layoutRes: Int get() = R.layout.fragment_seeker_volunteering_and_activities
    val viewModel: JobSeekerHomeViewModel by activityViewModels()
    override fun getViewModel(): ViewModel = viewModel

    var volunteeringTags = ArrayList<String>()
    var activitiesTags = ArrayList<String>()
    var volunteeringTagsSuggestions = ArrayList<String>()
    var activitiesTagsSuggestions = ArrayList<String>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentSeekerVolunteeringAndActivitiesBinding.inflate(inflater, container, false)
        configureUi()
        return binding.root
    }

    private fun configureUi() {
        binding.jobSeeker = viewModel.jobSeeker
         setClickListeners()
        viewModelObserver()
        viewModel.getExistingVolunteeringTags(object : GetAllUserCallback{
            override fun onSuccess(parseObject: List<ParseObject>) {
                volunteeringTagsSuggestions.clear()
                parseObject.forEach {
                    it.getString("name")?.let { tag -> volunteeringTagsSuggestions.add(tag) }
                }
                binding.actvVolunteering.setAdapter(ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, volunteeringTagsSuggestions))
            }
            override fun onFailure(e: Exception?) {
                if (e != null) {
                    log("${e.message.toString()} Something Went Wrong")
                }
            }
        })
        viewModel.getExistingActivitiesTags(object : GetAllUserCallback{
            override fun onSuccess(parseObject: List<ParseObject>) {
                activitiesTagsSuggestions.clear()
                parseObject.forEach {
                    it.getString("name")?.let { tag -> activitiesTagsSuggestions.add(tag) }
                }
                binding.actvActivities.setAdapter(ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, activitiesTagsSuggestions))
            }
            override fun onFailure(e: Exception?) {
                if (e != null) {
                    log("${e.message.toString()} Something Went Wrong")
                }
            }
        })
    }

    private fun viewModelObserver() {
         viewModel.isJobSeekerUpdated.observe(viewLifecycleOwner, {
             if(it){
                 binding.jobSeeker = viewModel.jobSeeker
                 if (viewModel.jobSeeker.activities != ""){
                     setActivitiesTags()
                 }
                  if (viewModel.jobSeeker.volunteerings != ""){
                     setVolunteeringTags()
                 }
             }
         })
    }

    private fun setVolunteeringTags() {
        val volunteeringTagsJsonArray = JSONArray(viewModel.jobSeeker.volunteerings)
        var i = 0
        while (i < volunteeringTagsJsonArray.length()) {
            volunteeringTags.add(volunteeringTagsJsonArray.getString(i))
            i++
        }
        volunteeringTags.forEach { str ->
            val chip = layoutInflater.inflate(
                R.layout.item_custom_chip,
                binding.cgVolunteering,
                false
            ) as Chip
            chip.text = str
            chip.setOnCloseIconClickListener { c ->
                volunteeringTags.remove((c as Chip).text)
                binding.cgVolunteering.removeView(c)
                viewModel.addVolunteeringTags(volunteeringTags) { exception ->
                    if (exception != null) {
                        toast("${exception.message.toString()} Something went wrong")
                    }
                }
            }
            chip.isCloseIconVisible = true
            chip.setCloseIconResource(R.drawable.close_white)
            chip.setCloseIconTintResource(R.color.white)
            binding.cgVolunteering.addView(chip)
        }
    }

    private fun setActivitiesTags() {
        val activities = JSONArray(viewModel.jobSeeker.activities)
        var i = 0
        while (i < activities.length()) {
            activitiesTags.add(activities.getString(i))
            i++
        }
        activitiesTags.forEach { str ->
            val chip = layoutInflater.inflate(
                R.layout.item_custom_chip,
                binding.cgActivities,
                false
            ) as Chip
            chip.text = str
            chip.setOnCloseIconClickListener { c ->
                activitiesTags.remove((c as Chip).text)
                binding.cgActivities.removeView(c)
                viewModel.addActivitiesTags(activitiesTags) {
                    if (it != null) {
                        toast("${it.message.toString()} Something went wrong")
                    }
                }
            }
            chip.isCloseIconVisible = true
            chip.setCloseIconResource(R.drawable.close_white)
            chip.setCloseIconTintResource(R.color.white)
            binding.cgActivities.addView(chip)
        }
    }

    private fun setClickListeners() {
        binding.ivBackButton.setOnClickListener {
            requireActivity().onBackPressed()
        }
         binding.ivVolunteering.setOnClickListener {
             if (binding.actvVolunteering.text.isNullOrEmpty()){
                 toast("Please enter tag first.")
             }else{
                 if (! volunteeringTagsSuggestions.contains(binding.actvVolunteering.text.toString())){
                     viewModel.saveVolunteeringTag(binding.actvVolunteering.text.toString())
                 }
                 if (volunteeringTags.contains(binding.actvVolunteering.text.toString())){
                     toast("This Skill is already exist.")
                 }else{
                     volunteeringTags.add(binding.actvVolunteering.text.toString())
                     val chip = layoutInflater.inflate(R.layout.item_custom_chip, binding.cgVolunteering, false) as Chip
                     chip.text = binding.actvVolunteering.text.toString()
                     chip.setOnCloseIconClickListener { c ->
                         volunteeringTags.remove((c as Chip).text)
                         binding.cgVolunteering.removeView(c)
                         viewModel.addVolunteeringTags(volunteeringTags){
                             if(it != null){
                                 toast("${it.message.toString()} Something went wrong")
                             }
                         }
                     }
                     chip.isCloseIconVisible = true
                     chip.setCloseIconResource(R.drawable.close_white)
                     chip.setCloseIconTintResource(R.color.white)
                     binding.cgVolunteering.addView(chip)
                     binding.actvVolunteering.text.clear()
                     viewModel.addVolunteeringTags(volunteeringTags){
                         if(it != null){
                             toast("${it.message.toString()} Something went wrong")
                         }
                     }
                 }
             }
         }
        binding.ivActivities.setOnClickListener {
            if (binding.actvActivities.text.isNullOrEmpty()){
                toast("Please enter tag first.")
            }else{
                 if (! volunteeringTagsSuggestions.contains(binding.actvActivities.text.toString())){
                     viewModel.saveActivitiesTag(binding.actvActivities.text.toString())
                 }
                 if (activitiesTags.contains(binding.actvActivities.text.toString())){
                     toast("This Skill is already exist.")
                 }else{
                     activitiesTags.add(binding.actvActivities.text.toString())
                     val chip = layoutInflater.inflate(R.layout.item_custom_chip, binding.cgActivities, false) as Chip
                     chip.text = binding.actvActivities.text.toString()
                     chip.setOnCloseIconClickListener { c ->
                         activitiesTags.remove((c as Chip).text)
                         binding.cgActivities.removeView(c)
                         viewModel.addActivitiesTags(activitiesTags){
                             if(it != null){
                                 toast("${it.message.toString()} Something went wrong")
                             }
                         }
                     }
                     chip.isCloseIconVisible = true
                     chip.setCloseIconResource(R.drawable.close_white)
                     chip.setCloseIconTintResource(R.color.white)
                     binding.cgActivities.addView(chip)
                     binding.actvActivities.text.clear()
                     viewModel.addActivitiesTags(activitiesTags){
                         if(it != null){
                             toast("${it.message.toString()} Something went wrong")
                         }
                     }
                 }
            }
        }
    }

    override fun onCreated(savedInstance: Bundle?) {

    }

}