package com.findajob.jobamax.data.pojo

import com.findajob.jobamax.R

data class MyList(
    val id: Int,
    val courseName: String,
    val course: String,
    val image: Int
) {
    companion object {
        fun generateMockMyList(): List<MyList> {
            return listOf(
                MyList(
                    id = 0,
                    courseName = "Master Class",
                    course = "Themes",
                    image = R.drawable.img_company_sample_01
                ),
                MyList(
                    id = 1,
                    courseName = "Keynotes",
                    course = "Upcoming Events",
                    image = R.drawable.img_company_sample_01
                ),
                MyList(
                    id = 2,
                    courseName = "Online Courses",
                    course = "32 Course Available",
                    image = R.drawable.img_company_sample_01
                ),
                MyList(
                    id = 3,
                    courseName = "Online Courses",
                    course = "32 Course Available",
                    image = R.drawable.img_company_sample_01
                ),
                MyList(
                    id = 4,
                    courseName = "Online Courses",
                    course = "32 Course Available",
                    image = R.drawable.img_company_sample_01
                ),
                MyList(
                    id = 5,
                    courseName = "Online Courses",
                    course = "32 Course Available",
                    image = R.drawable.img_company_sample_01
                )
            )
        }
    }
}