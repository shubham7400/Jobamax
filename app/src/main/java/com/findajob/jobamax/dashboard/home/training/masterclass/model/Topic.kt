package com.findajob.jobamax.dashboard.home.training.masterclass.model

import java.io.Serializable

class Topic() : Serializable{
    val topicThumbnail: String = ""
    val topicId: String = ""
    val subTitle: String = ""
    val trailerDuration: String = ""
    val guests: List<Guest>? = null
    val description: String = ""
    val likeAction: Long = 0
    val isMylistAdded: Boolean = false
    val title: String = ""
    val trailerUrl: String = ""
    val seasonYear: String = ""
    val episodes: List<Episode>? = null
}

class Episode () : Serializable{
    val duration: String = ""
    val videoThumbnail: String = ""
    val subTitle: String = ""
    val videoUrl: String = ""
    val name: String = ""
    val description: String = ""
    val partNumber: String = ""
    val episodeID: String = ""
}

class Guest () : Serializable{
    val imageUrl: String = ""
    val name: String = ""
    val description: String = ""
    val links: List<Link>? = null
    val title: String = ""
}

class Link () : Serializable{
    val link: String = ""
    val title: String = ""
}
