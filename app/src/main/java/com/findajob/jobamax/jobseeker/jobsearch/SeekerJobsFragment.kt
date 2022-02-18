package com.findajob.jobamax.jobseeker.jobsearch

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AccelerateInterpolator
import android.view.animation.LinearInterpolator
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import com.findajob.jobamax.R
import com.findajob.jobamax.base.BaseFragmentMain
import com.findajob.jobamax.databinding.FragmentSeekerAboutMeBinding
import com.findajob.jobamax.databinding.FragmentSeekerAddVolunteeringBinding
import com.findajob.jobamax.databinding.FragmentSeekerJobsBinding
import com.findajob.jobamax.databinding.ItemSeekerJobCardBinding
import com.findajob.jobamax.enums.FirebaseDynamicLinkPath
import com.findajob.jobamax.enums.LoginType
import com.findajob.jobamax.enums.ParseCloudFunction
import com.findajob.jobamax.jobseeker.home.JobSeekerHomeViewModel
import com.findajob.jobamax.model.NewJobOffer
import com.findajob.jobamax.preference.getUserId
import com.findajob.jobamax.preference.getUserType
import com.findajob.jobamax.util.toast
import com.google.firebase.dynamiclinks.ktx.androidParameters
import com.google.firebase.dynamiclinks.ktx.dynamicLink
import com.google.firebase.dynamiclinks.ktx.dynamicLinks
import com.google.firebase.ktx.Firebase
import com.google.gson.Gson
import com.parse.FunctionCallback
import com.parse.ParseCloud
import com.squareup.picasso.Picasso
import com.yuyakaido.android.cardstackview.CardStackLayoutManager
import com.yuyakaido.android.cardstackview.CardStackListener
import com.yuyakaido.android.cardstackview.Direction
import com.yuyakaido.android.cardstackview.SwipeAnimationSetting
import org.json.JSONObject


class SeekerJobsFragment : BaseFragmentMain<FragmentSeekerJobsBinding>() {

    override val layoutRes: Int get() = R.layout.fragment_seeker_jobs
    val viewModel: JobSeekerHomeViewModel by activityViewModels()
    override fun getViewModel(): ViewModel = viewModel


    lateinit var adapter: SeekerJobCardStackAdapter
    lateinit var cardStackLayoutManager: CardStackLayoutManager
    lateinit var cardStackListener: CardStackListener
    var jobOfferList = ArrayList<NewJobOffer>()
    var topJobOfferId: String? = null
    var rewindJobOfferId: String? = null
    var swipedJobOffer: NewJobOffer? = null
    var rewindJobOffer: NewJobOffer? = null
    var wishlistAddedJobsId = ArrayList<String>()
    var refuseJobsId = ArrayList<String>()

    var jobSeekerId: String? = ""
    var jobOfferId: String? = ""

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentSeekerJobsBinding.inflate(inflater, container, false)
        configureUi()
        return binding.root
    }

    private fun configureUi() {
        if (requireArguments().getString("jobSeekerId") != null){
            jobSeekerId = requireArguments().getString("jobSeekerId")
        }
        if (requireArguments().getString("jobOfferId") != null){
            jobOfferId = requireArguments().getString("jobOfferId")
        }

         setClickListeners()
        setCardStackView()
        getJobOffers()
    }

    override fun onCreated(savedInstance: Bundle?) {

    }

    private fun getJobOffers() {
        ParseCloud.callFunctionInBackground(ParseCloudFunction.getJobSearch.toString(), hashMapOf<String, Any>("jobSeekerId" to requireContext().getUserId(), "isFilterApply " to false, "jobOfferId" to jobOfferId!! ), FunctionCallback<ArrayList<Any>> { result, e ->
            jobOfferId = ""
            when {
                e != null -> {
                    toast("${e.message.toString()}")
                }
                result == null -> {
                    toast("No result found")
                }
                else -> {
                    val list = ArrayList<NewJobOffer>()
                    for (jobOffer in result.iterator()){
                        val res = Gson().toJson(jobOffer)
                        val mainObject = JSONObject(res)
                        list.add(NewJobOffer(mainObject))
                    }
                    jobOfferList = list
                    adapter.submitList(jobOfferList)
                    adapter.notifyDataSetChanged()
                }
            }
        })
    }

    private fun setCardStackView() {
        setCardStackListener()
        adapter = SeekerJobCardStackAdapter(arrayListOf())
        cardStackLayoutManager = CardStackLayoutManager(requireContext(), cardStackListener)
        cardStackLayoutManager.setDirections(listOf(Direction.Left, Direction.Top, Direction.Right))
        cardStackLayoutManager.setSwipeThreshold(0.4f)
        cardStackLayoutManager.setOverlayInterpolator(LinearInterpolator())
        binding.csvJob.layoutManager = cardStackLayoutManager
        binding.csvJob.adapter = adapter
    }

    private fun setCardStackListener() {
        cardStackListener = object : CardStackListener {
            override fun onCardDragging(direction: Direction?, ratio: Float) {
                topJobOfferId = null
                topJobOfferId = cardStackLayoutManager.topView.findViewById<TextView>(R.id.tv_job_offer_id).text.toString()
                val overlay = cardStackLayoutManager.topView.findViewById<ConstraintLayout>(R.id.cl_overlay)
                val overlayLabel = cardStackLayoutManager.topView.findViewById<TextView>(R.id.tv_overlay_label)
                overlay.visibility = View.VISIBLE
                direction?.let {
                    when(direction){
                        Direction.Left -> {
                            overlay.setBackgroundColor(resources.getColor(R.color.trans_red))
                            overlayLabel.text = "Refuse"
                        }
                        Direction.Top -> {
                            overlay.setBackgroundColor(resources.getColor(R.color.trans_purple))
                            overlayLabel.text = "Share"
                        }
                        Direction.Right -> {
                            overlay.setBackgroundColor(resources.getColor(R.color.transBlue))
                            overlayLabel.text = "Wishlist"
                        }
                        else -> { overlay.visibility = View.GONE}
                    }
                }
            }
            override fun onCardSwiped(direction: Direction?) {
                swipedJobOffer = null
                for (job in jobOfferList.iterator()){
                    if (topJobOfferId != null){
                        if (job.jobOfferId == topJobOfferId){
                            swipedJobOffer = job
                        }
                    }
                }
                when(direction){
                    Direction.Left -> {
                        if (swipedJobOffer != null){
                            addToRefuseJob(1) // type 1 to add job in refused list
                        }
                    }
                    Direction.Top -> {
                        shareJob() }
                    Direction.Right -> {
                        if (swipedJobOffer != null){
                            addToWishlistJob()
                        }
                    }
                    else -> {}
                }
            }
            override fun onCardRewound() {
                rewindJobOffer = null
                rewindJobOfferId = null
                cardStackLayoutManager.topView.findViewById<ConstraintLayout>(R.id.cl_overlay).visibility = View.GONE
                rewindJobOfferId = cardStackLayoutManager.topView.findViewById<TextView>(R.id.tv_job_offer_id).text.toString()
                for (job in jobOfferList.iterator()){
                    if (rewindJobOfferId != null){
                        if (job.jobOfferId == rewindJobOfferId){
                            rewindJobOffer = job
                        }
                    }
                }
                if (wishlistAddedJobsId.contains(rewindJobOfferId)){
                    if (rewindJobOffer != null){
                        removeJobFromWishlist()
                        wishlistAddedJobsId.remove(rewindJobOfferId)
                    }
                }else if (refuseJobsId.contains(rewindJobOfferId)){
                    if (rewindJobOffer != null){
                        removeJobFromRefuse(2)
                        refuseJobsId.remove(rewindJobOfferId)
                    }
                }
            }
            override fun onCardCanceled() {
                cardStackLayoutManager.topView.findViewById<ConstraintLayout>(R.id.cl_overlay).visibility = View.GONE
            }
            override fun onCardAppeared(view: View?, position: Int) {}
            override fun onCardDisappeared(view: View?, position: Int) {}
        }

    }

    private fun removeJobFromRefuse(type: Int) {
        ParseCloud.callFunctionInBackground(ParseCloudFunction.dropoutActions.toString(), hashMapOf("jobOfferId" to rewindJobOffer!!.jobOfferId, "myID" to requireContext().getUserId(), "type" to type), FunctionCallback<Any> { result, e ->
            when {
                e != null -> {
                    toast("${e.message.toString()}")
                }
                result == null -> {
                    toast("No result found")
                }
                else -> {}
            }
        })
    }

    private fun removeJobFromWishlist() {
        ParseCloud.callFunctionInBackground(ParseCloudFunction.removeFromWishlist.toString(), hashMapOf("jobOfferId" to rewindJobOffer!!.jobOfferId, "myID" to requireContext().getUserId()), FunctionCallback<Any> { result, e ->
            when {
                e != null -> {
                    toast("${e.message.toString()}")
                }
                result == null -> {
                    toast("No result found")
                }
                else -> {}
            }
        })
    }

    private fun addToWishlistJob() {
        wishlistAddedJobsId.add(swipedJobOffer!!.jobOfferId)
        ParseCloud.callFunctionInBackground(ParseCloudFunction.addJobToWishlist.toString(), hashMapOf("jobOfferId" to swipedJobOffer!!.jobOfferId, "myID" to requireContext().getUserId()), FunctionCallback<Any> { result, e ->
            when {
                e != null -> {
                    toast("${e.message.toString()}")
                }
                result == null -> {
                    toast("No result found")
                }
                else -> {}
            }
        })
    }

    private fun addToRefuseJob(type: Int) {
        refuseJobsId.add(swipedJobOffer!!.jobOfferId)
        ParseCloud.callFunctionInBackground(ParseCloudFunction.dropoutActions.toString(), hashMapOf("jobOfferId" to swipedJobOffer!!.jobOfferId, "myID" to requireContext().getUserId(), "type" to type), FunctionCallback<Any> { result, e ->
            when {
                e != null -> {
                    toast("${e.message.toString()}")
                }
                result == null -> {
                    toast("No result found")
                }
                else -> {}
            }
        })
    }

    private fun setClickListeners() {
        binding.fabRewind.setOnClickListener {
            binding.csvJob.rewind()
        }
        binding.fabRefuse.setOnClickListener {
            val setting = SwipeAnimationSetting.Builder().setDirection(Direction.Left).setDuration(200).setInterpolator(
                AccelerateInterpolator()
            ).build()
            cardStackLayoutManager.setSwipeAnimationSetting(setting)
            binding.csvJob.swipe()
        }
        binding.fabShare.setOnClickListener {
            val setting = SwipeAnimationSetting.Builder().setDirection(Direction.Top).setDuration(200).setInterpolator(
                AccelerateInterpolator()
            ).build()
            cardStackLayoutManager.setSwipeAnimationSetting(setting)
            binding.csvJob.swipe()
        }
        binding.fabApply.setOnClickListener {
            val setting = SwipeAnimationSetting.Builder().setDirection(Direction.Right).setDuration(200).setInterpolator(
                AccelerateInterpolator()
            ).build()
            cardStackLayoutManager.setSwipeAnimationSetting(setting)
            binding.csvJob.swipe()
        }
    }

    private fun shareJob() {
        var sharedJobOffer: NewJobOffer? = null
        for (job in jobOfferList.iterator()){
            if (topJobOfferId != null){
                if (job.jobOfferId == topJobOfferId){
                    sharedJobOffer = job
                }
            }
        }

        if (sharedJobOffer != null){
            val builder = Uri.Builder()
            builder.scheme("https")
                .authority("jobamax.page.link")
                .appendPath(FirebaseDynamicLinkPath.shareJobOffer.toString())
                .appendQueryParameter("jobOfferId", sharedJobOffer.jobOfferId)
                .appendQueryParameter("jobSeekerId", requireContext().getUserId())
            val myUrl: String = builder.build().toString()
            val dynamicLink = Firebase.dynamicLinks.dynamicLink {
                link = Uri.parse(myUrl)
                domainUriPrefix = "https://jobamax.page.link"
                androidParameters("com.findajob.jobamax") {
                }
            }
            val shareIntent = Intent.createChooser(Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, dynamicLink.uri.toString())
                type = "text/plain"
            }, "It is job offer link")
            startActivity(shareIntent)
        }
    }



}

class SeekerJobCardStackAdapter(var list : ArrayList<NewJobOffer>)  : RecyclerView.Adapter<SeekerJobCardStackAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
        ItemSeekerJobCardBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val jobOffer = list[position]
        holder.binding.apply {
            this.tvJobOfferId.text = jobOffer.jobOfferId
            this.clOverlay.visibility = View.GONE
            if(jobOffer.profilePicUrl.isNotEmpty()){
                Picasso.get().load(jobOffer.profilePicUrl).into(this.ivCompany)
            }
            this.tvCompanyName.text = jobOffer.companyName
        }
    }
    override fun getItemCount(): Int = list.size
    fun submitList(arrList: ArrayList<NewJobOffer>) {
        list = arrList
    }
    class ViewHolder(val binding: ItemSeekerJobCardBinding) : RecyclerView.ViewHolder(binding.root)
}