package com.mka.fifa.world.cup2022.encyclopedia.presentation.matches.components.old

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.mka.fifa.world.cup2022.encyclopedia.R
import com.mka.fifa.world.cup2022.encyclopedia.presentation.common.Heading
import com.mka.fifa.world.cup2022.encyclopedia.presentation.common.ScreenText
import com.mka.fifa.world.cup2022.encyclopedia.presentation.common.VerticalDividerThreeRows
import com.mka.fifa.world.cup2022.encyclopedia.presentation.matches.viewmodel.old.MatchesByIdViewModel

@Composable
fun MatchesByIdLineup(
    viewModel: MatchesByIdViewModel = hiltViewModel()
) {
    Image(
        painter = painterResource(id = R.drawable.team4),
        contentDescription = "Matches Image",
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth(),
        contentScale = ContentScale.Crop
    )
    val state = viewModel.state.value
    state.matches?.let { match ->
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
                .background(Color.DarkGray.copy(alpha = 0.6f)),
        ) {
            Heading(
                title1 = "Status",
                title2 = "Team",
                title3 = "Tactics",
                backgroundColor = colorResource(id = R.color.light_cyan),
                screenSize1 = 0.3f,
                screenSize2 = 0.65f,
                screenSize3 = 1f,
                style = MaterialTheme.typography.h6,
                color = Color.Black,
                padding = 6,
                textAlign1 = TextAlign.Center
            )

            Divider(color = Color.Yellow)
            VerticalDividerThreeRows(
                title1 = "Home",
                title2 = match.home_team.name,
                title3 = " ${match.home_team_lineup.tactics} ",
                screenSize1 = 0.3f,
                screenSize2 = 0.65f,
                screenSize3 = 1f,
                style = MaterialTheme.typography.body1,
                color1 = colorResource(id = R.color.lime),
                color2 = colorResource(id = R.color.light_cyan),
                color3 = colorResource(id = R.color.lavender),
                dividerColor = Color.Yellow,
                padding = 0
            )
            Divider(color = Color.Yellow)
            VerticalDividerThreeRows(
                title1 = "Away",
                title2 = match.away_team.name,
                title3 = " ${match.away_team_lineup.tactics} ",
                screenSize1 = 0.3f,
                screenSize2 = 0.65f,
                screenSize3 = 1f,
                style = MaterialTheme.typography.body1,
                color1 = colorResource(id = R.color.lime),
                color2 = colorResource(id = R.color.light_cyan),
                color3 = colorResource(id = R.color.lavender),
                dividerColor = Color.Yellow,
                padding = 0
            )

            Divider(color = Color.LightGray)
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
            ) {
                item {
                    Column {
                        Text(
                            text = "${match.home_team.name} Squad", modifier = Modifier
                                .fillMaxWidth()
                                .background(colorResource(id = R.color.lime))
                                .padding(bottom = 12.dp, top = 12.dp),
                            textAlign = TextAlign.Center,
                            fontFamily = FontFamily.Serif,
                            style = MaterialTheme.typography.h5,
                            textDecoration = TextDecoration.Underline,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )
                    }
                }
                item {
                    Heading(
                        title1 = "Shirt",
                        title2 = "Player",
                        title3 = "Position",
                        backgroundColor = colorResource(id = R.color.lavender),
                        screenSize1 = 0.20f,
                        screenSize2 = 0.60f,
                        screenSize3 = 1f,
                        style = MaterialTheme.typography.h6,
                        color = Color.Black,
                        padding = 6,
                        textAlign1 = TextAlign.Center
                    )

                }

                items(match.home_team_lineup.starting_eleven) { player ->

                    VerticalDividerThreeRows(
                        title1 = "${player.shirt_number}.",
                        title2 = player.name,
                        title3 = player.position,
                        screenSize1 = 0.20f,
                        screenSize2 = 0.60f,
                        screenSize3 = 1f,
                        style = MaterialTheme.typography.body2,
                        color1 = colorResource(id = R.color.lime),
                        color2 = colorResource(id = R.color.lavender),
                        color3 = colorResource(id = R.color.light_cyan),
                        dividerColor = Color.Yellow,
                        padding = 3
                    )

                }

                item {
                    Divider(color = Color.LightGray)
                    Column {
                        Text(
                            text = "${match.home_team.name}'s In-game Events", modifier = Modifier
                                .fillMaxWidth()
                                .background(colorResource(id = R.color.lime))
                                .padding(bottom = 12.dp, top = 12.dp),
                            textAlign = TextAlign.Center,
                            fontFamily = FontFamily.Serif,
                            style = MaterialTheme.typography.h5,
                            textDecoration = TextDecoration.Underline,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )
                    }
                }

                item {

                    Heading(
                        title1 = "Action",
                        title2 = "Player",
                        title3 = "Time",
                        backgroundColor = colorResource(id = R.color.lavender),
                        screenSize1 = 0.3f,
                        screenSize2 = 0.70f,
                        screenSize3 = 1f,
                        style = MaterialTheme.typography.h6,
                        color = Color.Black,
                        padding = 6,
                        textAlign1 = TextAlign.Center
                    )

                }

                items(match.home_team_events) { player ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.DarkGray.copy(alpha = 0.6f))
                    ) {
                        VerticalDividerThreeRows(
                            title1 = player.type_of_event.uppercase(),
                            title2 = player.player,
                            title3 = player.time,
                            screenSize1 = 0.3f,
                            screenSize2 = 0.70f,
                            screenSize3 = 1f,
                            style = MaterialTheme.typography.body2,
                            color1 = colorResource(id = R.color.lime),
                            color2 = colorResource(id = R.color.lavender),
                            color3 = colorResource(id = R.color.light_cyan),
                            dividerColor = Color.Yellow,
                            padding = 3
                        )
                    }
                    Divider(color = Color.LightGray)
                }

                // Away Team
                item {
                    Column {
                        Text(
                            text = "${match.away_team.name} Squad", modifier = Modifier
                                .fillMaxWidth()
                                .background(colorResource(id = R.color.lime))
                                .padding(bottom = 12.dp, top = 12.dp),
                            textAlign = TextAlign.Center,
                            fontFamily = FontFamily.Serif,
                            style = MaterialTheme.typography.h5,
                            textDecoration = TextDecoration.Underline,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )
                    }
                }
                item {
                    Heading(
                        title1 = "Shirt",
                        title2 = "Player",
                        title3 = "Position",
                        backgroundColor = colorResource(id = R.color.lavender),
                        screenSize1 = 0.20f,
                        screenSize2 = 0.60f,
                        screenSize3 = 1f,
                        style = MaterialTheme.typography.h6,
                        color = Color.Black,
                        padding = 6,
                        textAlign1 = TextAlign.Center
                    )

                }

                items(match.away_team_lineup.starting_eleven) { player ->

                    VerticalDividerThreeRows(
                        title1 = "${player.shirt_number}.",
                        title2 = player.name,
                        title3 = player.position,
                        screenSize1 = 0.20f,
                        screenSize2 = 0.60f,
                        screenSize3 = 1f,
                        style = MaterialTheme.typography.body2,
                        color1 = colorResource(id = R.color.lime),
                        color2 = colorResource(id = R.color.lavender),
                        color3 = colorResource(id = R.color.light_cyan),
                        dividerColor = Color.Yellow,
                        padding = 3
                    )

                }

                item {
                    Divider(color = Color.LightGray)
                    Column {
                        Text(
                            text = "${match.away_team.name}'s In-game Events", modifier = Modifier
                                .fillMaxWidth()
                                .background(colorResource(id = R.color.lime))
                                .padding(bottom = 12.dp, top = 12.dp),
                            textAlign = TextAlign.Center,
                            fontFamily = FontFamily.Serif,
                            style = MaterialTheme.typography.h5,
                            textDecoration = TextDecoration.Underline,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )
                    }
                }

                item {

                    Heading(
                        title1 = "Action",
                        title2 = "Player",
                        title3 = "Time",
                        backgroundColor = colorResource(id = R.color.lavender),
                        screenSize1 = 0.3f,
                        screenSize2 = 0.70f,
                        screenSize3 = 1f,
                        style = MaterialTheme.typography.h6,
                        color = Color.Black,
                        padding = 6,
                        textAlign1 = TextAlign.Center
                    )

                }

                items(match.away_team_events) { player ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.DarkGray.copy(alpha = 0.6f))
                    ) {
                        VerticalDividerThreeRows(
                            title1 = player.type_of_event.uppercase(),
                            title2 = player.player,
                            title3 = player.time,
                            screenSize1 = 0.3f,
                            screenSize2 = 0.70f,
                            screenSize3 = 1f,
                            style = MaterialTheme.typography.body2,
                            color1 = colorResource(id = R.color.lime),
                            color2 = colorResource(id = R.color.lavender),
                            color3 = colorResource(id = R.color.light_cyan),
                            dividerColor = Color.Yellow,
                            padding = 3
                        )
                    }
                    Divider(color = Color.LightGray)
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
            ScreenText(
                title = state.error,
                screenSize = 1f,
                padding = 20,
                fontWeight = FontWeight.Bold
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