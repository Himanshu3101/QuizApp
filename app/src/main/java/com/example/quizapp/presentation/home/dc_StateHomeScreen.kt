package com.example.quizapp.presentation.home

data class dc_StateHomeScreen(
    val numberOfQuiz : Int = 10,
    val category : String = "General Knowledge",
    val difficulty : String = "Easy",
    val type : String = "Multiple Choice"
)
