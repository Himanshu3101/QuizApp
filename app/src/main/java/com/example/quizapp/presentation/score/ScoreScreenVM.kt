package com.example.quizapp.presentation.score

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quizapp.domain.local.SessionManager
import com.example.quizapp.domain.local.model.UserSession
import com.example.quizapp.domain.usecases.DBSaveUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ScoreScreenVM @Inject constructor(
    private val sessionManager: SessionManager,
    private val dbSaveUserUseCase: DBSaveUserUseCase
) : ViewModel() {

    private val _scoreScreenData = MutableStateFlow(dc_ScoreScreen())
    val scoreScreenData = _scoreScreenData

    private val _saveResult = MutableStateFlow<Result<Unit>?>(null)
    val saveResult: StateFlow<Result<Unit>?> = _saveResult


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
                saveUser(sessionManager.session)
                Log.d("ScoreScreenVM", "Score saved: ${sessionManager.session}")
            }
        }
    }

    private fun saveUser(session: UserSession) {
        viewModelScope.launch(Dispatchers.IO) {
            val result = dbSaveUserUseCase(session)
            _saveResult.value = result
        }
    }
}