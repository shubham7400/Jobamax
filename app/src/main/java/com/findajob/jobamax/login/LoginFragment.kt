package com.findajob.jobamax.login

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.findajob.jobamax.R
import com.findajob.jobamax.base.BaseFragmentMain
import com.findajob.jobamax.databinding.FragmentLoginBinding
import com.findajob.jobamax.model.User
import com.findajob.jobamax.util.*
import com.facebook.AccessToken
import com.facebook.GraphRequest
import com.findajob.jobamax.dialog.ChangePasswordDialog
import com.findajob.jobamax.enums.LoginType
import com.findajob.jobamax.enums.ParseTableFields
import com.findajob.jobamax.enums.ParseTableName
import com.findajob.jobamax.jobseeker.home.JobSeekerHomeActivity
import com.findajob.jobamax.model.JobSeeker
import com.findajob.jobamax.preference.*
 import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import com.google.gson.Gson
import com.kusu.linkedinlogin.Linkedin
import com.kusu.linkedinlogin.LinkedinLoginListener
import com.kusu.linkedinlogin.model.SocialUser
import com.parse.*
import com.parse.facebook.ParseFacebookUtils
import kotlinx.android.synthetic.main.fragment_login.*
import org.json.JSONException
import org.json.JSONObject
import java.util.*
import kotlin.collections.ArrayList

class LoginFragment : BaseFragmentMain<FragmentLoginBinding>(), LoginInterface {

    private lateinit var viewModel: LoginViewModel
    private lateinit var mGoogleSignInClient: GoogleSignInClient
    private lateinit var navController: NavController
    private var linkedInFlag = false

    override val layoutRes: Int get() = R.layout.fragment_login

    override fun onCreated(savedInstance: Bundle?) {
        configureViewModel()
        initViews()
    }

    override fun getViewModel(): ViewModel = viewModel

    private fun configureViewModel() {
        viewModel = ViewModelProvider(requireActivity())[LoginViewModel::class.java]
    }

    private fun initViews() {
        binding.handler = this
        navController = findNavController()

        binding.ivBackButton.setOnClickListener {
            requireActivity().onBackPressed()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onResume() {
        super.onResume()
        progressHud.dismiss()
        if (linkedInFlag) {
            linkedInFlag = false
            progressHud.dismiss()
        }
        if (viewModel.roleType == ROLE_RECRUITER)
            socialMediaLayout.visibility = View.GONE
        else socialMediaLayout.visibility = View.VISIBLE
    }

    override fun onForgotPasswordClicked() {
        val email = emailField.text.toString()
        if (!email.isValidEmail()){
            toast("Enter valid email!")
        }else{
            progressHud.show()
            val params = HashMap<String, Any>()
            params["email"] = emailField.text.toString()
            when (viewModel.roleType) {
                ROLE_JOB_SEEKER -> {
                    params["userType"] = 2
                }
                ROLE_RECRUITER -> {
                    params["userType"] = 1
                }
            }
            viewModel.changePassword(params,
                {
                    progressHud.dismiss()
                    val res = Gson().toJson(it)
                    val mainObject = JSONObject(res)
                    val message = mainObject.getString("msg")
                    ChangePasswordDialog(requireActivity(),message, email).show()
                },
                {
                    progressHud.dismiss()
                    ChangePasswordDialog(requireActivity(),it.message.toString(), email).show()
                }
            )
        }
    }

    override fun onEyeClicked() {
        if (binding.passwordField.transformationMethod.equals(PasswordTransformationMethod.getInstance())) {
            binding.apply {
                showPasswordButton.setImageResource(R.drawable.ic_eye)
                passwordField.transformationMethod = HideReturnsTransformationMethod.getInstance()
                passwordField.setSelection(passwordField.length())
            }
        } else {
            binding.apply {
                showPasswordButton.setImageResource(R.drawable.ic_eye_off)
                passwordField.transformationMethod = PasswordTransformationMethod.getInstance()
                passwordField.setSelection(passwordField.length())
            }

        }
    }

    private fun handleSignInResult(completedTask: Task<GoogleSignInAccount>) {
        try {
            val account: GoogleSignInAccount? = completedTask.getResult(ApiException::class.java)
            if (account != null) {
                val user = User()
                user.email = account.email ?: ""
                user.loginType = GOOGLE_LOGIN_TYPE
                val nameArray = account.displayName?.split(" ")?.toList() ?: listOf()
                if (nameArray.isNotEmpty())
                    user.firstName = nameArray.first().capitalize(Locale.ROOT)
                if (nameArray.size > 1)
                    user.lastName = nameArray.last().capitalize(Locale.ROOT)
            }
        } catch (e: ApiException) {
            progressHud.dismiss()
            log("signInResult:failed code=" + e.statusCode)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        progressHud.dismiss()
        ParseFacebookUtils.onActivityResult(requestCode, resultCode, data)
    }

    override fun onFacebookLoginClicked() {
        val permissions: Collection<String> = listOf("public_profile", "email")
        progressHud.show()
        ParseFacebookUtils.logInWithReadPermissionsInBackground(this, permissions) { user, error ->
            try {
                val request = GraphRequest.newMeRequest(AccessToken.getCurrentAccessToken()) { data, response ->
                    val userId = data.getString("id")
                    requireContext().setUserId(userId)
                    requireContext().setLoginType(LoginType.facebook.toString())
                    requireContext().setUserType(2)
                    val query = ParseQuery.getQuery<ParseObject>(ParseTableName.JobSeeker.toString())
                    query.whereEqualTo(ParseTableFields.jobSeekerId.toString(),userId)
                    query.getFirstInBackground { result, e ->
                        when{
                            result != null -> {
                                // send user to home screen and save his credential
                                val jobSeeker = JobSeeker(result)
                                requireContext().setUserId(jobSeeker.jobSeekerId)
                                requireContext().setLoginType(jobSeeker.loginType)
                                requireContext().setUserType(2)
                                requireContext().setEmail(jobSeeker.email)
                                requireContext().setLoggedIn(true)
                                startActivity(Intent(requireContext(),JobSeekerHomeActivity::class.java ))
                            }
                            else -> {
                                // create new user from here
                                navController.navigate(R.id.valuePrivacyFragment)
                            }
                        }
                    }

                }
                val parameters = Bundle()
                parameters.putString("fields", "name, email")
                request.parameters = parameters
                request.executeAsync()
            }catch (e: Exception){
                toast(e.message.toString())
            }
        }


        /*//TODO: provide data deletion link in the facebook dev console
        val permissions: Collection<String> = listOf("public_profile", "email")
        progressHud.show()
        ParseFacebookUtils.logInWithReadPermissionsInBackground(this, permissions) { user, error ->
            try {
                progressHud.dismiss()
                // Check for error first
                if (error != null) {
                    log("Could not login with facebook", error)
                    toast(error.message ?: "Something went wrong.")
                    return@logInWithReadPermissionsInBackground
                }
                // If parse return null object
                if (user == null) {
                    toast("Login cancelled")
                    return@logInWithReadPermissionsInBackground
                }
                if (user.isNew) {
                    log("User signed up and logged in through Facebook!")
                }
                // Get user detail from Facebook


                *//*getUserDetailFromFB(
                    { user1, parseObject ->
                        (requireActivity() as LoginActivity).checkForExistingUser(user1)
                        parseObject.saveInBackground { e ->
                            if (e != null) {
                                log("saveInBackground() Error: " + e.message, e)
                            }
                        }
                    },
                    { t ->
                        log("Something went wrong with facebook login", t)
                        toast(t.localizedMessage ?: "")
                    }
                )*//*
            } catch (e: Exception) {
                log("Something went wrong with facebook login", e)
                progressHud.dismiss()
            }
        }*/
    }


    // Use ActivityResultContracts google login
    private val googleLoginActivityResult =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            progressHud.dismiss()
            if (it == null) {
                toast("SignInContract result null")
            }
            it?.let {
                if (it.resultCode == Activity.RESULT_OK) {
                    val task = GoogleSignIn.getSignedInAccountFromIntent(it.data)
                    handleSignInResult(task)
                }
            }
        }

    override fun onGoogleLoginClicked() {
        progressHud.show()
        log("onGoogleLoginClicked()")
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken("1"/*getString(R.string.default_web_client_id)*/)
            .requestEmail()
            .build()

        mGoogleSignInClient = GoogleSignIn.getClient(requireActivity(), gso)
        val intent = mGoogleSignInClient.signInIntent
        googleLoginActivityResult.launch(intent)
//        startActivityForResult(intent, GOOGLE_SIGN_IN_REQUEST_CODE)
    }

    override fun onLinkedInLoginClicked() {
        try {
            progressHud.show()
            linkedInFlag = true
            // Any access/client secret/token must be declared in the string.xml resources
            Linkedin.initialize(
                context = requireContext(),
                clientId = getString(R.string.linked_in_client_id),
                clientSecret = getString(R.string.linked_in_client_secret),
                redirectUri = getString(R.string.linked_in_redirect_uri),
                state = getString(R.string.linked_in_state),
                scopes = try {
                    (resources.getStringArray(R.array.linked_in_access_scopes).toList())
                } catch (e: Exception) {
                    e.printStackTrace()
                    ArrayList()
                }
            )
            Linkedin.login(requireContext(), object : LinkedinLoginListener {
                override fun failedLinkedinLogin(error: String) {
                    progressHud.dismiss()
                    log("failedLinkedInLogin: $error")
                }

                override fun successLinkedInLogin(socialUser: SocialUser) {
                    try {
                        val userId = socialUser.socialId.toString()
                        requireContext().setUserId(userId)
                        requireContext().setLoginType(LoginType.linkedin.toString())
                        requireContext().setUserType(2)
                        val query = ParseQuery.getQuery<ParseObject>(ParseTableName.JobSeeker.toString())
                        query.whereEqualTo(ParseTableFields.jobSeekerId.toString(),userId)
                        query.getFirstInBackground { result, e ->
                            when{
                                result != null -> {
                                    // send user to home screen and save his credential
                                    val jobSeeker = JobSeeker(result)
                                    requireContext().setUserId(jobSeeker.jobSeekerId)
                                    requireContext().setLoginType(jobSeeker.loginType)
                                    requireContext().setUserType(2)
                                    requireContext().setEmail(jobSeeker.email)
                                    requireContext().setLoggedIn(true)
                                    startActivity(Intent(requireContext(),JobSeekerHomeActivity::class.java ))
                                }
                                else -> {
                                    // create new user from here
                                    navController.navigate(R.id.valuePrivacyFragment)
                                }
                            }
                        }

                        /* log("sourceial ${socialUser}")
                         progressHud.show()
                         val user = User()
                         user.email = socialUser.email ?: ""
                         user.firstName = socialUser.firstName?.capitalize(Locale.ROOT) ?: ""
                         user.lastName = socialUser.lastName?.capitalize(Locale.ROOT) ?: ""
                         user.profilePicUrl = socialUser.profilePicture ?: ""
                         user.loginType = LINKEDIN_LOGIN_TYPE
                         progressHud.dismiss()
                         (requireActivity() as LoginActivity).checkForExistingUser(user)*/
                    } catch (e: Exception) {
                        e.printStackTrace()
                        progressHud.dismiss()
                    }
                }
            })
        } catch (e: Exception) {
            e.printStackTrace()
            progressHud.dismiss()
        }
    }

    override fun onEmailLoginClicked() {
        val email = emailField.text.toString().trim()
        val password = passwordField.text.toString().trim()

        if (!email.isValidEmail())
            toast("Enter valid email!")
        else if (password.length < 7) {
            toast("Password should have at least 7 characters")
        } else {
            if (requireContext().getUserType() == 2){
                (requireActivity() as LoginActivity).loginSeeker(email, password)
            }else if (requireContext().getUserType() == 1){
                (requireActivity() as LoginActivity).loginRecruiter(email, password)
            }
        }

    }

    override fun onRegisterClicked() {
        navController.navigate(R.id.action_loginFragment_to_registerFragment)
    }

    /**
     * Extract facebook user information
     *
     * @param onSuccess, success callback return [User] and [ParseObject]
     * @param onError, error callback return [Throwable]
     */
    private fun getUserDetailFromFB(onSuccess: (user: User, parseObject: ParseObject) -> Unit, onError: (Throwable) -> Unit) {
        try {
            val request = GraphRequest.newMeRequest(AccessToken.getCurrentAccessToken()) { data, response ->
                    try {
                        val u = ParseUser.getCurrentUser()
                        try {
                            u.username = data.getString("name")
                        } catch (e: JSONException) {
                            e.printStackTrace()
                        }

                        try {
                            u.email = data.getString("email")
                        } catch (e: JSONException) {
                            e.printStackTrace()
                        }
                        val user = User()
                        user.email = u.email ?: ""
                        user.loginType = FACEBOOK_LOGIN_TYPE
                        onSuccess.invoke(user, u)
                    } catch (e: Exception) {
                        e.printStackTrace()
                        onError.invoke(e)
                    }
                }
            val parameters = Bundle()
            parameters.putString("fields", "name, email")
            request.parameters = parameters
            request.executeAsync()
        } catch (e: Exception) {
            e.printStackTrace()
            onError.invoke(e)
        }
    }


}