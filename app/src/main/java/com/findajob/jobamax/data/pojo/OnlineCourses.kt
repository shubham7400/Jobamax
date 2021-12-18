package com.findajob.jobamax.data.pojo

import com.findajob.jobamax.R

data class OnlineCourses(
    val title: String,
    val rating: Float,
    val image: Int
) {
    companion object {
        fun generateMockCOnlineCourses(): List<OnlineCourses> {
            return listOf(
                OnlineCourses(
                    title = "Master Class",
                    rating = 2.5F,
                    image = R.drawable.img_master_class
                ),
                OnlineCourses(
                    title = "Keynotes",
                    rating = 4.5F,
                    image = R.drawable.img_keynotes
                ),
                OnlineCourses(
                    title = "Online Courses",
                    rating = 1.5F,
                    image = R.drawable.img_online_courses
                )
            )
        }
    }
}