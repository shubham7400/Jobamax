package com.findajob.jobamax.training.model

class EngineConfig internal constructor() {
	@JvmField
    var mClientRole = 0
	@JvmField
    var mUid = 0
	@JvmField
    var mChannel: String? = null
	fun reset() {
		mChannel = null
	}
}