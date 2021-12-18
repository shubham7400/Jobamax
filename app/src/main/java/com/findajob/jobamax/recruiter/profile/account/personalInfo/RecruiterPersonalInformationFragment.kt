package com.findajob.jobamax.recruiter.profile.account.personalInfo

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.PopupMenu
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import com.findajob.jobamax.R
import com.findajob.jobamax.base.BaseFragmentMain
import com.findajob.jobamax.databinding.FragmentRecruiterPersonalInformationBinding
import com.findajob.jobamax.recruiter.home.RecruiterHomeActivity
import com.findajob.jobamax.recruiter.home.RecruiterHomeViewModel
import com.findajob.jobamax.util.*
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_recruiter_personal_information.*
import org.jetbrains.anko.support.v4.longToast
import java.util.*

@AndroidEntryPoint
class RecruiterPersonalInformationFragment : BaseFragmentMain<FragmentRecruiterPersonalInformationBinding>(), RecruiterPersonalInformationInterface {
	
	val viewModel: RecruiterHomeViewModel by activityViewModels()
	lateinit var personalInfoModel: RecruiterPersonalInformationModel

	override val layoutRes: Int
		get() = R.layout.fragment_recruiter_personal_information

	override fun onCreated(savedInstance: Bundle?) {
		personalInfoModel = RecruiterPersonalInformationModel(viewModel.recruiter, viewModel.company)
		binding.handler = this
		initFields()
	}

	override fun getViewModel(): ViewModel? {
		return viewModel
	}
	
	private fun initFields() {
		binding.recruiter = personalInfoModel
		genderLabel.text = personalInfoModel.gender.capitalize()
	}
	
	private val datePickerListener = DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
		val calendar = Calendar.getInstance()
		calendar.set(Calendar.YEAR, year)
		calendar.set(Calendar.MONTH, month)
		calendar.set(Calendar.DATE, dayOfMonth)

		if (Date().addYear(-18).yyyyMMdd() < calendar.time.yyyyMMdd()) {
			longToast("Age should be 18+")
		} else {
			personalInfoModel.dob = calendar.time.dd_MM_yy()
			binding.dobField.error = null
			initFields()
		}
	}

	override fun onDobClicked() {
		val (year, month, day) = Triple(Date().year(), Date().month() - 1, Date().date() - 1)
		val datePickerDialog = DatePickerDialog(requireActivity(), datePickerListener, year, month, day)
		datePickerDialog.show()
	}

	override fun onBackPress() {
		requireActivity().onBackPressed()
	}

	override fun onOptionsItemSelected(item: MenuItem): Boolean {
		if (item.itemId == android.R.id.home)
			(requireActivity() as RecruiterHomeActivity).onBackPressed()
		return super.onOptionsItemSelected(item)
	}
	
	override fun onGenderClicked(view: View) {
		val popupMenu = PopupMenu(requireActivity(), view)
		popupMenu.menuInflater.inflate(R.menu.menu_gender, popupMenu.menu)
		popupMenu.setOnMenuItemClickListener {
			if (it.itemId == R.id.maleItem) {
				personalInfoModel.gender = "male"
			} else if (it.itemId == R.id.femaleItem) {
				personalInfoModel.gender = "female"
			} else personalInfoModel.gender = "other"
			genderLabel.error = null
			initFields()
			true
		}
		popupMenu.show()
	}
	
	override fun onSubmitClicked() {
		addPhoneNumber()
		if (validateFields()) {
			showLoading(true)
			viewModel.submitData(personalInfoModel) {
				showLoading(false)
				if (it != null)
					(requireActivity() as RecruiterHomeActivity).errorToast(it)
				else (requireActivity() as RecruiterHomeActivity).toast("Data Successfully Submitted!")
			}
		}
	}

	private fun addPhoneNumber(){
		personalInfoModel.phoneNumber = ccp.selectedCountryCodeWithPlus + " " + binding.phoneField.text.toString()
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
		
		if (lastNameField.text.isEmpty()) {
			lastNameField.error = getString(R.string.enter_last_name)
			validateFlag = false
		}
		
		if (companyNameField.text.isEmpty()) {
			companyNameField.error = getString(R.string.enter_company_name)
			validateFlag = false
		}
		
		if (postCodeField.text.isEmpty()) {
			postCodeField.error = getString(R.string.enter_postcode)
			validateFlag = false
		}
		
		if (emailField.text.isEmpty()) {
			emailField.error = getString(R.string.enter_email)
			validateFlag = false
		} else if(!emailField.text.toString().trim().isValidEmail()){
			emailField.error = getString(R.string.enter_valid_email)
			validateFlag = false
		}
		
		if (personalInfoModel.dob.isEmpty()) {
			binding.dobField.error = getString(R.string.enter_date_of_birth)
			validateFlag = false
		} else if ((phoneField.text.toString().trim().length + ccp.selectedCountryCodeWithPlus.length) <= 10) {
			toast(getString(R.string.enter_valid_phone_number))
			phoneField.error = getString(R.string.enter_valid_phone_number)
			validateFlag = false
		}
		
		return validateFlag
	}

}
