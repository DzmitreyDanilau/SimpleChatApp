package com.example.simplefirebasechat.presentation.ui.fragments.emailloginfragment

/**
 * Authentication result : success (user details) or error message.
 */
data class LoginResult(
    val success: LoggedInUserView? = null,
    val error: Int? = null
)
