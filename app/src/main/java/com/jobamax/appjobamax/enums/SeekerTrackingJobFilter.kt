package com.jobamax.appjobamax.enums

enum class SeekerTrackingJobFilter(val filterType: String) {
    ALL("Added to wishlist"),
    APPLIED("applied"),
    REFUSED("Refused"),
    ONLINE_INTERVIEWS("Online interview"),
    ASSESSMENTS("Assesment"),
    PHONE_CALL("Phone call"),
    INTERVIEWS("Interview"),
    HIRED("Hired");
}