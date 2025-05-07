package com.example.quizapp.presentation.nav_graph

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.quizapp.presentation.User.UserInfo
import com.example.quizapp.presentation.User.UserViewModel
import com.example.quizapp.presentation.home.HomeScreen
import com.example.quizapp.presentation.home.HomeScreenViewModel
import com.example.quizapp.presentation.quiz.QuizScreen
import com.example.quizapp.presentation.quiz.QuizViewModel
import com.example.quizapp.presentation.score.ScoreScreen

@Composable
fun SetNavGraph() {

    val navController = rememberNavController()
    val sharedViewModel : SharedViewModel = hiltViewModel()

    NavHost(navController = navController, startDestination = Routes.UserScreen.route){
        composable(route = Routes.UserScreen.route){
            val viewModel : UserViewModel = hiltViewModel()
            val state by viewModel.userState.collectAsState()
            UserInfo(state = state,
                event = viewModel :: onEvent,
                navController = navController,
                onSaveUser = {
                    sharedViewModel.setUserData(it)
                }
            )
        }


        composable(route = Routes.HomeScreen.route){
            val viewModel : HomeScreenViewModel = hiltViewModel()
            val state by viewModel.homeState.collectAsState()
            HomeScreen(
                state = state,
                event = viewModel :: onEvent,
                navController = navController
            )
        }

        composable(
            route = Routes.QuizScreen.route,
            arguments = listOf(
                navArgument(ARG_KEY_QUIZ_NUMBER){type = NavType.IntType},
                navArgument(ARG_KEY_QUIZ_CATEGORY){type = NavType.StringType},
                navArgument(ARG_KEY_QUIZ_DIFFICULTY){type = NavType.StringType},
                navArgument(ARG_KEY_QUIZ_TYPE){type = NavType.StringType},
            )
        ){
            val numOfQuizzes = it.arguments?.getInt(ARG_KEY_QUIZ_NUMBER)
            val category = it.arguments?.getString(ARG_KEY_QUIZ_CATEGORY)
            val difficult = it.arguments?.getString(ARG_KEY_QUIZ_DIFFICULTY)
            val type = it.arguments?.getString(ARG_KEY_QUIZ_TYPE)

            val quizViewModel : QuizViewModel = hiltViewModel()
            val state by quizViewModel.quizList.collectAsState()
            val user = sharedViewModel.userData.value
            Log.d("setNavGraphLog", user.toString())
            QuizScreen(
                numOfQuiz = numOfQuizzes!!,
                quizCategory = category!!,
                quizDifficulty = difficult!!,
                quizType = type!!,
                event = quizViewModel::onEvent, //Or use Old version -> { quizViewModel.onEvent(it) }
                state = state,
                navController = navController,
//                userInfo = user,
            )
        }


        composable(
            route = Routes.ScoreScreen.route,
            arguments = listOf(
                navArgument(NOQ_KEY) {type = NavType.IntType},
                navArgument(CORRECT_ANS_KEY) {type = NavType.IntType},
            )
        ) {
            val numOfQuestions = it.arguments?.getInt(NOQ_KEY)
            val numOfCorrectAns = it.arguments?.getInt(CORRECT_ANS_KEY)

            ScoreScreen(
                noOfQuestion = numOfQuestions!!,
                noOfCorrectAnswer = numOfCorrectAns!!,
                navController = navController,
            )
        }
    }
}