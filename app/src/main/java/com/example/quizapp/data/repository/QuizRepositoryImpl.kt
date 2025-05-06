package com.example.quizapp.data.repository

import com.example.quizapp.data.remote.QuizApi
import com.example.quizapp.domain.remote.model.Quiz
import com.example.quizapp.domain.remote.repository.QuizRepository

class QuizRepositoryImpl( private val quizApi: QuizApi) : QuizRepository {

    override suspend fun getQuizzes(
        amount: Int,
        category: Int,
        difficulty: String,
        type: String
    ): List<Quiz> {
        return quizApi.getQuizzes(amount, category, difficulty, type).results
    }
}