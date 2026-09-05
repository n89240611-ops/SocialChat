package com.socialchat.app.data

import com.google.firebase.auth.FirebaseAuth

class FirebaseAuthService(
    private val auth: FirebaseAuth = FirebaseAuth.getInstance()
) : AuthService {

    override suspend fun signInWithEmail(email: String, password: String): Result<String> =
        try {
            val result = auth.signInWithEmailAndPassword(email, password).get()
            Result.success(result.user?.uid ?: error("No user returned"))
        } catch (e: Exception) {
            Result.failure(e)
        }

    override suspend fun signUpWithEmail(email: String, password: String): Result<String> =
        try {
            val result = auth.createUserWithEmailAndPassword(email, password).get()
            Result.success(result.user?.uid ?: error("No user returned"))
        } catch (e: Exception) {
            Result.failure(e)
        }

    override fun startPhoneOtp(
        phone: String,
        onCodeSent: (String) -> Unit,
        onError: (Exception) -> Unit
    ) {
        // PhoneAuthProvider requires an Activity and verification callbacks.
        // Wire this from the Compose login screen in the next UI integration pass.
        onError(UnsupportedOperationException(
            "Phone OTP UI callback wiring is pending in the login screen."
        ))
    }
}
