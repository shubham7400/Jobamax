package com.findajob.jobamax.jobseeker.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import com.findajob.jobamax.R
import com.findajob.jobamax.base.BaseFragmentMain
import com.findajob.jobamax.databinding.FragmentSeekerAboutMeBinding
import com.findajob.jobamax.jobseeker.home.JobSeekerHomeViewModel
import com.findajob.jobamax.util.PLACE_API_KEY
import com.findajob.jobamax.util.log
import com.findajob.jobamax.util.toast
import com.google.android.gms.common.api.Status
import com.google.android.libraries.places.api.Places
import com.google.android.libraries.places.api.model.Place
import com.google.android.libraries.places.api.model.TypeFilter
import com.google.android.libraries.places.widget.AutocompleteSupportFragment
import com.google.android.libraries.places.widget.listener.PlaceSelectionListener
import com.pushwoosh.internal.platform.AndroidPlatformModule.getApplicationContext
import dagger.hilt.android.AndroidEntryPoint
import java.util.*

@AndroidEntryPoint
class SeekerAboutMeFragment : BaseFragmentMain<FragmentSeekerAboutMeBinding>() {

    override val layoutRes: Int get() = R.layout.fragment_seeker_about_me
    val viewModel: JobSeekerHomeViewModel by activityViewModels()
    override fun getViewModel(): ViewModel = viewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentSeekerAboutMeBinding.inflate(inflater, container, false)
        configureUi()
        return binding.root
    }

    private fun configureUi() {
         setClickListeners()
        viewModelObserver()
    }

    private fun viewModelObserver() {
         viewModel.isJobSeekerUpdated.observe(viewLifecycleOwner, {
             if (it){
                 binding.jobSeeker = viewModel.jobSeeker
             }
         })
    }

    private fun setClickListeners() {
         binding.ivBackButton.setOnClickListener {
             (activity as SeekerProfileActivity).onBackPressed()
         }
        binding.btnSaveInfo.setOnClickListener {
            when {
                binding.etFirstName.text.isNullOrEmpty() -> {
                    toast("First name can not be empty.")
                }
                binding.etLastName.text.isNullOrEmpty() -> {
                    toast("Last name can not be empty.")
                }
                else -> {
                    viewModel.updateJobSeeker(binding.etFirstName.text.toString(), binding.etLastName.text.toString()){
                        if (it == null){
                            toast("User Updated.")
                            viewModel.getJobSeeker()
                        }else{
                            toast("${it.message.toString()} Something went wrong")
                        }
                    }
                }
            }
        }
    }

    override fun onCreated(savedInstance: Bundle?) {
         binding.jobSeeker = viewModel.jobSeeker
    }

}