package com.example.quizapp.presentation.score

import android.icu.text.DecimalFormat
import android.util.Log
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.quizapp.R
import com.example.quizapp.presentation.User.DCStateUser
import com.example.quizapp.presentation.nav_graph.Routes
import com.example.quizapp.presentation.util.Dimens

@Composable
fun ScoreScreen(
    noOfQuestion: Int,
    noOfCorrectAnswer: Int,
    navController: NavController,
    userInfo: DCStateUser
){

    BackHandler {
        goToHome(navController)
    }

    Log.d("user121", "username=${userInfo.userName}, occupation=${userInfo.occupation}, city=${userInfo.city}")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = Dimens.MediumPadding),
        verticalArrangement = Arrangement.Center
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ){
            IconButton(
                onClick = {
                    goToHome(navController)
                }
            ) {
                Icon(
                    painterResource(R.drawable.baseline_close_24),
                    contentDescription = "close",
                    tint = colorResource(R.color.blue_grey)
                )
            }
        }

        Spacer(modifier = Modifier.height(Dimens.SmallSpacerHeight))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(500.dp)
                .clip(RoundedCornerShape(Dimens.MediumCornerRadius))
                .background(colorResource(R.color.blue_grey)),
            contentAlignment = Alignment.Center
        ){
            Column (
                modifier = Modifier.padding(
                    horizontal = Dimens.MediumPadding,
                    vertical = Dimens.MediumPadding
                ),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.congra))
                val annotatedString = buildAnnotatedString {
                    withStyle(style = SpanStyle(Color.Black)){
                        append("You attempted ")
                    }
                    withStyle(style = SpanStyle(Color.Blue)){
                        append("$noOfQuestion questions ")
                    }
                    withStyle(style = SpanStyle(Color.Black)){
                        append("and from that ")
                    }
                    withStyle(style = SpanStyle(Color.Black)){
                        append("$noOfCorrectAnswer answers ")
                    }
                    withStyle(style = SpanStyle(Color.Black)){
                        append("are correct")
                    }
                }

                val scorePercentage = calculatePercentage(noOfCorrectAnswer, noOfQuestion)
                LottieAnimation(
                    modifier = Modifier.size(Dimens.LargeLottieAnimSize),
                    composition = composition,
                    iterations = 100
                )
                Spacer(modifier = Modifier.height(Dimens.SmallSpacerHeight))

                Text(
                    text = "Congrats!",
                    color = Color.Black,
                    style = MaterialTheme.typography.titleMedium,
                    fontSize = Dimens.MediumTextSize,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(Dimens.MediumSpacerHeight))

                Text(
                    text = "$scorePercentage% Score",
                    color = colorResource(id = R.color.green),
                    style = MaterialTheme.typography.titleMedium,
                    fontSize = Dimens.LargeTextSize,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(Dimens.MediumSpacerHeight))

                Text(
                    text = "Quiz Completed successfully.",
                    color = Color.Black,
                    style = MaterialTheme.typography.titleMedium,
                    fontSize = Dimens.SmallTextSize,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(Dimens.MediumSpacerHeight))

                Text(
                    text = annotatedString,
                    color = Color.Black,
                    style = MaterialTheme.typography.titleMedium,
                    fontSize = Dimens.SmallTextSize,
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(Dimens.LargeSpacerHeight))

                Row (
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Share with us :",
                        color = Color.Black,
                        style = MaterialTheme.typography.titleMedium,
                        fontSize = Dimens.SmallTextSize
                    )

                    Spacer(modifier = Modifier.width(Dimens.SmallSpacerWidth))

                    Icon(
                        modifier = Modifier
                            .size(30.dp),
                        painter = painterResource(R.drawable.instagram),
                        tint = Color.Unspecified,
                        contentDescription = ""
                    )

                    Spacer(modifier = Modifier.width(Dimens.SmallSpacerWidth))

                    Icon(
                        modifier = Modifier
                            .size(40.dp),
                        painter = painterResource(R.drawable.facebook),
                        tint = Color.Unspecified,
                        contentDescription = ""
                    )

                    Spacer(modifier = Modifier.width(Dimens.SmallSpacerWidth))

                    Icon(
                        modifier = Modifier
                            .size(30.dp),
                        painter = painterResource(R.drawable.whatsapp),
                        tint = Color.Unspecified,
                        contentDescription = ""
                    )
                }
            }
        }
    }
}

fun goToHome(navController : NavController){
    navController.navigate(Routes.HomeScreen.route){
        popUpTo(Routes.HomeScreen.route){inclusive = true}
    }
}

fun calculatePercentage(noOfCorrectAnswer: Int, noOfQuestion: Int): Double {
    require(noOfCorrectAnswer >= 0 && noOfQuestion > 0) {"Invalid Input: noOfCorrectAnswer must be non-negative and noOfQuestion must be positive"}
    val percentage = (noOfCorrectAnswer.toDouble() / noOfQuestion.toDouble()) * 100
    return DecimalFormat("#.##").format(percentage).toDouble()
}


