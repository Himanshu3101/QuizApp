package com.example.quizapp.presentation.quiz

import androidx.lifecycle.ViewModel
import com.example.quizapp.domain.usecases.GetQuizzesUseCases
import javax.inject.Inject

class QuizViewModel @Inject constructor(private val getQuizzesUseCases: GetQuizzesUseCases) : ViewModel() {
}