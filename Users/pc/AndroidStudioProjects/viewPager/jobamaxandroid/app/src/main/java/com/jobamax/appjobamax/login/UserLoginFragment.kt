package com.jobamax.appjobamax.login

import android.content.Intent
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.navigation.fragment.findNavController
import com.google.gson.Gson
import com.jobamax.appjobamax.R
import com.jobamax.appjobamax.databinding.FragmentUserLoginBinding
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
import com.parse.ParseObject
import com.parse.ParseQuery


class UserLoginFragment : Fragment() {
    lateinit var binding: FragmentUserLoginBinding

    var user: UserTempInfo? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentUserLoginBinding.inflate(inflater, container, false)
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
        binding.etEmail.addTextChangedListener {
            if (it != null) {
                if (it.isEmpty() || binding.etPassword.text.isEmpty() ){
                    binding.btnContinue.isEnabled = false
                    binding.btnContinue.background = resources.getDrawable(R.drawable.rounded_grey_box_50, null)
                    binding.btnContinue.setTextColor(resources.getColor(R.color.navi_blue, null))
                }else{
                    binding.btnContinue.isEnabled = true
                    binding.btnContinue.background = resources.getDrawable(R.drawable.rounded_bottom_purple_top_blue_50, null)
                    binding.btnContinue.setTextColor(resources.getColor(R.color.white, null))
                }
            }
        }
        binding.etPassword.addTextChangedListener {
            if (it != null) {
                if (it.isEmpty() || binding.etEmail.text.isEmpty()){
                    binding.btnContinue.isEnabled = false
                    binding.btnContinue.background = resources.getDrawable(R.drawable.rounded_grey_box_50, null)
                    binding.btnContinue.setTextColor(resources.getColor(R.color.navi_blue, null))
                }else{
                    binding.btnContinue.isEnabled = true
                    binding.btnContinue.background = resources.getDrawable(R.drawable.rounded_bottom_purple_top_blue_50, null)
                    binding.btnContinue.setTextColor(resources.getColor(R.color.white, null))
                }
            }
        }
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
        when(user?.userType){
            1 -> {
                val query = ParseQuery.getQuery<ParseObject>(ParseTableName.RECRUITER.value)
                query.whereEqualTo(ParseTableFields.EMAIL.value, binding.etEmail.text.toString())
                query.whereEqualTo(ParseTableFields.PASSWORD.value, AESCrypt.encrypt(binding.etPassword.text.toString()))
                query.getFirstInBackground { result, e ->
                    if (e == null && result != null) {
                        val recruiter = Recruiter(result)
                        requireContext().setUserId(recruiter.recruiterId)
                        requireContext().setLoggedIn(true)
                        requireContext().setUserType(1)
                        startActivity(Intent(requireContext(), RecruiterHomeActivity::class.java))
                        requireActivity().finishAffinity()
                    } else {
                        log("error: ${e.message.toString()}")
                        toast("please enter valid username and password")
                    }
                }
            }
            2 -> {
                val query = ParseQuery.getQuery<ParseObject>(ParseTableName.JOB_SEEKER.value)
                query.whereEqualTo(ParseTableFields.EMAIL.value, binding.etEmail.text.toString())
                query.whereEqualTo(ParseTableFields.LOGIN_TYPE.value, LoginType.EMAIL.type)
                query.whereEqualTo(ParseTableFields.PASSWORD.value, AESCrypt.encrypt(binding.etPassword.text.toString()))
                query.getFirstInBackground { result, e ->
                    if (e == null && result != null) {
                        val jobSeeker = JobSeeker(result)
                        requireContext().setUserId(jobSeeker.jobSeekerId)
                        requireContext().setLoginType(jobSeeker.loginType)
                        requireContext().setLoggedIn(true)
                        requireContext().setUserType(2)
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
                        toast("please enter valid username and password")
                    }
                }
            }
        }
    }

}