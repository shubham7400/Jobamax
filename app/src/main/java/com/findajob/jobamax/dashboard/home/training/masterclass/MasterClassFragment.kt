package com.findajob.jobamax.dashboard.home.training.masterclass

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.findajob.jobamax.R
import com.findajob.jobamax.base.BaseFragmentMain
import com.findajob.jobamax.dashboard.home.training.masterclass.adapter.ComingSoonListAdapter
import com.findajob.jobamax.dashboard.home.training.masterclass.adapter.MyListAdapter
import com.findajob.jobamax.dashboard.home.training.masterclass.adapter.NewListAdapter
import com.findajob.jobamax.dashboard.home.training.masterclass.adapter.TrendingListAdapter
import com.findajob.jobamax.databinding.FragmentMasterClassBinding
import com.findajob.jobamax.extensions.goToActivity
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MasterClassFragment : BaseFragmentMain<FragmentMasterClassBinding>(), MasterClassInterface {

    val viewModel: MasterClassViewModel by viewModels()

    private val trendingListAdapter: TrendingListAdapter by lazy {
        TrendingListAdapter()
    }
    private val comingSoonListAdapter: ComingSoonListAdapter by lazy {
        ComingSoonListAdapter()
    }
    private val myListAdapter: MyListAdapter by lazy {
        MyListAdapter()
    }
    private val newListAdapter: NewListAdapter by lazy {
        NewListAdapter()
    }
    lateinit var navController: NavController

    override val layoutRes: Int get() = R.layout.fragment_master_class

    override fun onCreated(savedInstance: Bundle?) {
        navController = findNavController()
        binding.handler = this
        initViews()
        fetchCategories()
    }

    override fun getViewModel(): ViewModel? {
        return null
    }


    private fun fetchCategories() {
        viewModel.fetchVideoCategory()
    }

    private fun initViews() {
        initCategories()
        initObservers()
    }

    private fun initObservers() {
         viewModel.trendingList.observe(viewLifecycleOwner, {
             trendingListAdapter.collection = it
             trendingListAdapter.notifyDataSetChanged()
             if (it.isEmpty()) {
                 binding.tvHintTrendingList.visibility = View.VISIBLE
             }else{
                 binding.tvHintTrendingList.visibility = View.GONE
             }
         })
        viewModel.comingSoonList.observe(viewLifecycleOwner, {
            comingSoonListAdapter.collection = it
            comingSoonListAdapter.notifyDataSetChanged()
            if (it.isEmpty()) {
                binding.tvHintComingSoonList.visibility = View.VISIBLE
            }else{
                binding.tvHintComingSoonList.visibility = View.GONE
            }
        })
        viewModel.myList.observe(viewLifecycleOwner, {
            myListAdapter.collection = it
            myListAdapter.notifyDataSetChanged()
            if (it.isEmpty()) {
                binding.tvHintMyList.visibility = View.VISIBLE
            }else{
                binding.tvHintMyList.visibility = View.GONE
            }
        })
        viewModel.newList.observe(viewLifecycleOwner, {
            newListAdapter.collection = it
            newListAdapter.notifyDataSetChanged()
            if (it.isEmpty()) {
                binding.tvHintNewList.visibility = View.VISIBLE
            }else{
                binding.tvHintNewList.visibility = View.GONE
            }
        })
    }

    private fun initCategories() {
        trendingListAdapter.clickListener = {
            startActivity(Intent(requireContext(), MasterClassDetailsActivity::class.java).putExtra("category_item", it))
        }
        comingSoonListAdapter.clickListener = {
            startActivity(Intent(requireContext(), MasterClassDetailsActivity::class.java).putExtra("category_item", it))
        }
        myListAdapter.clickListener = {
            startActivity(Intent(requireContext(), MasterClassDetailsActivity::class.java).putExtra("category_item", it))
        }
        newListAdapter.clickListener = {
            startActivity(Intent(requireContext(), MasterClassDetailsActivity::class.java).putExtra("category_item", it))
        }
        binding.apply {
            rvTrendingList.adapter = trendingListAdapter
            rvComingSoonList.adapter = comingSoonListAdapter
            rvMyList.adapter = myListAdapter
            rvNewList.adapter = newListAdapter
        }
    }

    override fun onBackPress() {
        requireActivity().onBackPressed()
    }


}

interface MasterClassInterface {
    fun onBackPress()
}
