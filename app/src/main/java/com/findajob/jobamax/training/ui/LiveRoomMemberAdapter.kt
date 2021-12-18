package com.findajob.jobamax.training.ui

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.RecyclerView
import com.findajob.jobamax.R
import com.findajob.jobamax.dashboard.messages.ChatActivity
import com.findajob.jobamax.dialog.MessagePopUpDialog
import com.findajob.jobamax.extensions.goToActivity
import com.findajob.jobamax.training.model.Member
import com.findajob.jobamax.util.CHAT_IS_NETWORKING
import com.findajob.jobamax.util.inflate
import com.parse.ParseUser
import com.squareup.picasso.Picasso
import jp.wasabeef.picasso.transformations.CropCircleTransformation
import kotlinx.android.synthetic.main.item_live_room_member.view.*

class LiveRoomMemberAdapter(private val activity: Activity, private val members: List<Member>) :
    RecyclerView.Adapter<LiveRoomMemberAdapter.LiveRoomMemberViewHolder>() {

    inner class LiveRoomMemberViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bindTo(member: Member) {
            if (member.profileUrl.isNotEmpty()) {
                Picasso.get().load(member.profileUrl).transform(CropCircleTransformation())
                    .into(itemView.userIcon)
            }
            if(member.muted) {
                itemView.mutedIcon.visibility = View.VISIBLE
            } else {
                itemView.mutedIcon.visibility = View.GONE
            }
            if(member.handRaised) {
                itemView.handIcon.visibility = View.VISIBLE
            } else {
                itemView.handIcon.visibility = View.GONE
            }
            itemView.nameLabel.text = member.name
            if (ParseUser.getCurrentUser().objectId != member.id) {
                itemView.setOnClickListener {

                    val popUpDialog: MessagePopUpDialog = MessagePopUpDialog(activity, member) {
                        activity.goToActivity(
                            ChatActivity::class.java,
                            false,
                            bundleOf(
                                Pair(ChatActivity.EXTRA_RECEIVER_ID, member.id),
                                Pair(ChatActivity.EXTRA_RECEIVER_NAME, member.name),
                                Pair(ChatActivity.EXTRA_MESSAGE_SOURCE, CHAT_IS_NETWORKING),
                            )
                        )
                    }

                    popUpDialog.show()
                }
            }
        }
    }

    override fun getItemCount(): Int = members.size

    override fun onBindViewHolder(holder: LiveRoomMemberViewHolder, position: Int) =
        holder.bindTo(members[position])

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        LiveRoomMemberViewHolder(parent.inflate(R.layout.item_live_room_member))
}