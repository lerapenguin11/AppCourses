package com.example.main.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecase.ChangeFavoriteStatusUseCase
import com.example.domain.usecase.GetCoursesUseCase
import com.example.domain.usecase.GetFavoriteCoursesByIdUseCase
import com.example.domain.utils.ServerResult
import com.example.main.presentation.mapper.mapCourseUIWhitFavoriteCourses
import com.example.main.presentation.mapper.toCourseUI
import com.example.main.ui.ScreenType
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val getCoursesUseCase: GetCoursesUseCase,
    private val getFavoriteCoursesByIdUseCase: GetFavoriteCoursesByIdUseCase,
    private val changeFavoriteStatusUseCase: ChangeFavoriteStatusUseCase,
) : ViewModel() {

    private val _screenType: MutableStateFlow<ScreenType> = MutableStateFlow(ScreenType.Main)
    val screenType: StateFlow<ScreenType> = _screenType.asStateFlow()

    private val _test = MutableStateFlow(false)

    val coursesUIState: StateFlow<MainUiState> = combine(
        getCoursesUseCase.invoke(),
        getFavoriteCoursesByIdUseCase.invoke(),
        _test,
        screenType
    ) { coursesResult, favoriteIds, ts, screenType ->
            when (coursesResult) {
                is ServerResult.Success -> {
                    val coursesUiList =
                        coursesResult.data.map { domainCourse -> domainCourse.toCourseUI() }
                    val updatedCoursesUiList = coursesUiList.map { courseUi ->
                        mapCourseUIWhitFavoriteCourses(courseUi, favoriteIds)
                    }
                    when(screenType){
                        ScreenType.Main -> MainUiState.Content(updatedCoursesUiList)
                        ScreenType.Favorite -> MainUiState.Content(updatedCoursesUiList.filter { it.isFavorite })
                    }
                }

                is ServerResult.Error -> MainUiState.ErrorInitialLoading
                is ServerResult.Exception -> MainUiState.Exception
            }
        }.stateIn(
            scope = viewModelScope,
            initialValue = MainUiState.InitialLoading,
            started = SharingStarted.Lazily,
        )

    fun updateScreenType(screenType: ScreenType) {
        _screenType.update { screenType }
    }

    fun changeFavoriteStatus(courseId: Int) {
        viewModelScope.launch {
            changeFavoriteStatusUseCase.invoke(courseId)
        }

    }
}