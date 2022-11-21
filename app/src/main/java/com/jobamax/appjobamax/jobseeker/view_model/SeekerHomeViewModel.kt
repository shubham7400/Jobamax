package com.jobamax.appjobamax.jobseeker.view_model

import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.jobamax.appjobamax.enums.ParseTableFields
import com.jobamax.appjobamax.extensions.log
import com.jobamax.appjobamax.model.*
import com.parse.ParseException
import com.parse.ParseObject

class SeekerHomeViewModel : ViewModel(){
    val gson = Gson()

    var jobSeekerObject: ParseObject? = null
    val jobSeeker get() = if (jobSeekerObject == null) JobSeeker() else JobSeeker(jobSeekerObject!!)
    var isJobSeekerUpdated = MutableLiveData<Boolean>()


    // chat thread list
    private val _chatThreadList = MutableLiveData<List<ChatThread>>(listOf())
    val chatThreadList: LiveData<List<ChatThread>> get() = _chatThreadList
    fun setChatThreadList(list : List<ChatThread>){
        _chatThreadList.value = list
    }

}