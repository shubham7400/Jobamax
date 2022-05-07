package com.findajob.jobamax.jobseeker.coaching

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation
import com.findajob.jobamax.R
import com.findajob.jobamax.base.BaseFragmentMain
import com.findajob.jobamax.databinding.FragmentSeekerCoachingBinding
import com.findajob.jobamax.enums.ParseTableFields
import com.findajob.jobamax.enums.ParseTableName
import com.findajob.jobamax.jobseeker.home.JobSeekerHomeViewModel
import com.findajob.jobamax.preference.getUserId
import com.findajob.jobamax.util.toast
import com.parse.ParseObject
import com.parse.ParseQuery
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SeekerCoachingFragment : BaseFragmentMain<FragmentSeekerCoachingBinding>() {

    override val layoutRes: Int get() = R.layout.fragment_seeker_coaching
    val viewModel: JobSeekerHomeViewModel by activityViewModels()
    override fun getViewModel(): ViewModel = viewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentSeekerCoachingBinding.inflate(inflater, container, false)
        configureUi()
        return binding.root
    }

    private fun configureUi() {
         setClickListeners()
        viewModelObserver()
    }

    private fun viewModelObserver() {
        viewModel.isJobSeekerUpdated.observe(viewLifecycleOwner) {
            progressHud.dismiss()
            if (it) {
                binding.jobSeeker = viewModel.jobSeeker
            }
        }
    }


    private fun setClickListeners() {
        binding.ivBackButton.setOnClickListener {
            requireActivity().onBackPressed()
        }
        binding.civUser.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_seekerCoachingFragment_to_nav_seeker_profile, null))
        binding.btnContact.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND)
            intent.putExtra(Intent.EXTRA_EMAIL, arrayOf("support@jobamax.com"))
            intent.putExtra(Intent.EXTRA_TEXT, "Write a message to one of our career coaches!")
            intent.type = "message/rfc822"

            startActivity(Intent.createChooser(intent, "Choose an Email client :"))
        }
    }

    override fun onCreated(savedInstance: Bundle?) {
        if (viewModel.jobSeekerObject == null){
            getCurrent()
        }
        binding.jobSeeker = viewModel.jobSeeker
    }

    fun getCurrent( ) {
        val query = ParseQuery.getQuery<ParseObject>(ParseTableName.JobSeeker.toString())
        query.whereEqualTo(ParseTableFields.jobSeekerId.toString(), context?.getUserId())
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
        }
    }


}