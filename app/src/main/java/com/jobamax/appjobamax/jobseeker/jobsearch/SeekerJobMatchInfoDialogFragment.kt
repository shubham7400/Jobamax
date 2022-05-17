package com.jobamax.appjobamax.jobseeker.jobsearch

import android.app.Dialog
import android.content.Context
import android.graphics.drawable.GradientDrawable
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.SeekBar
import androidx.annotation.RequiresApi
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.RecyclerView
import com.jobamax.appjobamax.R
import com.jobamax.appjobamax.databinding.FragmentSeekerJobMatchInfoDialogBinding
import com.jobamax.appjobamax.databinding.ItemCheapBinding
import com.jobamax.appjobamax.model.NewJobOffer
import com.jobamax.appjobamax.util.PROFILE_PIC_URL
import com.jobamax.appjobamax.util.loadImageFromUrl


class SeekerJobMatchInfoDialogFragment : DialogFragment() {
    lateinit var binding: FragmentSeekerJobMatchInfoDialogBinding

    private var topJobOffer: NewJobOffer? = null
    private var profilePicUrl = ""
    var onProfileClick: () -> Unit = {}


    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentSeekerJobMatchInfoDialogBinding.inflate(inflater, container, false)
        configureUi()
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        topJobOffer = requireArguments().getSerializable("top_job_offer") as NewJobOffer
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun setData() {
        topJobOffer?.matchesPercentage?.let {
            binding.circularProgress.setProgress(it.toDouble(), 100.0)
        }
        topJobOffer?.subMatches?.educationPer?.let { progress ->
            binding.sbEducation.progress = progress
            binding.sbEducation.isEnabled = false
            binding.tvEducationPer.text = "$progress%"
            setColor(binding.sbEducation, progress, topJobOffer?.subMatches?.missingEducations, 1)
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
            setColor(binding.sbHardSkill, progress, topJobOffer?.subMatches?.missingHardSkills, 2)
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
            setColor(binding.sbSoftSkill, progress, topJobOffer?.subMatches?.missingSoftSkills, 3)
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
            setColor(binding.sbJobTitle, progress, topJobOffer?.subMatches?.missingJobTitles, 4)
            val isMissingTagsAvailable = topJobOffer?.subMatches?.missingJobTitles?.isNotEmpty() ?: false
            if (isMissingTagsAvailable){
                binding.tvJobTitleMissingTag.visibility = View.VISIBLE
            }else{
                binding.tvJobTitleMissingTag.visibility = View.GONE
            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun setColor(seekBar: SeekBar, progress: Int, missingTags: ArrayList<String>?, type: Int) {
        when(progress){
            in 0..20 -> {
                seekBar.progressDrawable = ResourcesCompat.getDrawable(resources ,R.drawable.seek_style_red, null)
                setChips(missingTags,resources.getColor(R.color.red, null), type)
            }
            in 21..49 -> {
                seekBar.progressDrawable = ResourcesCompat.getDrawable(resources ,R.drawable.seek_style_orange, null)
                setChips(missingTags, resources.getColor(R.color.orange, null), type)
             }
            in 50..61 -> {
                seekBar.progressDrawable =  ResourcesCompat.getDrawable(resources ,R.drawable.seek_style_yellow, null)
                setChips(missingTags,  resources.getColor(R.color.yellow, null), type)
             }
            in 62..79 -> {
                seekBar.progressDrawable = ResourcesCompat.getDrawable(resources ,R.drawable.seek_style_dark_green, null)
                setChips(missingTags,  resources.getColor(R.color.dark_green, null), type)
            }
            in 80..100 -> {
                seekBar.progressDrawable = ResourcesCompat.getDrawable(resources ,R.drawable.seek_style_green, null)
                setChips(missingTags,  resources.getColor(R.color.green, null), type)
             }
        }
    }

    private fun setChips(missingTags: ArrayList<String>?, colorId: Int, type: Int) {
        when(type){
            1 -> {
                binding.rvEducationMissingTag.adapter = missingTags?.let {
                    EducationMissingTagAdapter(it, colorId, requireContext())
                }
            }
            2 -> {
                binding.rvHardSkillMissingTag.adapter = missingTags?.let {
                    HardSkillMissingTagAdapter(it, colorId, requireContext())
                }
            }
            3 -> {
                binding.rvSoftSkillMissingTag.adapter = missingTags?.let {
                    SoftSkillMissingTagAdapter(it, colorId, requireContext())
                }
            }
            4 -> {
                binding.rvJobTitleMissingTag.adapter = missingTags?.let {
                    JobTitleMissingTagAdapter(it, colorId, requireContext())
                }
            }
        }
    }


    @RequiresApi(Build.VERSION_CODES.M)
    private fun configureUi() {
        profilePicUrl = requireArguments().getString(PROFILE_PIC_URL, "")
        setClickListeners()
        topJobOffer?.let {
            setData()
            setPercentageChartViewColor()
        }
        loadImageFromUrl(binding.civUser, profilePicUrl, R.drawable.default_user_img)
    }

    private fun setClickListeners() {
        binding.ivBackButton.setOnClickListener {
            dismiss()
        }
        binding.civUser.setOnClickListener {
            onProfileClick()
        }
    }

    private fun setPercentageChartViewColor() {
         when(topJobOffer?.matchesPercentage){
             in 0..20 -> {
                binding.circularProgress.progressColor = resources.getColor(R.color.red)
             }
             in 21..49 -> {
                 binding.circularProgress.progressColor = resources.getColor(R.color.orange)
             }
             in 50..61 -> {
                 binding.circularProgress.progressColor = resources.getColor(R.color.yellow)
             }
             in 62..79 -> {
                 binding.circularProgress.progressColor = resources.getColor(R.color.dark_green)
             }
             in 80..100 -> {
                 binding.circularProgress.progressColor = resources.getColor(R.color.green)
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
        fun newInstance(topJobOffer: NewJobOffer, profilePicUrl: String): SeekerJobMatchInfoDialogFragment {
            val fragment = SeekerJobMatchInfoDialogFragment()
            val args = Bundle()
            args.putSerializable("top_job_offer", topJobOffer)
            args.putString(PROFILE_PIC_URL, profilePicUrl)
            fragment.arguments = args
            return fragment
        }
    }


}

class EducationMissingTagAdapter(
    var list: ArrayList<String>,
    private val colorId: Int,
    val requireContext: Context
) : RecyclerView.Adapter<EducationMissingTagAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(ItemCheapBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.binding.apply {
            this.tvTag.text = item
            this.clTopParent.background = createDrawable(colorId)
        }
    }
    override fun getItemCount(): Int = list.size
    class ViewHolder(val binding: ItemCheapBinding) : RecyclerView.ViewHolder(binding.root)
}

class HardSkillMissingTagAdapter(
    var list: ArrayList<String>,
    private val colorId: Int,
    val requireContext: Context
) : RecyclerView.Adapter<HardSkillMissingTagAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(ItemCheapBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.binding.apply {
            this.tvTag.text = item
            this.clTopParent.background =  createDrawable(colorId)
        }
    }
    override fun getItemCount(): Int = list.size
    class ViewHolder(val binding: ItemCheapBinding) : RecyclerView.ViewHolder(binding.root)
}

class SoftSkillMissingTagAdapter(
    var list: ArrayList<String>,
    private val colorId: Int,
    val requireContext: Context
) : RecyclerView.Adapter<SoftSkillMissingTagAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(ItemCheapBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.binding.apply {
            this.tvTag.text = item
            this.clTopParent.background =  createDrawable(colorId)
        }
    }
    override fun getItemCount(): Int = list.size
    class ViewHolder(val binding: ItemCheapBinding) : RecyclerView.ViewHolder(binding.root)
}

class JobTitleMissingTagAdapter(
    var list: ArrayList<String>,
    private val colorId: Int,
    val requireContext: Context
) : RecyclerView.Adapter<JobTitleMissingTagAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(ItemCheapBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.binding.apply {
            this.tvTag.text = item
            this.clTopParent.background =  createDrawable(colorId)
        }
    }
    override fun getItemCount(): Int = list.size
    class ViewHolder(val binding: ItemCheapBinding) : RecyclerView.ViewHolder(binding.root)
}

fun createDrawable(backgroundColor: Int): GradientDrawable {
    val shape = GradientDrawable()
    shape.shape = GradientDrawable.RECTANGLE
    shape.cornerRadii = floatArrayOf(8f, 8f, 8f, 8f, 8f, 8f, 8f, 8f)
    shape.setColor(backgroundColor)
    return shape
}