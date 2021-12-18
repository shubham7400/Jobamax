package com.findajob.jobamax.repo

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.findajob.jobamax.dashboard.home.training.online.courses.OnlineCoursePagingSource
import com.findajob.jobamax.dashboard.home.training.online.courses.api.UdemyApiService
import com.findajob.jobamax.dashboard.home.training.online.courses.onlinecourse.review.ReviewsPagingSource
import com.findajob.jobamax.dashboard.home.training.online.courses.onlinecourse.syllabus.SyllabusPagingSource
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UdemyRepo @Inject constructor(private val udemyApiService: UdemyApiService) {

    fun getSearchResult(query: String ) =
        Pager(
            config = PagingConfig(
                pageSize = 20,
                maxSize = 100,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {OnlineCoursePagingSource(udemyApiService, query)}
        ).liveData

    fun getReviewsList(courseId: Int) =
        Pager(
            config = PagingConfig(
                pageSize = 20,
                maxSize = 100,
                enablePlaceholders = false
            ),
            pagingSourceFactory = { ReviewsPagingSource(udemyApiService, courseId) }
        ).liveData

    fun getSyllabus(courseId: Int) =
        Pager(
                config = PagingConfig(
                        pageSize = 20,
                        maxSize = 100,
                        enablePlaceholders = false
                ),
                pagingSourceFactory = { SyllabusPagingSource(udemyApiService, courseId) }
        ).liveData


}