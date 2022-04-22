package com.findajob.jobamax.jobseeker.track.newtrack

import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.fragment.app.DialogFragment
import com.findajob.jobamax.R
import com.findajob.jobamax.databinding.FragmentSeekerFilterJobBinding
import com.findajob.jobamax.databinding.FragmentSeekerTrackingJobFilterDialogBinding
import com.findajob.jobamax.enums.SeekerTrackingJobFilter
import com.findajob.jobamax.enums.SeekerWishlistJobFilter
import com.findajob.jobamax.jobseeker.wishlist.SeekerFilterJobFragment


class SeekerTrackingJobFilterDialogFragment : DialogFragment() {
    lateinit var binding: FragmentSeekerTrackingJobFilterDialogBinding
    var onGoClickListener: (SeekerTrackingJobFilter) -> Unit = {}
    var filteredJob = SeekerTrackingJobFilter.ALL
    var selectedFilter = ""

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentSeekerTrackingJobFilterDialogBinding.inflate(inflater, container, false)
        configureUi()
        return binding.root
    }
    private fun configureUi() {
        setSelectedFilter()
        setClickListeners()
    }

    private fun setSelectedFilter() {
        this.selectedFilter = arguments?.getString("selected_filter") ?: ""
        if (selectedFilter != "") {
            when (selectedFilter) {
                SeekerTrackingJobFilter.ALL.filterType -> {
                    binding.cbAll.isChecked = true
                }
                SeekerTrackingJobFilter.APPLIED.filterType -> {
                    binding.cbApplied.isChecked = true
                }
                SeekerTrackingJobFilter.REFUSED.filterType -> {
                    binding.cbRefused.isChecked = true
                }
                SeekerTrackingJobFilter.ONLINE_INTERVIEWS.filterType -> {
                    binding.cbOnlineIntervie.isChecked = true
                }
                SeekerTrackingJobFilter.ASSESSMENTS.filterType -> {
                    binding.cbAssessments.isChecked = true
                }
                SeekerTrackingJobFilter.PHONE_CALL.filterType -> {
                    binding.cbPhoneCall.isChecked = true
                }
                SeekerTrackingJobFilter.INTERVIEWS.filterType -> {
                    binding.cbInterview.isChecked = true
                }
                SeekerTrackingJobFilter.HIRED.filterType -> {
                    binding.cbHired.isChecked = true
                }
            }
        }
    }

    private fun setClickListeners() {
        binding.ivBackButton.setOnClickListener {
            dismiss()
        }
        binding.cbAll.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked){
                binding.cbInterview.isChecked = false
                binding.cbRefused.isChecked = false
                binding.cbPhoneCall.isChecked = false
                binding.cbApplied.isChecked = false
                binding.cbOnlineIntervie.isChecked = false
                binding.cbHired.isChecked = false
                binding.cbAssessments.isChecked = false
                filteredJob = SeekerTrackingJobFilter.ALL
            }
        }
        binding.cbApplied.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked){
                binding.cbAll.isChecked = false
                binding.cbInterview.isChecked = false
                binding.cbRefused.isChecked = false
                binding.cbPhoneCall.isChecked = false
                binding.cbOnlineIntervie.isChecked = false
                binding.cbHired.isChecked = false
                binding.cbAssessments.isChecked = false
                filteredJob = SeekerTrackingJobFilter.APPLIED
            }
        }
        binding.cbRefused.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked){
                binding.cbAll.isChecked = false
                binding.cbInterview.isChecked = false
                binding.cbPhoneCall.isChecked = false
                binding.cbApplied.isChecked = false
                binding.cbOnlineIntervie.isChecked = false
                binding.cbHired.isChecked = false
                binding.cbAssessments.isChecked = false
                filteredJob = SeekerTrackingJobFilter.REFUSED
            }
        }
        binding.cbOnlineIntervie.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked){
                binding.cbAll.isChecked = false
                binding.cbInterview.isChecked = false
                binding.cbRefused.isChecked = false
                binding.cbPhoneCall.isChecked = false
                binding.cbApplied.isChecked = false
                binding.cbHired.isChecked = false
                binding.cbAssessments.isChecked = false
                filteredJob = SeekerTrackingJobFilter.ONLINE_INTERVIEWS
            }
        }
        binding.cbAssessments.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked){
                binding.cbAll.isChecked = false
                binding.cbInterview.isChecked = false
                binding.cbRefused.isChecked = false
                binding.cbPhoneCall.isChecked = false
                binding.cbApplied.isChecked = false
                binding.cbOnlineIntervie.isChecked = false
                binding.cbHired.isChecked = false
                filteredJob = SeekerTrackingJobFilter.ASSESSMENTS
            }
        }
        binding.cbPhoneCall.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked){
                binding.cbAll.isChecked = false
                binding.cbInterview.isChecked = false
                binding.cbRefused.isChecked = false
                binding.cbApplied.isChecked = false
                binding.cbOnlineIntervie.isChecked = false
                binding.cbHired.isChecked = false
                binding.cbAssessments.isChecked = false
                filteredJob = SeekerTrackingJobFilter.PHONE_CALL
            }
        }
        binding.cbInterview.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked){
                binding.cbAll.isChecked = false
                binding.cbRefused.isChecked = false
                binding.cbPhoneCall.isChecked = false
                binding.cbApplied.isChecked = false
                binding.cbOnlineIntervie.isChecked = false
                binding.cbHired.isChecked = false
                binding.cbAssessments.isChecked = false
                filteredJob = SeekerTrackingJobFilter.INTERVIEWS
            }
        }
        binding.cbHired.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked){
                binding.cbAll.isChecked = false
                binding.cbInterview.isChecked = false
                binding.cbRefused.isChecked = false
                binding.cbPhoneCall.isChecked = false
                binding.cbApplied.isChecked = false
                binding.cbOnlineIntervie.isChecked = false
                binding.cbAssessments.isChecked = false
                filteredJob = SeekerTrackingJobFilter.HIRED
            }
        }

        binding.btnGo.setOnClickListener {
            onGoClickListener(filteredJob)
            dismiss()
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog: Dialog = super.onCreateDialog(savedInstanceState)
        dialog.window?.requestFeature(Window.FEATURE_NO_TITLE)
        return dialog
    }

    override fun onStart() {
        super.onStart()
        val dialog: Dialog? = dialog
        if (dialog != null) {
            dialog.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        }
    }

    companion object {
        fun newInstance(selectedFilter: SeekerTrackingJobFilter): SeekerTrackingJobFilterDialogFragment {
            val fragment = SeekerTrackingJobFilterDialogFragment()
            val args = Bundle()
            args.putString("selected_filter", selectedFilter.filterType)
            fragment.arguments = args
            return fragment
        }
    }
}