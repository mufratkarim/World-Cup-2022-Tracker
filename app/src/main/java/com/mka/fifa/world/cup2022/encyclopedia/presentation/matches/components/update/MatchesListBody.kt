package com.mka.fifa.world.cup2022.encyclopedia.presentation.matches.components.update

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
import com.mka.fifa.world.cup2022.encyclopedia.common.Constants
import com.mka.fifa.world.cup2022.encyclopedia.data.remote.model.update.Updated_Matches
import com.mka.fifa.world.cup2022.encyclopedia.presentation.Screen
import com.mka.fifa.world.cup2022.encyclopedia.presentation.common.ButtonText
import java.time.format.TextStyle
import java.util.*

@Composable
fun MatchesListBody(
    navController: NavController,
    matches: Updated_Matches
) {

    Row(
        modifier = Modifier
            .fillMaxSize(),
        verticalAlignment = CenterVertically
    ) {
        Column(
        ) {
            OutlinedButton(
                onClick = { navController.navigate("matches_stats/" + (matches.id?.minus(1))) },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = colorResource(id = R.color.lime)
                ),
                modifier = Modifier
                    .fillMaxWidth(0.3f)
                    .fillMaxHeight()
                    .padding(6.dp),
                shape = RoundedCornerShape(4.dp)
            ) {
                ButtonText(
                    title = "Stats",
                    style = MaterialTheme.typography.body1,
                    color = Color.Black
                )
            }

            OutlinedButton(
                onClick = { navController.navigate("matches_events/" + (65- matches.id!!)) },
                colors = ButtonDefaults.buttonColors(
                    colorResource(id = R.color.lavender)
                ),
                modifier = Modifier
                    .fillMaxWidth(0.3f)
                    .fillMaxHeight()
                    .padding(6.dp),
                shape = RoundedCornerShape(4.dp)
            ) {
                ButtonText(
                    title = "Events",
                    style = MaterialTheme.typography.body1,
                    color = Color.Black
                )

            }
        }

        Text(
            buildAnnotatedString {

                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, fontSize = 18.sp)) {
                    append("${matches.id}. ${matches.home_team}")
                }

                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, fontSize = 18.sp)) {
                    append(" - ${matches.away_team}")
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
                    append("${matches.score}")
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
                    append(matches.time?.let { date ->
                        val output = Constants.toLocalDateTime(date, "yyyy-MM-dd HH:mm:ss")
                        output.month.getDisplayName(
                            TextStyle.SHORT,
                            Locale.ENGLISH
                        ) + " " + output.dayOfMonth + ", " + matches.day


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
            fontSize = 15.sp,
            fontFamily = FontFamily.Serif
        )



    }
    Divider(color = Color.LightGray, thickness = 2.dp)
    Divider(color = Color.DarkGray, thickness = 4.dp)
}