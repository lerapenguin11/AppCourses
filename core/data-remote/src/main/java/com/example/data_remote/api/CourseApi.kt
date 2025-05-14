package com.example.data_remote.api

import com.example.data_remote.api.model.CourseList
import retrofit2.Response
import retrofit2.http.GET

interface CourseApi {

    @GET("v3/4fcf5997-7c1b-4959-9f73-1fd682cf6b7a")
    suspend fun getCourses(): Response<CourseList>
}