package com.mka.fifa.world.cup2022.encyclopedia.presentation.matches.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.InteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.HorizontalAlignmentLine
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.mka.fifa.world.cup2022.encyclopedia.R
import com.mka.fifa.world.cup2022.encyclopedia.data.remote.model.Matches
import com.mka.fifa.world.cup2022.encyclopedia.presentation.Screen
import com.mka.fifa.world.cup2022.encyclopedia.presentation.ui.theme.Shapes
import java.text.SimpleDateFormat
import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter
import java.util.*

@Composable
fun MatchesItem(
    navController: NavController,
    matches: Matches
) {

    Row(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Text(
            text = "${matches.id}.",
            color = Color.Black,
            modifier = Modifier
                .fillMaxSize(0.1f)
                .align(CenterVertically)
                .background(Color.Cyan.copy(alpha = 0.5f))
                .padding(4.dp),
            textAlign = TextAlign.Center
        )
        OutlinedButton(
            onClick = { navController.navigate(Screen.MatchesByIdScreen.route + "/${matches.id}") },
            colors = ButtonDefaults.buttonColors(Color.DarkGray.copy(alpha = 0.6f)),
            shape = CircleShape
        ) {
            Text(
                buildAnnotatedString {
                    append("${matches.home_team?.name} ")
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                        append("(${matches.home_team?.goals})")
                    }
                    append(" - ${matches.away_team?.name} ")
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                        append("(${matches.away_team?.goals})")
                    }
                    if (matches.home_team?.penalties!! > 0 || matches.away_team?.penalties!! > 0) {
                        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                            append("\r\nPenalties: ")
                        }
                        append("${matches.home_team.country}(${matches.home_team.penalties}) - ${matches.away_team?.country}(${matches.away_team?.penalties})")
                    }
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                        append("\r\nWinner: ")
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
                color = Color.White,
                modifier = Modifier
                    .fillMaxWidth()
                    .align(CenterVertically),
                textAlign = TextAlign.Center,
                lineHeight = 24.sp,
                fontFamily = FontFamily.Serif,
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.SemiBold
            )

        }

    }
    Divider(color = Color.LightGray, thickness = 2.dp)
    Divider(color = Color.DarkGray, thickness = 6.dp)
}