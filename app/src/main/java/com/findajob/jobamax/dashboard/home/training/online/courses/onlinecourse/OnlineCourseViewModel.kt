package com.findajob.jobamax.dashboard.home.training.online.courses.onlinecourse


import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.findajob.jobamax.dashboard.home.training.online.courses.model.OnlineCourse
import com.findajob.jobamax.repo.UdemyRepo
import com.findajob.jobamax.util.ONLINE_COURSE
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class OnlineCourseViewModel @Inject constructor(
        private val repository: UdemyRepo,
        private val savedStateHandle: SavedStateHandle
) : ViewModel() {


    val onlineCourse = savedStateHandle.get<OnlineCourse>(ONLINE_COURSE)

    val id = onlineCourse?.id

    val reviews = id?.let { repository.getReviewsList(it).cachedIn(viewModelScope) }

    val instructors = onlineCourse?.visible_instructors

    val syllabus = id?.let { repository.getSyllabus(it).cachedIn(viewModelScope) }

}
