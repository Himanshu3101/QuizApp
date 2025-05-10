package com.example.quizapp.domain.di

import com.example.quizapp.data.session.QuizSessionManager
import com.example.quizapp.domain.local.SessionManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SessionModule {

    @Provides
    @Singleton
    fun provideSessionManager(quizSessionManager: QuizSessionManager): SessionManager = quizSessionManager
}