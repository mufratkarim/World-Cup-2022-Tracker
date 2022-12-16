package com.mka.fifa.world.cup2022.encyclopedia.presentation.matches.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.HorizontalAlignmentLine
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mka.fifa.world.cup2022.encyclopedia.R
import com.mka.fifa.world.cup2022.encyclopedia.data.remote.model.Matches
import java.text.SimpleDateFormat
import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter
import java.util.*

@Composable
fun MatchesItem(
    matches: Matches
) {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .padding(4.dp)
    ) {
        Text(
            text = "${matches.id}.",
            color = Color.White,
            modifier = Modifier
                .fillMaxSize(0.1f)
                .align(CenterVertically)
                .background(Color.Blue.copy(alpha = 0.5f))
                .padding(4.dp),
            textAlign = TextAlign.Center
        )
        Text(
            buildAnnotatedString {
                append("${matches.home_team?.name} ")
                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                    append("(${matches.home_team?.goals})")
                }
                append(" - ${matches.away_team?.name} ")
                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                    append("(${matches.away_team?.goals})\r\nWinner: ")
                }
                append("${matches.winner}")
                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                    append("\r\nAttendance: ")
                }
                append("${matches.attendance}")
            },
            modifier = Modifier
                .fillMaxSize(0.7f)
                .align(CenterVertically)
                .background(Color.DarkGray.copy(alpha = 0.6f))
                .padding(4.dp),
            textAlign = TextAlign.Center,
            lineHeight = 24.sp,
            color = Color.White
        )
        Text(
            text = "${matches.stage_name}\r\n${
                matches.datetime?.let { date ->
                    val odt = OffsetDateTime.parse(date)
                    val dtf = DateTimeFormatter.ofPattern("h:mm a\r\nMMM dd", Locale.ENGLISH)
                    dtf.format(odt)
                }
            }",
            color = Color.Black,
            modifier = Modifier
                .fillMaxWidth()
                .align(CenterVertically)
                .background(Color.White.copy(alpha = 0.5f)),
            textAlign = TextAlign.Center,
            lineHeight = 24.sp
        )

    }
    Divider(color = Color.LightGray, thickness = 2.dp)
    Divider(color = Color.DarkGray, thickness = 6.dp)
}