package com.findajob.jobamax

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.lifecycle.ViewModel
import com.findajob.jobamax.base.BaseActivityMain
import com.findajob.jobamax.dashboard.home.training.masterclass.MasterClassDetailsActivity
import com.findajob.jobamax.databinding.ActivityMainBinding
import com.findajob.jobamax.enums.FirebaseDynamicLinkPath
import com.findajob.jobamax.enums.ParseTableFields
import com.findajob.jobamax.enums.ParseTableName
import com.findajob.jobamax.jobseeker.home.JobSeekerHomeActivity
import com.findajob.jobamax.login.LoginActivity
import com.findajob.jobamax.model.JobSeeker
import com.findajob.jobamax.preference.getRole
import com.findajob.jobamax.preference.getUserType
import com.findajob.jobamax.preference.isLoggedIn
import com.findajob.jobamax.recruiter.home.RecruiterHomeActivity
import com.findajob.jobamax.util.ROLE_JOB_SEEKER
import com.findajob.jobamax.util.ROLE_RECRUITER
import com.findajob.jobamax.util.log
import com.findajob.jobamax.util.toast
import com.google.firebase.dynamiclinks.ktx.dynamicLinks
import com.google.firebase.ktx.Firebase
import com.parse.ParseObject
import com.parse.ParseQuery
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivityMain<ActivityMainBinding>() {

    override val layoutRes: Int get() = R.layout.activity_main
    override fun getViewModel(): ViewModel? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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
                        val path = deepLink?.path!!.substring(1, deepLink!!.path!!.lastIndex)
                        when(path){
                            FirebaseDynamicLinkPath.verifyemail.toString() -> {
                                if (userType == "2"){
                                    updateIsEmailVerifiedInJobSeeker(id)
                                }else if (userType == "1"){
                                    updateIsEmailVerifiedInRecruiter(id)
                                }
                            }
                            FirebaseDynamicLinkPath.masterclassVideo.toString() -> {
                                startActivity(Intent(this, MasterClassDetailsActivity::class.java).putExtra("topic_id", topicId))
                            }
                        }
                    }
                }
                .addOnFailureListener(this) { e ->
                    log("getDynamicLink:onFailure ${e.message.toString()}")
                }

    }

    private fun updateIsEmailVerifiedInRecruiter(id: String?) {
      /*   val query = ParseQuery.getQuery<ParseObject>(ROLE_RECRUITER)
        query.whereEqualTo(ParseTableFields.r.toString(), id)
        val result = query.findInBackground()
        if (result == null){
            log("ssssererer $result")
        }else{
            log("sererer $result")
        }*/
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
                            getJobSeekerLoggedIn()
                        }else{
                            toast(it.message.toString())
                        }
                    }
                }
            }
    }

    private fun getJobSeekerLoggedIn() {

    }

    override fun onCreated(instance: Bundle?) {
        configureNavigation()
    }

    private fun configureNavigation() {
        if (isLoggedIn()) {
            if (getUserType() == 2)
                startActivity(Intent(this, JobSeekerHomeActivity::class.java))
            else startActivity(Intent(this, RecruiterHomeActivity::class.java))
            finish()
        }
        binding.btnGetStartedSlider.setOnClickListener {
            startActivity(Intent(this@MainActivity, LoginActivity::class.java))
            finish()
        }
    }

}
