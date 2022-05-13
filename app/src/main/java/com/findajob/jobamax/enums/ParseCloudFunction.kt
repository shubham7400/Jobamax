package com.findajob.jobamax.enums

enum class ParseCloudFunction(val value: String) {
    GET_TRACKING_STATUS("getTrackingStatus"),
    GET_JOB_SEARCH("getJobSearch"),
    DROPOUT_ACTIONS("dropoutActions"),
    ADD_JOB_TO_WISHLIST("addJobToWishlist"),
    REMOVE_FROM_WISHLIST("removeFromWishlist"),
    GET_JOBS_LOGO("getJobsLogo"),
    DELETE_USER("deleteUser"),
    GET_JOB_TITLES("getJobTitles"),
    ADD_JOB_TITLE("addJobTitle"),
    IMPORT_FROM_LINKEDIN(""),
    SAVE_SPENT_TIME("importFromLinkedIn"),
    SAVE_SWIPE_COUNT("saveSwipeCount")
}