package com.findajob.jobamax.data.pojo

data class VideoDetails(
    val videoThumbnail: String,
    val title: String,
    val year: String,
    val rating: String,
    val season: String,
    val resolution: String,
    val description: String,
) {
    companion object {
        fun generateMockUpData(): VideoDetails {
            return VideoDetails(
                videoThumbnail = "https://cdn.corporatefinanceinstitute.com/assets/marketing.jpeg",
                title = "Sample Title Data",
                year = "2001",
                rating = "7+",
                season = "Season1",
                resolution = "HD",
                description = "Sunt autem nusquam hoc epicurus in bonis sit id, de quo aut perferendis doloribus asperiores repellat causam non intellegamus, tu paulo ante.",
            )
        }
    }

}