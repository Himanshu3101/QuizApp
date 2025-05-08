package com.example.quizapp.presentation.nav_graph

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.quizapp.domain.local.model.UserSession
//import com.example.quizapp.presentation.User.DCStateUser
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SharedViewModel @Inject constructor()  : ViewModel() {

    private val _userSessionData = mutableStateOf(UserSession())
    val userSessionData: State<UserSession> = _userSessionData

    fun setUserData(userSession: UserSession){
        _userSessionData.value = userSession

        Log.d("SharedViewModelLog", _userSessionData.toString())
    }

}