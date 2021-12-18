package com.findajob.jobamax.dashboard.messages

interface ChatHandler {

    fun onSendMessage()

    fun onBackPress()

    fun onCallButtonPressed()

    fun onVideoCallButtonPressed()

    fun onRequirementsButtonPressed()

    fun launchCamera()

}