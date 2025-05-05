package com.example.quizapp.presentation.home

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow


class HomeScreenViewModel : ViewModel() {

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
        }
    }
}