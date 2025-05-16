package com.example.auth.ui.model

import com.example.auth.presentation.LoginValidationKeys

data class LoginContentUi(
    val email: String = "",
    val password: String = "",
    val error: Map<LoginValidationKeys, Int> = emptyMap(),
)
