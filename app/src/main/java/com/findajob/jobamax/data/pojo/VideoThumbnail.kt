package com.findajob.jobamax.data.pojo

data class VideoThumbnail(
    val thumbNail: String,
) {
    companion object {
        fun generateMockUpData(): List<VideoThumbnail> {
            return listOf(
                VideoThumbnail(
                    thumbNail = "https://cdn.corporatefinanceinstitute.com/assets/marketing.jpeg"
                ),
                VideoThumbnail(
                    thumbNail = "https://cdn.corporatefinanceinstitute.com/assets/marketing.jpeg"
                ),
                VideoThumbnail(

                    thumbNail = "https://cdn.corporatefinanceinstitute.com/assets/marketing.jpeg"
                ),
                VideoThumbnail(

                    thumbNail = "https://cdn.corporatefinanceinstitute.com/assets/marketing.jpeg"
                ),
                VideoThumbnail(

                    thumbNail = "https://cdn.corporatefinanceinstitute.com/assets/marketing.jpeg"
                ),
                VideoThumbnail(

                    thumbNail = "https://cdn.corporatefinanceinstitute.com/assets/marketing.jpeg"
                ),
            )
        }
    }
}