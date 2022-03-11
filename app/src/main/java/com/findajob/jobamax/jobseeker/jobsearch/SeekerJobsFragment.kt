package com.findajob.jobamax.jobseeker.jobsearch

import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.text.Html
import android.text.method.LinkMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AccelerateInterpolator
 import android.view.animation.LinearInterpolator
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.findajob.jobamax.R
import com.findajob.jobamax.base.BaseFragmentMain
import com.findajob.jobamax.data.pojo.HardSkill
import com.findajob.jobamax.databinding.FragmentSeekerJobsBinding
import com.findajob.jobamax.databinding.ItemSeekerJobCardBinding
import com.findajob.jobamax.databinding.ItemSeekerPreviewHardSkillBinding
import com.findajob.jobamax.dialog.JobReportDialog
import com.findajob.jobamax.enums.FirebaseDynamicLinkPath
import com.findajob.jobamax.enums.ParseCloudFunction
import com.findajob.jobamax.enums.ParseTableFields
import com.findajob.jobamax.enums.ParseTableName
import com.findajob.jobamax.jobseeker.home.JobSeekerHomeViewModel
import com.findajob.jobamax.jobseeker.model.JobSeekerJobFilter
 import com.findajob.jobamax.model.NewJobOffer
import com.findajob.jobamax.preference.getJobSeekerJobFilter
import com.findajob.jobamax.preference.getUserId
import com.findajob.jobamax.util.log
import com.findajob.jobamax.util.toast
import com.google.android.material.chip.Chip
import com.google.firebase.dynamiclinks.ktx.androidParameters
import com.google.firebase.dynamiclinks.ktx.dynamicLink
import com.google.firebase.dynamiclinks.ktx.dynamicLinks
import com.google.firebase.ktx.Firebase
import com.google.gson.Gson
import com.parse.FunctionCallback
import com.parse.ParseCloud
import com.parse.ParseObject
import com.parse.ParseQuery
import com.squareup.picasso.Picasso
import com.yuyakaido.android.cardstackview.*
import dagger.hilt.android.AndroidEntryPoint
import org.json.JSONObject


@AndroidEntryPoint
class SeekerJobsFragment : BaseFragmentMain<FragmentSeekerJobsBinding>() {

    override val layoutRes: Int get() = R.layout.fragment_seeker_jobs
    val viewModel: JobSeekerHomeViewModel by activityViewModels()
    override fun getViewModel(): ViewModel = viewModel

    lateinit var hardSkillAdapter: SeekerJobHardSkillAdapter

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

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentSeekerJobsBinding.inflate(inflater, container, false)
        configureUi()
        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.N)
    private fun configureUi() {

        if (requireArguments().getString("jobSeekerId") != null){
            jobSeekerId = requireArguments().getString("jobSeekerId")
        }
        if (requireArguments().getString("jobOfferId") != null){
            jobOfferId = requireArguments().getString("jobOfferId")
        }

         setClickListeners()
        setCardStackView()
        viewModelObserver()
        setHardSkillAdapter()
    }

    private fun viewModelObserver() {
        viewModel.isJobSeekerUpdated.observe(viewLifecycleOwner) {
            progressHud.dismiss()
            if (it) {
                binding.jobSeeker = viewModel.jobSeeker
            }
        }
    }

    override fun onCreated(savedInstance: Bundle?) {
        if (viewModel.jobSeekerObject == null){
            getCurrent()
        }
        binding.jobSeeker = viewModel.jobSeeker
        getJobOffers()
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




    private fun getJobOffers() {
        var param = HashMap<String, Any>()
        if (jobOfferId != ""){
            param = hashMapOf("jobSeekerId" to requireContext().getUserId(), "isFilterApply " to false, "jobOfferId" to jobOfferId!! )
        }else{
            if (requireContext().getJobSeekerJobFilter() == "" ){
                param = hashMapOf("jobSeekerId" to requireContext().getUserId(), "isFilterApply " to false, "jobOfferId" to jobOfferId!! )
                log("dfffkdk $param")
            }else{
                val jobSeekerJobFilter = Gson().fromJson(requireContext().getJobSeekerJobFilter(), JobSeekerJobFilter::class.java)
                param["searchString"] = if (jobSeekerJobFilter.searchString == null) "" else jobSeekerJobFilter.searchString!!
                param["distance"] = if (jobSeekerJobFilter.distance == null) 0 else jobSeekerJobFilter.distance!!
                param["location"] = if (jobSeekerJobFilter.location == null) "" else jobSeekerJobFilter.location!!
                param["lat"] = if (jobSeekerJobFilter.lat == null) 0.0 else jobSeekerJobFilter.lat!!
                param["lng"] = if (jobSeekerJobFilter.lng == null) 0.0 else jobSeekerJobFilter.lng!!
                param["industry"] = if (jobSeekerJobFilter.industry == null) "" else jobSeekerJobFilter.industry!!
                param["typeOfWork"] = jobSeekerJobFilter.typeOfWork.ifEmpty { emptyList() }
                param["experience"] = jobSeekerJobFilter.experience.ifEmpty { emptyList() }
            }
        }

        progressHud.show()
        ParseCloud.callFunctionInBackground(ParseCloudFunction.getJobSearch.toString(), param, FunctionCallback<ArrayList<Any>> { result, e ->
            progressHud.dismiss()
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
                    log("dfkldk ${list.size}")
                    adapter.submitList(jobOfferList)
                    adapter.notifyDataSetChanged()
                    setMatchPercentage()
                }
            }
        })
    }

    private fun setMatchPercentage() {
        var topJobOffer: NewJobOffer? = null
      /*  topJobOfferId = null
        try {
            topJobOfferId = cardStackLayoutManager.topView.findViewById<TextView>(R.id.tv_job_offer_id).text.toString()
        }catch (e: Exception){}*/
        if (topJobOfferId != null){
            for (job in jobOfferList.iterator()){
                if (topJobOfferId != null){
                    if (job.jobOfferId == topJobOfferId){
                        topJobOffer = job
                    }
                }
            }
        }
        if (topJobOffer != null ){
            binding.pcvMatch.setProgress(topJobOffer.matchesPercentage.toFloat(), true)
        }
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

        adapter.seeDescriptionClick = { job ->
            binding.csvJob.visibility = View.GONE
            binding.llFloatButtons.visibility = View.GONE
            binding.nsvCard.visibility = View.VISIBLE
           binding.lJob.acbSeeJobDesc.text = "less job description"
            binding.nsvCard.scrollTo(0, 0)
            setJobInfo(job)
        }
        adapter.onJobsEnd = {
            getJobOffers()
        }

        adapter.reportFlagClick = {
            JobReportDialog(requireActivity()).show()
        }
        binding.lJob.acbSeeJobDesc.setOnClickListener {
            binding.csvJob.visibility = View.VISIBLE
            binding.llFloatButtons.visibility = View.VISIBLE
            binding.nsvCard.visibility = View.GONE
        }
    }

    private fun setJobInfo(job: NewJobOffer) {
        binding.lJob.apply {
            this.tvJobTitle.text = job.jobTitle
            this.tvCompanyAddress.text = job.city
            this.tvJobType.text = job.typeOfWork
            this.tvAboutJob.text = job.description
            this.tvAboutCompany.text = job.aboutOfCompany
            this.tvCompanyName.text = job.companyName
            this.tvIndustry.text = job.industry


            if(job.profilePicUrl.isNotEmpty()){
                Picasso.get().load(job.profilePicUrl).into(this.ivCompany)
            }else{
                this.ivCompany.setImageResource(R.drawable.ic_company)
            }

            binding.lJob.tvCompanyUrl.movementMethod = LinkMovementMethod.getInstance()
            binding.lJob.tvCompanyUrl.text = Html.fromHtml(String.format("<a href=\"%s\">see company profile</a> ", job.jobUrl))

            var hardSkills = ArrayList<HardSkill>()
            //get the hard skill from job object and put in recycler view
            hardSkillAdapter.submitList(arrayListOf())
            hardSkillAdapter.notifyDataSetChanged()

            this.cgSoftSkill.removeAllViews()
            job.softSkills.forEach {
                val chip = layoutInflater.inflate(R.layout.item_custom_chip, this.cgSoftSkill, false) as Chip
                chip.text = it
                this.cgSoftSkill.addView(chip)
            }

            if (job.companyName.isEmpty()){
                binding.lJob.tvCompanyName.visibility = View.GONE
            }else{
                binding.lJob.tvCompanyName.visibility = View.VISIBLE
            }
            if (job.description.isEmpty()){
                binding.lJob.llAboutJob.visibility = View.GONE
            }else{
                binding.lJob.llAboutJob.visibility = View.VISIBLE
            }

            if (job.aboutOfCompany.isEmpty()){
                binding.lJob.llAboutCompany.visibility = View.GONE
            }else{
                binding.lJob.llAboutCompany.visibility = View.VISIBLE
            }

            if (job.hardSkills.isEmpty()){
                binding.lJob.llHardSkill.visibility = View.GONE
            }else{
                binding.lJob.llHardSkill.visibility = View.VISIBLE
            }

            if (job.softSkills.isEmpty()){
                binding.lJob.llSoftSkill.visibility = View.GONE
            }else{
                binding.lJob.llSoftSkill.visibility = View.VISIBLE
            }

            if (job.industry.isEmpty()){
                binding.lJob.llIndustry.visibility = View.GONE
            }else{
                binding.lJob.llIndustry.visibility = View.VISIBLE
            }

            if (job.salary.isEmpty()){
                binding.lJob.llSalary.visibility = View.GONE
            }else{
                binding.lJob.llSalary.visibility = View.VISIBLE
            }

            if (job.benefits.isEmpty()){
                binding.lJob.llBenefits.visibility = View.GONE
            }else{
                binding.lJob.llBenefits.visibility = View.VISIBLE
            }

            if (job.workplaceVibes.isEmpty()){
                binding.lJob.llWorkspace.visibility = View.GONE
            }else{
                binding.lJob.llWorkspace.visibility = View.VISIBLE
            }



            log("dkfksd jobUrl ${job.jobUrl}")
            log("dkfksd aboutOfCompany ${job.aboutOfCompany}")
            log("dkfksd benefits ${job.benefits}")
            log("dkfksd city ${job.city}")
            log("dkfksd companyName ${job.companyName}")
            log("dkfksd description ${job.description}")
            log("dkfksd industry ${job.industry}")
            log("dkfksd evolutionPerspective ${job.evolutionPerspective}")
            log("dkfksd companyId ${job.companyId}")
            log("dkfksd isMonthlySalary ${job.isMonthlySalary}")
            log("dkfksd jobOfferId ${job.jobOfferId}")
            log("dkfksd jobType ${job.jobType}")
            log("dkfksd matches ${job.matches}")
            log("dkfksd matchesPercentage ${job.matchesPercentage}")
            log("dkfksd profilePicUrl ${job.profilePicUrl}")
            log("dkfksd jobTitle ${job.jobTitle}")
            log("dkfksd salary ${job.salary}")
            log("dkfksd softSkills ${job.softSkills}")
            log("dkfksd hardSkills ${job.hardSkills}")
            log("dkfksd workplaceVibes ${job.workplaceVibes}")
            log("dkfksd subMatches ${job.subMatches}")
            log("dkfksd typeOfWork ${job.typeOfWork}")
        }
    }

    private fun setHardSkillAdapter() {
        val ownedHardSkills = ArrayList<HardSkill>()
        hardSkillAdapter = SeekerJobHardSkillAdapter(ownedHardSkills)
        binding.lJob.rvHardSkill.adapter = hardSkillAdapter
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
                            overlayLabel.text = resources.getString(R.string.refuse)
                            overlayLabel.rotation = 315F
                        }
                        Direction.Top -> {
                            overlay.setBackgroundColor(resources.getColor(R.color.trans_purple))
                            overlayLabel.text = resources.getString(R.string.share)
                            overlayLabel.rotation = 0F
                        }
                        Direction.Right -> {
                            overlay.setBackgroundColor(resources.getColor(R.color.transBlue))
                            overlayLabel.text = resources.getString(R.string.wishlist)
                            overlayLabel.rotation = 45F
                        }
                        else -> { overlay.visibility = View.GONE}
                    }
                }
                setMatchPercentage()
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
                    Direction.Top -> { shareJob() }
                    Direction.Right -> {
                        if (swipedJobOffer != null){
                            addToWishlistJob()
                        }
                    }
                    else -> {}
                }
                setMatchPercentage()
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
        ParseCloud.callFunctionInBackground(ParseCloudFunction.dropoutActions.toString(), hashMapOf("jobOfferId" to rewindJobOffer!!.jobOfferId, "jobSeekerId" to requireContext().getUserId(), "type" to type), FunctionCallback<Any> { result, e ->
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
        ParseCloud.callFunctionInBackground(ParseCloudFunction.removeFromWishlist.toString(), hashMapOf("jobOfferId" to rewindJobOffer!!.jobOfferId, "jobSeekerId" to requireContext().getUserId()), FunctionCallback<Any> { result, e ->
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
        ParseCloud.callFunctionInBackground(ParseCloudFunction.addJobToWishlist.toString(), hashMapOf("jobOfferId" to swipedJobOffer!!.jobOfferId, "jobSeekerId" to requireContext().getUserId()), FunctionCallback<Any> { result, e ->
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
        ParseCloud.callFunctionInBackground(ParseCloudFunction.dropoutActions.toString(), hashMapOf("jobOfferId" to swipedJobOffer!!.jobOfferId, "jobSeekerId" to requireContext().getUserId(), "type" to type), FunctionCallback<Any> { result, e ->
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

    @RequiresApi(Build.VERSION_CODES.N)
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



        binding.civUser.setOnClickListener { requireActivity().onBackPressed() }

        binding.ivBackButton.setOnClickListener {
            requireActivity().onBackPressed()
        }
        binding.ivFilterJob.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_seekerJobsFragment_to_seekerJobsFilterFragment, null))
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
    var seeDescriptionClick: (NewJobOffer) -> Unit = {}
    var reportFlagClick: (NewJobOffer) -> Unit = {}
    var onJobsEnd: () -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
        ItemSeekerJobCardBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val jobOffer = list[position]
        holder.binding.apply {
            this.tvJobOfferId.text = jobOffer.jobOfferId
            this.clOverlay.visibility = View.GONE

            if(jobOffer.profilePicUrl.isNotEmpty()){
                Picasso.get().load(jobOffer.profilePicUrl).into(this.ivCompany)
            }else{
                this.ivCompany.setImageResource(R.drawable.ic_company)
            }

            if( position+ 1 == list.size){
                onJobsEnd()
            }

            this.tvJobTitle.text = jobOffer.jobTitle
            this.tvAboutJob.text = jobOffer.description
            this.tvCompanyAddress.text = jobOffer.city
            this.tvJobType.text = jobOffer.typeOfWork
            this.tvAboutCompany.text = jobOffer.aboutOfCompany
            this.tvCompanyName.text = jobOffer.companyName
            if (jobOffer.companyName.isEmpty()){
                this.tvCompanyName.visibility = View.GONE
            }else{
                this.tvCompanyName.visibility = View.VISIBLE
            }
            this.acbSeeJobDesc.setOnClickListener {
                seeDescriptionClick(jobOffer)
            }
            this.ivReport.setOnClickListener {
                reportFlagClick(jobOffer)
            }
            if (jobOffer.description.isEmpty()){
                this.llAboutJob.visibility = View.GONE
            }else{
                this.llAboutJob.visibility = View.VISIBLE
            }
            if (jobOffer.aboutOfCompany.isEmpty()){
                this.llAboutCompany.visibility = View.GONE
            }else{
                this.llAboutCompany.visibility = View.VISIBLE
            }
        }
    }
    override fun getItemCount(): Int = list.size
    fun submitList(arrList: ArrayList<NewJobOffer>) {
        list = arrList
    }
    class ViewHolder(val binding: ItemSeekerJobCardBinding) : RecyclerView.ViewHolder(binding.root)
}

class SeekerJobHardSkillAdapter(var list : ArrayList<HardSkill>) : RecyclerView.Adapter<SeekerJobHardSkillAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
        ItemSeekerPreviewHardSkillBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val hardSkill = list[position]
        holder.binding.apply {
            this.tvHardSkill.text = hardSkill.skillName
            holder.binding.sbHardSkill.progress = hardSkill.skillLevel
            holder.binding.sbHardSkill.setOnTouchListener { _, _ -> true }
        }
    }
    override fun getItemCount(): Int = list.size
    fun submitList(ownedHardSkills: ArrayList<HardSkill>) {
        list = ownedHardSkills
    }

    class ViewHolder(val binding: ItemSeekerPreviewHardSkillBinding) : RecyclerView.ViewHolder(binding.root)
}