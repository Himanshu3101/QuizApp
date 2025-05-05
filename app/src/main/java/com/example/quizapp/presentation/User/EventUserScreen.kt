package com.example.quizapp.presentation.User

sealed class EventUserScreen {
    data class SetUserName(val userName: String) : EventUserScreen()
    data class SetOccupation(val occupation: String) : EventUserScreen()
    data class SetCity(val city: String) : EventUserScreen()
}