package com.socialchat.app.features

data class ChatNotification(
    val title: String,
    val body: String,
    val chatId: String
)

interface NotificationService {
    fun registerDeviceToken(uid: String)
    fun showChatNotification(notification: ChatNotification)
}
