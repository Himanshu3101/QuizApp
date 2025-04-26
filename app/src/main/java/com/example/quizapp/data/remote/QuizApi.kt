package com.example.quizapp.data.remote

import retrofit2.http.GET

interface QuizApi {

    @GET
    suspend fun getQuizzes()
}
