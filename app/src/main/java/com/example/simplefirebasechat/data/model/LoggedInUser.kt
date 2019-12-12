package com.example.simplefirebasechat.data.model

import java.io.Serializable

/**
 * Data class that captures user information for logged in users retrieved from LoginRepository
 */
data class LoggedInUser(
    val userId: String,
    val displayName: String,
    val uid: String,
    val email: String,
    val isAuthenticated: Boolean
) : Serializable
