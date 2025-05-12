package com.example.quizapp.data.local.repository

import android.util.Log
import com.example.quizapp.data.local.DAO.UserDao
import com.example.quizapp.data.local.Entity.UserEntity
import com.example.quizapp.data.local.mapping.toEntity
import com.example.quizapp.domain.local.model.UserSession
import com.example.quizapp.domain.local.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(private val userDao: UserDao) : UserRepository {

    override suspend fun saveUser(userSession: UserSession) : Result<Unit> {
        return try{
            Log.d("UserRepositoryImpl", "Trying to insert: $userSession")
            val id = userDao.insertUser(userSession.toEntity())
            Log.d("UserRepositoryImpl", "Inserted user with id: $id")
            if(id > 0) Result.success(Unit) else Result.failure(Exception("Failed to insert user"))
        }catch(e:Exception){
            Result.failure(e)
        }
    }

    override suspend fun getAllUsers(): List<UserEntity> {
        return userDao.getAllUsers()
    }
}