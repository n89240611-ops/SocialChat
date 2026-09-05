package com.socialchat.app.features

data class UserProfile(
    val uid: String = "",
    val displayName: String = "",
    val email: String = "",
    val phone: String = "",
    val photoUrl: String = "",
    val online: Boolean = false,
    val lastSeen: Long = 0L
)
