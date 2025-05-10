package com.example.quizapp.presentation.score

sealed class SC_EventScoreScreen {
    data class saveNoOfQuestion(val noOfQuestion: Int) : SC_EventScoreScreen()
    data class saveNoCorrect(val noOfCorrectAnswer: Int) : SC_EventScoreScreen()
    data class savePercentage(val scorePercentage: Int) : SC_EventScoreScreen()
    object SaveScore : SC_EventScoreScreen()
}