package com.findajob.jobamax.jobseeker.track.newtrack

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import com.findajob.jobamax.R
import com.findajob.jobamax.base.BaseFragmentMain
import com.findajob.jobamax.data.pojo.Phase
import com.findajob.jobamax.data.pojo.PhaseGroup
import com.findajob.jobamax.databinding.FragmentSeekerTrackingJobDetailsBinding
import com.findajob.jobamax.databinding.ItemSeekerTrackingJobDetailCardBinding
import com.findajob.jobamax.dialog.SeekerJobTrackingCardDialog
import com.findajob.jobamax.jobseeker.home.JobSeekerHomeViewModel
import com.findajob.jobamax.model.TrackingJob
import com.findajob.jobamax.util.toast
import com.google.gson.Gson


class SeekerTrackingJobDetailsFragment : BaseFragmentMain<FragmentSeekerTrackingJobDetailsBinding>() {

    override val layoutRes: Int get() = R.layout.fragment_seeker_tracking_job_details
    val viewModel: JobSeekerHomeViewModel by activityViewModels()
    override fun getViewModel(): ViewModel = viewModel

    lateinit var adapter: SeekerTrackingJobDetailsAdapter
    var trackingJob: TrackingJob? = null
    var phases = arrayListOf("Select Phase","Deadline", "Online interviews" , "Assessments" , "Phone call ", "Interview 1" , "Interview 2" , "Hired" , "Refused")
    var existingPhaseList = ArrayList<Phase>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentSeekerTrackingJobDetailsBinding.inflate(inflater, container, false)
        configureUi()
        return binding.root
    }

    private fun configureUi() {
        setAdapter()
        setClickListeners()
        viewModelObserver()
        arguments?.getSerializable("trackingJob")?.let {
            trackingJob = it as TrackingJob
        }
        trackingJob?.let {
            setData()
        }
    }

    private fun setData() {
        val mainObject = Gson().fromJson(trackingJob!!.phases, PhaseGroup::class.java)
        phases = arrayListOf(
            "Select Phase",
            "Deadline",
            "Online interviews",
            "Assessments",
            "Phone call ",
            "Interview 1",
            "Interview 2",
            "Hired",
            "Refused"
        )
        existingPhaseList.clear()
        existingPhaseList = ArrayList(mainObject.phases)
        existingPhaseList.forEach {
            phases.remove(it.name)
        }
        adapter.submitList(existingPhaseList)
        adapter.notifyDataSetChanged()
    }

    private fun setAdapter() {
        adapter = SeekerTrackingJobDetailsAdapter(existingPhaseList)
        binding.rvJobTrackingCard.adapter = adapter
    }

    private fun viewModelObserver() {

    }

    private fun setClickListeners() {
        binding.ivAddPhase.setOnClickListener {
            SeekerJobTrackingCardDialog(requireActivity(), phases) { phase, date ->
                val phaseObj = Phase()
                phaseObj.name = phase
                phaseObj.date = date
                phaseObj.no = (existingPhaseList.size + 1).toString()
                existingPhaseList.add(phaseObj)
                trackingJob?.pfObject?.put("phases", Gson().toJson(PhaseGroup(existingPhaseList) ))
                trackingJob?.pfObject?.saveInBackground {
                    if (it != null){
                        toast("${it.message.toString()} Something Went Wrong.")
                    }else{
                        updateData()
                    }
                }
            }.show()
        }
    }

    private fun updateData() {
        phases = arrayListOf(
            "Select Phase",
            "Deadline",
            "Online interviews",
            "Assessments",
            "Phone call ",
            "Interview 1",
            "Interview 2",
            "Hired",
            "Refused"
        )
        existingPhaseList.forEach {
            phases.remove(it.name)
        }
        adapter.submitList(existingPhaseList)
        adapter.notifyDataSetChanged()
    }

    override fun onCreated(savedInstance: Bundle?) {

    }
}

class SeekerTrackingJobDetailsAdapter(var list: ArrayList<Phase>) : RecyclerView.Adapter<SeekerTrackingJobDetailsAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(ItemSeekerTrackingJobDetailCardBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val phase = list[position]
        holder.binding.apply {
            this.tvDate.text = phase.date
            this.tvName.text = phase.name
        }
    }
    override fun getItemCount(): Int = list.size
    fun submitList(existingPhaseList: ArrayList<Phase>) {
        list = existingPhaseList
    }

    class ViewHolder(val binding: ItemSeekerTrackingJobDetailCardBinding) : RecyclerView.ViewHolder(binding.root)
}