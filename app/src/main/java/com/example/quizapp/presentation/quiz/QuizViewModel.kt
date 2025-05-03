package com.example.quizapp.presentation.quiz

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quizapp.common.Resources
import com.example.quizapp.domain.model.Quiz
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
            is EventQuizScreen.SetOptionSelected -> {
                updateQuizStateList(event.quizStateIndex, event.selectedOption)
            }

            else -> {}
        }
    }

    private fun updateQuizStateList(quizStateIndex: Int, selectedOption: Int) {
        val updateQuizStateList = mutableListOf<QuizState>()
        quizList.value.quizState.forEachIndexed { index, quizState ->
            updateQuizStateList.add(
                if(index == quizStateIndex){
                    quizState.copy(selectedOption = selectedOption)
                }
                else quizState
            )
        }
        _quizList.value = quizList.value.copy(quizState = updateQuizStateList)

        updateScore(_quizList.value.quizState[quizStateIndex])
    }

    private fun updateScore(quizState: QuizState) {
        val correctAnswer = quizState.quiz?.correct_answer
        val selectedAnswer = quizState.selectedOption?.let{
            quizState.shuffledOptions[it].replace("&quot;", "\"").replace("&#039;", "\'")
        }
        Log.d("checkLog", "$correctAnswer -> $selectedAnswer")
        if(correctAnswer == selectedAnswer){
            val previousScore = quizList.value.score
            _quizList.value = quizList.value.copy(score = previousScore + 1)
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
                        val listOfQuizState : List<QuizState> = getListOfQuizState(resources.data)
                        _quizList.value = StateQuizScreen(quizState = listOfQuizState)
                    }

                    is Resources.Error -> {
                        _quizList.value = StateQuizScreen(error = resources.message.toString())
                    }

                    else ->{}
                }
            }
        }
    }

    private fun getListOfQuizState(data: List<Quiz>?): List<QuizState> {

        val listOfQuizState = mutableListOf<QuizState>()

        for(quiz in data!!){
            val shuffleOption = mutableListOf<String>().apply{
                add(quiz.correct_answer)
                addAll(quiz.incorrect_answers)
                shuffle()
            }
            listOfQuizState.add(QuizState(quiz, shuffleOption, -1))
        }
        return listOfQuizState
    }
}