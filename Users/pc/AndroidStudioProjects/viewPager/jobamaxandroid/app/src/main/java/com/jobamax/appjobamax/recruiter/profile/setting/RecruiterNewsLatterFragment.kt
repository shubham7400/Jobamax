package com.jobamax.appjobamax.recruiter.profile.setting

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.jobamax.appjobamax.R
import com.jobamax.appjobamax.base.BaseFragment
import com.jobamax.appjobamax.databinding.FragmentRecruiterNewsLatterBinding
import com.jobamax.appjobamax.enums.ParseCloudFunction
import com.jobamax.appjobamax.enums.ParseTableFields
import com.jobamax.appjobamax.extensions.toast
import com.jobamax.appjobamax.jobseeker.view_model.SeekerHomeViewModel
import com.jobamax.appjobamax.model.JobSeeker
import com.jobamax.appjobamax.model.Recruiter
import com.jobamax.appjobamax.recruiter.RecruiterHomeActivity
import com.jobamax.appjobamax.recruiter.RecruiterHomeViewModel
import com.parse.FunctionCallback
import com.parse.ParseCloud

class RecruiterNewsLatterFragment : BaseFragment() {
    lateinit var binding: FragmentRecruiterNewsLatterBinding

    val viewModel: RecruiterHomeViewModel by activityViewModels()
    lateinit var recruiter: Recruiter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentRecruiterNewsLatterBinding.inflate(inflater, container, false)
        configureUi()
        return binding.root
    }

    private fun configureUi() {
        setClickListeners()
        setObserver()
        initializeRecruiter()
        setNewsLatterToggle()
        setData()
    }


    private fun initializeRecruiter() {
        recruiter = viewModel.recruiter
        if (viewModel.recruiterObject == null) {
            (requireActivity() as RecruiterHomeActivity).getRecruiter {
                if (it) {
                    recruiter = viewModel.recruiter
                    setData()
                }
            }
        }
    }

    private fun setData() {
        binding.scNewsLatter.isChecked = recruiter.newsLetterNotification
    }

    private fun setObserver() {
        viewModel.isRecruiterUpdated.observe(viewLifecycleOwner){
            if (it){
                recruiter = viewModel.recruiter
                setData()
            }
        }
    }


    private fun setNewsLatterToggle() {
        binding.scNewsLatter.setOnClickListener {
            val request = hashMapOf<String, Any>(
                ParseTableFields.FIRST_NAME.value to recruiter.firstName,
                ParseTableFields.LAST_NAME.value to recruiter.lastName,
                ParseTableFields.EMAIL.value to recruiter.email,
                ParseTableFields.TYPE.value to 4,
            )
            if (binding.scNewsLatter.isChecked) {
                connectWithNewsLatter(request)
            } else {
                disconnectWithNewsLatter(request)
            }
        }
    }

    private fun disconnectWithNewsLatter(request: HashMap<String, Any>) {
        progressHud.show()
        ParseCloud.callFunctionInBackground(ParseCloudFunction.REMOVE_EMAIL_V1.value, request, FunctionCallback<Any> { result, e ->
            progressHud.dismiss()
            if (e != null) {
                toast("${e.message.toString()} Something went wrong")
            }
            if (result != null) {
                viewModel.recruiterObject?.let {
                    it.put(ParseTableFields.NEWS_LETTER_NOTIFICATION.value, false)
                    it.saveInBackground { exception ->
                        if (exception != null) {
                            toast("${exception.message.toString()} Something went wrong")
                            binding.scNewsLatter.isChecked = false
                            it.put(ParseTableFields.NEWS_LETTER_NOTIFICATION.value, true)
                        }
                    }
                }
            }
        })
    }

    private fun connectWithNewsLatter(request: HashMap<String, Any>) {
        progressHud.show()
        ParseCloud.callFunctionInBackground(ParseCloudFunction.TRIGGER_ZAP.value, request, FunctionCallback<Any> { result, e ->
            progressHud.dismiss()
            if (e != null) {
                toast("${e.message.toString()} Something went wrong")
            }
            if (result != null) {
                viewModel.recruiterObject?.let {
                    it.put(ParseTableFields.NEWS_LETTER_NOTIFICATION.value, true)
                    it.saveInBackground { exception ->
                        if (exception != null) {
                            toast("${exception.message.toString()} Something went wrong")
                            binding.scNewsLatter.isChecked = false
                            it.put(ParseTableFields.NEWS_LETTER_NOTIFICATION.value, false)
                        }
                    }
                }
            }
        })
    }

    private fun setClickListeners() {
        binding.ivBackButton.setOnClickListener { requireActivity().onBackPressed() }
    }

}