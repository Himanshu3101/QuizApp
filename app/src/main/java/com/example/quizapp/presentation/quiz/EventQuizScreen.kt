package com.example.quizapp.presentation.quiz

sealed class EventQuizScreen {
    data class GetQuizzes(val numOfQuizzes: Int, val category: Int, val difficulty: String, val type: String) : EventQuizScreen()
}