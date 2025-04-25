package com.example.quizapp.presentation.home

sealed class EventHomeScreen {

    data class SetNumberOfQuizzes(val numberOfQuiz: Int) : EventHomeScreen()
    data class SetQuizCategory(val category: String) : EventHomeScreen()
    data class SetQuizDifficult(val difficulty: String) : EventHomeScreen()
    data class SetQuizType(val type: String) : EventHomeScreen()
}