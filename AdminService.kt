package com.socialchat.admin

interface AdminService {
    fun listOpenReports(): List<UserReport>
    fun suspendUser(uid: String)
    fun restoreUser(uid: String)
    fun removeContent(contentId: String)
}
