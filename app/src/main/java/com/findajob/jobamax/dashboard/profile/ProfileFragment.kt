package com.findajob.jobamax.dashboard.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
//import coil.load
//import coil.transform.CircleCropTransformation
import com.findajob.jobamax.R
import com.findajob.jobamax.data.pojo.CompanyInformationTest
import com.findajob.jobamax.databinding.FragmentProfileBinding


class ProfileFragment : Fragment() {

    lateinit var binding: FragmentProfileBinding
    lateinit var adapter: ProfileAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_profile, container, false)

        initViews()
        initMockData()

        return binding.root
    }

    private fun initMockData() {

        adapter.collection = CompanyInformationTest.generateMockCompanyInformation()
    }

    private fun initViews() {

        binding.apply {
           /* profileIvCompanyIcon.load(R.drawable.img_avatar_dummy_09) {
                crossfade(true)
                placeholder(R.drawable.img_company_sample_01)
                transformations(CircleCropTransformation())
            }*/

            profileTvCompanyName.text = "The Company"

            adapter = ProfileAdapter()
            profileRvInfo.adapter = adapter
            profileRvInfo.layoutManager = LinearLayoutManager(context)
        }
    }
}