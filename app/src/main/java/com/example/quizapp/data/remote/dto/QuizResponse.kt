package com.example.quizapp.data.remote.dto

import com.example.quizapp.domain.remote.model.Quiz



/*we can use Mapper class if Response are too long and having some Unnecessary item. we can remove them from Mapper
 class and show only necessary items in UI by domain -> model-> Quiz class(Model class).*/
data class QuizResponse(
    val response_code: Int,
    val results: List<Quiz>
)