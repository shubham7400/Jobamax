package com.jobamax.appjobamax.recruiter.search

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AccelerateInterpolator
import android.view.animation.LinearInterpolator
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isVisible
import androidx.core.view.updatePadding
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.jobamax.appjobamax.R
import com.jobamax.appjobamax.base.BaseFragment
import com.jobamax.appjobamax.databinding.FragmentRecruiterSearchBinding
import com.jobamax.appjobamax.databinding.ItemPortfolioImage2Binding
import com.jobamax.appjobamax.databinding.ItemRecruiterJobCardBinding
import com.jobamax.appjobamax.enums.ParseCloudFunction
import com.jobamax.appjobamax.enums.ParseTableFields
import com.jobamax.appjobamax.extensions.log
import com.jobamax.appjobamax.extensions.toast
import com.jobamax.appjobamax.jobseeker.build_profile.SeekerEducationAdapter
import com.jobamax.appjobamax.jobseeker.build_profile.SeekerExperienceListAdapter
import com.jobamax.appjobamax.jobseeker.build_profile.SeekerVolunteeringAdapter
import com.jobamax.appjobamax.model.*
import com.jobamax.appjobamax.preference.getUserId
import com.jobamax.appjobamax.recruiter.RecruiterHomeActivity
import com.jobamax.appjobamax.recruiter.RecruiterHomeViewModel
import com.jobamax.appjobamax.recruiter.dialog.DialogAddToFolderOrOffer
import com.jobamax.appjobamax.recruiter.home.PortfolioLinksAdapter
import com.jobamax.appjobamax.recruiter.home.SeekerHardSkillAdapter
import com.jobamax.appjobamax.recruiter.model.JobTitleFilter
import com.jobamax.appjobamax.recruiter.model.SeekerFolder
import com.jobamax.appjobamax.recruiter.model.SourcingCriteria
import com.jobamax.appjobamax.recruiter.model.SourcingSeeker
import com.jobamax.appjobamax.util.StudentStatus
import com.jobamax.appjobamax.util.getShader
import com.jobamax.appjobamax.util.loadImageFromUrl
import com.parse.FunctionCallback
import com.parse.ParseCloud
import com.yuyakaido.android.cardstackview.CardStackLayoutManager
import com.yuyakaido.android.cardstackview.CardStackListener
import com.yuyakaido.android.cardstackview.Direction
import com.yuyakaido.android.cardstackview.SwipeAnimationSetting
import org.json.JSONArray
import org.json.JSONObject

class RecruiterSearchFragment : BaseFragment() {
    lateinit var binding: FragmentRecruiterSearchBinding

    lateinit var adapter: RecruiterSearchedJobCardStackAdapter
    lateinit var cardStackLayoutManager: CardStackLayoutManager
    lateinit var cardStackListener: CardStackListener

    val viewModel: RecruiterHomeViewModel by activityViewModels()
    lateinit var recruiter: Recruiter

    var topJobSeekerId: String? = null
    var rewindJobSeekerId: String? = null
    var currentSourcingId = ""

    private val sourcingSeekerList = arrayListOf<SourcingSeeker>()

    private val swipedSourcingSeekerList = arrayListOf<SwipedSourcingSeeker>()

    lateinit var spinnerAdapter: SourcingCriteriaSpinnerAdapter
    private val sourcingCriteriaListTitleObject = SourcingCriteria(arrayListOf(),"", arrayListOf(), arrayListOf(), "", arrayListOf(), "", "Sourcing", arrayListOf(),"", 0.0, 0.0)
    private val sourcingCriteriaListAddMoreObject = SourcingCriteria(arrayListOf(),"", arrayListOf(), arrayListOf(), "", arrayListOf(), "", "ajouter un tag sourcing", arrayListOf(),"", 0.0, 0.0)
    var sourcingCriteriaList = arrayListOf(sourcingCriteriaListTitleObject, sourcingCriteriaListAddMoreObject)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentRecruiterSearchBinding.inflate(inflater, container, false)
        configureUi()
        return binding.root
    }



    private fun configureUi() {
        setObserver()
        initializeRecruiter()
        setCardStackView()
        setClickListeners()
        binding.llFloatingBtn.viewTreeObserver.addOnGlobalLayoutListener {
            val dimens = IntArray(2) { 0 }
            binding.sp1.getLocationInWindow(dimens)
            val topPadding = dimens[1] + binding.sp1.height + 40
            val bottomPadding = binding.llFloatingBtn.height + 40
            binding.csvJob.setPadding(40,topPadding,40,bottomPadding)
        }

        binding.tvNumber.paint.shader = getShader(binding.tvNumber)

        setSourcingCriteriaSpinnerAdapter()

        if (viewModel.sourcingCriteriaList.value!!.isEmpty()){
            getSourcingCriteria()
        }else{
            updateJobCriteriaList()
        }
    }

    private fun getSourcingSeekers(sourcingId: String) {
        ParseCloud.callFunctionInBackground(ParseCloudFunction.GET_SOURCING_SEEKER_V1.value, hashMapOf(ParseTableFields.SOURCING_ID.value to sourcingId), FunctionCallback<Any> { result, e ->
            when {
                e != null -> { toast(e.message.toString()) }
                result != null -> {
                    swipedSourcingSeekerList.clear()
                    sourcingSeekerList.clear()
                    val mainObject = JSONArray(gson.toJson(result))
                    for (i in 0 until mainObject.length()){
                        sourcingSeekerList.add(Gson().fromJson(mainObject.getJSONObject(i).toString(), SourcingSeeker::class.java))
                    }
                    adapter.submitList(sourcingSeekerList)
                    adapter.notifyDataSetChanged()
                }
                else -> { toast("Something Went Wrong.")}
            }
        })
    }

    private fun setSourcingCriteriaSpinnerAdapter() {
        spinnerAdapter = SourcingCriteriaSpinnerAdapter(requireActivity(), R.layout.item_textview, sourcingCriteriaList)
        binding.sp1.adapter = spinnerAdapter
        binding.sp1.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, view: View?, position: Int, p3: Long) {
                if (sourcingCriteriaList[position].sourcingId.isNotEmpty()) {
                    getSourcingSeekers(sourcingCriteriaList[position].sourcingId)
                    currentSourcingId = sourcingCriteriaList[position].sourcingId
                    binding.lJob.rootLayout.visibility = View.GONE
                    binding.csvJob.visibility = View.VISIBLE
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {}
        }
        spinnerAdapter.onTitleClick = {
            binding.sp1.onDetachedFromWindow()
        }
        spinnerAdapter.onAddSourcingClick = {
            RecruiterAddJobSourcingCriteriaDialogFragment().show(childFragmentManager, "RecruiterAddJobSourcingCriteriaDialogFragment")
            binding.sp1.onDetachedFromWindow()
        }
    }

    private fun updateJobCriteriaList() {
        sourcingCriteriaList.clear()
        sourcingCriteriaList.add(sourcingCriteriaListTitleObject)
        viewModel.sourcingCriteriaList.value?.forEach { sourcingCriteria ->
            sourcingCriteriaList.add(sourcingCriteria)
        }
        sourcingCriteriaList.add(sourcingCriteriaListAddMoreObject)
        spinnerAdapter.submitList(sourcingCriteriaList)
        spinnerAdapter.notifyDataSetChanged()
        if (viewModel.shouldBeSelectedSourcingCriteriaSourcingId.value?.isNotEmpty() == true) {
            val index = sourcingCriteriaList.indexOfFirst { it.sourcingId == viewModel.shouldBeSelectedSourcingCriteriaSourcingId.value }
            if (index != -1){
                binding.sp1.setSelection(index)
                viewModel.shouldBeSelectedSourcingCriteriaSourcingId.value = ""
            }else{
                spinnerAdapter.sourcingId = sourcingCriteriaList[0].sourcingId
            }
        }else{
            spinnerAdapter.sourcingId = sourcingCriteriaList[0].sourcingId
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
        }
    }

    private fun setData() {

    }

    private fun setObserver() {
        viewModel.isRecruiterUpdated.observe(viewLifecycleOwner){
            if (it){
                recruiter = viewModel.recruiter
                setData()
            }
        }

        viewModel.sourcingCriteriaList.observe(viewLifecycleOwner){
            updateJobCriteriaList()
        }
    }


    private fun getSourcingCriteria() {
        ParseCloud.callFunctionInBackground(ParseCloudFunction.GET_SOURCING_CRITERIA_V1.value, hashMapOf(ParseTableFields.COMPANY_ID.value to recruiter.companyId, ParseTableFields.RECRUITER_ID.value to requireContext().getUserId()), FunctionCallback<Any> { result, e ->
            when {
                e != null -> { toast(e.message.toString()) }
                result != null -> {
                    val list = arrayListOf<SourcingCriteria>()
                    val mainObject = JSONArray(gson.toJson(result))
                    for (i in 0 until mainObject.length()){
                        list.add(gson.fromJson(mainObject.getJSONObject(i).toString(), SourcingCriteria::class.java))
                    }
                    viewModel.setSourcingCriteriaList(list)
                }
                else -> { toast("Something Went Wrong.")}
            }
        })
    }

    private fun setCardStackView() {
        setCardStackListener()
        adapter = RecruiterSearchedJobCardStackAdapter(arrayListOf(), requireActivity())
        cardStackLayoutManager = CardStackLayoutManager(requireContext(), cardStackListener)
        cardStackLayoutManager.setDirections(listOf(Direction.Left,  Direction.Right))
        cardStackLayoutManager.setSwipeThreshold(0.4f)
        cardStackLayoutManager.setOverlayInterpolator(LinearInterpolator())
        binding.csvJob.layoutManager = cardStackLayoutManager
        binding.csvJob.adapter = adapter

        adapter.seeDescriptionClick = { sourcingSeeker ->
            updateJobVisibility()

            binding.lJob.llMostParent.setOnClickListener { updateJobVisibility() }

            binding.lJob.tvSeekerName.text = "${sourcingSeeker.firstName} ${sourcingSeeker.lastName}"

            binding.lJob.tvJobLocation.text = sourcingSeeker.city

            try {
                val university = gson.fromJson(JSONObject(sourcingSeeker.university).toString(), University::class.java)
                binding.lJob.tvUniversityName.text = university.name
                if (university.isCurrent){
                    binding.lJob.tvEducation.text = StudentStatus.CURRENT.status
                }else{
                    binding.lJob.tvEducation.text = StudentStatus.NON_CURRENT.status
                }
            }catch (e: Exception){}

            loadImageFromUrl(binding.lJob.circleImageView, sourcingSeeker.profileURL, R.drawable.default_user_img)

            val experiences = arrayListOf<Experience>()
            val experienceJsonArray = JSONObject(sourcingSeeker.experiences).getJSONArray("list")
            for (i in 0 until experienceJsonArray.length()){
                experiences.add(gson.fromJson(experienceJsonArray.getJSONObject(i).toString(), Experience::class.java))
            }
            binding.lJob.rvExperience.adapter = SeekerExperienceListAdapter(experiences, requireActivity(), true)

            if (experiences.isNotEmpty()){
                binding.lJob.tvJobName.text = "${experiences[0].job} - ${experiences[0].company}"
            }

            if (sourcingSeeker.interestedIn.isNotEmpty()){
                binding.lJob.tvWorkTypes.text = sourcingSeeker.interestedIn.joinToString(", ")
            }

            binding.lJob.cgSoftSkill.removeAllViews()
            binding.lJob.cgSoftSkillTags.removeAllViews()
            val softSkills = gson.fromJson(JSONArray(sourcingSeeker.softSkills).toString(), ArrayList::class.java)
            softSkills.forEach { tag ->
                binding.lJob.cgSoftSkill.addView(createChip(tag.toString()))
                binding.lJob.cgSoftSkillTags.addView(createChip(tag.toString()))
            }

            if (sourcingSeeker.elevatorPitch.isNotEmpty()){
                binding.lJob.tvBio.text = sourcingSeeker.elevatorPitch
            }

            val educations = arrayListOf<Education>()
            val educationJsonArray = JSONObject(sourcingSeeker.educations).getJSONArray("list")
            for (i in 0 until educationJsonArray.length()){
                educations.add(gson.fromJson(educationJsonArray.getJSONObject(i).toString(), Education::class.java))
            }
            binding.lJob.rvEducation.adapter = SeekerEducationAdapter(educations, requireActivity(), true)

            try {
                val hardSkills = arrayListOf<HardSkill>()
                val hardSkillsObject = JSONObject(sourcingSeeker.hardSkills)
                hardSkillsObject.keys().forEach {
                    hardSkills.add(HardSkill(it, hardSkillsObject.get(it).toString().toInt()))
                }
                binding.lJob.rvHardSkill.adapter = SeekerHardSkillAdapter(hardSkills, requireContext(), true)
            }catch (e: Exception){}

            try {
                val volunteerings = arrayListOf<Volunteering>()
                val volunteeringJsonArray = JSONObject(sourcingSeeker.volunteerings).getJSONArray("list")
                for (i in 0 until volunteeringJsonArray.length()){
                    volunteerings.add(gson.fromJson(volunteeringJsonArray.getJSONObject(i).toString(), Volunteering::class.java))
                }
                binding.lJob.rvVolunteering.adapter = SeekerVolunteeringAdapter(volunteerings, requireActivity(), true)
            }catch (e: Exception){}

            binding.lJob.cgInterests.removeAllViews()
            sourcingSeeker.interests.forEach { tag ->
                binding.lJob.cgInterests.addView(createChip(tag))
            }

            binding.lJob.rvPortfolioLink.adapter = PortfolioLinksAdapter(sourcingSeeker.portfolioLinks as ArrayList<String>, true )
            binding.lJob.rvPortfolioDocLink.adapter = PortfolioLinksAdapter(sourcingSeeker.portfolioDocLinks as ArrayList<String>, true )

            binding.lJob.cgWorkspace.removeAllViews()
            sourcingSeeker.workspaces.forEach { tag ->
                binding.lJob.cgWorkspace.addView(createChip(tag))
            }

            binding.lJob.rvPortfolioImages.adapter = PortfolioImageAdapter2(sourcingSeeker.images )
        }
    }

    private fun createChip(tag: String ): View {
        val chip: View = layoutInflater.inflate(R.layout.item_chip_white_box_gradient_border, null, false)
        val tvContract = chip.findViewById<TextView>(R.id.tv_tag)
        tvContract.text = tag
        tvContract.background = resources.getDrawable(R.drawable.rounded_bottom_purple_top_blue_50, null)
        tvContract.updatePadding(20, 0,20,0)
        tvContract.setTextColor(resources.getColor(R.color.white, null))
        return chip
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

        binding.fabWishlist.setOnClickListener {
            val setting = SwipeAnimationSetting.Builder().setDirection(Direction.Right).setDuration(200).setInterpolator(AccelerateInterpolator()).build()
            cardStackLayoutManager.setSwipeAnimationSetting(setting)
            binding.csvJob.swipe()
        }

        binding.ivFilterSourcing.setOnClickListener {
            RecruiterAddJobSourcingCriteriaDialogFragment().show(childFragmentManager, "RecruiterAddJobSourcingCriteriaDialogFragment")
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
                            overlayLabel.text = resources.getString(R.string.wishlist_job_card_overlay)
                            overlayLabel.rotation = 45F
                        }
                        else -> { overlay.visibility = View.GONE }
                    }
                }
            }
            override fun onCardSwiped(direction: Direction?) {
                if (currentSourcingId.isEmpty() || topJobSeekerId == null){ return }
                when(direction){
                    Direction.Left -> {
                        rejectOrUndoSourcing(1) {
                            if (it){
                                toast("Rejected Successfully")
                            }else{
                                toast("Something Went Wrong")
                                binding.csvJob.rewind()
                            }
                        }
                    }
                    Direction.Top -> {}
                    Direction.Right -> {
                        DialogAddToFolderOrOffer(requireActivity(), viewModel.jobTitleFilterList.value, viewModel.seekerFolders.value, {    jobOffer ->
                            acceptOrUndoSourcing(1, jobOffer) {
                                if (it){
                                    toast("Accepted Successfully")
                                }else{
                                    toast("Something Went Wrong")
                                    binding.csvJob.rewind()
                                }
                            }
                        }, { seekerFolder ->
                            addOrRemoveFromSeekerFolder(1, seekerFolder) {
                                if (it){
                                    toast("Added to Folder Successfully")
                                }else{
                                    toast("Something Went Wrong")
                                    binding.csvJob.rewind()
                                }
                            }
                        }).also {
                            it.setCancelable(false)
                            it.setCanceledOnTouchOutside(false)
                        }.show()

                    }
                    else -> {}
                }
            }
            override fun onCardRewound() {
                cardStackLayoutManager.topView.findViewById<ConstraintLayout>(R.id.cl_overlay).visibility = View.GONE
                rewindJobSeekerId = cardStackLayoutManager.topView.findViewById<TextView>(R.id.tv_job_seeker_id).text.toString()
                rewindSourcing()
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

    private fun addOrRemoveFromSeekerFolder(type: Int, seekerFolder: SeekerFolder, isSuccess: (Boolean) -> Unit) {
        if (type == 1){
            swipedSourcingSeekerList.add(SwipedSourcingSeeker(currentSourcingId, topJobSeekerId!!, true, null, seekerFolder))
        }
        val request = hashMapOf(
            ParseTableFields.FOLDER_ID.value to seekerFolder.folderId,
            ParseTableFields.RECRUITER_ID.value to requireContext().getUserId(),
            "jobSeekerIds" to arrayListOf(topJobSeekerId!!) ,
            ParseTableFields.TYPE.value to type,
        )
        ParseCloud.callFunctionInBackground(ParseCloudFunction.HANDLE_FOLDER_ACTION_V1.value, request, FunctionCallback<Any> { result, e ->
            when {
                e != null -> {
                    isSuccess(false)
                    log(e.message.toString())
                }
                result != null -> {
                    isSuccess(true)
                }
                else -> {
                    isSuccess(false)
                    log("Something Went Wrong.")
                }
            }
        })
    }

    private fun acceptOrUndoSourcing(type: Int, jobOffer: JobTitleFilter, isSuccess: (Boolean) -> Unit) {
        if (type == 1){
            swipedSourcingSeekerList.add(SwipedSourcingSeeker(currentSourcingId, topJobSeekerId!!, true, jobOffer, null))
        }
        val request = hashMapOf<String, Any>(
            ParseTableFields.SOURCING_ID.value to currentSourcingId,
            ParseTableFields.JOB_SEEKER_ID.value to topJobSeekerId!!,
            ParseTableFields.TYPE.value to type,
            ParseTableFields.JOB_OFFER_ID.value to jobOffer.jobOfferId
        )
        ParseCloud.callFunctionInBackground(ParseCloudFunction.SOURCING_ACCEPT_V1.value, request, FunctionCallback<Any> { result, e ->
            when {
                e != null -> {
                    isSuccess(false)
                    log(e.message.toString())
                }
                result != null -> {
                    isSuccess(true)
                }
                else -> {
                    isSuccess(false)
                    log("Something Went Wrong.")
                }
            }
        })
    }

    private fun rejectOrUndoSourcing(type: Int, isSuccess: (Boolean) -> Unit) {
        if (type == 1){
            swipedSourcingSeekerList.add(SwipedSourcingSeeker(currentSourcingId, topJobSeekerId!!, false, null, null))
        }
        val request = hashMapOf<String, Any>(
            ParseTableFields.SOURCING_ID.value to currentSourcingId,
            ParseTableFields.JOB_SEEKER_ID.value to topJobSeekerId!!,
            "type" to type
        )
        ParseCloud.callFunctionInBackground(ParseCloudFunction.SOURCING_REJECT_V1.value, request, FunctionCallback<Any> { result, e ->
            when {
                e != null -> {
                    isSuccess(false)
                    log(e.message.toString())
                }
                result != null -> {
                    isSuccess(true)
                }
                else -> {
                    isSuccess(false)
                    log("Something Went Wrong.")
                }
            }
        })
    }

    private fun rewindSourcing() {
        var swipedSourcingSeeker: SwipedSourcingSeeker? = null
        swipedSourcingSeekerList.forEach {
            if (it.jobSeekerId == rewindJobSeekerId){
                swipedSourcingSeeker = it
            }
        }
        swipedSourcingSeeker?.let { sss ->
            swipedSourcingSeekerList.remove(sss)
            if (sss.isSwipedRight){
                if (sss.selectedJobOffer != null){
                    acceptOrUndoSourcing(2, sss.selectedJobOffer){
                        if (it){
                            toast("rewinded successfully")
                        }else{
                            swipedSourcingSeekerList.add(sss)
                        }
                    }
                }else if (sss.selectedSeekerFolder != null){
                    addOrRemoveFromSeekerFolder(2, sss.selectedSeekerFolder){
                        if (it){
                            toast("rewinded successfully")
                        }else{
                            swipedSourcingSeekerList.add(sss)
                        }
                    }
                }
            }else{
                rejectOrUndoSourcing(2){
                    if (it){
                        toast("rewinded successfully")
                    }else{
                        swipedSourcingSeekerList.add(sss)
                    }
                }
            }
        }
    }



    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        binding.csvJob.rewind()
    }

}

class PortfolioImageAdapter2(val list: List<String>) : RecyclerView.Adapter<PortfolioImageAdapter2.ViewHolder>() {
    var onAddMoreClick: () -> Unit = {}
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(ItemPortfolioImage2Binding.inflate(LayoutInflater.from(parent.context), parent, false))
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.binding.apply {
            if (item.isEmpty()){
                this.ivPortfolio.visibility = View.GONE
                this.tvHint.visibility = View.VISIBLE
            }else{
                this.ivPortfolio.visibility = View.VISIBLE
                this.tvHint.visibility = View.GONE
            }
            this.tvHint.setOnClickListener {
                onAddMoreClick()
            }
            loadImageFromUrl(this.ivPortfolio, item, R.drawable.pw_default_loading_view_background)
        }
    }
    override fun getItemCount(): Int = list.size
    class ViewHolder(val binding: ItemPortfolioImage2Binding) : RecyclerView.ViewHolder(binding.root)
}

class RecruiterSearchedJobCardStackAdapter(var list: ArrayList<SourcingSeeker>, val requireActivity: FragmentActivity)  : RecyclerView.Adapter<RecruiterSearchedJobCardStackAdapter.ViewHolder>() {
    var seeDescriptionClick: (SourcingSeeker) -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(ItemRecruiterJobCardBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val sourcingSeeker = list[position]
        holder.binding.apply {
            this.llFullDes.visibility = View.GONE
            this.llMostParent.setOnClickListener {
                seeDescriptionClick(sourcingSeeker)
            }


            this.tvJobSeekerId.text = sourcingSeeker.jobSeekerId

            this.tvSeekerName.text = "${sourcingSeeker.firstName} ${sourcingSeeker.lastName}"

            this.tvJobLocation.text = sourcingSeeker.city

            try {
                val university = Gson().fromJson(JSONObject(sourcingSeeker.university).toString(), University::class.java)
                if (university.name.isEmpty()){
                    this.llUniversity.visibility = View.GONE
                }else{
                    this.tvUniversityName.text = university.name
                }
                if (university.isCurrent){
                    this.tvEducation.text = StudentStatus.CURRENT.status
                }else{
                    this.tvEducation.text = StudentStatus.NON_CURRENT.status
                }
            }catch (e: Exception){}

            loadImageFromUrl(this.circleImageView, sourcingSeeker.profileURL, R.drawable.default_user_img)

            val experiences = arrayListOf<Experience>()
            val experienceJsonArray = try {
                JSONObject(sourcingSeeker.experiences).getJSONArray("list")
            }catch (e: Exception){
                JSONArray()
            }
            for (i in 0 until experienceJsonArray.length()){
                experiences.add(Gson().fromJson(experienceJsonArray.getJSONObject(i).toString(), Experience::class.java))
            }

            if (experiences.isNotEmpty()){
                this.tvJobName.text = "${experiences[0].job} - ${experiences[0].company}"
            }

            if (sourcingSeeker.interestedIn.isNotEmpty()){
                this.tvWorkTypes.text = sourcingSeeker.interestedIn.joinToString(", ")
            }

            this.cgSoftSkill.removeAllViews()
            val softSkills = try {
                Gson().fromJson(JSONArray(sourcingSeeker.softSkills).toString(), ArrayList::class.java)
            }catch (e: Exception){
                arrayListOf<String>()
            }
            softSkills.forEach { tag ->
                this.cgSoftSkill.addView(createChip(tag.toString()))
            }
        }
    }

    override fun getItemCount(): Int = list.size
    fun submitList(arrList: ArrayList<SourcingSeeker>) {
        list = arrList
    }

    class ViewHolder(val binding: ItemRecruiterJobCardBinding) : RecyclerView.ViewHolder(binding.root)

    private fun createChip(tag: String ): View {
        val chip: View = requireActivity.layoutInflater.inflate(R.layout.item_chip_white_box_gradient_border, null, false)
        val tvContract = chip.findViewById<TextView>(R.id.tv_tag)
        tvContract.text = tag
        tvContract.background = requireActivity.resources.getDrawable(R.drawable.rounded_bottom_purple_top_blue_50, null)
        tvContract.updatePadding(20, 0,20,0)
        tvContract.setTextColor(requireActivity.resources.getColor(R.color.white, null))
        return chip
    }

}

class SourcingCriteriaSpinnerAdapter(private val activity: Activity, id: Int, var list: ArrayList<SourcingCriteria>) : ArrayAdapter<SourcingCriteria>(activity, id, list) {
    var onTitleClick: () -> Unit = {}
    var onAddSourcingClick: () -> Unit = {}
    var sourcingId = ""
    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = super.getDropDownView(position, convertView, parent)
        val tv = view as TextView
        tv.text = list[position].title
        if (position == 0){
            tv.paint.shader = activity.getShader(tv)
            tv.textSize = 20f
            tv.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.ic_arrow_up_gradient,0)
            tv.setOnClickListener { onTitleClick() }
        }else{
            if (tv.text.toString() == "ajouter un tag sourcing"){
                tv.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.ic_add_gradient_holo,0)
                tv.setOnClickListener { 
                    onAddSourcingClick()
                }
            }else{
                tv.setCompoundDrawablesWithIntrinsicBounds(0,0,0,0)
            }
            if (sourcingId == list[position].sourcingId && sourcingId.isNotEmpty()){
                tv.setBackgroundColor( activity.resources.getColor(R.color.greyishWhite,null))
            }
        }
        return  view
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = super.getDropDownView(position, convertView, parent)
        val tv = view as TextView
        tv.text = list[position].title
        if (position != 0){
            sourcingId = list[position].sourcingId
        }
        return view
    }


    override fun isEnabled(position: Int): Boolean {
        super.isEnabled(position)
        return position != 0
    }

    fun submitList(sourcingCriteriaList: ArrayList<SourcingCriteria>) {
        list = sourcingCriteriaList
    }
}

data class SwipedSourcingSeeker(val sourcingId: String, val jobSeekerId: String, val isSwipedRight: Boolean, val selectedJobOffer: JobTitleFilter? , val selectedSeekerFolder: SeekerFolder?)
