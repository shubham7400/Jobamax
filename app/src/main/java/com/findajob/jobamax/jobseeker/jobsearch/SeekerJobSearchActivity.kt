package com.findajob.jobamax.jobseeker.jobsearch

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.findajob.jobamax.R
import com.findajob.jobamax.databinding.ActivitySeekerJobSearchBinding
import com.findajob.jobamax.databinding.ItemSeekerJobCardBinding
import com.findajob.jobamax.enums.ParseCloudFunction
import com.findajob.jobamax.model.NewJobOffer
import com.findajob.jobamax.preference.getUserId
import com.findajob.jobamax.util.toast
import com.google.gson.Gson
import com.parse.FunctionCallback
import com.parse.ParseCloud
import com.yuyakaido.android.cardstackview.*
import org.json.JSONObject
import com.yuyakaido.android.cardstackview.CardStackLayoutManager
import android.view.animation.AccelerateInterpolator
import android.view.animation.LinearInterpolator
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.findajob.jobamax.enums.FirebaseDynamicLinkPath
import com.findajob.jobamax.enums.LoginType
import com.findajob.jobamax.preference.getUserType
import com.findajob.jobamax.util.log
import com.google.firebase.dynamiclinks.ktx.androidParameters
import com.google.firebase.dynamiclinks.ktx.dynamicLink
import com.google.firebase.dynamiclinks.ktx.dynamicLinks
import com.google.firebase.ktx.Firebase
import com.squareup.picasso.Picasso
import com.yuyakaido.android.cardstackview.SwipeAnimationSetting
import dagger.hilt.android.AndroidEntryPoint
import java.lang.Exception
import kotlin.collections.ArrayList

@AndroidEntryPoint
class SeekerJobSearchActivity : AppCompatActivity() {
    lateinit var binding: ActivitySeekerJobSearchBinding

    var jobSeekerId: String? = ""
    var jobOfferId: String? = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySeekerJobSearchBinding.inflate(layoutInflater)
        setContentView(binding.root)

        configureUi()
    }

    private fun configureUi() {
        if (intent.getStringExtra("jobSeekerId") != null) {
            jobSeekerId = intent.getStringExtra("jobSeekerId")
        }
        if (intent.getStringExtra("jobOfferId") != null) {
            jobOfferId = intent.getStringExtra("jobOfferId")
        }

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_seeker_job_search_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        val bundle = Bundle()
        bundle.putString("jobSeekerId", jobSeekerId)
        bundle.putString("jobOfferId", jobOfferId)
        navController.navigate(R.id.seekerJobsFragment, bundle)
    }

}