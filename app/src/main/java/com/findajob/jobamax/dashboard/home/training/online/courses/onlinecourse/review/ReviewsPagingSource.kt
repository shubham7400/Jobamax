package com.findajob.jobamax.dashboard.home.training.online.courses.onlinecourse.review


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.findajob.jobamax.dashboard.home.training.online.courses.api.UdemyApiService
import com.findajob.jobamax.dashboard.home.training.online.courses.model.review.Review
import retrofit2.HttpException
import java.io.IOException


private const val UDEMY_STARTING_PAGE_IDEX = 1

class ReviewsPagingSource(
    private val udemyApi: UdemyApiService,
    private val courseId: Int
) : PagingSource<Int, Review>() {

    private var _numberOfResults = MutableLiveData<Int>()
    val numberOfResult: LiveData<Int>
        get() = _numberOfResults

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Review> {
        val position = params.key ?: UDEMY_STARTING_PAGE_IDEX

        return try {

            val response = udemyApi.getReview(courseId, position, params.loadSize)
            val reviews = response.results
            LoadResult.Page(
                data = reviews,
                prevKey = if (position == UDEMY_STARTING_PAGE_IDEX) null else position - 1,
                nextKey = if (reviews.isEmpty()) null else position + 1
            )

        } catch (exception: IOException) {
            LoadResult.Error(exception)
        } catch (exception: HttpException) {
            LoadResult.Error(exception)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Review>): Int? {
        return state.anchorPosition?.let {
            state.closestPageToPosition(it)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(it)?.nextKey?.minus(1)
        }
    }
}