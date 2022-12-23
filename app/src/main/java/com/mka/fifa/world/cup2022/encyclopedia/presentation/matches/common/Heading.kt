package com.mka.fifa.world.cup2022.encyclopedia.presentation.matches.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import com.mka.fifa.world.cup2022.encyclopedia.R

@Composable
fun Heading(
    title1: String,
    title2: String,
    title3: String,
    backgroundColor: Color,
    screenSize1: Float,
    screenSize2: Float,
    screenSize3: Float,
    style: TextStyle,
    color: Color,
    padding: Int
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(backgroundColor),
        verticalAlignment = Alignment.CenterVertically
    ) {

        MatchesByIdScreenText(
            title = title1,
            screenSize = screenSize1,
            style = style,
            color = color,
            padding = padding
        )

        MatchesByIdScreenText(
            title = title2,
            screenSize = screenSize2,
            style = style,
            color = color,
            padding = padding
        )

        MatchesByIdScreenText(
            title = title3,
            screenSize = screenSize3,
            style = MaterialTheme.typography.h6,
            color = Color.Black,
            padding = padding
        )

    }
}