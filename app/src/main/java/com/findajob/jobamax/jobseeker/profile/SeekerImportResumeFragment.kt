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
import com.findajob.jobamax.jobseeker.home.JobSeekerHomeViewModel
import com.findajob.jobamax.model.JobSeeker
import com.findajob.jobamax.util.toast
import com.parse.FunctionCallback
import com.parse.ParseCloud
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
        binding.btnImportResume.setOnClickListener {
            if (binding.etLink.text.isNullOrEmpty()){
                toast("Please Enter the link first.")
            }else{
                progressHud.show()
                ParseCloud.callFunctionInBackground("importFromLinkedIn", hashMapOf("link" to binding.etLink.text.toString(), "jobSeekerId" to jobSeeker!!.jobSeekerId),
                    FunctionCallback<Any> { result, e ->
                        progressHud.dismiss()
                        when {
                            e != null -> {
                                toast("${e.message.toString()}")
                            }
                            result != null -> {
                                toast("Resume Imported Successfully.")
                               requireActivity().onBackPressed()
                            }
                        }
                    }
                )
            }
        }
    }

    override fun onCreated(savedInstance: Bundle?) {
        setClickListeners()
    }

    private fun setClickListeners() {
        binding.ivBackButton.setOnClickListener {
            requireActivity().onBackPressed()
        }
    }

}