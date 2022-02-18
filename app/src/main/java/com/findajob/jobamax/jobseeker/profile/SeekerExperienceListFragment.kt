package com.findajob.jobamax.jobseeker.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ExpandableListAdapter
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.findajob.jobamax.R
import com.findajob.jobamax.base.BaseFragmentMain
import com.findajob.jobamax.databinding.FragmentSeekerAddExperienceBinding
import com.findajob.jobamax.databinding.FragmentSeekerExperienceListBinding
import com.findajob.jobamax.databinding.FragmentSeekerProfileBinding
import com.findajob.jobamax.databinding.ItemSeekerExperienceBinding
import com.findajob.jobamax.jobseeker.home.JobSeekerHomeViewModel
import com.findajob.jobamax.jobseeker.profile.cv.model.Education
import com.findajob.jobamax.jobseeker.profile.cv.model.EducationGroup
import com.findajob.jobamax.jobseeker.profile.cv.model.Experience
import com.findajob.jobamax.jobseeker.profile.cv.model.ExperienceGroup
import com.findajob.jobamax.util.log
import com.findajob.jobamax.util.toast
import com.google.gson.Gson
import com.squareup.picasso.Picasso
import java.util.*
import kotlin.collections.ArrayList

class SeekerExperienceListFragment : BaseFragmentMain<FragmentSeekerExperienceListBinding>() {

    override val layoutRes: Int get() = R.layout.fragment_seeker_experience_list
    val viewModel: JobSeekerHomeViewModel by activityViewModels()
    override fun getViewModel(): ViewModel = viewModel

    lateinit var adapter: SeekerExperienceListAdapter
    var experiences = ArrayList<Experience>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
         binding = FragmentSeekerExperienceListBinding.inflate(inflater, container, false)
        configureUi()
        return binding.root
    }

    private fun configureUi() {
         setClickListeners()
        setExperienceAdapter()
        viewModelObserver()
        viewModel.getJobSeeker()
    }

    private fun setExperienceAdapter() {
         adapter = SeekerExperienceListAdapter(experiences)
        binding.rvExperienceList.adapter = adapter
        adapter.clickListener = { experience ->
            experiences.remove(experience)
            progressHud.show()
            viewModel.saveNewExperienceList(experiences){
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
                experiences = ArrayList(Gson().fromJson(viewModel.jobSeeker.experiences, ExperienceGroup::class.java)?.list ?: listOf())
                adapter.submitList(experiences)
                adapter.notifyDataSetChanged()
            }
        })
    }

    private fun setClickListeners() {
        binding.btnGoToProfile.setOnClickListener {
            requireActivity().onBackPressed()
        }
        binding.ivBackButton.setOnClickListener {
            requireActivity().onBackPressed()
        }
        binding.btnAddExperience.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_seekerExperienceListFragment_to_seekerAddExperienceFragment, null))
    }

    override fun onCreated(savedInstance: Bundle?) {

    }

}

class SeekerExperienceListAdapter(var list: ArrayList<Experience>) : RecyclerView.Adapter<SeekerExperienceListAdapter.ViewHolder>() {
    var clickListener: (Experience) -> Unit = {}
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(ItemSeekerExperienceBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val experience = list[position]
        holder.binding.apply {
            this.tvJobName.text = experience.job
            this.tvCompanyName.text = experience.company
            this.tvAddress.text = experience.location
            if (experience.logo != ""){
                Picasso.get().load(experience.logo).into(this.ivCompany)
            }
            if (experience.endDate == ""){
                val calendar = Calendar.getInstance(TimeZone.getDefault());
                val endDate = "${calendar.get(Calendar.MONTH ) + 1}/ ${calendar.get(Calendar.YEAR)}"
                this.tvDateDuration.text = experience.startDate+" to "+endDate
            }else{
                this.tvDateDuration.text = experience.startDate+" to "+experience.endDate
            }
            this.ivDeleteItem.setOnClickListener {
                clickListener(experience)
            }
            val bundle = Bundle()
            bundle.putSerializable("experience", experience)
            holder.binding.rlParent.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.seekerAddExperienceFragment, bundle))
        }
    }
    override fun getItemCount(): Int = list.size
    fun submitList(experiences: ArrayList<Experience>) {
        list = experiences
    }
    class ViewHolder(val binding: ItemSeekerExperienceBinding) : RecyclerView.ViewHolder(binding.root)
}