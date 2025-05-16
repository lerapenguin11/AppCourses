package com.example.auth.presentation

sealed class LoginSingleEvents {
    data object SuccessLogin: LoginSingleEvents()
}