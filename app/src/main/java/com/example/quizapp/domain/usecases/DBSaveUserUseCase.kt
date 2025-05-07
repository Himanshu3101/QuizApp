package com.example.quizapp.domain.usecases

import com.example.quizapp.domain.local.User
import com.example.quizapp.domain.local.UserRepository
import javax.inject.Inject

class DBSaveUserUseCase @Inject constructor(private val repository: UserRepository) {

    suspend operator fun invoke(user: User): Result<Unit> {
        return repository.saveUser(user)
    }

}