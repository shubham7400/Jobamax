package com.jobamax.appjobamax.jobseeker.profile.account.newsletter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.jobamax.appjobamax.base.BaseFragment
import com.jobamax.appjobamax.databinding.FragmentJobSeekerNewsletterBinding
import com.jobamax.appjobamax.enums.ParseCloudFunction
import com.jobamax.appjobamax.enums.ParseTableFields
import com.jobamax.appjobamax.extensions.toast
import com.jobamax.appjobamax.jobseeker.profile.account.SeekerSettingActivity
import com.jobamax.appjobamax.jobseeker.view_model.SeekerHomeViewModel
import com.jobamax.appjobamax.model.JobSeeker
import com.parse.FunctionCallback
import com.parse.ParseCloud
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class JobSeekerNewsletterFragment : BaseFragment()  {
    lateinit var binding: FragmentJobSeekerNewsletterBinding

    val viewModel: SeekerHomeViewModel by activityViewModels()
    lateinit var jobSeeker: JobSeeker


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentJobSeekerNewsletterBinding.inflate(inflater, container, false)
        configureUi()
        return binding.root
    }

    private fun configureUi() {
        setClickListeners()
        setObserver()
        setJobSeeker()
        setNewsLatterToggle()
        setData()
    }

    private fun setNewsLatterToggle() {
        binding.scNewsLatter.setOnClickListener {
            val request = hashMapOf<String, Any>(
                ParseTableFields.FIRST_NAME.value to jobSeeker.firstName,
                ParseTableFields.LAST_NAME.value to jobSeeker.lastName,
                ParseTableFields.EMAIL.value to jobSeeker.email,
                ParseTableFields.TYPE.value to 3,
            )
            if (binding.scNewsLatter.isChecked) {
                connectWithNewsLatter(request)
            } else {
                disconnectWithNewsLatter(request)
            }
        }
    }

    private fun setJobSeeker() {
        jobSeeker = viewModel.jobSeeker
        if (viewModel.jobSeekerObject == null) {
            (requireActivity() as SeekerSettingActivity  ).getJobSeeker {
                if (it) {
                    jobSeeker = viewModel.jobSeeker
                    setData()
                }
            }
        }
    }

    private fun setObserver() {
        viewModel.isJobSeekerUpdated.observe(viewLifecycleOwner){
            if (it){
                jobSeeker = viewModel.jobSeeker
                setData()
            }
        }
    }

    private fun setData() {
        binding.scNewsLatter.isChecked = jobSeeker.receiveNewsletter
    }

    private fun disconnectWithNewsLatter(request: HashMap<String, Any>) {
        progressHud.show()
        ParseCloud.callFunctionInBackground(ParseCloudFunction.REMOVE_EMAIL_V1.value, request, FunctionCallback<Any> { result, e ->
            progressHud.dismiss()
            if (e != null) {
                toast("${e.message.toString()} Something went wrong")
            }
            if (result != null) {
                viewModel.jobSeekerObject?.let {
                    it.put(ParseTableFields.RECEIVE_NEWS_LETTER.value, false)
                    it.saveInBackground { exception ->
                        if (exception != null) {
                            toast("${exception.message.toString()} Something went wrong")
                            binding.scNewsLatter.isChecked = false
                            it.put(ParseTableFields.RECEIVE_NEWS_LETTER.value, true)
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
                viewModel.jobSeekerObject?.let {
                    it.put(ParseTableFields.RECEIVE_NEWS_LETTER.value, true)
                    it.saveInBackground { exception ->
                        if (exception != null) {
                            toast("${exception.message.toString()} Something went wrong")
                            binding.scNewsLatter.isChecked = false
                            it.put(ParseTableFields.RECEIVE_NEWS_LETTER.value, false)
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
