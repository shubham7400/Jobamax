package com.jobamax.appjobamax.login

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.jobamax.appjobamax.R
import com.jobamax.appjobamax.databinding.FragmentTakeUniversityBinding
import com.jobamax.appjobamax.jobseeker.dialog.SeekerSearchUniversityAdapter
import com.jobamax.appjobamax.enums.ParseTableName
import com.jobamax.appjobamax.extensions.toast
import com.jobamax.appjobamax.model.University
import com.jobamax.appjobamax.model.UserTempInfo
import com.jobamax.appjobamax.util.ARG_USER
import com.parse.ParseObject
import com.parse.ParseQuery


class TakeUniversityFragment : Fragment() {
    lateinit var binding: FragmentTakeUniversityBinding

    var user: UserTempInfo? = null

    var university: University? = null
    var canFetchList = true
    lateinit var adapter: SeekerSearchUniversityAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentTakeUniversityBinding.inflate(inflater, container, false)
        configureUi()
        return binding.root
    }

    private fun configureUi() {
        setClickListeners()
        setAdapterFunctionality()
        user = requireArguments().getSerializable(ARG_USER) as UserTempInfo?
    }

    private fun setClickListeners() {
        binding.btnContinue.setOnClickListener {
            university?.isCurrent = binding.cbCondition.isChecked
            user?.university = university
            val args = Bundle()
            args.putSerializable(ARG_USER, user)
            findNavController().navigate( R.id.action_takeUniversityFragment_to_takeWorkExperienceFragment, args)
        }
        binding.ivBackButton.setOnClickListener { requireActivity().onBackPressed() }
        binding.clMostParent.setOnClickListener {
            binding.rvUniversities.visibility = View.GONE
        }
        binding.etUniversity.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (binding.etUniversity.text.isNullOrEmpty()){
                    binding.rvUniversities.visibility = View.GONE
                }else{
                    if (canFetchList){
                        university = null
                        getUniversities {
                            val universities = arrayListOf<University>()
                            for (obj in it.iterator()){
                                universities.add(University(null, obj.getString("logo") ?: "", obj.getString("name") ?: "", null))
                            }
                            adapter.submitList(universities)
                            adapter.notifyDataSetChanged()
                            if (universities.isNotEmpty()){
                                binding.rvUniversities.visibility = View.VISIBLE
                            }
                        }
                    }
                    canFetchList = true
                    if (binding.etUniversity.text.isNullOrEmpty()){
                        binding.btnContinue.isEnabled = false
                        binding.btnContinue.background = resources.getDrawable(R.drawable.rounded_grey_box_50, null)
                        binding.btnContinue.setTextColor(resources.getColor(R.color.navi_blue, null))
                    }else{
                        binding.btnContinue.isEnabled = true
                        binding.btnContinue.background = resources.getDrawable(R.drawable.rounded_bottom_purple_top_blue_50, null)
                        binding.btnContinue.setTextColor(resources.getColor(R.color.white, null))
                    }
                }
            }
            override fun afterTextChanged(p0: Editable?) {}
        })
    }

    private fun getUniversities(result: (List<ParseObject>) -> Unit) {
        val query = ParseQuery<ParseObject>(ParseTableName.UNIVERSITY.value)
        query.whereMatches("name",  "^.*?((?i)(${binding.etUniversity.text})).*$")
        query.findInBackground { res, e ->
            when {
                e != null -> {
                    toast(e.message.toString())
                }
                else -> {
                    result(res)
                }
            }
        }
    }

    private fun setAdapterFunctionality() {
        canFetchList = false
        adapter = SeekerSearchUniversityAdapter(arrayListOf())
        binding.rvUniversities.adapter = adapter
        adapter.clickListener = { company ->
            university = company
            binding.rvUniversities.visibility = View.GONE
            canFetchList = false
            binding.etUniversity.setText(university?.name)
        }
    }

}