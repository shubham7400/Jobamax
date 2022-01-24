package com.findajob.jobamax.jobseeker.profile

import android.os.Bundle
 import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
 import androidx.fragment.app.activityViewModels
 import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.findajob.jobamax.R
import com.findajob.jobamax.base.BaseFragmentMain
import com.findajob.jobamax.databinding.FragmentSeekerEducationBinding
 import com.findajob.jobamax.databinding.ItemSeekerEducationBinding
import com.findajob.jobamax.jobseeker.home.JobSeekerHomeViewModel
import com.findajob.jobamax.jobseeker.profile.cv.model.Education
import com.findajob.jobamax.jobseeker.profile.cv.model.EducationGroup
import com.findajob.jobamax.util.loadImageFromUrl
import com.findajob.jobamax.util.log
import com.findajob.jobamax.util.toast
import com.google.gson.Gson
import org.jetbrains.anko.doAsync
import java.util.*
import kotlin.collections.ArrayList


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
        adapter = SeekerEducationAdapter(educations)
        binding.rvEducationList.adapter = adapter
        adapter.clickListener = { education ->
            educations.remove(education)
            progressHud.show()
            viewModel.saveNewEducationList(educations){
                progressHud.dismiss()
                if(it == null){
                    toast("Item deleted.")
                }
            }
        }
    }

    private fun viewModelObserver() {
          viewModel.isJobSeekerUpdated.observe(viewLifecycleOwner, {
              if (it){
                  binding.jobSeeker = viewModel.jobSeeker
                  educations = ArrayList(Gson().fromJson(viewModel.jobSeeker.educations, EducationGroup::class.java)?.list ?: listOf())
                  adapter.submitList(educations)
                  adapter.notifyDataSetChanged()
              }
          })
    }

    private fun setClickListeners() {
        binding.ivBackButton.setOnClickListener {
            (activity as SeekerProfileActivity).onBackPressed()
        }
        binding.btnAddEducation.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.seekerNewEducationFragment, null))
        binding.btnGoToProfile.setOnClickListener{
            (activity as SeekerProfileActivity).onBackPressed()
        }
    }

    override fun onCreated(savedInstance: Bundle?) {
        viewModel.getJobSeeker()
    }

}

class SeekerEducationAdapter(var list: ArrayList<Education>) : RecyclerView.Adapter<SeekerEducationAdapter.ViewHolder>(){
    var clickListener: (Education) -> Unit = {
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(ItemSeekerEducationBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val education = list[position]
        holder.binding.tvInstituteName.text = education.name
        holder.binding.tvProgramName.text = education.program
        holder.binding.tvDateDuration.text = education.startDate+" to "+education.endDate
        val calendar = Calendar.getInstance(TimeZone.getDefault());
        val endDate = "${calendar.get(Calendar.DAY_OF_MONTH)}/ ${calendar.get(Calendar.MONTH ) + 1}/ ${calendar.get(Calendar.YEAR)}"
        if (education.endDate == ""){
            holder.binding.tvDateDuration.text = education.startDate+" to "+endDate
        }else{
            holder.binding.tvDateDuration.text = education.startDate+" to "+education.endDate
        }
        val bundle = Bundle()
        bundle.putSerializable("education", education)
        holder.binding.rlParent.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.seekerNewEducationFragment, bundle))
        holder.binding.ivDeleteItem.setOnClickListener {
            clickListener(education)
        }
    }
    override fun getItemCount(): Int  = list.size
    fun submitList(educations: ArrayList<Education>) {
         list = educations
    }

    class ViewHolder(val binding: ItemSeekerEducationBinding) : RecyclerView.ViewHolder(binding.root)
}

