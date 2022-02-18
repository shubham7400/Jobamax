package com.findajob.jobamax.jobseeker.profile.portfolio

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import com.findajob.jobamax.R
import com.findajob.jobamax.base.BaseFragmentMain
import com.findajob.jobamax.data.pojo.Portfolio
import com.findajob.jobamax.databinding.FragmentPortfolioDescriptionBinding
import com.findajob.jobamax.enums.ParseTableFields
import com.findajob.jobamax.enums.ParseTableName
import com.findajob.jobamax.jobseeker.home.JobSeekerHomeViewModel
import com.findajob.jobamax.jobseeker.profile.idealjob.IOnBackPressed
import com.findajob.jobamax.util.toast
import com.parse.ParseObject
import com.parse.ParseQuery


class PortfolioDescriptionFragment : BaseFragmentMain<FragmentPortfolioDescriptionBinding>(), IOnBackPressed {

    override val layoutRes: Int get() = R.layout.fragment_portfolio_description
    val viewModel: JobSeekerHomeViewModel by activityViewModels()
    override fun getViewModel(): ViewModel = viewModel

    var portfolio: Portfolio? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentPortfolioDescriptionBinding.inflate(inflater, container, false)
        configureUi()
        return binding.root
    }

    private fun configureUi() {
        setClickListeners()
    }

    private fun setClickListeners() {
        binding.ivBackButton.setOnClickListener {
            requireActivity().onBackPressed()
        }
    }

    private fun getPortfolioData() {
        val query = ParseQuery.getQuery<ParseObject>(ParseTableName.Portfolio.toString())
        query.whereEqualTo(ParseTableFields.jobSeeker.toString(), viewModel.jobSeeker.pfObject)
        query.include("jobSeeker")
        progressHud.show()
        query.getFirstInBackground { result, e ->
            progressHud.dismiss()
            when {
                e != null -> {
                    toast("${e.message.toString()}")
                }
                result != null -> {
                    portfolio = Portfolio(result)
                    binding.etPortfolioDescription.setText(portfolio!!.text)
                }
            }
        }
    }

    private fun saveDataToParse(callback : () -> Unit) {
        portfolio?.let {
            if (portfolio == null){
                val portfolioParseObject = ParseObject(ParseTableName.Portfolio.toString())
                viewModel.jobSeeker.pfObject?.let { it1 ->
                    portfolioParseObject.put("jobSeeker", it1)
                }
                portfolioParseObject.put("text", if(binding.etPortfolioDescription.text.isNullOrEmpty()) "" else binding.etPortfolioDescription.text.toString())
                progressHud.show()
                portfolioParseObject.saveInBackground {
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
                val portfolioParseObject = portfolio!!.pfObject
                portfolioParseObject?.let {
                    viewModel.jobSeeker.pfObject?.let { it1 -> it.put("jobSeeker", it1) }
                    it.put("text", if(binding.etPortfolioDescription.text.isNullOrEmpty()) "" else binding.etPortfolioDescription.text.toString())
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
    }


    override fun onCreated(savedInstance: Bundle?) {
        getPortfolioData()
        binding.jobSeeker = viewModel.jobSeeker
    }

    override fun onBackPressed(callback: () -> Unit) {
        saveDataToParse {
            callback()
        }
    }

}