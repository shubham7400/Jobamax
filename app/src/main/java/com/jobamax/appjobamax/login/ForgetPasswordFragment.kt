package com.jobamax.appjobamax.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import com.jobamax.appjobamax.R
import com.jobamax.appjobamax.base.BaseFragment
import com.jobamax.appjobamax.databinding.FragmentForgetPasswordBinding
import com.jobamax.appjobamax.dialog.BasicDialog
import com.jobamax.appjobamax.enums.ParseCloudFunction
import com.jobamax.appjobamax.enums.ParseTableFields
import com.jobamax.appjobamax.extensions.toast
import com.jobamax.appjobamax.model.UserTempInfo
import com.jobamax.appjobamax.util.ARG_USER
import com.jobamax.appjobamax.util.isValidEmail
import com.parse.FunctionCallback
import com.parse.ParseCloud
import com.parse.ParseException
import org.json.JSONObject


class ForgetPasswordFragment : BaseFragment() {
    lateinit var binding: FragmentForgetPasswordBinding

    var user: UserTempInfo? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentForgetPasswordBinding.inflate(inflater, container, false)
        configureUi()
        return binding.root
    }

    private fun configureUi() {
        setClickListeners()
        user = requireArguments().getSerializable(ARG_USER) as UserTempInfo?
    }

    private fun setClickListeners() {
        binding.ivBackButton.setOnClickListener { requireActivity().onBackPressed() }
        binding.btnContinue.setOnClickListener {
            resetPassword()
        }
    }

    private fun resetPassword() {
        val email = binding.etEmail.text.toString().trim()

        if (email.isEmpty()){
            BasicDialog(requireActivity(), "L'adresse e-mail ne peut pas être vide"){}.show()
            return
        }
        if (!email.isValidEmail()){
            BasicDialog(requireActivity(), "E-mail invalide"){}.show()
            return
        }

        if (user != null) {
            if (user!!.userType != null) {
                val request = hashMapOf<String, Any>(
                    ParseTableFields.EMAIL.value to email,
                    ParseTableFields.USER_TYPE.value to user!!.userType!!
                )
                ParseCloud.callFunctionInBackground(
                    ParseCloudFunction.RESET_PASSWORD_REQUEST.value,
                    request,
                    FunctionCallback<Any> { result, e ->
                        when {
                            e != null -> {
                                toast(e.message.toString())
                            }
                            else -> {
                                val response = JSONObject(gson.toJson(result))
                                try {
                                    val message = if (response.getBoolean("status")) {
                                        "Un lien a été envoyé à ton email pour réinitialiser ton mot de passe $email"
                                    } else {
                                        "Il n'y a pas de compte correspondant à cette adresse électronique."
                                    }
                                    BasicDialog(requireActivity(), message, true){
                                        requireActivity().onBackPressed()
                                    }.show()
                                } catch (e: Exception) {
                                    toast(e.message.toString() + " Something Went Wrong.")
                                }
                            }
                        }
                    })
            } else {
                toast("Something Went Wrong.")
            }
        } else {
            toast("Something Went Wrong.")
        }
    }


}