package com.findajob.jobamax.login

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.findajob.jobamax.R
import com.findajob.jobamax.base.BaseActivityMain
import com.findajob.jobamax.databinding.ActivityLoginBinding
import com.findajob.jobamax.dialog.multiChoice.BasicDialog
import com.findajob.jobamax.enums.LoginType
import com.findajob.jobamax.enums.ParseTableFields
import com.findajob.jobamax.enums.ParseTableName
import com.findajob.jobamax.jobseeker.home.JobSeekerHomeActivity
import com.findajob.jobamax.model.JobSeeker
import com.findajob.jobamax.model.Recruiter
import com.findajob.jobamax.model.UserTempInfo
import com.findajob.jobamax.preference.*
import com.findajob.jobamax.util.*
import com.parse.ParseObject
import com.parse.ParseQuery
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : BaseActivityMain<ActivityLoginBinding>() {
    lateinit var viewModel: LoginViewModel
    lateinit var navController: NavController

    override val layoutRes: Int get() = R.layout.activity_login

    override fun getViewModel(): ViewModel = viewModel

    override fun onCreated(instance: Bundle?) {
        initViews()
        configureViewModel()
    }

    private fun initViews(){
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.login_nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController
    }

    private fun configureViewModel(){
        viewModel = ViewModelProvider(this)[LoginViewModel::class.java]
    }

    fun isEmailAlreadyRegistered(user: UserTempInfo, callback : () -> Unit) {
        progressHud.show()
        val query = ParseQuery.getQuery<ParseObject>(ParseTableName.JobSeeker.toString())
        query.whereContains(ParseTableFields.email.toString(), user.email)
        query.whereContains(ParseTableFields.loginType.toString(), LoginType.EMAIL.type)
        query.getFirstInBackground { result, e ->
            progressHud.dismiss()
            when{
                result != null -> {
                    BasicDialog(this, "User is already registered with this email.", true){callback()}.show()
                }
                else -> {
                    navController.navigate(R.id.valuePrivacyFragment, bundleOf(ARG_ACTION to ACTION_REGISTER, ARG_USER to user))
                }
            }
        }
    }

    fun loginSeeker(user: UserTempInfo) {
        when(user.loginType){
            LoginType.EMAIL.type ->{
                getUserLogin(user)
            }
            LoginType.GOOGLE.type ->{
                navController.navigate(R.id.locationPermissionFragment, bundleOf(ARG_ACTION to ACTION_REGISTER, ARG_USER to user))
            }
            LoginType.LINKEDIN.type ->{
                navController.navigate(R.id.locationPermissionFragment, bundleOf(ARG_ACTION to ACTION_REGISTER, ARG_USER to user))
            }
            LoginType.FACEBOOK.type ->{
                navController.navigate(R.id.locationPermissionFragment, bundleOf(ARG_ACTION to ACTION_REGISTER, ARG_USER to user))
            }
        }
    }

    fun getUserLogin(user: UserTempInfo) {
        progressHud.show()
        val query = ParseQuery.getQuery<ParseObject>(ParseTableName.JobSeeker.toString())
        query.whereEqualTo(ParseTableFields.email.toString(), user.email)
        if (user.loginType == LoginType.EMAIL.type){
            query.whereEqualTo(ParseTableFields.loginType.toString(), user.loginType)
            query.whereEqualTo(ParseTableFields.password.toString(), AESCrypt.encrypt(user.password))
        }
        query.getFirstInBackground { result, e ->
            progressHud.dismiss()
            if (e == null && result != null) {
                if (result.getBoolean("emailVerified")) {
                    val jobSeeker = JobSeeker(result)
                    setUserId(jobSeeker.jobSeekerId)
                    setPhoneNumber(jobSeeker.phoneNumber)
                    setLoginType(jobSeeker.loginType)
                    setLoggedIn(true)
                    if (checkLocationPermission()) {
                        startActivity(Intent(this, JobSeekerHomeActivity::class.java))
                        finishAffinity()
                    } else
                        navController.navigate(R.id.locationPermissionFragment, bundleOf(ARG_ACTION to ACTION_LOGIN, ARG_USER to user))
                } else {
                    toast("Please verify account clicking on sent email at the time of registration.")
                }
            } else {
                toast("error: ${e.message.toString()}")
            }
        }
    }

    fun loginRecruiter(email: String, password: String) {
        progressHud.show()
        val query = ParseQuery.getQuery<ParseObject>(ParseTableName.Recruiter.toString())
        query.whereEqualTo(ParseTableFields.email.toString(), email)
        query.whereEqualTo(ParseTableFields.loginType.toString(), LoginType.EMAIL.type)
        query.whereEqualTo(ParseTableFields.password.toString(), AESCrypt.encrypt(password) )
        query.getFirstInBackground { result, e ->
            progressHud.dismiss()
            if (e == null && result != null) {
                if (result.getBoolean("emailVerified")) {
                    val recruiter = Recruiter(result)
                    setUserId(recruiter.recruiterId)
                    setPhoneNumber(recruiter.phoneNumber)
                    setLoginType(recruiter.loginType)
                    setLoggedIn(true)
                    if (checkLocationPermission()) {
                        /*startActivity(Intent(this, RecruiterHomeActivity::class.java))
                        finishAffinity()*/
                    } else navController.navigate(
                        R.id.locationPermissionFragment,
                        bundleOf(ARG_ACTION to ACTION_LOGIN)
                    )
                } else {
                    toast("Please verify account clicking on sent email at the time of registration.")
                }
            } else {
                toast("error: ${e.message.toString()}")
            }
        }
    }



    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == AUTOCOMPLETE_REQUEST_CODE && resultCode == RESULT_OK && data != null) {

            val intent = Intent()

            intent.putExtra(ARG_LOCATION, data.getStringExtra(ARG_LOCATION))
            intent.putExtra(ARG_LAT, data.getDoubleExtra(ARG_LAT, 0.0))
            intent.putExtra(ARG_LNG, data.getDoubleExtra(ARG_LNG, 0.0))
            intent.putExtra(ARG_CITY, data.getStringExtra(ARG_CITY))

            setResult(Activity.RESULT_OK, intent)

        } else {
//            errorToast()
//            finish()
        }
    }




}