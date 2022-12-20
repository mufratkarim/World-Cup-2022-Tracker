package com.mka.fifa.world.cup2022.encyclopedia.presentation.team_by_id

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement.Absolute.SpaceAround
import androidx.compose.foundation.layout.Arrangement.Absolute.SpaceBetween
import androidx.compose.foundation.layout.Arrangement.Absolute.SpaceEvenly
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.unit.sp
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
            painter = painterResource(id = R.drawable.matches),
            contentDescription = "Matches Image",
            modifier = Modifier.matchParentSize(),
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.LightGray.copy(0.6f))
                .verticalScroll(rememberScrollState())
                .padding(6.dp)
        ) {
            val space = "\t"
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(6.dp)
            ) {
                Text(
                    text = "Teams",
                    color = Color.Black,
                    overflow = TextOverflow.Ellipsis,
                    fontFamily = FontFamily.Serif,
                    textDecoration = TextDecoration.Underline,
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp,
                    modifier = Modifier.fillMaxWidth(0.35f).padding(start = 6.dp),
                )
                Text(
                    text = "W${space.repeat(3)}D${space.repeat(3)}L${space.repeat(3)}GF${
                        space.repeat(
                            3
                        )
                    }GA${space.repeat(2)}",
                    color = Color.Black,
                    overflow = TextOverflow.Ellipsis,
                    fontFamily = FontFamily.Serif,
                    textDecoration = TextDecoration.Underline,
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp
                )

                Text(
                    text = "Button",
                    color = Color.Black,
                    overflow = TextOverflow.Ellipsis,
                    fontFamily = FontFamily.Serif,
                    textDecoration = TextDecoration.Underline,
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp,
                    modifier = Modifier.fillMaxWidth()
                )

            }

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
                        .fillMaxWidth()
                        .padding(12.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically

                ) {

                    Text(
                        text = team.name,
                        color = Color.Black,
                        overflow = TextOverflow.Ellipsis,
                        fontFamily = FontFamily.Serif,
                        modifier = Modifier
                            .fillMaxWidth(0.35f),
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Text(
                        text = "${team.wins}${space.repeat(4)}${team.draws}${space.repeat(3)}${team.losses}${
                            space.repeat(
                                3
                            )
                        }${team.goals_for}${space.repeat(4)}${team.goals_against}${
                            space.repeat(
                                2
                            )
                        }",
                        color = Color.Black,
                        overflow = TextOverflow.Ellipsis,
                        fontFamily = FontFamily.SansSerif,
                        fontSize = 12.sp,
                        modifier = Modifier.fillMaxWidth(0.8f)

                    )

                    Button(
                        onClick = { navController.navigate(Screen.TeamUpdatesById.route + "/${team.country}") },
                        colors = ButtonDefaults.buttonColors(Color.Transparent),
                        modifier = Modifier.fillMaxWidth(),
                        shape = CircleShape
                    ) {
                        Text(text = "\uD83D\uDDB2️️", color = Color.Red)
                    }


                }

                Divider(color = Color.DarkGray)
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