package com.mka.fifa.world.cup2022.encyclopedia.presentation.common

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.android.style.LetterSpacingSpanEm
import androidx.compose.ui.text.android.style.LetterSpacingSpanPx
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp

@Composable
fun ScreenText(
    title: String,
    screenSize: Float,
    padding: Int,
    fontWeight: FontWeight = FontWeight.Normal,
    color: Color = Color.White,
    textAlign: TextAlign = TextAlign.Center,
    style: TextStyle = TextStyle.Default,
    textDecoration: TextDecoration = TextDecoration.None,
    letterSpacing: TextUnit = 0.em,
    fontSize: Int = 15
) {
    Text(
        text = title,
        color = color,
        textAlign = textAlign,
        fontWeight = fontWeight,
        textDecoration = textDecoration,
        style = style,
        modifier = Modifier
            .fillMaxWidth(screenSize)
            .padding(padding.dp),
        letterSpacing = letterSpacing,
        fontSize = fontSize.sp
    )
}
