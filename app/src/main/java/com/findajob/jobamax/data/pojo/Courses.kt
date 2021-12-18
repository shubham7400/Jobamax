package com.findajob.jobamax.data.pojo

import com.findajob.jobamax.R

data class Courses(
    val id: Int,
    val courseName: String,
    val image: Int
) {
    companion object {
        fun generateMockCourses(): List<Courses> {
            return listOf(
                Courses(
                    id = 0,
                    courseName = "Master Class",
                    image = R.drawable.img_master_class
                ),
                Courses(
                    id = 1,
                    courseName = "Online Courses",
                    image = R.drawable.img_online_courses
                ),
                Courses(
                    id = 2,
                    courseName = "Networking",
                    image = R.drawable.img_networking
                ),
            )
        }
    }
}