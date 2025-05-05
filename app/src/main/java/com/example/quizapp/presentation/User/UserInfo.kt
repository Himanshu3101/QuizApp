package com.example.quizapp.presentation.User

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.quizapp.R
import com.example.quizapp.presentation.common.PageHeader
import com.example.quizapp.presentation.common.ButtonBox
import com.example.quizapp.presentation.nav_graph.Routes
import com.example.quizapp.presentation.util.Dimens

@Preview(apiLevel = 34)
@Composable
fun Prev() {
    UserInfo(navController = rememberNavController(), state = DCStateUser(), event = { }, onSaveUser = {})
}

@Composable
fun UserInfo(
    navController: NavHostController,
    state: DCStateUser,
    event: (EventUserScreen) -> Unit,
    onSaveUser: (DCStateUser) -> Unit
) {

    var showError by remember { mutableStateOf(false) }

    val isValid = isFormValid(state)

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(bottom = Dimens.ExtraLargeSpacerHeight) // Leave space for button
        ) {

            PageHeader("Applicant Details")

            Column(
                modifier = Modifier
                    .padding(
                        start = Dimens.SmallPadding,
                        top = Dimens.MediumPadding,
                        end = Dimens.SmallPadding
                    ),
            ) {

                Spacer(modifier = Modifier.height(Dimens.MediumSpacerHeight))

                Text(
                    text = "User Name",
                    color = colorResource(R.color.blue_grey),
                    fontSize = Dimens.MediumTextSize,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(Dimens.MediumSpacerHeight))

                TextField(
                    modifier = Modifier
                        .fillMaxWidth(),
                    value = state.userName,
                    onValueChange = {
                        event(EventUserScreen.SetUserName(it))
                        showError = false
                    },

                    placeholder = { Text("Enter User  Name") }
                )

                Spacer(modifier = Modifier.height(Dimens.LargeSpacerHeight))

                Text(
                    text = "Occupation",
                    color = colorResource(R.color.blue_grey),
                    fontSize = Dimens.MediumTextSize,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(Dimens.MediumSpacerHeight))

                TextField(
                    modifier = Modifier
                        .fillMaxWidth(),
                    value = state.occupation,
                    onValueChange = {
                        event(EventUserScreen.SetOccupation(it))
                        showError = false
                    },
                    placeholder = { Text("Enter Occupation") }
                )

                Spacer(modifier = Modifier.height(Dimens.LargeSpacerHeight))

                Text(
                    text = "City",
                    color = colorResource(R.color.blue_grey),
                    fontSize = Dimens.MediumTextSize,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(Dimens.MediumSpacerHeight))

                TextField(
                    modifier = Modifier
                        .fillMaxWidth(),
                    value = state.city,
                    onValueChange = {
                        event(EventUserScreen.SetCity(it))
                        showError = false
                    },
                    placeholder = { Text("Enter City") }
                )

                //Error Message
                if (showError) {
                    Spacer(modifier = Modifier.height(Dimens.SmallSpacerHeight))
                    Text(
                        text = "Please fill all fields",
                        color = Color.Red,
                        fontSize = Dimens.SmallTextSize
                    )
                }
            }
        }


        Row(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .navigationBarsPadding()
        ) {
            ButtonBox(
                text = "Save",
                padding = Dimens.SmallPadding,
                borderColor = colorResource(id = R.color.orange),
                containerColor = colorResource(id = R.color.orange),
            ) {
                if (isValid) {
                    onSaveUser(state)
                    navController.navigate(Routes.HomeScreen.route)
                } else {
                   showError = true
                }
            }
        }

    }
}


fun isFormValid(state: DCStateUser): Boolean {
    return state.userName.isNotBlank() &&
            state.city.isNotBlank() &&
            state.occupation.isNotBlank()
}