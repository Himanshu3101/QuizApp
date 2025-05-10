package com.example.quizapp.domain.local

import com.example.quizapp.domain.local.model.UserSession

interface SessionManager {
    val session: UserSession
    fun updateSession(update : UserSession.()-> UserSession)
    fun clearSession()
}