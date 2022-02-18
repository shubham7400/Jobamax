package com.findajob.jobamax.jobseeker.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.findajob.jobamax.R
import com.findajob.jobamax.base.BaseFragmentMain
import com.findajob.jobamax.databinding.FragmentSeekerProfileBinding
import com.findajob.jobamax.databinding.FragmentSeekerVolunteeringListBinding
import com.findajob.jobamax.databinding.ItemSeekerEducationBinding
import com.findajob.jobamax.databinding.ItemSeekerVolunteeringBinding
import com.findajob.jobamax.jobseeker.home.JobSeekerHomeViewModel
import com.findajob.jobamax.jobseeker.profile.cv.model.Education
import com.findajob.jobamax.jobseeker.profile.cv.model.EducationGroup
import com.findajob.jobamax.jobseeker.profile.cv.model.Volunteering
import com.findajob.jobamax.jobseeker.profile.cv.model.VolunteeringGroup
import com.findajob.jobamax.util.toast
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint
import java.util.*
import kotlin.collections.ArrayList

@AndroidEntryPoint
class SeekerVolunteeringListFragment : BaseFragmentMain<FragmentSeekerVolunteeringListBinding>() {

    override val layoutRes: Int get() = R.layout.fragment_seeker_volunteering_list
    val viewModel: JobSeekerHomeViewModel by activityViewModels()
    override fun getViewModel(): ViewModel = viewModel

    lateinit var adapter: SeekerVolunteeringAdapter
    var volunteerings = ArrayList<Volunteering>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentSeekerVolunteeringListBinding.inflate(inflater, container, false)
        configureUi()
        return binding.root
    }

    private fun configureUi() {
        setClickListeners()
        viewModelObserver()
        setAdapter()
    }

    private fun setAdapter() {
        adapter = SeekerVolunteeringAdapter(volunteerings)
        binding.rvVolunteeringList.adapter = adapter
        adapter.clickListener = { volunteering ->
            volunteerings.remove(volunteering)
            progressHud.show()
            viewModel.saveNewVolunteeringList(volunteerings){
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
                volunteerings = ArrayList(Gson().fromJson(viewModel.jobSeeker.volunteerings, VolunteeringGroup::class.java)?.list ?: listOf())
                adapter.submitList(volunteerings)
                adapter.notifyDataSetChanged()
            }
        })
    }


    private fun setClickListeners() {
        binding.btnAddVolunteering.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_seekerVolunteeringListFragment_to_seekerAddVolunteeringFragment, null))
        binding.btnGoToProfile.setOnClickListener {
            requireActivity().onBackPressed()
        }
        binding.ivBackButton.setOnClickListener {
            requireActivity().onBackPressed()
        }
    }

    override fun onCreated(savedInstance: Bundle?) {

    }

}

class SeekerVolunteeringAdapter(var list: ArrayList<Volunteering>) : RecyclerView.Adapter<SeekerVolunteeringAdapter.ViewHolder>(){
    var clickListener: (Volunteering) -> Unit = {
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(ItemSeekerVolunteeringBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val volunteering = list[position]
        holder.binding.tvCompanyName.text = volunteering.company
        holder.binding.tvJob.text = volunteering.job
        holder.binding.tvDateDuration.text = volunteering.startDate+" to "+volunteering.endDate
        val calendar = Calendar.getInstance(TimeZone.getDefault());
        val endDate = "${calendar.get(Calendar.DAY_OF_MONTH)}/ ${calendar.get(Calendar.MONTH ) + 1}/ ${calendar.get(Calendar.YEAR)}"
        if (volunteering.endDate == ""){
            holder.binding.tvDateDuration.text = volunteering.startDate+" to "+endDate
        }else{
            holder.binding.tvDateDuration.text = volunteering.startDate+" to "+volunteering.endDate
        }
        val bundle = Bundle()
        bundle.putSerializable("volunteering", volunteering)
        holder.binding.rlParent.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.seekerAddVolunteeringFragment, bundle))
        holder.binding.ivDeleteItem.setOnClickListener {
            clickListener(volunteering)
        }
    }
    override fun getItemCount(): Int  = list.size
    fun submitList(volunteerings: ArrayList<Volunteering>) {
        list = volunteerings
    }

    class ViewHolder(val binding: ItemSeekerVolunteeringBinding) : RecyclerView.ViewHolder(binding.root)
}