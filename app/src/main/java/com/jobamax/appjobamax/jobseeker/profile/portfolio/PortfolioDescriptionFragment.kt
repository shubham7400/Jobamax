package com.jobamax.appjobamax.jobseeker.profile.portfolio

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import com.jobamax.appjobamax.R
import com.jobamax.appjobamax.base.BaseFragmentMain
import com.jobamax.appjobamax.data.pojo.Portfolio
import com.jobamax.appjobamax.databinding.FragmentPortfolioDescriptionBinding
import com.jobamax.appjobamax.databinding.ItemPortfolioLinkBinding
import com.jobamax.appjobamax.enums.ParseTableName
import com.jobamax.appjobamax.jobseeker.home.JobSeekerHomeViewModel
import com.jobamax.appjobamax.jobseeker.profile.idealjob.IOnBackPressed
import com.jobamax.appjobamax.util.log
import com.jobamax.appjobamax.util.toast
import com.parse.ParseObject


class PortfolioDescriptionFragment : BaseFragmentMain<FragmentPortfolioDescriptionBinding>(), IOnBackPressed {

    override val layoutRes: Int get() = R.layout.fragment_portfolio_description
    val viewModel: JobSeekerHomeViewModel by activityViewModels()
    override fun getViewModel(): ViewModel = viewModel

    var portfolio: Portfolio? = null
    lateinit var adapter: PortfolioLinksAdapter

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
        binding.civUser.setOnClickListener {
            requireActivity().onBackPressed()
        }
        binding.ivAddLink.setOnClickListener {
            if (binding.etLink.text.isNullOrBlank()){
                toast("Please Enter link first.")
            }else{
                val links = portfolio?.links
                links?.add(binding.etLink.text.toString())
                portfolio?.pfObject?.put("links", links!! )
                portfolio?.pfObject?.saveInBackground {
                    if (it != null){
                        toast(it.message.toString())
                    }else{
                        portfolio = Portfolio(portfolio!!.pfObject!!)
                        adapter.submitList(portfolio!!.links)
                        adapter.notifyDataSetChanged()
                    }
                }

            }
        }
        binding.etPortfolioDescription.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                binding.tvTextSize.text = "${binding.etPortfolioDescription.text.length}/240"
            }
            override fun afterTextChanged(p0: Editable?) {}
        })
    }

    private fun getPortfolioData() {

        portfolio = viewModel.jobSeeker.portfolio?.let {
            Portfolio(it)
        }
        if (portfolio == null){
            val parseObject = ParseObject(ParseTableName.PORTFOLIO.value)
            portfolio = Portfolio(parseObject)
            portfolio!!.pfObject?.let { viewModel.jobSeeker.pfObject?.put("portfolio", it) }
            viewModel.jobSeeker.pfObject?.saveInBackground()
        }

        portfolio?.let {
            binding.etPortfolioDescription.setText(portfolio!!.text)
            binding.tvTextSize.text = "${binding.etPortfolioDescription.text.length}/240"
        }
        adapter = PortfolioLinksAdapter(portfolio!!.links)
        binding.rvLinks.adapter = adapter
        adapter.onRemoveLinkClick = {
            if (portfolio!!.links.contains(it)){
                val links = portfolio!!.links
                links.remove(it)
                portfolio!!.pfObject?.put("links", links)
                portfolio!!.pfObject?.saveInBackground { exception ->
                    if (exception != null){
                        toast(exception.message.toString())
                    }
                }
                portfolio = portfolio!!.pfObject?.let { it1 -> Portfolio(it1) }
                portfolio?.let { it1 -> adapter.submitList(it1.links) }
                adapter.notifyDataSetChanged()
            }
        }
    }

    private fun saveDataToParse(/*callback : () -> Unit*/) {
        portfolio?.pfObject?.put("text", binding.etPortfolioDescription.text?.toString() ?: "")
        portfolio?.pfObject?.saveInBackground {
            if (it != null){
                log(it.message.toString())
            }else{
               /* callback()*/
            }
        }
    }


    override fun onCreated(savedInstance: Bundle?) {
        getPortfolioData()
        binding.jobSeeker = viewModel.jobSeeker
    }

    override fun onBackPressed(callback: () -> Unit) {
        saveDataToParse()
        callback()
    }

}

class PortfolioLinksAdapter(var list: ArrayList<String>) : RecyclerView.Adapter<PortfolioLinksAdapter.ViewHolder>(){
    var onRemoveLinkClick: (String) -> Unit = {}
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(ItemPortfolioLinkBinding.inflate(LayoutInflater.from(parent.context),parent, false))
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
         holder.binding.tvLink.text = list[position]
        holder.binding.ivRemoveLink.setOnClickListener {
            onRemoveLinkClick(list[position])
        }
    }
    override fun getItemCount(): Int = list.size
    fun submitList(links: ArrayList<String>) {
        list = links
    }

    class ViewHolder(val binding: ItemPortfolioLinkBinding) : RecyclerView.ViewHolder(binding.root)
}

