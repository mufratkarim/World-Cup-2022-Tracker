package com.mka.fifa.world.cup2022.encyclopedia.presentation.team_by_id

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement.Absolute.SpaceAround
import androidx.compose.foundation.layout.Arrangement.Absolute.SpaceBetween
import androidx.compose.foundation.layout.Arrangement.Absolute.SpaceEvenly
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
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
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.mka.fifa.world.cup2022.encyclopedia.R
import com.mka.fifa.world.cup2022.encyclopedia.presentation.Screen
import com.mka.fifa.world.cup2022.encyclopedia.presentation.groups.GroupsViewModel
import com.mka.fifa.world.cup2022.encyclopedia.presentation.groups.components.GroupsItem

@Composable
fun TeamsScreen(
    navController: NavController,
    viewModel: GroupsViewModel = hiltViewModel()
) {

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.teams1),
            contentDescription = "Matches Image",
            modifier = Modifier.matchParentSize(),
            contentScale = ContentScale.Crop
        )
        Column {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Teams",
                    style = MaterialTheme.typography.h5,
                    color = Color.Black,
                    overflow = TextOverflow.Ellipsis,
                    fontFamily = FontFamily.Serif,
                    textDecoration = TextDecoration.Underline,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = "W:D:L",
                    style = MaterialTheme.typography.h5,
                    color = Color.Black,
                    overflow = TextOverflow.Ellipsis,
                    fontFamily = FontFamily.Serif,
                    textDecoration = TextDecoration.Underline,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = "GF:GA:GD",
                    style = MaterialTheme.typography.h5,
                    color = Color.Black,
                    overflow = TextOverflow.Ellipsis,
                    fontFamily = FontFamily.Serif,
                    textDecoration = TextDecoration.Underline,
                    fontWeight = FontWeight.Bold
                )

            }
            val state = viewModel.state.value
            state.groups?.let { groups ->
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(4.dp),
                    contentPadding = PaddingValues(5.dp)
                ) {
                    items(groups.groups) { group ->
                        group.teams.let { list ->
                            val sortedTeams = list.sortedByDescending { it.country }
                            sortedTeams.map { team ->
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(6.dp)
                                        .clickable {
                                            navController.navigate(Screen.TeamById.route + "/${team.country}")
                                        },
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Text(
                                        text = team.name,
                                        style = MaterialTheme.typography.h6,
                                        color = Color.White,
                                        overflow = TextOverflow.Ellipsis,
                                        fontFamily = FontFamily.SansSerif,
                                        modifier = Modifier
                                            .background(Color.Black.copy(alpha = 0.5f))
                                            .fillMaxWidth(0.4f)
                                    )

                                    Text(
                                        text = "${team.wins}:${team.draws}:${team.losses}",
                                        style = MaterialTheme.typography.h6,
                                        color = Color.White,
                                        overflow = TextOverflow.Ellipsis,
                                        fontFamily = FontFamily.SansSerif,
                                        modifier = Modifier
                                            .background(Color.Black.copy(alpha = 0.5f))
                                            .fillMaxWidth(0.6f)
                                            .padding(start = 6.dp)
                                    )

                                    Text(
                                        text = "${team.goals_for}:${team.goals_against}:${team.goal_differential}",
                                        style = MaterialTheme.typography.h6,
                                        color = Color.White,
                                        overflow = TextOverflow.Ellipsis,
                                        fontFamily = FontFamily.SansSerif,
                                        modifier = Modifier
                                            .background(Color.Black.copy(alpha = 0.5f))
                                            .fillMaxWidth(),
                                        textAlign = TextAlign.End
                                    )

                                }
                            }

                        }


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
                        .align(Alignment.CenterHorizontally)

                )
            }

            if (state.isLoading) {
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
            }

        }

    }

}