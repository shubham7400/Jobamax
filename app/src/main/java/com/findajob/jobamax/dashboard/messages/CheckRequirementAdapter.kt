package com.findajob.jobamax.dashboard.messages

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.findajob.jobamax.R
import com.findajob.jobamax.databinding.ItemRequirementCheckBinding
import com.findajob.jobamax.util.log

class CheckRequirementAdapter : RecyclerView.Adapter<CheckRequirementAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemRequirementCheckBinding) :
        RecyclerView.ViewHolder(binding.root)

    private val diffCallBack = object : DiffUtil.ItemCallback<String>() {
        override fun areItemsTheSame(oldItem: String, newItem: String) = oldItem == newItem

        override fun areContentsTheSame(oldItem: String, newItem: String) =
            oldItem.length == newItem.length

    }

    private val differ = AsyncListDiffer(this, diffCallBack)

    var checkedList = arrayListOf<String>()


    fun submitList(requirements: List<String>) = differ.submitList(requirements)

    fun submitCheckedList(checkedRequirements: List<String>) {

        log("adapter -> checked list $checkedRequirements")

        checkedList = try {
            checkedRequirements as ArrayList<String>
        } catch (e: Exception) {
            arrayListOf<String>()
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {


        val inflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<ItemRequirementCheckBinding>(
            inflater,
            R.layout.item_requirement_check,
            parent,
            false
        )

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.apply {
            val requirement = differ.currentList[position]
            val isCheckedItem = checkedList.contains(requirement)

            tvRequirementName.text = requirement
            cbRequirementCheck.isChecked = isCheckedItem

            cbRequirementCheck.setOnCheckedChangeListener { _, isChecked ->
                if (isChecked) checkedList.add(requirement) else checkedList.remove(requirement)
            }
        }

    }

    override fun getItemCount() = differ.currentList.size
}