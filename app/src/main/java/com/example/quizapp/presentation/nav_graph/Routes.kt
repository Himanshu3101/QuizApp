package com.example.quizapp.presentation.nav_graph

const val ARG_KEY_QUIZ_NUMBER = "ak_quiz_number"
const val ARG_KEY_QUIZ_CATEGORY = "ak_quiz_category"
const val ARG_KEY_QUIZ_DIFFICULTY = "ak_quiz_difficulty"
const val ARG_KEY_QUIZ_TYPE = "ak_quiz_type"
const val NOQ_KEY = "noq_key"
const val CORRECT_ANS_KEY = "correct_ans_key"

sealed class Routes (val route:String){

    object HomeScreen : Routes(route = "homeScreen")
    object QuizScreen : Routes(route = "quizScreen/{$ARG_KEY_QUIZ_NUMBER}/{$ARG_KEY_QUIZ_CATEGORY}/{$ARG_KEY_QUIZ_DIFFICULTY}/{$ARG_KEY_QUIZ_TYPE}")

    fun passQuizParams(numOfQuizzes : Int, category : String, difficulty : String, type : String) : String{

        return "quizScreen/{$ARG_KEY_QUIZ_NUMBER}/{$ARG_KEY_QUIZ_CATEGORY}/{$ARG_KEY_QUIZ_DIFFICULTY}/{$ARG_KEY_QUIZ_TYPE}"
            .replace(
                oldValue = "{$ARG_KEY_QUIZ_NUMBER}",
                newValue = numOfQuizzes.toString()
            )
            .replace(
                oldValue = "{$ARG_KEY_QUIZ_CATEGORY}",
                newValue = category
            )
            .replace(
                oldValue = "{$ARG_KEY_QUIZ_DIFFICULTY}",
                newValue = difficulty
            )
            .replace(
                oldValue = "{$ARG_KEY_QUIZ_TYPE}",
                newValue = type
            )
    }

    object ScoreScreen : Routes(route = "score_screen/{$NOQ_KEY}/{$CORRECT_ANS_KEY}"){
        fun passNumOfQuesAndCorrectAnswer(question : Int, correctAnswer : Int) : String{
            return "score_screen/{$NOQ_KEY}/{$CORRECT_ANS_KEY}"
                .replace("{$NOQ_KEY}", question.toString())
                .replace("{$CORRECT_ANS_KEY}", correctAnswer.toString())
        }
    }
}