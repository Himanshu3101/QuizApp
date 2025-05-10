package com.example.quizapp.domain.local.model

data class UserSession(
    val userName: String = "",
    val occupation: String = "",
    val city: String = "",

    val noOfCorrectAnswer: Int = 0,
    val scorePercentage: Int = 0,

    val noOfQuestion: Int = 0,
    val category: String = "",
    val difficulty: String = "",
    val type: String = "",
)