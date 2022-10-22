package com.jobamax.appjobamax.jobseeker.profile.account

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.jobamax.appjobamax.databinding.FragmentSeekerChangePasswordBinding
import com.jobamax.appjobamax.dialog.BasicDialog
import com.jobamax.appjobamax.enums.ParseTableFields
import com.jobamax.appjobamax.enums.ParseTableName
import com.jobamax.appjobamax.extensions.log
import com.jobamax.appjobamax.extensions.toast
import com.jobamax.appjobamax.jobseeker.view_model.SeekerHomeViewModel
import com.jobamax.appjobamax.preference.getUserId
import com.jobamax.appjobamax.util.AESCrypt
import com.parse.ParseObject
import com.parse.ParseQuery


class SeekerChangePasswordFragment : Fragment() {
    lateinit var binding: FragmentSeekerChangePasswordBinding

    val viewModel: SeekerHomeViewModel by activityViewModels()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentSeekerChangePasswordBinding.inflate(inflater, container, false)
        configureUi()
        return binding.root
    }

    private fun configureUi() {
         setClickListeners()
    }

    private fun setClickListeners() {
        binding.ivBackButton.setOnClickListener { requireActivity().onBackPressed() }
        binding.submitButton.setOnClickListener { onSubmitClicked() }
    }

    private fun onSubmitClicked() {
        if (binding.etCurrentPassword.text.isNullOrEmpty()){
            BasicDialog(requireActivity(), "L'ancien mot de passe ne peut pas être vide", false){}.show()
            return
        }

        if (binding.etNewPassword.text.isNullOrEmpty()) {
            BasicDialog(requireActivity(), "Les mots de passes doivent correspondre", false){}.show()
            return
        }

        if (binding.etConfirmPassword.text.isEmpty()) {
            BasicDialog(requireActivity(), "Les mots de passes doivent correspondre", false){}.show()
            return
        }

        val oldPassword = binding.etCurrentPassword.text.toString().trim()
        val newPassword = binding.etNewPassword.text.toString().trim()
        val confirmNewPassword = binding.etConfirmPassword.text.toString().trim()

        if (newPassword != confirmNewPassword){
            BasicDialog(requireActivity(), "Les mots de passes doivent correspondre", false){}.show()
            return
        }

        if (newPassword.length < 7) {
            BasicDialog(requireActivity(), "Le mot de passe doit avoir au moins 7 caractères", false){}.show()
            return
        }

        authenticateOldPassword(oldPassword) {
            if (it){
                viewModel.jobSeekerObject?.put(ParseTableFields.PASSWORD.value, AESCrypt.encrypt(newPassword))
                viewModel.jobSeekerObject?.saveInBackground { exception ->
                    if (exception == null){
                        BasicDialog(requireActivity(), "Le mot de passe a été changé avec succès", true){
                            requireActivity().onBackPressed()
                        }.show()
                    }
                }
            }
        }
    }

    private fun authenticateOldPassword(oldPassword: String, callback: (Boolean) -> Unit) {
        val query = ParseQuery.getQuery<ParseObject>(ParseTableName.JOB_SEEKER.value)
        query.whereEqualTo(ParseTableFields.JOB_SEEKER_ID.value, requireContext().getUserId())
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


}