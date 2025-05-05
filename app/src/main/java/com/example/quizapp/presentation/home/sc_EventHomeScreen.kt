package com.example.quizapp.presentation.home

sealed class sc_EventHomeScreen {

    data class SetNumberOfQuizzes(val numberOfQuiz: Int) : sc_EventHomeScreen()
    data class SetQuizCategory(val category: String) : sc_EventHomeScreen()
    data class SetQuizDifficult(val difficulty: String) : sc_EventHomeScreen()
    data class SetQuizType(val type: String) : sc_EventHomeScreen()
}