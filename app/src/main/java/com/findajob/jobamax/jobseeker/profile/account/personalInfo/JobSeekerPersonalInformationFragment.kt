package com.findajob.jobamax.jobseeker.profile.account.personalInfo

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.PopupMenu
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import com.findajob.jobamax.R
import com.findajob.jobamax.base.BaseFragmentMain
import com.findajob.jobamax.databinding.FragmentJobSeekerPersonalInformationBinding
import com.findajob.jobamax.jobseeker.home.JobSeekerHomeActivity
import com.findajob.jobamax.jobseeker.home.JobSeekerHomeViewModel
import com.findajob.jobamax.util.*
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_job_seeker_personal_information.*
import java.util.*

@AndroidEntryPoint
class JobSeekerPersonalInformationFragment : BaseFragmentMain<FragmentJobSeekerPersonalInformationBinding>(), JobSeekerPersonalInformationInterface {

    val viewModel: JobSeekerHomeViewModel by activityViewModels()
    override fun getViewModel(): ViewModel {
        return viewModel
    }

    private lateinit var personalInfoModel: JobSeekerPersonalInformationModel


    override val layoutRes: Int get() = R.layout.fragment_job_seeker_personal_information

    override fun onCreated(savedInstance: Bundle?) {
        setHasOptionsMenu(true)
        personalInfoModel = JobSeekerPersonalInformationModel(viewModel.jobSeeker)
        binding.handler = this
        initFields()
    }


    private fun initFields() {
        binding.jobSeeker = personalInfoModel
        genderLabel.text = personalInfoModel.gender.capitalize()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home)
            (requireActivity() as JobSeekerHomeActivity).onBackPressed()
        return super.onOptionsItemSelected(item)
    }

    override fun onGenderClicked(view: View) {
        val popupMenu = PopupMenu(requireActivity(), view)
        popupMenu.menuInflater.inflate(R.menu.menu_gender, popupMenu.menu)
        popupMenu.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.maleItem -> {
                    personalInfoModel.gender = "male"
                }
                R.id.femaleItem -> {
                    personalInfoModel.gender = "female"
                }
                else -> personalInfoModel.gender = "other"
            }
            genderLabel.text = personalInfoModel.gender.capitalize(Locale.ROOT)
            initFields()
            true
        }
        popupMenu.show()
    }

    override fun onSubmitClicked() {
        addPhoneNumber()
        if (validateFields()) {
            updateUser()
            progressHud.show()
            viewModel.submitData(personalInfoModel) { e ->
                progressHud.dismiss()
                if (e != null) {
                    toast(e.message ?: "Something went wrong.")
                    e.printStackTrace()
                } else {
                    toast("Data Successfully Submitted!")
                }
            }
        }
    }

    private fun updateUser() {
        if (binding.postCodeField.text.isNotEmpty()) {
            personalInfoModel.postCode = binding.postCodeField.text.toString()
        }
        if (binding.dobField.text.isNotEmpty()) {
            personalInfoModel.dob = binding.dobField.text.toString()
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

    private fun addPhoneNumber() {
        personalInfoModel.phoneNumber = ccp.selectedCountryCodeWithPlus + " " + binding.phoneField.text.toString()
    }

    private val datePickerListener =
        DatePickerDialog.OnDateSetListener { _, year, month, dayOfMonth ->
            val calendar = Calendar.getInstance()
            calendar.set(Calendar.YEAR, year)
            calendar.set(Calendar.MONTH, month)
            calendar.set(Calendar.DATE, dayOfMonth)
            genderLabel.error = null

            if (Date().addYear(-18).yyyyMMdd() < calendar.time.yyyyMMdd()) {
                toast("Age should be 18+")
            } else {
                personalInfoModel.dob = calendar.time.dd_MM_yy()
                binding.dobField.error = null
                initFields()
            }
        }


    override fun onDobClicked() {
        val (year, month, day) = Triple(Date().year(), Date().month() - 1, Date().date() - 1)
        val datePickerDialog =
            DatePickerDialog(requireActivity(), datePickerListener, year, month, day)
        datePickerDialog.show()
    }

    override fun onBackPress() {
        requireActivity().onBackPressed()
    }


    private fun validateFields(): Boolean {

        var validateFlag = true
        if (genderLabel.text.isEmpty()) {
            genderLabel.error = getString(R.string.enter_gender_here)
            validateFlag = false
        }

        if (firstNameField.text.isEmpty()) {
            firstNameField.error = getString(R.string.enter_first_name)
            validateFlag = false
        }

        if (dobField.text.isEmpty()) {
            dobField.error = getString(R.string.enter_date_of_birth)
            validateFlag = false
        }

        if (phoneField.text.isEmpty()) {
            phoneField.error = getString(R.string.enter_phone_number)
            validateFlag = false
        } else if ((phoneField.text.toString().trim().length + ccp.selectedCountryCodeWithPlus.length) <= 10) {
            toast(getString(R.string.enter_valid_phone_number))
            phoneField.error = getString(R.string.enter_valid_phone_number)
            validateFlag = false
        }

        return validateFlag
    }
}