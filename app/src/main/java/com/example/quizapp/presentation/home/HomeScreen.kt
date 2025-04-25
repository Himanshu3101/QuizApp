package com.example.quizapp.presentation.home

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.quizapp.presentation.common.AppDropDownMenu
import com.example.quizapp.presentation.common.ButtonBox
import com.example.quizapp.presentation.home.component.HomeHeader
import com.example.quizapp.presentation.util.Constants
import com.example.quizapp.presentation.util.Constants.difficulty
import com.example.quizapp.presentation.util.Constants.type
import com.example.quizapp.presentation.util.Dimens.MediumPadding
import com.example.quizapp.presentation.util.Dimens.MediumSpacerHeight
import com.example.quizapp.presentation.util.Dimens.SmallSpacerHeight

@Preview
@Composable
fun PrevHome() {
    HomeScreen(state = DCStateHomeScreen(),
        event = {})
}



@Composable
fun HomeScreen(
    state : DCStateHomeScreen,
    event : (EventHomeScreen) -> Unit
) {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ){
        HomeHeader()

        Spacer(modifier = Modifier.height(MediumSpacerHeight))
        AppDropDownMenu(menuName = "Number of Questions:", menuList = Constants.numberAsString, text = state.numberOfQuiz.toString(), onDropDownClick = {event(EventHomeScreen.SetNumberOfQuizzes(it.toInt()))})

         Spacer(modifier = Modifier.height(SmallSpacerHeight))
         AppDropDownMenu(menuName = "Select Category:", menuList = Constants.categories, text = state.category, onDropDownClick = {event(EventHomeScreen.SetQuizCategory(it))})

         Spacer(modifier = Modifier.height(SmallSpacerHeight))
         AppDropDownMenu(menuName = "Select Difficulty:", menuList = difficulty, text = state.difficulty,onDropDownClick = {event(EventHomeScreen.SetQuizDifficult(it))})

        Spacer(modifier = Modifier.height(SmallSpacerHeight))
        AppDropDownMenu(menuName = "Select Type:", menuList = type, text = state.type, onDropDownClick = {event(EventHomeScreen.SetQuizType(it))})

        Spacer(modifier = Modifier.height(MediumSpacerHeight))

        ButtonBox(text = "Generate Quiz", padding = MediumPadding){
            Log.d("quiz details", "${state.numberOfQuiz} ${state.category} ${state.difficulty} ${state.type}")
        }
    }
}