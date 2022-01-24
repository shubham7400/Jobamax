package com.findajob.jobamax.jobseeker.home

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.android.billingclient.api.*
import com.findajob.jobamax.R
import com.findajob.jobamax.base.BaseActivityMain
import com.findajob.jobamax.base.BaseViewModel
import com.findajob.jobamax.dashboard.messages.MainChatActivity
import com.findajob.jobamax.dashboard.messages.MessagesFragment
import com.findajob.jobamax.dashboard.messages.ProfileActivity
import com.findajob.jobamax.databinding.ActivityJobSeekerHomeBinding
import com.findajob.jobamax.jobseeker.course.JobSeekerCourseActivity
import com.findajob.jobamax.jobseeker.profile.JobSeekerProfileFragment
import com.findajob.jobamax.jobseeker.profile.SeekerProfileActivity
import com.findajob.jobamax.jobseeker.profile.account.JobSeekerAccountActivity
import com.findajob.jobamax.jobseeker.profile.account.personalInfo.JobSeekerPersonalIntroInfoActivity
import com.findajob.jobamax.jobseeker.profile.cv.JobSeekerResumeViewModel
import com.findajob.jobamax.jobseeker.track.JobSeekerApplyActivity
import com.findajob.jobamax.jobseeker.track.JobSeekerApplyFragment
import com.findajob.jobamax.jobseeker.track.newtrack.SeekerJobTrackingActivity
import com.findajob.jobamax.jobseeker.wishlist.SeekerWishListActivity
import com.findajob.jobamax.model.UpdateUserCallback
import com.findajob.jobamax.util.errorToast
import com.findajob.jobamax.util.log
import com.findajob.jobamax.util.toast
import com.google.android.gms.location.*
import com.parse.ParseGeoPoint
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_job_seeker_home.*
import org.jetbrains.anko.longToast
import java.util.*

@AndroidEntryPoint
class JobSeekerHomeActivity : BaseActivityMain<ActivityJobSeekerHomeBinding>(), /*JobSeekerHomeInterface, PurchasesUpdatedListener,*/ View.OnClickListener {

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
        progressHud.show()
        viewModel.getJobSeeker()
    }

    private fun configureUi() {
         setClickListeners()
        viewModelObserver()
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
        binding.vMessage.setOnClickListener(this)
        binding.vProfile.setOnClickListener(this)
        binding.vTrack.setOnClickListener(this)
        binding.vWishlist.setOnClickListener(this)
        binding.ivSetting.setOnClickListener(this)
        binding.ivSetting.setOnClickListener(this)
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
                startActivity(Intent(this, JobSeekerCourseActivity::class.java))
            }
            binding.vMessage ->{
                startActivity(Intent(this, MainChatActivity::class.java))
            }
            binding.vTrack ->{
                startActivity(Intent(this, JobSeekerApplyActivity::class.java))
            }
            binding.vWishlist ->{
                startActivity(Intent(this, SeekerWishListActivity::class.java))
            }
            binding.tvSeekerName ->{

            }
            binding.btJobSearch ->{
                startActivity(Intent(this, ProfileActivity::class.java))
            }
            binding.btnCoaching ->{
                startActivity(Intent(this, SeekerJobTrackingActivity::class.java))
            }
        }
    }



    /*val viewModel: JobSeekerHomeViewModel by viewModels()

    private lateinit var fusedLocationClient: FusedLocationProviderClient
  *//*  lateinit var navController: NavController*//*

    private var billingClient: BillingClient? = null

    var trackToggleFlag = true
    var currentPosition = -1

    override fun onCreated(instance: Bundle?) {
        initViews()
        *//*configureViewModel()*//*
    }

    private fun initViews() {
      *//*  binding.handler = this
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)*//*
        setClickListeners()
       *//* navController = findNavController(R.id.nav_host_fragment)*//*
     *//*   onIconClicked(2)*//*

        *//*navController.addOnDestinationChangedListener { _, dest, _ ->
            *//**//*if (dest.id == R.id.jobSeekerCourseFragment || dest.id == R.id.messagesFragment || dest.id == R.id.jobSeekerProfileFragment || dest.id == R.id.jobSeekerApplyFragment || dest.id == R.id.jobSeekerTrackFragment) {
                appbar.visibility = View.VISIBLE
            } else appbar.visibility = View.GONE*//**//*
        }*//*
    }*/

   /* private fun configureViewModel() {
        viewModel.getJobSeeker()
    }


    override fun onResume() {
        super.onResume()
        val request = LocationRequest()
        request.interval = 10000
        request.fastestInterval = 10000
        request.priority = LocationRequest.PRIORITY_HIGH_ACCURACY

        val permission =
            ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
        if (permission == PackageManager.PERMISSION_GRANTED) {
            fusedLocationClient.requestLocationUpdates(request, locationCallback, null)
        }
    }

    override fun onPause() {
        super.onPause()
        fusedLocationClient.removeLocationUpdates(locationCallback)
    }

    private val locationCallback = object : LocationCallback() {
        override fun onLocationResult(locationResult: LocationResult) {
            val lastLocation = locationResult.lastLocation
            viewModel.currentLocation = ParseGeoPoint(lastLocation.latitude, lastLocation.longitude)
        }
    }

    override fun onBackPressed() {
      *//*  val currDest = navController.currentDestination?.id*//*
       *//* if (currDest == R.id.jobSeekerCourseFragment || currDest == R.id.messagesFragment || currDest == R.id.jobSeekerProfileFragment) {
            onIconClicked(2)
        } else
            super.onBackPressed()*//*
    }

    override fun onIconClicked(position: Int) {
        if (position == 2 && currentPosition == 2) {
            trackToggleFlag = !trackToggleFlag
          *//*  if (trackToggleFlag) {
                *//**//*toggleIcon.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_track_switch))*//**//*
                navController.popBackStack()
                navController.navigate(R.id.jobSeekerApplyFragment)
            } else {
                *//**//*toggleIcon.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_apply_switch))*//**//*
                navController.popBackStack()
                navController.navigate(R.id.jobSeekerTrackFragment)
            }*//*
        } else {
            binding.state = position
            currentPosition = position
            setUpAppbar()
        }
    }

    private fun setUpAppbar() {
        *//*if (currentPosition == 2) {
            *//**//*toggleIcon.visibility = View.VISIBLE
            secondIcon.visibility = View.GONE*//**//*
            if (trackToggleFlag)
                *//**//*toggleIcon.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_track_switch))*//**//*
            else
                *//**//*toggleIcon.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_apply_switch))*//**//*
        } else {
            *//**//*toggleIcon.visibility = View.GONE
            secondIcon.visibility = View.VISIBLE*//**//*
        }
*//*
        *//*firstIcon.requestLayout()
        firstIcon.layoutParams.height = resources.getDimension(R.dimen.home_icon_24dp).toInt()
        firstIcon.layoutParams.width = resources.getDimension(R.dimen.home_icon_24dp).toInt()
        secondIcon.requestLayout()
        secondIcon.layoutParams.height = resources.getDimension(R.dimen.home_icon_24dp).toInt()
        secondIcon.layoutParams.width = resources.getDimension(R.dimen.home_icon_24dp).toInt()
        thirdIcon.requestLayout()
        thirdIcon.layoutParams.height = resources.getDimension(R.dimen.home_icon_24dp).toInt()
        thirdIcon.layoutParams.width = resources.getDimension(R.dimen.home_icon_24dp).toInt()
        fourthIcon.requestLayout()
        fourthIcon.layoutParams.height = resources.getDimension(R.dimen.home_icon_20dp).toInt()
        fourthIcon.layoutParams.width = resources.getDimension(R.dimen.home_icon_20dp).toInt()*//*
       *//* when (currentPosition) {
            1 -> {
              *//**//*  firstIcon.requestLayout()
                firstIcon.layoutParams.height =
                    resources.getDimension(R.dimen.home_icon_48dp).toInt()
                firstIcon.layoutParams.width =
                    resources.getDimension(R.dimen.home_icon_48dp).toInt()*//**//*
                navController.popBackStack()
                navController.navigate(R.id.jobSeekerCourseFragment)
            }
            2 -> {
               *//**//* secondIcon.requestLayout()
                secondIcon.layoutParams.height = resources.getDimension(R.dimen.home_icon_40dp).toInt()
                secondIcon.layoutParams.width = resources.getDimension(R.dimen.home_icon_40dp).toInt()*//**//*
                if (trackToggleFlag) {
                    navController.popBackStack()
                    *//**//*toggleIcon.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_track_switch))*//**//*
                    navController.navigate(R.id.jobSeekerApplyFragment)
                } else {
                    navController.popBackStack()
                   *//**//* toggleIcon.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_apply_switch))*//**//*
                    navController.navigate(R.id.jobSeekerTrackFragment)
                }
            }
            3 -> {
                *//**//*thirdIcon.requestLayout()
                thirdIcon.layoutParams.height = resources.getDimension(R.dimen.home_icon_40dp).toInt()
                thirdIcon.layoutParams.width = resources.getDimension(R.dimen.home_icon_40dp).toInt()*//**//*
                navController.popBackStack()
                navController.navigate(R.id.messagesFragment)
            }
            else -> {
                *//**//*fourthIcon.requestLayout()
                fourthIcon.layoutParams.height = resources.getDimension(R.dimen.home_icon_32dp).toInt()
                fourthIcon.layoutParams.width = resources.getDimension(R.dimen.home_icon_32dp).toInt()*//**//*
                navController.popBackStack()
                navController.navigate(R.id.jobSeekerProfileFragment)
            }
        }*//*
    }

    fun initBilling() {
        progressHud.show()
        billingClient = BillingClient.newBuilder(this)
            .setListener(this)
            .enablePendingPurchases()
            .build()

        billingClient?.startConnection(object : BillingClientStateListener {
            override fun onBillingSetupFinished(billingResult: BillingResult) {
                if (billingResult.responseCode == BillingClient.BillingResponseCode.OK) {
                    querySkuDetails()
                } else {

                    if (!this@JobSeekerHomeActivity.isFinishing) {
                        progressHud.dismiss()
                        longToast(" Error Code: " + billingResult.responseCode)
                    }
                }
            }

            override fun onBillingServiceDisconnected() {
                if (!this@JobSeekerHomeActivity.isFinishing) {
                    progressHud.dismiss()
                    longToast("Billing Service Disconnected")
                }
            }
        })
    }


    fun querySkuDetails() {
        val skuList = ArrayList<String>()
        skuList.add(resources.getString(R.string.product_id))
        val params = SkuDetailsParams.newBuilder()
        params.setSkusList(skuList).setType(BillingClient.SkuType.INAPP)
        billingClient?.querySkuDetailsAsync(params.build()) { _, skuDetailsList ->

            if (!this@JobSeekerHomeActivity.isFinishing) {
                progressHud.dismiss()
                if (skuDetailsList != null && skuDetailsList.isNotEmpty()) {
                    val skuDetails = skuDetailsList[0]
                    val flowParams = BillingFlowParams.newBuilder()
                        .setSkuDetails(skuDetails!!)
                        .build()
                    billingClient?.launchBillingFlow(this, flowParams)?.responseCode

                } else errorToast()
            }
        }
    }

    override fun onPurchasesUpdated(billingResult: BillingResult, purchases: MutableList<Purchase>?) {
        log("onPurchasesUpdated()")
        if (billingResult.responseCode == BillingClient.BillingResponseCode.OK && purchases != null) {
            for (purchase in purchases) {
                log("purchase: ${purchase.sku}")
                handlePurchase(purchase)
            }
        } else if (billingResult.responseCode == BillingClient.BillingResponseCode.USER_CANCELED) {
            // Handle an error caused by a user cancelling the purchase flow.

        } else {
            val error = when (billingResult.responseCode) {
                -3 -> "SERVICE_TIMEOUT"
                -2 -> "FEATURE_NOT_SUPPORTED"
                -1 -> "SERVICE_DISCONNECTED"
                0 -> "OK"
                1 -> "USER_CANCELED"
                2 -> "SERVICE_UNAVAILABLE"
                3 -> "BILLING_UNAVAILABLE"
                4 -> "ITEM_UNAVAILABLE"
                5 -> "DEVELOPER_ERROR"
                7 -> "ITEM_ALREADY_OWNED"
                8 -> "ITEM_NOT_OWNED"
                else -> "ERROR"
            }
            longToast(" Error: " + error)
        }
    }

    private fun handlePurchase(purchase: Purchase) {
        if (purchase.sku.equals(resources.getString(R.string.product_id), ignoreCase = true)) {
            progressHud.show()
            viewModel.updateReachCount(15, object : UpdateUserCallback {
                override fun onFinish(isSuccessful: Boolean) {
                    progressHud.dismiss()
                    toast("Purchase Successful!")
                }

            })
        }
    }

    override val layoutRes: Int
        get() = R.layout.activity_job_seeker_home

    override fun getViewModel(): ViewModel = viewModel*/

}

interface JobSeekerHomeInterface {
    fun onIconClicked(position: Int)
}