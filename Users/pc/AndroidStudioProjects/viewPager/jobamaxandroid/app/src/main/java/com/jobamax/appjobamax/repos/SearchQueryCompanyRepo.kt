package com.jobamax.appjobamax.repos

import com.jobamax.appjobamax.model.SearchQueryCompany
import com.jobamax.appjobamax.network.ApiFetchCompaniesService
import com.jobamax.appjobamax.extensions.log
import com.google.gson.Gson
import org.json.JSONArray
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchQueryCompanyRepo(private val apiFetchCompaniesService: ApiFetchCompaniesService) {
    val gson = Gson()

    fun getCompanies(searchQuery: String, onSuccess: (ArrayList<SearchQueryCompany>) -> Unit){
        apiFetchCompaniesService.searchCompanies(searchQuery).enqueue(object: Callback<Any> {
            override fun onResponse(call: Call<Any>, response: Response<Any>) {
                try {
                    if (response.errorBody() != null) {
                        val errorText = response.errorBody()!!.string()
                        log("errorText $errorText")
                    }else{
                        if (response.body() != null) {
                            val companySuggestions = arrayListOf<SearchQueryCompany>()
                            val mainObject = gson.toJson(response.body())
                            val jsonArray = JSONArray(mainObject)
                            for (index in 0 until jsonArray.length()){
                                companySuggestions.add(gson.fromJson(jsonArray.getJSONObject(index).toString(), SearchQueryCompany::class.java))
                            }
                            onSuccess(companySuggestions)
                        }
                    }
                }catch (e: Exception){
                    log("exception ${e.message.toString()}")
                }
            }

            override fun onFailure(call: Call<Any>, t: Throwable) {
                log("onFailure ${t.message.toString()}")
            }

        })
    }


}