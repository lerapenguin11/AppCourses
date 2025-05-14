package com.example.data.repository

import com.example.data.repository.mapper.mapToDomain
import com.example.data.utils.handleApi
import com.example.data_remote.api.CourseApi
import com.example.domain.model.Course
import com.example.domain.repository.CourseRepository
import com.example.domain.utils.ServerResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

internal class CourseRepositoryImpl @Inject constructor(
    private val courseApi: CourseApi,
) : CourseRepository {
    override suspend fun getCourses(): Flow<ServerResult<List<Course>>> {
        return flow {
            emit(
                value = handleApi(
                    apiCall = { courseApi.getCourses() },
                    mapper = {
                        it.courses.map { course ->
                            course.mapToDomain()
                        }
                    }
                )
            )
        }
    }
}