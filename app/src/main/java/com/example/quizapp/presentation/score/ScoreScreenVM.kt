package com.example.quizapp.presentation.score

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.quizapp.data.session.QuizSessionManager
import com.example.quizapp.domain.local.SessionManager
import com.example.quizapp.domain.local.model.UserSession
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class ScoreScreenVM @Inject constructor(
    private val sessionManager: SessionManager
) : ViewModel() {

    private val _scoreScreenData = MutableStateFlow(dc_ScoreScreen())
    val scoreScreenData = _scoreScreenData

    fun onEvent(event : SC_EventScoreScreen){
        when(event){
            is SC_EventScoreScreen.saveNoOfQuestion -> {
                _scoreScreenData.value = scoreScreenData.value.copy(noOfQuestion = event.noOfQuestion)
            }
            is SC_EventScoreScreen.saveNoCorrect -> {
                _scoreScreenData.value = scoreScreenData.value.copy(noOfCorrectAnswer = event.noOfCorrectAnswer)
            }
            is SC_EventScoreScreen.savePercentage -> {
                _scoreScreenData.value = scoreScreenData.value.copy(scorePercentage = event.scorePercentage)
            }
            is SC_EventScoreScreen.SaveScore -> {
                sessionManager.updateSession {
                    copy(
                        noOfCorrectAnswer = scoreScreenData.value.noOfCorrectAnswer,
                        noOfQuestion = scoreScreenData.value.noOfQuestion,
                        scorePercentage = scoreScreenData.value.scorePercentage
                    )
                }
                Log.d("ScoreScreenVM", "Score saved: ${sessionManager.session}")
            }
        }
    }
}