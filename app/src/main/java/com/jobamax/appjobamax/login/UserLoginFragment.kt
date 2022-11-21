package com.jobamax.appjobamax.login

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.*
import androidx.fragment.app.Fragment
import androidx.core.widget.addTextChangedListener
import androidx.navigation.fragment.findNavController
import com.google.gson.Gson
import com.jobamax.appjobamax.R
import com.jobamax.appjobamax.base.BaseFragment
import com.jobamax.appjobamax.databinding.FragmentUserLoginBinding
import com.jobamax.appjobamax.dialog.BasicDialog
import com.jobamax.appjobamax.dialog.MessageDialog
import com.jobamax.appjobamax.dialog.SimpleMessageDialog
import com.jobamax.appjobamax.enums.LoginType
import com.jobamax.appjobamax.enums.ParseTableFields
import com.jobamax.appjobamax.enums.ParseTableName
import com.jobamax.appjobamax.extensions.log
import com.jobamax.appjobamax.extensions.toast
import com.jobamax.appjobamax.jobseeker.JobSeekerHomeActivity
import com.jobamax.appjobamax.jobseeker.build_profile.BuildProfileActivity
import com.jobamax.appjobamax.model.*
import com.jobamax.appjobamax.preference.*
import com.jobamax.appjobamax.recruiter.RecruiterHomeActivity
import com.jobamax.appjobamax.util.AESCrypt
import com.jobamax.appjobamax.util.ARG_USER
import com.jobamax.appjobamax.util.isValidEmail
import com.parse.ParseObject
import com.parse.ParseQuery
import com.pushwoosh.Pushwoosh


class UserLoginFragment : BaseFragment() {
    lateinit var binding: FragmentUserLoginBinding

    var user: UserTempInfo? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentUserLoginBinding.inflate(inflater, container, false)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val window: Window = requireActivity().window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = resources.getColor(R.color.white, null)
        }
        configureUi()
        return binding.root
    }

    private fun configureUi() {
        setClickListeners()
        user = requireArguments().getSerializable(ARG_USER) as UserTempInfo?
        if (user?.userType == 1){
            binding.clRecruiterInfo.visibility = View.VISIBLE
        }else{
            binding.clRecruiterInfo.visibility = View.GONE
        }
    }

    private fun setClickListeners() {
        binding.tvConnectionProblem.setOnClickListener {
            val args = Bundle()
            args.putSerializable(ARG_USER, user)
            findNavController().navigate(R.id.action_userLoginFragment_to_forgetPasswordFragment, args)
        }
        binding.ivBackButton.setOnClickListener { requireActivity().onBackPressed() }
        binding.btnContinue.setOnClickListener { getUserLogin() }

        binding.ivPasswordShowHide.setOnClickListener {
            if (binding.etPassword.transformationMethod.equals(PasswordTransformationMethod.getInstance())) {
                binding.apply {
                    ivPasswordShowHide.setImageResource(R.drawable.ic_eye_open_navi_blue)
                    etPassword.transformationMethod = HideReturnsTransformationMethod.getInstance()
                    etPassword.setSelection(etPassword.length())
                }
            } else {
                binding.apply {
                    ivPasswordShowHide.setImageResource(R.drawable.ic_eye_close_navi_blue)
                    etPassword.transformationMethod = PasswordTransformationMethod.getInstance()
                    etPassword.setSelection(etPassword.length())
                }
            }
        }
    }

    private fun getUserLogin() {
        val email = binding.etEmail.text.toString().trim()
        val password = binding.etPassword.text.toString()

        if (email.isEmpty() ){
            BasicDialog(requireActivity(), "Email/Password ne peut être vide"){}.show()
            return
        }
        if (!email.isValidEmail()){
            BasicDialog(requireActivity(), "E-mail invalide"){}.show()
            return
        }
        if (password.length < 7 || password.isEmpty()){
            BasicDialog(requireActivity(), "Le mot de passe doit contenir au moins 7 caractères"){}.show()
            return
        }

        when(user?.userType){
            1 -> {
                val query = ParseQuery.getQuery<ParseObject>(ParseTableName.RECRUITER.value)
                query.whereEqualTo(ParseTableFields.EMAIL.value, email)
                progressHud.show()
                query.getFirstInBackground { result, e ->
                    progressHud.dismiss()
                    if (e == null && result != null) {
                        val validPassword = result.getString(ParseTableFields.PASSWORD.value)
                        if (validPassword == AESCrypt.encrypt(password)){
                            val recruiter = Recruiter(result)
                            requireContext().setUserId(recruiter.recruiterId)
                            Pushwoosh.getInstance().setUserId(recruiter.recruiterId) {
                                if (it.isSuccess) { }
                                if (it.exception != null) {
                                    toast(it.exception!!.message.toString()+" Something Went Wrong")
                                }
                            }
                            requireContext().setLoggedIn(true)
                            requireContext().setUserType(1)
                            startActivity(Intent(requireContext(), RecruiterHomeActivity::class.java))
                            Pushwoosh.getInstance().setUserId(recruiter.recruiterId)
                            requireActivity().finishAffinity()
                        }else{
                            BasicDialog(requireActivity(), "Mot de passe invalide"){}.show()
                        }
                    } else {
                        println("error: ${e.message.toString()}")
                        BasicDialog(requireActivity(), "E-mail invalide"){}.show()
                    }
                }
            }
            2 -> {
                val query = ParseQuery.getQuery<ParseObject>(ParseTableName.JOB_SEEKER.value)
                query.whereEqualTo(ParseTableFields.EMAIL.value, email)
                progressHud.show()
                query.getFirstInBackground { result, e ->
                    progressHud.dismiss()
                    if (e == null && result != null) {
                        val validPassword = result.getString(ParseTableFields.PASSWORD.value)
                        if (validPassword == AESCrypt.encrypt(password)){
                            val jobSeeker = JobSeeker(result)
                            requireContext().setUserId(jobSeeker.jobSeekerId)
                            requireContext().setLoginType(jobSeeker.loginType)
                            requireContext().setLoggedIn(true)
                            requireContext().setUserType(2)
                            Pushwoosh.getInstance().setUserId(jobSeeker.jobSeekerId) {
                                if (it.isSuccess) { }
                                if (it.exception != null) {
                                    toast(it.exception!!.message.toString()+" Something Went Wrong")
                                }
                            }
                            if (!jobSeeker.seenOnboarding){
                                requireContext().setSeenOnBoarding(false)
                                startActivity(Intent(requireContext(), BuildProfileActivity::class.java))
                                requireActivity().finish()
                            }else{
                                requireContext().setSeenOnBoarding(true)
                                startActivity(Intent(requireContext(), JobSeekerHomeActivity::class.java))
                                requireActivity().finish()
                            }
                        }else{
                            BasicDialog(requireActivity(), "Mot de passe invalide"){}.show()
                        }
                    } else {
                        log("error: ${e.message.toString()}")
                        BasicDialog(requireActivity(), "E-mail invalide"){}.show()
                    }
                }
            }
        }
    }

}