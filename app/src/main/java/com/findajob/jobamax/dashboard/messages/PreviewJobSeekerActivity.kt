package com.findajob.jobamax.dashboard.messages

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.activity.viewModels
import androidx.core.view.marginBottom
import androidx.recyclerview.widget.LinearLayoutManager
import com.findajob.jobamax.R
import com.findajob.jobamax.base.BaseActivityMain
import com.findajob.jobamax.base.BaseViewModel
import com.findajob.jobamax.databinding.ItemJobSeekerSourceCardBinding
import com.findajob.jobamax.databinding.ItemTextChipBinding
import com.findajob.jobamax.jobseeker.profile.cv.model.*
import com.findajob.jobamax.model.JobSeeker
import com.findajob.jobamax.recruiter.track.JobSeekerActivityAdapter
import com.findajob.jobamax.recruiter.track.JobSeekerEducationAdapter
import com.findajob.jobamax.recruiter.track.JobSeekerExperienceAdapter
import com.google.android.material.chip.ChipGroup
import com.google.gson.Gson
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.item_job_seeker_source_card.*
import kotlinx.android.synthetic.main.item_job_seeker_source_card.view.*

@AndroidEntryPoint
class PreviewJobSeekerActivity : BaseActivityMain<ItemJobSeekerSourceCardBinding>() {

    private val viewModel: PreviewJobSeekerViewModel by viewModels()

    override val layoutRes: Int
        get() = R.layout.item_job_seeker_source_card

    lateinit var jobSeeker: JobSeeker
    lateinit var context: Context

    override fun getViewModel(): BaseViewModel = viewModel

    override fun onCreated(instance: Bundle?) {

        checkExtras()
        initViews()
        initObserver()
    }

    private fun initViews() {

//        binding.previewIbClose.setOnClickListener { finish() }
    }

    private fun initObserver() {
        viewModel.apply {
        }
        binding.lifecycleOwner = this
        binding.jobSeeker = jobSeeker
        context = this

        if (jobSeeker.profilePicUrl.isNotEmpty()) {
            Picasso.get().load(jobSeeker.profilePicUrl).into(binding.profileIcon)
        }
        binding.cardView.radius = 0f
        binding.cardView.elevation = 0f
        binding.scrollToggleCard.visibility = View.GONE
        val experiences = Gson().fromJson(jobSeeker.experiences, ExperienceGroup::class.java)?.list ?: listOf()
        binding.experienceLayout.visibility = if (experiences.isEmpty()) View.GONE else View.VISIBLE
        binding.experienceRecycler.layoutManager = LinearLayoutManager(context)
        binding.experienceRecycler.adapter = JobSeekerExperienceAdapter(experiences)
        binding.experienceRecycler.isNestedScrollingEnabled = false

        val schools = Gson().fromJson(jobSeeker.educations, EducationGroup::class.java)?.list ?: listOf<Education>()
        binding.schoolLayout.visibility = if (schools.isEmpty()) View.GONE else View.VISIBLE
        binding.schoolRecycler.layoutManager = LinearLayoutManager(context)
        binding.schoolRecycler.adapter = JobSeekerEducationAdapter(schools)
        binding.schoolRecycler.isNestedScrollingEnabled = false

        val skills = Gson().fromJson(jobSeeker.skills, SKillGroup::class.java)?.list ?: listOf()
        binding.skillLayout.visibility = if (skills.isEmpty()) View.GONE else View.VISIBLE
        refreshChips(binding.skillChipGroup, skills)

        val activities = Gson().fromJson(jobSeeker.activities, ActivityGroup::class.java)?.list ?: listOf()
        binding.activityLayout.visibility = if (activities.isEmpty()) View.GONE else View.VISIBLE
        binding.activityRecycler.layoutManager = LinearLayoutManager(context)
        binding.activityRecycler.adapter = JobSeekerActivityAdapter(activities)
        binding.activityRecycler.isNestedScrollingEnabled = false

        binding.cvLabel.text = jobSeeker.documentName
        binding.attachmentLayout.visibility = if (jobSeeker.attachmentCVLink.isEmpty()) View.GONE else View.VISIBLE

        binding.attachmentLayout.setOnClickListener {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(jobSeeker.attachmentCVLink))
            startActivity(browserIntent)
        }
        binding.videoPresentationLayout.visibility = if (jobSeeker.personalPresentationLink.isEmpty()) View.GONE else View.VISIBLE

        if (jobSeeker.videoThumbnailUrl.isNotEmpty()) {
            try {
                binding.playIcon.visibility = View.GONE
                binding.thumbProgressBar.visibility = View.VISIBLE
                Picasso.get().load(jobSeeker.videoThumbnailUrl).into(binding.videoThumbnailIcon, object :
                    Callback {
                    override fun onSuccess() {
                        binding.thumbProgressBar.visibility = View.GONE
                        binding.playIcon.visibility = View.VISIBLE
                    }

                    override fun onError(e: java.lang.Exception?) {
                        binding.thumbProgressBar.visibility = View.GONE
                    }

                })
            } catch (e: Exception) {
                binding.videoPresentationLayout.visibility = View.GONE
            }

            binding.videoPresentationLayout.setOnClickListener {
//                navVideo(jobSeeker.personalPresentationLink)
            }
        }
//        itemView.overlayLayout.visibility = View.GONE
    }

    private fun refreshChips(chipGroup: ChipGroup, list: List<String>) {
        chipGroup.removeAllViews()
        list.forEach { skill ->
            val chipBinding: ItemTextChipBinding = ItemTextChipBinding.inflate(LayoutInflater.from(context), skillChipGroup, false)
            chipBinding.label.text = skill.trim()
            chipGroup.addView(chipBinding.root)
        }
    }

    private fun checkExtras() {
        intent.extras?.apply {
            if (containsKey(EXTRA_JOB_SEEKER_ID)){

                with(getString(EXTRA_JOB_SEEKER_ID, "")) {
                    val jobSeekerObject = viewModel.getJobSeeker(this)
                    jobSeeker = JobSeeker(jobSeekerObject.first())
                }
            } else {
                finish()
            }
        }
    }

    companion object {
        const val EXTRA_JOB_SEEKER_ID= "user_id"
    }
}