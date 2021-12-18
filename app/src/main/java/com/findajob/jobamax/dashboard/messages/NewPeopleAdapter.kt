package com.findajob.jobamax.dashboard.messages

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.findajob.jobamax.R
import com.findajob.jobamax.data.pojo.Message
import com.findajob.jobamax.data.pojo.NewPeople
import com.findajob.jobamax.databinding.ListItemNewPeopleBinding
import com.findajob.jobamax.util.log
import java.util.*
import javax.inject.Inject
import kotlin.collections.ArrayList

class NewPeopleAdapter @Inject constructor() :
    RecyclerView.Adapter<NewPeopleAdapter.NewPeopleViewHolder>(), Filterable {

    private val diffCallBack = object : DiffUtil.ItemCallback<NewPeople>() {
        override fun areItemsTheSame(oi: NewPeople, ni: NewPeople) = oi.objectId == ni.objectId

        override fun areContentsTheSame(oldItem: NewPeople, newItem: NewPeople) =
            oldItem.profilePicUrl == newItem.profilePicUrl

    }

    private val differ = AsyncListDiffer(this, diffCallBack)

    internal var filterCollection: List<NewPeople> = differ.currentList

    fun submitList(people: List<NewPeople>) {
        differ.submitList(people)
    }

    internal var clickListener: (NewPeople) -> Unit = { _ -> }

    override fun getItemCount() = filterCollection.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        NewPeopleViewHolder.from(
            parent,
            R.layout.list_item_new_people
        )

    override fun onBindViewHolder(holder: NewPeopleViewHolder, position: Int) {
        val people = filterCollection[position]
        holder.binding.apply {
            item = people
            executePendingBindings()
            clNewPeople.setOnClickListener { clickListener(people) }
        }
    }

    override fun getItemViewType(position: Int) = position


    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val charSearch = constraint.toString()

                if (charSearch.isEmpty()) {
                    if (differ.currentList.isNotEmpty()) {
                        try {
                            // empty list can't be converted to arraylist
                            filterCollection = differ.currentList as ArrayList<NewPeople>
                            log("Casting as an array ")
                        } catch (e: ClassCastException) {
                            filterCollection = differ.currentList
                            log("Casting as a list " + e.message)
                        } catch (e: Exception) {
                            log(
                                "Could not be casted " + e.message
                            )
                        }

                    } else {
                        filterCollection = arrayListOf()
                    }
                } else {
                    val resultList = ArrayList<NewPeople>()
                    for (row in differ.currentList) {
                        val userName = row.name + row.lastName
                        if (userName.toLowerCase(Locale.ROOT)
                                .contains(constraint.toString().toLowerCase(Locale.ROOT))
                        ) {
                            resultList.add(row)
                        }
                    }
                    filterCollection = resultList
                }
                val filterResults = FilterResults()
                filterResults.values = filterCollection
                return filterResults
            }

            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                try {
                    filterCollection = results?.values as ArrayList<NewPeople>
                    notifyDataSetChanged()
                } catch (e: ClassCastException) {
                    filterCollection = results?.values as List<NewPeople>
                    notifyDataSetChanged()
                } catch (e: Exception) {
                    log("Could not convert")
                }
            }
        }
    }

    class NewPeopleViewHolder(val binding: ListItemNewPeopleBinding) :
        RecyclerView.ViewHolder(binding.root) {
        companion object {
            fun from(parent: ViewGroup, layout: Int): NewPeopleViewHolder {
                val inflater = LayoutInflater.from(parent.context)
                val binding = DataBindingUtil.inflate<ListItemNewPeopleBinding>(
                    inflater,
                    layout,
                    parent,
                    false
                )
                return NewPeopleViewHolder(
                    binding
                )
            }
        }
    }


}