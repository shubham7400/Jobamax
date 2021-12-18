package com.findajob.jobamax.model

data class JoobleItem(val snippet: String = "",
                    val link: String = "",
                    val location: String = "",
                    val company: String = "",
                    val source: String = "",
                    val id: Long = 0,
                    val title: String = "",
                    val salary: String = "",
                    val type: String = "",
                    val updated: String = "")


data class JobOfferJooble(val jobs: List<JoobleItem>?,
                          val totalCount: Int = 0)

data class JoobleRequest(val location : String,
                         var keywords : String)

