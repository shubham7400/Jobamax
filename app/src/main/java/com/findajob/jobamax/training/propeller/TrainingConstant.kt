package com.findajob.jobamax.training.propeller

import io.agora.rtc.RtcEngine

object TrainingConstant {
	@JvmField
    var MEDIA_SDK_VERSION: String? = null

	init {
		var sdk = "undefined"
		try {
			sdk = RtcEngine.getSdkVersion()
		} catch (e: Throwable) {
		}
		MEDIA_SDK_VERSION = sdk
	}
}