package com.jobamax.appjobamax.jobseeker.profile.volunteering

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
import com.jobamax.appjobamax.databinding.FragmentSeekerVolunteeringListBinding
import com.jobamax.appjobamax.databinding.ItemSeekerVolunteeringBinding
import com.jobamax.appjobamax.dialog.YesNoDialog
import com.jobamax.appjobamax.jobseeker.home.JobSeekerHomeViewModel
import com.jobamax.appjobamax.jobseeker.profile.cv.model.Volunteering
import com.jobamax.appjobamax.jobseeker.profile.cv.model.VolunteeringGroup
import com.jobamax.appjobamax.util.loadImageFromUrl
import com.jobamax.appjobamax.util.toast
import com.google.gson.Gson
import com.jobamax.appjobamax.preference.getLanguage
import com.jobamax.appjobamax.util.convertDateToCurrentLanguage
import dagger.hilt.android.AndroidEntryPoint
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
        adapter = SeekerVolunteeringAdapter(volunteerings, requireContext())
        binding.rvVolunteeringList.adapter = adapter
        adapter.clickListener = { volunteering ->
            YesNoDialog(requireActivity(), resources.getString(R.string.are_you_sure), {
                volunteerings.remove(volunteering)
                progressHud.show()
                viewModel.saveNewVolunteeringList(volunteerings){
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
                volunteerings = ArrayList(
                    Gson().fromJson(
                        viewModel.jobSeeker.volunteerings,
                        VolunteeringGroup::class.java
                    )?.list ?: listOf()
                )
                adapter.submitList(volunteerings)
                adapter.notifyDataSetChanged()
            }
        }
    }


    private fun setClickListeners() {
        binding.btnAddVolunteering.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_seekerVolunteeringListFragment_to_seekerAddVolunteeringFragment, null))
        binding.btnGoToProfile.setOnClickListener {
            requireActivity().onBackPressed()
        }
        binding.ivBackButton.setOnClickListener {
            requireActivity().onBackPressed()
        }
        binding.ivUserProfile.setOnClickListener {
            requireActivity().onBackPressed()
        }
    }

    override fun onCreated(savedInstance: Bundle?) {

    }

}

class SeekerVolunteeringAdapter(var list: ArrayList<Volunteering>, val requireContext: Context) : RecyclerView.Adapter<SeekerVolunteeringAdapter.ViewHolder>(){
    var clickListener: (Volunteering) -> Unit = {
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(ItemSeekerVolunteeringBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val volunteering = list[position]
        holder.binding.apply {
            loadImageFromUrl(this.ivCompany, volunteering.logo, R.drawable.volunteering_dummy)
            this.tvCompanyName.text = volunteering.company
            this.tvJob.text = volunteering.job
            when {
                volunteering.startDate == "" -> {
                    this.tvDateDuration.visibility = View.GONE
                }
                volunteering.endDate == "" -> {
                    this.tvDateDuration.text = convertDateToCurrentLanguage(volunteering.startDate, requireContext.getLanguage())+" - Present"
                }
                else -> {
                    this.tvDateDuration.text = convertDateToCurrentLanguage(volunteering.startDate, requireContext.getLanguage())+" - "+convertDateToCurrentLanguage(volunteering.endDate, requireContext.getLanguage())
                }
            }
            val bundle = Bundle()
            bundle.putSerializable("volunteering", volunteering)
            this.rlParent.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.seekerAddVolunteeringFragment, bundle))
            this.ivDeleteItem.setOnClickListener {
                clickListener(volunteering)
            }
        }
    }
    override fun getItemCount(): Int  = list.size
    fun submitList(volunteerings: ArrayList<Volunteering>) {
        list = volunteerings
    }

    class ViewHolder(val binding: ItemSeekerVolunteeringBinding) : RecyclerView.ViewHolder(binding.root)
}