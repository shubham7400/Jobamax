package com.findajob.jobamax.dashboard.home.training.online.courses

import androidx.lifecycle.*
import androidx.paging.cachedIn
import com.findajob.jobamax.dashboard.home.training.online.courses.model.CoursesResponse
import com.findajob.jobamax.repo.UdemyRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class OnlineCoursesListViewModel @Inject constructor(
    private val repository: UdemyRepo
) : ViewModel() {

    private val _onClick: MutableLiveData<Int> by lazy {
        MutableLiveData()
    }
    val onClick: LiveData<Int> by lazy {
        _onClick
    }
    private val _coursesList = MutableLiveData<CoursesResponse>()
    val result: LiveData<CoursesResponse>
        get() = _coursesList


    private val currentQuery = MutableLiveData(DEFAULT_QUERY)


    val onlineCourses = currentQuery.switchMap {
        repository.getSearchResult(it).cachedIn(viewModelScope)
    }

    fun searchCourses(query: String) {
        currentQuery.value = query
    }

    fun onClick(id: Int) {
        _onClick.value = id
    }

    companion object {
        private const val DEFAULT_QUERY = ""
    }
}