package com.example.data_remote.api.model

import com.google.gson.annotations.SerializedName

data class CourseList(
    @SerializedName("courses") val courses: List<CourseDto>
)
