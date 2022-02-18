package com.findajob.jobamax.enums

enum class JobPhase(var phase: String) {
    SELECT_PHASE("Select Phase"),
    DEADLINE("Deadline"),
    ONLINE_INTERVIEWS("Online interviews"),
    ASSESSMENTS( "Assessments"),
    PHONE_CALL("Phone call"),
    INTERVIEW("Interview"),
    HIRED("Hired"),
    REFUSED("Refused")
}