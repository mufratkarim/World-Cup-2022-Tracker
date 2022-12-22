package com.mka.fifa.world.cup2022.encyclopedia.presentation.matches.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.mka.fifa.world.cup2022.encyclopedia.R
import com.mka.fifa.world.cup2022.encyclopedia.presentation.Screen
import com.mka.fifa.world.cup2022.encyclopedia.presentation.matches.common.MatchesByIdScreenText
import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter
import java.util.*

@Composable
fun MatchesByIdItems(
    state: MatchesByIdState
) {
    Image(
        painter = painterResource(id = R.drawable.team4),
        contentDescription = "Matches Image",
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth(),
        contentScale = ContentScale.Crop
    )
    state.matches?.let { match ->
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
                .verticalScroll(rememberScrollState()),
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp, bottom = 0.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = rememberAsyncImagePainter("https://raw.githubusercontent.com/mufratkarim/mufratkarim/main/flags/${match.home_team.country.lowercase()}.png"),
                    contentDescription = "Matches Image",
                    modifier = Modifier
                        .fillMaxWidth(0.3f)
                        .height(75.dp),
                    contentScale = ContentScale.Crop
                )

                MatchesByIdScreenText(
                    title = " ${match.stage_name} ",
                    screenSize = 0.6f,
                    style = MaterialTheme.typography.h5,
                    color = Color.White
                )
//                Text(
//                    text = " ${match.stage_name} ",
//                    color = Color.White,
//                    modifier = Modifier
//                        .fillMaxWidth(0.6f)
//                        .background(Color.DarkGray.copy(alpha = 0.6f)),
//                    textAlign = TextAlign.Center,
//                    fontFamily = FontFamily.Serif,
//                    fontWeight = FontWeight.Bold,
//                    style = MaterialTheme.typography.h5
//                )

                Image(
                    painter = rememberAsyncImagePainter("https://raw.githubusercontent.com/mufratkarim/mufratkarim/main/flags/${match.away_team.country.lowercase()}.png"),
                    contentDescription = "Matches Image",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(75.dp),
                    contentScale = ContentScale.Crop
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Cyan)
                    .padding(6.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {


                MatchesByIdScreenText(
                    title = " ${match.home_team.name} ",
                    screenSize = 0.4f,
                    style = MaterialTheme.typography.h6,
                    color = Color.Black
                )

                MatchesByIdScreenText(
                    title = " VS ",
                    screenSize = 0.35f,
                    style = MaterialTheme.typography.h6,
                    color = Color.Black
                )

                MatchesByIdScreenText(
                    title = " ${match.away_team.name} ",
                    screenSize = 1f,
                    style = MaterialTheme.typography.h5,
                    color = Color.Black
                )

            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.DarkGray.copy(alpha = 0.6f))
                    .padding(6.dp),
                horizontalArrangement = Arrangement.Center
            ) {

                MatchesByIdScreenText(
                    title = "Winner: ",
                    screenSize = 0.5f,
                    style = MaterialTheme.typography.subtitle1,
                    color = Color.White
                )

                MatchesByIdScreenText(
                    title = match.winner,
                    screenSize = 0.5f,
                    style = MaterialTheme.typography.subtitle1,
                    color = Color.Cyan
                )
            }
            Divider(color = Color.LightGray)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.DarkGray.copy(alpha = 0.6f))
                    .padding(6.dp),
                horizontalArrangement = Arrangement.Center
            ) {

                MatchesByIdScreenText(
                    title = "${match.venue}, ",
                    screenSize = 0.5f,
                    style = MaterialTheme.typography.subtitle1,
                    color = Color.White
                )

                MatchesByIdScreenText(
                    title = match.location,
                    screenSize = 0.5f,
                    style = MaterialTheme.typography.subtitle1,
                    color = Color.Cyan
                )


            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.DarkGray.copy(alpha = 0.6f))
                    .padding(6.dp),
                horizontalArrangement = Arrangement.Center
            ) {

                MatchesByIdScreenText(
                    title = "Attendance: ",
                    screenSize = 0.5f,
                    style = MaterialTheme.typography.subtitle1,
                    color = Color.White
                )
                MatchesByIdScreenText(
                    title = match.attendance,
                    screenSize = 0.5f,
                    style = MaterialTheme.typography.subtitle1,
                    color = Color.White
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.DarkGray.copy(alpha = 0.6f))
                    .padding(6.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Time: ",
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = match.datetime.let { date ->
                        val odt = OffsetDateTime.parse(date)
                        val dtf = DateTimeFormatter.ofPattern("h:mm a, MMM dd", Locale.ENGLISH)
                        dtf.format(odt)
                    },
                    color = Color.Cyan,
                    textAlign = TextAlign.Center,
                    fontFamily = FontFamily.SansSerif
                )
            }
            Divider(color = Color.LightGray)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.DarkGray.copy(alpha = 0.6f)),
                verticalAlignment = Alignment.CenterVertically
            ) {
                MatchesByIdScreenText(
                    title = " ${match.home_team.goals} ",
                    screenSize = 0.3f,
                    style = MaterialTheme.typography.subtitle1,
                    color = Color.Cyan

                )

                MatchesByIdScreenText(
                    title = " Goals ",
                    screenSize = 0.6f,
                    style = MaterialTheme.typography.subtitle1,
                    color = Color.White

                )

                MatchesByIdScreenText(
                    title = " ${match.away_team.goals} ",
                    screenSize = 1f,
                    style = MaterialTheme.typography.subtitle1,
                    color = Color.Cyan

                )
            }

            if (match.home_team.penalties > 0 || match.away_team.penalties > 0) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.DarkGray.copy(alpha = 0.6f)),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = " ${match.home_team.penalties} ",
                        color = Color.Cyan,
                        modifier = Modifier
                            .fillMaxWidth(0.3f)
                            .padding(6.dp),
                        textAlign = TextAlign.Center,
                        fontFamily = FontFamily.Serif,
                        fontWeight = FontWeight.Bold,
                    )

                    Text(
                        text = " Penalties ",
                        color = Color.White,
                        modifier = Modifier
                            .fillMaxWidth(0.6f)
                            .padding(6.dp),
                        textAlign = TextAlign.Center,
                        fontFamily = FontFamily.Serif,
                        fontWeight = FontWeight.Bold,
                    )

                    Text(
                        text = " ${match.away_team.penalties} ",
                        color = Color.Cyan,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(6.dp),
                        textAlign = TextAlign.Center,
                        fontFamily = FontFamily.Serif,
                        fontWeight = FontWeight.Bold,
                    )
                }
            }
            Divider(color = Color.LightGray)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.DarkGray.copy(alpha = 0.6f)),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = " ${match.home_team_statistics.attempts_on_goal} ",
                    color = Color.Cyan,
                    modifier = Modifier
                        .fillMaxWidth(0.3f)
                        .padding(6.dp),
                    textAlign = TextAlign.Center,
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.Bold,
                )

                Text(
                    text = " Shot Attempts ",
                    color = Color.White,
                    modifier = Modifier
                        .fillMaxWidth(0.6f)
                        .padding(6.dp),
                    textAlign = TextAlign.Center,
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.Bold,
                )

                Text(
                    text = " ${match.away_team_statistics.attempts_on_goal} ",
                    color = Color.Cyan,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(6.dp),
                    textAlign = TextAlign.Center,
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.Bold,
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.DarkGray.copy(alpha = 0.6f)),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = " ${match.home_team_statistics.on_target} ",
                    color = Color.Cyan,
                    modifier = Modifier
                        .fillMaxWidth(0.3f)
                        .padding(6.dp),
                    textAlign = TextAlign.Center,
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.Bold,
                )

                Text(
                    text = " On Target ",
                    color = Color.White,
                    modifier = Modifier
                        .fillMaxWidth(0.6f)
                        .padding(6.dp),
                    textAlign = TextAlign.Center,
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.Bold,
                )

                Text(
                    text = " ${match.away_team_statistics.on_target} ",
                    color = Color.Cyan,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(6.dp),
                    textAlign = TextAlign.Center,
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.Bold,
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.DarkGray.copy(alpha = 0.6f)),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = " ${match.home_team_statistics.off_target} ",
                    color = Color.Cyan,
                    modifier = Modifier
                        .fillMaxWidth(0.3f)
                        .padding(6.dp),
                    textAlign = TextAlign.Center,
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.Bold,
                )

                Text(
                    text = " Off Target ",
                    color = Color.White,
                    modifier = Modifier
                        .fillMaxWidth(0.6f)
                        .padding(6.dp),
                    textAlign = TextAlign.Center,
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.Bold,
                )

                Text(
                    text = " ${match.away_team_statistics.off_target} ",
                    color = Color.Cyan,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(6.dp),
                    textAlign = TextAlign.Center,
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.Bold,
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.DarkGray.copy(alpha = 0.6f)),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = " ${match.home_team_statistics.blocked} ",
                    color = Color.Cyan,
                    modifier = Modifier
                        .fillMaxWidth(0.3f)
                        .padding(6.dp),
                    textAlign = TextAlign.Center,
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.Bold,
                )

                Text(
                    text = " Attempts Blocked ",
                    color = Color.White,
                    modifier = Modifier
                        .fillMaxWidth(0.6f)
                        .padding(6.dp),
                    textAlign = TextAlign.Center,
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.Bold,
                )

                Text(
                    text = " ${match.away_team_statistics.blocked} ",
                    color = Color.Cyan,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(6.dp),
                    textAlign = TextAlign.Center,
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.Bold,
                )
            }

            Divider(color = Color.LightGray)

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = " ${match.home_team_statistics.num_passes} ",
                    color = Color.Cyan,
                    modifier = Modifier
                        .fillMaxWidth(0.3f)
                        .background(Color.DarkGray.copy(alpha = 0.6f))
                        .padding(6.dp),
                    textAlign = TextAlign.Center,
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.Bold,
                )

                Text(
                    text = " Total Passes ",
                    color = Color.White,
                    modifier = Modifier
                        .fillMaxWidth(0.6f)
                        .background(Color.DarkGray.copy(alpha = 0.6f))
                        .padding(6.dp),
                    textAlign = TextAlign.Center,
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.Bold,
                )

                Text(
                    text = " ${match.away_team_statistics.num_passes} ",
                    color = Color.Cyan,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.DarkGray.copy(alpha = 0.6f))
                        .padding(6.dp),
                    textAlign = TextAlign.Center,
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.Bold,
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.DarkGray.copy(alpha = 0.6f)),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = " ${match.home_team_statistics.passes_completed} ",
                    color = Color.Cyan,
                    modifier = Modifier
                        .fillMaxWidth(0.3f)
                        .padding(6.dp),
                    textAlign = TextAlign.Center,
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.Bold,
                )

                Text(
                    text = " Successful Passes ",
                    color = Color.White,
                    modifier = Modifier
                        .fillMaxWidth(0.6f)
                        .padding(6.dp),
                    textAlign = TextAlign.Center,
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.Bold,
                )

                Text(
                    text = " ${match.away_team_statistics.passes_completed} ",
                    color = Color.Cyan,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(6.dp),
                    textAlign = TextAlign.Center,
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.Bold,
                )
            }

            Divider(color = Color.LightGray)

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = " ${match.home_team_statistics.fouls_committed} ",
                    color = Color.Cyan,
                    modifier = Modifier
                        .fillMaxWidth(0.3f)
                        .background(Color.DarkGray.copy(alpha = 0.6f))
                        .padding(6.dp),
                    textAlign = TextAlign.Center,
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.Bold,
                )

                Text(
                    text = " Fouls ",
                    color = Color.White,
                    modifier = Modifier
                        .fillMaxWidth(0.6f)
                        .background(Color.DarkGray.copy(alpha = 0.6f))
                        .padding(6.dp),
                    textAlign = TextAlign.Center,
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.Bold,
                )

                Text(
                    text = " ${match.away_team_statistics.fouls_committed} ",
                    color = Color.White,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.DarkGray.copy(alpha = 0.6f))
                        .padding(6.dp),
                    textAlign = TextAlign.Center,
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.Bold,
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = " ${match.home_team_statistics.yellow_cards} ",
                    color = Color.Cyan,
                    modifier = Modifier
                        .fillMaxWidth(0.3f)
                        .background(Color.DarkGray.copy(alpha = 0.6f))
                        .padding(6.dp),
                    textAlign = TextAlign.Center,
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.Bold,
                )

                Text(
                    text = " Yellow Cards ",
                    color = Color.White,
                    modifier = Modifier
                        .fillMaxWidth(0.6f)
                        .background(Color.DarkGray.copy(alpha = 0.6f))
                        .padding(6.dp),
                    textAlign = TextAlign.Center,
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.Bold,
                )

                Text(
                    text = " ${match.away_team_statistics.yellow_cards} ",
                    color = Color.Cyan,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.DarkGray.copy(alpha = 0.6f))
                        .padding(6.dp),
                    textAlign = TextAlign.Center,
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.Bold,
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = " ${match.home_team_statistics.red_cards} ",
                    color = Color.Cyan,
                    modifier = Modifier
                        .fillMaxWidth(0.3f)
                        .background(Color.DarkGray.copy(alpha = 0.6f))
                        .padding(6.dp),
                    textAlign = TextAlign.Center,
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.Bold,
                )

                Text(
                    text = " Red Cards ",
                    color = Color.White,
                    modifier = Modifier
                        .fillMaxWidth(0.6f)
                        .background(Color.DarkGray.copy(alpha = 0.6f))
                        .padding(6.dp),
                    textAlign = TextAlign.Center,
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.Bold,
                )

                Text(
                    text = " ${match.away_team_statistics.red_cards} ",
                    color = Color.Cyan,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.DarkGray.copy(alpha = 0.6f))
                        .padding(6.dp),
                    textAlign = TextAlign.Center,
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.Bold,
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = " ${match.home_team_statistics.offsides} ",
                    color = Color.Cyan,
                    modifier = Modifier
                        .fillMaxWidth(0.3f)
                        .background(Color.DarkGray.copy(alpha = 0.6f))
                        .padding(6.dp),
                    textAlign = TextAlign.Center,
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.Bold,
                )

                Text(
                    text = " Offsides ",
                    color = Color.White,
                    modifier = Modifier
                        .fillMaxWidth(0.6f)
                        .background(Color.DarkGray.copy(alpha = 0.6f))
                        .padding(6.dp),
                    textAlign = TextAlign.Center,
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.Bold,
                )

                Text(
                    text = " ${match.away_team_statistics.offsides} ",
                    color = Color.Cyan,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.DarkGray.copy(alpha = 0.6f))
                        .padding(6.dp),
                    textAlign = TextAlign.Center,
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.Bold,
                )
            }

            Divider(color = Color.LightGray)

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = " ${match.home_team_statistics.corners} ",
                    color = Color.Cyan,
                    modifier = Modifier
                        .fillMaxWidth(0.3f)
                        .background(Color.DarkGray.copy(alpha = 0.6f))
                        .padding(6.dp),
                    textAlign = TextAlign.Center,
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.Bold,
                )

                Text(
                    text = " Corners ",
                    color = Color.White,
                    modifier = Modifier
                        .fillMaxWidth(0.6f)
                        .background(Color.DarkGray.copy(alpha = 0.6f))
                        .padding(6.dp),
                    textAlign = TextAlign.Center,
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.Bold,
                )

                Text(
                    text = " ${match.away_team_statistics.corners} ",
                    color = Color.Cyan,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.DarkGray.copy(alpha = 0.6f))
                        .padding(6.dp),
                    textAlign = TextAlign.Center,
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.Bold,
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = " ${match.home_team_statistics.free_kicks} ",
                    color = Color.Cyan,
                    modifier = Modifier
                        .fillMaxWidth(0.3f)
                        .background(Color.DarkGray.copy(alpha = 0.6f))
                        .padding(6.dp),
                    textAlign = TextAlign.Center,
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.Bold,
                )

                Text(
                    text = " Free Kicks ",
                    color = Color.White,
                    modifier = Modifier
                        .fillMaxWidth(0.6f)
                        .background(Color.DarkGray.copy(alpha = 0.6f))
                        .padding(6.dp),
                    textAlign = TextAlign.Center,
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.Bold,
                )

                Text(
                    text = " ${match.away_team_statistics.free_kicks} ",
                    color = Color.Cyan,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.DarkGray.copy(alpha = 0.6f))
                        .padding(6.dp),
                    textAlign = TextAlign.Center,
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.Bold,
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.DarkGray.copy(alpha = 0.6f)),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = " ${match.home_team_statistics.penalties} ",
                    color = Color.Cyan,
                    modifier = Modifier
                        .fillMaxWidth(0.3f)
                        .padding(6.dp),
                    textAlign = TextAlign.Center,
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.Bold,
                )

                Text(
                    text = " In-game Penalties ",
                    color = Color.White,
                    modifier = Modifier
                        .fillMaxWidth(0.6f)
                        .padding(6.dp),
                    textAlign = TextAlign.Center,
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.Bold,
                )

                Text(
                    text = " ${match.away_team_statistics.penalties} ",
                    color = Color.Cyan,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(6.dp),
                    textAlign = TextAlign.Center,
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.Bold,
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.DarkGray.copy(alpha = 0.6f)),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = " ${match.home_team_statistics.penalties_scored} ",
                    color = Color.Cyan,
                    modifier = Modifier
                        .fillMaxWidth(0.3f)
                        .padding(6.dp),
                    textAlign = TextAlign.Center,
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.Bold,
                )

                Text(
                    text = " Successful Penalties ",
                    color = Color.White,
                    modifier = Modifier
                        .fillMaxWidth(0.6f)
                        .padding(6.dp),
                    textAlign = TextAlign.Center,
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.Bold,
                )

                Text(
                    text = " ${match.away_team_statistics.penalties_scored} ",
                    color = Color.Cyan,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(6.dp),
                    textAlign = TextAlign.Center,
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.Bold,
                )
            }

        }


    }

    if (state.error.isNotBlank()) {
        Row(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = state.error,
                color = MaterialTheme.colors.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
            )
        }

    }

    if (state.isLoading) {
        Row(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            CircularProgressIndicator()
        }

    }
}