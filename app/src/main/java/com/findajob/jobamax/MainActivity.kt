package com.findajob.jobamax

import android.content.Intent
import android.content.res.Configuration
import android.content.res.Resources
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.findajob.jobamax.databinding.ActivityMainBinding
import com.findajob.jobamax.enums.FirebaseDynamicLinkPath
import com.findajob.jobamax.enums.ParseTableFields
import com.findajob.jobamax.enums.ParseTableName
import com.findajob.jobamax.jobseeker.home.JobSeekerHomeActivity
import com.findajob.jobamax.jobseeker.jobsearch.SeekerJobSearchActivity
import com.findajob.jobamax.login.LoginActivity
import com.findajob.jobamax.model.JobSeeker
import com.findajob.jobamax.model.Recruiter
import com.findajob.jobamax.preference.*
 import com.findajob.jobamax.util.log
import com.findajob.jobamax.util.toast
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
        val intent = intent
        intent?.let { handleDeepLink(it) }
    }

    private fun setLocale(languageCode: String) {
        val locale = Locale(languageCode)
        Locale.setDefault(locale)
        val resources: Resources =  resources
        val config: Configuration = resources.configuration
        config.setLocale(locale)
        resources.updateConfiguration(config, resources.displayMetrics)
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
                            FirebaseDynamicLinkPath.verifyemail.toString() -> {
                                if (userType == "2"){
                                    updateIsEmailVerifiedInJobSeeker(id)
                                }else if (userType == "1"){
                                    updateIsEmailVerifiedInRecruiter(id)
                                }
                            }
                            FirebaseDynamicLinkPath.shareJobOffer.toString() -> {
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

    private fun updateIsEmailVerifiedInRecruiter(recruiterId: String?) {
        val query = ParseQuery.getQuery<ParseObject>(ParseTableName.Recruiter.toString())
        query.whereEqualTo(ParseTableFields.recruiterId.toString(), recruiterId)
        query.getFirstInBackground { obj, e ->
            if (e != null){
                toast("error "+e.message.toString())
            }else{
                obj.put(ParseTableFields.emailVerified.toString(),true)
                obj.saveInBackground {
                    if (it == null){
                        toast("Email has been verified successfully.")
                        val recruiter = Recruiter(obj)
                        setUserId(recruiterId!!)
                        setPhoneNumber(recruiter.phoneNumber)
                        setLoginType(recruiter.loginType)
                        setLoggedIn(true)
                        /*startActivity(Intent(this,  RecruiterHomeActivity::class.java))*/
                        finishAffinity()
                    }else{
                        toast(it.message.toString())
                    }
                }
            }
        }
    }



    private fun updateIsEmailVerifiedInJobSeeker(jobSeekerId: String?) {
            val query = ParseQuery.getQuery<ParseObject>(ParseTableName.JobSeeker.toString())
            query.whereEqualTo(ParseTableFields.jobSeekerId.toString(), jobSeekerId)
            query.getFirstInBackground { obj, e ->
                if (e != null){
                    toast("error "+e.message.toString())
                }else{
                    obj.put(ParseTableFields.emailVerified.toString(),true)
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
            if (getUserType() == 2){
                if (getUserId() != ""){
                    startActivity(Intent(this, JobSeekerHomeActivity::class.java))
                    finish()
                }
            }else{
               /* startActivity(Intent(this, RecruiterHomeActivity::class.java))
                finish()*/
            }
        }else{
            setUserType(2)
            startActivity(Intent(this@MainActivity, LoginActivity::class.java))
            finish()
        }
    }



}
