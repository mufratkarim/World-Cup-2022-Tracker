package com.mka.fifa.world.cup2022.encyclopedia.presentation.team_by_id

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.FlingBehavior
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.mka.fifa.world.cup2022.encyclopedia.R
import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter
import java.util.*

@Composable
fun TeamUpdatesScreen(
    viewModel: TeamUpdatesViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    Image(
        painter = painterResource(id = R.drawable.teams1),
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
        contentPadding = PaddingValues(6.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.DarkGray.copy(alpha = 0.6f)),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Match #",
                    color = Color.White,
                    modifier = Modifier
                        .fillMaxWidth(0.35f)
                        .padding(bottom = 12.dp, start = 6.dp),
                    textAlign = TextAlign.Start,
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.h6,
                    textDecoration = TextDecoration.Underline
                )

                Text(
                    text = "Result",
                    color = Color.White,
                    modifier = Modifier
                        .fillMaxWidth(0.50f)
                        .padding(bottom = 12.dp),
                    textAlign = TextAlign.Center,
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.h6,
                    textDecoration = TextDecoration.Underline
                )

                Text(
                    text = "Winner",
                    color = Color.White,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 12.dp),
                    textAlign = TextAlign.End,
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.h6,
                    textDecoration = TextDecoration.Underline
                )
            }

            Divider(color = Color.LightGray)
        }

        items(state.matches) { match ->

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.DarkGray.copy(alpha = 0.6f))
                    .padding(6.dp)
            ) {
                Text(
                    text = "${match.id}",
                    modifier = Modifier
                        .fillMaxWidth(0.15f)
                        .padding(bottom = 6.dp),
                    textAlign = TextAlign.Start,
                    fontFamily = FontFamily.Serif,
                    color = Color.White
                )
                Text(
                    text = "[H]${match.home_team.name} - [A]${match.away_team.name}\r\nScore: ${match.home_team.goals} - ${match.away_team.goals}"
                            + if (match.home_team.penalties > 0 || match.away_team.penalties > 0) "\r\nPenalties: ${match.home_team.penalties} - ${match.away_team.penalties}" else ""
                            + "\r\nTime: ${
                        match.datetime.let { date ->
                            val odt = OffsetDateTime.parse(date)
                            val dtf =
                                DateTimeFormatter.ofPattern("h:mm a, MMM dd", Locale.ENGLISH)
                            dtf.format(odt)
                        }
                    }",
                    modifier = Modifier
                        .fillMaxWidth(0.80f)
                        .padding(bottom = 6.dp),
                    textAlign = TextAlign.Start,
                    fontFamily = FontFamily.Serif,
                    color = Color.White
                )
                Text(
                    text = match.winner, modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 6.dp),
                    textAlign = TextAlign.Center,
                    fontFamily = FontFamily.Serif,
                    color = Color.White
                )
            }


        }

    }


}