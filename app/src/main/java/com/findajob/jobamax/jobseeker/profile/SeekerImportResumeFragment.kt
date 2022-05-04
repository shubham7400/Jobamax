package com.findajob.jobamax.jobseeker.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import com.findajob.jobamax.R
import com.findajob.jobamax.base.BaseFragmentMain
import com.findajob.jobamax.databinding.FragmentSeekerImportResumeBinding
import com.findajob.jobamax.enums.ParseCloudFunction
import com.findajob.jobamax.enums.ParseTableFields
import com.findajob.jobamax.enums.ParseTableName
import com.findajob.jobamax.jobseeker.home.JobSeekerHomeViewModel
import com.findajob.jobamax.model.JobSeeker
import com.findajob.jobamax.preference.getUserId
import com.findajob.jobamax.util.toast
import com.parse.FunctionCallback
import com.parse.ParseCloud
import com.parse.ParseObject
import com.parse.ParseQuery
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SeekerImportResumeFragment : BaseFragmentMain<FragmentSeekerImportResumeBinding>() {

    override val layoutRes: Int get() = R.layout.fragment_seeker_import_resume
    val viewModel: JobSeekerHomeViewModel by activityViewModels()
    override fun getViewModel(): ViewModel = viewModel

    var jobSeeker: JobSeeker? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentSeekerImportResumeBinding.inflate(inflater, container, false)
        configureUi()
        return binding.root
    }

    private fun configureUi() {
        jobSeeker = viewModel.jobSeeker
        binding.jobSeeker = viewModel.jobSeeker
        binding.btnImportResume.setOnClickListener {
            if (binding.etLink.text.isNullOrEmpty()){
                toast("Please Enter the link first.")
            }else{
                progressHud.show()
                ParseCloud.callFunctionInBackground(ParseCloudFunction.importFromLinkedIn.toString(), hashMapOf("link" to binding.etLink.text.toString().trim(), "jobSeekerId" to requireContext().getUserId()),
                    FunctionCallback<Any> { result, e ->
                        progressHud.dismiss()
                        when {
                            e != null -> {
                                toast("${e.message.toString()}")
                            }
                            result != null -> {
                                toast("Resume Imported Successfully.")
                                getCurrent()
                            }
                        }
                    }
                )
            }
        }
    }

    private fun getCurrent() {
        val query = ParseQuery.getQuery<ParseObject>(ParseTableName.JobSeeker.toString())
        query.whereEqualTo(ParseTableFields.jobSeekerId.toString(),  requireContext().getUserId())
        query.include("portfolio")
        query.include("idealJob")
        progressHud.show()
        query.findInBackground { it, e ->
            progressHud.dismiss()
            val jobSeeker = it?.firstOrNull()
            when {
                e != null -> {
                    toast(e.message.toString())
                }
                jobSeeker == null -> {
                    toast("User Not Found.")
                }
                else -> {
                    viewModel.jobSeekerObject = jobSeeker
                    viewModel.isJobSeekerUpdated.value = true
                }
            }
            requireActivity().onBackPressed()
        }
    }

    override fun onCreated(savedInstance: Bundle?) {
        setClickListeners()
    }

    private fun setClickListeners() {
        binding.ivBackButton.setOnClickListener {
            requireActivity().onBackPressed()
        }
        binding.civUser.setOnClickListener {
            requireActivity().onBackPressed()
        }
    }

}