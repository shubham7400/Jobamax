package com.jobamax.appjobamax.jobseeker.profile.account.personalInfo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import androidx.fragment.app.activityViewModels
import com.jobamax.appjobamax.R
import com.jobamax.appjobamax.base.BaseFragment
 import com.jobamax.appjobamax.databinding.FragmentJobSeekerPersonalInformationBinding
import com.jobamax.appjobamax.dialog.BasicDialog
import com.jobamax.appjobamax.enums.ParseTableFields
import com.jobamax.appjobamax.extensions.*
import com.jobamax.appjobamax.jobseeker.profile.account.SeekerSettingActivity
import com.jobamax.appjobamax.jobseeker.view_model.SeekerHomeViewModel
import com.jobamax.appjobamax.model.JobSeekerPersonalInformationModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_job_seeker_personal_information.*
import java.util.*

@AndroidEntryPoint
class JobSeekerPersonalInformationFragment : BaseFragment(), JobSeekerPersonalInformationInterface {
    lateinit var binding: FragmentJobSeekerPersonalInformationBinding

    val viewModel: SeekerHomeViewModel by activityViewModels()

    lateinit var personalInfoModel: JobSeekerPersonalInformationModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentJobSeekerPersonalInformationBinding.inflate(inflater, container, false)
        configureUi()
        return binding.root
    }

    private fun configureUi() {
        setHasOptionsMenu(true)
        personalInfoModel = JobSeekerPersonalInformationModel(viewModel.jobSeeker)
        binding.handler = this
        initFields()
    }




    private fun initFields() {
        binding.jobSeeker = personalInfoModel
        binding.genderLabel.text = personalInfoModel.gender.replaceFirstChar {
            if (it.isLowerCase()) it.titlecase(
                Locale.getDefault()
            ) else it.toString()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home)
            (requireActivity() as SeekerSettingActivity).onBackPressed()
        return super.onOptionsItemSelected(item)
    }

    override fun onGenderClicked(view: View) {
        val popupMenu = PopupMenu(requireActivity(), view)
        popupMenu.menuInflater.inflate(R.menu.menu_gender, popupMenu.menu)
        popupMenu.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.maleItem -> {
                    personalInfoModel.gender = "Homme"
                }
                R.id.femaleItem -> {
                    personalInfoModel.gender = "Femme"
                }
                else -> personalInfoModel.gender = "Autre"
            }
            genderLabel.text = personalInfoModel.gender.replaceFirstChar {
                if (it.isLowerCase()) it.titlecase(
                    Locale.ROOT
                ) else it.toString()
            }
            initFields()
            true
        }
        popupMenu.show()
    }

    override fun onSubmitClicked() {
        if (validateFields()) {
            updateUser()
            viewModel.jobSeekerObject?.also {
                it.put(ParseTableFields.FIRST_NAME.value, personalInfoModel.firstName)
                it.put(ParseTableFields.LAST_NAME.value, personalInfoModel.lastName)
                it.put(ParseTableFields.GENDER.value, personalInfoModel.gender)
                it.put(ParseTableFields.AGE.value, personalInfoModel.age)
                it.put(ParseTableFields.POST_CODE.value, personalInfoModel.postCode)
                it.put(ParseTableFields.EMAIL.value, personalInfoModel.email)
            }
            viewModel.jobSeekerObject?.saveInBackground { e ->
                if (e != null) {
                    toast(e.message ?: "Something went wrong.")
                    e.printStackTrace()
                } else {
                    BasicDialog(requireActivity(), "Détails enregistrés avec succès", true){ requireActivity().onBackPressed() }.show()
                }
            }
        }
    }

    private fun updateUser() {

        if (binding.etAge.text.isNotEmpty()) {
            personalInfoModel.age = binding.etAge.text.toString()
        }
        if (binding.etEmailField.text.isNotEmpty()) {
            personalInfoModel.email = binding.etEmailField.text.toString()
        }
        if (binding.firstNameField.text.isNotEmpty()) {
            personalInfoModel.firstName = binding.firstNameField.text.toString()
        }
        if (binding.lastNameField.text.isNotEmpty()) {
            personalInfoModel.lastName = binding.lastNameField.text.toString()
        }
        if (binding.genderLabel.text.isNotEmpty()) {
            personalInfoModel.gender = binding.genderLabel.text.toString()
        }
    }







    override fun onBackPress() {
        requireActivity().onBackPressed()
    }


    private fun validateFields(): Boolean {

        var validateFlag = true
        if (binding.genderLabel.text.isEmpty()) {
            BasicDialog(requireActivity(), "Détails enregistrés avec succès", true){  }.show()
            validateFlag = false
            return validateFlag
        }

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
}