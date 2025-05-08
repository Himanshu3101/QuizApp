package com.example.quizapp.data.local.mapping

import com.example.quizapp.data.local.Entity.UserEntity
import com.example.quizapp.domain.local.model.UserSession

fun UserEntity.toDomain(): UserSession {
    return UserSession(
        name = userName,
        occupation = occupation,
        city = city,
        noOfQuestion = numberOfQuiz,
        category = category,
        difficulty = difficulty,
        type = type,
        correctAnswer = correctAnswer,
        incorrectAnswers = incorrectAnswers,
        percentage = score
    )
}

fun UserSession.toEntity() : UserEntity{
    return UserEntity(
        userName = name,
        occupation = occupation,
        city = city,
        numberOfQuiz = noOfQuestion,
        category = category,
        difficulty = difficulty,
        type = type,
        correctAnswer = correctAnswer,
        incorrectAnswers = incorrectAnswers,
        score = percentage
    )
}