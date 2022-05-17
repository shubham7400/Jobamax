package com.jobamax.appjobamax.jobseeker.profile.education

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.jobamax.appjobamax.R
import com.jobamax.appjobamax.base.BaseFragmentMain
import com.jobamax.appjobamax.databinding.FragmentSeekerEducationBinding
import com.jobamax.appjobamax.databinding.ItemSeekerEducationBinding
import com.jobamax.appjobamax.jobseeker.home.JobSeekerHomeViewModel
import com.jobamax.appjobamax.data.pojo.Education
import com.jobamax.appjobamax.data.pojo.EducationGroup
import com.jobamax.appjobamax.dialog.YesNoDialog
import com.jobamax.appjobamax.util.loadImageFromUrl
import com.jobamax.appjobamax.util.log
import com.jobamax.appjobamax.util.toast
import com.google.gson.Gson
import com.jobamax.appjobamax.preference.getLanguage
import com.jobamax.appjobamax.util.convertDateToCurrentLanguage
import dagger.hilt.android.AndroidEntryPoint
import java.lang.Exception
import java.util.*
import kotlin.collections.ArrayList

@AndroidEntryPoint
class SeekerEducationFragment : BaseFragmentMain<FragmentSeekerEducationBinding>() {
    override val layoutRes: Int get() = R.layout.fragment_seeker_education
    val viewModel: JobSeekerHomeViewModel by activityViewModels()
    override fun getViewModel(): ViewModel = viewModel

    lateinit var adapter: SeekerEducationAdapter
    var educations = ArrayList<Education>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentSeekerEducationBinding.inflate(inflater, container, false)
        configureUi()
        return binding.root
    }

    private fun configureUi() {
        setClickListeners()
        viewModelObserver()
        setAdapter()
    }

    private fun setAdapter() {
        adapter = SeekerEducationAdapter(educations, requireContext())
        binding.rvEducationList.adapter = adapter
        adapter.clickListener = { education ->
            YesNoDialog(requireActivity(), resources.getString(R.string.are_you_sure),{
                educations.remove(education)
                progressHud.show()
                viewModel.saveNewEducationList(educations){
                    progressHud.dismiss()
                    if(it == null){
                        toast("Item deleted.")
                    }
                }
            }, {}).show()
        }
    }

    private fun viewModelObserver() {
          viewModel.isJobSeekerUpdated.observe(viewLifecycleOwner) {
              if (it) {
                  binding.jobSeeker = viewModel.jobSeeker
                  educations = try {
                      ArrayList(
                          Gson().fromJson(
                              viewModel.jobSeeker.educations,
                              EducationGroup::class.java
                          )?.list ?: listOf()
                      )
                  } catch (e: Exception) {
                      log("${e.message.toString()}")
                      arrayListOf()
                  }
                  adapter.submitList(educations)
                  adapter.notifyDataSetChanged()
              }
          }
    }

    private fun setClickListeners() {
        binding.ivBackButton.setOnClickListener {
            requireActivity().onBackPressed()
        }
        binding.ivUserProfile.setOnClickListener {
            requireActivity().onBackPressed()
        }
        binding.btnAddEducation.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_seekerEducationFragment_to_seekerNewEducationFragment, null))
        binding.btnGoToProfile.setOnClickListener{
            requireActivity().onBackPressed()
        }
    }

    override fun onCreated(savedInstance: Bundle?) {
        viewModel.getJobSeeker()
    }

}

class SeekerEducationAdapter(var list: ArrayList<Education>, val requireContext: Context) : RecyclerView.Adapter<SeekerEducationAdapter.ViewHolder>(){
    var clickListener: (Education) -> Unit = {
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(ItemSeekerEducationBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val education = list[position]
        holder.binding.apply {
            this.tvInstituteName.text = education.name
            this.tvProgramName.text = education.program
            loadImageFromUrl(this.ivUser,education.logo ,R.drawable.school_dummy)
            when {
                education.startDate == "" -> {
                    this.tvDateDuration.visibility = View.GONE
                }
                education.endDate == "" -> {
                    this.tvDateDuration.text = convertDateToCurrentLanguage(education.startDate, requireContext.getLanguage())+" - Present"
                }
                else -> {
                    this.tvDateDuration.text = convertDateToCurrentLanguage(education.startDate, requireContext.getLanguage())+" - "+convertDateToCurrentLanguage(education.endDate, requireContext.getLanguage())
                }
            }
            val bundle = Bundle()
            bundle.putSerializable("education", education)
            this.rlParent.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_seekerEducationFragment_to_seekerNewEducationFragment, bundle))
            this.ivDeleteItem.setOnClickListener {
                clickListener(education)
            }
        }
    }
    override fun getItemCount(): Int  = list.size
    fun submitList(educations: ArrayList<Education>) {
         list = educations
    }

    class ViewHolder(val binding: ItemSeekerEducationBinding) : RecyclerView.ViewHolder(binding.root)
}

