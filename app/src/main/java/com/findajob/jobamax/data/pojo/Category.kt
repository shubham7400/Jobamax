package com.findajob.jobamax.data.pojo

import java.io.Serializable


class Category() : Serializable {
    val topicThumbnail: String = ""
    val topicId: String = ""
    val description: String = ""
    val title: String = ""
    val topicType: Int? = null
}

/*
data class Category(val name: String, val thumbNail: List<VideoThumbnail>, ) {
    companion object {
        fun generateMockUpData(): List<Category> {
            return listOf(
                Category(
                    name = "Most Popular",
                    thumbNail = VideoThumbnail.generateMockUpData()
                ),
                Category(
                    name = "Marketing",
                    thumbNail = VideoThumbnail.generateMockUpData()
                ),
                Category(
                    name = "Management",
                    thumbNail = VideoThumbnail.generateMockUpData()
                ),
                Category(
                    name = "Business Plan",
                    thumbNail = VideoThumbnail.generateMockUpData()
                ),
                Category(
                    name = "Design",
                    thumbNail = VideoThumbnail.generateMockUpData()
                ),
                Category(
                    name = "Style",
                    thumbNail = VideoThumbnail.generateMockUpData()
                ),
            )
        }
    }
}*/
