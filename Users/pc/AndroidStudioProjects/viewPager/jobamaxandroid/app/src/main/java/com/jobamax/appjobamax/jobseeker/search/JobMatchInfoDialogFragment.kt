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


class JobMatchInfoDialogFragment : DialogFragment() {
    lateinit var binding: FragmentJobMatchInfoDialogBinding

    private var topJobOffer: JobOffer? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentJobMatchInfoDialogBinding.inflate(inflater, container, false)
        configureUi()
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(R.style.DialogFragmentSlideAnim, R.style.DialogFragmentSlideAnim)
        topJobOffer = requireArguments().getSerializable("top_job_offer") as JobOffer
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
        topJobOffer?.let { offer ->
            offer.matches.apply {
                binding.sbEducation.progress = this.educationPer
                this.educations.forEach {
                    binding.cgEducationTags.addView(createChip(it.text))
                }
                binding.sbExperience.progress = this.experiencePer
                this.experiences.forEach {
                    binding.cgExperienceTags.addView(createChip(it.text))
                }
                binding.sbHardSkill.progress = this.hardSkillPer
                this.hardSkills.forEach {
                    binding.cgHardSkillTags.addView(createChip(it.text))
                }
                binding.sbSoftSkill.progress = this.softSkillPer
                this.softSkills.forEach {
                    binding.cgSoftSkillTags.addView(createChip(it.text))
                }
            }
        }
        binding.sbEducation.isEnabled = false
        binding.sbExperience.isEnabled = false
        binding.sbHardSkill.isEnabled = false
        binding.sbSoftSkill.isEnabled = false
    }

    private fun createChip(tag: String): View {
        val chip: View = layoutInflater.inflate(R.layout.item_chip_white_box_gradient_border, null, false)
        val tvContract = chip.findViewById<TextView>(R.id.tv_tag)
        val state = chip.findViewById<TextView>(R.id.tv_chip_state)
        tvContract.text = tag
        tvContract.background = resources.getDrawable(R.drawable.rounded_white_box_gradient_border_50, null)
        tvContract.updatePadding(20, 0,20,0)
        state.text = "0"
        tvContract.setTextColor(resources.getColor(R.color.navi_blue, null))
        return chip
    }

    private fun setClickListeners() {
        binding.ivClose.setOnClickListener { dismiss() }
    }

    companion object {
        fun newInstance(topJobOffer: JobOffer): JobMatchInfoDialogFragment {
            val fragment = JobMatchInfoDialogFragment()
            val args = Bundle()
            args.putSerializable("top_job_offer", topJobOffer)
            fragment.arguments = args
            return fragment
        }
    }

}