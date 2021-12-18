package com.findajob.jobamax.dashboard.messages

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.findajob.jobamax.R
import com.findajob.jobamax.data.pojo.Chat
import com.findajob.jobamax.databinding.ItemChatReceiverBinding
import com.findajob.jobamax.databinding.ItemChatSenderBinding
import com.parse.ParseUser
import javax.inject.Inject


class ChatAdapter @Inject constructor() :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        const val TYPE_SENDER = 1
        const val TYPE_RECEIVER = 2
    }

    internal var clickListener: (Chat) -> Unit = { _ -> }

    var profileImageUrl: String = ""


    private val diffCallBack = object : DiffUtil.ItemCallback<Chat>() {
        override fun areItemsTheSame(oldItem: Chat, newItem: Chat) = oldItem == newItem

        override fun areContentsTheSame(oldItem: Chat, newItem: Chat) =
            oldItem.message == newItem.message && oldItem.seen == newItem.seen
                    && oldItem.file == newItem.file
    }

    private val differ = AsyncListDiffer(this, diffCallBack)

    fun submitList(chats: List<Chat>) {
        differ.submitList(chats)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return when (viewType) {
            TYPE_SENDER -> {
                SenderViewHolder.from(
                    parent,
                    R.layout.item_chat_sender
                )
            }
            else -> {
                ReceiverViewHolder.from(
                    parent,
                    R.layout.item_chat_receiver
                )
            }
        }
    }

    override fun getItemCount() = differ.currentList.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        val chat = differ.currentList[position]


        when (holder) {
            is SenderViewHolder -> {
                holder.binding.apply {
                    item = chat
                    senderProfilePic = profileImageUrl
                    executePendingBindings()
                    itemSenderImage.setOnClickListener { clickListener(chat) }
                    itemSenderFile.setOnClickListener { clickListener(chat) }
                }
            }
            is ReceiverViewHolder -> {
                holder.binding.apply {
                    item = chat
                    executePendingBindings()
                    itemReceiverImage.setOnClickListener { clickListener(chat) }
                    itemReceiverFile.setOnClickListener { clickListener(chat) }

                }
            }
            else -> throw IllegalArgumentException()
        }
    }

    override fun getItemViewType(position: Int): Int {
        val chat = differ.currentList[position]

        return when (chat.senderId.objectId == ParseUser.getCurrentUser().objectId) {
            true -> TYPE_SENDER
            else -> TYPE_RECEIVER
        }
    }

    class SenderViewHolder(val binding: ItemChatSenderBinding) :
        RecyclerView.ViewHolder(binding.root) {
        companion object {
            fun from(parent: ViewGroup, layout: Int): SenderViewHolder {
                val inflater = LayoutInflater.from(parent.context)
                val binding =
                    DataBindingUtil.inflate<ItemChatSenderBinding>(inflater, layout, parent, false)
                return SenderViewHolder(
                    binding
                )
            }
        }
    }

    class ReceiverViewHolder(val binding: ItemChatReceiverBinding) :
        RecyclerView.ViewHolder(binding.root) {
        companion object {
            fun from(parent: ViewGroup, layout: Int): ReceiverViewHolder {
                val inflater = LayoutInflater.from(parent.context)
                val binding =
                    DataBindingUtil.inflate<ItemChatReceiverBinding>(
                        inflater,
                        layout,
                        parent,
                        false
                    )
                return ReceiverViewHolder(
                    binding
                )
            }
        }
    }

}