package com.mka.fifa.world.cup2022.encyclopedia.presentation.team_by_id

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.FlingBehavior
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.mka.fifa.world.cup2022.encyclopedia.R
import com.mka.fifa.world.cup2022.encyclopedia.presentation.Screen
import com.mka.fifa.world.cup2022.encyclopedia.presentation.matches.components.MatchesDropdownCategory
import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter
import java.util.*

@Composable
fun TeamUpdatesScreen(
    navController: NavController,
    viewModel: TeamUpdatesViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    Image(
        painter = painterResource(id = R.drawable.teams3),
        contentDescription = "Team Updates Image",
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .fillMaxSize(),
        contentScale = ContentScale.Crop
    )
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        contentPadding = PaddingValues(6.dp)
    ) {
        item {
            Row {
                Text(
                    text = "Match",
                    color = Color.White,
                    modifier = Modifier
                        .fillMaxSize(0.3f),
                    textAlign = TextAlign.Center,
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
                Text(
                    text = "Result",
                    color = Color.White,
                    modifier = Modifier
                        .fillMaxSize(0.60f),
                    textAlign = TextAlign.Center,
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
                Text(
                    text = "Winner",
                    color = Color.White,
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    fontSize = 18.sp
                )

            }

            Divider(color = Color.LightGray)
        }

        items(state.matches) { match ->

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.DarkGray.copy(alpha = 0.6f))
                    .padding(6.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Column {
                    Text(
                        text = "${match.home_team.name} - ${match.away_team.name}",
                        modifier = Modifier
                            .fillMaxWidth(0.3f)
                            .padding(6.dp),
                        textAlign = TextAlign.Center,
                        fontFamily = FontFamily.Serif,
                        color = Color.Green,
                        fontSize = 15.sp
                    )

                    OutlinedButton(
                        onClick = { navController.navigate(Screen.MatchesByIdScreen.route + "/${match.id}") },
                        colors = ButtonDefaults.buttonColors(
                            Color.Green.copy(alpha = 0.6f)
                        ),
                        shape = RectangleShape,
                        modifier = Modifier.fillMaxWidth(0.3f)
                    ) {
                        Text(
                            text = "Stats",
                            style = MaterialTheme.typography.subtitle1,
                            color = Color.Black,
                            overflow = TextOverflow.Ellipsis,
                            textDecoration = TextDecoration.Underline,
                            fontFamily = FontFamily.Monospace,
                        )
                    }

                }


                Text(
                    text = "Score: ${match.home_team.goals} - ${match.away_team.goals}"
                            + (if (match.home_team.penalties > 0 || match.away_team.penalties > 0) "\r\nPenalties: ${match.home_team.penalties} - ${match.away_team.penalties}" else "")
                            + "\r\nTime: ${
                        match.datetime.let { date ->
                            val odt = OffsetDateTime.parse(date)
                            val dtf =
                                DateTimeFormatter.ofPattern("h:mm a, MMM dd", Locale.ENGLISH)
                            dtf.format(odt)
                        }
                    }",
                    modifier = Modifier
                        .fillMaxWidth(0.60f)
                        .padding(6.dp),
                    textAlign = TextAlign.Center,
                    fontFamily = FontFamily.Serif,
                    color = Color.Cyan,
                    fontSize = 15.sp
                )
                Column  {
                    Text(
                        text = match.winner, modifier = Modifier
                            .fillMaxWidth()
                            .padding(6.dp),
                        textAlign = TextAlign.Center,
                        fontFamily = FontFamily.Serif,
                        color = Color.Yellow,
                        fontSize = 15.sp
                    )

                    OutlinedButton(
                        onClick = { navController.navigate(Screen.MatchesByIdLineupScreen.route + "/${match.id}") },
                        colors = ButtonDefaults.buttonColors(
                            Color.Yellow.copy(alpha = 0.6f)
                        ),
                        shape = RectangleShape,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = "Lineup",
                            style = MaterialTheme.typography.subtitle1,
                            color = Color.Black,
                            overflow = TextOverflow.Ellipsis,
                            textDecoration = TextDecoration.Underline,
                            fontFamily = FontFamily.Monospace,
                        )
                    }
                }

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