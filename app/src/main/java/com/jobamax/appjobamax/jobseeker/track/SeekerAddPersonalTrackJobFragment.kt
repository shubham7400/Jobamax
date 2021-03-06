package com.jobamax.appjobamax.jobseeker.track

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation
import com.jobamax.appjobamax.R
import com.jobamax.appjobamax.base.BaseFragmentMain
import com.jobamax.appjobamax.data.pojo.PhaseGroup
import com.jobamax.appjobamax.databinding.FragmentSeekerAddPersonalTrackJobBinding
import com.jobamax.appjobamax.enums.ParseTableFields
import com.jobamax.appjobamax.enums.ParseTableName
import com.jobamax.appjobamax.jobseeker.home.JobSeekerHomeViewModel
import com.jobamax.appjobamax.util.convertCustomObjectToJsonString
import com.jobamax.appjobamax.util.toast
import com.parse.ParseObject


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
             val pfObject = ParseObject(ParseTableName.PERSONAL_TRACK_JOB.value)
             viewModel.jobSeeker.pfObject?.let { it1 -> pfObject.put("jobSeeker", it1) }
             pfObject.put("jobSeekerId", viewModel.jobSeeker.jobSeekerId)
             if (binding.etJobTitle.text.isNullOrEmpty()){
                 pfObject.put(ParseTableFields.JOB_TITLE.value, "")
             }else{
                 pfObject.put(ParseTableFields.JOB_TITLE.value, binding.etJobTitle.text.toString())
             }
             if (binding.etCity.text.isNullOrEmpty()){
                 pfObject.put(ParseTableFields.CITY.value, "")
             }else{
                 pfObject.put(ParseTableFields.CITY.value, binding.etCity.text.toString())
             }
             if (binding.etCompanyName.text.isNullOrEmpty()){
                 pfObject.put(ParseTableFields.COMPANY_NAME.value, "")
             }else{
                 pfObject.put(ParseTableFields.COMPANY_NAME.value, binding.etCompanyName.text.toString())
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