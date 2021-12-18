package com.findajob.jobamax.model

import com.parse.ParseObject
import java.util.*

class LiveRoom {
	
	var roomId = UUID.randomUUID().toString()
	var category: List<String> = listOf()
	var name = ""
	
	constructor()
	
	fun toParseObject(): ParseObject {
		val liveRoom = ParseObject("LiveRoom")
		liveRoom.put("name", name)
		liveRoom.put("roomId", roomId)
		liveRoom.put("category", category)
		return liveRoom
	}
	
	constructor(obj: ParseObject) : this() {
		this.name = obj["name"].toString()
		this.roomId = obj["roomId"].toString()
		this.category = (obj["category"] as? List<String>) ?: listOf()
	}

	companion object {
		const val CLASS_NAME ="LiveRoom"
	}
}