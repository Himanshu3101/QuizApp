package com.example.quizapp.presentation.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.quizapp.R
import com.example.quizapp.presentation.util.Dimens

@Preview
@Composable
fun PrevHeader(){
    PageHeader(
        "Next"
    )
}


@Composable
fun PageHeader(s: String) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(Dimens.TopHeaderSize)
            .background(
                color = colorResource(id = R.color.dark_slate_blue),
                shape = RoundedCornerShape(
                    bottomStart = Dimens.ExtraLargeCornerRadius,
                    bottomEnd = Dimens.ExtraLargeCornerRadius
                )
            )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = Dimens.SmallPadding),
            horizontalArrangement = Arrangement.Center
        ){
            Text(
                text = s,
                color = colorResource(id = R.color.blue_grey),
                style = MaterialTheme.typography.titleMedium,
                textAlign = TextAlign.Center,
                fontSize = Dimens.LargeTextSize
            )
        }
    }

}