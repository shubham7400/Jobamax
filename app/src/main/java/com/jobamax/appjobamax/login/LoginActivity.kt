package com.jobamax.appjobamax.login

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.jobamax.appjobamax.R
import com.jobamax.appjobamax.base.BaseActivityMain
import com.jobamax.appjobamax.databinding.ActivityLoginBinding
import com.jobamax.appjobamax.dialog.BasicDialog
import com.jobamax.appjobamax.enums.LoginType
import com.jobamax.appjobamax.enums.ParseTableFields
import com.jobamax.appjobamax.enums.ParseTableName
import com.jobamax.appjobamax.jobseeker.home.JobSeekerHomeActivity
import com.jobamax.appjobamax.model.JobSeeker
import com.jobamax.appjobamax.model.UserTempInfo
import com.jobamax.appjobamax.preference.*
import com.jobamax.appjobamax.util.*
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
        val query = ParseQuery.getQuery<ParseObject>(ParseTableName.JOB_SEEKER.value)
        query.whereContains(ParseTableFields.EMAIL.value, user.email)
        query.getFirstInBackground { result, e ->
            progressHud.dismiss()
            when{
                result != null -> {
                    BasicDialog(this, "User is already registered with this email.", true){callback()}.show()
                }
                else -> {
                    navController.navigate(R.id.valuePrivacyFragment, bundleOf( ARG_USER to user))
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
                isEmailAlreadyRegistered(user){
                    getUserLogin(user)
                }
            }
            LoginType.LINKEDIN.type ->{
                isEmailAlreadyRegistered(user){
                    getUserLogin(user)
                }
            }
            LoginType.FACEBOOK.type ->{
                isEmailAlreadyRegistered(user){
                    getUserLogin(user)
                }
            }
        }
    }

    private fun getUserLogin(user: UserTempInfo) {
        progressHud.show()
        val query = ParseQuery.getQuery<ParseObject>(ParseTableName.JOB_SEEKER.value)
        query.whereEqualTo(ParseTableFields.EMAIL.value, user.email)
        if (user.loginType == LoginType.EMAIL.type){
            query.whereEqualTo(ParseTableFields.LOGIN_TYPE.value, user.loginType)
            query.whereEqualTo(ParseTableFields.PASSWORD.value, AESCrypt.encrypt(user.password))
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
                    startActivity(Intent(this, JobSeekerHomeActivity::class.java))
                    finishAffinity()
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