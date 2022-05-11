package com.findajob.jobamax.jobseeker.track.newtrack

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation
import com.findajob.jobamax.R
import com.findajob.jobamax.base.BaseFragmentMain
import com.findajob.jobamax.data.pojo.PhaseGroup
import com.findajob.jobamax.databinding.FragmentSeekerAddPersonalTrackJobBinding
import com.findajob.jobamax.databinding.FragmentSeekerTrackingJobBinding
import com.findajob.jobamax.enums.ParseTableFields
import com.findajob.jobamax.enums.ParseTableName
import com.findajob.jobamax.jobseeker.home.JobSeekerHomeViewModel
import com.findajob.jobamax.util.convertCustomObjectToJsonString
import com.findajob.jobamax.util.log
import com.findajob.jobamax.util.toast
import com.google.gson.Gson
import com.parse.ParseObject
import com.parse.ParseQuery


class SeekerAddPersonalTrackJobFragment : BaseFragmentMain<FragmentSeekerAddPersonalTrackJobBinding>() {


    override val layoutRes: Int get() = R.layout.fragment_seeker_add_personal_track_job
    val viewModel: JobSeekerHomeViewModel by activityViewModels()
    override fun getViewModel(): ViewModel = viewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentSeekerAddPersonalTrackJobBinding.inflate(inflater, container, false)
        configureUi()
        return binding.root
    }

    private fun configureUi() {
         setClickListeners()
        binding.jobSeeker = viewModel.jobSeeker
    }

    private fun setClickListeners() {
         binding.btnSaveInfo.setOnClickListener {
             val pfObject = ParseObject(ParseTableName.PersonalTrackJob.toString())
             viewModel.jobSeeker.pfObject?.let { it1 -> pfObject.put("jobSeeker", it1) }
             pfObject.put("jobSeekerId", viewModel.jobSeeker.jobSeekerId)
             if (binding.etJobTitle.text.isNullOrEmpty()){
                 pfObject.put(ParseTableFields.jobTitle.toString(), "")
             }else{
                 pfObject.put(ParseTableFields.jobTitle.toString(), binding.etJobTitle.text.toString())
             }
             if (binding.etCity.text.isNullOrEmpty()){
                 pfObject.put(ParseTableFields.city.toString(), "")
             }else{
                 pfObject.put(ParseTableFields.city.toString(), binding.etCity.text.toString())
             }
             if (binding.etCompanyName.text.isNullOrEmpty()){
                 pfObject.put(ParseTableFields.companyName.toString(), "")
             }else{
                 pfObject.put(ParseTableFields.companyName.toString(), binding.etCompanyName.text.toString())
             }

             pfObject.put("phases", convertCustomObjectToJsonString(PhaseGroup()))
             progressHud.show()
             pfObject.saveInBackground {
                 progressHud.dismiss()
                 if (it != null){
                     toast("${it.message.toString()}")
                 }else{
                     toast("Added.")
                     requireActivity().onBackPressed()
                 }
             }
         }

        binding.ivBackButton.setOnClickListener { requireActivity().onBackPressed() }
        binding.ivUserProfile.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_seekerAddPersonalTrackJobFragment_to_nav_seeker_profile, null))
    }

    override fun onCreated(savedInstance: Bundle?) {

    }

}