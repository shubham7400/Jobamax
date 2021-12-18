package com.findajob.jobamax.dashboard.messages

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.findajob.jobamax.R
import com.findajob.jobamax.data.pojo.Message
import com.findajob.jobamax.databinding.ItemArchivedMessagesBinding
import com.findajob.jobamax.databinding.ItemMessagesBinding
import com.findajob.jobamax.util.log
import com.daimajia.swipe.SwipeLayout
import com.parse.ParseObject
import org.jetbrains.anko.imageResource
import javax.inject.Inject

class ArchivedMessageAdapter @Inject constructor() :
    RecyclerView.Adapter<ArchivedMessageAdapter.Holder>(), Filterable {

    var currentUserId: String = ""

    private val diffCallBack = object : DiffUtil.ItemCallback<Message>() {
        override fun areItemsTheSame(oldItem: Message, newItem: Message) =
            oldItem.objectId == newItem.objectId

        override fun areContentsTheSame(oldItem: Message, newItem: Message) =
            oldItem.seenBy == newItem.seenBy && oldItem.message?.objectId == newItem.message?.objectId
    }

    private val differ = AsyncListDiffer(this, diffCallBack)

    fun submitList(messageList: List<Message>) {
        differ.submitList(messageList)
    }

    fun removeAnItem(message: Message) {
        try {
            val changedList = differ.currentList
            changedList.remove(message)
            differ.submitList(changedList)

            val changedFilteredList = filterCollection as ArrayList
            changedFilteredList.remove(message)
            filterCollection = changedFilteredList

        } catch (e: Exception) {
            log("remoteAnItem: could not remove the item", e)
        }
    }

    fun getCurrentList(): List<Message> = differ.currentList

    lateinit var context: Context

    internal var filterCollection: List<Message> = differ.currentList

    internal var clickListener: (Message) -> Unit = { _ -> }

    internal var unarchiveButtonListener: (Message) -> Boolean = { _ -> true }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {

        context = parent.context

        return Holder.from(
            parent,
            R.layout.item_archived_messages
        )
    }

    override fun getItemCount() = filterCollection.size

    override fun onBindViewHolder(holder: Holder, position: Int) {

        val message = filterCollection[position]

        var name = ""

        val firstName = try {
            message.receiverId.fetchIfNeeded<ParseObject>().getString("firstName") ?: ""
        } catch (e: Exception) {
            log("could not get the first name of the receiver ${e.message}")
            ""
        }
        val lastName = try {
            message.receiverId.fetchIfNeeded<ParseObject>().getString("lastName") ?: ""
        } catch (e: Exception) {
            log("could not get the second name of the receiver ${e.message}")
            ""
        }

        name = "$firstName $lastName"

        if (name.trim().isEmpty()) {
            name = try {
                message.receiverId.getString("username") ?: "Unknown"
            } catch (e: Exception) {
                log("could not get the username of the receiver ${e.message}", e)
                ""
            }
        }


        holder.binding.apply {
            item = message
            recieverName = name


            if (message.seenBy.contains(currentUserId)) {
                ivSeenIndicator.visibility = View.GONE
            }

            executePendingBindings()

            message.also { messageItem ->


                slMessageSwipe.addDrag(
                    SwipeLayout.DragEdge.Left,
                    slMessageSwipe.findViewById(R.id.bottom_wrapper1)
                )


                // shortlist a message
                ivUnarchive.setOnClickListener {
                    slMessageSwipe.close(true)
                    unarchiveButtonListener(messageItem)
                }


                // go to message
                clMessageBody.setOnClickListener {
                    slMessageSwipe.close(true)
                    clickListener(messageItem)
                }
            }

        }
    }

    override fun getItemViewType(position: Int) = position

    class Holder(val binding: ItemArchivedMessagesBinding) : RecyclerView.ViewHolder(binding.root) {
        companion object {
            fun from(parent: ViewGroup, layout: Int): Holder {
                val inflater = LayoutInflater.from(parent.context)
                val binding = DataBindingUtil.inflate<ItemArchivedMessagesBinding>(
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

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val charSearch = constraint.toString()

                if (charSearch.isEmpty()) {
                    if (differ.currentList.isNotEmpty()) {
                        try {
                            // empty list can't be converted to arraylist
                            filterCollection = differ.currentList as ArrayList<Message>
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
                    val resultList = ArrayList<Message>()
                    for (row in differ.currentList) {
                        val userName =
                            row.getParseObject("senderId")?.get("username").toString()
                        if (userName.toLowerCase()
                                .contains(constraint.toString().toLowerCase())
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
                    filterCollection = results?.values as ArrayList<Message>
                    notifyDataSetChanged()
                } catch (e: ClassCastException) {
                    filterCollection = results?.values as List<Message>
                    notifyDataSetChanged()
                } catch (e: Exception) {
                    log("Could not convert")
                }
            }
        }
    }

}
