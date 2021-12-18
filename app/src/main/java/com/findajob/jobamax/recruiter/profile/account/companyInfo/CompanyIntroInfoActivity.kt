package com.findajob.jobamax.recruiter.profile.account.companyInfo

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.findajob.jobamax.R
import com.findajob.jobamax.base.BaseActivityMain
import com.findajob.jobamax.databinding.ActivityCompanyIntroInfoBinding
import com.findajob.jobamax.dialog.RegistrationSuccessfulDialog
import com.findajob.jobamax.extensions.observe
import com.findajob.jobamax.login.LoginActivity
import com.findajob.jobamax.model.Company
import com.findajob.jobamax.recruiter.home.RecruiterHomeViewModel
import com.findajob.jobamax.repo.SaveParseObjectCallback
import com.findajob.jobamax.util.errorToast
import com.findajob.jobamax.util.toast
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CompanyIntroInfoActivity : BaseActivityMain<ActivityCompanyIntroInfoBinding>(),
    CompanyIntroInfoHandler {

    val viewModel: RecruiterHomeViewModel by viewModels()
    lateinit var company: Company

    override val layoutRes: Int
        get() = R.layout.activity_company_intro_info

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
            saveCompanyData()
            viewModel.saveCompanyData(company)
        } else errorToast()
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