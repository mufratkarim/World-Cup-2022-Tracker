package com.mka.fifa.world.cup2022.encyclopedia.presentation.teams

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
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
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.mka.fifa.world.cup2022.encyclopedia.R
import com.mka.fifa.world.cup2022.encyclopedia.data.remote.dto.groups_dto.Team
import com.mka.fifa.world.cup2022.encyclopedia.presentation.Screen
import com.mka.fifa.world.cup2022.encyclopedia.presentation.common.ScreenText
import com.mka.fifa.world.cup2022.encyclopedia.presentation.common.VerticalDivider
import com.mka.fifa.world.cup2022.encyclopedia.presentation.common.VerticalDividerThreeRows
import com.mka.fifa.world.cup2022.encyclopedia.presentation.groups.GroupsViewModel

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
            contentDescription = "Teams Image",
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
            val teamHeading = "W${space.repeat(3)}D${space.repeat(3)}L${space.repeat(3)}GF${space.repeat(3)}GA${space.repeat(2)}"
            VerticalDividerThreeRows(
                title1 = "Teams",
                title2 = teamHeading,
                title3 = "Button",
                screenSize1 = 0.3f,
                screenSize2 = 0.7f,
                screenSize3 = 1f,
                style = MaterialTheme.typography.subtitle2,
                color1 = colorResource(id = R.color.light_cyan),
                color2 = colorResource(id = R.color.lavender),
                color3 = colorResource(id = R.color.lime),
                dividerColor = Color.Yellow,
                padding = 6,
                fontWeight = FontWeight.Bold,
                textDecoration = TextDecoration.Underline
            )
            Divider(color = Color.Yellow)
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
                        .height(IntrinsicSize.Min),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically

                ) {
                    val teamText = "${team.wins}${space.repeat(4)}${team.draws}${space.repeat(3)}${team.losses}${space.repeat(3)}${team.goals_for}${space.repeat(4)}${team.goals_against}${space.repeat(2)}"
                    Text(
                        text = team.name,
                        color = Color.Black,
                        overflow = TextOverflow.Ellipsis,
                        fontFamily = FontFamily.Serif,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth(0.3f),
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold
                    )
                    VerticalDivider(color = Color.Yellow)
                    Text(
                        text = teamText,
                        color = Color.Black,
                        overflow = TextOverflow.Ellipsis,
                        fontFamily = FontFamily.SansSerif,
                        textAlign = TextAlign.Center,
                        textDecoration = TextDecoration.Underline,
                        fontSize = 14.sp,
                        modifier = Modifier.fillMaxWidth(0.7f)

                    )
                    VerticalDivider(color = Color.Yellow)
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
                ScreenText(title = state.error, screenSize = 1f, padding = 20, textAlign = TextAlign.Center)
            }

            if (state.isLoading) {
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
            }

        }

    }

}