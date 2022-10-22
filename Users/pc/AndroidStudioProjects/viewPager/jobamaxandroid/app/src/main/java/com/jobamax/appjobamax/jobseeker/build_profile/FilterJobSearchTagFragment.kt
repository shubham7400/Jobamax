package com.jobamax.appjobamax.jobseeker.build_profile

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewAnimationUtils
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.core.view.updatePadding
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.chip.ChipGroup
import com.google.gson.Gson
import com.jobamax.appjobamax.R
import com.jobamax.appjobamax.base.BaseFragment
import com.jobamax.appjobamax.databinding.FragmentFilterJobSearchTagBinding
import com.jobamax.appjobamax.databinding.ItemJobCriteriaCategoryBinding
import com.jobamax.appjobamax.enums.ParseTableFields
import com.jobamax.appjobamax.extensions.toast
import com.jobamax.appjobamax.jobseeker.profile.SeekerCreateCvActivity
import com.jobamax.appjobamax.jobseeker.search.ManualAndPersonalizeActivity
import com.jobamax.appjobamax.jobseeker.view_model.SeekerHomeViewModel
import com.jobamax.appjobamax.model.CriteriaCategory
import com.jobamax.appjobamax.model.JobSeeker
import com.jobamax.appjobamax.model.ManualCriteria
 import kotlin.math.max


class FilterJobSearchTagFragment : BaseFragment() {
    lateinit var binding: FragmentFilterJobSearchTagBinding

    lateinit var jobSeeker: JobSeeker
    val viewModel: SeekerHomeViewModel by activityViewModels()

    lateinit var manualCriteria: ManualCriteria
    var jobSearchKeywords = ArrayList<String>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentFilterJobSearchTagBinding.inflate(inflater, container, false)
        configureUi()
        return binding.root
    }

    private fun configureUi() {
        setClickListeners()
        initializeJobSeeker()
        setData()
    }

    private fun setData() {
        manualCriteria = jobSeeker.manualCriteria!!
        jobSearchKeywords.clear()
        manualCriteria.jobSearchKeywords.forEach { jobSearchKeywords.add(it) }
        configureCriteriaCategories()
    }

    private fun setClickListeners() {
        binding.btnSave.setOnClickListener {
            manualCriteria.jobSearchKeywords.clear()
            jobSearchKeywords.forEach { manualCriteria.jobSearchKeywords.add(it) }
            viewModel.jobSeekerObject?.put(ParseTableFields.MANUAL_CRITERIA.value, gson.toJson(manualCriteria))
            viewModel.jobSeekerObject?.saveInBackground { exception ->
                if (exception == null) {
                    requireActivity().onBackPressed()
                }else{
                    toast(exception.message.toString())
                }
            }
        }
        binding.ivDismiss.setOnClickListener { requireActivity().onBackPressed() }
    }

    private fun configureCriteriaCategories() {
        val adapter = FilterJobSearchTagAdapter(CriteriaCategory.getCriteriaCategory(), requireActivity(), jobSearchKeywords)
        binding.rvJobFilterTags.adapter = adapter
        adapter.onTagClick = { tag ->
            if (jobSearchKeywords.contains(tag)){
                jobSearchKeywords.remove(tag)
            }else{
                jobSearchKeywords.add(tag)
            }
            adapter.submitAddedTags(jobSearchKeywords)
            true
        }
    }

    private fun initializeJobSeeker() {
        jobSeeker = viewModel.jobSeeker
        if (viewModel.jobSeekerObject == null) {
            try {
                (requireActivity() as SeekerCreateCvActivity).getJobSeeker {
                    if (it) {
                        jobSeeker = viewModel.jobSeeker
                    }
                }
            }catch (e: Exception){
                (requireActivity() as ManualAndPersonalizeActivity).getJobSeeker {
                    if (it) {
                        jobSeeker = viewModel.jobSeeker
                    }
                }
            }
        }
    }

}

class FilterJobSearchTagAdapter(val list: ArrayList<CriteriaCategory>, val requireActivity: FragmentActivity, var jobSearchKeywords: ArrayList<String>) : RecyclerView.Adapter<FilterJobSearchTagAdapter.ViewHolder>() {
    var onTagClick: (String) -> Boolean = { true }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(ItemJobCriteriaCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
         val item = list[position]
        holder.binding.apply {
            this.tvCategoryTitle.text = item.title
            this.cgCategoryTags.removeAllViews()
            var isRedDotVisible = false
            item.tags.forEach { tag ->
                val isContain = jobSearchKeywords.contains(tag)
                if (isContain && !isRedDotVisible){
                    this.cvSelectedCategoryTagHint.visibility = View.VISIBLE
                    isRedDotVisible = true
                }
                this.cgCategoryTags.addView(createChip(tag, isContain){
                    var hasAnyCategoryTagSelected = false
                    kotlin.run breaking@ {
                        item.tags.forEach {
                            if (jobSearchKeywords.contains(it)) {
                                this.cvSelectedCategoryTagHint.visibility = View.VISIBLE
                                hasAnyCategoryTagSelected = true
                                return@breaking
                            }
                        }
                    }
                    if (!hasAnyCategoryTagSelected){
                        this.cvSelectedCategoryTagHint.visibility = View.GONE
                    }
                })
            }

            this.clCategory.setOnClickListener {
                if (this.cgCategoryTags.isVisible){
                    viewHideAnimation(this.cgCategoryTags, this.ivArrow)
                }else{
                    showViewAnimation(this.cgCategoryTags, this.ivArrow)
                }
            }
        }
    }
    override fun getItemCount(): Int = list.size
    class ViewHolder(val binding: ItemJobCriteriaCategoryBinding) : RecyclerView.ViewHolder(binding.root)

    private fun createChip(tag: String, isSelected: Boolean, onTagStateChange: () -> Unit): View {
        val chip: View = requireActivity.layoutInflater.inflate(R.layout.item_chip_white_box_gradient_border, null, false)
        val tvContract = chip.findViewById<TextView>(R.id.tv_tag)
        val state = chip.findViewById<TextView>(R.id.tv_chip_state)
        tvContract.text = tag
        if (isSelected){
            tvContract.background = requireActivity.resources.getDrawable(R.drawable.rounded_bottom_purple_top_blue_50, null)
            tvContract.updatePadding(20, 0,20,0)
            state.text = "1"
            tvContract.setTextColor(requireActivity.resources.getColor(R.color.white, null))
        }else{
            tvContract.background = requireActivity.resources.getDrawable(R.drawable.rounded_white_box_gradient_border_50, null)
            tvContract.updatePadding(20, 0,20,0)
            state.text = "0"
            tvContract.setTextColor(requireActivity.resources.getColor(R.color.navi_blue, null))
        }
        tvContract.setOnClickListener {
           if(onTagClick(tag)){
               if (jobSearchKeywords.contains(tag)){
                   tvContract.background = requireActivity.resources.getDrawable(R.drawable.rounded_bottom_purple_top_blue_50, null)
                   tvContract.updatePadding(20, 0,20,0)
                   state.text = "1"
                   tvContract.setTextColor(requireActivity.resources.getColor(R.color.white, null))
               }else{
                   tvContract.background = requireActivity.resources.getDrawable(R.drawable.rounded_white_box_gradient_border_50, null)
                   tvContract.updatePadding(20, 0,20,0)
                   state.text = "0"
                   tvContract.setTextColor(requireActivity.resources.getColor(R.color.navi_blue, null))
               }
           }
            onTagStateChange()
        }
        return chip
    }

    private fun showViewAnimation(cgContractType: ChipGroup, iv: ImageView) {
        val finalRadius = max(cgContractType.width, cgContractType.height)
        val anim = ViewAnimationUtils.createCircularReveal(cgContractType, 0, 0, 0f, finalRadius.toFloat())
        cgContractType.visibility = View.VISIBLE
        iv.setImageResource(R.drawable.ic_arrow_up_navi_blue)
        anim.start()
    }

    private fun viewHideAnimation(cgContractType: ChipGroup, iv: ImageView) {
        val anim = ViewAnimationUtils.createCircularReveal(cgContractType, 0, 0, cgContractType.width.toFloat(), 0f)
        anim.addListener(object : AnimatorListenerAdapter() {
            override fun onAnimationEnd(animation: Animator) {
                super.onAnimationEnd(animation)
                cgContractType.visibility = View.GONE
                iv.setImageResource(R.drawable.ic_arrow_down_navi_blue)
            }
        })
        anim.start()
    }

    fun submitAddedTags(tags: ArrayList<String>) {
        jobSearchKeywords = tags
    }
}