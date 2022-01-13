package com.findajob.jobamax.jobseeker.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.findajob.jobamax.R
import com.findajob.jobamax.base.BaseFragmentMain
import com.findajob.jobamax.databinding.FragmentSeekerVolunteeringAndActivitiesBinding
import com.findajob.jobamax.jobseeker.home.JobSeekerHomeViewModel
import com.findajob.jobamax.util.log
import com.findajob.jobamax.util.toast
import com.google.android.material.chip.Chip
import org.json.JSONArray


class SeekerVolunteeringAndActivitiesFragment : BaseFragmentMain<FragmentSeekerVolunteeringAndActivitiesBinding>() {

    override val layoutRes: Int get() = R.layout.fragment_seeker_my_skill
    val viewModel: JobSeekerHomeViewModel by activityViewModels()
    override fun getViewModel(): ViewModel = viewModel

    var volunteeringTags = ArrayList<String>()
    var activitiesTags = ArrayList<String>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentSeekerVolunteeringAndActivitiesBinding.inflate(inflater, container, false)
        configureUi()
        return binding.root
    }

    private fun configureUi() {
         setClickListeners()
        viewModelObserver()
    }

    private fun viewModelObserver() {
         viewModel.isJobSeekerUpdated.observe(viewLifecycleOwner, {
             if(it){
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
        log("dfdk f$volunteeringTagsJsonArray  $volunteeringTags")
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
         binding.ivVolunteering.setOnClickListener {
             if (binding.etVolunteering.text.isNullOrEmpty()){
                 toast("Please enter tag first.")
             }else{
                 volunteeringTags.add(binding.etVolunteering.text.toString())
                 val chip = layoutInflater.inflate(R.layout.item_custom_chip, binding.cgVolunteering, false) as Chip
                 chip.text = binding.etVolunteering.text.toString()
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
                 binding.etVolunteering.text.clear()
                 viewModel.addVolunteeringTags(volunteeringTags){
                     if(it != null){
                         toast("${it.message.toString()} Something went wrong")
                     }
                 }
             }
         }
        binding.ivActivities.setOnClickListener {
            if (binding.etActivities.text.isNullOrEmpty()){
                toast("Please enter tag first.")
            }else{
                activitiesTags.add(binding.etActivities.text.toString())
                val chip = layoutInflater.inflate(R.layout.item_custom_chip, binding.cgActivities, false) as Chip
                chip.text = binding.etActivities.text.toString()
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
                binding.etActivities.text.clear()
                viewModel.addActivitiesTags(activitiesTags){
                    if(it != null){
                        toast("${it.message.toString()} Something went wrong")
                    }
                }
            }
        }
    }

    override fun onCreated(savedInstance: Bundle?) {

    }

}