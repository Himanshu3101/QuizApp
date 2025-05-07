package com.example.quizapp.data.di

import android.content.Context
import androidx.room.Room
import com.example.quizapp.data.local.AppDatabase
import com.example.quizapp.data.local.DAO.UserDao
import com.example.quizapp.data.local.repository.UserRepositoryImpl
import com.example.quizapp.domain.local.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext appContext: Context): AppDatabase =
        Room.databaseBuilder(appContext, AppDatabase::class.java, "user_db").build()

    @Provides
    fun provideUserDao(db: AppDatabase): UserDao = db.userDao()

    @Provides
    fun provideUserRepository(dao: UserDao): UserRepository = UserRepositoryImpl(dao)
}