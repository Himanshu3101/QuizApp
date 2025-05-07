package com.example.quizapp.data.local.mapping

import com.example.quizapp.data.local.Entity.UserEntity
import com.example.quizapp.domain.local.User

fun UserEntity.toDomain(): User {
    return User(
        id = id,
        name = name,
        occupation = occupation,
        city = city,
        noOfQuestion = noOfQuestion,
        category = category,
        difficulty = difficulty,
        type = type,
        correctAnswer = correctAnswer,
        incorrectAnswers = incorrectAnswers,
        percentage = percentage
    )
}

fun User.toEntity() : UserEntity{
    return UserEntity(
        id = id,
        name = name,
        occupation = occupation,
        city = city,
        noOfQuestion = noOfQuestion,
        category = category,
        difficulty = difficulty,
        type = type,
        correctAnswer = correctAnswer,
        incorrectAnswers = incorrectAnswers,
        percentage = percentage
    )
}