package com.jobamax.appjobamax.jobseeker.profile.experience

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
import com.jobamax.appjobamax.databinding.FragmentSeekerExperienceListBinding
import com.jobamax.appjobamax.databinding.ItemSeekerExperienceBinding
import com.jobamax.appjobamax.dialog.YesNoDialog
import com.jobamax.appjobamax.jobseeker.home.JobSeekerHomeViewModel
import com.jobamax.appjobamax.jobseeker.profile.cv.model.Experience
import com.jobamax.appjobamax.jobseeker.profile.cv.model.ExperienceGroup
import com.jobamax.appjobamax.util.loadImageFromUrl
import com.jobamax.appjobamax.util.toast
import com.google.gson.Gson
import com.jobamax.appjobamax.preference.getLanguage
import com.jobamax.appjobamax.util.convertDateToCurrentLanguage
import com.jobamax.appjobamax.util.log
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
         adapter = SeekerExperienceListAdapter(experiences, requireContext())
        binding.rvExperienceList.adapter = adapter
        adapter.clickListener = { experience ->
            YesNoDialog(requireActivity(), resources.getString(R.string.are_you_sure), {
                experiences.remove(experience)
                progressHud.show()
                viewModel.saveNewExperienceList(experiences){
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
                experiences = ArrayList(
                    Gson().fromJson(
                        viewModel.jobSeeker.experiences,
                        ExperienceGroup::class.java
                    )?.list ?: listOf()
                )
                adapter.submitList(experiences)
                adapter.notifyDataSetChanged()
            }
        }
    }

    private fun setClickListeners() {
        binding.btnGoToProfile.setOnClickListener {
            requireActivity().onBackPressed()
        }
        binding.ivBackButton.setOnClickListener {
            requireActivity().onBackPressed()
        }
        binding.ivUserProfile.setOnClickListener {
            requireActivity().onBackPressed()
        }
        binding.btnAddExperience.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_seekerExperienceListFragment_to_seekerAddExperienceFragment, null))
    }

    override fun onCreated(savedInstance: Bundle?) {

    }

}

class SeekerExperienceListAdapter(var list: ArrayList<Experience>, val requireContext: Context) : RecyclerView.Adapter<SeekerExperienceListAdapter.ViewHolder>() {
    var clickListener: (Experience) -> Unit = {}
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(ItemSeekerExperienceBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val experience = list[position]
        holder.binding.apply {
            this.tvJobName.text = experience.job
            this.tvCompanyName.text = experience.company
            this.tvAddress.text = experience.location
            loadImageFromUrl(this.ivCompany, experience.logo, R.drawable.experience_dummy)
            when {
                experience.startDate == "" -> {
                    this.tvDateDuration.visibility = View.GONE
                }
                experience.endDate == "" -> {
                    this.tvDateDuration.text = convertDateToCurrentLanguage(experience.startDate, requireContext.getLanguage())+" - Present"
                }
                else -> {
                    this.tvDateDuration.text = convertDateToCurrentLanguage(experience.startDate, requireContext.getLanguage())+" - "+convertDateToCurrentLanguage(experience.endDate, requireContext.getLanguage())
                }
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