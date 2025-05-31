package com.example.quizapp.domain.usecases

import com.example.quizapp.data.local.Entity.UserEntity
import com.example.quizapp.domain.local.UserRepository
import com.example.quizapp.domain.local.model.UserSession
import javax.inject.Inject

class DBGetUseCases @Inject constructor(private val repository: UserRepository) {

    suspend operator fun invoke(): List<UserEntity> {
        return repository.getAllUsers()
    }

}