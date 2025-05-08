package com.example.quizapp.presentation.home

import androidx.lifecycle.ViewModel
import com.example.quizapp.data.session.QuizSessionManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val quizSessionManager: QuizSessionManager
) : ViewModel() {

    private val _homeState = MutableStateFlow(dc_StateHomeScreen())
    val homeState = _homeState

    fun onEvent(event : sc_EventHomeScreen){
        when(event){
            is sc_EventHomeScreen.SetNumberOfQuizzes -> {
                    _homeState.value = homeState.value.copy(numberOfQuiz = event.numberOfQuiz)
            }
            is sc_EventHomeScreen.SetQuizCategory -> {
                    _homeState.value = homeState.value.copy(category = event.category)
            }
            is sc_EventHomeScreen.SetQuizDifficult ->{
                _homeState.value = homeState.value.copy(difficulty = event.difficulty)
            }
            is sc_EventHomeScreen.SetQuizType -> {
                _homeState.value = homeState.value.copy(type = event.type)
            }
            is sc_EventHomeScreen.saveGenerateQuiz ->{
                quizSessionManager.updateSession {
                    copy(
                        noOfQuestion = homeState.value.numberOfQuiz,
                        category = homeState.value.category,
                        difficulty = homeState.value.difficulty,
                        type = homeState.value.type
                    )
                }
            }
        }
    }
}