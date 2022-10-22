package com.jobamax.appjobamax.jobseeker.search


import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.text.SpannableString
import android.text.TextUtils
import android.text.style.UnderlineSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AccelerateInterpolator
import android.view.animation.Animation
import android.view.animation.LinearInterpolator
import android.view.animation.Transformation
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isVisible
import androidx.core.view.updatePadding
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.RecyclerView
import com.adjust.sdk.Adjust
import com.adjust.sdk.AdjustEvent
import com.google.firebase.dynamiclinks.ktx.androidParameters
import com.google.firebase.dynamiclinks.ktx.dynamicLink
import com.google.firebase.dynamiclinks.ktx.dynamicLinks
import com.google.firebase.ktx.Firebase
import com.google.gson.Gson
import com.jobamax.appjobamax.R
import com.jobamax.appjobamax.WebViewActivity
import com.jobamax.appjobamax.base.BaseFragment
import com.jobamax.appjobamax.databinding.FragmentSeekerSearchJobBinding
import com.jobamax.appjobamax.databinding.ItemSeekerJobCardBinding
import com.jobamax.appjobamax.dialog.JobReportDialog
import com.jobamax.appjobamax.dialog.MessageDialog
import com.jobamax.appjobamax.enums.FirebaseDynamicLinkPath
import com.jobamax.appjobamax.enums.ParseCloudFunction
import com.jobamax.appjobamax.enums.ParseTableFields
import com.jobamax.appjobamax.extensions.log
import com.jobamax.appjobamax.extensions.toast
import com.jobamax.appjobamax.jobseeker.JobSeekerHomeActivity
import com.jobamax.appjobamax.jobseeker.delegation.CircularRevealViewAnimation
import com.jobamax.appjobamax.jobseeker.delegation.CircularRevealViewAnimationImpl
import com.jobamax.appjobamax.jobseeker.view_model.SeekerHomeViewModel
import com.jobamax.appjobamax.model.JobOffer
import com.jobamax.appjobamax.model.JobSeeker
import com.jobamax.appjobamax.model.ManualCriteria
import com.jobamax.appjobamax.model.PersonalizeCriteria
import com.jobamax.appjobamax.preference.getJobSearchType
import com.jobamax.appjobamax.preference.getUserId
import com.jobamax.appjobamax.preference.setJobSearchType
import com.jobamax.appjobamax.util.*
import com.parse.FunctionCallback
import com.parse.ParseCloud
import com.yuyakaido.android.cardstackview.CardStackLayoutManager
import com.yuyakaido.android.cardstackview.CardStackListener
import com.yuyakaido.android.cardstackview.Direction
import com.yuyakaido.android.cardstackview.SwipeAnimationSetting
import org.json.JSONObject


class SeekerSearchJobFragment : BaseFragment() {
   lateinit var binding: FragmentSeekerSearchJobBinding


    val viewModel: SeekerHomeViewModel by activityViewModels()
    lateinit var jobSeeker: JobSeeker

    private val companyUrl = "https://jobamax.com/webapp/company/"

    lateinit var adapter: SeekerJobNewCardStackAdapter
    lateinit var cardStackLayoutManager: CardStackLayoutManager
    private lateinit var cardStackListener: CardStackListener

    var jobOfferList = ArrayList<JobOffer>()
    var topJobOfferId: String? = null
    var rewindJobOfferId: String? = null
    var swipedJobOffer: JobOffer? = null
    var rewindJobOffer: JobOffer? = null
    var wishlistAddedJobsId = ArrayList<String>()
    var refuseJobsId = ArrayList<String>()

    var jobSeekerId: String? = ""
    var jobOfferId: String? = ""

    private var swipeCount = 0

    private var rightSwipeCount = 0
    private var leftSwipeCount = 0


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentSeekerSearchJobBinding.inflate(inflater, container, false)

        configureUi()
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        requireContext().setJobSearchType(binding.scManualPersonalize.isChecked)
    }


    private fun configureUi() {
        binding.scManualPersonalize.isChecked = requireContext().getJobSearchType()
        setClickListeners()
        setJobSeeker()
        setCardStackView()

        binding.llFloatingBtn.viewTreeObserver.addOnGlobalLayoutListener {
            val dimens = IntArray(2) { 0 }
            binding.btnJobMatch.getLocationInWindow(dimens)
            val topPadding = dimens[1] + binding.btnJobMatch.height + 40
            val bottomPadding = binding.llFloatingBtn.height + 40
            binding.csvJob.setPadding(40,topPadding,40,bottomPadding)
        }
    }

    private fun showJobCardSwipeTutorial() {
        if (!jobSeeker.seenSwipeTutorial) {
            val dialog = SeekerLearnJobCardSwipingDialogFragment()
            dialog.show(childFragmentManager, "SeekerLearnJobCardSwipingDialogFragment")
            dialog.onFinish = {
                viewModel.jobSeekerObject?.put(ParseTableFields.SEEN_SWIPE_TUTORIAL.value, true)
                viewModel.jobSeekerObject?.saveInBackground {
                    if (it != null) {
                        jobSeeker = viewModel.jobSeeker
                    }
                }
            }
        }
    }

    private val resultContract = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        val intent = it.data
        intent?.let {
            when (intent.getIntExtra("check_box_state", -1)) {
                0 -> {
                    val pc = intent.getSerializableExtra("personalize_criteria") as PersonalizeCriteria
                    viewModel.jobSeekerObject?.put(ParseTableFields.CITY.value, pc.location)
                    viewModel.jobSeekerObject?.put(ParseTableFields.EXPERIENCE.value, pc.experience)
                    viewModel.jobSeekerObject?.put(ParseTableFields.INTERESTED_IN.value, pc.typeOfWork)
                    viewModel.jobSeekerObject?.put(ParseTableFields.LAT.value, pc.latitude)
                    viewModel.jobSeekerObject?.put(ParseTableFields.LNG.value, pc.longitude)
                    jobSeeker = viewModel.jobSeeker
                    if (binding.scManualPersonalize.isChecked){
                        binding.scManualPersonalize.isChecked = false
                    }else{
                        getJobOffers()
                    }
                }
                1 -> {
                    val mc = intent.getSerializableExtra("manual_criteria") as ManualCriteria
                    viewModel.jobSeekerObject?.put(ParseTableFields.MANUAL_CRITERIA.value, gson.toJson(mc))
                    jobSeeker = viewModel.jobSeeker
                    if (binding.scManualPersonalize.isChecked) {
                        getJobOffers()
                    }else{
                        binding.scManualPersonalize.isChecked = true
                    }
                }
                else -> {}
            }
        }
    }

    private fun setJobFilterSwitchListener() {
         binding.scManualPersonalize.setOnCheckedChangeListener { _, isChecked ->
             updateSwitchState(isChecked)
         }
    }

    private fun setJobSeeker() {
        if (viewModel.jobSeekerObject == null) {
            try {
                progressHud.show()
                (requireActivity() as JobSeekerHomeActivity).getJobSeeker {
                    progressHud.dismiss()
                    if (it) {
                        jobSeeker = viewModel.jobSeeker
                        setData()
                    }
                }
            }catch (e: Exception){ }
        }else{
            jobSeeker = viewModel.jobSeeker
            setData()
        }
    }

    private fun setData() {
        updateSwitchState(binding.scManualPersonalize.isChecked)
        setJobFilterSwitchListener()
        showJobCardSwipeTutorial()
    }

    private fun setCardData(job: JobOffer) {

        loadImageFromUrl(binding.lJob.circleImageView, job.companyLogo, R.drawable.ic_company_navi_blue)

        binding.lJob.tvDescription.setOnClickListener {
            startActivity(Intent(requireContext(), WebViewActivity::class.java).putExtra(ARG_WEB_URL, job.jobUrl))
        }

        /*binding.lJob.llSalary2.visibility = View.GONE*/

        job.tags.forEach { binding.lJob.cgTags.addView(createChip(it, true))  }

        if (job.jobType == 1) {
            binding.lJob.ivOnline.visibility = View.VISIBLE
        }else {
            binding.lJob.ivOnline.visibility = View.GONE
        }

        binding.lJob.tvSwipeCount.text = (job.swipeLeftCount + job.swipeRightCount + job.randomViewCount).toString()

        binding.lJob.tvJobDescription.text = job.description
        if (job.description.isEmpty()){
            binding.lJob.llJobDesc.visibility = View.GONE
        }

        binding.lJob.tvCompanyName.text = job.companyName
        if(job.companyName.isEmpty()){
            binding.lJob.tvCompanyName.visibility = View.GONE
            binding.lJob.tvCompanyName2.visibility = View.GONE
        }else{
            binding.lJob.tvCompanyName.visibility = View.VISIBLE
            binding.lJob.tvCompanyName2.visibility = View.VISIBLE
            if (job.hasShowCase && job.jobType == 1){
                binding.lJob.tvCompanyName2.visibility = View.VISIBLE
                val content = SpannableString(job.companyName)
                content.setSpan(UnderlineSpan(), 0, content.length, 0)
                binding.lJob.tvCompanyName2.text = content
                binding.lJob.tvCompanyName2.paint.shader =  getShader(binding.lJob.tvCompanyName2)
                binding.lJob.tvCompanyName.setOnClickListener {
                    startActivity(Intent(requireContext(), WebViewActivity::class.java).putExtra(ARG_WEB_URL, "$companyUrl${job.companyId}"))
                }
            }else{
                binding.lJob.tvCompanyName2.visibility = View.GONE
            }
        }

        binding.lJob.tvJobName.text = job.jobTitle
        if (job.jobTitle.isEmpty()){
            binding.lJob.llJobTitle.visibility = View.GONE
        }

        binding.lJob.tvWorkTypes.text = job.typeOfWork
        if (job.typeOfWork.isEmpty()){
            binding.lJob.llWorkType.visibility = View.GONE
        }

        binding.lJob.tvJobLocation.text = job.city
        if (job.city.isEmpty()){
            binding.lJob.llJobLocation.visibility = View.GONE
        }

       /* binding.lJob.tvSalary.text = job.salary
        if (job.salary.isEmpty()){
            binding.lJob.tvSalary.text = "Salary not revealed"
        }*/

        job.matches.apply {
            binding.lJob.sbEducation.progress = this.educationPer
            binding.lJob.cgEducationTags.removeAllViews()
            this.educations.forEach {
                binding.lJob.cgEducationTags.addView(createChip(it.text))
            }

            binding.lJob.sbExperience.progress = this.experiencePer
            binding.lJob.cgExperienceTags.removeAllViews()
            this.experiences.forEach {
                binding.lJob.cgExperienceTags.addView(createChip(it.text))
            }

            binding.lJob.sbHardSkill.progress = this.hardSkillPer
            binding.lJob.cgHardSkillTags.removeAllViews()
            this.hardSkills.forEach {
                binding.lJob.cgHardSkillTags.addView(createChip(it.text))
            }

            binding.lJob.sbSoftSkill.progress = this.softSkillPer
            binding.lJob.cgSoftSkillTags.removeAllViews()
            this.softSkills.forEach {
                binding.lJob.cgSoftSkillTags.addView(createChip(it.text))
            }
        }
        binding.lJob.sbEducation.isEnabled = false
        binding.lJob.sbExperience.isEnabled = false
        binding.lJob.sbHardSkill.isEnabled = false
        binding.lJob.sbSoftSkill.isEnabled = false
    }

    private fun createChip(tag: String,  isFullGradient: Boolean = false): View {
        val chip: View = layoutInflater.inflate(R.layout.item_chip_white_box_gradient_border, null, false)
        val tvContract = chip.findViewById<TextView>(R.id.tv_tag)
        tvContract.text = tag
        if (isFullGradient){
            tvContract.background = resources.getDrawable(R.drawable.rounded_bottom_purple_top_blue_50, null)
            tvContract.setTextColor(resources.getColor(R.color.white, null))
        }else{
            tvContract.background = resources.getDrawable(R.drawable.rounded_white_box_gradient_border_50, null)
            tvContract.setTextColor(resources.getColor(R.color.colorPrimary, null))
        }
        tvContract.updatePadding(20, 0,20,0)
        return chip
    }

    private fun setCardStackView() {
        setCardStackListener()
        adapter = SeekerJobNewCardStackAdapter(arrayListOf(), requireActivity())
        cardStackLayoutManager = CardStackLayoutManager(requireContext(), cardStackListener)
        cardStackLayoutManager.setDirections(listOf(Direction.Left, Direction.Top, Direction.Right))
        cardStackLayoutManager.setSwipeThreshold(0.4f)
        cardStackLayoutManager.setOverlayInterpolator(LinearInterpolator())
        binding.csvJob.layoutManager = cardStackLayoutManager
        binding.csvJob.adapter = adapter

        adapter.seeDescriptionClick = { job ->
            updateJobVisibility()
            setCardData(job)
        }
        adapter.reportFlagClick = {
            JobReportDialog(requireActivity()).show()
        }
        adapter.onDescriptionClick = {
            startActivity(Intent(requireContext(), WebViewActivity::class.java).putExtra(ARG_WEB_URL, it.jobUrl))
        }
        adapter.onCompanyClick = {
            startActivity(Intent(requireContext(), WebViewActivity::class.java).putExtra(ARG_WEB_URL, "$companyUrl${it.companyId}"))
        }
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

    val handler = Handler()
    var runnable: Runnable = object : Runnable {
        override fun run() {
            try {
                topJobOfferId = cardStackLayoutManager.topView.findViewById<TextView>(R.id.tv_job_offer_id).text.toString()
                setMatchPercentage()
            }catch (e: Exception){
                setMatchPercentage()
            }
            handler.postDelayed(this, 2000)
        }
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


    private fun setMatchPercentage() {
        var topJobOffer: JobOffer? = null
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
            binding.btnJobMatch.text = topJobOffer.matchesPercentage.toString()+"% match"
        }else{
            binding.btnJobMatch.text = "% match"
        }
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
                            increaseSwipeCount()
                        }
                    }
                    Direction.Top -> {
                        shareJob()
                        saveSwipeCount()
                        increaseSwipeCount()
                    }
                    Direction.Right -> {
                        if (swipedJobOffer != null){  
                            addToWishlistJob()
                            increaseSwipeCount()
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
            override fun onCardAppeared(view: View?, position: Int) {
                runnable.run()
            }
            override fun onCardDisappeared(view: View?, position: Int) {}
        }




        binding.csvJob.addOnScrollListener(object : RecyclerView.OnScrollListener() {

            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if(cardStackLayoutManager.childCount == 0 ){
                    if (jobOfferList.isNotEmpty()) {
                        getJobOffers()
                    }
                }
            }
        })
    }

    private fun increaseSwipeCount() {
        swipeCount++
        if (swipeCount >= 10){
            startJobMatchAnimation()
            swipeCount = 0
        }
    }

    private fun removeJobFromRefuse(type: Int) {
        ParseCloud.callFunctionInBackground(ParseCloudFunction.DROPOUT_ACTIONS.value, hashMapOf("jobOfferId" to rewindJobOffer!!.jobOfferId, "jobSeekerId" to requireContext().getUserId(), "type" to type), FunctionCallback<Any> { result, e ->
            when {
                e != null -> {
                    toast(e.message.toString())
                }
                result == null -> {
                    toast("No result found")
                }
                else -> {}
            }
        })
    }

    private fun saveSwipeCount() {
        ParseCloud.callFunctionInBackground(ParseCloudFunction.SAVE_SWIPE_COUNT.value, hashMapOf( "jobSeekerId" to requireContext().getUserId(), "type" to 3), FunctionCallback<Any> { result, e ->
            when {
                e != null -> {
                    toast(e.message.toString())
                }
                result == null -> {
                    toast("No result found")
                }
                else -> {}
            }
        })
    }


    private fun shareJob() {
        var sharedJobOffer: JobOffer? = null
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
                .appendPath(FirebaseDynamicLinkPath.SHARE_JOB_OFFER.path)
                .appendQueryParameter("jobOfferId", sharedJobOffer.jobOfferId)
                .appendQueryParameter("jobSeekerId", requireContext().getUserId())
            val myUrl: String = builder.build().toString()
            val dynamicLink = Firebase.dynamicLinks.dynamicLink {
                link = Uri.parse(myUrl)
                domainUriPrefix = "https://jobamax.page.link"
                androidParameters("com.jobamax.appjobamax") {
                }
            }
            val shareIntent = Intent.createChooser(Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, dynamicLink.uri.toString())
                type = "text/plain"
            }, "It is job offer link")
            startActivityForResult(shareIntent, 2)
        }else{
            binding.csvJob.rewind()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        binding.csvJob.rewind()
    }


    private fun addToRefuseJob(type: Int) {
        refuseJobsId.add(swipedJobOffer!!.jobOfferId)
        ParseCloud.callFunctionInBackground(ParseCloudFunction.DROPOUT_ACTIONS.value, hashMapOf("jobOfferId" to swipedJobOffer!!.jobOfferId, "jobSeekerId" to requireContext().getUserId(), "type" to type), FunctionCallback<Any> { result, e ->
            when {
                e != null -> {
                    toast(e.message.toString())
                }
                result == null -> {
                    toast("No result found")
                }
                else -> {
                    val adjustEvent = AdjustEvent("ymyv1o")
                    Adjust.trackEvent(adjustEvent)
                    leftSwipeCount++
                }
            }
        })
    }


    private fun addToWishlistJob() {
        wishlistAddedJobsId.add(swipedJobOffer!!.jobOfferId)
        ParseCloud.callFunctionInBackground(ParseCloudFunction.ADD_JOB_TO_WISHLIST.value, hashMapOf("jobOfferId" to swipedJobOffer!!.jobOfferId, "jobSeekerId" to requireContext().getUserId()), FunctionCallback<Any> { result, e ->
            when {
                e != null -> {
                    toast(e.message.toString())
                }
                result == null -> {
                    toast("No result found")
                }
                else -> {
                    toast(getString(R.string.added_successfully_to_wishlist))

                    val adjustEvent1 = AdjustEvent("c0uwfm")
                    Adjust.trackEvent(adjustEvent1)
                    val adjustEvent2 = AdjustEvent("ymyv1o")
                    Adjust.trackEvent(adjustEvent2)
                    rightSwipeCount++
                }
            }
        })
    }

    private fun removeJobFromWishlist() {
        ParseCloud.callFunctionInBackground(ParseCloudFunction.REMOVE_FROM_WISHLIST.value, hashMapOf("jobOfferId" to rewindJobOffer!!.jobOfferId, "jobSeekerId" to requireContext().getUserId()), FunctionCallback<Any> { result, e ->
            when {
                e != null -> {
                    toast(e.message.toString())
                }
                result == null -> {
                    toast("No result found")
                }
                else -> {}
            }
        })
    }

    private fun getJobOffers() {
        var param = HashMap<String, Any>()
        if (jobOfferId != ""){
            param = hashMapOf("jobSeekerId" to requireContext().getUserId(), "isFilterApply " to false, "jobOfferId" to jobOfferId!! )
        }else {
            param["jobSeekerId"] = requireContext().getUserId()
            param["leftSwipeCount"] = leftSwipeCount
            param["rightSwipeCount"] = rightSwipeCount
            if (binding.scManualPersonalize.isChecked) {
                jobSeeker.manualCriteria!!.apply {
                    param["filterType"] = 1
                    /*   param["experience"] = arrayListOf<String>()*/
                    param["companySize"] = this.companySize
                    param["typeOfWork"] = this.typeOfWork
                    param["location"] = this.location
                    param["jobSearchKeywords"] = this.jobSearchKeywords
                    param["companyName"] = this.companyName
                    param[ParseTableFields.LATITUDE.value] = this.lat
                    param[ParseTableFields.LONGITUDE.value] = this.long

                }
            } else {
                param["filterType"] = 2
                /*param["experience"] = it.experience*/
                param["typeOfWork"] = jobSeeker.interestedIn
                param["location"] = jobSeeker.city
                param["latitude"] = jobSeeker.lat
                param["longitude"] = jobSeeker.lng
            }
        }

        log("fjlksdkl $param")
        progressHud.show()
        ParseCloud.callFunctionInBackground(ParseCloudFunction.GET_JOB_SEARCH_V2.value, param, FunctionCallback<ArrayList<Any>> { result, e ->
            progressHud.dismiss()
            try {
                if (e != null){
                    log(e.message.toString())
                }
                if (result == null){
                    jobOfferList.clear()
                    adapter.submitList(jobOfferList)
                    adapter.notifyDataSetChanged()
                    if (jobOfferList.isEmpty()){
                        MessageDialog(requireActivity(), "0 offres trouvées. Vérifie que tu as bien rempli ton profil pour faire tourner l'algorithme de matching. Sinon vérifie tes critères de recherche et réessaye", false) {}.show()
                    }
                }else{
                    val list = ArrayList<JobOffer>()
                    for (jobOffer in result.iterator()){
                        val res = gson.toJson(jobOffer)
                        val mainObject = JSONObject(res)
                        /*Log.i("TAG", "fjskla $mainObject")*/
                        list.add(gson.fromJson(mainObject.toString(), JobOffer::class.java))
                    }
                    jobOfferList = list
                    adapter.submitList(jobOfferList)
                    adapter.notifyDataSetChanged()
                    if (jobOfferList.isEmpty()){
                        try {
                            MessageDialog(requireActivity(), "0 offres trouvées. Vérifie que tu as bien rempli ton profil pour faire tourner l'algorithme de matching. Sinon vérifie tes critères de recherche et réessaye  \uD83D\uDE22", false) {}.show()
                        }catch (e: Exception){ }
                    }
                }
                leftSwipeCount = 0
                rightSwipeCount = 0
            }catch (e: Exception){ log(e.message.toString()+" Something Went Wrong.")}
        })
    }




    fun setClickListeners() {
        binding.lJob.llMostParent.setOnClickListener { updateJobVisibility() }
        binding.fabRewind.setOnClickListener {
            binding.csvJob.visibility = View.VISIBLE
            binding.lJob.rootLayout.visibility = View.GONE
            binding.csvJob.rewind()
        }
        binding.fabRefuse.setOnClickListener {
            binding.csvJob.visibility = View.VISIBLE
            binding.lJob.rootLayout.visibility = View.GONE
            val setting = SwipeAnimationSetting.Builder().setDirection(Direction.Left).setDuration(200).setInterpolator(AccelerateInterpolator()).build()
            cardStackLayoutManager.setSwipeAnimationSetting(setting)
            binding.csvJob.swipe()
        }
        binding.fabShare.setOnClickListener {
            binding.csvJob.visibility = View.VISIBLE
            binding.lJob.rootLayout.visibility = View.GONE
            val setting = SwipeAnimationSetting.Builder().setDirection(Direction.Top).setDuration(200).setInterpolator(AccelerateInterpolator()).build()
            cardStackLayoutManager.setSwipeAnimationSetting(setting)
            binding.csvJob.swipe()
        }
        binding.fabWishlist.setOnClickListener {
            binding.csvJob.visibility = View.VISIBLE
            binding.lJob.rootLayout.visibility = View.GONE
            val setting = SwipeAnimationSetting.Builder().setDirection(Direction.Right).setDuration(200).setInterpolator(AccelerateInterpolator()).build()
            cardStackLayoutManager.setSwipeAnimationSetting(setting)
            binding.csvJob.swipe()
        }
        binding.btnCriteria.setOnClickListener {
            val bundle = Bundle()
            bundle.putBoolean("is_manual", binding.scManualPersonalize.isChecked)
            val intent = Intent(requireContext(), ManualAndPersonalizeActivity::class.java)
            intent.putExtras(bundle)
            resultContract.launch(intent)
        }

        binding.btnJobMatch.setOnClickListener {
            var topJobOffer: JobOffer? = null
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
                val instance = JobMatchInfoDialogFragment.newInstance(topJobOffer)
                instance.show(childFragmentManager,"dialog")
            }

            binding.llParent.clearAnimation()
        }
    }



    private fun startJobMatchAnimation() {
        val newLeftMargin = 20f
        val opacity = 1f
        val a: Animation = object : Animation() {
            override fun applyTransformation(interpolatedTime: Float, t: Transformation?) {
                val params: LinearLayout.LayoutParams =
                    binding.btnJobMatch.layoutParams as LinearLayout.LayoutParams
                val margin = (newLeftMargin * interpolatedTime).toInt()
                val opacityValue = (100 - ((opacity * interpolatedTime) * 100)).toInt()
                params.setMargins(margin, margin, margin, margin)
                if (opacityValue > 90) {
                    binding.llParent.background.alpha = 0
                } else {
                    binding.llParent.background.alpha = opacityValue
                }
                binding.btnJobMatch.layoutParams = params
            }
        }
        a.duration = 1000 // in ms
        a.repeatMode = Animation.RESTART
        a.repeatCount = Animation.INFINITE
        binding.llParent.startAnimation(a)
    }

    private fun updateSwitchState(isChecked: Boolean) {
        if (isChecked) {
            binding.tvPersonalizeSwitch.visibility = View.GONE
            binding.tvManualSwitch.visibility = View.VISIBLE
        } else {
            binding.tvPersonalizeSwitch.visibility = View.VISIBLE
            binding.tvManualSwitch.visibility = View.GONE
            if (jobSeeker.interestedIn.isEmpty() || jobSeeker.city.isEmpty() || !jobSeeker.seenUpdatePopup){
                PersonalizeFilterDialogFragment().also {
                    it.isCancelable = false
                }.show(childFragmentManager, "personalizeFilterDialogFragment")
            }
        }
        getJobOffers()
    }

}

class SeekerJobNewCardStackAdapter(var list: ArrayList<JobOffer>, val requireActivity: FragmentActivity)  : RecyclerView.Adapter<SeekerJobNewCardStackAdapter.ViewHolder>(), CircularRevealViewAnimation by CircularRevealViewAnimationImpl() {
    var seeDescriptionClick: (JobOffer) -> Unit = {}
    var reportFlagClick: (JobOffer) -> Unit = {}
    var onDescriptionClick: (JobOffer) -> Unit = {}
    var onCompanyClick: (JobOffer) -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
        ItemSeekerJobCardBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val jobOffer = list[position]
        holder.binding.apply {
            this.tvJobOfferId.text = jobOffer.jobOfferId
            this.clOverlay.visibility = View.GONE
            this.tvDescription.visibility = View.GONE
            this.llMostParent.setOnClickListener {
                seeDescriptionClick(jobOffer)
            }
            this.llMatch.visibility = View.GONE

            try { this.cgTags.addView(createChip(jobOffer.tags[0]))  }catch (e: Exception){
                this.cgTags.visibility = View.GONE
            }
            try { this.cgTags.addView(createChip(jobOffer.tags[1])) }catch (e: Exception){}

            log("flsdjfkls ${jobOffer.hasShowCase} ${jobOffer.jobType}")

            if (list.isNotEmpty()) {
                try {
                    if (jobOffer.jobOfferId == list[0].jobOfferId){
                        var i = 0
                        object : CountDownTimer(11000, 1000){
                            override fun onTick(p0: Long) {
                                try {
                                    when(i){
                                        1 -> { showViewAnimationFromLeft(this@apply.cvJobViewedDialog) }
                                        5 -> { hideViewAnimationFromLeft(this@apply.cvJobViewedDialog) }
                                        6 -> { showViewAnimationFromRight(this@apply.cvJobOnlineDialog) }
                                        10 -> { hideViewAnimationFromRight(this@apply.cvJobOnlineDialog) }
                                    }
                                }catch (e: Exception){ log(e.message.toString())}
                                i++
                            }
                            override fun onFinish() {
                                try {
                                    this@apply.cvJobViewedDialog.visibility = View.GONE
                                    this@apply.cvJobOnlineDialog.visibility = View.GONE
                                }catch (e: Exception){}
                            }
                        }.start()
                    }

                }catch (e: Exception){}
             }

            if (jobOffer.jobType == 1) {
                this.ivOnline.visibility = View.VISIBLE
            }else {
                this.ivOnline.visibility = View.GONE
            }


            this.tvSwipeCount.text = (jobOffer.swipeLeftCount + jobOffer.swipeRightCount + jobOffer.randomViewCount).toString()

            this.tvCompanyName.text = jobOffer.companyName
            if (jobOffer.hasShowCase && jobOffer.jobType == 1){
                this.tvCompanyName2.visibility = View.VISIBLE
                val content = SpannableString(jobOffer.companyName)
                content.setSpan(UnderlineSpan(), 0, content.length, 0)
                this.tvCompanyName2.text = content
                this.tvCompanyName2.paint.shader = requireActivity.getShader(this.tvCompanyName2)
                this.tvCompanyName.setOnClickListener {
                    onCompanyClick(jobOffer)
                }
            }else{
                this.tvCompanyName2.visibility = View.GONE
            }

            if(jobOffer.companyName.isEmpty()){
                this.tvCompanyName.visibility = View.GONE
            }

            this.tvJobName.text = jobOffer.jobTitle
            if (jobOffer.jobTitle.isEmpty()){
                this.llJobTitle.visibility = View.GONE
            }

            this.tvWorkTypes.text = jobOffer.typeOfWork
            if (jobOffer.typeOfWork.isEmpty()){
                this.llWorkType.visibility = View.GONE
            }

            this.tvJobLocation.text = jobOffer.city
            if (jobOffer.city.isEmpty()){
                this.llJobLocation.visibility = View.GONE
            }

            /*this.tvSalary.visibility = View.GONE
            this.tvSalary.text = jobOffer.salary
            this.tvSalary2.text = jobOffer.salary
            if (jobOffer.salary.isEmpty()){
                this.tvSalary2.text = "Salary not revealed"
            }*/

            this.tvJobDescription.text = jobOffer.description
            if (jobOffer.description.isEmpty()){
                this.llJobDesc.visibility = View.GONE
            }

            this.tvJobDescription.maxLines = 3
            this.tvJobDescription.ellipsize = TextUtils.TruncateAt.END


            loadImageFromUrl(this.circleImageView, jobOffer.companyLogo, R.drawable.ic_company_navi_blue)
        }
    }


    override fun getItemCount(): Int = list.size
    fun submitList(arrList: ArrayList<JobOffer>) {
        list = arrList
    }
    class ViewHolder(val binding: ItemSeekerJobCardBinding) : RecyclerView.ViewHolder(binding.root)

    private fun createChip(tag: String): View {
        val chip: View = requireActivity.layoutInflater.inflate(R.layout.item_chip_white_box_gradient_border, null, false)
        val tvContract = chip.findViewById<TextView>(R.id.tv_tag)
        tvContract.text = tag
        tvContract.background = requireActivity.resources.getDrawable(R.drawable.rounded_bottom_purple_top_blue_50, null)
        tvContract.updatePadding(20, 0,20,0)
        tvContract.setTextColor(requireActivity.resources.getColor(R.color.white, null))
        return chip
    }
}


