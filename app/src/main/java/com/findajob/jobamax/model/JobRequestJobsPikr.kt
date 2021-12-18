package com.findajob.jobamax.model


import com.google.gson.annotations.SerializedName

data class Bool(@SerializedName("must")
                val must: List<MustItem>?)


data class QueryString(@SerializedName("query")
                       val query: String = "",
                       @SerializedName("fields")
                       val fields: List<String>?)


data class MustItem(@SerializedName("query_string")
                    val queryString: QueryString)


data class JobRequestJobsPikr(@SerializedName("size")
                              val size: Int = 0,
                              @SerializedName("format")
                              val format: String = "",
                              @SerializedName("search_query_json")
                              val searchQueryJson: SearchQueryJson)


data class SearchQueryJson(@SerializedName("bool")
                           val bool: Bool)


