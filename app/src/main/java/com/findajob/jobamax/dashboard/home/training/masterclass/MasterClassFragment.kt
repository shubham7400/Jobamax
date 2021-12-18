package com.findajob.jobamax.dashboard.home.training.masterclass

import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.findajob.jobamax.R
import com.findajob.jobamax.base.BaseFragmentMain
import com.findajob.jobamax.dashboard.home.training.masterclass.adapter.CategoryAdapter
import com.findajob.jobamax.data.pojo.Category
import com.findajob.jobamax.databinding.FragmentMasterClassBinding
import com.findajob.jobamax.extensions.goToActivity
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MasterClassFragment : BaseFragmentMain<FragmentMasterClassBinding>(),
    MasterClassInterface {

    private val categoryAdapter: CategoryAdapter by lazy {
        CategoryAdapter()
    }
    lateinit var navController: NavController

    override val layoutRes: Int
        get() = R.layout.fragment_master_class

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
        categoryAdapter.collection = Category.generateMockUpData()
    }

    private fun initViews() {
        initCategories()
    }

    private fun initCategories() {
        categoryAdapter.clickListener = {
            activity?.goToActivity(MasterClassDetailsActivity::class.java, false)
//            startActivity(Intent(requireActivity(), MasterClassDetailsActivity::class.java))
        }
        binding.apply {
            rvClassCategories.adapter = categoryAdapter
        }
    }

    override fun onBackPress() {
        requireActivity().onBackPressed()
    }


}

interface MasterClassInterface {
    fun onBackPress()
}
