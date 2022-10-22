package com.jobamax.appjobamax.recruiter.profile.setting

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.jobamax.appjobamax.R
import com.jobamax.appjobamax.base.BaseFragment
import com.jobamax.appjobamax.databinding.FragmentRecruiterPersonalInfoBinding
import com.jobamax.appjobamax.dialog.BasicDialog
import com.jobamax.appjobamax.enums.ParseTableFields
import com.jobamax.appjobamax.extensions.toast
import com.jobamax.appjobamax.model.Recruiter
import com.jobamax.appjobamax.recruiter.RecruiterHomeActivity
import com.jobamax.appjobamax.recruiter.RecruiterHomeViewModel


class RecruiterPersonalInfoFragment : BaseFragment() {
    lateinit var binding: FragmentRecruiterPersonalInfoBinding

    val viewModel: RecruiterHomeViewModel by activityViewModels()
    lateinit var recruiter: Recruiter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentRecruiterPersonalInfoBinding.inflate(inflater, container, false)
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
            if (validateData()){
                viewModel.recruiterObject?.let {
                    it.put(ParseTableFields.FIRST_NAME.value, binding.firstNameField.text.toString())
                    it.put(ParseTableFields.LAST_NAME.value, binding.lastNameField.text.toString())
                    it.put(ParseTableFields.AGE.value, binding.etAge.text.toString())
                    it.saveInBackground { exception ->
                        if (exception != null) {
                            toast("${exception.message.toString()} Something went wrong")
                        }else{
                            BasicDialog(requireActivity(), "Détails enregistrés avec succès", true){ requireActivity().onBackPressed() }.show()
                        }
                    }
                }
            }
        }
    }

    private fun validateData(): Boolean {

        var validateFlag = true

        if (binding.firstNameField.text.isEmpty()) {
            BasicDialog(requireActivity(), "le prénom est requis", true){  }.show()
            validateFlag = false
            return validateFlag
        }

        if (binding.lastNameField.text.isEmpty()) {
            BasicDialog(requireActivity(), "le nom de famille est requis", true){ }.show()
            validateFlag = false
            return validateFlag
        }

        if (binding.etEmailField.text.isEmpty()) {
            BasicDialog(requireActivity(), "L'email est nécessaire", true){  }.show()
            validateFlag = false
            return validateFlag
        }

        if (binding.etAge.text.isEmpty()) {
            BasicDialog(requireActivity(), "L'âge ne peut être vide", true){  }.show()
            validateFlag = false
            return validateFlag
        }

        return validateFlag
    }

    private fun initializeRecruiter() {
        recruiter = viewModel.recruiter
        if (viewModel.recruiterObject == null) {
            (requireActivity() as RecruiterHomeActivity).getRecruiter {
                if (it) {
                    recruiter = viewModel.recruiter
                    setData()
                }
            }
        }
    }

    private fun setObserver() {
        viewModel.isRecruiterUpdated.observe(viewLifecycleOwner){
            if (it){
                recruiter = viewModel.recruiter
                setData()
            }
        }
    }

    private fun setData() {
        binding.firstNameField.setText(recruiter.firstName)
        binding.lastNameField.setText(recruiter.lastName)
        binding.etAge.setText(recruiter.age)
        binding.etEmailField.setText(recruiter.email)
    }

}