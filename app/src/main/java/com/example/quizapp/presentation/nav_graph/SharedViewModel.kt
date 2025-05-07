package com.example.quizapp.presentation.nav_graph

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
//import com.example.quizapp.presentation.User.DCStateUser
import com.example.quizapp.presentation.quiz.dc_StateQuizScreen
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SharedViewModel @Inject constructor()  : ViewModel() {

    private val _userData = mutableStateOf(dc_StateQuizScreen())
    val userData: State<dc_StateQuizScreen> = _userData

    fun setUserData(user : dc_StateQuizScreen){
        _userData.value = user

        Log.d("SharedViewModelLog", _userData.toString())
    }

}