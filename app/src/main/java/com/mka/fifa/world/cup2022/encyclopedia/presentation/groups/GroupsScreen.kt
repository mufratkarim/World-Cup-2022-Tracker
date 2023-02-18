package com.mka.fifa.world.cup2022.encyclopedia.presentation.groups

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.mka.fifa.world.cup2022.encyclopedia.R
import com.mka.fifa.world.cup2022.encyclopedia.presentation.common.ScreenText
import java.time.format.TextStyle

@Composable
fun GroupsScreen(
    navController: NavController,
    viewModel: GroupsViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.teams2),
            contentDescription = "Teams Image",
            modifier = Modifier.matchParentSize(),
            contentScale = ContentScale.FillBounds,
            alpha = 0.5f
        )
        val groupLetters = arrayOf("A", "B", "C", "D", "E", "F", "G", "H", "")
        LazyColumn(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            items(state.groups.withIndex().toList()) { (index, group) ->

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.DarkGray.copy(alpha = 0.8f)),
                ) {

                    if (index % 4 == 0) {
                        Divider(color = colorResource(id = R.color.lavender))

                        Row(horizontalArrangement = Arrangement.SpaceEvenly) {
                            ScreenText(
                                title = "Group ${groupLetters[index / 4]} ",
                                screenSize = 0.5f,
                                padding = 8,
                                color = colorResource(id = R.color.lavender),
                                textAlign = TextAlign.End,
                                fontWeight = FontWeight.Bold
                            )
                            ScreenText(
                                color = colorResource(id = R.color.lavender),
                                title = "MP W–D–L GF GA GD PTS ",
                                screenSize = 1f,
                                padding = 8,
                                textAlign = TextAlign.Center,
                                fontSize = 12,
                            )

                        }

                        Divider(color = colorResource(id = R.color.light_cyan))
                    }

                    Row(horizontalArrangement = Arrangement.SpaceEvenly) {
                        ScreenText(
                            title = "${group.rank}. ${group.team}",
                            screenSize = 0.5f,
                            padding = 8,
                            color = colorResource(id = R.color.light_cyan),
                            textAlign = TextAlign.End
                        )
                        ScreenText(
                            title = "${group.matches_played} ${group.wins}–${group.draws}–${group.losses} ${group.goals_scored} ${group.goals_against} ${group.goal_difference}",
                            screenSize = 1f,
                            padding = 8,
                            color = colorResource(id = R.color.light_cyan),
                            letterSpacing = 0.25.em
                        )
                    }


                }
            }


        }

        if (state.error.isNotBlank()) {
            ScreenText(
                title = state.error,
                screenSize = 1f,
                padding = 20,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colors.error
            )
        }

        if (state.isLoading) {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }

}