package com.socialchat.admin

enum class AdminAction {
    VIEW_REPORTS, SUSPEND_USER, RESTORE_USER, REMOVE_CONTENT, VIEW_METRICS
}

data class UserReport(
    val reportId: String,
    val reporterId: String,
    val targetUserId: String,
    val reason: String,
    val status: String = "open"
)

data class AdminRole(
    val isAdmin: Boolean = false,
    val canModerate: Boolean = false
)
