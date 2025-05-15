package com.example.domain.data_store

import kotlinx.coroutines.flow.Flow

interface OnboardingManager {

    val isOnboardingCompleted: Flow<Boolean>
    suspend fun setOnboardingCompleted(completed: Boolean)
}