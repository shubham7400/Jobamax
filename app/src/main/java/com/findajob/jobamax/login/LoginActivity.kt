package com.findajob.jobamax.login

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.findajob.jobamax.R
import com.findajob.jobamax.base.BaseActivityMain
import com.findajob.jobamax.base.logThis
import com.findajob.jobamax.data.remote.AuthRepository
import com.findajob.jobamax.data.remote.NoInternetException
import com.findajob.jobamax.databinding.ActivityLoginBinding
import com.findajob.jobamax.dialog.multiChoice.BasicDialog
import com.findajob.jobamax.domain.CheckExistingJobSeekerUseCase
import com.findajob.jobamax.domain.CheckExistingRecruiterUseCase
import com.findajob.jobamax.enums.LoginType
import com.findajob.jobamax.enums.ParseTableFields
import com.findajob.jobamax.enums.ParseTableName
import com.findajob.jobamax.extensions.observe
import com.findajob.jobamax.jobseeker.home.JobSeekerHomeActivity
import com.findajob.jobamax.location.SelectLocationActivity
import com.findajob.jobamax.model.JobSeeker
import com.findajob.jobamax.model.Recruiter
import com.findajob.jobamax.model.User
import com.findajob.jobamax.preference.*
import com.findajob.jobamax.recruiter.home.RecruiterHomeActivity
import com.findajob.jobamax.util.*
import com.google.firebase.messaging.FirebaseMessaging
import com.parse.ParseObject
import com.parse.ParseQuery
import com.parse.ParseUser


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
        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java).apply {
            AuthRepository.Factory.getInstance(this@LoginActivity).either(
                {
                    toast(it.localizedMessage ?: "")
                },
                {
                    /*
                    Manually instantiate required component for view model.
                    It should be done via DI.
                     */
                    authRepository = it
                    checkExistingRecruiterUseCase = CheckExistingRecruiterUseCase(authRepository)
                    checkExistingJobSeekerUseCase = CheckExistingJobSeekerUseCase(authRepository)
                    logThis(checkExistingRecruiterUseCase.toString())
                }
            )
        }
    }


    fun checkForExistingUser(user: User) {
        /*
        Note: Removed the live data mechanism with callback (Higher Order Function)
        When callback invoked, post on Main thread with lifecycleScope
         */
        progressHud.show()
        viewModel.getCurrentUser(user,
            { existingUser ->
                progressHud.dismiss()
                lifecycleScope.launchWhenResumed {
                    user.id = if (viewModel.roleType == ROLE_JOB_SEEKER)
                        existingUser["jobSeekerId"].toString()
                    else existingUser["recruiterId"].toString()
                    navHome(user, false)
                }
            },
            {
                progressHud.dismiss()
                lifecycleScope.launchWhenResumed {
                    when (it) {
                        is NoInternetException -> {
                            toast(NoInternetException.MSG)
                        }
                        is ParseQueryEmptyThrowable -> {
                            saveDetails(user)
                        }
                        else -> {
                            toast(it.localizedMessage ?: "")
                        }
                    }
                }
            })
    }

    private fun navHome(user: User, isRegister: Boolean) {
        try {
            log("Logging in...")
            setLoggedIn(true)
            saveLocally(user, viewModel.roleType)
            FirebaseMessaging.getInstance().subscribeToTopic("/topics/" + user.id)
            if (isRegister) {
                navController.navigate(R.id.valuePrivacyFragment)
            } else {
                if (checkLocationPermission()) {
                    startActivity(
                        Intent(
                            this,
                            if (getRole() == ROLE_JOB_SEEKER)
                                JobSeekerHomeActivity::class.java
                            else RecruiterHomeActivity::class.java
                        )
                    )
                    finishAffinity()
                } else navController.navigate(
                    R.id.locationPermissionFragment,
                    bundleOf(ARG_ACTION to ACTION_LOGIN)
                )
            }
        }
        catch (e : Exception){
            e.printStackTrace()
            errorToast(e)
        }
    }

    private fun register(email: String, password: String) {

        /*isEmailAlreadyRegistered(email, password)
        progressHud.show()
        val parseUser = ParseUser()
        parseUser.email = email
        parseUser.setPassword(password)
        parseUser.username = email

        parseUser.signUpInBackground { it ->
            progressHud.dismiss()
            if (it == null) {
                val user = User()
                user.email = email
                user.loginType = EMAIL_LOGIN_TYPE
                user.userId = parseUser.objectId

                parseUser.objectId?.let {
                    setUserObjectId(it)
                    setUserFullName(parseUser.username)
                    FirebaseMessaging.getInstance().subscribeToTopic("/topics/$it")
                }

                saveDetails(user)
            } else errorToast(it)
        }*/
    }

    fun isEmailAlreadyRegistered(email: String, password: String) {
        progressHud.show()
        val query = if (getUserType() == 2){
            ParseQuery.getQuery<ParseObject>(ParseTableName.JobSeeker.toString())
        }else{
            ParseQuery.getQuery<ParseObject>(ParseTableName.Recruiter.toString())
        }
        query.whereContains(ParseTableFields.email.toString(), email)
        query.whereContains(ParseTableFields.loginType.toString(), LoginType.email.toString())
        query.getFirstInBackground { result, e ->
            progressHud.dismiss()
            when{
                result != null -> {
                    BasicDialog(this, "User is already registered with this email."){}.show()
                }
                else -> {
                    setEmail(email)
                    setPassword(password)
                    setLoginType(LoginType.email.toString())
                    setRole(viewModel.roleType)
                    navController.navigate(R.id.valuePrivacyFragment)
                }
            }
        }
    }

    fun loginSeeker(email: String, password: String) {
        progressHud.show()
        val query = ParseQuery.getQuery<ParseObject>(ParseTableName.JobSeeker.toString())
        query.whereEqualTo(ParseTableFields.email.toString(), email)
        query.whereEqualTo(ParseTableFields.loginType.toString(), LoginType.email.toString())
        query.whereEqualTo(ParseTableFields.password.toString(), AESCrypt.encrypt(password)  )
        query.getFirstInBackground { result, e ->
            progressHud.dismiss()
            if (e == null && result != null){
                if(result.getBoolean("emailVerified")){
                    val jobSeeker = JobSeeker(result)
                    setUserId(jobSeeker.jobSeekerId)
                    setPhoneNumber(jobSeeker.phoneNumber)
                    setLoginType(jobSeeker.loginType)
                    setLoggedIn(true)
                    if (checkLocationPermission()) {
                        startActivity(Intent(this, JobSeekerHomeActivity::class.java))
                        finishAffinity()
                    } else navController.navigate(
                        R.id.locationPermissionFragment,
                        bundleOf(ARG_ACTION to ACTION_LOGIN)
                    )
                }else{
                    toast("Please verify account clicking on sent email at the time of registration.")
                }
            }else{
                toast("error: ${e.message.toString()}")
            }
        }

     /*   progressHud.show()
        val parseUser = ParseUser()
        parseUser.email = email
        parseUser.setPassword(password)
        parseUser.username = email

        ParseUser.logInInBackground(email, password) { u, e ->
            progressHud.dismiss()
            if (e == null) {
                val user = User()
                user.email = email
                user.loginType = EMAIL_LOGIN_TYPE

                u?.objectId?.let {
                    setUserObjectId(it)
                    setUserFullName(parseUser.username)
                    FirebaseMessaging.getInstance().subscribeToTopic("/topics/$it")
                }
                checkForExistingUser(user)
            } else errorToast(e)
        }*/
    }

    fun loginRecruiter(email: String, password: String) {
        progressHud.show()
        val query = ParseQuery.getQuery<ParseObject>(ParseTableName.Recruiter.toString())
        query.whereEqualTo(ParseTableFields.email.toString(), email)
        query.whereEqualTo(ParseTableFields.loginType.toString(), LoginType.email.toString())
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
                        startActivity(Intent(this, RecruiterHomeActivity::class.java))
                        finishAffinity()
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

    private fun saveDetails(user: User) {
        progressHud.show()
        viewModel.saveUserDetails(user)

        observe(viewModel.detailedUser) {
            it?.let {
                progressHud.dismiss()
                navHome(user, true)
            }
        }
        observe(viewModel.errorMessage) {
            it?.let { em ->
                progressHud.dismiss()
                toast(em)
            }
        }
    }

    fun navLocationPicker() {
        val intent = Intent(this, SelectLocationActivity::class.java)
        startActivityForResult(intent, AUTOCOMPLETE_REQUEST_CODE)
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