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
import com.findajob.jobamax.enums.ParseTableFields
import com.findajob.jobamax.enums.ParseTableName
import com.findajob.jobamax.enums.SeekerWishlistJobFilter
import com.findajob.jobamax.jobseeker.home.JobSeekerHomeViewModel
import com.findajob.jobamax.model.GetAllUserCallback
import com.findajob.jobamax.model.JobSeeker
import com.findajob.jobamax.model.TrackingJob
import com.findajob.jobamax.model.WishlistedJob
import com.findajob.jobamax.preference.getUserId
import com.findajob.jobamax.util.log
import com.findajob.jobamax.util.toast
import com.google.gson.Gson
import com.parse.ParseObject
import com.parse.ParseQuery
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint
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
    var filteredJob = SeekerWishlistJobFilter.ALL.name

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
            when(action){
                1 -> {
                    updateFavorite(wishlistJob)
                }
                2 -> {
                    addToTrackingJobList(wishlistJob)
                }
                else -> {
                   addToArchived(wishlistJob)
                }
            }
        }
    }

    private fun addToArchived(wishlistJob: WishlistedJob) {
        wishlistJob.pfObject?.put("isArchived", !wishlistJob.isArchived)
        wishlistJob.pfObject?.let { it ->
            progressHud.show()
            viewModel.updateWishlistJob(it) { exception ->
                progressHud.dismiss()
                if (exception != null) {
                    toast("${exception.message.toString()} Something Went Wrong")
                } else {
                    fetchWishlist( )
                }
            }
        }
    }

    private fun addToTrackingJobList(wishlistJob: WishlistedJob) {
        val trackingJob = TrackingJob()
        trackingJob.jobSeekerId =
            wishlistJob.jobSeeker?.let { JobSeeker(it).jobSeekerId }.toString()
        trackingJob.job = wishlistJob.job
        trackingJob.jobSeeker = wishlistJob.jobSeeker
        val phase = Phase()
        phase.name = "Added to wishlist"
        phase.no = "1"
        phase.date = SimpleDateFormat(
            "MMM dd, yyyy",
            Locale.getDefault()
        ).format(wishlistJob.pfObject?.createdAt)
        trackingJob.phases = Gson().toJson(PhaseGroup(arrayListOf(phase)))
        val query = ParseQuery.getQuery<ParseObject>(ParseTableName.TrackingJob.toString())
        query.whereEqualTo("job", trackingJob.job)
        query.whereEqualTo("jobSeeker", trackingJob.jobSeeker)
        progressHud.show()
        query.countInBackground { count, e ->
            progressHud.dismiss()
            if (count == 0) {
                viewModel.addJobToTack(trackingJob.toParseObject()) {
                    if (it != null) {
                        toast("${it.message.toString()} Something Went Wrong")
                    } else {
                        deleteWishlistJob(wishlistJob)
                    }
                }
            } else {
                deleteWishlistJob(wishlistJob)
                toast("This job is already in tracking.")
            }
        }
    }

    private fun deleteWishlistJob(wishlistJob: WishlistedJob) {
        wishlistJob.pfObject?.deleteInBackground { exception ->
            if (exception != null) {
                toast("${exception.message.toString()}")
            } else {
                fetchWishlist( )
            }
        }
    }

    private fun updateFavorite(wishlistJob: WishlistedJob) {
        wishlistJob.pfObject?.put("isFavroite", !wishlistJob.isFavroite)
        wishlistJob.pfObject?.let { it ->
            progressHud.show()
            viewModel.updateWishlistJob(it) { exception ->
                progressHud.dismiss()
                if (exception != null) {
                    toast("${exception.message.toString()} Something Went Wrong")
                } else {
                    fetchWishlist( )
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
            var all = 0
            var favorite = 0
            var archive = 0
            wishlistJobs.forEach {
                if (it.isArchived){
                    archive++
                }
                if (it.isFavroite){
                    favorite++
                }
                all++
            }
            val seekerFilterJobFragment = SeekerFilterJobFragment().newInstance(all, favorite, archive)
            seekerFilterJobFragment.show(childFragmentManager,"dialog")
            seekerFilterJobFragment.onGoClickListener = {
                adapter.submitList(wishlistJobs, it)
                adapter.notifyDataSetChanged()
            }
        }

        binding.ivBackButton.setOnClickListener {
            requireActivity().onBackPressed()
        }
        binding.civUser.setOnClickListener {
            requireActivity().onBackPressed()
        }
    }

    override fun onCreated(savedInstance: Bundle?) {

        if (viewModel.jobSeekerObject == null){
            getCurrent()
        }
        binding.jobSeeker = viewModel.jobSeeker
        fetchWishlist()
    }

    fun getCurrent( ) {
        val query = ParseQuery.getQuery<ParseObject>(ParseTableName.JobSeeker.toString())
        query.whereEqualTo(ParseTableFields.jobSeekerId.toString(), context?.getUserId())
        query.include("portfolio")
        query.include("idealJob")
        query.findInBackground { it, e ->
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


    private fun fetchWishlist() {
        val query = ParseQuery.getQuery<ParseObject>(ParseTableName.WishlistedJob.toString())
        query.whereEqualTo(ParseTableFields.jobSeekerId.toString(),requireContext().getUserId())
        query.include("job")
        query.include("jobSeeker")
        query.findInBackground { result, e ->
            when {
                e != null -> {
                    toast("${e.message.toString()}")
                }
                result == null -> {
                    toast("No Data")
                }
                else -> {
                    wishlistJobs.clear()
                    result.forEach {
                        wishlistJobs.add(WishlistedJob(it))
                    }
                    adapter.submitList(wishlistJobs)
                    adapter.notifyDataSetChanged()
                    if (wishlistJobs.isEmpty()){
                        binding.tvNoData.visibility  = View.VISIBLE
                    }else{
                        binding.tvNoData.visibility  = View.GONE
                    }
                }
            }
        }
    }

}

class SeekerWishListAdapter(var list: ArrayList<WishlistedJob>) : RecyclerView.Adapter<SeekerWishListAdapter.ViewHolder>(){
    var filter = SeekerWishlistJobFilter.ALL
    var clickListener: (WishlistedJob, Int) -> Unit = { wishlistJob: WishlistedJob, i: Int ->

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(ItemWishlistJobBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val wishlistJob = list[position]
        holder.binding.apply {
            this.tvJobTitle.text = wishlistJob.job?.getString("jobTitle") ?: ""
            this.tvCompanyName.text = wishlistJob.job?.getString("companyName") ?: ""
            this.tvLocation.text = wishlistJob.job?.getString("location") ?: ""
            when(filter){
                SeekerWishlistJobFilter.ALL -> {
                    this.llActionButton.visibility = View.VISIBLE
                    if (!wishlistJob.job?.getString("logo").isNullOrEmpty()){
                        Picasso.get().load(wishlistJob.job?.getString("logo")).into(this.ivCompany)
                    }else{
                        this.ivCompany.setBackgroundResource(R.drawable.ic_company)
                    }
                    if (wishlistJob.isFavroite){
                        this.ivFavorite.setImageResource(R.drawable.heart)
                    }else{
                        this.ivFavorite.setImageResource(R.drawable.heart_holo)
                    }
                    this.ivFavorite.setOnClickListener {
                        clickListener(wishlistJob, 1)
                    }
                    this.ivAdd.setOnClickListener {
                        clickListener(wishlistJob, 2)
                    }
                    this.ivArchive.setOnClickListener {
                        clickListener(wishlistJob, 3)
                    }
                }
                else -> {
                    this.llActionButton.visibility = View.GONE
                }
            }

        }
    }
    override fun getItemCount(): Int = list.size
    fun submitList(wishlistedJobs: ArrayList<WishlistedJob>, f: SeekerWishlistJobFilter = SeekerWishlistJobFilter.ALL) {
        var jobs = ArrayList<WishlistedJob>()
        this.filter = f
        when(filter){
            SeekerWishlistJobFilter.ARCHIVE -> {
                wishlistedJobs.forEach {
                    if (it.isArchived){
                        jobs.add(it)
                    }
                }
            }
            SeekerWishlistJobFilter.FAVORITE -> {
                wishlistedJobs.forEach {
                    if (it.isFavroite){
                        jobs.add(it)
                    }
                }
            }
            else -> {
                jobs = wishlistedJobs
            }
        }
        list = jobs
    }



    class ViewHolder(val binding: ItemWishlistJobBinding) : RecyclerView.ViewHolder(binding.root)
}
