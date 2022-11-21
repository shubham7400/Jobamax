package com.jobamax.appjobamax

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.jobamax.appjobamax.enums.FirebaseDynamicLinkHost
import com.jobamax.appjobamax.enums.FirebaseDynamicLinkPath
import com.jobamax.appjobamax.enums.ParseTableFields
import com.jobamax.appjobamax.enums.ParseTableName
import com.jobamax.appjobamax.extensions.log
import com.jobamax.appjobamax.extensions.toast
import com.jobamax.appjobamax.jobseeker.JobSeekerHomeActivity
import com.jobamax.appjobamax.jobseeker.build_profile.BuildProfileActivity
import com.jobamax.appjobamax.login.LoginFlowActivity
import com.jobamax.appjobamax.model.UserTempInfo
import com.jobamax.appjobamax.preference.*
import com.jobamax.appjobamax.recruiter.RecruiterHomeActivity
import com.jobamax.appjobamax.util.ARG_USER
import com.parse.ParseObject
import com.parse.ParseQuery
import kotlinx.coroutines.delay

class NewSplashActivity : AppCompatActivity() {

    val user = UserTempInfo()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_splash)

        handleIntent(intent)
        configureUi()
    }



    private fun configureUi() {
        lifecycleScope.launchWhenStarted {
            delay(2000)
            if (isLoggedIn()){
                when(getUserType()){
                    1 -> {
                        startActivity(Intent(this@NewSplashActivity, RecruiterHomeActivity::class.java))
                        finish()
                    }
                    2 -> {
                        if (getSeenOnBoarding()){
                            startActivity(Intent(this@NewSplashActivity, JobSeekerHomeActivity::class.java))
                            finish()
                        }else{
                            startActivity(Intent(this@NewSplashActivity, BuildProfileActivity::class.java))
                            finish()
                        }
                    }
                    else -> {
                        val args = Bundle()
                        args.putSerializable(ARG_USER, user)
                        startActivity(Intent(this@NewSplashActivity, LoginFlowActivity::class.java).putExtra(ARG_USER, args))
                        finish()
                    }
                }
            }else{
                val args = Bundle()
                args.putSerializable(ARG_USER, user)
                startActivity(Intent(this@NewSplashActivity, LoginFlowActivity::class.java).putExtra(ARG_USER, args))
                finish()
            }
        }
    }


    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        intent?.let { newIntent ->
            handleIntent(newIntent)
        }
    }

    private fun handleIntent(intent: Intent?) {
        val appLinkData: Uri? = intent?.data
        showDeepLinkOffer(appLinkData)
    }


    private fun showDeepLinkOffer( appLinkData: Uri?) {
        setSharedJobOfferId("")
        setSharedJobSharerId("")
        if (appLinkData != null) {
            val path = appLinkData.path?.removePrefix("/")
            val scheme = appLinkData.scheme
            val host = appLinkData.host

            if (scheme != null && host != null){
                when(path){
                    FirebaseDynamicLinkPath.SHARE_JOB_OFFER.path -> {
                        val jobOfferId = appLinkData.getQueryParameter(ParseTableFields.JOB_OFFER_ID.value)
                        val jobSeekerId = appLinkData.getQueryParameter(ParseTableFields.JOB_SEEKER_ID.value)
                        val sharerId = appLinkData.getQueryParameter("sharerId")
                        setSharedJobOfferId(jobOfferId ?: "")
                        setSharedJobSharerId(sharerId ?: "")
                    }
                }
            }

        }
    }



}