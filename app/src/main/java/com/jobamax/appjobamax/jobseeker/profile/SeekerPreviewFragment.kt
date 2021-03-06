package com.jobamax.appjobamax.jobseeker.profile


import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import com.jobamax.appjobamax.R
import com.jobamax.appjobamax.base.BaseFragmentMain
import com.jobamax.appjobamax.data.pojo.*
import com.jobamax.appjobamax.databinding.*
import com.jobamax.appjobamax.jobseeker.home.JobSeekerHomeViewModel
import com.jobamax.appjobamax.jobseeker.profile.cv.model.*
import com.jobamax.appjobamax.model.JobSeeker
import com.jobamax.appjobamax.util.loadImageFromUrl
import com.jobamax.appjobamax.util.log
import com.google.android.material.chip.Chip
import com.google.gson.Gson
import com.jobamax.appjobamax.preference.getLanguage
import com.jobamax.appjobamax.util.convertDateToCurrentLanguage
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.item_link.view.*
import org.json.JSONArray
import org.json.JSONObject
import java.io.IOException


@AndroidEntryPoint
class SeekerPreviewFragment : BaseFragmentMain<FragmentSeekerPreviewBinding>() {

    override val layoutRes: Int get() = R.layout.fragment_seeker_preview
    val viewModel: JobSeekerHomeViewModel by activityViewModels()
    override fun getViewModel(): ViewModel = viewModel

    var jobSeeker: JobSeeker? = null

    var schoolAdapter: SeekerPreviewSchoolAdapter? = null
    var experienceAdapter: SeekerPreviewExperienceAdapter? = null
    var hardSkillAdapter: SeekerPreviewHardSkillAdapter? = null
    var volunteeringAdapter: SeekerPreviewVolunteeringAdapter? = null
    var idealJobImageAdapter: SeekerPreviewIdealJobImagesAdapter? = null
    private var portfolioImageAdapter: SeekerPreviewPortfolioImagesAdapter? = null

    var idealJob: IdealJob? = null
    private val idealJobImageUrlList = arrayListOf<String>()

    var portfolio: Portfolio? = null
    private val portfolioImageUrlList = arrayListOf<String>()

    private var ownedSoftSkills = ArrayList<String>()
    private var workspaces = listOf<String>()
    var activitiesTags = ArrayList<String>()

    private val mSeekbarUpdateHandler: Handler = Handler()
    var player: MediaPlayer? = null
    private var mStartPlaying = true
    var mUpdateSeekbar: Runnable? = null



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentSeekerPreviewBinding.inflate(inflater, container, false)
        jobSeeker = viewModel.jobSeeker
        binding.jobSeeker = viewModel.jobSeeker
        jobSeeker?.let {
            configureUi()
        }
        return binding.root
    }


    private fun configureUi() {
        binding.tvSeekerName.text = "${jobSeeker?.firstName} ${jobSeeker?.lastName}"
        binding.tvSeekerProfession.text = jobSeeker?.profession ?: ""
        loadImageFromUrl(binding.civSeeker, jobSeeker?.profilePicUrl)
        binding.tvSeekerAbout.text = jobSeeker?.elevatorPitch ?: ""
        if (jobSeeker?.elevatorPitch.isNullOrEmpty()) {
            binding.tvSeekerAbout.visibility = View.GONE
            binding.tvAboutTitle.visibility = View.GONE
        }else{
            binding.tvSeekerAbout.visibility = View.VISIBLE
            binding.tvAboutTitle.visibility = View.VISIBLE
        }
        setAdapters()
    }

    private fun setAdapters() {
        setSchoolAdapter()
        setExperienceAdapter()
        setHardSkillAdapter()
        setVolunteeringAdapter()
        setIdealJobImageAdapter()
        setPortfolioImageAdapter()
        getIdealJobData()
        getIdealWorkspace()
        getPortfolioData()
        setSoftSkill()
        setActivitiesTags()
        setClickListeners()
        setIdealJobAudio()
    }

    private fun getIdealWorkspace() {
        if (viewModel.jobSeeker.workspaces.isNotEmpty()){
            workspaces =  viewModel.jobSeeker.workspaces
        }
        binding.cgIdealWorkspace.removeAllViews()
        workspaces.forEach {
            val chip = layoutInflater.inflate(R.layout.item_custom_chip, binding.cgIdealWorkspace, false) as Chip
            chip.text = it
            binding.cgIdealWorkspace.addView(chip)
        }
        if (workspaces.isEmpty()){
            binding.tvIdealWorkspaceTitle.visibility = View.GONE
            binding.cgIdealWorkspace.visibility = View.GONE
        }else{
            binding.tvIdealWorkspaceTitle.visibility = View.VISIBLE
            binding.cgIdealWorkspace.visibility = View.VISIBLE
        }
    }

    private fun setIdealJobAudio() {
        binding.sbAudio.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, progress: Int, fromUser: Boolean) {
                if (fromUser)
                    player?.seekTo(progress)
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {

            }

        })
    }

    private fun setClickListeners() {
         binding.ivIdealJobVideo.setOnClickListener {
             idealJob?.videoURL?.let {
                 if (it  != ""){
                     startActivity( Intent(requireContext(), VideoPlayActivity::class.java).putExtra("video_url", it))
                 }
             }
         }
        binding.ivPortfolioVideo.setOnClickListener {
            portfolio?.videoURL?.let {
                if (it  != ""){
                    startActivity( Intent(requireContext(), VideoPlayActivity::class.java).putExtra("video_url", it))
                }
            }
        }
        binding.ivBackButton.setOnClickListener {
            requireActivity().onBackPressed()
        }

        binding.ivAudioPlayBtn.setOnClickListener {
            onPlay(mStartPlaying)
        }

        binding.ivUserProfile.setOnClickListener {
            requireActivity().onBackPressed()
        }
    }

    private fun onPlay(start: Boolean) = if (start) { startPlaying() } else { stopPlaying() }
    private fun startPlaying() {
        if (player != null){
            player!!.start()
            mStartPlaying = false
            binding.ivAudioPlayBtn.setImageResource(R.drawable.pause)
        }else{
            player = MediaPlayer().apply {
                try {
                    idealJob?.audioUrl?.let { audioUrl ->
                        setDataSource(audioUrl)
                        prepare()
                        start()
                        mStartPlaying = false
                        binding.ivAudioPlayBtn.setImageResource(R.drawable.pause)
                    }
                } catch (e: IOException) {
                    log(  "prepare() failed")
                }
            }
        }

        mUpdateSeekbar  = object : Runnable {
            override fun run() {
                binding.sbAudio.progress = player!!.currentPosition
                binding.tvAudioDuration.text = convertMillisToMinuteAndSecond((player!!.duration - binding.sbAudio.progress).toLong())
                mSeekbarUpdateHandler.postDelayed(this, 0)
            }
        }

        binding.sbAudio.max = player!!.duration
        mSeekbarUpdateHandler.postDelayed(mUpdateSeekbar!!, 0)

        player?.setOnCompletionListener {
            binding.ivAudioPlayBtn.setImageResource(R.drawable.play)
            mSeekbarUpdateHandler.removeCallbacks(mUpdateSeekbar!!)
        }
    }

    fun convertMillisToMinuteAndSecond(millis: Long) : String {
        val milliseconds: Long = millis
        val minutes = milliseconds / 1000 / 60
        val seconds = milliseconds / 1000 % 60
        return "$minutes min : $seconds sec"
    }

    private fun stopPlaying() {
        player?.pause()
        mStartPlaying = true
        binding.ivAudioPlayBtn.setImageResource(R.drawable.play)
        mSeekbarUpdateHandler.removeCallbacks(mUpdateSeekbar!!)
    }

    private fun setActivitiesTags() {
       if (viewModel.jobSeeker.interests.isEmpty()){ }else{
           val activities = JSONArray(viewModel.jobSeeker.interests)
           var i = 0
           while (i < activities.length()) {
               activitiesTags.add(activities.getString(i))
               i++
           }
           activitiesTags.forEach { str ->
               val chip = layoutInflater.inflate(R.layout.item_custom_chip, binding.cgActivities, false) as Chip
               chip.text = str
               binding.cgActivities.addView(chip)
           }
       }
        if (activitiesTags.isEmpty()){
            binding.tvInterest.visibility = View.GONE
            binding.cgActivities.visibility = View.GONE
        }else{
            binding.tvInterest.visibility = View.VISIBLE
            binding.cgActivities.visibility = View.VISIBLE
        }
    }


    private fun setSoftSkill() {
        if (viewModel.jobSeeker.softSkills != ""){
            val softSkills =  JSONArray(viewModel.jobSeeker.softSkills)
            var i = 0
            while (i < softSkills.length()){
                ownedSoftSkills.add(softSkills.getString(i) )
                i++
            }
        }
        binding.cgSoftSkill.removeAllViews()
        ownedSoftSkills.forEach {
            val chip = layoutInflater.inflate(R.layout.item_custom_chip, binding.cgSoftSkill, false) as Chip
            chip.text = it
            chip.setOnCloseIconClickListener { c ->
                ownedSoftSkills.remove((c as Chip).text)
                binding.cgSoftSkill.removeView(c)
            }
            binding.cgSoftSkill.addView(chip)
        }
        if (ownedSoftSkills.isEmpty()){
            binding.tvSoftSkill.visibility = View.GONE
            binding.cgSoftSkill.visibility = View.GONE
        }else{
            binding.tvSoftSkill.visibility = View.VISIBLE
            binding.cgSoftSkill.visibility = View.VISIBLE
        }
    }

    private fun getPortfolioData() {
        jobSeeker?.portfolio?.let { parseObject ->
            portfolioImageAdapter = SeekerPreviewPortfolioImagesAdapter(portfolioImageUrlList)
            binding.rvPortfolioImages.adapter = portfolioImageAdapter
            portfolio = Portfolio(parseObject)
            if (portfolio!!.videoURL.isEmpty()) {
                binding.cvPortfolioVideo.visibility = View.GONE
            }else{
                binding.cvPortfolioVideo.visibility = View.VISIBLE
            }
            binding.tvPortfolioDescription.text = portfolio!!.text
            portfolio!!.arrImages.forEach {
                portfolioImageUrlList.add(it)
            }
            portfolioImageAdapter!!.submitList(portfolioImageUrlList)
            portfolioImageAdapter!!.notifyDataSetChanged()

            if (portfolio!!.audioUrl.isEmpty() && portfolio!!.text.isEmpty() && portfolio!!.arrImages.isEmpty()){
                binding.tvPortfolioTitle.visibility = View.GONE
            }else{
                binding.tvPortfolioTitle.visibility = View.VISIBLE
            }

            val itemLinkView = LayoutInflater.from(requireContext()).inflate(R.layout.item_link, binding.llLinks, false)
            binding.llLinks.removeAllViews()
            portfolio?.links?.forEach { link ->
                itemLinkView.tv_link.text = link
                binding.llLinks.addView(itemLinkView)
            }
        }

    }


    private fun getIdealJobData() {
        jobSeeker?.idealJob?.let { parseObject ->

            idealJobImageAdapter = SeekerPreviewIdealJobImagesAdapter(idealJobImageUrlList)
            binding.rvIdealJobImages.adapter = idealJobImageAdapter
            idealJob = IdealJob(parseObject)
            if (idealJob!!.audioUrl.isEmpty()) {
                binding.clAudioPlayer.visibility = View.GONE
            }else{
                binding.clAudioPlayer.visibility = View.VISIBLE
            }
            if (idealJob!!.videoURL.isEmpty()) {
                binding.cvIdealJobVideo.visibility = View.GONE
            }else{
                binding.cvIdealJobVideo.visibility = View.VISIBLE
            }
            binding.tvIdealJobDescription.text = idealJob!!.text
            idealJob!!.arrImages.forEach {
                idealJobImageUrlList.add(it)
            }
            idealJobImageAdapter!!.submitList(idealJobImageUrlList)
            idealJobImageAdapter!!.notifyDataSetChanged()

            if (idealJob?.text?.isEmpty() != false && idealJob?.audioUrl?.isEmpty() != false && idealJob?.videoURL?.isEmpty() != false){
                binding.tvIdealJobTitle.visibility = View.GONE
            }else{
                binding.tvIdealJobTitle.visibility = View.VISIBLE
            }
        }
    }

    private fun setPortfolioImageAdapter() {

    }

    private fun setIdealJobImageAdapter() {

    }

    private fun setVolunteeringAdapter() {
        volunteeringAdapter = SeekerPreviewVolunteeringAdapter(arrayListOf(), requireContext())
        binding.rvVolunteering.adapter = volunteeringAdapter
        val volunteerings = try {
            ArrayList(Gson().fromJson(viewModel.jobSeeker.volunteerings, VolunteeringGroup::class.java)?.list ?: listOf())
        }catch (e: Exception){
            log("${e.message.toString()}")
            arrayListOf()
        }
        if (volunteerings.isEmpty()){
            binding.tvVolunteeringTitle.visibility = View.GONE
        }else{
            binding.tvVolunteeringTitle.visibility = View.VISIBLE
            volunteeringAdapter!!.submitList(volunteerings)
            volunteeringAdapter!!.notifyDataSetChanged()
        }
    }

    private fun setHardSkillAdapter() {
        val ownedHardSkills = ArrayList<HardSkill>()
        hardSkillAdapter = SeekerPreviewHardSkillAdapter(ownedHardSkills)
        binding.rvHardSkill.adapter = hardSkillAdapter
        if (viewModel.jobSeeker.hardSkills != ""){
            val hardSkillJsonObj = JSONObject(viewModel.jobSeeker.hardSkills)
            for (key in hardSkillJsonObj.keys().iterator())  {
                ownedHardSkills.add(HardSkill(key, hardSkillJsonObj.getInt(key)))
            }
        }
        hardSkillAdapter!!.submitList(ownedHardSkills)
        hardSkillAdapter!!.notifyDataSetChanged()
        if (ownedHardSkills.isEmpty()){
            binding.tvHardSkill.visibility = View.GONE
            binding.rvHardSkill.visibility = View.GONE
        }else{
            binding.tvHardSkill.visibility = View.VISIBLE
            binding.rvHardSkill.visibility = View.VISIBLE
        }
    }

    private fun setExperienceAdapter() {
        experienceAdapter = SeekerPreviewExperienceAdapter(arrayListOf(), requireContext())
        binding.rvExperience.adapter = experienceAdapter
        val experiences = try {
            ArrayList(Gson().fromJson(viewModel.jobSeeker.experiences, ExperienceGroup::class.java)?.list ?: listOf())
        }catch (e: Exception){
            log("${e.message.toString()}")
            arrayListOf()
        }
        experienceAdapter!!.submitList(experiences)
        experienceAdapter!!.notifyDataSetChanged()
        if (experiences.isEmpty()){
            binding.tvExperience.visibility = View.GONE
            binding.rvExperience.visibility = View.GONE
        }else{
            binding.tvExperience.visibility = View.VISIBLE
            binding.rvExperience.visibility = View.VISIBLE
        }
        binding.ivSeeLessExperience.setOnClickListener {
            experienceAdapter?.changeVisibility(true)
            experienceAdapter?.notifyDataSetChanged()
            it.visibility = View.GONE
            binding.ivSeeMoreExperience.visibility = View.VISIBLE
        }
        binding.ivSeeMoreExperience.setOnClickListener {
            experienceAdapter?.changeVisibility(false)
            experienceAdapter?.notifyDataSetChanged()
            it.visibility = View.GONE
            binding.ivSeeLessExperience.visibility = View.VISIBLE
        }
        if(experiences.isEmpty() || experiences.size < 3){
            binding.ivSeeLessExperience.visibility = View.GONE
            binding.ivSeeMoreExperience.visibility = View.GONE
        }
    }

    private fun setSchoolAdapter() {
        schoolAdapter = SeekerPreviewSchoolAdapter(arrayListOf(), requireContext())
        binding.rvSchool.adapter = schoolAdapter
        val educations = try {
            ArrayList(Gson().fromJson(viewModel.jobSeeker.educations, EducationGroup::class.java)?.list ?: listOf())
        }catch (e: Exception){
            log("${e.message.toString()}")
            arrayListOf()
        }
        schoolAdapter!!.submitList(educations)
        schoolAdapter!!.notifyDataSetChanged()
        if (educations.isEmpty()){
            binding.tvSchool.visibility = View.GONE
            binding.rvSchool.visibility = View.GONE
        }else{
            binding.tvSchool.visibility = View.VISIBLE
            binding.rvSchool.visibility = View.VISIBLE
        }
    }

    override fun onCreated(savedInstance: Bundle?) {

    }

}

class SeekerPreviewSchoolAdapter(var list: ArrayList<Education>, val requireContext: Context) : RecyclerView.Adapter<SeekerPreviewSchoolAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
        ItemSeekerPreviewSchoolBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val education = list[position]
        holder.binding.apply {
            this.tvInstituteName.text = education.name
            this.tvProgramName.text = education.program
            when {
                education.startDate == "" -> {
                    this.tvDateDuration.visibility = View.GONE
                }
                education.endDate == "" -> {
                    this.tvDateDuration.text = "${convertDateToCurrentLanguage(education.startDate, requireContext.getLanguage())} - present"
                }
                else -> {
                    this.tvDateDuration.text = "${convertDateToCurrentLanguage(education.startDate, requireContext.getLanguage())} - ${convertDateToCurrentLanguage(education.endDate, requireContext.getLanguage())}"
                }
            }
            loadImageFromUrl(holder.binding.ivInstitute, education.logo, R.drawable.school_dummy)
         }
    }
    override fun getItemCount(): Int = list.size
    fun submitList(educations: ArrayList<Education>) {
        list = educations
    }

    class ViewHolder(val binding: ItemSeekerPreviewSchoolBinding) : RecyclerView.ViewHolder(binding.root)
}

class SeekerPreviewExperienceAdapter(var list: ArrayList<Experience>,val requireContext: Context) : RecyclerView.Adapter<SeekerPreviewExperienceAdapter.ViewHolder>() {
    var isVisibleLess = true
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(ItemSeekerPreviewExperienceBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val experience = list[position]
        holder.binding.apply {
            this.tvCompanyName.text = experience.company
            this.tvProfession.text = experience.job
            when {
                experience.startDate == "" -> {
                    this.tvDateDuration.visibility = View.GONE
                }
                experience.endDate == "" -> {
                    this.tvDateDuration.text = "${convertDateToCurrentLanguage(experience.startDate, requireContext.getLanguage())} - present"
                }
                else -> {
                    this.tvDateDuration.text = "${convertDateToCurrentLanguage(experience.startDate, requireContext.getLanguage())} - ${convertDateToCurrentLanguage(experience.endDate, requireContext.getLanguage())}"
                }
            }
            loadImageFromUrl(this.ivCompany, experience.logo, R.drawable.experience_dummy)
            if (position > 1 && isVisibleLess){
                this.clMostParent.visibility = View.GONE
                this.clMostParent.layoutParams = RecyclerView.LayoutParams(0, 0)
            }else{
                this.clMostParent.visibility = View.VISIBLE
                this.clMostParent.layoutParams = RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
            }
        }
    }
    override fun getItemCount(): Int = list.size
    fun submitList(experiences: ArrayList<Experience>) {
        list = experiences
    }

    fun changeVisibility(state: Boolean) {
        isVisibleLess = state
    }

    class ViewHolder(val binding: ItemSeekerPreviewExperienceBinding) : RecyclerView.ViewHolder(binding.root)
}

class SeekerPreviewHardSkillAdapter(var list : ArrayList<HardSkill>) : RecyclerView.Adapter<SeekerPreviewHardSkillAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(ItemSeekerPreviewHardSkillBinding.inflate(LayoutInflater.from(parent.context), parent, false))
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

class SeekerPreviewVolunteeringAdapter(var list: ArrayList<Volunteering>, val requireContext: Context) : RecyclerView.Adapter<SeekerPreviewVolunteeringAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(ItemSeekerPreviewVolunteeringBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val volunteering = list[position]
        holder.binding.apply {
            this.tvCompanyName.text = volunteering.company
            this.tvJob.text = volunteering.job
            when {
                volunteering.startDate == "" -> {
                    this.tvDateDuration.visibility = View.GONE
                }
                volunteering.endDate == "" -> {
                    this.tvDateDuration.text = "${convertDateToCurrentLanguage(volunteering.startDate, requireContext.getLanguage())} - present"
                }
                else -> {
                    this.tvDateDuration.text = "${convertDateToCurrentLanguage(volunteering.startDate, requireContext.getLanguage())} - ${convertDateToCurrentLanguage(volunteering.endDate, requireContext.getLanguage())}"
                }
            }
            loadImageFromUrl(this.ivCompany, volunteering.logo, R.drawable.volunteering_dummy)
        }
    }
    override fun getItemCount(): Int = list.size
    fun submitList(volunteerings: ArrayList<Volunteering>) {
        list = volunteerings
    }

    class ViewHolder(val binding: ItemSeekerPreviewVolunteeringBinding) : RecyclerView.ViewHolder(binding.root)
}

class SeekerPreviewIdealJobImagesAdapter(var list : ArrayList<String>) : RecyclerView.Adapter<SeekerPreviewIdealJobImagesAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(ItemImageBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Picasso.get().load(list[position]).into(holder.binding.ivUser)
    }
    override fun getItemCount(): Int = list.size
    fun submitList(urlList : ArrayList<String>) {
        list = urlList
    }

    class ViewHolder(val binding: ItemImageBinding) : RecyclerView.ViewHolder(binding.root)
}

class SeekerPreviewPortfolioImagesAdapter(var list : ArrayList<String>) : RecyclerView.Adapter<SeekerPreviewPortfolioImagesAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(ItemImageBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Picasso.get().load(list[position]).into(holder.binding.ivUser)
    }
    override fun getItemCount(): Int = list.size
    fun submitList(portfolioImageUrlList: ArrayList<String>) {
        list = portfolioImageUrlList
    }

    class ViewHolder(val binding: ItemImageBinding) : RecyclerView.ViewHolder(binding.root)
}

