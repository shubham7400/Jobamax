package com.jobamax.appjobamax.jobseeker.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import com.jobamax.appjobamax.R
import com.jobamax.appjobamax.base.BaseFragmentMain
import com.jobamax.appjobamax.databinding.FragmentSeekerImportResumeBinding
import com.jobamax.appjobamax.enums.ParseCloudFunction
import com.jobamax.appjobamax.enums.ParseTableFields
import com.jobamax.appjobamax.enums.ParseTableName
import com.jobamax.appjobamax.jobseeker.home.JobSeekerHomeViewModel
import com.jobamax.appjobamax.model.JobSeeker
import com.jobamax.appjobamax.preference.getUserId
import com.jobamax.appjobamax.util.toast
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
                ParseCloud.callFunctionInBackground(ParseCloudFunction.IMPORT_FROM_LINKEDIN.value, hashMapOf("link" to binding.etLink.text.toString().trim(), "jobSeekerId" to requireContext().getUserId()),
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
        val query = ParseQuery.getQuery<ParseObject>(ParseTableName.JOB_SEEKER.value)
        query.whereEqualTo(ParseTableFields.JOB_SEEKER_ID.value,  requireContext().getUserId())
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