package com.findajob.jobamax.jobseeker.track

import android.content.Intent
import android.os.Bundle
import android.provider.CalendarContract
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.findajob.jobamax.R
import com.findajob.jobamax.base.BaseFragmentMain
import com.findajob.jobamax.data.pojo.Phase
import com.findajob.jobamax.data.pojo.PhaseGroup
import com.findajob.jobamax.databinding.FragmentSeekerTrackingJobDetailsBinding
import com.findajob.jobamax.databinding.ItemSeekerTrackingJobDetailCardBinding
import com.findajob.jobamax.dialog.SeekerJobTrackingCardDialog
import com.findajob.jobamax.dialog.SimpleYesNoDialog
import com.findajob.jobamax.dialog.YesNoDialog
import com.findajob.jobamax.jobseeker.home.JobSeekerHomeViewModel
import com.findajob.jobamax.jobseeker.model.TrackingOtherJob
import com.findajob.jobamax.model.TrackingJob
import com.findajob.jobamax.preference.getLanguage
import com.findajob.jobamax.util.*
import com.google.gson.Gson


class SeekerTrackingJobDetailsFragment : BaseFragmentMain<FragmentSeekerTrackingJobDetailsBinding>() {

    override val layoutRes: Int get() = R.layout.fragment_seeker_tracking_job_details
    val viewModel: JobSeekerHomeViewModel by activityViewModels()
    override fun getViewModel(): ViewModel = viewModel

    lateinit var adapter: SeekerTrackingJobDetailsAdapter
    var trackingJob: TrackingJob? = null
    var trackingOtherJob: TrackingOtherJob? = null
    lateinit var phaseList : ArrayList<String>
    lateinit var phases : ArrayList<String>
    var existingPhaseList = ArrayList<Phase>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentSeekerTrackingJobDetailsBinding.inflate(inflater, container, false)
        if ( requireContext().getLanguage() == ENGLISH_LANG_CODE){
            phaseList = arrayListOf("Select Phase", "Online interview" , "Assesment" , "Phone call", "Interview", "Hired" , "Refused")
            phases = phaseList
        }else{
            phaseList = arrayListOf("Sélectionnez la phase", "Entretien en ligne" , "Évaluation" , "Appel téléphonique", "Entretien", "Embauché" , "Refusé")
            phases = phaseList
        }
        configureUi()
        return binding.root
    }

    private fun configureUi() {
        setAdapter()
        viewModelObserver()
        setClickListeners()
        arguments?.getSerializable("trackingJobamaxJob")?.let {
            trackingJob = it as TrackingJob
            updateViewForJobamaxJob()
        }
        trackingJob?.let {
            setJobamaxJobData()
        }

        arguments?.getSerializable("trackingOtherJob")?.let {
            trackingOtherJob = it as TrackingOtherJob
            updateViewForOtherJob()
        }
        trackingOtherJob?.let {
            setOtherJobData()
        }
    }

    private fun setOtherJobData() {
        log("dsfjklsdklf ${trackingOtherJob!!.phases}")
        if (trackingOtherJob!!.phases != ""){
            val mainObject = Gson().fromJson(trackingOtherJob!!.phases, PhaseGroup::class.java)
            phases = phaseList
            existingPhaseList.clear()
            existingPhaseList = ArrayList(mainObject.phases)
            existingPhaseList.forEach {
                phases.remove(it.name)
            }
            adapter.submitList(existingPhaseList, trackingOtherJob!!.isSelected)
            adapter.notifyDataSetChanged()
        }
    }

    private fun updateViewForJobamaxJob() {
        if (trackingJob!!.isSelected) {
            binding.ivFinal.visibility = View.GONE
            binding.ivAddPhase.visibility = View.GONE
            binding.view11.visibility = View.GONE
            adapter.submitList(existingPhaseList, trackingJob!!.isSelected)
            adapter.notifyDataSetChanged()
        }
    }

    private fun updateViewForOtherJob() {
        if (trackingOtherJob!!.isSelected) {
            binding.ivFinal.visibility = View.GONE
            binding.ivAddPhase.visibility = View.GONE
            binding.view11.visibility = View.GONE
            adapter.submitList(existingPhaseList, trackingJob!!.isSelected)
            adapter.notifyDataSetChanged()
        }
    }

    private fun setJobamaxJobData() {
        binding.tvJobTitle.text = trackingJob?.job?.getString("jobTitle") ?: ""
        binding.tvAboutJob.text = trackingJob?.job?.getString("description") ?: ""
        binding.tvPageTitle.text = trackingJob?.job?.getString("companyName") ?: ""
        val logo = trackingJob?.job?.getString("logo") ?: ""
        loadImageFromUrl(binding.civCompanyLogo, logo, R.drawable.ic_company)
        val mainObject = Gson().fromJson(trackingJob!!.phases, PhaseGroup::class.java)
        phases = phaseList
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
            YesNoDialog(requireActivity(), resources.getString(R.string.are_you_sure), {
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
            }, {}).show()
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
                if (trackingJob != null){
                    trackingJob?.pfObject?.put("phases", Gson().toJson(PhaseGroup(existingPhaseList) ))
                    trackingJob?.pfObject?.saveInBackground {
                        if (it != null){
                            toast("${it.message.toString()} Something Went Wrong.")
                        }else{
                            updateData()
                            createGoogleEvent(phaseObj.name)
                        }
                    }
                }else if (trackingOtherJob != null){
                    trackingOtherJob?.pfObject?.put("phases", Gson().toJson(PhaseGroup(existingPhaseList) ))
                    trackingOtherJob?.pfObject?.saveInBackground {
                        if (it != null){
                            toast("${it.message.toString()} Something Went Wrong.")
                        }else{
                            updateData()
                            createGoogleEvent(phaseObj.name)
                        }
                    }
                }

            }.show()
        }
        binding.ivRemoveJob.setOnClickListener {
            YesNoDialog(requireActivity(), resources.getString(R.string.are_you_sure),{
                progressHud.show()
                trackingJob?.pfObject?.deleteInBackground {
                    progressHud.dismiss()
                    if (it != null){
                        toast("${it.message.toString()}")
                    }else{
                        toast("Job deleted.")
                        requireActivity().onBackPressed()
                    }
                }
            },{}).show()
        }
        binding.acbSeeJobDesc.setOnClickListener {
            val bundle = Bundle()
            bundle.putSerializable("tracking_job", trackingJob)
            Navigation.findNavController(it).navigate(R.id.seekerTrackingJobDescriptionFragment, bundle)
        }
        binding.ivFinal.setOnClickListener {
            YesNoDialog(requireActivity(), resources.getString(R.string.are_you_selected), {
                trackingJob?.pfObject?.put("isSelected", true)
                progressHud.show()
                trackingJob?.pfObject?.saveInBackground {
                    progressHud.dismiss()
                    if(it != null){
                        toast("${it.message.toString()}")
                    }else{
                        trackingJob!!.pfObject?.let { it1 ->
                            trackingJob = TrackingJob(it1)
                            updateViewForJobamaxJob()
                        }
                    }
                }
            }, {}).show()
        }

        binding.ivBackButton.setOnClickListener {
            requireActivity().onBackPressed()
        }
        binding.ivUserProfile.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_seekerTrackingJobDetailsFragment_to_nav_seeker_profile, null))
    }

    private fun createGoogleEvent(name: String) {
        val title = if (trackingJob == null){
            trackingOtherJob?.jobTitle+" - "+ name
        }else{
            trackingJob?.job?.getString("jobTitle") +" - "+ name
        }
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
        phases = phaseList
        if (trackingJob != null){
            existingPhaseList.forEach {
                phases.remove(it.name)
            }
            adapter.submitList(existingPhaseList, trackingJob!!.isSelected)
            adapter.notifyDataSetChanged()
        }else if (trackingOtherJob != null){
            existingPhaseList.forEach {
                phases.remove(it.name)
            }
            adapter.submitList(existingPhaseList, trackingOtherJob!!.isSelected)
            adapter.notifyDataSetChanged()
        }

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