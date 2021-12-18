package com.findajob.jobamax.model

data class JobsItem(val job_type: String = "",
                    val candidate_required_location: String = "",
                    val company_name: String = "",
                    val publication_date: String = "",
                    val description: String = "",
                    val id: Int = 0,
                    val title: String = "",
                    val category: String = "",
                    val salary: String = "",
                    val url: String = "")


data class JobOfferRemotive(val jobs: List<JobsItem>?)


