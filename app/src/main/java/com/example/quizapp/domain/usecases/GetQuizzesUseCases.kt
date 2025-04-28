package com.example.quizapp.domain.usecases

import com.example.quizapp.common.Resources
import com.example.quizapp.domain.model.Quiz
import com.example.quizapp.domain.repository.QuizRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn



//Use case have only one logic.E.g.- if worked with ROOM so we have 4 operation - CURD. So we have 4 use cases.


class GetQuizzesUseCases(
    val quizRepository: QuizRepository
) {

    // without operator invoke function. we have to call class name and function name.
    /*fun getQuizzes(*/

    //Here, we know everytime, class have a same  use cases. So we can use operator invoke function.
    operator fun invoke(
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