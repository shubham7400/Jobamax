package com.findajob.jobamax.dashboard.home.training.online.courses.onlinecourse.instructor

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.findajob.jobamax.R
import com.findajob.jobamax.dashboard.home.training.online.courses.model.VisibleInstructor
import com.findajob.jobamax.databinding.ItemOnlineCourseInstructorBinding
import com.findajob.jobamax.util.AutoUpdatableAdapter
import kotlin.properties.Delegates


class InstructorsAdapter() : RecyclerView.Adapter<InstructorsAdapter.Holder>(), AutoUpdatableAdapter {

    internal var collection: List<VisibleInstructor> by Delegates.observable(emptyList()) { prop, old, new ->
        autoNotify(old, new) { o, n -> o.display_name == n.display_name }
    }

    override fun getItemCount(): Int = collection.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder = Holder.from(
            parent,
            R.layout.item_online_course_instructor
    )

    internal var clickListener: (VisibleInstructor) -> Unit = { _ -> }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.binding.apply {
            item = collection[position]
            executePendingBindings()
            itemInstructorCvBg.setOnClickListener { clickListener(collection[position]) }
        }

    }


    class Holder(val binding: ItemOnlineCourseInstructorBinding) : RecyclerView.ViewHolder(binding.root) {

        companion object {
            fun from(parent: ViewGroup, layout: Int): Holder {
                val inflater = LayoutInflater.from(parent.context)
                val binding = DataBindingUtil.inflate<ItemOnlineCourseInstructorBinding>(
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

}

