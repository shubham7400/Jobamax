package com.findajob.jobamax.model

import com.parse.ParseObject
import java.util.*

class Interests {
	
	var name = ""
	
	constructor()
	
	fun toParseObject(): ParseObject {
		val interests = ParseObject("Interests")
		interests.put("name", name)
		return interests
	}
	
	constructor(obj: ParseObject) : this() {
		this.name = obj["name"].toString()
	}
}