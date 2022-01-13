package com.findajob.jobamax.recruiter.profile.account.companyInfo

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import com.findajob.jobamax.MainActivity
import com.findajob.jobamax.R
import com.findajob.jobamax.base.BaseActivityMain
import com.findajob.jobamax.databinding.ActivityCompanyIntroInfoBinding
import com.findajob.jobamax.dialog.RegistrationSuccessfulDialog
import com.findajob.jobamax.dialog.multiChoice.BasicDialog
import com.findajob.jobamax.enums.LoginType
import com.findajob.jobamax.enums.ParseTableName
import com.findajob.jobamax.extensions.observe
import com.findajob.jobamax.login.LoginActivity
import com.findajob.jobamax.model.Company
import com.findajob.jobamax.model.Recruiter
import com.findajob.jobamax.preference.*
import com.findajob.jobamax.recruiter.home.RecruiterHomeViewModel
import com.findajob.jobamax.recruiter.profile.account.personalInfo.RecruiterPersonalInfoIntroActivity
import com.findajob.jobamax.recruiter.profile.account.personalInfo.RecruiterPersonalInformationModel
import com.findajob.jobamax.util.errorToast
import com.findajob.jobamax.util.log
import com.findajob.jobamax.util.toast
import com.google.firebase.dynamiclinks.ktx.androidParameters
import com.google.firebase.dynamiclinks.ktx.dynamicLink
import com.google.firebase.dynamiclinks.ktx.dynamicLinks
import com.google.firebase.ktx.Firebase
import com.parse.ParseCloud
import com.parse.ParseObject
import com.parse.ParseQuery
import dagger.hilt.android.AndroidEntryPoint
import java.util.*

@AndroidEntryPoint
class CompanyIntroInfoActivity : BaseActivityMain<ActivityCompanyIntroInfoBinding>(),
    CompanyIntroInfoHandler {

    val viewModel: RecruiterHomeViewModel by viewModels()
    lateinit var company: Company

    private lateinit var personalInfoModel: RecruiterPersonalInformationModel

    override val layoutRes: Int get() = R.layout.activity_company_intro_info

    override fun getViewModel(): ViewModel = viewModel

    override fun onCreated(instance: Bundle?) {
        configureViewModel()
        initViews()
        initFields()
        subscribe()
    }

    private fun subscribe() {
        observe(viewModel.companyDataSaveListener) {
            it?.let { isSuccessful ->
                progressHud.dismiss()
                if (isSuccessful) {
                    showSuccessDialog()
                } else toast("Could not save your company data")
            }
        }
    }

    private fun initFields() {
        company.apply {
            binding.apply {
                if (name.isNotEmpty()) etCompanyNameField.setText(name)
                if (companyWebsite.isNotEmpty()) etCompanyWebsiteField.setText(companyWebsite)
                if (position.isNotEmpty()) etPositionField.setText(position)
                if (headquarterAddress.isNotEmpty()) etHeadquartersField.setText(headquarterAddress)
                if (vatNumber.isNotEmpty()) etVatNumberField.setText(vatNumber)
                if (companyWebsite.isNotEmpty()) etCompanyWebsiteField.setText(companyWebsite)
            }
        }

        when (company.companySize) {
            binding.rb1To10.text -> binding.rb1To10.isChecked = true
            binding.rb11To50.text -> binding.rb11To50.isChecked = true
            binding.rb51To199.text -> binding.rb51To199.isChecked = true
            binding.rb200To500.text -> binding.rb200To500.isChecked = true
            binding.rb500More.text -> binding.rb500More.isChecked = true
        }

    }

    private fun initViews() {
        binding.handler = this
        personalInfoModel = RecruiterPersonalInformationModel()
        personalInfoModel.firstName = intent.getStringExtra(RecruiterPersonalInfoIntroActivity.RECRUITER_FIRST_NAME).toString()
        personalInfoModel.lastName = intent.getStringExtra(RecruiterPersonalInfoIntroActivity.RECRUITER_LAST_NAME).toString()
        personalInfoModel.gender = intent.getStringExtra(RecruiterPersonalInfoIntroActivity.RECRUITER_GENDER).toString()
        personalInfoModel.email = intent.getStringExtra(RecruiterPersonalInfoIntroActivity.RECRUITER_EMAIL).toString()
        personalInfoModel.dob = intent.getStringExtra(RecruiterPersonalInfoIntroActivity.RECRUITER_DOB).toString()
        personalInfoModel.postCode = intent.getStringExtra(RecruiterPersonalInfoIntroActivity.RECRUITER_ZIP_CODE).toString()
        personalInfoModel.phoneNumber = intent.getStringExtra(RecruiterPersonalInfoIntroActivity.RECRUITER_PHONE_NUMBER).toString()
        personalInfoModel.postCode = intent.getStringExtra(RecruiterPersonalInfoIntroActivity.RECRUITER_PROMO_CODE).toString()
    }

    private fun configureViewModel() {
//        viewModel = ViewModelProvider(this).get(RecruiterHomeViewModel::class.java)
        company = viewModel.company
    }

    private fun validateFields(): Boolean {

        if (binding.etCompanyNameField.text.isNullOrEmpty()) {
            binding.etCompanyNameField.error = "Specify the name of your company"
            return false
        }
        if (binding.etPositionField.text.isNullOrEmpty()) {
            binding.etPositionField.error = "Specify the position"
            return false
        }
        if (binding.etHeadquartersField.text.isNullOrEmpty()) {
            binding.etHeadquartersField.error = "Specify the headquarter of your company"
            return false
        }
        return true
    }

    private fun saveCompanyData() {
        binding.apply {
            when (rgCompanySizeOptions.checkedRadioButtonId) {
                R.id.rb_1_to_10 -> company.companySize = binding.rb1To10.text.toString()
                R.id.rb_11_to_50 -> company.companySize = binding.rb11To50.text.toString()
                R.id.rb_51_to_199 -> company.companySize = binding.rb51To199.text.toString()
                R.id.rb_200_to_500 -> company.companySize = binding.rb200To500.text.toString()
                R.id.rb_500_more -> company.companySize = binding.rb500More.text.toString()
            }

            company.companyWebsite = binding.etCompanyWebsiteField.text.toString()
            company.headquarterAddress = binding.etHeadquartersField.text.toString()
            company.name = binding.etCompanyNameField.text.toString()
            company.vatNumber = binding.etVatNumberField.text.toString()
            company.position = binding.etPositionField.text.toString()
        }

    }

    override fun onBackClicked() = super.onBackPressed()

    override fun onSubmitClicked() {

        if (validateFields()) {
            progressHud.show()
            val recruiter = Recruiter()
            recruiter.recruiterId = UUID.randomUUID().toString()
            recruiter.firstName = personalInfoModel.firstName
            recruiter.lastName = personalInfoModel.lastName
            recruiter.gender = personalInfoModel.gender
            recruiter.dob = personalInfoModel.dob
            recruiter.postCode = personalInfoModel.postCode
            recruiter.email = personalInfoModel.email
            recruiter.phoneNumber = personalInfoModel.phoneNumber
            recruiter.password = getPassword()
            recruiter.loginType = getLoginType()
            recruiter.toParseObject().saveInBackground { parseException ->
                if (parseException != null){
                    toast(parseException.message.toString())
                }else{
                    saveCompanyData()
                    val companyParseObject = company.toParseObject()
                    companyParseObject.put("recruiterId",  getUserId())
                    companyParseObject.saveInBackground { exception ->
                        if (exception != null){
                            toast(exception.message.toString())
                        }else{
                            val query = ParseQuery.getQuery<ParseObject>(ParseTableName.Recruiter.toString())
                            query.whereEqualTo("recruiterId", recruiter.recruiterId)
                            query.getFirstInBackground { result, e ->
                                when{
                                    e != null -> {
                                        toast(e.message.toString())
                                    }
                                    /* result == null -> {
                                         toast("result not found")
                                     }*/
                                    result != null -> {
                                        result.put("company", companyParseObject)
                                        result.saveInBackground { exception ->
                                            if (exception == null) {
                                                sendEmailVerificationLink(recruiter)
                                            } else {
                                                toast("Something Went Wrong")
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } else errorToast()
    }

    private fun sendEmailVerificationLink(recruiter: Recruiter) {
        progressHud.show()
        val builder = Uri.Builder()
        builder.scheme("https")
            .authority("jobamax.page.link")
            .appendPath("verifyemail")
            .appendQueryParameter("userType", getUserType().toString())
            .appendQueryParameter("LoginType", LoginType.email.toString())
            .appendQueryParameter("recruiterId", recruiter.recruiterId)
        val myUrl: String = builder.build().toString()
        val dynamicLink = Firebase.dynamicLinks.dynamicLink {
            link = Uri.parse(myUrl)
            domainUriPrefix = "https://jobamax.page.link"
            androidParameters("com.findajob.jobamax") {
            }
        }
        val param = HashMap<String, String>()
        param["toEmail"] = getEmail()
        param["link"] = dynamicLink.uri.toString()
        ParseCloud.callFunctionInBackground<Any>("sendgridEmail", param) { obj, e ->
            progressHud.dismiss()
            if (e != null && obj == null) {
                toast("Something Went Wrong.")
            } else {
                BasicDialog(this, "An email with verification link is sent to:\n ${getEmail()}", true) {
                    startActivity(Intent(this, MainActivity::class.java))
                    finishAffinity()
                }.also {
                    it.setCancelable(false)
                }.show()
            }
        }
    }

    private fun showSuccessDialog() {
        val dialog = RegistrationSuccessfulDialog(this) {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
        dialog.setCancelable(false)
        dialog.show()
    }
}

interface CompanyIntroInfoHandler {
    fun onBackClicked()

    fun onSubmitClicked()
}