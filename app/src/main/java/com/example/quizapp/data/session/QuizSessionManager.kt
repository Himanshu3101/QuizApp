package com.example.quizapp.data.session

import android.content.Context
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.example.quizapp.domain.local.SessionManager
import com.example.quizapp.domain.local.model.UserSession
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class QuizSessionManager @Inject constructor(@ApplicationContext private val context: Context) : SessionManager{

    override var session : UserSession by mutableStateOf(UserSession())

    override fun updateSession(update : UserSession.()-> UserSession ){
            session = session.update()
    }

    override fun clearSession(){
        session = UserSession()
    }

}