package com.socialchat.app.ui

/**
 * Temporary status screen/state until a real Firebase project is connected.
 */
data class BackendStatus(
    val firebaseConnected: Boolean = false,
    val authenticationReady: Boolean = true,
    val chatReady: Boolean = true
)
