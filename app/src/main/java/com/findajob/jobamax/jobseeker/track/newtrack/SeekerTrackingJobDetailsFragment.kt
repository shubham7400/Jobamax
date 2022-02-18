package com.findajob.jobamax.jobseeker.track.newtrack

import android.content.Intent
import android.os.Bundle
import android.provider.CalendarContract
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
    var phases = arrayListOf("Select Phase", "Online interviews" , "Assessments" , "Phone call ", "Interview", "Hired" , "Refused")
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
            updateView()
        }
        trackingJob?.let {
            setData()
        }
    }

    private fun updateView() {
        if (trackingJob!!.isSelected) {
            binding.ivFinal.visibility = View.GONE
            binding.ivAddPhase.visibility = View.GONE
            binding.view11.visibility = View.GONE
            adapter.submitList(existingPhaseList, trackingJob!!.isSelected)
            adapter.notifyDataSetChanged()
        }
    }

    private fun setData() {
        binding.tvJobTitle.text = trackingJob?.job?.getString("jobTitle") ?: ""
        binding.tvCompanyName.text = trackingJob?.job?.getString("companyName") ?: ""
        val mainObject = Gson().fromJson(trackingJob!!.phases, PhaseGroup::class.java)
        phases = arrayListOf(
            "Select Phase",
            "Online interviews",
            "Assessments",
            "Phone call ",
            "Interview",
            "Hired",
            "Refused"
        )
        existingPhaseList.clear()
        existingPhaseList = ArrayList(mainObject.phases)
        existingPhaseList.forEach {
            phases.remove(it.name)
        }
        adapter.submitList(existingPhaseList, trackingJob!!.isSelected)
        adapter.notifyDataSetChanged()
    }

    private fun setAdapter() {
        adapter = SeekerTrackingJobDetailsAdapter(existingPhaseList, false)
        binding.rvJobTrackingCard.adapter = adapter
        adapter.deletePhaseListener = { it ->
            existingPhaseList.remove(it)
            trackingJob?.pfObject?.put("phases", Gson().toJson(PhaseGroup(existingPhaseList)))
            progressHud.show()
            trackingJob?.pfObject?.saveInBackground { exception ->
                progressHud.dismiss()  
                if (exception != null){
                    toast("${exception.message.toString()} Something Went Wrong")
                }
            }
            adapter.submitList(existingPhaseList, trackingJob!!.isSelected)
            adapter.notifyDataSetChanged()
        }
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
                        createGoogleEvent(phaseObj.name)
                    }
                }
            }.show()
        }
        binding.ivRemoveJob.setOnClickListener {
            trackingJob?.pfObject?.delete()
        }
        binding.ivFinal.setOnClickListener {
            trackingJob?.pfObject?.put("isSelected", true)
            progressHud.show()
            trackingJob?.pfObject?.saveInBackground {
                progressHud.dismiss()
                if(it != null){
                    toast("${it.message.toString()}")
                }else{
                     trackingJob!!.pfObject?.let { it1 ->
                         trackingJob = TrackingJob(it1)
                         updateView()
                     }
                }
            }
        }
    }

    private fun createGoogleEvent(name: String) {
        val title = trackingJob?.job?.getString("jobTitle") +" - "+ name
        val description = "this is event description"
        val intent = Intent(Intent.ACTION_INSERT).setData(CalendarContract.Events.CONTENT_URI).also {
            it.putExtra(CalendarContract.Events.TITLE, title)
            it.putExtra(CalendarContract.Events.DESCRIPTION, description)
            it.putExtra(CalendarContract.Events.ALL_DAY, true)
        }
        if (intent.resolveActivity(requireActivity().packageManager) != null){
            startActivity(intent)
        }else{
            toast("There is no app that can support this action.")
        }
    }

    private fun updateData() {
        phases = arrayListOf(
            "Select Phase",
            "Online interviews",
            "Assessments",
            "Phone call ",
            "Interview",
            "Hired",
            "Refused"
        )
        existingPhaseList.forEach {
            phases.remove(it.name)
        }
        adapter.submitList(existingPhaseList, trackingJob!!.isSelected)
        adapter.notifyDataSetChanged()
    }

    override fun onCreated(savedInstance: Bundle?) {
        binding.jobSeeker = viewModel.jobSeeker
    }
}

class SeekerTrackingJobDetailsAdapter(var list: ArrayList<Phase>, var isSelected: Boolean) : RecyclerView.Adapter<SeekerTrackingJobDetailsAdapter.ViewHolder>() {
    var deletePhaseListener : (Phase) -> Unit = {}
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(ItemSeekerTrackingJobDetailCardBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val phase = list[position]
        holder.binding.apply {
            this.tvDate.text = phase.date
            this.tvName.text = phase.name
            this.ivDeletePhase.setOnClickListener {
                deletePhaseListener(phase)
            }
            if (isSelected){
                this.ivDeletePhase.visibility = View.GONE
            }
        }
    }
    override fun getItemCount(): Int = list.size
    fun submitList(existingPhaseList: ArrayList<Phase>, selected: Boolean) {
        isSelected = selected
        list = existingPhaseList
    }

    class ViewHolder(val binding: ItemSeekerTrackingJobDetailCardBinding) : RecyclerView.ViewHolder(binding.root)
}