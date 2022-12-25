package com.mka.fifa.world.cup2022.encyclopedia.presentation.matches.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.mka.fifa.world.cup2022.encyclopedia.R
import com.mka.fifa.world.cup2022.encyclopedia.data.remote.model.Matches
import com.mka.fifa.world.cup2022.encyclopedia.presentation.Screen
import com.mka.fifa.world.cup2022.encyclopedia.presentation.common.ButtonText
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
            .fillMaxSize(),
        verticalAlignment = CenterVertically
    ) {

        Column(
        ) {
            OutlinedButton(
                onClick = { navController.navigate(Screen.MatchesByIdScreen.route + "/${matches.id}") },
                colors = ButtonDefaults.buttonColors(
                    colorResource(id = R.color.lime)
                ),
                modifier = Modifier.fillMaxWidth(0.3f).fillMaxHeight()
            ) {
                ButtonText(title = "Stats", style = MaterialTheme.typography.body1, color = Color.Black)
            }

            OutlinedButton(
                onClick = { navController.navigate(Screen.MatchesByIdLineupScreen.route + "/${matches.id}") },
                colors = ButtonDefaults.buttonColors(
                    colorResource(id = R.color.lavender)
                ),
                modifier = Modifier.fillMaxWidth(0.3f).fillMaxHeight()
            ) {
                ButtonText(title = "Lineup", style = MaterialTheme.typography.body1, color = Color.Black)

            }
        }

        Text(
            buildAnnotatedString {

                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, fontSize = 18.sp)) {
                    append("${matches.home_team?.name}")
                }

                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, fontSize = 18.sp)) {
                    append(" - ${matches.away_team?.name}")
                }
                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                        color = colorResource(id = R.color.lime)
                    )
                ) {
                    append("\r\nMatch Num: ")
                }
                withStyle(style = SpanStyle(color = colorResource(id = R.color.lavender))) {
                    append("${matches.id}")
                }
                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                        color = colorResource(id = R.color.lime)
                    )
                ) {
                    append("\r\nResult: ")
                }
                withStyle(style = SpanStyle(color = colorResource(id = R.color.lavender))) {
                    append("${matches.home_team?.goals} - ${matches.away_team?.goals}")
                }

                if (matches.home_team?.penalties!! > 0 || matches.away_team?.penalties!! > 0) {
                    withStyle(
                        style = SpanStyle(
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp,
                            color = colorResource(id = R.color.lime)
                        )
                    ) {
                        append("\r\nPenalties: ")
                    }
                    withStyle(style = SpanStyle(color = colorResource(id = R.color.lavender))) {
                        append("(${matches.home_team.penalties}) - (${matches.away_team?.penalties})")
                    }

                }
                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                        color = colorResource(id = R.color.lime)
                    )
                ) {
                    append("\r\nWinner: ")
                }
                withStyle(style = SpanStyle(color = colorResource(id = R.color.lavender))) {
                    append("${matches.winner}")
                }

                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                        color = colorResource(id = R.color.lime)
                    )
                ) {
                    append("\r\nTime: ")
                }
                withStyle(style = SpanStyle(color = colorResource(id = R.color.lavender))) {
                    append(matches.datetime?.let { date ->
                        val odt = OffsetDateTime.parse(date)
                        val dtf = DateTimeFormatter.ofPattern("h:mm a, MMM dd", Locale.ENGLISH)
                        dtf.format(odt)
                    }.toString())
                }

            },
            modifier = Modifier
                .fillMaxWidth()
                .align(CenterVertically)
                .background(Color.DarkGray.copy(0.8f))
                .padding(8.dp),
            textAlign = TextAlign.Start,
            lineHeight = 36.sp,
            color = colorResource(id = R.color.light_cyan),
            fontSize = 18.sp,
            fontFamily = FontFamily.Serif
        )


    }
    Divider(color = Color.LightGray, thickness = 2.dp)
    Divider(color = Color.DarkGray, thickness = 4.dp)
}