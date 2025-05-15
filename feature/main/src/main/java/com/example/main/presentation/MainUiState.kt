package com.example.main.presentation

import com.example.model.CourseUI

sealed class MainUiState {
    data object InitialLoading : MainUiState()
    data object ErrorInitialLoading : MainUiState()
    data object Exception: MainUiState()
    data class Content(val data: List<CourseUI>) : MainUiState()
}