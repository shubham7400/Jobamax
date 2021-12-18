package com.findajob.jobamax.recruiter.profile.account.invoices

import android.os.Bundle
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import com.findajob.jobamax.R
import com.findajob.jobamax.base.BaseFragmentMain
import com.findajob.jobamax.databinding.FragmentRecruiterInvoicesBinding
import com.findajob.jobamax.recruiter.home.RecruiterHomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RecruiterInvoicesFragment : BaseFragmentMain<FragmentRecruiterInvoicesBinding>(),
    RecruiterInvoicesInterface {

    val viewModel: RecruiterHomeViewModel by activityViewModels()
    override fun getViewModel(): ViewModel = viewModel

    private lateinit var paymentHistoryAdapter: PaymentHistoryAdapter

    override fun onBackButtonClicked() {
        requireActivity().onBackPressed()
    }

    private fun subscribeObserver() {
        viewModel.loadPaymentHistory()
        viewModel.getPaymentHistoryObserver().observe(viewLifecycleOwner, {
            progressHud.dismiss()
            paymentHistoryAdapter.notifyListChanged(it)
        })
    }

    override val layoutRes: Int
        get() = R.layout.fragment_recruiter_invoices

    override fun onCreated(savedInstance: Bundle?) {
        initViews()
        subscribeObserver()
    }

    private fun initViews() {
        progressHud.show()
        setHasOptionsMenu(true)
        paymentHistoryAdapter = PaymentHistoryAdapter {}
        binding.handler = this
        binding.rvLocationList.layoutManager = LinearLayoutManager(requireContext())
        binding.rvLocationList.adapter = paymentHistoryAdapter
    }


}