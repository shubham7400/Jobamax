package com.jobamax.appjobamax.login

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.navigation.fragment.findNavController
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import com.jobamax.appjobamax.R
import com.jobamax.appjobamax.databinding.FragmentLoginRegistrationOptionBinding
import com.jobamax.appjobamax.enums.LoginType
import com.jobamax.appjobamax.extensions.checkForPermissions
import com.jobamax.appjobamax.extensions.log
import com.jobamax.appjobamax.extensions.toast
import com.jobamax.appjobamax.model.UserTempInfo
import com.jobamax.appjobamax.util.ARG_USER
import com.jobamax.appjobamax.util.GOOGLE_LOGIN_TYPE
import com.jobamax.appjobamax.util.permissions
import com.realtimecoding.linkedinmanager.events.LinkedInManagerResponse
import com.realtimecoding.linkedinmanager.helper.LinkedInRequestManager
import com.realtimecoding.linkedinmanager.models.LinkedInAccessToken
import com.realtimecoding.linkedinmanager.models.LinkedInEmailAddress
import com.realtimecoding.linkedinmanager.models.LinkedInUserProfile
import java.util.*


class LoginRegistrationOptionFragment : Fragment(), LinkedInManagerResponse {
    lateinit var binding: FragmentLoginRegistrationOptionBinding

    var user: UserTempInfo? = null

    private lateinit var mGoogleSignInClient: GoogleSignInClient
    lateinit var linkedInRequestManager : LinkedInRequestManager

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentLoginRegistrationOptionBinding.inflate(inflater, container, false)
        configureUi()
        return binding.root
    }

    private fun configureUi() {
        setClickListeners()
        linkedInRequestManager = LinkedInRequestManager(requireActivity(), this, resources.getString(R.string.linked_in_client_id), resources.getString(R.string.linked_in_client_secret), resources.getString(R.string.linked_in_redirect_url), false)
        user = requireArguments().getSerializable(ARG_USER) as UserTempInfo?
    }

    private fun setClickListeners() {
        binding.btnCreateAccount.setOnClickListener {
            user?.loginType  = LoginType.EMAIL.type
            val args = Bundle()
            args.putSerializable(ARG_USER, user)
            findNavController().navigate(  R.id.action_loginRegistrationOptionFragment_to_userLocationPermissionFragment, args)
        }
        binding.btnConnectMe.setOnClickListener {
            val args = Bundle()
            args.putSerializable(ARG_USER, user)
            findNavController().navigate(  R.id.action_loginRegistrationOptionFragment_to_userLoginFragment, args)
        }

        binding.btnGoogleLogin.setOnClickListener {
            if (checkForPermissions(permissions)) {
                val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build()
                mGoogleSignInClient = GoogleSignIn.getClient(requireActivity(), gso)
                val intent = mGoogleSignInClient.signInIntent
                googleLoginActivityResult.launch(intent)
            }
        }
        binding.btnLinkedInLogin.setOnClickListener {
            if (checkForPermissions(permissions)) {
                linkedInRequestManager.showAuthenticateView(LinkedInRequestManager.MODE_EMAIL_ADDRESS_ONLY )
            }
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
                user?.also {
                    it.email = account.email ?: ""
                    it.loginType = GOOGLE_LOGIN_TYPE
                    val nameArray = account.displayName?.split(" ")?.toList() ?: listOf()
                    if (nameArray.isNotEmpty())
                        it.firstName = nameArray.first()
                            .replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.ROOT) else it.toString() }
                    if (nameArray.size > 1)
                        it.lastName = nameArray.last()
                            .replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.ROOT) else it.toString() }
                    user!!.loginType = LoginType.GOOGLE.type
                }
                val args = Bundle()
                args.putSerializable(ARG_USER, user)
                findNavController().navigate(R.id.action_loginRegistrationOptionFragment_to_userLocationPermissionFragment, args)
            }
        } catch (e: ApiException) {
            log("signInResult:failed code=" + e.statusCode)
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
        user?.also {
            it.email = linkedInEmailAddress?.emailAddress ?: ""
            it.loginType = LoginType.LINKEDIN.type
        }
        val args = Bundle()
        args.putSerializable(ARG_USER, user)
        findNavController().navigate(R.id.action_loginRegistrationOptionFragment_to_userLocationPermissionFragment, args)
        linkedInRequestManager.dismissAuthenticateView()
    }
    override fun onGetProfileDataFailed() {
        log("onGetProfileDataFailed")
    }
    override fun onGetProfileDataSuccess(linkedInUserProfile: LinkedInUserProfile?) {
        log("onGetProfileDataSuccess ${linkedInUserProfile?.imageURL} ${linkedInUserProfile?.userName}")
    }

}