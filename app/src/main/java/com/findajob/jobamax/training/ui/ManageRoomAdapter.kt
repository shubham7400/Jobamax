package com.findajob.jobamax.training.ui

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.findajob.jobamax.R
import com.findajob.jobamax.model.LiveRoom
import com.findajob.jobamax.util.inflate
import com.parse.ParseObject
import kotlinx.android.synthetic.main.item_live_room.view.*

class ManageRoomAdapter(val onRoomClicked: (room: ParseObject) -> Unit) : RecyclerView.Adapter<ManageRoomAdapter.ManageRoomViewHolder>() {
	
	private var rooms: List<ParseObject> = listOf()
	
	fun notifyRoomChanged(rooms: List<ParseObject>) {
		this.rooms = rooms
		notifyDataSetChanged()
	}
	
	inner class ManageRoomViewHolder(view: View) : RecyclerView.ViewHolder(view) {
		
		fun bindTo(room: LiveRoom) {
			itemView.roomLabel.text = room.name
			itemView.setOnClickListener {
				onRoomClicked(rooms[adapterPosition])
			}
		}
	}
	
	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ManageRoomViewHolder(parent.inflate(R.layout.item_live_room))
	
	override fun onBindViewHolder(holder: ManageRoomViewHolder, position: Int) = holder.bindTo(LiveRoom(rooms[position]))
	
	override fun getItemCount(): Int = rooms.size
}