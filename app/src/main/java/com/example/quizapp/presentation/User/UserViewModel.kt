package com.example.quizapp.presentation.User

import androidx.lifecycle.ViewModel
import com.example.quizapp.data.session.QuizSessionManager
import com.example.quizapp.domain.local.SessionManager
import com.example.quizapp.domain.local.model.UserSession
import com.example.quizapp.presentation.quiz.dc_StateQuizScreen
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val sessionManager: SessionManager
):  ViewModel(){

    private val _userState = MutableStateFlow(DCStateUser())
    val userState = _userState

//    val state = quizSessionManager.session

    fun onEvent(event : EventUserScreen){
        when(event){
            is EventUserScreen.SetUserName -> {
                _userState.value = userState.value.copy(userName = event.userName)
            }
            is EventUserScreen.SetCity ->{
                _userState.value = userState.value.copy(city = event.city)
            }
            is EventUserScreen.SetOccupation -> {
                _userState.value = userState.value.copy(occupation = event.occupation)
            }
            is EventUserScreen.SaveUserInfo -> {
                sessionManager.updateSession {
                    copy(
                        userName = userState.value.userName,
                        occupation = userState.value.occupation,
                        city = userState.value.city
                    )
                }

            }
        }
    }
}