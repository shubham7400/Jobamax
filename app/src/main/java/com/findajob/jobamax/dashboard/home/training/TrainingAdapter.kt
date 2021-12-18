package com.findajob.jobamax.dashboard.home.training

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.findajob.jobamax.data.pojo.Courses
import com.findajob.jobamax.databinding.ItemTrainingCoursesBinding
import com.findajob.jobamax.util.AutoUpdatableAdapter
import kotlin.properties.Delegates

class TrainingAdapter : RecyclerView.Adapter<TrainingAdapter.Holder>(), AutoUpdatableAdapter {

    internal var collection: List<Courses> by Delegates.observable(emptyList()) { prop, old, new ->
        autoNotify(old, new) { o, n -> o.id == n.id }
    }

    internal var clickListener: (Courses) -> Unit = { _ -> }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        Holder.from(parent)

    override fun getItemCount() = collection.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.binding.apply {
            item = collection[position]
            executePendingBindings()
            itemHomeClBg.setOnClickListener { clickListener(collection[position]) }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    class Holder(val binding: ItemTrainingCoursesBinding) : RecyclerView.ViewHolder(binding.root) {
        companion object {
            fun from(parent: ViewGroup): Holder {
                val inflater = LayoutInflater.from(parent.context)
                val binding = ItemTrainingCoursesBinding.inflate(inflater, parent, false)
                return Holder(binding)
            }
        }
    }
}
