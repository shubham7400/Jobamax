package com.jobamax.appjobamax.recruiter.profile.setting

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.jobamax.appjobamax.R
import com.jobamax.appjobamax.databinding.FragmentRecruiterChangePasswordBinding
import com.jobamax.appjobamax.enums.ParseTableFields
import com.jobamax.appjobamax.enums.ParseTableName
import com.jobamax.appjobamax.extensions.log
import com.jobamax.appjobamax.extensions.toast
import com.jobamax.appjobamax.model.Recruiter
import com.jobamax.appjobamax.preference.getUserId
import com.jobamax.appjobamax.recruiter.RecruiterHomeActivity
import com.jobamax.appjobamax.recruiter.RecruiterHomeViewModel
import com.jobamax.appjobamax.util.AESCrypt
import com.parse.ParseObject
import com.parse.ParseQuery


class RecruiterChangePasswordFragment : Fragment() {
     lateinit var binding: FragmentRecruiterChangePasswordBinding

    val viewModel: RecruiterHomeViewModel by activityViewModels()
    lateinit var recruiter: Recruiter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentRecruiterChangePasswordBinding.inflate(inflater, container, false)
        configureUi()
        return binding.root
    }

    private fun configureUi() {
        setClickListeners()
        setObserver()
        initializeRecruiter()
    }

    private fun setClickListeners() {
        binding.ivBackButton.setOnClickListener { requireActivity().onBackPressed() }
         binding.btnSave.setOnClickListener {
             viewModel.recruiterObject?.let {
                savePassword()
             }
         }
    }

    private fun savePassword() {
        if (binding.etNewPassword.text.isNullOrEmpty()) {
            toast("Password should not be empty")
            return
        }

        if (binding.etConfirmPassword.text.isEmpty()) {
            toast("Password should not be empty")
            return
        }

        val oldPassword = binding.etCurrentPassword.text.toString().trim()
        val newPassword = binding.etNewPassword.text.toString().trim()
        val confirmNewPassword = binding.etConfirmPassword.text.toString().trim()

        if (newPassword != confirmNewPassword){
            toast("Password not match")
            return
        }

        if (newPassword.length < 7) {
            toast("Password should have at least 7 characters")
            return
        }

        authenticateOldPassword(oldPassword) {
            if (it){
                viewModel.recruiterObject?.put(ParseTableFields.PASSWORD.value, AESCrypt.encrypt(newPassword))
                viewModel.recruiterObject?.saveInBackground { exception ->
                    if (exception == null){
                        toast("Password Changed successfully")
                        requireActivity().onBackPressed()
                    }
                }
            }
        }
    }

    private fun authenticateOldPassword(oldPassword: String, callback: (Boolean) -> Unit) {
        val query = ParseQuery.getQuery<ParseObject>(ParseTableName.RECRUITER.value)
        query.whereEqualTo(ParseTableFields.RECRUITER_ID.value, requireContext().getUserId())
        query.findInBackground { it, e ->
            val parseObject = it?.firstOrNull()
            when {
                e != null -> {
                    log(e.message.toString())
                    callback(false)
                }
                parseObject == null -> {
                    log("User Not Found")
                    callback(false)
                }
                else -> {
                    val password = parseObject.get(ParseTableFields.PASSWORD.value)
                    if (AESCrypt.encrypt(oldPassword) == password){
                        callback(true)
                    }else{
                        toast("your old password did not match")
                        callback(false)
                    }
                }
            }
        }
    }


    private fun initializeRecruiter() {
        recruiter = viewModel.recruiter
        if (viewModel.recruiterObject == null) {
            (requireActivity() as RecruiterSettingActivity).getRecruiter {
                if (it) {
                    recruiter = viewModel.recruiter
                }
            }
        }
    }

    private fun setObserver() {
        viewModel.isRecruiterUpdated.observe(viewLifecycleOwner){
            if (it){
                recruiter = viewModel.recruiter
            }
        }
    }

}