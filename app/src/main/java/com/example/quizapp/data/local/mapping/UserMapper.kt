package com.example.quizapp.data.local.mapping

import com.example.quizapp.data.local.Entity.UserEntity
import com.example.quizapp.domain.local.model.UserSession

fun UserEntity.toDomain(): UserSession {
    return UserSession(
        userName = userName,
        occupation = occupation,
        city = city,
        noOfQuestion = numberOfQuiz,
        category = category,
        difficulty = difficulty,
        type = type,
        noOfCorrectAnswer = correctAnswer,
        scorePercentage = scorePercentage
    )
}

fun UserSession.toEntity() : UserEntity{
    return UserEntity(
        userName = userName,
        occupation = occupation,
        city = city,
        numberOfQuiz = noOfQuestion,
        category = category,
        difficulty = difficulty,
        type = type,
        correctAnswer = noOfCorrectAnswer,
        scorePercentage = scorePercentage
    )
}