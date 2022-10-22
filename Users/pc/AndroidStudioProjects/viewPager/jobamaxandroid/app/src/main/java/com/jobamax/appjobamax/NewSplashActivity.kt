package com.jobamax.appjobamax

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.jobamax.appjobamax.enums.FirebaseDynamicLinkPath
import com.jobamax.appjobamax.enums.ParseTableFields
import com.jobamax.appjobamax.enums.ParseTableName
import com.jobamax.appjobamax.extensions.log
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


    private fun handleIntent(intent: Intent?) {
        val appLinkAction: String? = intent?.action
        val appLinkData: Uri? = intent?.data
        showDeepLinkOffer(appLinkAction, appLinkData)
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        intent?.let { newIntent ->
            handleIntent(newIntent)
        }
    }

    private fun showDeepLinkOffer(appLinkAction: String?, appLinkData: Uri?) {
        if (Intent.ACTION_VIEW == appLinkAction && appLinkData != null) {
            val path = appLinkData.path?.removePrefix("/")
            path?.let {
                when(path){
                    FirebaseDynamicLinkPath.SALESMAN.path -> {
                        val promoCode = appLinkData.getQueryParameter("promoCode")
                        if (promoCode.isNullOrBlank().not()) {
                            user.promoCode = promoCode
                            savePromoCode(getUserId(), promoCode)
                        }
                    }
                }
            }

        }
    }

    private fun savePromoCode(jobSeekerId: String?, promoCode: String?) {
        val query = ParseQuery.getQuery<ParseObject>(ParseTableName.JOB_SEEKER.value)
        query.whereEqualTo(ParseTableFields.JOB_SEEKER_ID.value, jobSeekerId)
        query.getFirstInBackground { obj, e ->
            if (e != null){
                log("error "+e.message.toString())
            }else{
                if (promoCode != null) {
                    obj.put(ParseTableFields.PROMO_CODE.value,promoCode)
                }
                obj.saveInBackground {
                    if (it != null){
                        log(it.message.toString())
                    }
                }
            }
        }
    }


}