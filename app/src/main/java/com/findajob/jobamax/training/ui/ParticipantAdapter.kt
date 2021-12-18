package com.findajob.jobamax.training.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.findajob.jobamax.R
import com.findajob.jobamax.dashboard.messages.ChatActivity
import com.findajob.jobamax.databinding.ListItemParticipantsBinding
import com.findajob.jobamax.dialog.MessagePopUpDialog
import com.findajob.jobamax.extensions.goToActivity
import com.findajob.jobamax.training.model.Member
import com.findajob.jobamax.util.AutoUpdatableAdapter
import com.findajob.jobamax.util.CHAT_IS_NETWORKING
import kotlinx.android.synthetic.main.item_live_room_member.view.*
import javax.inject.Inject
import kotlin.properties.Delegates

class ParticipantAdapter @Inject constructor(activity: FragmentActivity) : RecyclerView.Adapter<ParticipantAdapter.Holder>(),
    AutoUpdatableAdapter {

    internal var collection: List<Member> by Delegates.observable(emptyList()) { _, old, new ->
        autoNotify(old, new) { o, n -> o.name == n.name }
    }

    val activity = activity

    class Holder(val binding: ListItemParticipantsBinding) :
        RecyclerView.ViewHolder(binding.root) {

        companion object {
            fun from(parent: ViewGroup, layout: Int): Holder {
                val inflater = LayoutInflater.from(parent.context)
                val binding = DataBindingUtil.inflate<ListItemParticipantsBinding>(
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

    override fun getItemViewType(position: Int): Int {
        return position
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder = Holder.from(
        parent, R.layout.list_item_participants
    )

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.binding.apply {
            member = collection[position]
            executePendingBindings()

            member?.let { member ->
                ivMessage.setOnClickListener {
                    activity.goToActivity(
                        ChatActivity::class.java,
                        false,
                        bundleOf(
                            Pair(ChatActivity.EXTRA_RECEIVER_ID, member.id),
                            Pair(ChatActivity.EXTRA_RECEIVER_NAME, member.name),
                            Pair(ChatActivity.EXTRA_MESSAGE_SOURCE, CHAT_IS_NETWORKING)
                        )
                    )
                }
            }


        }
    }

    override fun getItemCount() = collection.size
}