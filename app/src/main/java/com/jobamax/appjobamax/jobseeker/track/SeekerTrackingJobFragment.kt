package com.jobamax.appjobamax.jobseeker.track

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.jobamax.appjobamax.R
import com.jobamax.appjobamax.base.BaseFragmentMain
import com.jobamax.appjobamax.data.pojo.Phase
import com.jobamax.appjobamax.data.pojo.PhaseGroup
import com.jobamax.appjobamax.databinding.FragmentSeekerTrackingJobBinding
import com.jobamax.appjobamax.databinding.ItemSeekerOtherJobBinding
import com.jobamax.appjobamax.databinding.ItemSeekerTrackBinding
import com.jobamax.appjobamax.enums.*
import com.jobamax.appjobamax.jobseeker.home.JobSeekerHomeViewModel
import com.jobamax.appjobamax.jobseeker.model.TrackingOtherJob
import com.jobamax.appjobamax.model.GetAllUserCallback
import com.jobamax.appjobamax.model.TrackingJob
import com.jobamax.appjobamax.preference.getLanguage
import com.jobamax.appjobamax.preference.getUserId
import com.jobamax.appjobamax.util.*
import com.google.gson.Gson
import com.parse.FunctionCallback
import com.parse.ParseCloud
import com.parse.ParseObject
import com.parse.ParseQuery
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList


@AndroidEntryPoint
class SeekerTrackingJobFragment : BaseFragmentMain<FragmentSeekerTrackingJobBinding>() {

    override val layoutRes: Int get() = R.layout.fragment_seeker_tracking_job
    val viewModel: JobSeekerHomeViewModel by activityViewModels()
    override fun getViewModel(): ViewModel = viewModel

    var trackingJobamaxJobList = ArrayList<TrackingJob>()
    var trackingOtherJobList = ArrayList<TrackingOtherJob>()
    lateinit var jobamaxJobAdapter: SeekerTrackingJobamaxJobAdapter
    lateinit var otherJobAdapter: SeekerTrackingOtherJobAdapter

    var selectedFilter = SeekerTrackingJobFilter.ALL

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentSeekerTrackingJobBinding.inflate(inflater, container, false)
        configureUi()
        return binding.root
    }

    private fun configureUi() {
        getNextDeadline()
        getNextInterview()
        setAdapter()
         setClickListeners()
        viewModelObserver()
    }

    private fun getCurrent( ) {
        val query = ParseQuery.getQuery<ParseObject>(ParseTableName.JOB_SEEKER.value)
        query.whereEqualTo(ParseTableFields.JOB_SEEKER_ID.value, context?.getUserId())
        query.include("portfolio")
        query.include("idealJob")
        progressHud.show()
        query.findInBackground { it, e ->
            progressHud.dismiss()
            val jobSeeker = it?.firstOrNull()
            when {
                e != null -> {
                    toast(e.message.toString())
                }
                jobSeeker == null -> {
                    toast("User Not Found.")
                }
                else -> {
                    viewModel.jobSeekerObject = jobSeeker
                    viewModel.isJobSeekerUpdated.value = true
                }
            }
        }
    }


    private fun getNextInterview() {
        ParseCloud.callFunctionInBackground(ParseCloudFunction.GET_TRACKING_STATUS.value, mapOf("name" to JobPhase.INTERVIEW.phase , "jobSeekerId" to requireContext().getUserId() ), FunctionCallback<String>() { result, e ->
            when {
                e != null -> {
                    toast("${e.message.toString()}")
                }
                else -> {
                    if (result == "" || result == null){
                        binding.tvNextInterview.text = resources.getString(R.string.no_interview)
                    }else{
                        binding.tvNextInterview.text = convertDateToCurrentLanguage(result, requireContext().getLanguage())
                    }
                }
            }
        })
        
    }

    private fun getNextDeadline() {
        val request = mapOf("name" to JobPhase.DEADLINE.phase , "jobSeekerId" to requireContext().getUserId() )
         ParseCloud.callFunctionInBackground(ParseCloudFunction.GET_TRACKING_STATUS.value, request, FunctionCallback<String>() { result, e ->
            when {
                e != null -> {
                    toast("${e.message.toString()}")
                }
                else -> {
                    if (result == "" || result == null){
                        binding.tvNextDeadline.text = resources.getString(R.string.no_deadline)
                    }else{
                        binding.tvNextDeadline.text = convertDateToCurrentLanguage(result, requireContext().getLanguage())
                    }
                }
            }
        })

    }

    private fun setAdapter() {
        jobamaxJobAdapter = SeekerTrackingJobamaxJobAdapter(trackingJobamaxJobList, requireContext())
        binding.rvTrackedJob.adapter = jobamaxJobAdapter

        otherJobAdapter = SeekerTrackingOtherJobAdapter(trackingOtherJobList, requireContext())
        binding.rvTrackedOtherJob.adapter = otherJobAdapter
    }

    private fun viewModelObserver() {
        viewModel.isJobSeekerUpdated.observe(viewLifecycleOwner, Observer {
            if (it){
                binding.jobSeeker = viewModel.jobSeeker
            }
        })
    }

    private fun setClickListeners() {
        binding.ivBackButton.setOnClickListener {
            requireActivity().onBackPressed()
        }
        binding.ivCalendar.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_seekerTrackingJobFragment_to_seekerCalenderFragment, null))
        binding.civUser.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_seekerTrackingJobFragment_to_nav_seeker_profile, null))

        binding.ivFilter.setOnClickListener {
            val seekerTrackingJobFilterDialogFragment = SeekerTrackingJobFilterDialogFragment.newInstance(selectedFilter, viewModel.jobSeeker.profilePicUrl)
            seekerTrackingJobFilterDialogFragment.show(childFragmentManager,"dialog")
            seekerTrackingJobFilterDialogFragment.onGoClickListener = {
                selectedFilter = it
                jobamaxJobAdapter.submitList(trackingJobamaxJobList, selectedFilter)
                jobamaxJobAdapter.notifyDataSetChanged()
                otherJobAdapter.submitList(trackingOtherJobList, selectedFilter)
                otherJobAdapter.notifyDataSetChanged()
            }
        }
        binding.tvJobamaxJob.setOnClickListener {
            binding.tvOtherJob.background = null
            binding.tvJobamaxJob.setBackgroundResource(R.drawable.rounded_white_box)
            binding.rvTrackedJob.visibility = View.VISIBLE
            binding.rvTrackedOtherJob.visibility = View.GONE
            binding.ivAddOtherJob.visibility = View.GONE
        }
        binding.tvOtherJob.setOnClickListener {
            binding.tvOtherJob.setBackgroundResource(R.drawable.rounded_white_box)
            binding.tvJobamaxJob.background = null
            binding.rvTrackedJob.visibility = View.GONE
            binding.rvTrackedOtherJob.visibility = View.VISIBLE
            binding.ivAddOtherJob.visibility = View.VISIBLE
        }

        binding.ivAddOtherJob.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.seekerAddPersonalTrackJobFragment, null))

    }

    override fun onCreated(savedInstance: Bundle?) {
        getCurrent()
        getTrackingJobamaxJobs()
        getTrackingOtherJobs()
    }

    private fun getTrackingOtherJobs() {
        val query = ParseQuery.getQuery<ParseObject>(ParseTableName.PERSONAL_TRACK_JOB.value)
        query.whereEqualTo(ParseTableFields.JOB_SEEKER_ID.value, context?.getUserId())
        query.include("jobSeeker")
        query.findInBackground { list, e ->
            when {
                e != null -> {
                    toast(e.message.toString())
                }
                list == null -> {
                    log("No result found")
                }
                else -> {
                    trackingOtherJobList.clear()
                    list.forEach {
                        trackingOtherJobList.add(TrackingOtherJob(it))
                    }
                    otherJobAdapter.submitList(trackingOtherJobList, selectedFilter)
                    otherJobAdapter.notifyDataSetChanged()
                }
            }
        }
    }

    private fun getTrackingJobamaxJobs() {
        binding.jobSeeker = viewModel.jobSeeker
        viewModel.loadTrackingJob(object : GetAllUserCallback {
            override fun onSuccess(parseObject: List<ParseObject>) {
                trackingJobamaxJobList.clear()
                parseObject.forEach {
                    trackingJobamaxJobList.add(TrackingJob(it))
                }
                jobamaxJobAdapter.submitList(trackingJobamaxJobList, selectedFilter)
                jobamaxJobAdapter.notifyDataSetChanged()
            }

            override fun onFailure(e: Exception?) {
                if (e != null) {
                    toast("${e.message.toString()} Something Went Wrong")
                }
            }
        })
    }

}

class SeekerTrackingJobamaxJobAdapter(var list: ArrayList<TrackingJob>, val requireContext: Context) : RecyclerView.Adapter<SeekerTrackingJobamaxJobAdapter.ViewHolder>(){
    var selectedFilter = SeekerTrackingJobFilter.ALL
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(ItemSeekerTrackBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val job = list[position]
        holder.binding.apply {
            val mainObject = Gson().fromJson(job.phases, PhaseGroup::class.java)
            val phases = ArrayList(mainObject.phases)
            var lastPhase: Phase? = null
            var date: Date? = null
            phases.forEach {
                var sdf: SimpleDateFormat? = null
                var date1: Date? = null
                try {
                    sdf = SimpleDateFormat("MMM dd, yyyy")
                    date1 = sdf.parse(it.date)
                }catch (e: java.lang.Exception){
                    sdf = SimpleDateFormat("MMM dd, yyyy", Locale.FRANCE)
                    try {
                        date1 = sdf.parse(it.date)
                    }catch (e: java.lang.Exception){}
                }
                if (date == null){
                    date = date1
                    lastPhase = it
                }else{
                    if (date1 != null) {
                        if (date1.after(date)){
                            date = date1
                            lastPhase = it
                        }
                    }
                }
            }

            if (lastPhase != null) {
                if (requireContext.getLanguage() == FRENCH_LANG_CODE){
                    if (trackingEventMap.containsKey(lastPhase!!.name)){
                        this.tvLatestPhase.text = trackingEventMap[lastPhase!!.name]
                    }else{
                        this.tvLatestPhase.text = lastPhase!!.name
                    }
                }else{
                    if (trackingEventMap.containsKey(lastPhase!!.name)){
                        this.tvLatestPhase.text = lastPhase!!.name
                    }else{
                        if (trackingEventMap.containsValue(lastPhase!!.name)){
                            trackingEventMap.forEach {
                                if (it.value == lastPhase!!.name){
                                    this.tvLatestPhase.text = it.key
                                }
                            }
                        }else{
                            this.tvLatestPhase.text = lastPhase!!.name
                        }
                    }
                }

            }

            this.tvJobTitle.text = job.job?.getString("jobTitle") ?: ""
            this.tvCompanyName.text = job.job?.getString("companyName") ?: ""
            this.tvLocation.text = job.job?.getString("city") ?: ""
            if (job.job?.getString("logo") != ""){
                Picasso.get().load(job.job?.getString("logo")).into(this.ivCompany)
            }else{
                this.ivCompany.setImageResource(R.drawable.ic_company)
            }
            val bundle = Bundle()
            bundle.putSerializable("trackingJobamaxJob", job)
            this.clParent.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.seekerTrackingJobDetailsFragment, bundle))
            this.acbtnApply.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.seekerTrackingJobDetailsFragment, bundle))
        }
    }
    override fun getItemCount(): Int = list.size
    fun submitList(trackingJobList: ArrayList<TrackingJob>, appliedFilter: SeekerTrackingJobFilter) {
        this.selectedFilter = appliedFilter
        val jobs = ArrayList<TrackingJob>()
        when(selectedFilter) {
            SeekerTrackingJobFilter.ALL -> {
                trackingJobList.forEach { job ->
                    val phaseGroup = Gson().fromJson(job.phases, PhaseGroup::class.java)
                     phaseGroup.phases.forEach {
                         if (it.name == selectedFilter.filterType){
                             jobs.add(job)
                         }
                     }
                }
            }
            SeekerTrackingJobFilter.APPLIED -> {
                trackingJobList.forEach { job ->
                    val phaseGroup = Gson().fromJson(job.phases, PhaseGroup::class.java)
                    phaseGroup.phases.forEach {
                        if (it.name == selectedFilter.filterType){
                            jobs.add(job)
                        }
                    }
                }            }
            SeekerTrackingJobFilter.REFUSED -> {
                trackingJobList.forEach { job ->
                    val phaseGroup = Gson().fromJson(job.phases, PhaseGroup::class.java)
                    phaseGroup.phases.forEach {
                        if (it.name == selectedFilter.filterType){
                            jobs.add(job)
                        }
                    }
                }            }
            SeekerTrackingJobFilter.ONLINE_INTERVIEWS -> {
                trackingJobList.forEach { job ->
                    val phaseGroup = Gson().fromJson(job.phases, PhaseGroup::class.java)
                    phaseGroup.phases.forEach {
                        if (it.name == selectedFilter.filterType){
                            jobs.add(job)
                        }
                    }
                }            }
            SeekerTrackingJobFilter.INTERVIEWS -> {
                trackingJobList.forEach { job ->
                    val phaseGroup = Gson().fromJson(job.phases, PhaseGroup::class.java)
                    phaseGroup.phases.forEach {
                        if (it.name == selectedFilter.filterType){
                            jobs.add(job)
                        }
                    }
                }            }
            SeekerTrackingJobFilter.HIRED -> {
                trackingJobList.forEach { job ->
                    val phaseGroup = Gson().fromJson(job.phases, PhaseGroup::class.java)
                    phaseGroup.phases.forEach {
                        if (it.name == selectedFilter.filterType){
                            jobs.add(job)
                        }
                    }
                }            }
            SeekerTrackingJobFilter.ASSESSMENTS -> {
                trackingJobList.forEach { job ->
                    val phaseGroup = Gson().fromJson(job.phases, PhaseGroup::class.java)
                    phaseGroup.phases.forEach {
                        if (it.name == selectedFilter.filterType){
                            jobs.add(job)
                        }
                    }
                }            }
            SeekerTrackingJobFilter.PHONE_CALL -> {
                trackingJobList.forEach { job ->
                    val phaseGroup = Gson().fromJson(job.phases, PhaseGroup::class.java)
                    phaseGroup.phases.forEach {
                        if (it.name == selectedFilter.filterType){
                            jobs.add(job)
                        }
                    }
                }
            }
        }
        list = jobs
    }

    class ViewHolder(val binding: ItemSeekerTrackBinding) : RecyclerView.ViewHolder(binding.root)
}

class SeekerTrackingOtherJobAdapter(var list: ArrayList<TrackingOtherJob>, val requireContext: Context) : RecyclerView.Adapter<SeekerTrackingOtherJobAdapter.ViewHolder>(){
    var selectedFilter = SeekerTrackingJobFilter.ALL
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(ItemSeekerOtherJobBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val job = list[position]
        holder.binding.apply {
            val mainObject = Gson().fromJson(job.phases, PhaseGroup::class.java)
            val phases = ArrayList(mainObject.phases)
            var lastPhase: Phase? = null
            var date: Date? = null
            phases.forEach {
                var sdf: SimpleDateFormat? = null
                var date1: Date? = null
                try {
                    sdf = SimpleDateFormat("MMM dd, yyyy")
                    date1 = sdf.parse(it.date)
                }catch (e: java.lang.Exception){
                    sdf = SimpleDateFormat("MMM dd, yyyy", Locale.FRANCE)
                    try {
                        date1 = sdf.parse(it.date)
                    }catch (e: java.lang.Exception){}
                }
                if (date == null){
                    date = date1
                    lastPhase = it
                }else{
                    if (date1 != null) {
                        if (date1.after(date)){
                            date = date1
                            lastPhase = it
                        }
                    }
                }
            }

            if (lastPhase != null) {
                this.tvLatestPhase.text = convertPhaseNameInCurrentLanguage(lastPhase!!.name, requireContext.getLanguage())
            }else{
                this.tvLatestPhase.text = ""
            }


            this.tvJobTitle.text = job.jobTitle
            this.tvCompanyName.text = job.companyName
            this.tvCity.text = job.city
            this.ivCompany.setImageResource(R.drawable.wishlist_dummy)
            val bundle = Bundle()
            bundle.putSerializable("trackingOtherJob", job)
            this.clParent.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.seekerTrackingJobDetailsFragment, bundle))
            this.acbtnApply.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.seekerTrackingJobDetailsFragment, bundle))
        }
    }
    override fun getItemCount(): Int = list.size
    fun submitList(trackingJobList: ArrayList<TrackingOtherJob>, appliedFilter: SeekerTrackingJobFilter) {
        this.selectedFilter = appliedFilter
        val jobs = ArrayList<TrackingOtherJob>()
        when(selectedFilter) {
            SeekerTrackingJobFilter.ALL -> {
                trackingJobList.forEach { job ->
                    jobs.add(job)
                }
            }
            SeekerTrackingJobFilter.APPLIED -> {
                trackingJobList.forEach { job ->
                    val phaseGroup = Gson().fromJson(job.phases, PhaseGroup::class.java)
                    phaseGroup.phases.forEach {
                        if (it.name == selectedFilter.filterType){
                            jobs.add(job)
                        }
                    }
                }            }
            SeekerTrackingJobFilter.REFUSED -> {
                trackingJobList.forEach { job ->
                    val phaseGroup = Gson().fromJson(job.phases, PhaseGroup::class.java)
                    phaseGroup.phases.forEach {
                        if (it.name == selectedFilter.filterType){
                            jobs.add(job)
                        }
                    }
                }            }
            SeekerTrackingJobFilter.ONLINE_INTERVIEWS -> {
                trackingJobList.forEach { job ->
                    val phaseGroup = Gson().fromJson(job.phases, PhaseGroup::class.java)
                    phaseGroup.phases.forEach {
                        if (it.name == selectedFilter.filterType){
                            jobs.add(job)
                        }
                    }
                }            }
            SeekerTrackingJobFilter.INTERVIEWS -> {
                trackingJobList.forEach { job ->
                    val phaseGroup = Gson().fromJson(job.phases, PhaseGroup::class.java)
                    phaseGroup.phases.forEach {
                        if (it.name == selectedFilter.filterType){
                            jobs.add(job)
                        }
                    }
                }            }
            SeekerTrackingJobFilter.HIRED -> {
                trackingJobList.forEach { job ->
                    val phaseGroup = Gson().fromJson(job.phases, PhaseGroup::class.java)
                    phaseGroup.phases.forEach {
                        if (it.name == selectedFilter.filterType){
                            jobs.add(job)
                        }
                    }
                }            }
            SeekerTrackingJobFilter.ASSESSMENTS -> {
                trackingJobList.forEach { job ->
                    val phaseGroup = Gson().fromJson(job.phases, PhaseGroup::class.java)
                    phaseGroup.phases.forEach {
                        if (it.name == selectedFilter.filterType){
                            jobs.add(job)
                        }
                    }
                }            }
            SeekerTrackingJobFilter.PHONE_CALL -> {
                trackingJobList.forEach { job ->
                    val phaseGroup = Gson().fromJson(job.phases, PhaseGroup::class.java)
                    phaseGroup.phases.forEach {
                        if (it.name == selectedFilter.filterType){
                            jobs.add(job)
                        }
                    }
                }
            }
        }
        list = jobs
    }

    class ViewHolder(val binding: ItemSeekerOtherJobBinding) : RecyclerView.ViewHolder(binding.root)
}