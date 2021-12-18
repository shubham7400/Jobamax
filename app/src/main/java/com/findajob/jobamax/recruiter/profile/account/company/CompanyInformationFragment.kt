package com.findajob.jobamax.recruiter.profile.account.company

import android.os.Bundle
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.GridLayoutManager
import com.findajob.jobamax.R
import com.findajob.jobamax.base.BaseFragmentMain
import com.findajob.jobamax.databinding.FragmentCompanyInformationBinding
import com.findajob.jobamax.model.Company
import com.findajob.jobamax.recruiter.home.RecruiterHomeViewModel
import com.findajob.jobamax.recruiter.profile.account.company.adapter.CompanySize
import com.findajob.jobamax.recruiter.profile.account.company.adapter.CompanySizeAdapter
import com.findajob.jobamax.repo.SaveParseObjectCallback
import com.findajob.jobamax.util.toast

class CompanyInformationFragment : BaseFragmentMain<FragmentCompanyInformationBinding>(),
    CompanyInformationInterface {

    val viewModel: RecruiterHomeViewModel by activityViewModels()
    lateinit var company: Company
    private val companySizeAdapter: CompanySizeAdapter by lazy {
        CompanySizeAdapter()
    }

    override val layoutRes: Int
        get() = R.layout.fragment_company_information

    override fun onCreated(savedInstance: Bundle?) {
        company = viewModel.company
        binding.handler = this
        initFields()
    }

    override fun getViewModel(): ViewModel? {
        return viewModel
    }

    private fun initFields() {
        binding.companyData = company
        initCompanySize()
    }

    private fun initCompanySize() {
        companySizeAdapter.collection =
            resources.getStringArray(R.array.company_sizes).map { CompanySize(it, false) }
        binding.rvCompanySize.apply {
            layoutManager =
                GridLayoutManager(requireContext(), 2, GridLayoutManager.VERTICAL, false)
            adapter = companySizeAdapter
        }
        companySizeAdapter.selectedSize(company.companySize)
    }

    override fun onSubmitButtonClicked() {
        if (validateFields()) {
            showLoading(true)
            updateCompanyPayload()
            viewModel.updateCompany(company, object : SaveParseObjectCallback {
                override fun onFinish(isSuccessful: Boolean) {
                    showLoading(false)
                    if (isSuccessful) {
                        toast("Data Successfully Saved")
                        requireActivity().onBackPressed()
                    } else toast("Something went wrong")
                }
            })
        }
    }


    override fun onBackButtonClicked() {
        requireActivity().onBackPressed()
    }

    private fun validateFields(): Boolean {

        with(binding) {
            if (headquarterField.text.isEmpty()) {
                headquarterField.error = getString(R.string.enter_headquarter_address)
                toast(getString(R.string.enter_headquarter_address))
                return false
            }
            if (vatField.text.isEmpty()) {
                vatField.error = getString(R.string.enter_vat_number)
                toast(getString(R.string.enter_vat_number))
                return false
            }
            if (companyWebsite.text.isEmpty()) {
                toast(getString(R.string.enter_website_url))
                return false
            }
        }

        if (companySizeAdapter.selectedItem == null) {
            toast(getString(R.string.select_company_size))
            return false
        }

        return true
    }

    private fun updateCompanyPayload() {
        with(binding) {
            company.headquarterAddress = headquarterField.text.toString()
            company.vatNumber = vatField.text.toString()
            company.companyWebsite = companyWebsite.text.toString()

        }
        companySizeAdapter.selectedItem?.let {
            company.companySize = it.label
        }
    }


}

