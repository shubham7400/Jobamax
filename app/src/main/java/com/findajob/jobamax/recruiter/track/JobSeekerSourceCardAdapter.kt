package com.findajob.jobamax.recruiter.track

import android.content.Intent
import android.content.res.ColorStateList
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.findajob.jobamax.R
import com.findajob.jobamax.databinding.ItemJobSeekerSourceCardBinding
import com.findajob.jobamax.databinding.ItemTextChipBinding
import com.findajob.jobamax.jobseeker.profile.cv.model.ActivityGroup
import com.findajob.jobamax.jobseeker.profile.cv.model.EducationGroup
import com.findajob.jobamax.jobseeker.profile.cv.model.ExperienceGroup
import com.findajob.jobamax.jobseeker.profile.cv.model.SKillGroup
import com.findajob.jobamax.model.JobSeeker
import com.findajob.jobamax.util.log
import com.google.android.material.chip.ChipGroup
import com.google.gson.Gson
import com.parse.ParseObject
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_job_seeker_source_card.view.*

class JobSeekerSourceCardAdapter(
    val gson: Gson,
    val enableGesture: (flag: Boolean) -> Unit,
    val navVideo: (url: String) -> Unit
) : RecyclerView.Adapter<JobSeekerSourceCardAdapter.JobOfferCardViewHolder>() {


    private val diffCallBack = object : DiffUtil.ItemCallback<ParseObject>() {
        override fun areItemsTheSame(oldItem: ParseObject, newItem: ParseObject): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: ParseObject, newItem: ParseObject): Boolean {
            return oldItem.updatedAt == newItem.updatedAt
        }
    }

    private val differ = AsyncListDiffer(this, diffCallBack)

    fun submitJobSeekers(jobSeekers: List<ParseObject>) {
        differ.submitList(jobSeekers)
    }

    inner class JobOfferCardViewHolder(val binding: ItemJobSeekerSourceCardBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindTo(jobSeeker: JobSeeker) {
            binding.jobSeeker = jobSeeker

            if (jobSeeker.profilePicUrl.isNotEmpty()) {
                binding.profileIcon.load(jobSeeker.profilePicUrl)
            } else log("the profile picture url empty")

            binding.scrollToggleCard.setOnClickListener {
                if ((binding.scrollToggleButton.tag.toString().toIntOrNull() ?: 0) == 0) {
                    binding.scrollToggleButton.tag = "1"
                    enableGesture(false)
                    binding.scrollView.isEnabled = true
                    binding.scrollToggleButton.imageTintList = ColorStateList.valueOf(
                        ContextCompat.getColor(
                            itemView.context,
                            R.color.white
                        )
                    )
                    binding.scrollToggleCard.backgroundTintList = ColorStateList.valueOf(
                        ContextCompat.getColor(
                            itemView.context,
                            R.color.colorPrimary
                        )
                    )

                } else {
                    binding.scrollView.isEnabled = false
                    binding.scrollToggleButton.tag = "0"
                    enableGesture(true)

                    binding.scrollToggleButton.imageTintList = ColorStateList.valueOf(
                        ContextCompat.getColor(
                            itemView.context,
                            R.color.primary_text
                        )
                    )
                    binding.scrollToggleCard.backgroundTintList = ColorStateList.valueOf(
                        ContextCompat.getColor(
                            itemView.context,
                            R.color.white
                        )
                    )
                }
            }

            val experiences =
                gson.fromJson(jobSeeker.experiences, ExperienceGroup::class.java)?.list
                    ?: listOf()
            binding.experienceLayout.visibility =
                if (experiences.isEmpty()) View.GONE else View.VISIBLE
            binding.experienceRecycler.layoutManager = LinearLayoutManager(itemView.context)
            binding.experienceRecycler.adapter = JobSeekerExperienceAdapter(experiences)
            binding.experienceRecycler.isNestedScrollingEnabled = false

            val schools =
                gson.fromJson(jobSeeker.educations, EducationGroup::class.java)?.list ?: listOf()
            binding.schoolLayout.visibility = if (schools.isEmpty()) View.GONE else View.VISIBLE
            binding.schoolRecycler.layoutManager = LinearLayoutManager(itemView.context)
            binding.schoolRecycler.adapter = JobSeekerEducationAdapter(schools)
            binding.schoolRecycler.isNestedScrollingEnabled = false

            val skills = gson.fromJson(jobSeeker.skills, SKillGroup::class.java)?.list ?: listOf()
            binding.skillLayout.visibility = if (skills.isEmpty()) View.GONE else View.VISIBLE
            refreshChips(binding.skillChipGroup, skills)

            val activities =
                gson.fromJson(jobSeeker.activities, ActivityGroup::class.java)?.list ?: listOf()
            binding.activityLayout.visibility =
                if (activities.isEmpty()) View.GONE else View.VISIBLE
            binding.activityRecycler.layoutManager = LinearLayoutManager(itemView.context)
            binding.activityRecycler.adapter = JobSeekerActivityAdapter(activities)
            binding.activityRecycler.isNestedScrollingEnabled = false

            binding.cvLabel.text = jobSeeker.documentName
            binding.attachmentLayout.visibility =
                if (jobSeeker.attachmentCVLink.isEmpty()) View.GONE else View.VISIBLE

            binding.attachmentLayout.setOnClickListener {
                val browserIntent =
                    Intent(Intent.ACTION_VIEW, Uri.parse(jobSeeker.attachmentCVLink))
                itemView.context.startActivity(browserIntent)
            }
            binding.videoPresentationLayout.visibility =
                if (jobSeeker.personalPresentationLink.isEmpty()) View.GONE else View.VISIBLE

            if (jobSeeker.videoThumbnailUrl.isNotEmpty()) {
                try {
                    binding.playIcon.visibility = View.GONE
                    binding.thumbProgressBar.visibility = View.VISIBLE
                    Picasso.get().load(jobSeeker.videoThumbnailUrl)
                        .into(binding.videoThumbnailIcon, object : Callback {
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
                    navVideo(jobSeeker.personalPresentationLink)
                }
            }
            itemView.overlayLayout.visibility = View.GONE
        }

        private fun refreshChips(chipGroup: ChipGroup, list: List<String>) {
            chipGroup.removeAllViews()
            list.forEach { skill ->
                val chipBinding: ItemTextChipBinding = ItemTextChipBinding.inflate(
                    LayoutInflater.from(itemView.context),
                    itemView.skillChipGroup,
                    false
                )
                chipBinding.label.text = skill.trim()
                chipGroup.addView(chipBinding.root)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = JobOfferCardViewHolder(
        ItemJobSeekerSourceCardBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: JobOfferCardViewHolder, position: Int) =
        holder.bindTo(JobSeeker(differ.currentList[position]))

    override fun getItemCount() = differ.currentList.size
}
