package com.findajob.jobamax.jobseeker.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import com.findajob.jobamax.R
import com.findajob.jobamax.base.BaseFragmentMain
import com.findajob.jobamax.databinding.FragmentSeekerInterestBinding
import com.findajob.jobamax.dialog.YesNoDialog
import com.findajob.jobamax.jobseeker.home.JobSeekerHomeViewModel
import com.findajob.jobamax.model.GetAllUserCallback
import com.findajob.jobamax.util.log
import com.findajob.jobamax.util.toast
import com.google.android.material.chip.Chip
import com.parse.ParseObject


class SeekerInterestFragment : BaseFragmentMain<FragmentSeekerInterestBinding>() {

    override val layoutRes: Int get() = R.layout.fragment_seeker_interest
    val viewModel: JobSeekerHomeViewModel by activityViewModels()
    override fun getViewModel(): ViewModel = viewModel

    var interestTags = ArrayList<String>()
    var volunteeringTagsSuggestions = ArrayList<String>()
    var interestTagsSuggestions = ArrayList<String>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentSeekerInterestBinding.inflate(inflater, container, false)
        configureUi()
        return binding.root
    }

    private fun configureUi() {
        binding.jobSeeker = viewModel.jobSeeker
         setClickListeners()
        viewModelObserver()

        viewModel.getExistingActivitiesTags(object : GetAllUserCallback{
            override fun onSuccess(parseObject: List<ParseObject>) {
                interestTagsSuggestions.clear()
                parseObject.forEach {
                    it.getString("name")?.let { tag -> interestTagsSuggestions.add(tag) }
                }
                binding.actvInterest.setAdapter(ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, interestTagsSuggestions))
            }
            override fun onFailure(e: Exception?) {
                if (e != null) {
                    log("${e.message.toString()} Something Went Wrong")
                }
            }
        })
    }

    private fun viewModelObserver() {
         viewModel.isJobSeekerUpdated.observe(viewLifecycleOwner) {
             if (it) {
                 binding.jobSeeker = viewModel.jobSeeker
                 if (viewModel.jobSeeker.interests.isNotEmpty()) {
                     setActivitiesTags()
                 }
             }
         }
    }



    private fun setActivitiesTags() {
        val activitiesTags = ArrayList(viewModel.jobSeeker.interests)
        activitiesTags.forEach { str ->
            val chip = layoutInflater.inflate(R.layout.item_custom_chip, binding.cgInterests, false) as Chip
            chip.text = str
            chip.setOnCloseIconClickListener { c ->
                YesNoDialog(requireActivity(), resources.getString(R.string.are_you_sure), {
                    activitiesTags.remove((c as Chip).text)
                    binding.cgInterests.removeView(c)
                    viewModel.addInterestTags(activitiesTags) {
                        if (it != null) {
                            toast("${it.message.toString()} Something went wrong")
                        }
                    }
                }, {}).show()
            }
            chip.isCloseIconVisible = true
            chip.setCloseIconResource(R.drawable.close_white)
            chip.setCloseIconTintResource(R.color.white)
            binding.cgInterests.addView(chip)
        }
    }

    private fun setClickListeners() {
        binding.ivBackButton.setOnClickListener {
            requireActivity().onBackPressed()
        }
        binding.civUser.setOnClickListener {
            requireActivity().onBackPressed()
        }
        binding.ivAddInterest.setOnClickListener {
            if (binding.actvInterest.text.isNullOrEmpty()){
                toast("Please enter tag first.")
            }else{
                 if (! volunteeringTagsSuggestions.contains(binding.actvInterest.text.toString())){
                     viewModel.saveActivitiesTag(binding.actvInterest.text.toString().trim())
                 }
                 if (interestTags.contains(binding.actvInterest.text.toString())){
                     toast("This Skill is already exist.")
                 }else{
                     interestTags.add(binding.actvInterest.text.toString().trim())
                     val chip = layoutInflater.inflate(R.layout.item_custom_chip, binding.cgInterests, false) as Chip
                     chip.text = binding.actvInterest.text.toString()
                     chip.setOnCloseIconClickListener { c ->
                         interestTags.remove((c as Chip).text)
                         binding.cgInterests.removeView(c)
                         viewModel.addInterestTags(interestTags){
                             if(it != null){
                                 toast("${it.message.toString()} Something went wrong")
                             }
                         }
                     }
                     chip.isCloseIconVisible = true
                     chip.setCloseIconResource(R.drawable.close_white)
                     chip.setCloseIconTintResource(R.color.white)
                     binding.cgInterests.addView(chip)
                     binding.actvInterest.text.clear()
                     viewModel.addInterestTags(interestTags){
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