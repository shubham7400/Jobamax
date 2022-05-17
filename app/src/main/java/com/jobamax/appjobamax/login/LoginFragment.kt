package com.jobamax.appjobamax.login

import android.app.Activity
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.jobamax.appjobamax.R
import com.jobamax.appjobamax.base.BaseFragmentMain
import com.jobamax.appjobamax.databinding.FragmentLoginBinding
import com.jobamax.appjobamax.dialog.ChangePasswordDialog
import com.jobamax.appjobamax.dialog.MessageDialog
import com.jobamax.appjobamax.enums.LoginType
 import com.jobamax.appjobamax.model.UserTempInfo
import com.jobamax.appjobamax.util.*
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import com.google.gson.Gson
import com.realtimecoding.linkedinmanager.events.LinkedInManagerResponse
import com.realtimecoding.linkedinmanager.helper.LinkedInRequestManager
import com.realtimecoding.linkedinmanager.models.LinkedInAccessToken
import com.realtimecoding.linkedinmanager.models.LinkedInEmailAddress
import com.realtimecoding.linkedinmanager.models.LinkedInUserProfile
import kotlinx.android.synthetic.main.fragment_login.*
import org.json.JSONObject
import java.util.*


class LoginFragment : BaseFragmentMain<FragmentLoginBinding>(), LoginInterface, LinkedInManagerResponse {

    private lateinit var viewModel: LoginViewModel
    private lateinit var mGoogleSignInClient: GoogleSignInClient
    private lateinit var navController: NavController

    lateinit var linkedInRequestManager : LinkedInRequestManager


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
        

        if (checkForPermissions(permissions)) {
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        linkedInRequestManager = LinkedInRequestManager(requireActivity(), this, resources.getString(R.string.linked_in_client_id), resources.getString(R.string.linked_in_client_secret), resources.getString(R.string.linked_in_redirect_url), false)
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onForgotPasswordClicked() {
        val email = emailField.text.toString()
        if (!email.isValidEmail()){
            MessageDialog(requireActivity(), "Email address can not be empty."){}.show()
        }else{
            progressHud.show()
            val params = HashMap<String, Any>()
            params["email"] = emailField.text.toString()
            params["userType"] = JOB_SEEKER_TYPE
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



    override fun onFacebookLoginClicked() {

    }


    override fun onGoogleLoginClicked() {
        if (checkForPermissions(permissions)) {
            val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build()
            mGoogleSignInClient = GoogleSignIn.getClient(requireActivity(), gso)
            val intent = mGoogleSignInClient.signInIntent
            googleLoginActivityResult.launch(intent)
        }
    }
    private val googleLoginActivityResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
        if (it == null) {
            toast("SignInContract result null")
        }
        it?.let {
            if (it.resultCode == Activity.RESULT_OK) {
                val task = GoogleSignIn.getSignedInAccountFromIntent(it.data)
                handleSignInResult(task)
            }else if (it.resultCode == Activity.RESULT_CANCELED){
                log("googleLoginResultError error.")
            }
        }
    }
    private fun handleSignInResult(completedTask: Task<GoogleSignInAccount>) {
        try {
            val account: GoogleSignInAccount? = completedTask.getResult(ApiException::class.java)
            if (account != null) {
                val user = UserTempInfo().also {
                    it.email = account.email ?: ""
                    it.loginType = GOOGLE_LOGIN_TYPE
                    val nameArray = account.displayName?.split(" ")?.toList() ?: listOf()
                    if (nameArray.isNotEmpty())
                        it.firstName = nameArray.first().capitalize(Locale.ROOT)
                    if (nameArray.size > 1)
                        it.lastName = nameArray.last().capitalize(Locale.ROOT)
                }
                (requireActivity() as LoginActivity).loginSeeker(user)
            }
        } catch (e: ApiException) {
            progressHud.dismiss()
            log("signInResult:failed code=" + e.statusCode)
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
            val user = UserTempInfo().also {
                it.email = email
                it.loginType = LoginType.EMAIL.type
                it.password = password
            }
            (requireActivity() as LoginActivity).loginSeeker(user)
        }

    }

    override fun onRegisterClicked() {
        navController.navigate(R.id.action_loginFragment_to_registerFragment)
    }


    override fun onLinkedInLoginClicked() {
        if (checkForPermissions(permissions)) {
            linkedInRequestManager.showAuthenticateView(LinkedInRequestManager.MODE_EMAIL_ADDRESS_ONLY )
        }
    }

    override fun onGetAccessTokenFailed() {
        log("onGetAccessTokenFailed")
    }
    override fun onGetAccessTokenSuccess(linkedInAccessToken: LinkedInAccessToken?) {
        log("onGetAccessTokenSuccess")
    }
    override fun onGetCodeFailed() {
        log("onGetCodeFailed")
    }
    override fun onGetCodeSuccess(code: String?) {
        log("onGetCodeSuccess")
    }
    override fun onGetEmailAddressFailed() {
        log("onGetEmailAddressFailed")
    }
    override fun onGetEmailAddressSuccess(linkedInEmailAddress: LinkedInEmailAddress?) {
        log("onGetEmailAddressSuccess ${linkedInEmailAddress?.emailAddress}")
        val user = UserTempInfo().also {
            it.email = linkedInEmailAddress?.emailAddress ?: ""
            it.loginType = LoginType.LINKEDIN.type
        }
        (requireActivity() as LoginActivity).loginSeeker(user)
        linkedInRequestManager.dismissAuthenticateView()
    }
    override fun onGetProfileDataFailed() {
        log("onGetProfileDataFailed")
    }
    override fun onGetProfileDataSuccess(linkedInUserProfile: LinkedInUserProfile?) {
        log("onGetProfileDataSuccess ${linkedInUserProfile?.imageURL} ${linkedInUserProfile?.userName}")
    }
}