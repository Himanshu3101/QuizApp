package com.example.quizapp

import android.app.Application
import android.util.Log
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class QuizApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Log.d("QuizApp", "Application started")
    }
}