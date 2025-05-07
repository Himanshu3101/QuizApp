package com.example.quizapp.data.local.repository

import com.example.quizapp.data.local.DAO.UserDao
import com.example.quizapp.data.local.mapping.toEntity
import com.example.quizapp.domain.local.User
import com.example.quizapp.domain.local.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(private val userDao: UserDao) : UserRepository {

    override suspend fun saveUser(user: User) : Result<Unit> {
        return try{
            val id = userDao.insertUser(user.toEntity())
            if(id > 0) Result.success(Unit) else Result.failure(Exception("Failed to insert user"))
        }catch(e:Exception){
            Result.failure(e)
        }
    /*userDao.insertUser(user.toEntity())*/
    }
}