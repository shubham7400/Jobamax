package com.findajob.jobamax.jobseeker.home

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModel
import com.findajob.jobamax.R
import com.findajob.jobamax.base.BaseActivityMain
import com.findajob.jobamax.databinding.ActivityJobSeekerHomeBinding
import com.findajob.jobamax.enums.ParseCloudFunction
import com.findajob.jobamax.enums.ParseTableFields
import com.findajob.jobamax.enums.ParseTableName
import com.findajob.jobamax.jobseeker.calender.SeekerCalenderActivity
import com.findajob.jobamax.jobseeker.coaching.SeekerCoachingActivity
import com.findajob.jobamax.jobseeker.jobsearch.SeekerJobSearchActivity
import com.findajob.jobamax.jobseeker.profile.SeekerProfileActivity
import com.findajob.jobamax.jobseeker.profile.account.JobSeekerAccountActivity
import com.findajob.jobamax.jobseeker.track.newtrack.SeekerJobTrackingActivity
import com.findajob.jobamax.jobseeker.wishlist.SeekerWishListActivity
import com.findajob.jobamax.preference.getUserId
import com.findajob.jobamax.services.LocationService
import com.findajob.jobamax.util.log
import com.findajob.jobamax.util.toast
import com.google.gson.Gson
import com.parse.*
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint
import org.json.JSONObject

@AndroidEntryPoint
class JobSeekerHomeActivity : BaseActivityMain<ActivityJobSeekerHomeBinding>(), View.OnClickListener {

    override val layoutRes: Int get() = R.layout.activity_job_seeker_home
    val viewModel: JobSeekerHomeViewModel by viewModels()
    override fun getViewModel(): ViewModel = viewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityJobSeekerHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        configureUi()
    }

    override fun onCreated(instance: Bundle?) {
        getCurrent()
    }

    private fun getCurrent( ) {
        val query = ParseQuery.getQuery<ParseObject>(ParseTableName.JobSeeker.toString())
        query.whereEqualTo(ParseTableFields.jobSeekerId.toString(),  getUserId())
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


    private fun configureUi() {
         setClickListeners()
        viewModelObserver()
        updateWishlistImages()
        if (!checkPermission()) {
            requestPermission()
        }else{
            ContextCompat.startForegroundService(this, Intent(this, LocationService::class.java))
        }
    }

    private fun checkPermission(): Boolean {
        val result = ContextCompat.checkSelfPermission(applicationContext, Manifest.permission.ACCESS_FINE_LOCATION)
        val result1 = ContextCompat.checkSelfPermission(applicationContext, Manifest.permission.ACCESS_COARSE_LOCATION)
        return result == PackageManager.PERMISSION_GRANTED && result1 == PackageManager.PERMISSION_GRANTED
    }

    private fun requestPermission() {
        ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION), 1)
    }

    private fun updateWishlistImages() {
        try {
            ParseCloud.callFunctionInBackground(ParseCloudFunction.getJobsLogo.toString(), hashMapOf("jobSeekerId" to getUserId()), FunctionCallback<Any> { result, e ->
                val jsonArray = JSONObject(Gson().toJson(result)).getJSONArray("urls")
                for (i in 0 until jsonArray.length()){
                    when(i){
                        0 -> {
                            Picasso.get().load(jsonArray[i].toString()).into(binding.iv1)
                        }
                        1 -> {
                            Picasso.get().load(jsonArray[i].toString()).into(binding.iv2)
                        }
                        2 -> {
                            Picasso.get().load(jsonArray[i].toString()).into(binding.iv3)
                        }
                    }
                }
            })

        }catch (e: Exception){log(e.message.toString())}
     }

    private fun viewModelObserver() {
         viewModel.isJobSeekerUpdated.observe(this, androidx.lifecycle.Observer {
             progressHud.dismiss()
             if (it){
                 binding.jobSeeker = viewModel.jobSeeker
             }
         })
    }

    private fun setClickListeners() {
        binding.btJobSearch.setOnClickListener(this)
        binding.btnCoaching.setOnClickListener(this)
        binding.tvSeekerName.setOnClickListener(this)
        binding.vProfile.setOnClickListener(this)
        binding.vCalendar.setOnClickListener(this)
        binding.vProfile.setOnClickListener(this)
        binding.vTrack.setOnClickListener(this)
        binding.vWishlist.setOnClickListener(this)
        binding.ivSetting.setOnClickListener(this)
        binding.ivSetting.setOnClickListener(this)
        binding.textView6.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when(view){

            binding.ivSetting ->{
                startActivity(Intent(this, JobSeekerAccountActivity::class.java))
            }
            binding.vProfile ->{
                startActivity(Intent(this, SeekerProfileActivity::class.java))
            }
            binding.vCalendar ->{
                startActivity(Intent(this, SeekerCalenderActivity::class.java))
            }
            binding.vTrack ->{
                startActivity(Intent(this, SeekerJobTrackingActivity::class.java))
            }
            binding.vWishlist ->{
                startActivity(Intent(this, SeekerWishListActivity::class.java))
            }
            binding.tvSeekerName ->{

            }
            binding.btJobSearch ->{
                startActivity(Intent(this, SeekerJobSearchActivity::class.java))
            }
            binding.btnCoaching ->{
                startActivity(Intent(this, SeekerCoachingActivity::class.java))
            }
        }
    }

}

