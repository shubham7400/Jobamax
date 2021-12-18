package com.findajob.jobamax.dashboard.home.training.online.courses.onlinecourse.syllabus

import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.findajob.jobamax.R
import com.findajob.jobamax.dashboard.home.training.online.courses.model.syllabus.Syllabus
import com.findajob.jobamax.databinding.ItemOnlineCourseSyllabusBinding


class SyllabusAdapter : PagingDataAdapter<Syllabus, SyllabusAdapter.Holder>(DiffCallback) {


    internal var clickListener: (Syllabus) -> Unit = { _ -> }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            = Holder.from(
            parent,
            R.layout.item_online_course_syllabus
    )


    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.binding.apply {
            item = getItem(position)
            executePendingBindings()

            itemSyllabusClBg.setOnClickListener { getItem(position)?.let { it1 -> clickListener(it1) } }

            getItem(position)?.let {item ->

                if(!(item.description.isNullOrBlank())){
                    syllabusAssetArrow.visibility = View.VISIBLE
                    syllabusAssetArrow.setOnClickListener{
                        if(chapterDescriptionTv.visibility != View.VISIBLE){
                            chapterDescriptionTv.visibility = View.VISIBLE
                            syllabusAssetArrow.setImageResource(R.drawable.ic_arrow_up)
                        }else{
                            chapterDescriptionTv.visibility = View.GONE
                            syllabusAssetArrow.setImageResource(R.drawable.ic_arrow_down)
                        }
                    }
                }

                if(item._class.equals("lecture")){
                    if(item.asset.asset_type.equals("Article")) {
                        syllabusAssetIcon.setImageResource(R.drawable.ic_article)
                    }

                    syllabusAssetIcon.visibility = View.VISIBLE
                    chapterTitleTv.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16F)
                    seperator.visibility = View.GONE

                }else{
                    syllabusAssetIcon.visibility = View.GONE
                    chapterTitleTv.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20F)
                    seperator.visibility = View.VISIBLE

                }

            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    class Holder(val binding: ItemOnlineCourseSyllabusBinding) : RecyclerView.ViewHolder(binding.root) {

        companion object{
            fun from(parent: ViewGroup, layout: Int): Holder {
                val inflater = LayoutInflater.from(parent.context)
                val binding = DataBindingUtil.inflate<ItemOnlineCourseSyllabusBinding>(
                        inflater,
                        layout,
                        parent,
                        false
                )
                return Holder(
                        binding
                )
            }
        }

    }



    companion object DiffCallback : DiffUtil.ItemCallback<Syllabus>() {
        override fun areItemsTheSame(oldItem: Syllabus, newItem: Syllabus): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Syllabus, newItem: Syllabus): Boolean {
            return oldItem.id == newItem.id
        }
    }

}

