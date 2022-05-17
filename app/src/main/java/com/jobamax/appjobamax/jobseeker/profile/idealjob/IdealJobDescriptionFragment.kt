package com.jobamax.appjobamax.jobseeker.profile.idealjob

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import com.jobamax.appjobamax.R
import com.jobamax.appjobamax.base.BaseFragmentMain
import com.jobamax.appjobamax.data.pojo.IdealJob
import com.jobamax.appjobamax.databinding.FragmentIdealJobDescriptionBinding
import com.jobamax.appjobamax.enums.ParseTableName
import com.jobamax.appjobamax.jobseeker.home.JobSeekerHomeViewModel
import com.jobamax.appjobamax.util.log
import com.parse.ParseObject


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
            requireActivity().onBackPressed()
        }
    }



    private fun getIdealJobData() {

       idealJob = viewModel.jobSeeker.idealJob?.let {
            IdealJob(it)
        }
        if (idealJob == null){
            val parseObject = ParseObject(ParseTableName.IDEAL_JOB.value)
            idealJob = IdealJob(parseObject)
            idealJob!!.pfObject?.let { viewModel.jobSeeker.pfObject?.put("idealJob", it) }
            viewModel.jobSeeker.pfObject?.saveInBackground()
        }

        idealJob?.let {
            binding.etIdealJobDescription.setText(idealJob!!.text)
            binding.tvTextSize.text = "${binding.etIdealJobDescription.text.length}/240"
        }

        binding.etIdealJobDescription.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                binding.tvTextSize.text = "${binding.etIdealJobDescription.text.length}/240"
            }
            override fun afterTextChanged(p0: Editable?) {}
        })
    }

    private fun saveDataToParse(/*callback : () -> Unit*/) {
        idealJob?.pfObject?.put("text", binding.etIdealJobDescription.text?.toString() ?: "")
        idealJob?.pfObject?.saveInBackground {
            if (it != null){
                log(it.message.toString())
            }else{
                /*callback()*/
            }
        }
    }

    override fun onCreated(savedInstance: Bundle?) {
        binding.jobSeeker = viewModel.jobSeeker
    }

    override fun onBackPressed(callback: () -> Unit) {
        saveDataToParse()
        callback()
    }

}

interface IOnBackPressed {
    fun onBackPressed(callback : () -> Unit)
}