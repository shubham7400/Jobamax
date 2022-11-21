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
import com.jobamax.appjobamax.model.JobSeeker
import com.jobamax.appjobamax.model.JobSeekerPersonalInformationModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_job_seeker_personal_information.*
import java.util.*

@AndroidEntryPoint
class JobSeekerPersonalInformationFragment : BaseFragment(){
    lateinit var binding: FragmentJobSeekerPersonalInformationBinding

    val viewModel: SeekerHomeViewModel by activityViewModels()

    lateinit var jobSeeker: JobSeeker

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentJobSeekerPersonalInformationBinding.inflate(inflater, container, false)
        configureUi()
        return binding.root
    }

    private fun configureUi() {
        setClickListeners()
        initializeJobSeeker()
    }

    private fun setClickListeners() {
        binding.ivBackButton.setOnClickListener { requireActivity().onBackPressed() }
        binding.tvGenderLabel.setOnClickListener { onGenderClicked(it) }
        binding.btnSave.setOnClickListener { saveInformation() }
    }

    private fun initializeJobSeeker() {
         jobSeeker = viewModel.jobSeeker
        if (viewModel.jobSeekerObject == null){
            (requireActivity() as SeekerSettingActivity).getJobSeeker {
                if (it){
                    setData()
                }
            }
        }else{
            setData()
        }
    }

    private fun setData() {
        binding.firstNameField.setText(jobSeeker.firstName)
        binding.lastNameField.setText(jobSeeker.lastName)
        binding.etAge.setText(jobSeeker.age)
        binding.etEmailField.setText(jobSeeker.email)
        binding.tvGenderLabel.text = jobSeeker.gender.replaceFirstChar {
            if (it.isLowerCase()) it.titlecase(
                Locale.getDefault()
            ) else it.toString()
        }
    }


   private fun onGenderClicked(view: View) {
        val popupMenu = PopupMenu(requireActivity(), view)
        popupMenu.menuInflater.inflate(R.menu.menu_gender, popupMenu.menu)
        popupMenu.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.maleItem -> {
                    binding.tvGenderLabel.text = "Homme"
                }
                R.id.femaleItem -> {
                    binding.tvGenderLabel.text = "Femme"
                }
                else -> binding.tvGenderLabel.text = "Autre"
            }
            true
        }
        popupMenu.show()
    }





    private fun saveInformation() {
        val firstName = binding.firstNameField.text.toString().trim()
        val lastName = binding.lastNameField.text.toString().trim()
        val gender = binding.tvGenderLabel.text.toString().trim()
        val age = binding.etAge.text.toString().trim()

        if (binding.firstNameField.text.isEmpty()) {
            BasicDialog(requireActivity(), "le prénom est requis", true){  }.show()
            return
        }
        if (binding.lastNameField.text.isEmpty()) {
            BasicDialog(requireActivity(), "le nom de famille est requis", true){ }.show()
            return
        }
        if (binding.tvGenderLabel.text.isEmpty()) {
            BasicDialog(requireActivity(), "Détails enregistrés avec succès", true){  }.show()
            return
        }
        if (binding.etAge.text.isEmpty()) {
            BasicDialog(requireActivity(), "L'âge ne peut être vide", true){  }.show()
            return
        }
        if (binding.etEmailField.text.isEmpty()) {
            BasicDialog(requireActivity(), "L'email est nécessaire", true){  }.show()
            return
        }
        if (binding.etAge.text.toString().toInt() < 16) {
            BasicDialog(requireActivity(), "L'âge doit être supérieur à 16 ans", true){  }.show()
            return
        }


        viewModel.jobSeekerObject?.also {
            it.put(ParseTableFields.FIRST_NAME.value, firstName)
            it.put(ParseTableFields.LAST_NAME.value, lastName)
            it.put(ParseTableFields.GENDER.value, gender)
            it.put(ParseTableFields.AGE.value, age)
            try {
                it.put(ParseTableFields.AGE_INT.value, age.toInt())
            }catch (e: Exception){}
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