package com.jobamax.appjobamax.jobseeker

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation
import com.jobamax.appjobamax.R
import com.jobamax.appjobamax.base.BaseFragmentMain
import com.jobamax.appjobamax.databinding.FragmentJobSeekerHomeBinding
import com.jobamax.appjobamax.enums.ParseCloudFunction
import com.jobamax.appjobamax.enums.ParseTableFields
import com.jobamax.appjobamax.enums.ParseTableName
import com.jobamax.appjobamax.jobseeker.home.JobSeekerHomeViewModel
import com.jobamax.appjobamax.preference.getUserId
import com.jobamax.appjobamax.services.LocationService
import com.jobamax.appjobamax.util.loadImageFromUrl
import com.jobamax.appjobamax.util.log
import com.jobamax.appjobamax.util.toast
import com.google.gson.Gson
import com.parse.FunctionCallback
import com.parse.ParseCloud
import com.parse.ParseObject
import com.parse.ParseQuery
import org.json.JSONObject

class JobSeekerHomeFragment : BaseFragmentMain<FragmentJobSeekerHomeBinding>() {

    override val layoutRes: Int get() = R.layout.fragment_job_seeker_home
    val viewModel: JobSeekerHomeViewModel by activityViewModels()
    override fun getViewModel(): ViewModel = viewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentJobSeekerHomeBinding.inflate(inflater, container, false)
        configureUi()
        return binding.root
    }

    private fun configureUi() {
        setClickListeners()
        viewModelObserver()
        updateWishlistImages()
        if (!checkPermission()) {
            requestPermission()
        }else{
            ContextCompat.startForegroundService(requireContext(), Intent(requireContext(), LocationService::class.java))
        }
    }

    override fun onCreated(savedInstance: Bundle?) {
        if (viewModel.jobSeekerObject == null){
            getCurrent()
        }
    }


    private fun getCurrent( ) {
        val query = ParseQuery.getQuery<ParseObject>(ParseTableName.JOB_SEEKER.value)
        query.whereEqualTo(ParseTableFields.JOB_SEEKER_ID.value,  requireContext().getUserId())
        query.include("portfolio")
        query.include("idealJob")
        progressHud.show()
        query.findInBackground { it, e ->
            progressHud.dismiss()
            val jobSeeker = it?.firstOrNull()
            when {
                e != null -> {
                    toast(e.message.toString())
                }
                jobSeeker == null -> {
                    toast("User Not Found.")
                }
                else -> {
                    viewModel.jobSeekerObject = jobSeeker
                    viewModel.isJobSeekerUpdated.value = true
                }
            }
        }
    }




    private fun checkPermission(): Boolean {
        val result = ContextCompat.checkSelfPermission(requireContext().applicationContext, Manifest.permission.ACCESS_FINE_LOCATION)
        val result1 = ContextCompat.checkSelfPermission(requireContext().applicationContext, Manifest.permission.ACCESS_COARSE_LOCATION)
        return result == PackageManager.PERMISSION_GRANTED && result1 == PackageManager.PERMISSION_GRANTED
    }

    private fun requestPermission() {
        ActivityCompat.requestPermissions(requireActivity(), arrayOf(Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION), 1)
    }

    private fun updateWishlistImages() {
        try {
            ParseCloud.callFunctionInBackground(ParseCloudFunction.GET_JOBS_LOGO.value, hashMapOf("jobSeekerId" to requireContext().getUserId()), FunctionCallback<Any> { result, e ->
                val jsonArray = JSONObject(Gson().toJson(result)).getJSONArray("urls")
                for (i in 0 until jsonArray.length()){
                    when(i){
                        0 -> {
                            loadImageFromUrl(binding.iv1, jsonArray[i].toString(), R.drawable.wishlist_dummy)
                        }
                        1 -> {
                            loadImageFromUrl(binding.iv2, jsonArray[i].toString(), R.drawable.wishlist_dummy)
                        }
                        2 -> {
                            loadImageFromUrl(binding.iv3, jsonArray[i].toString(), R.drawable.wishlist_dummy)
                        }
                    }
                }
            })

        }catch (e: Exception){log(e.message.toString())}
    }

    private fun viewModelObserver() {
        viewModel.isJobSeekerUpdated.observe(viewLifecycleOwner) {
            progressHud.dismiss()
            if (it) {
                binding.jobSeeker = viewModel.jobSeeker
            }
        }
        binding.jobSeeker = viewModel.jobSeeker
    }

    private fun setClickListeners() {
        binding.vProfile.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_jobSeekerHomeFragment_to_nav_seeker_profile, null))
        binding.vTrack.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_jobSeekerHomeFragment_to_nav_job_tracking, null))
        binding.vWishlist.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_jobSeekerHomeFragment_to_nav_seeker_wishlist, null))
        binding.vCalendar.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_jobSeekerHomeFragment_to_seekerCalenderFragment, null))
        binding.btJobSearch.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_jobSeekerHomeFragment_to_nav_job_search, null))
        binding.ivSetting.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_jobSeekerHomeFragment_to_nav_seeker_account, null))
        binding.btnCoaching.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_jobSeekerHomeFragment_to_seekerCoachingFragment, null))
    }
}