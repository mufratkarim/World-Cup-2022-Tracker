@file:Suppress("RemoveSingleExpressionStringTemplate")

package com.mka.fifa.world.cup2022.encyclopedia.presentation.teams

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter
import java.util.*

@Composable
fun TeamByIdScreen(
    viewModel: TeamByIdViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.linearGradient(
                    listOf(
                        Color.DarkGray,
                        Color.LightGray,
                        Color.Cyan
                    )
                )
            )
    ) {
        state.teamById?.let { team ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
            ) {
                Image(
                    painter = rememberAsyncImagePainter("https://raw.githubusercontent.com/mufratkarim/mufratkarim/main/flags/${team.country.lowercase()}.png"),
                    contentDescription = "Team ${team.name}",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(256.dp),
                    contentScale = ContentScale.Crop
                )
                Text(
                    text = "${team.name}", style = MaterialTheme.typography.h3,
                    color = Color.DarkGray,
                    modifier = Modifier
                        .background(Color.White.copy(0.5f))
                        .fillMaxWidth(),
                    fontWeight = FontWeight.Bold,
                    textDecoration = TextDecoration.Underline,
                    textAlign = TextAlign.Center
                )
                Row(modifier = Modifier.padding(4.dp)) {
                    Text(
                        text = "Wins/Draws/Losses: ",
                        style = MaterialTheme.typography.h6,
                        color = Color.Black,
                        modifier = Modifier
                            .padding(start = 4.dp),
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "${team.wins}/${team.draws}/${team.losses}",
                        style = MaterialTheme.typography.h6,
                        color = Color.Gray
                    )
                }
                Row(modifier = Modifier.padding(4.dp)) {
                    Text(
                        text = "Goals For/Against/Diff: ",
                        style = MaterialTheme.typography.h6,
                        color = Color.Black,
                        modifier = Modifier
                            .padding(start = 4.dp),
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "${team.goals_for}/${team.goals_against}/${team.goal_differential}",
                        style = MaterialTheme.typography.h6,
                        color = Color.Gray,
                    )
                }
                Row(modifier = Modifier.padding(4.dp)) {
                    Text(
                        text = "${team.games_played} total games",
                        style = MaterialTheme.typography.h6,
                        color = Color.Black,
                        modifier = Modifier
                            .padding(start = 4.dp),
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "/${team.group_points} total points",
                        style = MaterialTheme.typography.h6,
                        color = Color.Gray
                    )
                }
                Text(
                    text = "Last Match", style = MaterialTheme.typography.h3,
                    color = Color.DarkGray,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.White.copy(0.5f)),
                    fontWeight = FontWeight.Bold,
                    textDecoration = TextDecoration.Underline,
                    textAlign = TextAlign.Center
                )
                Row(modifier = Modifier.padding(4.dp)) {
                    Text(
                        text = "[Home]: ${team.last_match.home_team}",
                        style = MaterialTheme.typography.h6,
                        color = Color.Black,
                        modifier = Modifier
                            .padding(start = 4.dp),
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = " - [Away]: ${team.last_match.away_team}",
                        style = MaterialTheme.typography.h6,
                        color = Color.Gray
                    )
                }
                Row(modifier = Modifier.padding(4.dp)) {
                    Text(
                        text = "Result: ",
                        style = MaterialTheme.typography.h6,
                        color = Color.Black,
                        modifier = Modifier
                            .padding(start = 4.dp),
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "${team.last_match.home_team_score} - ${team.last_match.away_team_score}",
                        style = MaterialTheme.typography.h6,
                        color = Color.Gray
                    )
                }
                if (team.last_match.home_team_penalties > 0 || team.last_match.away_team_penalties > 0) {
                    Row(modifier = Modifier.padding(4.dp)) {
                        Text(
                            text = "Penalties: ${team.last_match.home_team} (${team.last_match.home_team_penalties})",
                            style = MaterialTheme.typography.h6,
                            color = Color.Black,
                            modifier = Modifier
                                .padding(start = 4.dp),
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = " - ${team.last_match.away_team} (${team.last_match.away_team_penalties})",
                            style = MaterialTheme.typography.h6,
                            color = Color.Gray
                        )
                    }
                }

                Row(modifier = Modifier.padding(4.dp)) {
                    Text(
                        text = "Winner: ",
                        style = MaterialTheme.typography.h6,
                        color = Color.Black,
                        modifier = Modifier
                            .padding(start = 4.dp),
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "${team.last_match.winner}",
                        style = MaterialTheme.typography.h6,
                        color = Color.Gray,
                    )
                }
                Row(modifier = Modifier.padding(4.dp)) {
                    Text(
                        text = "Stage: ",
                        style = MaterialTheme.typography.h6,
                        color = Color.Black,
                        modifier = Modifier
                            .padding(start = 6.dp),
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "${team.last_match.stage_name}, ${
                            team.last_match.datetime.let { date ->
                                val odt = OffsetDateTime.parse(date)
                                val dtf =
                                    DateTimeFormatter.ofPattern("h:mm a, MMM dd", Locale.ENGLISH)
                                dtf.format(odt)
                            }
                        }",
                        style = MaterialTheme.typography.h6,
                        color = Color.Gray,
                    )
                }
                Row(modifier = Modifier.padding(4.dp)) {
                    Text(
                        text = "Stadium: ",
                        style = MaterialTheme.typography.h6,
                        color = Color.Black,
                        modifier = Modifier
                            .padding(start = 6.dp),
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "${team.last_match.venue}, ${team.last_match.location}",
                        style = MaterialTheme.typography.h6,
                        color = Color.Gray,

                        )
                }

            }


        }

        if (state.error.isNotBlank()) {
            Text(
                text = state.error,
                color = MaterialTheme.colors.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .align(Alignment.Center)

            )
        }

        if (state.isLoading) {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}