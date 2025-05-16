package com.example.auth.presentation

import androidx.lifecycle.ViewModel
import com.example.auth.R
import com.example.auth.ui.AuthScreenType
import com.example.auth.ui.model.LoginContentUi
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update

class AuthViewModel : ViewModel() {

    private val _screenType: MutableStateFlow<AuthScreenType> =
        MutableStateFlow(AuthScreenType.Registration)
    val screenType: StateFlow<AuthScreenType> = _screenType.asStateFlow()

    private val _loginContentUi: MutableStateFlow<LoginContentUi> =
        MutableStateFlow(LoginContentUi())
    val loginContentUi: StateFlow<LoginContentUi> = _loginContentUi.asStateFlow()

    private val _singleEvents: Channel<LoginSingleEvents> = Channel()
    val singleEvents = _singleEvents.receiveAsFlow()

    fun updateScreenType(screenType: AuthScreenType) {
        _screenType.update { screenType }
    }

    fun updateEmail(email: String) {
        _loginContentUi.update {
            it.copy(email = email)
        }
        removeValidationError(key = LoginValidationKeys.Email)
    }

    fun updatePassword(password: String) {
        _loginContentUi.update {
            it.copy(password = password)
        }
        removeValidationError(key = LoginValidationKeys.Password)
    }

    fun validateForm() {
        checkEmailValidate(email = _loginContentUi.value.email)
        checkPasswordValidate(password = _loginContentUi.value.password)
        if (_loginContentUi.value.error.isEmpty()) {
            _singleEvents.trySend(LoginSingleEvents.SuccessLogin)
        }
    }

    private fun isValidEmail(email: String, addValidationError: () -> Unit): Boolean {
        val emailRegex = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+".toRegex()

        if (!email.matches(emailRegex)) {
            addValidationError()
            return false
        }
        return true
    }

    private fun checkPasswordValidate(password: String) {
        if (password.isBlank()) {
            addValidationError(
                key = LoginValidationKeys.Password,
                value = R.string.error_empty_field,
            )
        }
    }

    private fun checkEmailValidate(email: String) {
        if (email.isBlank()) {
            addValidationError(
                key = LoginValidationKeys.Email,
                value = R.string.error_empty_field,
            )
        } else {
            isValidEmail(
                email = email,
                addValidationError = {
                    addValidationError(
                        key = LoginValidationKeys.Email,
                        value = R.string.error_mask_email,
                    )
                }
            )
        }
    }

    private fun addValidationError(key: LoginValidationKeys, value: Int) {
        val newErrors = _loginContentUi.value.error.toMutableMap()
        newErrors[key] = value
        _loginContentUi.update { it.copy(error = newErrors) }
    }

    private fun removeValidationError(key: LoginValidationKeys) {
        _loginContentUi.update {
            val errors = it.error.toMutableMap()
            errors.remove(key)
            it.copy(error = errors)
        }
    }
}