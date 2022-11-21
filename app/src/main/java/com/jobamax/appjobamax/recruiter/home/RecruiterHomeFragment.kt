package com.jobamax.appjobamax.recruiter.home

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.drawable.ClipDrawable
import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.LayerDrawable
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AccelerateInterpolator
import android.view.animation.LinearInterpolator
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.SeekBar
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isVisible
import androidx.core.view.updatePadding
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.jobamax.appjobamax.R
import com.jobamax.appjobamax.base.BaseFragment
import com.jobamax.appjobamax.databinding.FragmentRecruiterHomeBinding
import com.jobamax.appjobamax.databinding.ItemPortfolioLinkBinding
import com.jobamax.appjobamax.databinding.ItemRecruiterJobCardBinding
import com.jobamax.appjobamax.databinding.ItemSeekerHardSkillBinding
import com.jobamax.appjobamax.dialog.BasicDialog
import com.jobamax.appjobamax.enums.*
import com.jobamax.appjobamax.extensions.log
import com.jobamax.appjobamax.extensions.toast
import com.jobamax.appjobamax.jobseeker.build_profile.SeekerEducationAdapter
import com.jobamax.appjobamax.jobseeker.build_profile.SeekerExperienceListAdapter
import com.jobamax.appjobamax.jobseeker.build_profile.SeekerVolunteeringAdapter
import com.jobamax.appjobamax.model.*
import com.jobamax.appjobamax.preference.getUserId
import com.jobamax.appjobamax.recruiter.RecruiterHomeActivity
import com.jobamax.appjobamax.recruiter.RecruiterHomeViewModel
import com.jobamax.appjobamax.recruiter.dialog.JobMatchedDialog
import com.jobamax.appjobamax.recruiter.model.CompanySubscription
import com.jobamax.appjobamax.recruiter.model.JobTitleFilter
import com.jobamax.appjobamax.recruiter.model.RecruitmentSeeker
import com.jobamax.appjobamax.recruiter.model.SeekerFolder
import com.jobamax.appjobamax.recruiter.search.PortfolioImageAdapter2
import com.jobamax.appjobamax.singletons.MyParseLiveQueryClient
import com.jobamax.appjobamax.util.StudentStatus
import com.jobamax.appjobamax.util.getShader
import com.jobamax.appjobamax.util.loadImageFromUrl
import com.parse.*
import com.parse.livequery.SubscriptionHandling
import com.yuyakaido.android.cardstackview.CardStackLayoutManager
import com.yuyakaido.android.cardstackview.CardStackListener
import com.yuyakaido.android.cardstackview.Direction
import com.yuyakaido.android.cardstackview.SwipeAnimationSetting
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.json.JSONArray
import org.json.JSONObject
import java.util.*
import kotlin.collections.HashSet


class RecruiterHomeFragment : BaseFragment() {
    lateinit var binding: FragmentRecruiterHomeBinding

    val viewModel: RecruiterHomeViewModel by activityViewModels()

    lateinit var recruiter: Recruiter
    private var companySubscription: CompanySubscription? = null
    private var companySubscriptionHandling: SubscriptionHandling<ParseObject>? = null


    lateinit var adapter: RecruitmentSeekerJobCardStackAdapter
    lateinit var cardStackLayoutManager: CardStackLayoutManager
    lateinit var cardStackListener: CardStackListener

    lateinit var spinnerAdapter: JobTitleFilterSpinnerAdapter
    private val jobTitleFilterListTitleObject = JobTitleFilter("","Poster une nouvelle offre")
    private val jobTitleFilterListAddMoreObject = JobTitleFilter("","Poster une nouvelle offre")
    var jobTitleFilterList = arrayListOf(jobTitleFilterListTitleObject, jobTitleFilterListAddMoreObject)

    private var recruitmentSeekerList = arrayListOf<RecruitmentSeeker>()

    private val swipedRecruitmentSeekerList = arrayListOf<SwipedRecruitmentSeeker>()

    var topJobSeekerId: String? = null
    var rewindJobSeekerId: String? = null
    var currentJobOfferId = ""

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentRecruiterHomeBinding.inflate(inflater, container, false)
        configureUi()
        return binding.root
    }

    private fun configureUi() {
        setObserver()
        setClickListeners()
        initializeRecruiter()
        setCardStackView()
        binding.llFloatingBtn.viewTreeObserver.addOnGlobalLayoutListener {
            val dimens = IntArray(2) { 0 }
            binding.sp1.getLocationInWindow(dimens)
            val topPadding = dimens[1] + binding.sp1.height + 40
            val bottomPadding = binding.llFloatingBtn.height + 40
            binding.csvJob.setPadding(40,topPadding,40,bottomPadding)
        }

        binding.tvSubscription.paint.shader = getShader(binding.tvSubscription)


        setJobTitleFilterSpinnerAdapter()
        if (viewModel.jobTitleFilterList.value!!.isEmpty()){
            getJobTitleFilterList()
        }else{
            updateJobTitleFilterList()
        }
    }

    private fun subscribeCompanySubscription() {
        val parseQuery = ParseQuery<ParseObject>(ParseTableName.COMPANY_SUBSCRIPTION.value)
        parseQuery.whereEqualTo(ParseTableFields.COMPANY_ID.value, recruiter.companyId)
        companySubscriptionHandling = MyParseLiveQueryClient.parseLiveQueryClient.subscribe(parseQuery)
        companySubscriptionHandling?.let {
            companySubscriptionHandling!!.handleSubscribe {
                companySubscriptionHandling!!.handleEvent(SubscriptionHandling.Event.CREATE) { _: ParseQuery<ParseObject?>?, result: ParseObject? -> }
                companySubscriptionHandling!!.handleEvent(SubscriptionHandling.Event.DELETE) { _: ParseQuery<ParseObject?>?, result: ParseObject? -> }
                companySubscriptionHandling!!.handleEvent(SubscriptionHandling.Event.UPDATE) { _: ParseQuery<ParseObject?>?, result: ParseObject? ->
                    println("fdsjlkfsd ${gson.toJson(result)}")
                    result?.let {
                        lifecycleScope.launch(Dispatchers.Main){
                            viewModel.setCompanySubscription( CompanySubscription(it) )
                        }
                    }
                }
            }
        }
    }

    private fun fetchCompanySubscription() {
        val query = ParseQuery<ParseObject>(ParseTableName.COMPANY_SUBSCRIPTION.value)
        query.whereEqualTo(ParseTableFields.COMPANY_ID.value, recruiter.companyId)
        query.getFirstInBackground { result, e ->
            when{
                e != null -> toast(e.message.toString()+" Something Went Wrong.")
                result == null -> toast("Result Not Found.")
                else -> {
                    viewModel.setCompanySubscription( CompanySubscription(result) )
                }
            }
        }
    }

    private fun initializeRecruiter() {
        recruiter = viewModel.recruiter
        if (viewModel.recruiterObject == null) {
            (requireActivity() as RecruiterHomeActivity).getRecruiter {
                if (it) {
                    recruiter = viewModel.recruiter
                    setData()
                }
            }
        }else{
            setData()
        }
    }

    private fun setData() {
        getSeekerFolders()
        if(companySubscriptionHandling == null){
            subscribeCompanySubscription()
        }
        if (viewModel.companySubscription.value == null) {
            fetchCompanySubscription()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        val parseQuery = ParseQuery<ParseObject>(ParseTableName.COMPANY_SUBSCRIPTION.value)
        parseQuery.whereEqualTo(ParseTableFields.COMPANY_ID.value, recruiter.companyId)
        MyParseLiveQueryClient.parseLiveQueryClient.subscribe(parseQuery)
    }

    private fun getSeekerFolders() {
         ParseCloud.callFunctionInBackground(ParseCloudFunction.GET_FOLDERS_V1.value, hashMapOf<String,String>( ParseTableFields.COMPANY_ID.value to recruiter.companyId),
             FunctionCallback<Any> { result, e ->
                 if (e != null) {
                     log(e.message.toString()+" Something went wrong.")
                 }
                 if (result != null) {
                     val seekerFolderList = HashSet<SeekerFolder>()
                     try {
                         val jsonArray = JSONArray(gson.toJson(result))
                         for (i in 0 until jsonArray.length()){
                            seekerFolderList.add(gson.fromJson(jsonArray.getJSONObject(i).toString(), SeekerFolder::class.java))
                         }
                         viewModel.setSeekerFolders(seekerFolderList)
                     }catch (e: Exception){ }
                 }
             }
         )
    }

    private fun setObserver() {
        viewModel.jobTitleFilterList.observe(viewLifecycleOwner){ list ->
            updateJobTitleFilterList()
        }

        viewModel.companySubscription.observe(viewLifecycleOwner){
            companySubscription = it
            setSubscription()
        }
    }

    private fun setSubscription() {
        println("flsdk")
        binding.tvSubscription.text = "${companySubscription!!.usedJobOffer}/${companySubscription!!.totalJobOffers} available"
    }

    private fun setJobTitleFilterSpinnerAdapter() {
        spinnerAdapter = JobTitleFilterSpinnerAdapter(
            requireActivity(),
            R.layout.item_textview,
            jobTitleFilterList
        )
        binding.sp1.adapter = spinnerAdapter
        updateJobTitleFilterList()
        binding.sp1.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, view: View?, position: Int, p3: Long) {
                if (jobTitleFilterList[position].jobOfferId.isNotEmpty()) {
                    getRecruitmentSeekers(jobTitleFilterList[position].jobOfferId)
                    currentJobOfferId = jobTitleFilterList[position].jobOfferId
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {}
        }
        spinnerAdapter.onTitleClick = {
            binding.sp1.onDetachedFromWindow()
        }
        spinnerAdapter.onAddMoreClick = {
            (requireActivity() as RecruiterHomeActivity).binding.tabLayout.getTabAt(3)?.select()
        }
    }

    private fun getRecruitmentSeekers(jobOfferId: String) {
        val request = hashMapOf(ParseTableFields.JOB_OFFER_ID.value to jobOfferId, "selection" to 0)
        progressHud.show()
        ParseCloud.callFunctionInBackground(ParseCloudFunction.GET_RECRUITMENT_SEEKERS_V2.value, request, FunctionCallback<Any> { result, e ->
            progressHud.dismiss()
            when {
                e != null -> { toast(e.message.toString()) }
                result != null -> {
                    recruitmentSeekerList.clear()
                    val mainObject = JSONArray(gson.toJson(result))
                    for (i in 0 until mainObject.length()){
                        recruitmentSeekerList.add(gson.fromJson(mainObject.getJSONObject(i).toString(), RecruitmentSeeker::class.java))
                    }
                    if (recruitmentSeekerList.isEmpty()){
                        BasicDialog(requireActivity(), "Aucun candidat.", true, "sourcez"){
                            (requireActivity() as RecruiterHomeActivity).binding.tabLayout.getTabAt(1)?.select()
                        }.show()
                    }
                    adapter.submitList(recruitmentSeekerList)
                    adapter.notifyDataSetChanged()
                }
                else -> { toast("Something Went Wrong.")}
            }
        })
    }

    private fun updateJobTitleFilterList() {
        jobTitleFilterList.clear()
        jobTitleFilterList.add(jobTitleFilterListTitleObject)
        viewModel.jobTitleFilterList.value?.forEach { jobTitleFilter ->
            jobTitleFilterList.add(jobTitleFilter)
        }
        jobTitleFilterList.add(jobTitleFilterListAddMoreObject)
        spinnerAdapter.submitList(jobTitleFilterList)
        if (jobTitleFilterList.size > 2) {
            binding.sp1.setSelection(1)
            spinnerAdapter.jobOfferId = jobTitleFilterList[1].jobOfferId
        }else{
            spinnerAdapter.jobOfferId = jobTitleFilterList[1].jobOfferId
        }
        spinnerAdapter.notifyDataSetChanged()
    }

    private fun getJobTitleFilterList() {
         ParseCloud.callFunctionInBackground(ParseCloudFunction.GET_JOB_TITLE_FILTER_V1.value, hashMapOf(ParseTableFields.RECRUITER_ID.value to requireContext().getUserId()), FunctionCallback<Any> { result, e ->
             when {
                 e != null -> { toast(e.message.toString()) }
                 result != null -> {
                     val list = arrayListOf<JobTitleFilter>()
                     val mainObject = JSONArray(gson.toJson(result))
                     for (i in 0 until  mainObject.length()){ list.add(gson.fromJson(mainObject.getJSONObject(i).toString(), JobTitleFilter::class.java)) }
                     viewModel.setJobTitleFilterList(list)
                 }
                 else -> { toast("Something Went Wrong.")}
             }
         })
    }

    private fun setClickListeners() {
        binding.fabRewind.setOnClickListener {
            binding.csvJob.rewind()
        }
        binding.fabRefuse.setOnClickListener {
            val setting = SwipeAnimationSetting.Builder().setDirection(Direction.Left).setDuration(200).setInterpolator(AccelerateInterpolator()).build()
            cardStackLayoutManager.setSwipeAnimationSetting(setting)
            binding.csvJob.swipe()
        }

        binding.fabShortlist.setOnClickListener {
            val setting = SwipeAnimationSetting.Builder().setDirection(Direction.Right).setDuration(200).setInterpolator(AccelerateInterpolator()).build()
            cardStackLayoutManager.setSwipeAnimationSetting(setting)
            binding.csvJob.swipe()
        }
    }

    private fun setCardStackView() {
        setCardStackListener()
        adapter = RecruitmentSeekerJobCardStackAdapter(arrayListOf(), requireActivity())
        cardStackLayoutManager = CardStackLayoutManager(requireContext(), cardStackListener)
        cardStackLayoutManager.setDirections(listOf(Direction.Left,  Direction.Right))
        cardStackLayoutManager.setSwipeThreshold(0.4f)
        cardStackLayoutManager.setOverlayInterpolator(LinearInterpolator())
        binding.csvJob.layoutManager = cardStackLayoutManager
        binding.csvJob.adapter = adapter

        adapter.seeDescriptionClick = { recruitmentSeeker ->
            updateJobVisibility()

            binding.lJob.llMostParent.setOnClickListener { updateJobVisibility() }

            binding.lJob.tvSeekerName.text = "${recruitmentSeeker.firstName} ${recruitmentSeeker.lastName}"

            binding.lJob.tvJobLocation.text = recruitmentSeeker.city

            binding.lJob.tvMatchedPer.text = "${recruitmentSeeker.matchedPercentage}%"

            try {
                val university = gson.fromJson(JSONObject(recruitmentSeeker.university).toString(), University::class.java)
                binding.lJob.tvUniversityName.text = university.name
                if (university.isCurrent){
                    binding.lJob.tvEducation.text = StudentStatus.CURRENT.status
                }else{
                    binding.lJob.tvEducation.text = StudentStatus.NON_CURRENT.status
                }
            }catch (e: Exception){}

            loadImageFromUrl(binding.lJob.circleImageView, recruitmentSeeker.profileURL, R.drawable.default_user_img)

            val experiences = arrayListOf<Experience>()
            val experienceJsonArray = JSONObject(recruitmentSeeker.experiences).getJSONArray("list")
            for (i in 0 until experienceJsonArray.length()){
                experiences.add(gson.fromJson(experienceJsonArray.getJSONObject(i).toString(), Experience::class.java))
            }
            binding.lJob.rvExperience.adapter = SeekerExperienceListAdapter(experiences, requireActivity(), true)

            if (experiences.isNotEmpty()){
                binding.lJob.tvJobName.text = "${experiences[0].job} - ${experiences[0].company}"
            }

            if (recruitmentSeeker.interestedIn.isNotEmpty()){
                binding.lJob.tvWorkTypes.text = recruitmentSeeker.interestedIn.joinToString(", ")
            }

            binding.lJob.cgSoftSkillTags.removeAllViews()
            val softSkills = gson.fromJson(JSONArray(recruitmentSeeker.softSkills).toString(), ArrayList::class.java)
            softSkills.forEach { tag ->
                binding.lJob.cgSoftSkillTags.addView(createChip(tag.toString()))
            }

            if (recruitmentSeeker.elevatorPitch.isNotEmpty()){
                binding.lJob.tvBio.text = recruitmentSeeker.elevatorPitch
            }

            val educations = arrayListOf<Education>()
            val educationJsonArray = JSONObject(recruitmentSeeker.educations).getJSONArray("list")
            for (i in 0 until educationJsonArray.length()){
                educations.add(gson.fromJson(educationJsonArray.getJSONObject(i).toString(), Education::class.java))
            }
            if (educations.isNotEmpty()){
                try {
                    binding.lJob.tvUniversityName.text = educations[0].name
                }catch (e: Exception){}
            }
            binding.lJob.rvEducation.adapter = SeekerEducationAdapter(educations, requireActivity(), true)

            val hardSkills = arrayListOf<HardSkill>()
            val hardSkillsObject = JSONObject(recruitmentSeeker.hardSkills)
            hardSkillsObject.keys().forEach {
                hardSkills.add(HardSkill(it, hardSkillsObject.get(it).toString().toInt()))
            }
            binding.lJob.rvHardSkill.adapter = SeekerHardSkillAdapter(hardSkills, requireContext(), true)

            val volunteerings = arrayListOf<Volunteering>()
            val volunteeringJsonArray = JSONObject(recruitmentSeeker.volunteerings).getJSONArray("list")
            for (i in 0 until volunteeringJsonArray.length()){
                volunteerings.add(gson.fromJson(volunteeringJsonArray.getJSONObject(i).toString(), Volunteering::class.java))
            }
            binding.lJob.rvVolunteering.adapter = SeekerVolunteeringAdapter(volunteerings, requireActivity(), true)

            binding.lJob.cgInterests.removeAllViews()
            recruitmentSeeker.interests.forEach { tag ->
                binding.lJob.cgInterests.addView(createChip(tag))
            }

            binding.lJob.rvPortfolioLink.adapter = PortfolioLinksAdapter(
                recruitmentSeeker.portfolioLinks as ArrayList<String>,
                isStaticView = true,
                requireContext(),
                showIcon = false,
                LinkType.Link.value
            )
            binding.lJob.rvPortfolioDocLink.adapter = PortfolioLinksAdapter(
                recruitmentSeeker.portfolioDocLinks as ArrayList<String>,
                isStaticView = true,
                requireContext(),
                showIcon = false,
                LinkType.Doc.value
            )

            binding.lJob.cgWorkspace.removeAllViews()
            recruitmentSeeker.workspaces.forEach { tag ->
                binding.lJob.cgWorkspace.addView(createChip(tag))
            }

            binding.lJob.rvPortfolioImages.adapter = PortfolioImageAdapter2(recruitmentSeeker.images )
        }

    }

    private fun createChip(tag: String ): View {
        val chip: View = layoutInflater.inflate(R.layout.item_chip_white_box_gradient_border, null, false)
        val tvContract = chip.findViewById<TextView>(R.id.tv_tag)
        tvContract.text = tag
        tvContract.background = resources.getDrawable(R.drawable.rounded_bottom_purple_top_blue_50, null)
        tvContract.updatePadding(30, 0,30,0)
        tvContract.setTextColor(resources.getColor(R.color.white, null))
        return chip
    }

    private fun updateJobVisibility() {
        if (binding.csvJob.isVisible) {
            binding.csvJob.visibility = View.GONE
            binding.lJob.rootLayout.visibility = View.VISIBLE
        } else {
            binding.csvJob.visibility = View.VISIBLE
            binding.lJob.rootLayout.visibility = View.GONE
        }
    }

    private fun setCardStackListener() {
        cardStackListener = object : CardStackListener {
            override fun onCardDragging(direction: Direction?, ratio: Float) {
                val overlay = cardStackLayoutManager.topView.findViewById<ConstraintLayout>(R.id.cl_overlay)
                val overlayLabel = cardStackLayoutManager.topView.findViewById<TextView>(R.id.tv_overlay_label)
                topJobSeekerId = cardStackLayoutManager.topView.findViewById<TextView>(R.id.tv_job_seeker_id).text.toString()
                overlay.visibility = View.VISIBLE
                direction?.let {
                    when(direction){
                        Direction.Left -> {
                            overlay.setBackgroundResource(R.drawable.rounded_red_box_trans)
                            overlayLabel.text = resources.getString(R.string.refuse)
                            overlayLabel.rotation = 315F
                        }
                        Direction.Top -> { overlay.visibility = View.GONE }
                        Direction.Right -> {
                            overlay.setBackgroundResource(R.drawable.rounded_blue_box_trans)
                            overlayLabel.text = resources.getString(R.string.shortlist_job_card_overlay)
                            overlayLabel.rotation = 45F
                        }
                        else -> { overlay.visibility = View.GONE}
                    }
                }
            }
            override fun onCardSwiped(direction: Direction?) {
                if (currentJobOfferId.isEmpty() || topJobSeekerId == null){ return }
                when(direction){
                    Direction.Left -> {
                        recruitmentService(RecruitmentStep.REJECTION.value){
                            if (it){
                                //toast("Rejected Successfully")
                            }else{
                                toast("Something Went Wrong")
                                binding.csvJob.rewind()
                            }
                        }
                    }
                    Direction.Top -> {}
                    Direction.Right -> {
                        recruitmentService(RecruitmentStep.PRE_QUALIFICATION.value){
                            if (it){
                                toast("Accepted Successfully")
                            }else{
                                toast("Something Went Wrong")
                                binding.csvJob.rewind()
                            }
                        }
                    }
                    else -> {}
                }
            }
            override fun onCardRewound() {
                cardStackLayoutManager.topView.findViewById<ConstraintLayout>(R.id.cl_overlay).visibility = View.GONE
                rewindJobSeekerId = cardStackLayoutManager.topView.findViewById<TextView>(R.id.tv_job_seeker_id).text.toString()
                rewindRecruitmentSeeker()
            }
            override fun onCardCanceled() {
                cardStackLayoutManager.topView.findViewById<ConstraintLayout>(R.id.cl_overlay).visibility = View.GONE
            }
            override fun onCardAppeared(view: View?, position: Int) {

            }
            override fun onCardDisappeared(view: View?, position: Int) {}
        }




        binding.csvJob.addOnScrollListener(object : RecyclerView.OnScrollListener() {

            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if(cardStackLayoutManager.childCount == 0){

                }
            }
        })
    }

    private fun rewindRecruitmentSeeker() {
        var swipedRecruitmentSeeker: SwipedRecruitmentSeeker? = null
        swipedRecruitmentSeekerList.forEach {
            if (it.jobSeekerId == rewindJobSeekerId){
                swipedRecruitmentSeeker = it
            }
        }
        swipedRecruitmentSeeker?.let {
            swipedRecruitmentSeekerList.remove(swipedRecruitmentSeeker)
            when(swipedRecruitmentSeeker!!.recruitmentStep){
                1 -> {
                    recruitmentService(RecruitmentStep.APPLICATIONS_RECEIVED.value){
                        if (it){
                            //toast("rewinded successfully")
                        }else{
                            swipedRecruitmentSeekerList.add(swipedRecruitmentSeeker!!)
                        }
                    }
                }
                6 -> {
                    recruitmentService(RecruitmentStep.APPLICATIONS_RECEIVED.value){
                        if (it){
                           // toast("rewinded successfully")
                        }else{
                            swipedRecruitmentSeekerList.add(swipedRecruitmentSeeker!!)
                        }
                    }
                }
            }
        }
    }

    private fun recruitmentService(recruitmentStep: Int, isSuccess: (Boolean) -> Unit) {
        swipedRecruitmentSeekerList.add(SwipedRecruitmentSeeker(topJobSeekerId!!, currentJobOfferId, recruitmentStep))
        val request = hashMapOf<String, Any>(
            ParseTableFields.JOB_SEEKER_ID.value to topJobSeekerId!!,
            ParseTableFields.JOB_OFFER_ID.value to currentJobOfferId,
            ParseTableFields.COMPANY_ID.value to recruiter.companyId,
            "action" to recruitmentStep,
            ParseTableFields.RECRUITER_ID.value to requireContext().getUserId()
        )
        ParseCloud.callFunctionInBackground(ParseCloudFunction.HANDLE_ACTION_V1.value, request, FunctionCallback<Any> { result, e ->
            when {
                e != null -> {
                    isSuccess(false)
                    log(e.message.toString())
                }
                result != null -> {
                    if (recruitmentStep == RecruitmentStep.PRE_QUALIFICATION.value){
                        val jobSeekerProfileUrl = recruitmentSeekerList.firstOrNull { it.jobSeekerId == request[ParseTableFields.JOB_SEEKER_ID.value] }?.profileURL ?: ""
                        val companyLogoUrl = recruiter.company?.getString(ParseTableFields.LOGO_URL.value) ?: ""
                        JobMatchedDialog(requireActivity(), jobSeekerProfileUrl, companyLogoUrl) {
                            (requireActivity() as RecruiterHomeActivity).binding.tabLayout.getTabAt(2)?.select()
                        }.also {
                            it.setCancelable(false)
                        }.show()

                        ParseCloud.callFunctionInBackground(ParseTableName.SEND_MATCHES_NOTIFICATION.value, hashMapOf(ParseTableFields.JOB_SEEKER_ID.value to request[ParseTableFields.JOB_SEEKER_ID.value]), FunctionCallback<Any> { result, e ->
                            when{
                                e != null -> toast(e.message.toString()+" Something Went Wrong.")
                                result == null -> toast("Something Went Wrong.")
                                else -> {
                                    println("fksdfd ${request[ParseTableFields.JOB_SEEKER_ID.value]}")
                                    println("fdskflds ${gson.toJson(result)}")
                                }
                            }
                        })
                    }
                    isSuccess(true)
                }
                else -> {
                    isSuccess(false)
                    log("Something Went Wrong.")
                }
            }
        })
    }



    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        binding.csvJob.rewind()
    }



    var runnable: Runnable = object : Runnable {
        override fun run() {
            try {
                topJobSeekerId = cardStackLayoutManager.topView.findViewById<TextView>(R.id.tv_job_seeker_id).text.toString()
            }catch (e: Exception){}
            handler.postDelayed(this, 2000)
        }
    }

    var handler: Handler = Handler()

    override fun onResume() {
        super.onResume()
        try {
            val dimens = IntArray(2) { 0 }
            binding.sp1.getLocationInWindow(dimens)
            val topPadding = dimens[1] + binding.sp1.height + 40
            val bottomPadding = binding.llFloatingBtn.height + 40
            binding.csvJob.setPadding(40,topPadding,40,bottomPadding)
        }catch (e: Exception){}
        handler.postDelayed(runnable,20000)
        runnable.run()
    }

    override fun onPause() {
        super.onPause()
        handler.removeCallbacks(runnable)
    }


}

class RecruitmentSeekerJobCardStackAdapter(var list: ArrayList<RecruitmentSeeker>, val requireActivity: FragmentActivity)  : RecyclerView.Adapter<RecruitmentSeekerJobCardStackAdapter.ViewHolder>() {
    var seeDescriptionClick: (RecruitmentSeeker) -> Unit = {}
    val gson = Gson()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
        ItemRecruiterJobCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val recruitmentSeeker = list[position]
        holder.binding.apply {
            this.llFullDes.visibility = View.GONE
            this.llMostParent.setOnClickListener {
                seeDescriptionClick(recruitmentSeeker)
            }

            this.tvMatchedPer.text = "${recruitmentSeeker.matchedPercentage}%"

            this.tvJobSeekerId.text = recruitmentSeeker.jobSeekerId

            this.tvSeekerName.text = "${recruitmentSeeker.firstName} ${recruitmentSeeker.lastName}"

            if (recruitmentSeeker.city.isNotEmpty()){
                this.clJobLocation.visibility = View.VISIBLE
                this.tvJobLocation.text = recruitmentSeeker.city
            }else{
                this.clJobLocation.visibility = View.GONE
            }
            try {
                val university = gson.fromJson(JSONObject(recruitmentSeeker.university).toString(), University::class.java)
                if (university != null){
                    this.tvUniversityName.text = university.name
                    if (university.isCurrent){
                        this.tvEducation.text = StudentStatus.CURRENT.status
                    }else{
                        this.tvEducation.text = StudentStatus.NON_CURRENT.status
                    }
                }else{
                    this.llEducation.visibility = View.GONE
                    this.llUniversity.visibility = View.GONE
                }
            }catch (e: Exception){
                this.llEducation.visibility = View.GONE
                this.llUniversity .visibility = View.GONE
            }

            val educations = arrayListOf<Education>()
            val educationJsonArray = JSONObject(recruitmentSeeker.educations).getJSONArray("list")
            for (i in 0 until educationJsonArray.length()){
                educations.add(gson.fromJson(educationJsonArray.getJSONObject(i).toString(), Education::class.java))
            }
            if (educations.isNotEmpty()){
                try {
                    this.tvUniversityName.text = educations[0].name
                }catch (e: Exception){}
            }

            loadImageFromUrl(this.circleImageView, recruitmentSeeker.profileURL, R.drawable.default_user_img)

            val experiences = arrayListOf<Experience>()
            val experienceJsonArray = try {
                JSONObject(recruitmentSeeker.experiences).getJSONArray("list")
            }catch (e: Exception){
                JSONArray()
            }
            for (i in 0 until experienceJsonArray.length()){
                experiences.add(gson.fromJson(experienceJsonArray.getJSONObject(i).toString(), Experience::class.java))
            }

            if (experiences.isNotEmpty()){
                this.llJobTitle.visibility = View.VISIBLE
                this.tvJobName.text = "${experiences[0].job} - ${experiences[0].company}"
            }else{
                this.llJobTitle.visibility = View.GONE
            }

            if (recruitmentSeeker.interestedIn.isNotEmpty()){
                this.llWorkType.visibility = View.VISIBLE
                this.tvWorkTypes.text = recruitmentSeeker.interestedIn.joinToString(", ")
            }else{
                this.llWorkType.visibility = View.GONE
            }

        }
    }

    override fun getItemCount(): Int = list.size
    fun submitList(arrList: ArrayList<RecruitmentSeeker>) {
        list = arrList
    }

    class ViewHolder(val binding: ItemRecruiterJobCardBinding) : RecyclerView.ViewHolder(binding.root)



}

class JobTitleFilterSpinnerAdapter(private val activity: Activity, id: Int, var list: List<JobTitleFilter>) : ArrayAdapter<JobTitleFilter>(activity, id, list) {
    var onTitleClick: () -> Unit = {}
    var onAddMoreClick: () -> Unit = {}
    var jobOfferId = ""
    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = super.getDropDownView(position, convertView, parent)
        val tv = view as TextView
        tv.text = list[position].jobTitle
        if (position == 0){
            tv.paint.shader = activity.getShader(tv)
            tv.textSize = 20f
            tv.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.ic_arrow_up_gradient,0)
            tv.setOnClickListener { onTitleClick() }
        }else{
            if (tv.text.toString() == "Poster une nouvelle offre"){
                tv.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.ic_add_gradient_holo,0)
                tv.setOnClickListener {
                    onAddMoreClick()
                }
            }else{
                tv.setCompoundDrawablesWithIntrinsicBounds(0,0,0,0)
            }
            if (jobOfferId == list[position].jobOfferId && jobOfferId.isNotEmpty()){
                tv.setBackgroundColor( activity.resources.getColor(R.color.greyishWhite,null))
            }
        }
        return  view
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = super.getDropDownView(position, convertView, parent)
        val tv = view as TextView
        tv.text = list[position].jobTitle
        if (position != 0){
            jobOfferId = list[position].jobOfferId
        }
        return view
    }


    override fun isEnabled(position: Int): Boolean {
        super.isEnabled(position)
        return position != 0
    }

    fun submitList(jobTitleFilterList: ArrayList<JobTitleFilter>) {
        list = jobTitleFilterList
    }
}

data class SwipedRecruitmentSeeker(val jobSeekerId: String, val jobOfferId: String, val recruitmentStep: Int)



class PortfolioLinksAdapter(
    var list: ArrayList<String>,
    private val isStaticView: Boolean = false,
    val requireContext: Context,
    val showIcon: Boolean = false,
    val linkType: String
) : RecyclerView.Adapter<PortfolioLinksAdapter.ViewHolder>(){
    var onLinkClick: (String) -> Unit = {}
    var onRemoveLinkClick: (String) -> Unit = {}
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
        ItemPortfolioLinkBinding.inflate(LayoutInflater.from(parent.context),parent, false))
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.tvLink.text = list[position]
        if (isStaticView){
            holder.binding.ivRemoveLink.visibility = View.GONE
            holder.binding.tvLink.setTextColor(requireContext.resources.getColor(R.color.navi_blue, null))
        }
        if (showIcon){
            holder.binding.ivIcon.visibility = View.VISIBLE
            when(linkType){
                LinkType.Link.value -> {
                    holder.binding.ivIcon.setImageDrawable(requireContext.resources.getDrawable(R.drawable.ic_link_navi_blue, null))
                }
                LinkType.Doc.value -> {
                    holder.binding.ivIcon.setImageDrawable(requireContext.resources.getDrawable(R.drawable.ic_doc, null))
                }
            }
        }
        holder.binding.ivRemoveLink.setOnClickListener {
            onRemoveLinkClick(list[position])
        }
        holder.binding.tvLink.setOnClickListener {
            onLinkClick(list[position])
        }
    }
    override fun getItemCount(): Int = list.size
    fun submitList(links: ArrayList<String>) {
        list = links
    }

    class ViewHolder(val binding: ItemPortfolioLinkBinding) : RecyclerView.ViewHolder(binding.root)
}


class SeekerHardSkillAdapter(
    var list: ArrayList<HardSkill>,
    val requireContext: Context,
    private val staticView: Boolean
) : RecyclerView.Adapter<SeekerHardSkillAdapter.ViewHolder>(){
    var clickListener: (HardSkill) -> Unit = {}
    var skillLevelChangeListener: (HardSkill, Int ) -> Unit = { _, _ -> }

    var cardShadowColor = R.color.screen_background
    var firstColor = R.color.theme_light_blue
    var secondColor = R.color.theme_dark_blue

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(ItemSeekerHardSkillBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val hardSkill = list[position]
        holder.binding.apply {
            changeStrokeColor(this.sbHardSkill)
            this.sbHardSkill.setOnSeekBarChangeListener(null)
            this.tvHardSkill.text = hardSkill.skillName
            this.sbHardSkill.progress = hardSkill.skillLevel
            this.ivRemoveBtn.setOnClickListener {
                clickListener(hardSkill)
            }
            this.sbHardSkill.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
                override fun onProgressChanged(p0: SeekBar?, value: Int, p2: Boolean) {
                    skillLevelChangeListener(hardSkill, value)
                }
                override fun onStartTrackingTouch(p0: SeekBar?) {}
                override fun onStopTrackingTouch(p0: SeekBar?) {}
            })
            if (staticView){
                this.ivRemoveBtn.visibility = View.GONE
                this.sbHardSkill.isEnabled = false
            }
        }
    }

    override fun getItemCount(): Int = list.size

    fun submitList(ownedHardSkills: ArrayList<HardSkill>) {
        list = ownedHardSkills
    }

    fun changeCardBackgroundColor(shadowColor: Int, gradientFirstColor: Int, gradientSecondColor: Int) {
        cardShadowColor = shadowColor
        firstColor = gradientFirstColor
        secondColor = gradientSecondColor
    }

   fun changeStrokeColor(sb: SeekBar) {
       if (android.os.Build.VERSION.SDK_INT > 28){
           val thumb = sb.thumb.mutate() as LayerDrawable
           val thumbDrawable1 = thumb.getDrawable(0) as GradientDrawable
           val thumbDrawable2 = thumb.getDrawable(1) as GradientDrawable
           val colors = intArrayOf(requireContext.resources.getColor(firstColor, null) ,  requireContext.resources.getColor(secondColor, null))
           thumbDrawable1.colors = colors
           thumbDrawable2.colors = colors
       }else{
           val gd = GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, intArrayOf(requireContext.resources.getColor(firstColor, null) ,  requireContext.resources.getColor(secondColor, null)))
           gd.cornerRadius = 100f
           sb.thumb = gd
       }

       val progressDrawable = sb.progressDrawable.mutate() as LayerDrawable
       val seekBarBackDrawable = progressDrawable.getDrawable(0) as GradientDrawable
       val seekBarFrontClipDrawable = progressDrawable.getDrawable(1) as ClipDrawable
       val seekBarFrontDrawable = seekBarFrontClipDrawable.drawable as GradientDrawable
       if (android.os.Build.VERSION.SDK_INT > 28){
           seekBarBackDrawable.setColor(requireContext.resources.getColor(cardShadowColor, null))
           seekBarFrontDrawable.colors = intArrayOf(requireContext.resources.getColor(firstColor, null) ,  requireContext.resources.getColor(secondColor, null))
       }else{
           val back = GradientDrawable().also {
               it.setColor(requireContext.resources.getColor(cardShadowColor, null))
               it.cornerRadius = 100f
           }
           val front = GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, intArrayOf(requireContext.resources.getColor(firstColor, null) ,  requireContext.resources.getColor(secondColor, null))).also {
               it.cornerRadius = 100f
           }
           //sb.progressDrawable = LayerDrawable(arrayOf(ClipDrawable(back, Gravity.END, ClipDrawable.HORIZONTAL), ClipDrawable(front, Gravity.END, ClipDrawable.HORIZONTAL)))
       }
    }

    class ViewHolder(val binding: ItemSeekerHardSkillBinding) : RecyclerView.ViewHolder(binding.root)
}

