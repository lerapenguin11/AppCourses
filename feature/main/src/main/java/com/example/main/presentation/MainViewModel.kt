package com.example.main.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecase.GetCoursesUseCase
import com.example.domain.utils.onError
import com.example.domain.utils.onException
import com.example.domain.utils.onSuccess
import com.example.main.presentation.mapper.toCourseUI
import com.example.main.ui.ScreenType
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import javax.inject.Inject
import kotlin.time.Duration.Companion.seconds

class MainViewModel @Inject constructor(
    private val getCoursesUseCase: GetCoursesUseCase,
) : ViewModel() {

    private val _screenType: MutableStateFlow<ScreenType> = MutableStateFlow(ScreenType.Main)
    val screenType: StateFlow<ScreenType> = _screenType.asStateFlow()

    private val _test = MutableStateFlow(false)

    @OptIn(ExperimentalCoroutinesApi::class)
    val coursesUIState = getCoursesUseCase.invoke().flatMapLatest {
        flow{
            it.onSuccess { courseList ->
                val coursesUi = courseList.map { course -> course.toCourseUI() }
                emit(value = MainUiState.Content(coursesUi))
            }.onError { _, _ ->
                emit(value = MainUiState.ErrorInitialLoading)
            }.onException {
                emit(value = MainUiState.Exception)
            }
        }
    }.stateIn(
        scope = viewModelScope,
        initialValue = MainUiState.InitialLoading,
        started = SharingStarted.Lazily,
    )

    fun updateScreenType(screenType: ScreenType) {
        _screenType.update { screenType }
    }
}