package com.example.quizapp.domain.local

interface UserRepository {

    suspend fun saveUser(user: User) : Result<Unit>
}