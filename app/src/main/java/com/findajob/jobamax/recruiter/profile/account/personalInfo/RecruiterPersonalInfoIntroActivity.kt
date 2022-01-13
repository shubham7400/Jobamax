package com.findajob.jobamax.recruiter.profile.account.personalInfo

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.PopupMenu
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import com.findajob.jobamax.R
import com.findajob.jobamax.base.BaseActivityMain
import com.findajob.jobamax.databinding.ActivityRecruiterPersonalInfoIntroBinding
import com.findajob.jobamax.dialog.multiChoice.BasicDialog
import com.findajob.jobamax.enums.ParseTableName
import com.findajob.jobamax.extensions.goToActivity
import com.findajob.jobamax.preference.getEmail
import com.findajob.jobamax.recruiter.home.RecruiterHomeActivity
import com.findajob.jobamax.recruiter.profile.account.companyInfo.CompanyIntroInfoActivity
import com.findajob.jobamax.util.*
import com.parse.ParseObject
import com.parse.ParseQuery
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_recruiter_personal_info_intro.*
import org.jetbrains.anko.longToast
import java.util.*

@AndroidEntryPoint
class RecruiterPersonalInfoIntroActivity : BaseActivityMain<ActivityRecruiterPersonalInfoIntroBinding>(), RecruiterPersonalInfoIntroInterface {

    val viewModel: RecruiterPersonalInfoIntroViewModel by viewModels()
    private lateinit var personalInfoModel: RecruiterPersonalInformationModel

    override val layoutRes: Int get() = R.layout.activity_recruiter_personal_info_intro

    override fun getViewModel(): ViewModel = viewModel

    override fun onCreated(instance: Bundle?) {
        configureViewModel()
        initViews()
    }

    private fun configureViewModel() {
        subscribeObserver()
        viewModel.getRecruiter()
    }

    private fun initViews() {
        binding.handler = this
        personalInfoModel = RecruiterPersonalInformationModel()
        binding.etEmailField.setText(getEmail())
    }


    private fun subscribeObserver() {
        viewModel.getRecruiterObserver().observe(this, { recruiter ->
            progressHud.dismiss()
           /* personalInfoModel = RecruiterPersonalInformationModel(recruiter, viewModel.company)*/
            binding.recruiter = personalInfoModel
            binding.company = viewModel.company
            binding.tvGenderHint.text = personalInfoModel.gender.replaceFirstChar { char ->
                if (char.isLowerCase()) char.titlecase(
                    Locale.getDefault()
                ) else char.toString()
            }
        })
    }


    private val datePickerListener =
        DatePickerDialog.OnDateSetListener { _, year, month, dayOfMonth ->
            val calendar = Calendar.getInstance()
            calendar.set(Calendar.YEAR, year)
            calendar.set(Calendar.MONTH, month)
            calendar.set(Calendar.DATE, dayOfMonth)

            if (Date().addYear(-18).yyyyMMdd() < calendar.time.yyyyMMdd()) {
                longToast("Age should be 18+")
            } else {
                personalInfoModel.dob = calendar.time.dd_MM_yy()
                binding.tvDateOfBirthField.text = calendar.time.dd_MM_yy()
                binding.recruiter = personalInfoModel
            }
        }

    override fun onDobClicked() {
        val (year, month, day) = Triple(Date().year(), Date().month() - 1, Date().date() - 1)
        val datePickerDialog = DatePickerDialog(this, datePickerListener, year, month, day)
        datePickerDialog.show()
    }

    override fun onGenderClicked(view: View) {
        val popupMenu = PopupMenu(this, view)
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

            binding.tvGenderHint.text = personalInfoModel.gender.replaceFirstChar { char ->
                if (char.isLowerCase()) char.titlecase(
                    Locale.getDefault()
                ) else char.toString()
            }
            binding.tvGenderHint.error = null
            true
        }
        popupMenu.show()
    }

    override fun onSubmitClicked() {
        addPhoneNumber()
        if (binding.etInvitationCode.text.isNotEmpty()){
            progressHud.show()
            val query = ParseQuery.getQuery<ParseObject>(ParseTableName.SalesPerson.toString())
            query.whereContains("promoCode", binding.etInvitationCode.toString())
            query.getFirstInBackground { result, e ->
                progressHud.dismiss()
                if (result == null){
                    BasicDialog(this, "Invalid Promo Code!"){}.show()
                }else{
                    takeToCompanyInfoActivity()
                }
            }
        }else{
            takeToCompanyInfoActivity()
        }
    }

    private fun takeToCompanyInfoActivity() {
        if (validateFields()) {
            startActivity(Intent(this, CompanyIntroInfoActivity::class.java).also {
                it.putExtra(RECRUITER_FIRST_NAME, if (binding.etFirstName.text.isBlank())  "" else binding.etFirstName.text.toString() )
                it.putExtra(RECRUITER_LAST_NAME, if (binding.etLastName.text.isBlank())  "" else binding.etLastName.text.toString())
                it.putExtra(RECRUITER_GENDER, if (binding.tvGenderHint.text.isBlank())  "" else binding.tvGenderHint.text.toString())
                it.putExtra(RECRUITER_DOB, if (binding.tvDateOfBirthField.text.isBlank())  "" else binding.tvDateOfBirthField.text.toString())
                it.putExtra(RECRUITER_ZIP_CODE, if (binding.etPostalCode.text.isBlank())  "" else binding.etPostalCode.text.toString())
                it.putExtra(RECRUITER_EMAIL, if (binding.etEmailField.text.isBlank())  "" else binding.etEmailField.text.toString())
                it.putExtra(RECRUITER_PHONE_NUMBER, if (binding.etPhoneNumber.text.isBlank())  "" else binding.etPhoneNumber.text.toString())
                it.putExtra(RECRUITER_PROMO_CODE, if (binding.etInvitationCode.text.isBlank())  "" else binding.etInvitationCode.text.toString())
            })
        }
    }

    private fun addPhoneNumber() {
        personalInfoModel.phoneNumber = binding.ccp.selectedCountryCodeWithPlus + " " + binding.etPhoneNumber.text.toString()
    }

    override fun onSkipped() {
        startActivity(Intent(this, RecruiterHomeActivity::class.java))
        finish()
    }

    private fun validateFields(): Boolean {

        var validateFlag = true
        if (binding.tvGenderLabel.text.isEmpty()) {
            binding.tvGenderLabel.error = getString(R.string.enter_gender_here)
            validateFlag = false
        }

        if (binding.etFirstName.text.isEmpty()) {
            binding.etFirstName.error = getString(R.string.enter_first_name)
            validateFlag = false
        }

        if (binding.tvDateOfBirthField.text.isEmpty()) {
            binding.tvDateOfBirthField.error = getString(R.string.enter_date_of_birth)
            validateFlag = false
        }

        if (binding.tvGenderHint.text.isEmpty()) {
            binding.tvGenderHint.error = getString(R.string.enter_gender_here)
            validateFlag = false
        }

      /*  if (binding.etLastName.text.isEmpty()) {
            binding.etLastName.error = getString(R.string.enter_last_name)
            validateFlag = false
        }
*/
//        if (binding..text.isEmpty()) {
//            companyNameField.error = getString(R.string.enter_company_name)
//            validateFlag = false
//        }

//        if (binding.etPostalCode.text.isEmpty()) {
//            binding.etPostalCode.error = getString(R.string.enter_postcode)
//            validateFlag = false
//        }

        if (binding.etEmailField.text.isEmpty()) {
            binding.etEmailField.error = getString(R.string.enter_email)
            validateFlag = false
        } else if (!binding.etEmailField.text.toString().trim().isValidEmail()) {
            binding.etEmailField.error = getString(R.string.enter_valid_email)
            validateFlag = false
        }

        if (binding.etPhoneNumber.text.isEmpty()) {
            binding.etPhoneNumber.error = getString(R.string.enter_phone_number)
            validateFlag = false
        } else if ((binding.etPhoneNumber.text.toString()
                .trim().length + ccp.selectedCountryCodeWithPlus.length) <= 10
        ) {
            toast(getString(R.string.enter_valid_phone_number))
            binding.etPhoneNumber.error = getString(R.string.enter_valid_phone_number)
            validateFlag = false
        }


        return validateFlag
    }


    override fun onBackClicked() = super.onBackPressed()


    companion object {
        val RECRUITER_FIRST_NAME = "recruiter_first_name"
        val RECRUITER_LAST_NAME = "recruiter_last_name"
        val RECRUITER_GENDER = "recruiter_gender"
        val RECRUITER_DOB = "recruiter_dob"
        val RECRUITER_ZIP_CODE = "recruiter_zip_code"
        val RECRUITER_EMAIL = "recruiter_email"
        val RECRUITER_PHONE_NUMBER = "recruiter_phone_number"
        val RECRUITER_PROMO_CODE = "recruiter_promo_code"
    }


}


interface RecruiterPersonalInfoIntroInterface {

    fun onGenderClicked(view: View)

    fun onDobClicked()

    fun onSubmitClicked()

    fun onSkipped()

    fun onBackClicked()

}