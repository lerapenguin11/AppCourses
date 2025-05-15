package com.example.courses.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.domain.data_store.OnboardingManager

class MainNavigationViewModelFactory(private val onboardingManager: OnboardingManager) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainNavigationViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MainNavigationViewModel(onboardingManager) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
 }