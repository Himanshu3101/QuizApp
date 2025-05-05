package com.example.quizapp.presentation.User

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class UserViewModel :  ViewModel(){

    private val _userState = MutableStateFlow(DCStateUser())
    val userState = _userState

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
        }
    }
}