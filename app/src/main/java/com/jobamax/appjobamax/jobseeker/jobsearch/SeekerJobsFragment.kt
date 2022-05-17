package com.jobamax.appjobamax.jobseeker.jobsearch

import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.text.Editable
import android.text.Html
import android.text.TextWatcher
import android.text.method.LinkMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AccelerateInterpolator
import android.view.animation.LinearInterpolator
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.core.view.isVisible
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.chip.Chip
import com.google.firebase.dynamiclinks.ktx.androidParameters
import com.google.firebase.dynamiclinks.ktx.dynamicLink
import com.google.firebase.dynamiclinks.ktx.dynamicLinks
import com.google.firebase.ktx.Firebase
import com.google.gson.Gson
import com.jobamax.appjobamax.R
import com.jobamax.appjobamax.base.BaseFragmentMain
import com.jobamax.appjobamax.data.pojo.HardSkill
import com.jobamax.appjobamax.databinding.FragmentSeekerJobsBinding
import com.jobamax.appjobamax.databinding.ItemJobTitleBinding
import com.jobamax.appjobamax.databinding.ItemSeekerJobCardBinding
import com.jobamax.appjobamax.databinding.ItemSeekerPreviewHardSkillBinding
import com.jobamax.appjobamax.dialog.JobReportDialog
import com.jobamax.appjobamax.dialog.MessageDialog
import com.jobamax.appjobamax.enums.FirebaseDynamicLinkPath
import com.jobamax.appjobamax.enums.ParseCloudFunction
import com.jobamax.appjobamax.enums.ParseTableFields
import com.jobamax.appjobamax.enums.ParseTableName
import com.jobamax.appjobamax.jobseeker.home.JobSeekerHomeViewModel
import com.jobamax.appjobamax.jobseeker.model.JobSeekerJobFilter
import com.jobamax.appjobamax.model.NewJobOffer
import com.jobamax.appjobamax.preference.*
import com.jobamax.appjobamax.util.*
import com.parse.FunctionCallback
import com.parse.ParseCloud
import com.parse.ParseObject
import com.parse.ParseQuery
import com.squareup.picasso.Picasso
import com.yuyakaido.android.cardstackview.CardStackLayoutManager
import com.yuyakaido.android.cardstackview.CardStackListener
import com.yuyakaido.android.cardstackview.Direction
import com.yuyakaido.android.cardstackview.SwipeAnimationSetting
import org.json.JSONObject


class SeekerJobsFragment : BaseFragmentMain<FragmentSeekerJobsBinding>(){

    override val layoutRes: Int get() =  R.layout.fragment_seeker_jobs
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

    lateinit var jobTitleAdapter: SeekerJobTitleAdapter
    var jobTitles = arrayListOf<String>()
    var isJobTitleSelected = false



    var runnable: Runnable = object : Runnable {
        override fun run() {
            try {
                topJobOfferId = cardStackLayoutManager.topView.findViewById<TextView>(R.id.tv_job_offer_id).text.toString()
                setMatchPercentage()
            }catch (e: Exception){}
            handler.postDelayed(this, 2000)
        }
    }

    var handler: Handler = Handler()

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentSeekerJobsBinding.inflate(inflater, container, false)
        configureUi()
        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.N)
    private fun configureUi() {
        val bundle = requireActivity().intent?.extras
        if (bundle != null) {
            jobSeekerId = bundle.getString("jobSeekerId")
            jobOfferId = bundle.getString("jobOfferId")
        }


        setClickListeners()
        setCardStackView()
        viewModelObserver()
        setHardSkillAdapter()
        setFilterStateIcon()
        setJobTypeRecyclerview()

    }

    override fun onStart() {
        super.onStart()
        requireContext().setJobSearchScreenEnterTime((System.currentTimeMillis() / 1000).toString())
    }

    override fun onDestroyView() {
        super.onDestroyView()
        saveSpentTimeOnJobSearch()
    }

    private fun saveSpentTimeOnJobSearch() {
        if (requireContext().getJobSearchScreenEnterTime() != ""){
            val request = HashMap<String, Any>().also {
                it["jobSeekerId"] = requireContext().getUserId()
                it["enterTime"] = requireContext().getJobSearchScreenEnterTime().toLong()
                it["leaveTime"] = System.currentTimeMillis() / 1000
                it["type"] = 1
            }
            ParseCloud.callFunctionInBackground(ParseCloudFunction.SAVE_SPENT_TIME.value, request, FunctionCallback<Any> { result, e ->
                if (e != null) {
                    try {
                        toast(e.message.toString())
                    }catch (e: Exception){}
                }
                try {
                    requireContext().setJobSearchScreenEnterTime("")
                }catch (e : Exception){}
            })
        }
        requireContext().setJobSearchScreenEnterTime("")
    }


    override fun onResume() {
        super.onResume()
        handler.postDelayed(runnable,20000)
        runnable.run()
    }

    override fun onPause() {
        super.onPause()
        handler.removeCallbacks(runnable)
    }

    private fun setJobKeyword() {
        if (requireContext().getJobSeekerJobFilter() != ""){
            val jobSeekerJobFilter = Gson().fromJson(requireContext().getJobSeekerJobFilter(), JobSeekerJobFilter::class.java)
            isJobTitleSelected = true
            binding.etJobKeyword.setText(jobSeekerJobFilter.searchString)
            isJobTitleSelected = true
        }
    }

    private fun setJobTypeRecyclerview() {
        jobTitleAdapter =  SeekerJobTitleAdapter(jobTitles)
        binding.rvJobTypes.adapter = jobTitleAdapter
        jobTitleAdapter.onJobTypeClick = {
            isJobTitleSelected = true
            binding.etJobKeyword.setText(it)
            binding.rvJobTypes.visibility = View.GONE
            binding.etJobKeyword.clearFocus()
            updateJobs()
        }
        if (jobTitles.isEmpty()){
            binding.rvJobTypes.visibility = View.GONE
        }
    }

    private fun setFilterStateIcon() {
        if (requireContext().getJobSeekerJobFilter() == "") {
            binding.vFilterState.visibility = View.GONE
        } else {
            binding.vFilterState.visibility = View.VISIBLE
        }

    }

    private fun viewModelObserver() {
        viewModel.isJobSeekerUpdated.observe(viewLifecycleOwner) {
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
        setJobKeyword()
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




    private fun getJobOffers() {
        var param = HashMap<String, Any>()
        if (jobOfferId != ""){
            param = hashMapOf("jobSeekerId" to requireContext().getUserId(), "isFilterApply " to false, "jobOfferId" to jobOfferId!! )
        }else{
            if (requireContext().getJobSeekerJobFilter() == "" ){
                param["jobSeekerId"]  =  requireContext().getUserId()
                param["isFilterApply"]  = false
                param["latitude"]  = getCurrentLatitude()
                param["longitude"]  = getCurrentLongitude()
            }else{
                val jobSeekerJobFilter = Gson().fromJson(requireContext().getJobSeekerJobFilter(), JobSeekerJobFilter::class.java)
                param["searchString"] = if (jobSeekerJobFilter.searchString == null) "" else jobSeekerJobFilter.searchString!!
                param["jobSeekerId"] = requireContext().getUserId()
                param["isFilterApply"] = true
                param["distance"] = if (jobSeekerJobFilter.distance == null) 0 else jobSeekerJobFilter.distance!!
                param["location"] = if (jobSeekerJobFilter.location == null) "" else jobSeekerJobFilter.location!!
                param["latitude"] = if (jobSeekerJobFilter.latitude == null) getCurrentLatitude() else jobSeekerJobFilter.latitude!!
                param["longitude"] = if (jobSeekerJobFilter.longitude == null) getCurrentLongitude() else jobSeekerJobFilter.longitude!!
                param["industry"] = jobSeekerJobFilter.industry
                param["companyName"] = if (jobSeekerJobFilter.companyName == null) "" else jobSeekerJobFilter.companyName!!
                param["typeOfWork"] = jobSeekerJobFilter.typeOfWork.ifEmpty { emptyList() }
                param["experience"] = jobSeekerJobFilter.experience.ifEmpty { emptyList() }
            }
        }

        log("fjlksdkl $param")
        progressHud.show()
        ParseCloud.callFunctionInBackground(ParseCloudFunction.GET_JOB_SEARCH.value, param, FunctionCallback<ArrayList<Any>> { result, e ->
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
                    adapter.submitList(jobOfferList)
                    adapter.notifyDataSetChanged()
                    setMatchPercentage()
                    if (jobOfferList.isEmpty()){
                        MessageDialog(requireActivity(), resources.getString(R.string.no_jobs_available)) {}.show()
                    }
                }
            }
        })
    }



    private fun setMatchPercentage() {
        var topJobOffer: NewJobOffer? = null
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
            binding.pcvMatch.setProgress(topJobOffer.matchesPercentage.toDouble(), 100.0)
            setPercentageChartViewColor(topJobOffer.matchesPercentage.toInt())
        }
    }

    private fun setPercentageChartViewColor(progress: Int) {
        when(progress){
            in 0..20 -> {
                binding.pcvMatch.progressColor = resources.getColor(R.color.red)
            }
            in 21..49 -> {
                binding.pcvMatch.progressColor = resources.getColor(R.color.orange)
            }
            in 50..61 -> {
                binding.pcvMatch.progressColor = resources.getColor(R.color.yellow)
            }
            in 62..79 -> {
                binding.pcvMatch.progressColor = resources.getColor(R.color.dark_green)
            }
            in 80..100 -> {
                binding.pcvMatch.progressColor = resources.getColor(R.color.green)
            }
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
            binding.llRewind.visibility = View.GONE
            binding.lJob.rootLayout.visibility = View.VISIBLE
            binding.clSearchBar.visibility = View.GONE
            binding.lJob.acbSeeJobDesc.text = resources.getString(R.string.see_less)
            binding.nsvCard.scrollTo(0, 0)
            setJobInfo(job)
            val set = ConstraintSet()
            set.clone(binding.clMostParent)
            set.connect(binding.nsvCard.id, ConstraintSet.TOP, binding.csvJob.id, ConstraintSet.BOTTOM , 10)
            set.applyTo(binding.clMostParent)
        }

        adapter.reportFlagClick = {
            JobReportDialog(requireActivity()).show()
        }
        binding.lJob.acbSeeJobDesc.setOnClickListener {
            binding.csvJob.visibility = View.VISIBLE
            binding.lJob.rootLayout.visibility = View.GONE
            binding.llRewind.visibility = View.VISIBLE
            binding.clSearchBar.visibility = View.VISIBLE
            val set = ConstraintSet()
            set.clone(binding.clMostParent)
            set.clear(binding.nsvCard.id, ConstraintSet.TOP)
            set.applyTo(binding.clMostParent)
        }
    }

    private fun setJobInfo(job: NewJobOffer) {
        binding.lJob.apply {
            this.tvJobTitle.text = job.jobTitle
            this.tvCompanyAddress.text = job.location
            if (job.typeOfWork == ""){
                this.tvJobType.visibility = View.GONE
            }else{
                this.tvJobType.visibility = View.VISIBLE
            }
            this.tvJobType.text = job.typeOfWork
            this.tvAboutJob.text = job.description
            this.tvAboutCompany.text = job.aboutOfCompany
            this.tvCompanyName.text = job.companyName
            this.tvIndustry.text = job.industry


            if(job.companyLogo.isNotEmpty()){
                Picasso.get().load(job.companyLogo).into(this.ivCompany)
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
                            overlay.setBackgroundResource(R.drawable.rounded_red_box_trans)
                            overlayLabel.text = resources.getString(R.string.refuse)
                            overlayLabel.rotation = 315F
                        }
                        Direction.Top -> {
                            overlay.setBackgroundResource(R.drawable.rounded_purpal_box_trans)
                            overlayLabel.text = resources.getString(R.string.share)
                            overlayLabel.rotation = 0F
                        }
                        Direction.Right -> {
                            overlay.setBackgroundResource(R.drawable.rounded_blue_box_trans)
                            overlayLabel.text = resources.getString(R.string.wishlist_job_card_overlay)
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
                    Direction.Top -> {
                        shareJob()
                        saveSwipeCount()
                    }
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


        binding.csvJob.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
            }

            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if(cardStackLayoutManager.childCount == 0){
                    getJobOffers()
                }
            }
        })
    }

    private fun saveSwipeCount() {
        ParseCloud.callFunctionInBackground(ParseCloudFunction.SAVE_SWIPE_COUNT.value, hashMapOf( "jobSeekerId" to requireContext().getUserId(), "type" to 3), FunctionCallback<Any> { result, e ->
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

    private fun removeJobFromRefuse(type: Int) {
        ParseCloud.callFunctionInBackground(ParseCloudFunction.DROPOUT_ACTIONS.value, hashMapOf("jobOfferId" to rewindJobOffer!!.jobOfferId, "jobSeekerId" to requireContext().getUserId(), "type" to type), FunctionCallback<Any> { result, e ->
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
        ParseCloud.callFunctionInBackground(ParseCloudFunction.REMOVE_FROM_WISHLIST.value, hashMapOf("jobOfferId" to rewindJobOffer!!.jobOfferId, "jobSeekerId" to requireContext().getUserId()), FunctionCallback<Any> { result, e ->
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
        ParseCloud.callFunctionInBackground(ParseCloudFunction.ADD_JOB_TO_WISHLIST.value, hashMapOf("jobOfferId" to swipedJobOffer!!.jobOfferId, "jobSeekerId" to requireContext().getUserId()), FunctionCallback<Any> { result, e ->
            when {
                e != null -> {
                    toast("${e.message.toString()}")
                }
                result == null -> {
                    toast("No result found")
                }
                else -> {
                    toast(getString(R.string.added_successfully_to_wishlist))

                    swipedJobOffer?.jobUrl?.let {
                        startActivity(Intent(requireContext(), SeekerJobWebActivity::class.java).putExtra(ARG_WEB_URL, it))
                    }
                }
            }
        })
    }


    private fun addToRefuseJob(type: Int) {
        refuseJobsId.add(swipedJobOffer!!.jobOfferId)
        ParseCloud.callFunctionInBackground(ParseCloudFunction.DROPOUT_ACTIONS.value, hashMapOf("jobOfferId" to swipedJobOffer!!.jobOfferId, "jobSeekerId" to requireContext().getUserId(), "type" to type), FunctionCallback<Any> { result, e ->
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
            if (binding.lJob.rootLayout.isVisible){
                binding.lJob.acbSeeJobDesc.performClick()
            }
            val setting = SwipeAnimationSetting.Builder().setDirection(Direction.Left).setDuration(200).setInterpolator(AccelerateInterpolator()).build()
            cardStackLayoutManager.setSwipeAnimationSetting(setting)
            binding.csvJob.swipe()
        }
        binding.fabShare.setOnClickListener {
            if (binding.lJob.rootLayout.isVisible){
                binding.lJob.acbSeeJobDesc.performClick()
            }
            val setting = SwipeAnimationSetting.Builder().setDirection(Direction.Top).setDuration(200).setInterpolator(
                AccelerateInterpolator()
            ).build()
            cardStackLayoutManager.setSwipeAnimationSetting(setting)
            binding.csvJob.swipe()
        }
        binding.fabApply.setOnClickListener {
            if (binding.lJob.rootLayout.isVisible){
                binding.lJob.acbSeeJobDesc.performClick()
            }
            val setting = SwipeAnimationSetting.Builder().setDirection(Direction.Right).setDuration(200).setInterpolator(
                AccelerateInterpolator()
            ).build()
            cardStackLayoutManager.setSwipeAnimationSetting(setting)
            binding.csvJob.swipe()
        }

        binding.ivSearchIcon.setOnClickListener {
            updateJobs()
        }


        binding.civUser.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_seekerJobsFragment_to_nav_seeker_profile, null))

        binding.ivBackButton.setOnClickListener {
            requireActivity().onBackPressed()
        }
        binding.ivFilterJob.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_seekerJobsFragment_to_seekerJobsFilterFragment, null))

        binding.etJobKeyword.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(text: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (binding.etJobKeyword.text.isNullOrEmpty()){
                    binding.rvJobTypes.visibility = View.GONE
                }else{
                    if (!isJobTitleSelected){
                        getJobTypes()
                    }
                    isJobTitleSelected = false
                }
            }
            override fun afterTextChanged(p0: Editable?) {}
        })

        binding.llMatchPercent.setOnClickListener {

            var topJobOffer: NewJobOffer? = null
            for (job in jobOfferList.iterator()){
                if (topJobOfferId != null){
                    if (job.jobOfferId == topJobOfferId){
                        topJobOffer = job
                    }
                }
            }
            if (topJobOffer == null){
                toast("Please drag little the top job card.")
            }else{
                val instance = SeekerJobMatchInfoDialogFragment.newInstance(topJobOffer, viewModel.jobSeeker.profilePicUrl)
                instance.show(childFragmentManager,"dialog")
                instance.onProfileClick ={
                    binding.civUser.performClick()
                }
            }
        }
        binding.ivFavorite.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_seekerJobsFragment_to_seekerWishListFragment, null))
    }

    private fun updateJobs() {
        if (!binding.etJobKeyword.text.isNullOrEmpty()) {
            updateJobFilter(binding.etJobKeyword.text.toString())
        }
        getJobOffers()
        setFilterStateIcon()
        if (!isJobTitleSelected) {
            addJobTitle()
        }
    }

    private fun addJobTitle() {
        ParseCloud.callFunctionInBackground(ParseCloudFunction.ADD_JOB_TITLE.value, hashMapOf<String, Any>("title" to binding.etJobKeyword.text.toString()), FunctionCallback<Any> { result, e ->
            when{
                e != null -> { toast(e.message.toString()) }
                result == null -> {}
                else -> {}
            }
        })
    }

    private fun getJobTypes() {
        ParseCloud.callFunctionInBackground(ParseCloudFunction.GET_JOB_TITLES.value, hashMapOf<String, Any>("search" to binding.etJobKeyword.text.toString()), FunctionCallback<ArrayList<String>> { result, e ->
            when{
                e != null -> { toast(e.message.toString()) }
                result == null -> {
                    binding.rvJobTypes.visibility = View.GONE
                }
                else -> {
                    binding.rvJobTypes.visibility = View.VISIBLE
                    jobTitleAdapter.submitList(result)
                    jobTitleAdapter.notifyDataSetChanged()
                }
            }
        })
    }

    private fun updateJobFilter(searchString: String) {
        val jobSeekerJobFilter = if (requireContext().getJobSeekerJobFilter() != ""){
            Gson().fromJson(requireContext().getJobSeekerJobFilter(), JobSeekerJobFilter::class.java)
        }else{
            JobSeekerJobFilter()
        }
        jobSeekerJobFilter.searchString = searchString
        requireContext().setJobSeekerJobFilter(Gson().toJson(jobSeekerJobFilter ))
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
                .appendPath(FirebaseDynamicLinkPath.SHARE_JOB_OFFER.value)
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
            startActivityForResult(shareIntent, 2)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        binding.csvJob.rewind()
    }


}


class SeekerJobCardStackAdapter(var list : ArrayList<NewJobOffer>)  : RecyclerView.Adapter<SeekerJobCardStackAdapter.ViewHolder>(){
    var seeDescriptionClick: (NewJobOffer) -> Unit = {}
    var reportFlagClick: (NewJobOffer) -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
        ItemSeekerJobCardBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val jobOffer = list[position]
        holder.binding.apply {
            this.tvJobOfferId.text = jobOffer.jobOfferId
            this.clOverlay.visibility = View.GONE

            if(jobOffer.companyLogo.isNotEmpty()){
                Picasso.get().load(jobOffer.companyLogo).into(this.ivCompany)
            }else{
                this.ivCompany.setImageResource(R.drawable.ic_company)
            }

            this.tvAboutJob.maxLines = 6
            this.llAboutCompany.visibility = View.INVISIBLE
            this.llHardSkill.visibility = View.INVISIBLE

            this.tvJobTitle.text = jobOffer.jobTitle
            this.tvAboutJob.text = jobOffer.description
            this.tvCompanyAddress.text = jobOffer.location
            if (jobOffer.typeOfWork == ""){
                this.tvJobType.visibility = View.GONE
            }else{
                this.tvJobType.visibility = View.VISIBLE
            }
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


class SeekerJobTitleAdapter(var list: ArrayList<String>) : RecyclerView.Adapter<SeekerJobTitleAdapter.ViewHolder>(){
    var onJobTypeClick : (String) -> Unit = {}
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
        ItemJobTitleBinding.inflate(LayoutInflater.from(parent.context), parent , false))
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.binding.tvText.text = item
        holder.binding.tvText.setOnClickListener {
            onJobTypeClick(item)
        }
    }
    override fun getItemCount(): Int = list.size
    fun submitList(result: ArrayList<String>) {
        list = result
    }

    class ViewHolder(val binding: ItemJobTitleBinding) : RecyclerView.ViewHolder(binding.root)
}