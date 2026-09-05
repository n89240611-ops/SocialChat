# Firestore model

users/{uid}
- displayName
- email
- phone
- photoUrl
- online
- lastSeen
- createdAt

chats/{chatId}
- members: [uid1, uid2]
- lastMessage
- updatedAt

chats/{chatId}/messages/{messageId}
- senderId
- text
- createdAt
- type
