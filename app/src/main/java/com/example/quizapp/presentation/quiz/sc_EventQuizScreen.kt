package com.example.quizapp.presentation.quiz

//For the Event
sealed class sc_EventQuizScreen {
    data class GetQuizzes(val numOfQuizzes: Int, val category: Int, val difficulty: String, val type: String) : sc_EventQuizScreen()

    data class SetOptionSelected(val quizStateIndex: Int, val selectedOption: Int) : sc_EventQuizScreen()

//    object saveScoreInfo : sc_EventQuizScreen()
//    data class userSavedDB(val user: User) : sc_EventQuizScreen()
}