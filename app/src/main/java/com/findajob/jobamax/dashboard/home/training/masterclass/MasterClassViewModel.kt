package com.findajob.jobamax.dashboard.home.training.masterclass

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.findajob.jobamax.dashboard.home.training.masterclass.model.MasterClassVideo
import com.findajob.jobamax.dashboard.home.training.masterclass.model.Topic
import com.findajob.jobamax.data.pojo.Category
import com.findajob.jobamax.data.pojo.VideoDetails
import com.findajob.jobamax.enums.ParseCloudFunction
import com.findajob.jobamax.preference.getUserId
import com.findajob.jobamax.util.log
import com.findajob.jobamax.util.toast
import com.google.gson.Gson
import com.parse.FunctionCallback
import com.parse.ParseCloud
import org.json.JSONObject

class MasterClassViewModel(val context: Application) : AndroidViewModel(context) {
    val trendingList = MutableLiveData<List<Category>>()
    val comingSoonList = MutableLiveData<List<Category>>()
    val myList = MutableLiveData<List<Category>>()
    val newList = MutableLiveData<List<Category>>()

    val topic = MutableLiveData<Topic>()


    private val _videoDetailsLD: MutableLiveData<VideoDetails> by lazy {
        MutableLiveData()
    }

    private val _videoListLD: MutableLiveData<List<MasterClassVideo>> by lazy {
        MutableLiveData()
    }
    val videoDetailsLD: LiveData<VideoDetails> by lazy {
        _videoDetailsLD
    }

    val videoListLD: LiveData<List<MasterClassVideo>> by lazy {
        _videoListLD
    }

    fun fetchVideoDetails() {
        _videoDetailsLD.value = VideoDetails.generateMockUpData()
    }

    fun fetchVideoList(topicId: String) {
        ParseCloud.callFunctionInBackground(ParseCloudFunction.getSeasonsById.toString(), hashMapOf("topicId" to topicId, "userId" to context.getUserId()), FunctionCallback<Map<String, Any>> { result, e ->
            when {
                e != null -> {
                    context.toast(e.message.toString())
                }
                else -> {
                    val mainObject = JSONObject(result)
                    val topicObj = Gson().fromJson(mainObject.toString(), Topic::class.java)
                    topic.value = topicObj
                }
            }
        })
    }

    fun fetchVideoCategory() {
        ParseCloud.callFunctionInBackground(ParseCloudFunction.getTopics.toString() , hashMapOf("userId" to context.getUserId()), FunctionCallback<Map<String, Any>> { result, e ->
            when{
                e != null -> {
                    context.toast(e.message.toString())
                }
                else -> {
                    try {
                        val mainObject = JSONObject(result)
                        var list = ArrayList<Category>()
                        val trendingArray = mainObject.getJSONArray("trendingList")
                        for (index in 0 until  trendingArray.length()){
                            list.add( Gson().fromJson(trendingArray.getJSONObject(index).toString(), Category::class.java))
                        }
                        trendingList.value = list

                        list = ArrayList()
                        val comingSoonArray = mainObject.getJSONArray("comingSoonList")
                        for (index in 0 until  comingSoonArray.length()){
                            list.add( Gson().fromJson(comingSoonArray.getJSONObject(index).toString(), Category::class.java))
                        }
                        comingSoonList.value = list

                        list = ArrayList()
                        val myListArray = mainObject.getJSONArray("myList")
                        for (index in 0 until  myListArray.length()){
                            list.add( Gson().fromJson(myListArray.getJSONObject(index).toString(), Category::class.java))
                        }
                        myList.value = list

                        list = ArrayList()
                        val newListArray = mainObject.getJSONArray("newList")
                        for (index in 0 until  newListArray.length()){
                            list.add( Gson().fromJson(newListArray.getJSONObject(index).toString(), Category::class.java))
                        }
                        newList.value = list
                    }catch (e: Exception){
                        log(" ${e.message.toString()}")
                    }
                }
            }
        })
    }

    fun saveTopicInMyList(topicId: String, isAdded: (Boolean) -> Unit) {
        ParseCloud.callFunctionInBackground(ParseCloudFunction.saveInMyList.toString(), mapOf("topicId" to topicId , "userId" to context.getUserId()), FunctionCallback<Map<String, Any>>() { result, e ->
            val mainObject = JSONObject(result)
            if (mainObject.getBoolean("status")){
                isAdded(mainObject.getBoolean("isMylistAdded"))
            }
        })
    }

    fun saveTopicLikeAndDislike(topicId: String, likeAction: Int, state: (Int) -> Unit) {
        ParseCloud.callFunctionInBackground(ParseCloudFunction.saveLikeAndDislike.toString(), mapOf("topicId" to topicId , "userId" to context.getUserId(), "likeAction" to likeAction), FunctionCallback<Map<String, Any>>() { result, e ->
            val mainObject = JSONObject(result)
            if (mainObject.getBoolean("status")){
                state(mainObject.getInt("likeAction"))
            }
            log("dfjkdsfj $mainObject")
        })
    }
}