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
 import com.findajob.jobamax.util.toast
import com.parse.ParseObject
import com.parse.ParseQuery


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
    }

    private fun takeBack() {

    }

    private fun getIdealJobData() {
        val query = ParseQuery.getQuery<ParseObject>(ParseTableName.IdealJob.toString())
        query.whereEqualTo(ParseTableFields.jobSeeker.toString(), viewModel.jobSeeker.pfObject)
        query.include("jobSeeker")
        query.getFirstInBackground { result, e ->
            when {
                e != null -> {
                    toast("${e.message.toString()}")
                }
                result != null -> {
                    idealJob = IdealJob(result)
                    binding.etIdealJobDescription.setText(idealJob!!.text)
                }
            }
        }
    }

    private fun saveDataToParse(callback : () -> Unit) {
        if (idealJob == null){
            val idealJobParseObject = ParseObject(ParseTableName.IdealJob.toString())
            viewModel.jobSeeker.pfObject?.let { it1 ->
                idealJobParseObject.put("jobSeeker", it1)
            }
            idealJobParseObject.put("text", if(binding.etIdealJobDescription.text.isNullOrEmpty()) "" else binding.etIdealJobDescription.text.toString())
            progressHud.show()
            idealJobParseObject  .saveInBackground {
                progressHud.dismiss()
                if(it != null){
                    toast("${it.message.toString()}")
                    callback()
                }else{
                    /*toast("Data saved.")*/
                    callback()
                }
            }
        }else{
            val portfolioParseObject = idealJob!!.pfObject
            portfolioParseObject?.let {
                viewModel.jobSeeker.pfObject?.let { it1 -> it.put("jobSeeker", it1) }
                it.put("text", if(binding.etIdealJobDescription.text.isNullOrEmpty()) "" else binding.etIdealJobDescription.text.toString())
            }
            progressHud.show()
            portfolioParseObject?.saveInBackground {
                progressHud.dismiss()
                if(it != null){
                    toast("${it.message.toString()}")
                    callback()
                }else{
                    /*toast("Data saved.")*/
                    callback()
                }
            }
        }
    }

    override fun onCreated(savedInstance: Bundle?) {
        binding.jobSeeker = viewModel.jobSeeker
    }

    override fun onBackPressed(call: () -> Unit) {
        saveDataToParse {
            call()
        }
    }

}

interface IOnBackPressed {
    fun onBackPressed(callback : () -> Unit)
}