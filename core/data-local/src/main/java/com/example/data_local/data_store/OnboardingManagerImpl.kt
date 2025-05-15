package com.example.data_local.data_store

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import com.example.domain.data_store.OnboardingManager
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

internal class OnboardingManagerImpl @Inject constructor(private val dataStore: DataStore<Preferences>) :
    OnboardingManager {

    override val isOnboardingCompleted: Flow<Boolean> = dataStore.data.map {
        it[is_onboarding_completed] ?: false
    }


    override suspend fun setOnboardingCompleted(completed: Boolean) {
        dataStore.edit { pref ->
            pref[is_onboarding_completed] = completed
        }
    }

    private companion object {
        val is_onboarding_completed = booleanPreferencesKey("is_onboarding_completed")
    }
}