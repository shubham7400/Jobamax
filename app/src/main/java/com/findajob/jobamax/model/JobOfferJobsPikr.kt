package com.findajob.jobamax.model


import com.google.gson.annotations.SerializedName
import org.json.JSONObject

data class JobDataItem(@SerializedName("job_type")
                       val jobType: String = "",
                       @SerializedName("cursor")
                       val cursor: Long = 0,
                       @SerializedName("country")
                       val country: String = "",
                       @SerializedName("crawl_timestamp")
                       val crawlTimestamp: String = "",
                       @SerializedName("city")
                       val city: String = "",
                       @SerializedName("salary_offered")
                       val salaryOffered: String = "",
                       @SerializedName("url")
                       val url: String = "",
                       @SerializedName("geo")
                       val geo: String = "",
                       @SerializedName("uniq_id")
                       val uniqId: String = "",
                       @SerializedName("job_description")
                       val jobDescription: String = "",
                       @SerializedName("job_board")
                       val jobBoard: String = "",
                       @SerializedName("post_date")
                       val postDate: String = "",
                       @SerializedName("company_name")
                       val companyName: String = "",
                       @SerializedName("state")
                       val state: String = "",
                       @SerializedName("category")
                       val category: String = "",
                       @SerializedName("job_title")
                       val jobTitle: String = "")


data class JobOfferJobsPikr(@SerializedName("next_cursor")
                            val nextCursor: Long = 0,
                            @SerializedName("size")
                            val size: Int = 0,
                            @SerializedName("total_count")
                            val totalCount: Int = 0,
                            @SerializedName("job_data")
                            val jobData: List<JobDataItem>?,
                            @SerializedName("job_credit_remaining")
                            val jobCreditRemaining: Int = 0,
                            @SerializedName("message")
                            val message: String = "",
                            @SerializedName("status")
                            val status: String = "")