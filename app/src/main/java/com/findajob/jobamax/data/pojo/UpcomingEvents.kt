package com.findajob.jobamax.data.pojo

import com.findajob.jobamax.R

data class UpcomingEvents(
    val id: Int,
    val event: String,
    val description: String,
    val image: Int,
    val date : String,
) {
    companion object {
        fun generateMockUpcomingEvents(): List<UpcomingEvents> {
            return listOf(
                UpcomingEvents(
                    id = 0,
                    event = "Energy Justice",
                    description = "Exploring an Equitable Green Transition",
                    image = R.drawable.img_keynotes,
                    date = "November 25, 2020"
                ),
                UpcomingEvents(
                    id = 1,
                    event = "Marketing",
                    description = "Exploring an Equitable Green Transition",
                    image = R.drawable.img_keynotes,
                    date = "November 26, 2020"
                ),
                UpcomingEvents(
                    id = 2,
                    event = "Online Courses",
                    description = "Exploring an Equitable Green Transition",
                    image = R.drawable.img_keynotes,
                    date = "November 27, 2020"
                ),
                UpcomingEvents(
                    id = 3,
                    event = "Online Courses",
                    description = "Exploring an Equitable Green Transition",
                    image = R.drawable.img_keynotes,
                    date = "November 28, 2020"
                ),
                UpcomingEvents(
                    id = 4,
                    event = "Online Courses",
                    description = "Exploring an Equitable Green Transition",
                    image = R.drawable.img_keynotes,
                    date = "November 29, 2020"
                ),
                UpcomingEvents(
                    id = 5,
                    event = "Online Courses",
                    description = "Exploring an Equitable Green Transition",
                    image = R.drawable.img_keynotes,
                    date = "November 30, 2020"
                )
            )
        }
    }
}