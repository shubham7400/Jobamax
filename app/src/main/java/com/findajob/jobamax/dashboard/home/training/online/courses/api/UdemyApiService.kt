package com.findajob.jobamax.dashboard.home.training.online.courses.api

import com.findajob.jobamax.dashboard.home.training.online.courses.model.CoursesResponse
import com.findajob.jobamax.dashboard.home.training.online.courses.model.review.ReviewResponse
import com.findajob.jobamax.dashboard.home.training.online.courses.model.syllabus.SyllabusResponse
import retrofit2.http.*


interface UdemyApiService {

    companion object {
        const val BASE_URL = "https://www.udemy.com/api-2.0/"
        private const val HEADER =
            "Authorization: Basic OVFRTjhodzRmMm5QWjlQaGNzeGM5S3lOa3duSjBDSTE5ZTl3YlUzQzpLbk5LUW96QkZiOE0wUG9aUEJKYlV0Y2oya0F2SldjS3VXNTI4MUxDZjlZNFI3M09IQ3B2SW5VM2tsTFk0M2Z2OGlPRXF6aTJaM3ZtWkZaYlVXSzE5eFhxMlJ5bFk0QnZZNlB6c3pudHExZFJTRlZTSldrd0ozd2pTdEdrdmtKNA=="

        private const val UDEMY_CLIENT_SECRET = "tKnNKQozBFb8M0PoZPBJbUtcj2kAvJWcKuW5281LCf9Y4R" +
                "73OHCpvInU3klLY43fv8iOEqzi2Z3vmZFZbUWK19xXq2RylY4BvY6Pzszntq1dRSFVSJWkwJ3wjStGkvkJ4"

        private const val UDEMY_CLIENT_ID = "9QQN8hw4f2nPZ9Phcsxc9KyNkwnJ0CI19e9wbU3C"

    }

    @Headers(
        HEADER
    )
    @GET("courses")
    suspend fun getRequest(@Query("search") search: String, @Query("page") page: Int, @Query("page_size") pageSize: Int): CoursesResponse

    @Headers(HEADER)
    @GET("courses/{course_id}/reviews")
    suspend fun getReview(@Path(value = "course_id", encoded = true) id: Int, @Query("page") page: Int, @Query("page_size") pageSize: Int): ReviewResponse

    @Headers(HEADER)
    @GET("courses/{course_id}/public-curriculum-items")
    suspend fun getSyllabus(@Path(value = "course_id", encoded = true) id: Int, @Query("page") page: Int, @Query("page_size") pageSize: Int): SyllabusResponse

}


