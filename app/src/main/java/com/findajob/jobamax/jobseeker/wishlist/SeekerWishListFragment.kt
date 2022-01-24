package com.findajob.jobamax.jobseeker.wishlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import com.findajob.jobamax.R
import com.findajob.jobamax.base.BaseFragmentMain
import com.findajob.jobamax.data.pojo.Phase
import com.findajob.jobamax.data.pojo.PhaseGroup
import com.findajob.jobamax.databinding.FragmentSeekerWishListBinding
import com.findajob.jobamax.databinding.ItemWishlistJobBinding
import com.findajob.jobamax.enums.ParseTableName
import com.findajob.jobamax.enums.SeekerWishlistJobFilter
import com.findajob.jobamax.jobseeker.home.JobSeekerHomeViewModel
import com.findajob.jobamax.model.GetAllUserCallback
import com.findajob.jobamax.model.JobSeeker
import com.findajob.jobamax.model.TrackingJob
import com.findajob.jobamax.model.WishlistedJob
import com.findajob.jobamax.util.log
import com.findajob.jobamax.util.toast
import com.google.android.exoplayer2.extractor.mp4.Track
import com.google.gson.Gson
import com.parse.ParseObject
import com.parse.ParseQuery
import dagger.hilt.android.AndroidEntryPoint
import org.json.JSONObject
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

@AndroidEntryPoint
class SeekerWishListFragment : BaseFragmentMain<FragmentSeekerWishListBinding>() {

    override val layoutRes: Int get() = R.layout.fragment_seeker_wish_list
    val viewModel: JobSeekerHomeViewModel by activityViewModels()
    override fun getViewModel(): ViewModel = viewModel

    lateinit var adapter: SeekerWishListAdapter
    var wishlistJobs = ArrayList<WishlistedJob>()
    var filteredJobTypes = arrayListOf(SeekerWishlistJobFilter.ALL.name)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentSeekerWishListBinding.inflate(inflater, container, false)
        configureUi()
        return binding.root
    }

    private fun configureUi() {
        setAdapter()
        setClickListeners()
        viewModelObserver()
    }

    private fun setAdapter() {
        adapter = SeekerWishListAdapter(wishlistJobs)
        binding.rvWishlistJob.adapter = adapter
        adapter.clickListener = { wishlistJob: WishlistedJob, action: Int ->
            if (action == 1){
                updateFavorite(wishlistJob)
            }else{
                val trackingJob = TrackingJob()
                trackingJob.jobSeekerId = wishlistJob.jobSeeker?.let { JobSeeker(it).jobSeekerId }.toString()
                trackingJob.job = wishlistJob.job
                trackingJob.jobSeeker = wishlistJob.jobSeeker
                val phase = Phase()
                phase.name = "Added to wishlist"
                phase.no = "1"
                phase.date = SimpleDateFormat("MMM dd, yyyy", Locale.getDefault()).format(wishlistJob.pfObject?.createdAt)
                trackingJob.phases = Gson().toJson(PhaseGroup(arrayListOf(phase)))
                val query = ParseQuery.getQuery<ParseObject>(ParseTableName.TrackingJob.toString())
                query.whereEqualTo("job", trackingJob.job)
                query.whereEqualTo("jobSeeker", trackingJob.jobSeeker)
                query.countInBackground { count, e ->
                    if (count == 0){
                        viewModel.addJobToTack(trackingJob.toParseObject() ){
                            if (it != null){
                                toast("${it.message.toString()} Something Went Wrong")
                            }else{
                                fetchWishlist(filteredJobTypes)
                            }
                        }
                    }else{
                        toast("This job is already in tracking.")
                    }
                }

            }
        }
    }

    private fun updateFavorite(wishlistJob: WishlistedJob) {
        wishlistJob.pfObject?.put("isFavroite", !wishlistJob.isFavroite)
        wishlistJob.pfObject?.let {
            viewModel.updateWishlistJob(it) {
                if (it != null) {
                    toast("${it.message.toString()} Something Went Wrong")
                } else {
                    fetchWishlist(filteredJobTypes)
                }
            }
        }
    }

    private fun viewModelObserver() {
        viewModel.isJobSeekerUpdated.observe(viewLifecycleOwner, Observer {
            if(it){
                binding.jobSeeker = viewModel.jobSeeker
            }
        })
    }

    private fun setClickListeners() {
        binding.ivFilterJob.setOnClickListener {
            val seekerFilterJobFragment = SeekerFilterJobFragment.newInstance()
            seekerFilterJobFragment.show(childFragmentManager,"dialog")
            seekerFilterJobFragment.onGoClickListener = {
                filteredJobTypes = it
                fetchWishlist(filteredJobTypes)
            }
        }
    }

    override fun onCreated(savedInstance: Bundle?) {
        viewModel.getJobSeeker()
        fetchWishlist(filteredJobTypes)
    }

    private fun fetchWishlist(filteredJobTypes: ArrayList<String> ) {
        viewModel.getWishList(object : GetAllUserCallback {
            override fun onSuccess(list: List<ParseObject>) {
                wishlistJobs.clear()
                list.forEach {
                    wishlistJobs.add(WishlistedJob(it))
                }

                adapter.submitList(wishlistJobs)
                adapter.notifyDataSetChanged()

            }

            override fun onFailure(e: Exception?) {
                if (e != null) {
                    toast("${e.message.toString()}")
                }
            }
        }, filteredJobTypes)
    }

}

class SeekerWishListAdapter(var list: ArrayList<WishlistedJob>) : RecyclerView.Adapter<SeekerWishListAdapter.ViewHolder>(){
    var clickListener: (WishlistedJob, Int) -> Unit = { wishlistJob: WishlistedJob, i: Int ->

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(ItemWishlistJobBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val wishlistJob = list[position]
        holder.binding.apply {
            this.tvProductName.text = wishlistJob.job?.getString("name") ?: ""
            this.tvCompanyName.text = wishlistJob.job?.getString("companyName") ?: ""
            if (wishlistJob.isFavroite){
                this.ivFavorite.setImageResource(R.drawable.heart)
            }else{
                this.ivFavorite.setImageResource(R.drawable.unfill_favorite_perpule)
            }
            this.ivFavorite.setOnClickListener {
                clickListener(wishlistJob, 1)
            }
            this.ivAdd.setOnClickListener {
                clickListener(wishlistJob, 2)
            }
        }
    }
    override fun getItemCount(): Int = list.size
    fun submitList(wishlistedJobs: ArrayList<WishlistedJob>) {
        list = wishlistedJobs
    }

    class ViewHolder(val binding: ItemWishlistJobBinding) : RecyclerView.ViewHolder(binding.root)
}