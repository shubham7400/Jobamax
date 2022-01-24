package com.findajob.jobamax.enums

enum class SeekerWishlistJobFilter(jobType: String) {
    ALL("all"),
    FAVORITE("favorite"),
    MOST_RECENT_ONES("mostRecentOnes"),
    APPLIED("applied"),
    REFUSED("refused"),
    ONLINE_INTERVIEW("online_interview"),
    ASSESSMENTS("assessments"),
    PHONE_CALL("phoneCall"),
    INTERVIEW("interview"),
    HIRED("hired")
}