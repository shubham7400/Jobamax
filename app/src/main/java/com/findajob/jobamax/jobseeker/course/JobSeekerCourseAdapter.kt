package com.findajob.jobamax.jobseeker.course

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.findajob.jobamax.R
import com.findajob.jobamax.data.pojo.Courses
import com.findajob.jobamax.databinding.ItemTrainingCoursesBinding
import com.findajob.jobamax.util.AutoUpdatableAdapter
import kotlin.properties.Delegates

class JobSeekerCourseAdapter : RecyclerView.Adapter<JobSeekerCourseAdapter.Holder>(), AutoUpdatableAdapter {

    internal var collection: List<Courses> by Delegates.observable(emptyList()) { _, old, new ->
        autoNotify(old, new) { o, n -> o.id == n.id }
    }

    internal var clickListener: (Courses) -> Unit = { _ -> }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        Holder.from(parent, R.layout.item_training_courses)

    override fun getItemCount() = collection.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.binding.apply {
            item = collection[position]
//            itemCompanyIvIcon.setColorFilter(Color.rgb(123, 123, 123), android.graphics.PorterDuff.Mode.MULTIPLY)
            executePendingBindings()
//            itemHomeCvBg.setOnClickListener { clickListener(collection[position]) }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    class Holder(val binding: ItemTrainingCoursesBinding) : RecyclerView.ViewHolder(binding.root) {
        companion object {
            fun from(parent: ViewGroup, layout: Int): Holder {
                val inflater = LayoutInflater.from(parent.context)
                val binding = DataBindingUtil.inflate<ItemTrainingCoursesBinding>(inflater, layout, parent, false)
                return Holder(binding)
            }
        }
    }
}
