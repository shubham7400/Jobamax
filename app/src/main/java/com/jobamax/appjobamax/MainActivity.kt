package com.jobamax.appjobamax

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.jobamax.appjobamax.databinding.ActivityMainBinding
import com.jobamax.appjobamax.enums.FirebaseDynamicLinkPath
import com.jobamax.appjobamax.enums.ParseTableFields
import com.jobamax.appjobamax.enums.ParseTableName
import com.jobamax.appjobamax.extensions.setLocale
import com.jobamax.appjobamax.jobseeker.home.JobSeekerHomeActivity
import com.jobamax.appjobamax.jobseeker.jobsearch.SeekerJobSearchActivity
import com.jobamax.appjobamax.login.LoginActivity
import com.jobamax.appjobamax.model.JobSeeker
import com.jobamax.appjobamax.preference.*
import com.jobamax.appjobamax.util.JOB_SEEKER_TYPE
import com.jobamax.appjobamax.util.log
import com.jobamax.appjobamax.util.toast
import com.google.firebase.dynamiclinks.ktx.dynamicLinks
import com.google.firebase.ktx.Firebase
import com.parse.ParseObject
import com.parse.ParseQuery
 import dagger.hilt.android.AndroidEntryPoint
import java.util.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setLocale(getLanguage())
        setJobSeekerJobFilter("")
        val intent = intent
        intent?.let { handleDeepLink(it) }
    }



    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        intent?.let { handleDeepLink(it) }
    }

    private fun handleDeepLink(it: Intent) {
            Firebase.dynamicLinks
                .getDynamicLink(it)
                .addOnSuccessListener(this) { pendingDynamicLinkData ->
                    var deepLink: Uri? = null
                    pendingDynamicLinkData?.let {
                        deepLink = pendingDynamicLinkData.link
                        // now you have parameters so you have to update email verified on server and get the obj of user and store it into session and then get user logged in
                        val userType = deepLink?.getQueryParameter("userType")
                        val loginType = deepLink?.getQueryParameter("LoginType")
                        val id = deepLink?.getQueryParameter("recruiterId")
                        val topicId = deepLink?.getQueryParameter("topicId")
                        val jobOfferId = deepLink?.getQueryParameter("jobOfferId")
                        val jobSeekerId = deepLink?.getQueryParameter("jobSeekerId")
                        val path = deepLink?.path!!.substring(1, deepLink!!.path!!.length)
                        when(path){
                            FirebaseDynamicLinkPath.EMAIL_VERIFICATION.toString() -> {
                                if (userType == JOB_SEEKER_TYPE){
                                    updateIsEmailVerifiedInJobSeeker(id)
                                }
                            }
                            FirebaseDynamicLinkPath.SHARE_JOB_OFFER.value -> {
                                startActivity(Intent(this, SeekerJobSearchActivity::class.java).also {
                                    it.putExtra("jobOfferId", jobOfferId)
                                    it.putExtra("jobSeekerId", jobSeekerId)
                                })
                            }
                            else -> {
                                configureNavigation()
                            }
                        }
                    }
                    if (pendingDynamicLinkData == null){
                        configureNavigation()
                    }
                }
                .addOnFailureListener(this) { e ->
                    configureNavigation()
                    log("getDynamicLink:onFailure ${e.message.toString()}")
                }
    }


    private fun updateIsEmailVerifiedInJobSeeker(jobSeekerId: String?) {
            val query = ParseQuery.getQuery<ParseObject>(ParseTableName.JOB_SEEKER.value)
            query.whereEqualTo(ParseTableFields.JOB_SEEKER_ID.value, jobSeekerId)
            query.getFirstInBackground { obj, e ->
                if (e != null){
                    toast("error "+e.message.toString())
                }else{
                    obj.put(ParseTableFields.EMAIL_VERIFIED.value,true)
                    obj.saveInBackground {
                        if (it == null){
                            toast("Email has been verified successfully.")
                            val jobSeeker = JobSeeker(obj)
                            setUserId(jobSeekerId!!)
                            setPhoneNumber(jobSeeker.phoneNumber)
                            setLoginType(jobSeeker.loginType)
                            setLoggedIn(true)
                            startActivity(Intent(this,  JobSeekerHomeActivity::class.java))
                            finishAffinity()
                        }else{
                            toast(it.message.toString())
                        }
                    }
                }
            }
    }




    private fun configureNavigation() {
        if (isLoggedIn()) {
            if (getUserId() != ""){
                startActivity(Intent(this, JobSeekerHomeActivity::class.java))
                finish()
            }
        }else{
            setUserType(JOB_SEEKER_TYPE.toInt())
            startActivity(Intent(this@MainActivity, LoginActivity::class.java))
            finish()
        }
    }



}
