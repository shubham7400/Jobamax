package com.findajob.jobamax.util

import com.findajob.jobamax.R


const val ARG_ROLE = "arg_role"
const val ROLE_JOB_SEEKER = "job_seeker"
const val ROLE_RECRUITER = "recruiter"
const val ADZUNA_JOB = "adzuna"
const val REMOTIVE_JOB = "remotive"
const val JOOBLE_JOB = "jooble"
const val JOBSPIKR_JOB = "jobs-pikr"
const val USAJOBS_JOB = "usa-jobs"
const val RECRUITER_SUBSCRIPTION_REQUEST_CODE = 100
const val GOOGLE_SIGN_IN_REQUEST_CODE = 1002
const val LINKEDIN_SIGN_IN_REQUEST_CODE = 1003
const val REQUEST_PERMISSIONS_REQUEST_CODE = 1004
const val SAF_PERMISSIONS_REQUEST_CODE = 1005
const val ARG_JOB_OFFER = "job_offer"
const val ARG_JOB_NAME = "job_name"
const val ARG_JOB_ID = "job_id"
const val ARG_LOCATION = "arg_location"
const val ARG_LAT = "arg_lat"
const val ARG_LNG = "arg_lng"
const val ARG_CITY = "arg_city"
const val ARG_CITY_FLAG = "arg_city_flag"
const val ARG_VIDEO_URL = "arg_video_url"
const val ARG_ACTION = "arg_action"
const val ACTION_LOGIN = "login_action"
const val ACTION_REGISTER = "register_action"
const val REQUEST_LOCATION_CODE = 1006
const val AUTOCOMPLETE_REQUEST_CODE = 1007
const val REQUEST_CURRENT_LOCATION_CODE = 1008
const val REQUEST_CITY_CODE = 1009
const val NODE_APPLICANTS = "applicants"
const val NODE_CANCELLED = "cancelled"
const val NODE_MATCHED = "matched"
const val NODE_REFUSED = "refused"
const val NODE_DROPOUTS = "dropouts"
const val ARG_WEB_URL = "arg_web_url"
const val ARG_EDUCATION = "arg_education"
const val ARG_EXPERIENCE = "arg_experience"

const val RELATION_KEY_MATCHED = "matched"
const val RELATION_KEY_SOURCED = "sourced"

const val SORTING_CREATED_AT = "createdAt"
const val SORTING_UPDATED_AT = "updatedAt"

const val NODE_JOB_SEEKER = "jobSeeker"
const val NODE_RECRUITER = "recruiter"
const val ARG_REFRESH_ROOM = "refresh_room"
const val ARG_JOBSEARCH = "jobsearch_navigate_arg"
const val ARG_CHAT_REQUIREMENTS = "requirements"
const val ARG_REFRESH_ACTIVE = "refresh_active_users"
const val NETWORKING_ROOM = "networking_room"

// ParseQuery related
const val CREATED_AT_ORDER_LABEL = "createdAt"

const val PLACE_API_KEY = "AIzaSyA4NEv4m7rHGc22VGJz6ffdz2VIgY31avY"

const val ONLINE_COURSE = "OnlineCourse"

const val REQUEST_ALL_PERMISSIONS = 101
val navIcons = intArrayOf(
    R.drawable.ic_course,
    R.drawable.ic_track,
    R.drawable.ic_chat,
    R.drawable.ic_profile
)
val navLabels = intArrayOf(
    R.string.course,
    R.string.track,
    R.string.chat,
    R.string.profile
)

val benefitsList = listOf(
    "Cell phone reimbursement",
    "Commuter assistance",
    "Flexible schedule",
    "Food allowance",
    "Health insurance",
    "Internet reimbursement",
    "Life insurance",
    "Paid sick time",
    "Paid time off",
    "Work from home",
    "Other"
)

//Job Type
const val CONST_FULL_TIME = "full-time"
const val CONST_PART_TIME = "part-time"
const val CONST_PERMANENT = "permanent"
const val CONST_TEMPORARY = "temporary"

//Job Category
const val CONST_JOB = "job"
const val CONST_WORK_STUDY = "work-study"
const val CONST_INTERNSHIP = "internship"
const val CONST_OTHER = "other"

//Hierarchy
const val CONST_HIGH = "high"
const val CONST_MEDIUM = "medium"
const val CONST_LOW = "low"

//Work Experience
const val CONST_UNDER_ONE = "under-one"
const val CONST_ONE_TO_TWO = "one-two"
const val CONST_TWO_PLUS = "two-plus"

const val GOOGLE_LOGIN_TYPE = "google"
const val LINKEDIN_LOGIN_TYPE = "linkedin"
const val FACEBOOK_LOGIN_TYPE = "facebook"
const val PHONE_LOGIN_TYPE = "phone"
const val EMAIL_LOGIN_TYPE = "email"
const val EMAIL = "email"
const val PASSWORD = "password"

const val JOBAMAX_FACEBOOK_URL = "https://www.facebook.com/jobamax.company"
const val JOBAMAX_INSTA_URL = "https://www.instagram.com/jobamax/"
const val JOBAMAX_LINKEDEN_URL = "https://www.linkedin.com/company/jobamax/"
const val JOBAMAX_TWITTER_URL = "https://www.twitter.com/jobamax_company"
const val JOBAMAX_DOWNLOAD_URL = "https://jobamax.com/en/download"

const val RECRUIT_JOB_SEEKER_PAGE_SIZE = 50
const val SOURCE_JOB_SEEKER_PAGE_SIZE = 50
const val JOB_OFFER_PAGE_SIZE = 50


// another resouces array for active state for the icon
val navIconsActive = intArrayOf(
    R.drawable.ic_course,
    R.drawable.ic_track,
    R.drawable.ic_chat,
    R.drawable.ic_profile
)

const val MESSAGE_BODY = "body"
const val MESSAGE_USER_ID = "userId"

const val CHAT_SENDER_ID = "senderId"
const val CHAT_RECEIVER_ID = "receiverId"
const val CHAT_MESSAGE = "message"
const val CHAT_FILE = "file"
const val CHAT_IS_JOB = "isJob"
const val CHAT_IS_NETWORKING = "isNetworking"
const val CHAT_IS_ARCHIVED = "isArchived"

const val MESSAGE_SENDER_ID = "message_sender_id"
const val MESSAGE_RECEIVER_ID = "message_receiver_id"
const val MESSAGE_SENDER_USERNAME = "message_sender_username"
const val MESSAGE_RECEIVER_USERNAME = "message_receiver_username"


const val FCM_API = "https://fcm.googleapis.com/fcm/send"
const val FIREBASE_SERVER_KEY =
    "AAAAsZsQSh4:APA91bGlUri7JyMiG7kYnsbcY_qEjss_J2V0FuXRW_1wF7GlRHLCUYRgsFF2KeEpBINz7a0kXMHLbQ6ihnNzCthwS-I83gZkVaXKocnwC9QHInLlrCCtNhJUH9AwyOLq21kORvlE_1Wn"
const val ADZUNA_APP_ID = "844f49b1"
const val ADZUNA_APP_KEY = "ebbde41f84e681d15718c6df3b76fdf8"

const val RECRUITER_STANDARD_PLAN = "standard"
const val RECRUITER_PREMIUM_PLAN = "premium"
const val RECRUITER_STARTER_PLAN = "starter"
const val RECRUITER_ENTERPRISE_PLAN = "enterprise"

const val STRIPE_PUBLISHABLE_KEY = "pk_test_51IYTBnCnZpFbP8B6gYfhVD2uupPzxvJaB7kLga9HplK7cuHEyWKZx9NWdlFd4ntSmyMTaeAQ5g06qB7anQLJs7AE00VlkH2lLO"

const val JOOBLE_APP_KEY = "8c7fda69-0ca6-4b95-89bb-f9be69c487fa"

//Firebase Push Notification Credentials
const val FCM_BASE_URL = "https://fcm.googleapis.com/"
const val FCM_SERVER_KEY = "AAAA1VNXc2M:APA91bGVQTctfKBEO-YqU5I6-OPjZJ037DFyJYgPNubKjiwywi7hOYAbAswpWROnEKkk1nAsS5WCh-T8L-u0eDU8YavfWmKLPM3UCJQ_-_WY2wO1_VR-FU5TtAuQkRvVNGYPvx0G_LT4"
const val FCM_CONTENT_TYPE = "application/json"

// UXCam api-key
const val UX_CAM_API_KEY = ""

const val JOBSPIKR_CLIENT_ID = "jobam_jp_49d22c96dc"
const val JOBSPIKR_CLIENT_AUTH_KEY = "OfF5QspCREVxAsQlWyHrXMlq3ZL99fiAaxDVWOp9pVA"

const val MAXIMUM_INTERESTS = 3


const val JOB_HUNT_PAGE_LABEL = "Job Hunt"
const val RECRUITMENT_PAGE_LABEL = "Recruitment"
const val NETWORKING_PAGE_LABEL = "Networking"
const val ARCHIVED_PAGE_LABEL = "Archived"
