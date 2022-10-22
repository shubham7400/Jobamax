package com.jobamax.appjobamax.jobseeker.wishlist

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.jobamax.appjobamax.R
import com.jobamax.appjobamax.WebViewActivity
import com.jobamax.appjobamax.base.BaseFragment
import com.jobamax.appjobamax.databinding.FragmentSeekerWishlistBinding
import com.jobamax.appjobamax.databinding.ItemNewWishlistBinding
import com.jobamax.appjobamax.dialog.DialogYesNoSimple
import com.jobamax.appjobamax.jobseeker.dialog.WishlistFilterDialog
import com.jobamax.appjobamax.enums.ParseCloudFunction
import com.jobamax.appjobamax.extensions.log
import com.jobamax.appjobamax.jobseeker.JobSeekerHomeActivity
import com.jobamax.appjobamax.model.WishlistJob
import com.jobamax.appjobamax.preference.getUserId
import com.jobamax.appjobamax.recruiter.RecruiterHomeActivity
import com.jobamax.appjobamax.util.ARG_WEB_URL
import com.jobamax.appjobamax.util.loadImageFromUrl
import com.parse.FunctionCallback
import com.parse.ParseCloud
import org.json.JSONObject


class SeekerWishlistFragment : BaseFragment() {
    lateinit var binding: FragmentSeekerWishlistBinding

    lateinit var wishlistAdapter: SeekerNewWishlistAdapter

    var wishlist = arrayListOf<WishlistJob>()
    var appliedFilter = WishlistJobFilter.All.value

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        context?.theme?.applyStyle(R.style.wishlist_menu, true)
        binding = FragmentSeekerWishlistBinding.inflate(inflater, container, false)
        configureUi()
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onResume() {
        super.onResume()
        fetchWishlist()
    }

    private fun configureUi() {
        setClickListeners()
        setWishlistAdapter()
        fetchWishlist()
    }

    fun apply(jobOfferId: String, applyStatus: (Boolean) -> Unit = {}) {
        val param = HashMap<String, Any>()
        param["jobSeekerId"] = requireContext().getUserId()
        param["jobOfferId"] = jobOfferId
        ParseCloud.callFunctionInBackground(ParseCloudFunction.APPLY_FOR_JOB.value, param, FunctionCallback<Any> { result, e ->
            if (e != null){
                applyStatus(false)
            }
            if (result == null){
                applyStatus(false)
            }else{
                applyStatus(true)
            }
        })
    }

    private fun updateFavoriteStatus(wishlistJob: WishlistJob, applyStatus: (Boolean) -> Unit = {}) {
        val param = HashMap<String, Any>()
        param["jobSeekerId"] = requireContext().getUserId()
        param["jobOfferId"] = wishlistJob.jobOfferId
        param["isFavourite"] = !wishlistJob.isFavroite
        ParseCloud.callFunctionInBackground(ParseCloudFunction.MARK_AS_FAVORITE.value, param, FunctionCallback<Any> { result, e ->
            if (e != null){
                applyStatus(false)
            }
            if (result == null){
                applyStatus(false)
            }else{
                applyStatus(true)
            }
        })
    }

    private fun updateArchiveStatus(wishlistJob: WishlistJob, archiveStatus: (Boolean) -> Unit) {
        val param = HashMap<String, Any>()
        param["jobSeekerId"] = requireContext().getUserId()
        param["jobOfferId"] = wishlistJob.jobOfferId
        val funName = if (wishlistJob.isArchived){
            ParseCloudFunction.UNARCHIVE_WISHLIST_JOB_ACTION.value
        }else{
            ParseCloudFunction.ARCHIVE_WISHLIST_JOB_ACTION.value
        }
        ParseCloud.callFunctionInBackground(funName, param, FunctionCallback<Any> { result, e ->
            if (e != null){
                archiveStatus(false)
            }
            if (result == null){
                archiveStatus(false)
            }else{
                archiveStatus(true)
            }
        })
    }

    private fun fetchWishlist() {
        val param = HashMap<String, Any>()
        param["jobSeekerId"] = requireContext().getUserId()
        ParseCloud.callFunctionInBackground(ParseCloudFunction.GET_WISH_LIST_V2.value, param, FunctionCallback<ArrayList<Any>> { result, e ->
            if (e != null){
                log(e.message.toString())
            }
            if (result == null){
                wishlist.clear()
            }else{
                wishlist.clear()
                for (jobOffer in result.iterator()){
                    val res = gson.toJson(jobOffer)
                    val mainObject = JSONObject(res)
                    wishlist.add(gson.fromJson(mainObject.toString(), WishlistJob::class.java))
                }
                wishlistAdapter.submitList(wishlist, appliedFilter)
                wishlistAdapter.notifyDataSetChanged()
                if (wishlist.isNotEmpty()){
                    binding.llEmptyWishlistMsg.visibility = View.GONE
                    binding.btnSwipeJobs.visibility = View.GONE
                }else{
                    binding.llEmptyWishlistMsg.visibility = View.VISIBLE
                    binding.btnSwipeJobs.visibility = View.VISIBLE
                }
            }
        })
    }





    private fun setWishlistAdapter() {
        wishlistAdapter = SeekerNewWishlistAdapter(wishlist.filter { !it.isArchived } as ArrayList, requireContext())
        binding.recyclerView.adapter = wishlistAdapter
         wishlistAdapter.onApplyConfirmationClick = { item ->
             DialogYesNoSimple(requireActivity(), "As-tu postulé ?", {
                apply(item.jobOfferId){ success ->
                    if (success){
                          val index = wishlist.indexOf(item)
                          item.isApplied = true
                          wishlist[index] = item
                          wishlistAdapter.submitList(wishlist, appliedFilter)
                          wishlistAdapter.notifyDataSetChanged()
                      }
                  }
            }, {}).show()
        }
        wishlistAdapter.onFavoriteClick = { item ->
            updateFavoriteStatus(item){ success ->
                if (success){
                    val index = wishlist.indexOf(item)
                    item.isFavroite = !item.isFavroite
                    wishlist[index] = item
                    wishlistAdapter.submitList(wishlist, appliedFilter)
                    wishlistAdapter.notifyDataSetChanged()
                }
            }
        }
        wishlistAdapter.onArchiveClick = { item ->
            updateArchiveStatus(item){ success ->
                if (success){
                    val index = wishlist.indexOf(item)
                    item.isArchived = !item.isArchived
                    wishlist[index] = item
                    wishlistAdapter.submitList(wishlist, appliedFilter)
                    wishlistAdapter.notifyDataSetChanged()
                }
            }
        }
        wishlistAdapter.onInProgressClick = { item ->
            startActivity(Intent(requireContext(), WebViewActivity::class.java).putExtra(ARG_WEB_URL, item.jobUrl))
        }
        if (wishlist.isNotEmpty()){
            binding.llEmptyWishlistMsg.visibility = View.GONE
        }else{
            binding.llEmptyWishlistMsg.visibility = View.VISIBLE
        }
    }



    private fun setClickListeners() {
        binding.ivFilterWishlist.setOnClickListener {
            val dialog = WishlistFilterDialog(requireActivity(), appliedFilter)
            dialog.onFilterOptionClick = { filterId ->
                updateWishlist(filterId)
            }
            val window: Window? = dialog.window
            window?.let {
                val wlp = it.attributes
                wlp.gravity = Gravity.TOP
                it.clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND)
                it.attributes = wlp
            }
            dialog.show()
        }

        binding.btnSwipeJobs.setOnClickListener {
            (requireActivity() as JobSeekerHomeActivity).binding.tabLayout.getTabAt(0)?.select()
        }
    }

    private fun updateWishlist(filterId: Int) {
        when(filterId){
            WishlistJobFilter.All.value -> {
                wishlistAdapter.submitList(wishlist, WishlistJobFilter.All.value)
                wishlistAdapter.notifyDataSetChanged()
            }
            WishlistJobFilter.ARCHIVE.value -> {
                wishlistAdapter.submitList(wishlist, WishlistJobFilter.ARCHIVE.value)
                wishlistAdapter.notifyDataSetChanged()
            }
            WishlistJobFilter.DONE.value -> {
                wishlistAdapter.submitList(wishlist, WishlistJobFilter.DONE.value)
                wishlistAdapter.notifyDataSetChanged()
            }
            WishlistJobFilter.PROGRESS.value -> {
                wishlistAdapter.submitList(wishlist, WishlistJobFilter.PROGRESS.value)
                wishlistAdapter.notifyDataSetChanged()
            }
        }
        appliedFilter = filterId
    }

    enum class WishlistJobFilter(val value: Int){
        All(1),
        ARCHIVE(2),
        DONE(3),
        PROGRESS(4)
    }

}

class SeekerNewWishlistAdapter(var list: ArrayList<WishlistJob>, val requireContext: Context) : RecyclerView.Adapter<SeekerNewWishlistAdapter.ViewHolder>(){
    var onApplyConfirmationClick: (WishlistJob) -> Unit = {}
    var onFavoriteClick: (WishlistJob) -> Unit = {}
    var onArchiveClick: (WishlistJob) -> Unit = {}
    var onInProgressClick: (WishlistJob) -> Unit = {}
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
        ItemNewWishlistBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.binding.apply {
            if (item.isArchived){
                this.tvArchiveTitle.text = "unarchive"
            }else{
                this.tvArchiveTitle.text = "archive"
            }
            this.tvCompanyName.text = item.companyName
            this.tvJobName.text = item.jobTitle
            this.tvJobLocation.text = item.location
            this.btnApply.setOnClickListener {
                requireContext.startActivity(Intent(requireContext, WebViewActivity::class.java).putExtra(ARG_WEB_URL, item.jobUrl))
            }
            this.btnApplyConfirmation.setOnClickListener {
                onApplyConfirmationClick(item)
            }
            this.cbLike.setOnClickListener {
                onFavoriteClick(item)
            }
            this.btnInProgress.setOnClickListener { onInProgressClick(item) }
            if (item.isApplied){
                this.btnApply.visibility = View.GONE
                this.btnApplyConfirmation.visibility = View.GONE
                this.btnInProgress.visibility = View.VISIBLE
            }else{
                this.btnApply.visibility = View.VISIBLE
                this.btnApplyConfirmation.visibility = View.VISIBLE
                this.btnInProgress.visibility = View.GONE
            }
            this.cbLike.isChecked = item.isFavroite

            loadImageFromUrl(this.civCompanyLogo, item.companyLogo, R.drawable.ic_company_gradient)
            when(item.jobType.toInt()){
                1 -> { this.tvJobType.text = "A" }
                2 -> { this.tvJobType.text = "internship" }
                3 -> { this.tvJobType.text = "C" }
                4 -> { this.tvJobType.text = "D" }
            }
            this.ivArchive.setOnClickListener { onArchiveClick(item) }
            this.tvArchiveTitle.setOnClickListener { onArchiveClick(item) }

            this.clMostParent.performClick()

            this.clMostParent.setOnLongClickListener {
                if (this.clMostParent.x < 0){
                    this.clMostParent.animate().translationX(0f).duration = 500
                }else{
                    this.clMostParent.animate().translationX(-(this.llBg.width.toFloat()+ 15)).duration = 500
                }
                return@setOnLongClickListener true
            }
            this.clMostParent.setOnClickListener {
                this.clMostParent.animate().translationX(0f).duration = 500
            }
        }
    }
    override fun getItemCount(): Int = list.size

    fun submitList(wishlist: ArrayList<WishlistJob>, filterId: Int) {
        list = when(filterId){
            SeekerWishlistFragment.WishlistJobFilter.All.value -> {
                wishlist.filter { !it.isArchived } as ArrayList
            }
            SeekerWishlistFragment.WishlistJobFilter.ARCHIVE.value -> {
                wishlist.filter { it.isArchived } as ArrayList
            }
            SeekerWishlistFragment.WishlistJobFilter.DONE.value -> {
               arrayListOf()
            }
            SeekerWishlistFragment.WishlistJobFilter.PROGRESS.value -> {
                wishlist.filter { it.isApplied } as ArrayList
            }
            else -> { wishlist }
        }
    }

    class ViewHolder(val binding: ItemNewWishlistBinding) : RecyclerView.ViewHolder(binding.root)
}