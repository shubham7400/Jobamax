package com.findajob.jobamax.jobseeker.wishlist

import android.content.Intent
import android.graphics.drawable.BitmapDrawable
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.PopupWindow
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.findajob.jobamax.R
import com.findajob.jobamax.base.BaseFragmentMain
import com.findajob.jobamax.data.pojo.Phase
import com.findajob.jobamax.data.pojo.PhaseGroup
import com.findajob.jobamax.databinding.FragmentSeekerWishListBinding
import com.findajob.jobamax.databinding.ItemWishlistJobBinding
import com.findajob.jobamax.dialog.YesNoDialog
import com.findajob.jobamax.enums.ParseTableFields
import com.findajob.jobamax.enums.ParseTableName
import com.findajob.jobamax.enums.SeekerWishlistJobFilter
import com.findajob.jobamax.jobseeker.home.JobSeekerHomeViewModel
import com.findajob.jobamax.model.JobSeeker
import com.findajob.jobamax.model.TrackingJob
import com.findajob.jobamax.model.WishlistedJob
import com.findajob.jobamax.preference.getUserId
import com.findajob.jobamax.util.toast
import com.google.gson.Gson
import com.parse.ParseObject
import com.parse.ParseQuery
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.popup_add_job_to_track.view.*
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
    var selectedFilter = SeekerWishlistJobFilter.ALL

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
        adapter.clickListener = { wishlistJob: WishlistedJob, action: Int, view: View? ->
            when(action){
                1 -> {
                    updateFavorite(wishlistJob)
                }
                2 -> {
                    displayPopupWindow(wishlistJob, view)
                }
                3 -> {
                    addToArchived(wishlistJob)
                }
                else -> {
                    val jobUrl = wishlistJob.job?.getString("jobUrl")
                    val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(jobUrl))
                    startActivity(browserIntent)
                }
            }
        }
    }

    private fun displayPopupWindow(wishlistJob: WishlistedJob, view: View?) {
        val popup = PopupWindow(requireContext())
        val layout: View = layoutInflater.inflate(R.layout.popup_add_job_to_track, null)
        layout.tv_message.setOnClickListener {
            addToTrackingJobList(wishlistJob)
            popup.dismiss()
        }
        popup.contentView = layout
        popup.height = WindowManager.LayoutParams.WRAP_CONTENT
        popup.width = WindowManager.LayoutParams.WRAP_CONTENT
        popup.isOutsideTouchable = true
        popup.isFocusable = true
        popup.setBackgroundDrawable(BitmapDrawable())
        popup.showAsDropDown(view)
    }

    private fun addToArchived(wishlistJob: WishlistedJob) {
        YesNoDialog(requireActivity(), resources.getString(R.string.are_you_sure),{
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
        }, {}).show()
    }

    private fun addToTrackingJobList(wishlistJob: WishlistedJob) {
        wishlistJob.pfObject?.put("isAddedToTracking", true)
        wishlistJob.pfObject?.saveInBackground()

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
        val query = ParseQuery.getQuery<ParseObject>(ParseTableName.TRACKING_JOB.value)
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
                        toast("Added to tracking successfully.")
                        fetchWishlist( )
                    }
                }
            } else {
                fetchWishlist( )
                toast("This job is already in tracking.")
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
            var inProgress = 0
            wishlistJobs.forEach {
                if (it.isArchived){
                    archive++
                }else{
                    all++
                }
                if (it.isFavroite){
                    favorite++
                }
                if(it.isAddedToTracking && !it.isArchived){
                    inProgress++
                }
            }
            val seekerFilterJobFragment = SeekerFilterJobFragment().newInstance(all, favorite, archive, inProgress, selectedFilter)
            seekerFilterJobFragment.show(childFragmentManager,"dialog")
            seekerFilterJobFragment.onGoClickListener = {
                selectedFilter = it
                adapter.submitList(wishlistJobs, selectedFilter)
                adapter.notifyDataSetChanged()
            }
        }

        binding.ivBackButton.setOnClickListener {
            requireActivity().onBackPressed()
        }
        binding.civUser.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_seekerWishListFragment_to_nav_seeker_profile, null))
    }

    override fun onCreated(savedInstance: Bundle?) {

        if (viewModel.jobSeekerObject == null){
            getCurrent()
        }
        binding.jobSeeker = viewModel.jobSeeker
        fetchWishlist()
    }

    private fun getCurrent( ) {
        val query = ParseQuery.getQuery<ParseObject>(ParseTableName.JOB_SEEKER.value)
        query.whereEqualTo(ParseTableFields.JOB_SEEKER_ID.value, context?.getUserId())
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
        val query = ParseQuery.getQuery<ParseObject>(ParseTableName.WISHLISTED_JOB.value)
        query.whereEqualTo(ParseTableFields.JOB_SEEKER_ID.value,requireContext().getUserId())
        query.whereLessThan("createdAt", Date(Date().time - 120000))
        query.include("job")
        query.include("jobSeeker")
        progressHud.show()
        query.findInBackground { result, e ->
            progressHud.dismiss()
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
                    adapter.submitList(wishlistJobs, selectedFilter)
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
    var clickListener: (WishlistedJob, Int, view: View?) -> Unit = { wishlistedJob: WishlistedJob, i: Int, view: View? ->

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(ItemWishlistJobBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val wishlistJob = list[position]
        holder.binding.apply {
            this.tvJobTitle.text = wishlistJob.job?.getString("jobTitle") ?: ""
            this.tvCompanyName.text = wishlistJob.job?.getString("companyName") ?: ""
            this.tvLocation.text = wishlistJob.job?.getString("city") ?: ""
            when(filter){
                SeekerWishlistJobFilter.ALL -> {
                    this.llActionButton.visibility = View.VISIBLE
                    this.ivFavorite.visibility = View.VISIBLE
                    this.ivAdd.visibility = View.VISIBLE
                    this.ivArchive.visibility = View.VISIBLE
                    if (!wishlistJob.job?.getString("logo").isNullOrEmpty()){
                        Picasso.get().load(wishlistJob.job?.getString("logo")).into(this.ivCompany)
                    }else{
                        this.ivCompany.setBackgroundResource(R.drawable.ic_company)
                    }
                    if (wishlistJob.isAddedToTracking){
                        this.ivAdd.visibility = View.GONE
                        this.ivFavorite.visibility = View.GONE
                    }
                    if (wishlistJob.isFavroite){
                        this.ivFavorite.setImageResource(R.drawable.filled_heart)
                    }else{
                        this.ivFavorite.setImageResource(R.drawable.heart_holo)
                    }
                    if (wishlistJob.isArchived){
                        this.ivArchive.setImageResource(R.drawable.ic_unarchive)
                    }else{
                        this.ivArchive.setImageResource(R.drawable.ic_archive)
                    }
                    this.ivFavorite.setOnClickListener {
                        clickListener(wishlistJob, 1, null)
                    }
                    this.ivAdd.setOnClickListener {
                        clickListener(wishlistJob, 2, it)
                    }
                    this.ivArchive.setOnClickListener {
                        clickListener(wishlistJob, 3, null)
                    }
                    this.acbtnApply.setOnClickListener {
                        clickListener(wishlistJob, 4, null)
                    }
                }
                SeekerWishlistJobFilter.ARCHIVE -> {
                    this.llActionButton.visibility = View.VISIBLE
                    this.ivFavorite.visibility = View.GONE
                    this.ivAdd.visibility = View.GONE
                    this.ivArchive.visibility = View.VISIBLE
                    this.ivArchive.setImageResource(R.drawable.ic_unarchive)
                    this.ivArchive.setOnClickListener {
                        clickListener(wishlistJob, 3, null)
                    }
                }
                else -> {
                    this.llActionButton.visibility = View.GONE
                }
            }

        }
    }
    override fun getItemCount(): Int = list.size
    fun submitList(wishlistedJobs: ArrayList<WishlistedJob>, selectedFilter: SeekerWishlistJobFilter) {
        this.filter = selectedFilter
        list = when(filter){
            SeekerWishlistJobFilter.ARCHIVE -> {
                wishlistedJobs.filter { it.isArchived } as ArrayList<WishlistedJob>
            }
            SeekerWishlistJobFilter.FAVORITE -> {
                wishlistedJobs.filter { it.isFavroite } as ArrayList<WishlistedJob>
            }
            SeekerWishlistJobFilter.IN_PROGRESS -> {
                wishlistedJobs.filter { it.isAddedToTracking && !it.isArchived }  as ArrayList<WishlistedJob>
            }
            else -> {
                wishlistedJobs.filter { !it.isArchived } as ArrayList<WishlistedJob>
            }
        }
    }



    class ViewHolder(val binding: ItemWishlistJobBinding) : RecyclerView.ViewHolder(binding.root)
}
