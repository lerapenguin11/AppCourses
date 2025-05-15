package com.example.data.repository

import com.example.data.repository.mapper.mapToDomain
import com.example.data.utils.handleApi
import com.example.data_local.room.course.FavoriteCourseDao
import com.example.data_local.room.course.FavoriteCourseEntity
import com.example.data_remote.api.CourseApi
import com.example.domain.model.Course
import com.example.domain.repository.CourseRepository
import com.example.domain.utils.ServerResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

internal class CourseRepositoryImpl @Inject constructor(
    private val courseApi: CourseApi,
    private val courseDao: FavoriteCourseDao,
) : CourseRepository {
    override fun getCourses(): Flow<ServerResult<List<Course>>> {
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

    override suspend fun changeFavoriteStatus(courseId: Int) {
        val isCourseFavorite = courseDao.isCourseFavorite(courseId).first()
        when (isCourseFavorite) {
            true -> {
                courseDao.deleteFromFavorite(courseId)
            }

            false -> {
                courseDao.addFavoriteCourse(FavoriteCourseEntity(courseId))
            }
        }
    }

    override fun getFavoriteCoursesById(): Flow<List<Int>> {
        return courseDao.getFavoriteCourses().map { courseEntities ->
            courseEntities.map {
                it.courseId
            }
        }
    }
}