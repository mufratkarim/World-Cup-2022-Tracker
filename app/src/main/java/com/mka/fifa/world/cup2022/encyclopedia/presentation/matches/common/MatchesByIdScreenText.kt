package com.mka.fifa.world.cup2022.encyclopedia.presentation.matches.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import com.mka.fifa.world.cup2022.encyclopedia.data.remote.model.MatchesById

@Composable
fun MatchesByIdScreenText(
    title: String,
    screenSize: Float,
    style: TextStyle,
    color: Color
) {

    Text(
        text = title,
        color = color,
        modifier = Modifier
            .fillMaxWidth(screenSize),
        textAlign = TextAlign.Center,
        fontFamily = FontFamily.Serif,
        fontWeight = FontWeight.Bold,
        style = style
    )

}