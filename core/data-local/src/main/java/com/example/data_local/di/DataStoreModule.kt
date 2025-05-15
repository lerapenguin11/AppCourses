package com.example.data_local.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.core.handlers.ReplaceFileCorruptionHandler
import androidx.datastore.preferences.SharedPreferencesMigration
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.preferencesDataStoreFile
import com.example.data_local.data_store.OnboardingManagerImpl
import com.example.domain.data_store.OnboardingManager
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import javax.inject.Singleton

@Module
internal interface DataStoreModule {

    companion object {
        private const val dataStorePreferences = "data_store_preferences"

        @Singleton
        @Provides
        fun providePreferencesDataStore(appContext: Context): DataStore<Preferences> {
            return PreferenceDataStoreFactory.create(
                corruptionHandler = ReplaceFileCorruptionHandler(
                    produceNewData = { emptyPreferences() }
                ),
                migrations = listOf(SharedPreferencesMigration(appContext, dataStorePreferences)),
                scope = CoroutineScope(Dispatchers.IO + SupervisorJob()),
                produceFile = { appContext.preferencesDataStoreFile(dataStorePreferences) }
            )
        }

        @Singleton
        @Provides
        fun provideOnboardingManagerDataStore(dataStore: DataStore<Preferences>): OnboardingManager {
            return OnboardingManagerImpl(dataStore = dataStore)
        }
    }
}