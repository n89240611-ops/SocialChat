package com.socialchat.app.data

/**
 * Firebase Authentication contract.
 * Implement with Firebase Auth after google-services.json is added.
 */
interface AuthService {
    suspend fun signInWithEmail(email: String, password: String): Result<String>
    suspend fun signUpWithEmail(email: String, password: String): Result<String>
    fun startPhoneOtp(phone: String, onCodeSent: (String) -> Unit, onError: (Exception) -> Unit)
}
