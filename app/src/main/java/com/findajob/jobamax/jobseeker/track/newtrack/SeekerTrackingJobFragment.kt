package com.findajob.jobamax.jobseeker.track.newtrack

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.findajob.jobamax.R
import com.findajob.jobamax.base.BaseFragmentMain
import com.findajob.jobamax.databinding.FragmentSeekerTrackingJobBinding
import com.findajob.jobamax.databinding.ItemSeekerTrackBinding
import com.findajob.jobamax.enums.JobPhase
import com.findajob.jobamax.jobseeker.calender.SeekerCalenderActivity
import com.findajob.jobamax.jobseeker.home.JobSeekerHomeViewModel
import com.findajob.jobamax.jobseeker.wishlist.SeekerFilterJobFragment
import com.findajob.jobamax.model.GetAllUserCallback
import com.findajob.jobamax.model.TrackingJob
import com.findajob.jobamax.preference.getUserId
import com.findajob.jobamax.util.toast
import com.parse.ParseObject
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SeekerTrackingJobFragment : BaseFragmentMain<FragmentSeekerTrackingJobBinding>() {

    override val layoutRes: Int get() = R.layout.fragment_seeker_tracking_job
    val viewModel: JobSeekerHomeViewModel by activityViewModels()
    override fun getViewModel(): ViewModel = viewModel

    var trackingJobList = ArrayList<TrackingJob>()
    lateinit var adapter: SeekerTrackingJobAdapter

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
        viewModel.getJobSeeker()
    }

    private fun getNextInterview() {
        viewModel.getNextInterview(JobPhase.INTERVIEW.phase, requireContext().getUserId(), {
            toast("${it.message.toString()}")
        }, {
            if (it == "" || it == null){
                binding.tvNextInterview.text = "No Interview"
            }else{
                binding.tvNextInterview.text = it
            }
        })
    }

    private fun getNextDeadline() {
        viewModel.getNextDeadline(JobPhase.DEADLINE.phase, requireContext().getUserId(), {
            toast("${it.message.toString()}")
        }, {
            if (it == "" || it == null){
                binding.tvNextDeadline.text = "No Deadline"
            }else{
                binding.tvNextDeadline.text = it
            }
        })
    }

    private fun setAdapter() {
        adapter = SeekerTrackingJobAdapter(trackingJobList)
        binding.rvTrackedJob.adapter = adapter
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
        binding.ivCalendar.setOnClickListener {
            requireContext().startActivity(Intent(requireContext(), SeekerCalenderActivity::class.java))
        }
        binding.ivFilter.setOnClickListener {
            val seekerTrackingJobFilterDialogFragment = SeekerTrackingJobFilterDialogFragment.newInstance()
            seekerTrackingJobFilterDialogFragment.show(childFragmentManager,"dialog")
            seekerTrackingJobFilterDialogFragment.onGoClickListener = {
             /*   filteredJob = it
                fetchWishlist(filteredJob)*/
            }
        }
    }

    override fun onCreated(savedInstance: Bundle?) {
        binding.jobSeeker = viewModel.jobSeeker
        viewModel.loadTrackingJob(object : GetAllUserCallback{
            override fun onSuccess(parseObject: List<ParseObject>) {
                trackingJobList.clear()
                parseObject.forEach {
                    trackingJobList.add(TrackingJob(it))
                }
                adapter.submitList(trackingJobList)
                adapter.notifyDataSetChanged()
            }
            override fun onFailure(e: Exception?) {
                if (e != null) {
                    toast("${e.message.toString()} Something Went Wrong")
                }
            }
        })
    }

}

class SeekerTrackingJobAdapter(var list: ArrayList<TrackingJob>) : RecyclerView.Adapter<SeekerTrackingJobAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(ItemSeekerTrackBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val job = list[position]
        holder.binding.apply {
            this.tvProductName.text = job.job?.getString("name") ?: ""
            this.tvCompanyName.text = job.job?.getString("companyName") ?: ""
            val bundle = Bundle()
            bundle.putSerializable("trackingJob", job)
            this.clParent.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.seekerTrackingJobDetailsFragment, bundle))
            this.acbtnApply.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.seekerTrackingJobDetailsFragment, bundle))
        }
    }
    override fun getItemCount(): Int = list.size
    fun submitList(trackingJobList: ArrayList<TrackingJob>) {
        list = trackingJobList
    }

    class ViewHolder(val binding: ItemSeekerTrackBinding) : RecyclerView.ViewHolder(binding.root)
}