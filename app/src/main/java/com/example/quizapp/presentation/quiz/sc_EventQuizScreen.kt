package com.example.quizapp.presentation.quiz

import com.example.quizapp.domain.local.User

sealed class sc_EventQuizScreen {
    data class GetQuizzes(val numOfQuizzes: Int, val category: Int, val difficulty: String, val type: String) : sc_EventQuizScreen()

    data class SetOptionSelected(val quizStateIndex: Int, val selectedOption: Int) : sc_EventQuizScreen()

    data class userSavedDB(val user: User) : sc_EventQuizScreen()
}