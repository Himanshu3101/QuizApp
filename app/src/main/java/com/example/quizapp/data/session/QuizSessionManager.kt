package com.example.quizapp.data.session

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.example.quizapp.domain.local.model.UserSession

class QuizSessionManager {

    var session : UserSession by mutableStateOf(UserSession())

    fun updateSession(update : UserSession.()-> UserSession ){
            session = session.update()
    }

    fun clearSession(){
        session = UserSession()
    }

}