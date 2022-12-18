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
import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter
import java.util.*

@Composable
fun MatchesByIdItems(
    state: MatchesByIdState,
    navController: NavController
) {
    Image(
        painter = painterResource(id = R.drawable.matches),
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
                    .background(Color.DarkGray.copy(alpha = 0.6f)),
                horizontalArrangement = Arrangement.Center
            ) {

                Text(
                    text = "${match.venue}, ",
                    color = Color.White,
                    modifier = Modifier
                        .padding(top = 12.dp),
                    textAlign = TextAlign.Center,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.SemiBold
                )

                Text(
                    text = match.location,
                    color = Color.White,
                    modifier = Modifier
                        .padding(top = 12.dp),
                    textAlign = TextAlign.Center,
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.SemiBold
                )

            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.DarkGray.copy(alpha = 0.6f)),
                horizontalArrangement = Arrangement.Center
            ) {

                Text(
                    text = "Attendance: ",
                    color = Color.White,
                    modifier = Modifier
                        .padding(top = 12.dp),
                    textAlign = TextAlign.Center,
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = match.attendance,
                    color = Color.White,
                    modifier = Modifier
                        .padding(top = 12.dp),
                    textAlign = TextAlign.Center,
                    fontFamily = FontFamily.SansSerif
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.DarkGray.copy(alpha = 0.6f)),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Time: ",
                    color = Color.White,
                    modifier = Modifier
                        .padding(top = 12.dp),
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
                    color = Color.White,
                    modifier = Modifier
                        .padding(top = 12.dp),
                    textAlign = TextAlign.Center,
                    fontFamily = FontFamily.SansSerif
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.DarkGray.copy(alpha = 0.6f)),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Winner: ",
                    color = Color.White,
                    modifier = Modifier
                        .padding(top = 12.dp),
                    textAlign = TextAlign.Center,
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = match.winner,
                    color = Color.White,
                    modifier = Modifier
                        .padding(top = 12.dp),
                    textAlign = TextAlign.Center,
                    fontFamily = FontFamily.SansSerif
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp),
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

                Text(
                    text = " ${match.stage_name} ",
                    color = Color.White,
                    modifier = Modifier
                        .fillMaxWidth(0.6f)
                        .background(Color.DarkGray.copy(alpha = 0.6f)),
                    textAlign = TextAlign.Center,
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.h5
                )

                Image(
                    painter = rememberAsyncImagePainter("https://raw.githubusercontent.com/mufratkarim/mufratkarim/main/flags/${match.away_team.country.lowercase()}.png"),
                    contentDescription = "Matches Image",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(75.dp),
                    contentScale = ContentScale.Crop
                )
            }
            Text(
                text = "Click below to see the lineups of ${match.home_team.name} and ${match.away_team.name}",
                color = Color.White,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.DarkGray.copy(alpha = 0.6f))
                    .padding(6.dp),
                textAlign = TextAlign.Center,
                fontFamily = FontFamily.Serif,
                fontWeight = FontWeight.SemiBold
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 6.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                OutlinedButton(
                    onClick = { navController.navigate(Screen.MatchesByIdLineupScreen.route + "/${match.id}") },
                    colors = ButtonDefaults.buttonColors(Color.Cyan.copy(alpha = 0.6f)),
                    shape = CircleShape
                ) {
                    Text(
                        text = " ${match.home_team.name} ",
                        color = Color.Black,
                        modifier = Modifier
                            .fillMaxWidth(0.4f),
                        textAlign = TextAlign.Center,
                        fontFamily = FontFamily.Serif,
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.h6
                    )

                    Text(
                        text = " VS ",
                        color = Color.Black,
                        modifier = Modifier
                            .fillMaxWidth(0.35f),
                        textAlign = TextAlign.Center,
                        fontFamily = FontFamily.Serif,
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.h6
                    )

                    Text(
                        text = " ${match.away_team.name} ",
                        color = Color.Black,
                        modifier = Modifier
                            .fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        fontFamily = FontFamily.Serif,
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.h6
                    )
                }

            }

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = " ${match.home_team.goals} ",
                    color = Color.White,
                    modifier = Modifier
                        .fillMaxWidth(0.3f)
                        .background(Color.DarkGray.copy(alpha = 0.6f))
                        .padding(6.dp),
                    textAlign = TextAlign.Center,
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.Bold,
                )

                Text(
                    text = " Goals ",
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
                    text = " ${match.away_team.goals} ",
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

            if (match.home_team.penalties > 0 || match.away_team.penalties > 0) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = " ${match.home_team.penalties} ",
                        color = Color.White,
                        modifier = Modifier
                            .fillMaxWidth(0.3f)
                            .background(Color.DarkGray.copy(alpha = 0.6f))
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
                            .background(Color.DarkGray.copy(alpha = 0.6f))
                            .padding(6.dp),
                        textAlign = TextAlign.Center,
                        fontFamily = FontFamily.Serif,
                        fontWeight = FontWeight.Bold,
                    )

                    Text(
                        text = " ${match.away_team.penalties} ",
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
            }
            Divider(color = Color.LightGray)
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = " ${match.home_team_statistics.attempts_on_goal} ",
                    color = Color.White,
                    modifier = Modifier
                        .fillMaxWidth(0.3f)
                        .background(Color.DarkGray.copy(alpha = 0.6f))
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
                        .background(Color.DarkGray.copy(alpha = 0.6f))
                        .padding(6.dp),
                    textAlign = TextAlign.Center,
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.Bold,
                )

                Text(
                    text = " ${match.away_team_statistics.attempts_on_goal} ",
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
                    text = " ${match.home_team_statistics.on_target} ",
                    color = Color.White,
                    modifier = Modifier
                        .fillMaxWidth(0.3f)
                        .background(Color.DarkGray.copy(alpha = 0.6f))
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
                        .background(Color.DarkGray.copy(alpha = 0.6f))
                        .padding(6.dp),
                    textAlign = TextAlign.Center,
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.Bold,
                )

                Text(
                    text = " ${match.away_team_statistics.on_target} ",
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
                    text = " ${match.home_team_statistics.off_target} ",
                    color = Color.White,
                    modifier = Modifier
                        .fillMaxWidth(0.3f)
                        .background(Color.DarkGray.copy(alpha = 0.6f))
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
                        .background(Color.DarkGray.copy(alpha = 0.6f))
                        .padding(6.dp),
                    textAlign = TextAlign.Center,
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.Bold,
                )

                Text(
                    text = " ${match.away_team_statistics.off_target} ",
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
                    text = " ${match.home_team_statistics.blocked} ",
                    color = Color.White,
                    modifier = Modifier
                        .fillMaxWidth(0.3f)
                        .background(Color.DarkGray.copy(alpha = 0.6f))
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
                        .background(Color.DarkGray.copy(alpha = 0.6f))
                        .padding(6.dp),
                    textAlign = TextAlign.Center,
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.Bold,
                )

                Text(
                    text = " ${match.away_team_statistics.blocked} ",
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

            Divider(color = Color.LightGray)

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = " ${match.home_team_statistics.num_passes} ",
                    color = Color.White,
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
                    text = " ${match.home_team_statistics.passes_completed} ",
                    color = Color.White,
                    modifier = Modifier
                        .fillMaxWidth(0.3f)
                        .background(Color.DarkGray.copy(alpha = 0.6f))
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
                        .background(Color.DarkGray.copy(alpha = 0.6f))
                        .padding(6.dp),
                    textAlign = TextAlign.Center,
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.Bold,
                )

                Text(
                    text = " ${match.away_team_statistics.passes_completed} ",
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

            Divider(color = Color.LightGray)

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = " ${match.home_team_statistics.fouls_committed} ",
                    color = Color.White,
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
                    color = Color.White,
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
                    text = " ${match.home_team_statistics.red_cards} ",
                    color = Color.White,
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
                    text = " ${match.home_team_statistics.offsides} ",
                    color = Color.White,
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

            Divider(color = Color.LightGray)

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = " ${match.home_team_statistics.corners} ",
                    color = Color.White,
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
                    text = " ${match.home_team_statistics.free_kicks} ",
                    color = Color.White,
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
                    text = " ${match.home_team_statistics.penalties} ",
                    color = Color.White,
                    modifier = Modifier
                        .fillMaxWidth(0.3f)
                        .background(Color.DarkGray.copy(alpha = 0.6f))
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
                        .background(Color.DarkGray.copy(alpha = 0.6f))
                        .padding(6.dp),
                    textAlign = TextAlign.Center,
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.Bold,
                )

                Text(
                    text = " ${match.away_team_statistics.penalties} ",
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
                    text = " ${match.home_team_statistics.penalties_scored} ",
                    color = Color.White,
                    modifier = Modifier
                        .fillMaxWidth(0.3f)
                        .background(Color.DarkGray.copy(alpha = 0.6f))
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
                        .background(Color.DarkGray.copy(alpha = 0.6f))
                        .padding(6.dp),
                    textAlign = TextAlign.Center,
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.Bold,
                )

                Text(
                    text = " ${match.away_team_statistics.penalties_scored} ",
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

        }


    }
}