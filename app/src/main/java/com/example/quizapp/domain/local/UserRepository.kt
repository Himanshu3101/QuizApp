package com.example.quizapp.domain.local

import com.example.quizapp.data.local.Entity.UserEntity
import com.example.quizapp.domain.local.model.UserSession

interface UserRepository {

    suspend fun saveUser(userSession: UserSession) : Result<Unit>
    suspend fun getAllUsers(): List<UserEntity>
}