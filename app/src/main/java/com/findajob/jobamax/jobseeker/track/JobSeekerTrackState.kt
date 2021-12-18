package com.findajob.jobamax.jobseeker.track

import com.parse.ParseObject

class JobSeekerTrackState {
	var appliedList = listOf<ParseObject>()
	var refusedList = listOf<ParseObject>()
	var matchedList = listOf<ParseObject>()
	var refuseReasons = listOf<ParseObject>()
}