package com.findajob.jobamax.jobseeker.jobsearch

import android.app.Dialog
import android.os.Bundle
import android.view.*
import android.widget.SeekBar
import androidx.core.content.res.ResourcesCompat
import androidx.core.content.res.ResourcesCompat.getColorStateList
import androidx.fragment.app.DialogFragment
import com.findajob.jobamax.R
import com.findajob.jobamax.databinding.FragmentSeekerJobMatchInfoDialogBinding
import com.findajob.jobamax.model.NewJobOffer
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup


class SeekerJobMatchInfoDialogFragment : DialogFragment() {
    lateinit var binding: FragmentSeekerJobMatchInfoDialogBinding

    private var topJobOffer: NewJobOffer? = null


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentSeekerJobMatchInfoDialogBinding.inflate(inflater, container, false)
        configureUi()
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        topJobOffer = requireArguments().getSerializable("top_job_offer") as NewJobOffer
    }

    private fun setData() {
        topJobOffer?.matchesPercentage?.let {
            binding.pcvMatch.setProgress(it.toFloat(), true)
        }
        topJobOffer?.subMatches?.educationPer?.let { progress ->
            binding.sbEducation.progress = progress
            binding.sbEducation.isEnabled = false
            binding.tvEducationPer.text = "$progress%"
            setColor(binding.sbEducation,  binding.cgEducation, progress, topJobOffer?.subMatches?.missingEducations)
            val isMissingTagsAvailable = topJobOffer?.subMatches?.missingEducations?.isNotEmpty() ?: false
            if (isMissingTagsAvailable){
                binding.tvEducationMissingTag.visibility = View.VISIBLE
            }else{
                binding.tvEducationMissingTag.visibility = View.GONE
            }
        }

        topJobOffer?.subMatches?.hardSkillPer?.let { progress ->
            binding.sbHardSkill.progress = progress
            binding.sbHardSkill.isEnabled = false
            binding.tvHardSkillPer.text = "$progress%"
            setColor(binding.sbHardSkill, binding.cgHardSkill, progress, topJobOffer?.subMatches?.missingHardSkills)
            val isMissingTagsAvailable = topJobOffer?.subMatches?.missingHardSkills?.isNotEmpty() ?: false
            if (isMissingTagsAvailable){
                binding.tvHardSkillMissingTag.visibility = View.VISIBLE
            }else{
                binding.tvHardSkillMissingTag.visibility = View.GONE
            }
        }

        topJobOffer?.subMatches?.softSkillPer?.let { progress ->
            binding.sbSoftSkill.progress = progress
            binding.sbSoftSkill.isEnabled = false
            binding.tvSoftSkillPer.text = "$progress%"
            setColor(binding.sbSoftSkill, binding.cgSoftSkill, progress, topJobOffer?.subMatches?.missingSoftSkills)
            val isMissingTagsAvailable = topJobOffer?.subMatches?.missingSoftSkills?.isNotEmpty() ?: false
            if (isMissingTagsAvailable){
                binding.tvSoftSkillMissingTag.visibility = View.VISIBLE
            }else{
                binding.tvSoftSkillMissingTag.visibility = View.GONE
            }
        }

        topJobOffer?.subMatches?.jobTitlePer?.let { progress ->
            binding.sbJobTitle.progress = progress
            binding.sbJobTitle.isEnabled = false
            binding.tvJobTitlePer.text = "$progress%"
            setColor(binding.sbJobTitle, binding.cgJobTitle, progress, topJobOffer?.subMatches?.missingJobTitles)
            val isMissingTagsAvailable = topJobOffer?.subMatches?.missingJobTitles?.isNotEmpty() ?: false
            if (isMissingTagsAvailable){
                binding.tvJobTitleMissingTag.visibility = View.VISIBLE
            }else{
                binding.tvJobTitleMissingTag.visibility = View.GONE
            }
        }
    }

    private fun setColor(seekBar: SeekBar, chipGroup: ChipGroup, progress: Int, missingTags: ArrayList<String>?) {
        when(progress){
            in 0..20 -> {
                seekBar.progressDrawable = ResourcesCompat.getDrawable(resources ,R.drawable.seek_style_red, null)
                setChips(missingTags, chipGroup, R.color.red)
            }
            in 21..49 -> {
                seekBar.progressDrawable = ResourcesCompat.getDrawable(resources ,R.drawable.seek_style_orange, null)
                setChips(missingTags, chipGroup, R.color.orange)
             }
            in 50..61 -> {
                seekBar.progressDrawable =  ResourcesCompat.getDrawable(resources ,R.drawable.seek_style_yellow, null)
                setChips(missingTags, chipGroup, R.color.yellow)
             }
            in 62..79 -> {
                seekBar.progressDrawable = ResourcesCompat.getDrawable(resources ,R.drawable.seek_style_dark_green, null)
                setChips(missingTags, chipGroup, R.color.dark_green)
            }
            in 80..100 -> {
                seekBar.progressDrawable = ResourcesCompat.getDrawable(resources ,R.drawable.seek_style_green, null)
                setChips(missingTags, chipGroup, R.color.green)
             }
        }
    }

    private fun setChips(list: ArrayList<String>?, chipGroup: ChipGroup, color: Int) {
        list?.forEach {
            val chip = layoutInflater.inflate(R.layout.item_custom_chip, chipGroup, false) as Chip
            chip.text = it
            chip.chipBackgroundColor = getColorStateList(resources, color, null )
            chip.setCloseIconTintResource(R.color.white)
            chip.isCloseIconVisible = false
            chipGroup.addView(chip)
        }
    }

    private fun configureUi() {
        setClickListeners()
        topJobOffer?.let {
            setData()
            setPercentageChartViewColor()
        }
    }

    private fun setClickListeners() {
        binding.ivBackButton.setOnClickListener {
            dismiss()
        }
    }

    private fun setPercentageChartViewColor() {
         when(topJobOffer?.matchesPercentage){
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


    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog: Dialog = super.onCreateDialog(savedInstanceState)
        dialog.window?.requestFeature(Window.FEATURE_NO_TITLE)
        return dialog
    }

    override fun onStart() {
        super.onStart()
        val dialog: Dialog? = dialog
        if (dialog != null) {
            dialog.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        }
    }

    companion object {
        fun newInstance(topJobOffer: NewJobOffer): SeekerJobMatchInfoDialogFragment {
            val fragment = SeekerJobMatchInfoDialogFragment()
            val args = Bundle()
            args.putSerializable("top_job_offer", topJobOffer)
            fragment.arguments = args
            return fragment
        }
    }


}