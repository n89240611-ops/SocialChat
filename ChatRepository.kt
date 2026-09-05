package com.socialchat.app.data

data class Message(
    val id: String = "",
    val senderId: String = "",
    val text: String = "",
    val createdAt: Long = 0L
)

interface ChatRepository {
    fun observeMessages(chatId: String, onMessages: (List<Message>) -> Unit)
    suspend fun sendMessage(chatId: String, senderId: String, text: String): Result<Unit>
}
