package com.example.quizapp.domain.local

data class User(
    val id: Int = 0,
    val name: String = "",
    val occupation: String = "",
    val city: String = "",

    val correctAnswer: Int = 0,
    val incorrectAnswers: Int = 0,
    val percentage: Double = 0.0,

    val noOfQuestion: Int = 0,
    val category: String = "",
    val difficulty: String = "",
    val type: String = "",
)