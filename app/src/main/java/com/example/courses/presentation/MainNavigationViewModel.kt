package com.example.courses.presentation

import androidx.activity.result.launch
import androidx.compose.runtime.Immutable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.data_store.OnboardingManager
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainNavigationViewModel @Inject constructor(private val onboardingManager: OnboardingManager) :
    ViewModel() {
    private val _startDestination = MutableStateFlow<StartDestination>(StartDestination.Init)
    val startDestination: StateFlow<StartDestination> = _startDestination.asStateFlow()

    init {
        checkOnboardingStatus()
    }

    private fun checkOnboardingStatus() {
        viewModelScope.launch {
            if (onboardingManager.isOnboardingCompleted.first()) {
                _startDestination.value = StartDestination.MainApp
            } else {
                _startDestination.value = StartDestination.Onboarding
            }
        }
    }

    fun completeOnboarding() {
        viewModelScope.launch {
            onboardingManager.setOnboardingCompleted(true)
            _startDestination.value = StartDestination.MainApp
        }
    }
}

@Immutable
sealed class StartDestination {
    object Onboarding : StartDestination()
    object MainApp : StartDestination()
    object Init : StartDestination()
}