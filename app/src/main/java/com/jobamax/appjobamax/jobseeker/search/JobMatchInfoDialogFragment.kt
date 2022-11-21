package com.jobamax.appjobamax.jobseeker.search

import android.os.Bundle
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.view.updatePadding
import androidx.fragment.app.DialogFragment
import com.jobamax.appjobamax.R
import com.jobamax.appjobamax.databinding.FragmentJobMatchInfoDialogBinding
import com.jobamax.appjobamax.model.JobOffer
import com.jobamax.appjobamax.model.MatchTag


class JobMatchInfoDialogFragment : DialogFragment() {
    lateinit var binding: FragmentJobMatchInfoDialogBinding

    private var topJobOffer: JobOffer? = null
    var isManualJobFilter = false

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentJobMatchInfoDialogBinding.inflate(inflater, container, false)
        configureUi()
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(R.style.DialogFragmentSlideAnim, R.style.DialogFragmentSlideAnim)
        topJobOffer = requireArguments().getSerializable("top_job_offer") as JobOffer
        isManualJobFilter = requireArguments().getBoolean("is_manual_job_filter")
    }


    override fun onStart() {
        super.onStart()
        dialog?.window?.apply {
            this.setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT)
            this.setBackgroundDrawableResource(R.color.transparent)
            val displayMetrics = DisplayMetrics()
            windowManager.defaultDisplay.getMetrics(displayMetrics)
            val height = displayMetrics.heightPixels
            val width = displayMetrics.widthPixels
            val layoutParams1 = this.attributes
            layoutParams1.width = width - 100
            layoutParams1.height = height - 100
            this.attributes = layoutParams1
        }
    }

    private fun configureUi() {
        setClickListeners()
        setData()
    }

    private fun setData() {
        if (isManualJobFilter){
            binding.llExperience.visibility = View.GONE
        }else{
            binding.clJobSearch.visibility = View.GONE
        }



        topJobOffer?.let { offer ->
            binding.tvLocation.text = offer.myCriteria.location
            binding.tvTypeOfWork.text = offer.myCriteria.typeOfWork
            binding.tvJobSearchKeyword.text = offer.myCriteria.jobSearches
            binding.tvJobSearchKeyword.text = offer.tags.joinToString(", ")
            offer.matches.apply {
                binding.sbEducation.progress = this.educationPer
                this.educations.forEach {
                    binding.cgEducationTags.addView(createChip(it))
                }
                binding.sbExperience.progress = this.experiencePer
                this.experiences.forEach {
                    binding.cgExperienceTags.addView(createChip(it))
                }
                binding.sbHardSkill.progress = this.hardSkillPer
                this.hardSkills.forEach {
                    binding.cgHardSkillTags.addView(createChip(it))
                }
                binding.sbSoftSkill.progress = this.softSkillPer
                this.softSkills.forEach {
                    binding.cgSoftSkillTags.addView(createChip(it))
                }
            }
        }
        binding.sbEducation.isEnabled = false
        binding.sbExperience.isEnabled = false
        binding.sbHardSkill.isEnabled = false
        binding.sbSoftSkill.isEnabled = false
    }

    private fun createChip(matchTag: MatchTag): View {
        val chip: View = layoutInflater.inflate(R.layout.item_chip_white_box_gradient_border, null, false)
        val tvContract = chip.findViewById<TextView>(R.id.tv_tag)
        val state = chip.findViewById<TextView>(R.id.tv_chip_state)
        tvContract.text = matchTag.text
        if (matchTag.matched){
            tvContract.background = resources.getDrawable(R.drawable.rounded_aquamarine_blue_gradient_border, null)
        }else{
            tvContract.background = resources.getDrawable(R.drawable.rounded_white_box_gradient_border_50, null)
        }
        tvContract.updatePadding(30, 0,30,0)
        state.text = "0"
        tvContract.setTextColor(resources.getColor(R.color.colorPrimary, null))
        return chip
    }

    private fun setClickListeners() {
        binding.ivClose.setOnClickListener { dismiss() }
    }

    companion object {
        fun newInstance(topJobOffer: JobOffer, isManualJobFilter: Boolean): JobMatchInfoDialogFragment {
            val fragment = JobMatchInfoDialogFragment()
            val args = Bundle()
            args.putSerializable("top_job_offer", topJobOffer)
            args.putBoolean("is_manual_job_filter", isManualJobFilter)
            fragment.arguments = args
            return fragment
        }
    }

}