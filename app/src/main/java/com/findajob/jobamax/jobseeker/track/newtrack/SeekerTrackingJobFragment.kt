package com.findajob.jobamax.jobseeker.track.newtrack

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
import com.findajob.jobamax.jobseeker.home.JobSeekerHomeViewModel
import com.findajob.jobamax.model.GetAllUserCallback
import com.findajob.jobamax.model.TrackingJob
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
        setAdapter()
         setClickListeners()
        viewModelObserver()
        viewModel.getJobSeeker()
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
        }
    }
    override fun getItemCount(): Int = list.size
    fun submitList(trackingJobList: ArrayList<TrackingJob>) {
        list = trackingJobList
    }

    class ViewHolder(val binding: ItemSeekerTrackBinding) : RecyclerView.ViewHolder(binding.root)
}