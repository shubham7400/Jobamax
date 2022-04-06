package com.findajob.jobamax.enums

import com.findajob.jobamax.util.log

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