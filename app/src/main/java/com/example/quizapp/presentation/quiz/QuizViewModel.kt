package com.example.quizapp.presentation.quiz

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.quizapp.common.Resources
import com.example.quizapp.domain.usecases.GetQuizzesUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


//on Video for Data and Domain layer - recap On 1:59:00 - https://www.youtube.com/watch?v=WYHuLJVEaLc

@HiltViewModel
class QuizViewModel @Inject constructor(private val getQuizzesUseCases: GetQuizzesUseCases) : ViewModel() {

    private val _quizList = MutableStateFlow(StateQuizScreen())
    val quizList = _quizList.asStateFlow()

    fun onEvent(event: EventQuizScreen){
        when(event) {
            is EventQuizScreen.GetQuizzes -> {
                getQuizzes(event.numOfQuizzes, event.category, event.difficulty, event.type)
            }

            else -> {}
        }
    }

    private fun getQuizzes(amount: Int, category: Int, difficulty: String, type: String){
        viewModelScope.launch {

            // With class name & function - we have to call class name and function name.
            /*getQuizzesUseCases.getQuizzes(amount, category, difficulty, type).collect{resources ->*/

            // With invoke function - we can directly call
            getQuizzesUseCases(amount, category, difficulty, type).collect { resources ->
                when (resources) {
                    is Resources.Loading -> {
                        _quizList.value = StateQuizScreen(isLoading = true)
                    }

                    is Resources.Success -> {
                        for (quiz in resources.data!!) {
                            Log.d("quiz", quiz.toString())
                        }
                        _quizList.value = StateQuizScreen(data = resources.data)
                    }

                    is Resources.Error -> {
                        _quizList.value = StateQuizScreen(error = resources.message.toString())
                    }

                    else ->{}
                }
            }
        }
    }
}