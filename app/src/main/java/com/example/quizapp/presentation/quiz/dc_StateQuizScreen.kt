package com.example.quizapp.presentation.quiz

import com.example.quizapp.domain.remote.model.Quiz
//For the State of Quiz Screen
data class dc_StateQuizScreen(
    val isLoading : Boolean = false,
    val quizState : List<QuizState>  = emptyList(),
    val error : String = "",
    val score : Int = 0,


    val userName : String = "",
    val occupation : String = "",
    val city : String = "",
)

data class QuizState(
    val quiz : Quiz?= null,
    val shuffledOptions : List<String> = emptyList(),
    val selectedOption : Int ?= -1
)
