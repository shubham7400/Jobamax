package com.jobamax.appjobamax.login

import android.app.Activity
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.*
import androidx.activity.result.contract.ActivityResultContracts
import androidx.navigation.fragment.findNavController
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import com.jobamax.appjobamax.R
import com.jobamax.appjobamax.base.BaseFragment
import com.jobamax.appjobamax.databinding.FragmentLoginRegistrationOptionBinding
import com.jobamax.appjobamax.dialog.BasicDialog
import com.jobamax.appjobamax.enums.LoginType
import com.jobamax.appjobamax.enums.ParseTableFields
import com.jobamax.appjobamax.enums.ParseTableName
import com.jobamax.appjobamax.extensions.checkForPermissions
import com.jobamax.appjobamax.extensions.log
import com.jobamax.appjobamax.extensions.toast
import com.jobamax.appjobamax.jobseeker.JobSeekerHomeActivity
import com.jobamax.appjobamax.jobseeker.build_profile.BuildProfileActivity
import com.jobamax.appjobamax.model.JobSeeker
import com.jobamax.appjobamax.model.UserTempInfo
import com.jobamax.appjobamax.preference.*
import com.jobamax.appjobamax.util.ARG_USER
import com.jobamax.appjobamax.util.permissions
import com.parse.ParseObject
import com.parse.ParseQuery
import com.pushwoosh.Pushwoosh
import com.realtimecoding.linkedinmanager.events.LinkedInManagerResponse
import com.realtimecoding.linkedinmanager.helper.LinkedInRequestManager
import com.realtimecoding.linkedinmanager.models.LinkedInAccessToken
import com.realtimecoding.linkedinmanager.models.LinkedInEmailAddress
import com.realtimecoding.linkedinmanager.models.LinkedInUserProfile
import java.util.*


class LoginRegistrationOptionFragment : BaseFragment(), LinkedInManagerResponse {
    lateinit var binding: FragmentLoginRegistrationOptionBinding

    var user: UserTempInfo? = null

    private lateinit var mGoogleSignInClient: GoogleSignInClient
    lateinit var linkedInRequestManager : LinkedInRequestManager

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentLoginRegistrationOptionBinding.inflate(inflater, container, false)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val window: Window = requireActivity().window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = resources.getColor(R.color.colorPrimary, null)
        }
        configureUi()
        return binding.root
    }

    private fun configureUi() {
        setClickListeners()
        linkedInRequestManager = LinkedInRequestManager(requireActivity(), this, resources.getString(R.string.linked_in_client_id), resources.getString(R.string.linked_in_client_secret), resources.getString(R.string.linked_in_redirect_url), false)
        linkedInRequestManager.logout()
        user = requireArguments().getSerializable(ARG_USER) as UserTempInfo?
    }

    private fun setClickListeners() {
        binding.btnCreateAccount.setOnClickListener {
            user?.loginType  = LoginType.EMAIL.type
            val args = Bundle()
            args.putSerializable(ARG_USER, user)
            findNavController().navigate(  R.id.action_loginRegistrationOptionFragment_to_privacyPolicyFragment, args)
        }
        binding.btnConnectMe.setOnClickListener {
            val args = Bundle()
            args.putSerializable(ARG_USER, user)
            findNavController().navigate(  R.id.action_loginRegistrationOptionFragment_to_userLoginFragment, args)
        }
        binding.ivBackButton.setOnClickListener { requireActivity().onBackPressed() }

        binding.btnGoogleLogin.setOnClickListener {
            if (checkForPermissions(permissions)) {
                val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build()
                mGoogleSignInClient = GoogleSignIn.getClient(requireActivity(), gso)
                mGoogleSignInClient.signOut().addOnCompleteListener {
                    val intent = mGoogleSignInClient.signInIntent
                    googleLoginActivityResult.launch(intent)
                }
            }
        }
        binding.btnLinkedInLogin.setOnClickListener {
            if (checkForPermissions(permissions)) {
                linkedInRequestManager.showAuthenticateView(LinkedInRequestManager.MODE_BOTH_OPTIONS  )
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
                user?.let {
                    it.email = account.email ?: ""
                    it.userId = account.id ?: ""
                    it.profilePicUrl = account.photoUrl?.toString() ?: ""
                    println("fldsfkl ${it.profilePicUrl}")
                    it.loginType = LoginType.GOOGLE.type
                    val nameArray = account.displayName?.split(" ")?.toList() ?: listOf()
                    if (nameArray.isNotEmpty())
                        it.firstName = nameArray.first().replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.ROOT) else it.toString() }
                    if (nameArray.size > 1)
                        it.lastName = nameArray.last().replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.ROOT) else it.toString() }
                    user!!.loginType = LoginType.GOOGLE.type
                    if (it.email.isNotEmpty()){
                        checkAccountWithEmail()
                    }else{
                        toast("Something Went Wrong.")
                    }
                }
            }
        } catch (e: ApiException) {
            log("signInResult:failed code=" + e.statusCode)
        }
    }

    private fun checkAccountWithEmail() {
        isEmailAlreadyRegistered { isExist ->
            if (isExist) {
                getUserLogin()
            } else {
                val args = Bundle()
                args.putSerializable(ARG_USER, user)
                findNavController().navigate(
                    R.id.action_loginRegistrationOptionFragment_to_privacyPolicyFragment,
                    args
                )
            }
        }
    }

    private fun getUserLogin() {
        val query = ParseQuery.getQuery<ParseObject>(ParseTableName.JOB_SEEKER.value)
        query.whereEqualTo(ParseTableFields.EMAIL.value, user!!.email)
        progressHud.show()
        query.getFirstInBackground { result, e ->
            progressHud.dismiss()
            if (e == null && result != null) {
                val jobSeeker = JobSeeker(result)
                requireContext().setUserId(jobSeeker.jobSeekerId)
                requireContext().setLoginType(jobSeeker.loginType)
                requireContext().setLoggedIn(true)
                requireContext().setUserType(2)
                Pushwoosh.getInstance().setUserId(jobSeeker.jobSeekerId)
                if (!jobSeeker.seenOnboarding){
                    requireContext().setSeenOnBoarding(false)
                    startActivity(Intent(requireContext(), BuildProfileActivity::class.java))
                    requireActivity().finish()
                }else{
                    requireContext().setSeenOnBoarding(true)
                    startActivity(Intent(requireContext(), JobSeekerHomeActivity::class.java))
                    requireActivity().finish()
                }

            } else {
                log("error: ${e.message.toString()}")
                BasicDialog(requireActivity(), "E-mail invalide"){}.show()
            }
        }
    }

    private fun isEmailAlreadyRegistered(callback : (Boolean) -> Unit) {
        val query = ParseQuery.getQuery<ParseObject>(ParseTableName.JOB_SEEKER.value)
        query.whereContains(ParseTableFields.EMAIL.value, user!!.email)
        progressHud.show()
        query.getFirstInBackground { result, e ->
            progressHud.dismiss()
            when{
                result != null -> {
                    callback(true)
                }
                else -> {
                    callback(false)
                }
            }
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
        println("onGetEmailAddressSuccess ${linkedInEmailAddress?.emailAddress}")
        user?.let {
            it.email = linkedInEmailAddress?.emailAddress ?: ""
            it.loginType = LoginType.LINKEDIN.type
            checkAccountWithEmail()
        }
        linkedInRequestManager.dismissAuthenticateView()
    }
    override fun onGetProfileDataFailed() {
        log("onGetProfileDataFailed")
    }
    override fun onGetProfileDataSuccess(linkedInUserProfile: LinkedInUserProfile?) {
        println("onGetProfileDataSuccess ${linkedInUserProfile?.imageURL} ${linkedInUserProfile?.userName}")
        user?.apply {
            this.profilePicUrl = linkedInUserProfile?.imageURL ?: ""
            this.firstName = linkedInUserProfile?.userName?.firstName?.localized?.en_US.toString()
            this.lastName = linkedInUserProfile?.userName?.lastName?.localized?.en_US.toString()
            this.userId = linkedInUserProfile?.userName?.id.toString()
        }
    }

}