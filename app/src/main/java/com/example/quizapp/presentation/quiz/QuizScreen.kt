package com.example.quizapp.presentation.quiz

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.quizapp.R
import com.example.quizapp.presentation.common.ButtonBox
import com.example.quizapp.presentation.common.QuizAppBar
import com.example.quizapp.presentation.quiz.component.QuizInterface
import com.example.quizapp.presentation.util.Constants
import com.example.quizapp.presentation.util.Dimens
import com.example.quizapp.presentation.util.Dimens.LargeSpacerHeight
import com.example.quizapp.presentation.util.Dimens.MediumCornerRadius


/*TODO("We can implement sharedViewModel logic here bcoz we need same data from home screen but here,
   we need only 3. So, we can use shared View Model but here we are passing data directly.")*/
@Preview
@Composable
fun PrevQuiz(){
    QuizScreen(
        numOfQuiz = 10,
        quizCategory = "General Knowledge",
        quizDifficulty = "Medium",
        quizType = "Multiple Choice",
        event = {},
        state = StateQuizScreen()
    )
}

@Composable
fun QuizScreen (
    numOfQuiz: Int,
    quizCategory: String,
    quizDifficulty: String,
    quizType : String,
    event : (EventQuizScreen) -> Unit,
    state : StateQuizScreen
) {

    LaunchedEffect(key1 = Unit) {
        val difficulty = when (quizDifficulty){
            "Medium" -> "medium"
            "Hard" -> "hard"
            else -> "easy"

        }
        val type = when(quizType){
            "Multiple Choice" -> "multiple"
            else -> "boolean"
        }

        event(EventQuizScreen.GetQuizzes(numOfQuiz, Constants.categoriesMap[quizCategory]!!, difficulty, type))
    }

    Column(
        modifier = Modifier.fillMaxSize()
    ){
        QuizAppBar(quizCategory = quizCategory){

        }

        Column(
            modifier = Modifier
                .padding(Dimens.VerySmallPadding)
                .fillMaxSize()
        ){
            Spacer(modifier = Modifier.height(LargeSpacerHeight))

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Text(
                    text = "Questions : $numOfQuiz",
                    color = colorResource(R.color.blue_grey)
                )
                Text(
                    text = quizDifficulty,
                    color = colorResource(R.color.blue_grey)
                )
            }
            Spacer(modifier = Modifier.height(Dimens.SmallSpacerHeight))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(Dimens.VerySmallViewHeight)
                    .clip(RoundedCornerShape(MediumCornerRadius))
                    .background(color = colorResource(R.color.blue_grey))
            )

            Spacer(modifier = Modifier.height(LargeSpacerHeight))

            //QuizUI
           QuizInterface(
               modifier = Modifier.weight(1f),
               onOptionSelected = {},
               qNumber = 1
           )

            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = Dimens.MediumPadding)
                    .navigationBarsPadding()
            ){
                ButtonBox(
                    text = "Previous",
                    padding = Dimens.SmallPadding,
                    fraction = 0.43f,
                    fontSize = Dimens.SmallTextSize

                ) {

                }

                ButtonBox(
                    text = "Next",
                    padding = Dimens.SmallPadding,
                    borderColor = colorResource(id = R.color.orange),
                    containerColor = colorResource(id = R.color.dark_slate_blue),
                    fraction = 1f,
                    textColor = colorResource(id = R.color.white),
                    fontSize = Dimens.SmallTextSize
                ){

                }

            }
        }
    }
}



