package com.example.quizapp.domain.remote.repository

import com.example.quizapp.domain.remote.model.Quiz

interface QuizRepository {

    suspend fun getQuizzes(amount:Int, category:Int, difficulty:String, type:String ) : List<Quiz>
}