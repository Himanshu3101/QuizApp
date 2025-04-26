package com.example.quizapp.domain.usecases

import com.example.quizapp.common.Resources
import com.example.quizapp.domain.model.Quiz
import com.example.quizapp.domain.repository.QuizRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class GetQuizzesUseCases(
    val quizRepository: QuizRepository
) {
    fun gtQuizzes(
        amount:Int,
        category:Int,
        difficulty:String,
        type:String
    ) : Flow<Resources<List<Quiz>>> = flow {

        emit(Resources.Loading())

        try{
            emit(Resources.Success(data = quizRepository.getQuizzes(amount,category, difficulty, type)))
        }catch (e : Exception){
            emit(Resources.Error(message = e.message.toString()))
        }


    }.flowOn(Dispatchers.IO)
}