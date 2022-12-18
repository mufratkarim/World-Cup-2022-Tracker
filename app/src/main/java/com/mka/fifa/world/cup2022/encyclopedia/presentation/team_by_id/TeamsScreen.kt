package com.mka.fifa.world.cup2022.encyclopedia.presentation.team_by_id

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement.Absolute.SpaceAround
import androidx.compose.foundation.layout.Arrangement.Absolute.SpaceBetween
import androidx.compose.foundation.layout.Arrangement.Absolute.SpaceEvenly
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.mka.fifa.world.cup2022.encyclopedia.R
import com.mka.fifa.world.cup2022.encyclopedia.data.remote.dto.groups_dto.Team
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
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
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

            Text(
                text = "Click the teams to see all of their matches",
                color = Color.White,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.DarkGray.copy(alpha = 0.6f))
                    .padding(6.dp),
                textAlign = TextAlign.Center,
                fontFamily = FontFamily.Serif,
                fontWeight = FontWeight.SemiBold
            )

            val state = viewModel.state.value
            val teamList: MutableList<Team> = mutableListOf()
            state.groups?.let { groups ->
                groups.groups.map { group ->
                    group.teams.let { list ->
                        teamList.addAll(list)
                    }

                }
            }
            val sortedList = teamList.sortedBy { it.name }
            sortedList.map { team ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    OutlinedButton(
                        onClick = { navController.navigate(Screen.TeamUpdatesById.route + "/${team.country}") },
                        colors = ButtonDefaults.buttonColors(Color.Black.copy(alpha = 0.5f)),
                        modifier = Modifier.padding(6.dp),
                        shape = CircleShape
                    ) {
                        Text(
                            text = team.name,
                            style = MaterialTheme.typography.h6,
                            color = Color.White,
                            overflow = TextOverflow.Ellipsis,
                            fontFamily = FontFamily.SansSerif,
                            modifier = Modifier
                                .fillMaxWidth(0.4f)
                        )

                        Text(
                            text = "${team.wins}:${team.draws}:${team.losses}",
                            style = MaterialTheme.typography.h6,
                            color = Color.White,
                            overflow = TextOverflow.Ellipsis,
                            fontFamily = FontFamily.SansSerif,
                            modifier = Modifier
                                .fillMaxWidth(0.6f)

                        )

                        Text(
                            text = "${team.goals_for}:${team.goals_against}:${team.goal_differential}",
                            style = MaterialTheme.typography.h6,
                            color = Color.White,
                            overflow = TextOverflow.Ellipsis,
                            fontFamily = FontFamily.SansSerif,
                            modifier = Modifier
                                .fillMaxWidth(),
                            textAlign = TextAlign.End
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
                        .padding(horizontal = 6.dp)
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