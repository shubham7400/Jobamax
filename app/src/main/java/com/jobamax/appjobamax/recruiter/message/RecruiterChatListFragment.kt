package com.jobamax.appjobamax.recruiter.message

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.jobamax.appjobamax.R
import com.jobamax.appjobamax.base.BaseFragment
import com.jobamax.appjobamax.databinding.FragmentRecruiterChatListBinding
import com.jobamax.appjobamax.databinding.ItemRecruiterChatListBinding
import com.jobamax.appjobamax.enums.ParseCloudFunction
import com.jobamax.appjobamax.enums.ParseTableFields
import com.jobamax.appjobamax.extensions.toast
import com.jobamax.appjobamax.model.Recruiter
import com.jobamax.appjobamax.model.University
import com.jobamax.appjobamax.preference.getUserId
import com.jobamax.appjobamax.recruiter.RecruiterHomeActivity
import com.jobamax.appjobamax.recruiter.RecruiterHomeViewModel
import com.jobamax.appjobamax.recruiter.dialog.DialogSeekerFolder
import com.jobamax.appjobamax.recruiter.dialog.FilterJobRoleWiseDialog
import com.jobamax.appjobamax.recruiter.dialog.QualifyingStepDialog
import com.jobamax.appjobamax.recruiter.model.JobTitleFilter
import com.jobamax.appjobamax.recruiter.model.QualifyingStep
import com.jobamax.appjobamax.recruiter.model.RecruitmentSeeker
import com.jobamax.appjobamax.recruiter.model.SeekerFolder
import com.jobamax.appjobamax.util.getShader
import com.jobamax.appjobamax.util.loadImageFromUrl
import com.parse.FunctionCallback
import com.parse.ParseCloud
import org.json.JSONArray
import org.json.JSONObject


class RecruiterChatListFragment : BaseFragment() {
    lateinit var binding: FragmentRecruiterChatListBinding

    val viewModel: RecruiterHomeViewModel by activityViewModels()
    lateinit var recruiter: Recruiter

    lateinit var recruitmentSeekerChatListAdapter: RecruiterRecruitmentSeekerChatListAdapter

    lateinit var qualifyingStepSpinnerAdapter: QualifyingStepSpinnerAdapter
    var qualifyingStepSelectionType = 0

    var showSelectJobOfferDialog = true

    private val selectionList = arrayListOf<Int>()

    private val qualifyingSteps = QualifyingStep.getQualifyingSteps()

    var isSelectedAllForSorting = false
    private val selectedRecruitmentSeekerList = arrayListOf<RecruitmentSeeker>()
    private val selectedRefusedRecruitmentSeekerList = arrayListOf<RecruitmentSeeker>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRecruiterChatListBinding.inflate(inflater, container, false)
        configureUi()
        return binding.root
    }

    private fun configureUi() {
        setClickListeners()
        setViewModelObserver()
        initializeRecruiter()
        binding.tvSortBy.paint.shader = getShader(binding.tvSortBy)
        setRecruitmentSeekerChatListAdapter()
        setQualifyingStepAdapter()
        if (viewModel.selectedJobTitleFilter.value != null) {
            getRecruitmentSeekers(viewModel.selectedJobTitleFilter.value!!.jobOfferId)
        }
        if (viewModel.jobTitleFilterList.value.isNullOrEmpty()) {
            getJobTitleFilterList()
        }else{
            try {
                viewModel.jobTitleFilterList.value!![0].let {
                    viewModel.setSelectedJobTitleFilter(it)
                    getSelectionCount {}
                }
            }catch (e: Exception){}
        }
        binding.tvCancelMoveToFolder.paint.shader = getShader(binding.tvCancelMoveToFolder)
        binding.tvMoveToFolder.paint.shader = getShader(binding.tvMoveToFolder)
    }

    override fun onResume() {
        super.onResume()
        if (showSelectJobOfferDialog) {
            showSelectJobOfferDialog = false
            updateJobTitle()
        }
    }

    private fun setViewModelObserver() {
        viewModel.selectedJobTitleFilter.observe(viewLifecycleOwner) {
            it?.let {
                binding.tvEditRole.text = it.jobTitle
                getSelectionCount { setQualifyingStepAdapter() }
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

    private fun setData() {}



    private fun getJobTitleFilterList() {
        ParseCloud.callFunctionInBackground(
            ParseCloudFunction.GET_JOB_TITLE_FILTER_V1.value,
            hashMapOf(ParseTableFields.RECRUITER_ID.value to requireContext().getUserId()),
            FunctionCallback<Any> { result, e ->
                when {
                    e != null -> {
                        toast(e.message.toString())
                    }
                    result != null -> {
                        val list = arrayListOf<JobTitleFilter>()
                        val mainObject = JSONArray(gson.toJson(result))
                        for (i in 0 until mainObject.length()) {
                            list.add(
                                gson.fromJson(
                                    mainObject.getJSONObject(i).toString(),
                                    JobTitleFilter::class.java
                                )
                            )
                        }
                        viewModel.setJobTitleFilterList(list)
                        try {
                            viewModel.jobTitleFilterList.value!![0].let {
                                viewModel.setSelectedJobTitleFilter(it)
                                getSelectionCount{}
                            }
                        }catch (e: Exception){}
                    }
                    else -> {
                        toast("Something Went Wrong.")
                    }
                }
            })
    }


    private fun getRecruitmentSeekers(jobOfferId: String, selectionType: Int = 0) {
        ParseCloud.callFunctionInBackground(
            ParseCloudFunction.GET_RECRUITMENT_SEEKERS_V2.value,
            hashMapOf(ParseTableFields.JOB_OFFER_ID.value to jobOfferId, "selection" to selectionType),
            FunctionCallback<Any> { result, e ->
                val list = arrayListOf<RecruitmentSeeker>()
                when {
                    e != null -> {
                        toast(e.message.toString())
                    }
                    result != null -> {
                        val mainObject = JSONArray(gson.toJson(result))
                        for (i in 0 until mainObject.length()) {
                            list.add(
                                Gson().fromJson(
                                    mainObject.getJSONObject(i).toString(),
                                    RecruitmentSeeker::class.java
                                )
                            )
                        }
                    }
                    else -> {
                        toast("Something Went Wrong.")
                    }
                }
                recruitmentSeekerChatListAdapter.updateRecruitmentSeekerSelection(false)
                isSelectedAllForSorting = false
                recruitmentSeekerChatListAdapter.submitList(list)
                recruitmentSeekerChatListAdapter.notifyDataSetChanged()
            })
    }

    private fun setQualifyingStepAdapter(selectionType: Int = 1) {
        qualifyingStepSpinnerAdapter = QualifyingStepSpinnerAdapter(requireActivity(), R.layout.item_textview, qualifyingSteps)
        qualifyingStepSpinnerAdapter.item = qualifyingSteps[1].title
        binding.spQualifyingStep.adapter = qualifyingStepSpinnerAdapter
        binding.spQualifyingStep.setSelection(selectionType)
        binding.spQualifyingStep.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(p0: AdapterView<*>?, view: View?, position: Int, p3: Long) {
                    if (position > 0){
                        qualifyingStepSelectionType = qualifyingSteps[position].selectionValue
                        viewModel.selectedJobTitleFilter.value?.let {
                            getRecruitmentSeekers(it.jobOfferId, qualifyingStepSelectionType)
                        }
                        if (qualifyingStepSelectionType == 6){
                            binding.ivSeekerFolder.visibility = View.GONE
                            binding.tvMoveToFolder.visibility = View.VISIBLE
                        }else{
                            binding.ivSeekerFolder.visibility = View.VISIBLE
                            binding.tvMoveToFolder.visibility = View.GONE
                            binding.tvCancelMoveToFolder.visibility = View.GONE
                            binding.tvSortBy.visibility = View.VISIBLE
                        }
                    }
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {}
            }
        qualifyingStepSpinnerAdapter.onTitleClick = {
            binding.spQualifyingStep.onDetachedFromWindow()
        }
    }

    private fun setRecruitmentSeekerChatListAdapter() {
        recruitmentSeekerChatListAdapter =
            RecruiterRecruitmentSeekerChatListAdapter(arrayListOf(), requireContext())
        binding.rvChatList.adapter = recruitmentSeekerChatListAdapter
        recruitmentSeekerChatListAdapter.onSortClick = { rs ->
            QualifyingStepDialog(requireActivity(), qualifyingSteps) { qs ->
                recruitmentSeekerChatListAdapter.selectedRecruitmentSeekers.clear()
                updateSortList(rs, qs)
            }.show()
        }
        recruitmentSeekerChatListAdapter.onRatingChange = {
            updateRating(it)
        }
        recruitmentSeekerChatListAdapter.onChatClick = {
            val bundle = Bundle()
            bundle.putSerializable("recruitment_seeker", it)
            viewModel.selectedJobTitleFilter.value?.let { jobTitleFilter ->
                bundle.putSerializable("job_title_filter", jobTitleFilter)
            }
            val intent = Intent(requireContext(), RecruiterChatBoardActivity::class.java)
            intent.putExtras(bundle)
            startActivity(intent)
        }
        recruitmentSeekerChatListAdapter.onSeekerSelectionForSort = { recruitmentSeekers ->
            selectedRecruitmentSeekerList.clear()
            recruitmentSeekers.forEach { selectedRecruitmentSeekerList.add(it) }
        }
        recruitmentSeekerChatListAdapter.onRefusedSeekerSelectionForSort = { recruitmentSeekers, updateVisibility ->
            selectedRefusedRecruitmentSeekerList.clear()
            recruitmentSeekers.forEach { selectedRefusedRecruitmentSeekerList.add(it) }
            if (updateVisibility) {
                if (selectedRefusedRecruitmentSeekerList.isNotEmpty()){
                    binding.tvMoveToFolder.visibility = View.VISIBLE
                    binding.tvSortBy.visibility = View.GONE
                    binding.tvCancelMoveToFolder.visibility = View.GONE
                }else{
                    binding.tvMoveToFolder.visibility = View.GONE
                    binding.tvCancelMoveToFolder.visibility = View.VISIBLE
                }
            }else{
                binding.tvSortBy.visibility = View.VISIBLE
            }
        }
        recruitmentSeekerChatListAdapter.onProfileClick = { rs ->
            RecruiterRecruitmentSeekerProfileDialogFragment.getInstance(rs).show(childFragmentManager, "RecruiterRecruitmentSeekerProfile")
        }
    }

    private fun updateRating(rs: RecruitmentSeeker) {
        val request = hashMapOf<String, Any>(
            ParseTableFields.JOB_OFFER_ID.value to rs.jobOfferId,
            ParseTableFields.JOB_SEEKER_ID.value to rs.jobSeekerId,
            ParseTableFields.RATING.value to rs.rating
        )
        ParseCloud.callFunctionInBackground(ParseCloudFunction.SAVE_RATING_V1.value, request, FunctionCallback<Any> { result, e ->
            when {
                e != null -> toast(e.message.toString()+ " Something Went Wrong.")
                result == null -> toast("Something Went Wrong.")
                else -> {}
            }
        })
    }

    private fun updateSortList(rs: RecruitmentSeeker?, qs: QualifyingStep) {
        val request = hashMapOf<String, Any>()
        if (rs != null) {
            request["jobSeekerIds"] = arrayListOf(rs.jobSeekerId)
        } else {
            request["jobSeekerIds"] = ArrayList(selectedRecruitmentSeekerList.map { it.jobSeekerId })
        }
        request[ParseTableFields.JOB_OFFER_ID.value] = viewModel.selectedJobTitleFilter.value!!.jobOfferId
        request["action"] = qs.selectionValue
        ParseCloud.callFunctionInBackground(ParseCloudFunction.HANDLE_MULTIPLE_ACTION_V1.value,
            request,
            FunctionCallback<Any> { result, e ->
                when {
                    e != null -> toast(e.message.toString() + " Something Went Wrong")
                    result != null -> {
                        toast("Sorted Successfully.")
                        getSelectionCount {
                            viewModel.selectedJobTitleFilter.value?.let {
                                setQualifyingStepAdapter((qualifyingStepSelectionType + 1))
                            }
                        }
                    }
                    else -> toast("Something Went Wrong.")
                }
            }
        )
    }

    private fun setClickListeners() {
        binding.tvSortBy.setOnClickListener {
            if (viewModel.selectedJobTitleFilter.value != null) {
                if (isSelectedAllForSorting) {
                    if (selectedRecruitmentSeekerList.isEmpty()) {
                        recruitmentSeekerChatListAdapter.updateRecruitmentSeekerSelection(false)
                        isSelectedAllForSorting = false
                    } else {
                        QualifyingStepDialog(requireActivity(), qualifyingSteps) { qs ->
                            recruitmentSeekerChatListAdapter.selectedRecruitmentSeekers.clear()
                            recruitmentSeekerChatListAdapter.updateRecruitmentSeekerSelection(false)
                            updateSortList(null, qs)
                        }.show()
                    }
                } else {
                    recruitmentSeekerChatListAdapter.updateRecruitmentSeekerSelection(true)
                    recruitmentSeekerChatListAdapter.update(qualifyingStepSelectionType)
                    isSelectedAllForSorting = true
                }
                recruitmentSeekerChatListAdapter.notifyDataSetChanged()
            } else {
                toast("Please select job offer first")
            }
        }
        binding.tvEditRole.setOnClickListener {
            updateJobTitle()
        }
        binding.tvMoveToFolder.setOnClickListener {
            if (viewModel.selectedJobTitleFilter.value != null) {
                if (selectedRefusedRecruitmentSeekerList.isEmpty()) {
                    recruitmentSeekerChatListAdapter.updateRecruitmentSeekerSelection(true)
                    recruitmentSeekerChatListAdapter.update(qualifyingStepSelectionType)
                    isSelectedAllForSorting = true
                    it.visibility = View.GONE
                    binding.tvSortBy.visibility = View.GONE
                    binding.tvCancelMoveToFolder.visibility = View.VISIBLE
                    recruitmentSeekerChatListAdapter.notifyDataSetChanged()
                } else {
                    DialogSeekerFolder(requireActivity(), viewModel.seekerFolders.value) { seekerFolder ->
                         moveRecruitmentSeekerToFolder(seekerFolder)
                    }.show()
                }
            } else {
                toast("Please select job offer first")
            }
        }
        binding.tvCancelMoveToFolder.setOnClickListener {
            it.visibility = View.GONE
            binding.tvSortBy.visibility = View.VISIBLE
            binding.tvMoveToFolder.visibility = View.VISIBLE
            recruitmentSeekerChatListAdapter.updateRecruitmentSeekerSelection(false)
            isSelectedAllForSorting = false
            recruitmentSeekerChatListAdapter.notifyDataSetChanged()
        }
        binding.ivSeekerFolder.setOnClickListener {
            if (viewModel.selectedJobTitleFilter.value == null) {
                toast("Please select job offer first")
            } else {
                DialogSeekerFolder(requireActivity(), viewModel.seekerFolders.value) { seekerFolder ->
                    val importSeekerDialogFragment =
                        RecruiterImportSeekerToQualifyingStepDialogFragment.newInstance(
                            viewModel.selectedJobTitleFilter.value!!,
                            qualifyingStepSelectionType,
                            seekerFolder
                        )
                    importSeekerDialogFragment.show(childFragmentManager, "RecruiterImportSeekerToQualifyingStepDialogFragment")
                }.show()
            }
        }

    }

    private fun moveRecruitmentSeekerToFolder(seekerFolder: SeekerFolder) {
        val request = hashMapOf<String, Any>(
            ParseTableFields.FOLDER_ID.value to seekerFolder.folderId,
            "jobSeekerIds" to  ArrayList(selectedRefusedRecruitmentSeekerList.map { it.jobSeekerId }),
            ParseTableFields.RECRUITER_ID.value to requireContext().getUserId(),
            ParseTableFields.TYPE.value to 1
        )
        ParseCloud.callFunctionInBackground(ParseCloudFunction.HANDLE_FOLDER_ACTION_V1.value, request, FunctionCallback<Any> { result, e ->
            when{
                e != null -> toast(e.message.toString()+ " Something Went Wrong.")
                result == null -> toast("Something Went Wrong.")
                else -> {
                    recruitmentSeekerChatListAdapter.updateRecruitmentSeekerSelection(false)
                    isSelectedAllForSorting = false
                    recruitmentSeekerChatListAdapter.notifyDataSetChanged()
                }
            }
        })
    }

    private fun getSelectionCount( onSuccess: (Boolean) -> Unit ) {
        ParseCloud.callFunctionInBackground(
            ParseCloudFunction.GET_SELECTION_COUNT_V1.value,
            hashMapOf(ParseTableFields.JOB_OFFER_ID.value to viewModel.selectedJobTitleFilter.value!!.jobOfferId),
            FunctionCallback<Any> { result, e ->
                when {
                    e != null -> toast(e.message.toString() + " Something went wrong.")
                    result != null -> {
                        selectionList.clear()
                        val jsonObject = JSONObject(gson.toJson(result))
                        qualifyingSteps.forEach {
                            try {
                                val title = it.title.replaceAfter("(","").removeSuffix("(").trim()
                                it.title = "$title (${jsonObject.getInt(it.key)})"
                                println("fldfjkd ${it.title}")
                            } catch (e: Exception) {
                            }
                        }
                        onSuccess(true)
                    }
                    else -> toast("Something went wrong")
                }
            })
    }

    private fun updateJobTitle() {
        FilterJobRoleWiseDialog(requireActivity(), viewModel.jobTitleFilterList.value, viewModel.selectedJobTitleFilter.value) { selectedJobTitleFilter ->
            viewModel.setSelectedJobTitleFilter(selectedJobTitleFilter)
            getSelectionCount{}
        }.show()
    }

}

class RecruiterRecruitmentSeekerChatListAdapter(
    var list: ArrayList<RecruitmentSeeker>,
    val requireContext: Context
) :
    RecyclerView.Adapter<RecruiterRecruitmentSeekerChatListAdapter.ViewHolder>() {
    var onSortClick: (RecruitmentSeeker) -> Unit = {}
    var onChatClick: (RecruitmentSeeker) -> Unit = {}
    var onRatingChange: (RecruitmentSeeker) -> Unit = {}
    var onProfileClick: (RecruitmentSeeker) -> Unit = {}
    var onSeekerSelectionForSort: (ArrayList<RecruitmentSeeker>) -> Unit = {}
    var onRefusedSeekerSelectionForSort: (ArrayList<RecruitmentSeeker>, updateVisibility: (Boolean)) -> Unit = { list , v -> }
    val gson = Gson()

    var isRecruitmentSeekerSelected = false
    var selectionType = 0

    var selectedRecruitmentSeekers = arrayListOf<RecruitmentSeeker>()
    var selectedRefusedRecruitmentSeekers = arrayListOf<RecruitmentSeeker>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
        ItemRecruiterChatListBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.binding.apply {
            loadImageFromUrl(this.civUser, item.profileURL, R.drawable.default_user_img)
            this.tvRecruitmentSeekerName.text = "${item.firstName} ${item.lastName}"
            try {
                val university =
                    gson.fromJson(JSONObject(item.university).toString(), University::class.java)
                if (university != null) {
                    if (university.name.isEmpty()) {
                        this.tvUniversityName.visibility = View.INVISIBLE
                    } else {
                        this.tvUniversityName.text = university.name
                    }
                } else {
                    this.tvUniversityName.visibility = View.INVISIBLE
                }
            } catch (e: Exception) {
                this.tvUniversityName.visibility = View.INVISIBLE
            }

            this.civUser.setOnClickListener {
                onProfileClick(item)
            }

            this.tvMatchedPer.text = item.matchedPercentage.toString()+"%"
            this.rbRating.rating = item.rating.toFloat()
            this.rbRating.setOnRatingBarChangeListener { _, rating, b ->
                item.rating = rating.toLong()
                onRatingChange(item )
            }

            this.tvSortBtn.setOnClickListener { onSortClick(item) }
            this.ivChat.setOnClickListener { onChatClick(item) }
            if (selectionType == 6){
                if (isRecruitmentSeekerSelected) {
                    this.tvSortBtn.visibility = View.GONE
                    this.clParent.setOnClickListener {
                        if (selectedRefusedRecruitmentSeekers.contains(item)) {
                            selectedRefusedRecruitmentSeekers.remove(item)
                            this.clParent.setBackgroundColor(requireContext.resources.getColor(R.color.transparent, null))
                        } else {
                            selectedRefusedRecruitmentSeekers.add(item)
                            this.clParent.setBackgroundColor(requireContext.resources.getColor(R.color.background_blue, null))
                        }
                        onRefusedSeekerSelectionForSort(selectedRefusedRecruitmentSeekers, true)
                    }
                } else {
                    this.tvSortBtn.visibility = View.VISIBLE
                    selectedRefusedRecruitmentSeekers.clear()
                    this.clParent.isClickable = false
                    this.clParent.setBackgroundColor(requireContext.resources.getColor(R.color.transparent, null))
                    onRefusedSeekerSelectionForSort(selectedRefusedRecruitmentSeekers, false)
                }
            }else{
                if (isRecruitmentSeekerSelected) {
                    this.tvSortBtn.visibility = View.GONE
                    this.clParent.setOnClickListener {
                        if (selectedRecruitmentSeekers.contains(item)) {
                            selectedRecruitmentSeekers.remove(item)
                            this.clParent.setBackgroundColor(requireContext.resources.getColor(R.color.transparent, null))
                        } else {
                            selectedRecruitmentSeekers.add(item)
                            this.clParent.setBackgroundColor(requireContext.resources.getColor(R.color.background_blue, null))
                        }
                        onSeekerSelectionForSort(selectedRecruitmentSeekers)
                    }
                } else {
                    this.tvSortBtn.visibility = View.VISIBLE
                    selectedRecruitmentSeekers.clear()
                    this.clParent.isClickable = false
                    this.clParent.setBackgroundColor(requireContext.resources.getColor(R.color.transparent, null))
                    onSeekerSelectionForSort(selectedRecruitmentSeekers)
                }

            }
         }
    }

    override fun getItemCount(): Int = list.size
    fun submitList(recruitmentSeekerList: ArrayList<RecruitmentSeeker>) {
        list = recruitmentSeekerList
    }

    fun updateRecruitmentSeekerSelection(b: Boolean) {
        isRecruitmentSeekerSelected = b
    }

    fun update(qualifyingStepSelectionType: Int) {
        selectionType = qualifyingStepSelectionType
    }

    class ViewHolder(val binding: ItemRecruiterChatListBinding) :
        RecyclerView.ViewHolder(binding.root)
}

class QualifyingStepSpinnerAdapter(
    private val activity: Activity,
    id: Int,
    val list: ArrayList<QualifyingStep>
) : ArrayAdapter<QualifyingStep>(activity, id, list) {
    var onTitleClick: () -> Unit = {}
    var item = ""
    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = super.getDropDownView(position, convertView, parent)
        val tv = view as TextView
        tv.text = list[position].title
        if (position == 0) {
            tv.paint.shader = activity.getShader(tv)
            tv.textSize = 20f
            tv.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_arrow_up_gradient, 0)
            tv.setOnClickListener { onTitleClick() }
        } else {
            tv.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0)
            if (item == tv.text.toString()) {
                tv.setBackgroundColor(activity.resources.getColor(R.color.greyishWhite, null))
            }
        }
        return view
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = super.getDropDownView(position, convertView, parent)
        val tv = view as TextView
        tv.text = list[position].title
        if (position != 0) {
            item = tv.text.toString()
        }
        return view
    }


    override fun isEnabled(position: Int): Boolean {
        super.isEnabled(position)
        return position != 0
    }
}

