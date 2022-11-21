package com.jobamax.appjobamax.jobseeker.build_profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.jobamax.appjobamax.R
import com.jobamax.appjobamax.databinding.FragmentManualFilterMainBinding


class ManualFilterMainFragment : Fragment() {
   lateinit var binding: FragmentManualFilterMainBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentManualFilterMainBinding.inflate(inflater, container, false)
        configureUi()
        return binding.root
    }

    private fun configureUi() {
        setClickListeners()
        setupViewPager()
    }

    private fun setClickListeners() {
        binding.ivBackButton.setOnClickListener { requireActivity().onBackPressed() }
    }

    private fun setupViewPager() {
        val adapter = AdapterTabPager(childFragmentManager, lifecycle)
        adapter.addFragment(ManualFilterFragment(), "manuelle")
        adapter.addFragment(PersonalizeFilterFragment(), "personnalisée")
        binding.viewpager.adapter = adapter
        val bundle = requireActivity().intent?.extras
        bundle?.let {
            val isManual = bundle.getBoolean("is_manual", false)
            if (isManual) {
                binding.viewpager.currentItem = 0
            }else{
                binding.viewpager.currentItem = 1
            }
        }

        TabLayoutMediator(binding.resultTabs, binding.viewpager) { tab, position ->
            tab.text = adapter.getTabTitle(position)
        }.attach()

        val view = layoutInflater.inflate(R.layout.tab_manual_filter, null, false)
        val manualTab = view.findViewById<TextView>(R.id.tv_tab_manual)
        val personalizeTab = view.findViewById<TextView>(R.id.tv_tab_personalize)
        binding.resultTabs.getTabAt(0)?.customView = manualTab
        binding.resultTabs.getTabAt(1)?.customView = personalizeTab
        if (binding.resultTabs.selectedTabPosition == 0){
            manualTab.background = resources.getDrawable(R.drawable.rounded_bottom_purple_top_blue_10, null)
            manualTab.setTextColor(resources.getColor(R.color.white, null))
            personalizeTab.background = resources.getDrawable(R.drawable.rounded_blue_border_white_box_10, null)
            personalizeTab.setTextColor(resources.getColor(R.color.colorPrimary, null))
        }else{
            manualTab.background = resources.getDrawable(R.drawable.rounded_blue_border_white_box_10, null)
            manualTab.setTextColor(resources.getColor(R.color.colorPrimary, null))
            personalizeTab.background = resources.getDrawable(R.drawable.rounded_bottom_purple_top_blue_10, null)
            personalizeTab.setTextColor(resources.getColor(R.color.white, null))
        }
        binding.resultTabs.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                if (tab?.position == 0){
                    manualTab.background = resources.getDrawable(R.drawable.rounded_bottom_purple_top_blue_10, null)
                    manualTab.setTextColor(resources.getColor(R.color.white, null))
                    personalizeTab.background = resources.getDrawable(R.drawable.rounded_blue_border_white_box_10, null)
                    personalizeTab.setTextColor(resources.getColor(R.color.colorPrimary, null))
                }else{
                    manualTab.background = resources.getDrawable(R.drawable.rounded_blue_border_white_box_10, null)
                    manualTab.setTextColor(resources.getColor(R.color.colorPrimary, null))
                    personalizeTab.background = resources.getDrawable(R.drawable.rounded_bottom_purple_top_blue_10, null)
                    personalizeTab.setTextColor(resources.getColor(R.color.white, null))
                }
            }
            override fun onTabUnselected(tab: TabLayout.Tab?) {}
            override fun onTabReselected(tab: TabLayout.Tab?) {}
        })


    }

    fun goToFilterJobSearchTag() {
        findNavController().navigate(R.id.action_manualFilterMainFragment_to_filterJobSearchTagFragment, null)
    }

    fun goToModifyCv() {
        val bundle = Bundle()
        bundle.putBoolean("arg_update_app_bar", true)
        findNavController().navigate(R.id.action_manualFilterMainFragment_to_modifyCVFragment, bundle)
    }


    class AdapterTabPager(childFragmentManager: FragmentManager, lifecycle: Lifecycle) : FragmentStateAdapter(childFragmentManager, lifecycle) {
        private val mFragmentList: MutableList<Fragment> = ArrayList()
        private val mFragmentTitleList: MutableList<String> = ArrayList()

        fun addFragment(fragment: Fragment, title: String) {
            mFragmentList.add(fragment)
            mFragmentTitleList.add(title)
        }

        fun getTabTitle(position : Int): String = mFragmentTitleList[position]
        override fun getItemCount(): Int = mFragmentList.size
        override fun createFragment(position: Int): Fragment = mFragmentList[position]
    }

}

