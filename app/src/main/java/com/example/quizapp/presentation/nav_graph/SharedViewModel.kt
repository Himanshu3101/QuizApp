package com.example.quizapp.presentation.nav_graph

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.quizapp.presentation.User.DCStateUser
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SharedViewModel @Inject constructor()  : ViewModel() {

    private val _userData = mutableStateOf(DCStateUser())
    val userData: State<DCStateUser> = _userData

    fun setUserData(user : DCStateUser){
        _userData.value = user
    }

}