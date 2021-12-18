package com.findajob.jobamax.dashboard.home.training

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.findajob.jobamax.R
import com.findajob.jobamax.dashboard.home.training.masterclass.model.MasterClass
import com.findajob.jobamax.data.pojo.UpcomingEvents
import com.findajob.jobamax.databinding.FragmentKeynotesBinding

class KeynotesFragment : Fragment() {

    lateinit var binding: FragmentKeynotesBinding
    private val adapterMyList: MyListAdapter by lazy {
        MyListAdapter()
    }
    private val adapterUpcomingEvents: UpcomingEventsAdapter by lazy {
        UpcomingEventsAdapter()
    }
    private val adapterPastEvents: UpcomingEventsAdapter by lazy {
        UpcomingEventsAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_keynotes, container, false)
        initViews()
        initMockData()
        return binding.root
    }

    private fun initMockData() {
        adapterMyList.collection = MasterClass.generateMockData()
        adapterUpcomingEvents.collection = UpcomingEvents.generateMockUpcomingEvents()
        adapterPastEvents.collection = UpcomingEvents.generateMockUpcomingEvents()
    }

    private fun initViews() {
        binding.apply {
            keynotesRvMyList.adapter = adapterMyList
            keynotesRvUpcomingEvents.adapter = adapterUpcomingEvents
            keynotesRvPastEvents.adapter = adapterPastEvents
        }

    }
}