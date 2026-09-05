package com.socialchat.app.data

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query

class FirebaseChatRepository(
    private val db: FirebaseFirestore = FirebaseFirestore.getInstance()
) : ChatRepository {

    override fun observeMessages(chatId: String, onMessages: (List<Message>) -> Unit) {
        db.collection("chats").document(chatId)
            .collection("messages")
            .orderBy("createdAt", Query.Direction.ASCENDING)
            .addSnapshotListener { snapshot, error ->
                if (error != null || snapshot == null) return@addSnapshotListener
                val messages = snapshot.documents.map { doc ->
                    Message(
                        id = doc.id,
                        senderId = doc.getString("senderId").orEmpty(),
                        text = doc.getString("text").orEmpty(),
                        createdAt = doc.getLong("createdAt") ?: 0L
                    )
                }
                onMessages(messages)
            }
    }

    override suspend fun sendMessage(
        chatId: String,
        senderId: String,
        text: String
    ): Result<Unit> {
        return try {
            val data = mapOf(
                "senderId" to senderId,
                "text" to text,
                "createdAt" to System.currentTimeMillis()
            )
            db.collection("chats").document(chatId)
                .collection("messages").add(data).get()
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
