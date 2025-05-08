package com.example.quizapp.domain.usecases

import com.example.quizapp.domain.local.model.UserSession
import com.example.quizapp.domain.local.UserRepository
import javax.inject.Inject

class DBSaveUserUseCase @Inject constructor(private val repository: UserRepository) {

    suspend operator fun invoke(userSession: UserSession): Result<Unit> {
        return repository.saveUser(userSession)
    }

}