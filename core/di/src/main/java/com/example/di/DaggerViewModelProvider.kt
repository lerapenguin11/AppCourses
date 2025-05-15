package com.example.di

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisallowComposableCalls
import androidx.compose.runtime.remember
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

class DaggerViewModelProvider {

    companion object {
        @Composable
        @Suppress("unchecked_cast")
        inline fun <reified VM : ViewModel> daggerViewModel(
            key: String? = null,
            crossinline viewModelInstanceCreator: @DisallowComposableCalls (handle: SavedStateHandle) -> VM
        ): VM {
            val factory = remember(key) {
                object : AbstractSavedStateViewModelFactory() {
                    override fun <VM : ViewModel> create(
                        key: String,
                        modelClass: Class<VM>,
                        handle: SavedStateHandle
                    ): VM {
                        return viewModelInstanceCreator(handle) as VM
                    }
                }
            }
            return viewModel(key = key, factory = factory)
        }
    }
}