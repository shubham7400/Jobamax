package com.findajob.jobamax.jobseeker.profile.idealjob

import android.os.Bundle
 import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import com.findajob.jobamax.R
import com.findajob.jobamax.base.BaseFragmentMain
import com.findajob.jobamax.data.pojo.IdealJob
import com.findajob.jobamax.databinding.FragmentIdealJobDescriptionBinding
  import com.findajob.jobamax.enums.ParseTableFields
import com.findajob.jobamax.enums.ParseTableName
import com.findajob.jobamax.jobseeker.home.JobSeekerHomeViewModel
import com.findajob.jobamax.util.log
import com.findajob.jobamax.util.toast
import com.parse.ParseObject
import com.parse.ParseQuery
import kotlinx.android.synthetic.main.fragment_job_search.*


class IdealJobDescriptionFragment : BaseFragmentMain<FragmentIdealJobDescriptionBinding>(), IOnBackPressed {

    override val layoutRes: Int get() = R.layout.fragment_ideal_job_description
    val viewModel: JobSeekerHomeViewModel by activityViewModels()
    override fun getViewModel(): ViewModel = viewModel

    var idealJob: IdealJob? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentIdealJobDescriptionBinding.inflate(inflater, container, false)
        configureUi()
        return binding.root
    }

    private fun configureUi() {
        getIdealJobData()
        setClickListeners()
    }

    private fun setClickListeners() {
        binding.ivBackButton.setOnClickListener {
            requireActivity().onBackPressed()
        }
        binding.civUser.setOnClickListener {
            requireActivity().finish()
        }
    }



    private fun getIdealJobData() {

       idealJob = viewModel.jobSeeker.idealJob?.let {
            IdealJob(it)
        }
        if (idealJob == null){
            val parseObject = ParseObject(ParseTableName.IdealJob.toString())
            idealJob = IdealJob(parseObject)
            idealJob!!.pfObject?.let { viewModel.jobSeeker.pfObject?.put("idealJob", it) }
            viewModel.jobSeeker.pfObject?.saveInBackground()
        }

        idealJob?.let {
            binding.etIdealJobDescription.setText(idealJob!!.text)
        }

    }

    private fun saveDataToParse(callback : () -> Unit) {
        idealJob?.pfObject?.put("text", binding.etIdealJobDescription.text?.toString() ?: "")
        idealJob?.pfObject?.saveInBackground {
            if (it != null){
                log(it.message.toString())
            }else{
                callback()
            }
        }
    }

    override fun onCreated(savedInstance: Bundle?) {
        binding.jobSeeker = viewModel.jobSeeker
    }

    override fun onBackPressed(callback: () -> Unit) {
        saveDataToParse {
            callback()
        }
    }

}

interface IOnBackPressed {
    fun onBackPressed(callback : () -> Unit)
}