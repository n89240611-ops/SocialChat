package com.socialchat.app.features

enum class SafetyAction { BLOCK, UNBLOCK, REPORT }

data class SafetyRecord(
    val actorUid: String = "",
    val targetUid: String = "",
    val action: SafetyAction = SafetyAction.REPORT,
    val reason: String = "",
    val createdAt: Long = 0L
)
