package com.findajob.jobamax.dashboard.home.training

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.findajob.jobamax.base.BaseAndroidViewModel
import com.findajob.jobamax.data.pojo.Courses
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TrainingViewModel @Inject constructor(val context: Application) :
    BaseAndroidViewModel(context) {

    private val _coursesLiveData: MutableLiveData<List<Courses>> by lazy {
        MutableLiveData()
    }


    val courseLiveData: LiveData<List<Courses>> by lazy {
        _coursesLiveData
    }

    fun fetchCourses() {
        _coursesLiveData.value = Courses.generateMockCourses()
    }
}