package com.mka.fifa.world.cup2022.encyclopedia.presentation.players

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.mka.fifa.world.cup2022.encyclopedia.R
import com.mka.fifa.world.cup2022.encyclopedia.presentation.common.VerticalDividerTwoRows
import com.mka.fifa.world.cup2022.encyclopedia.presentation.teams.update.viewmodel.TeamsViewModel

@Composable
fun TeamScreen(
    name: String,
    viewModel: TeamsViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    Box(
        modifier = Modifier
            .fillMaxSize()
            .fillMaxWidth()

    ) {
        Image(
            painter = painterResource(id = R.drawable.teams3),
            contentDescription = "Teams Image",
            modifier = Modifier.matchParentSize(),
            contentScale = ContentScale.FillBounds,
            alpha = 0.5f
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.DarkGray.copy(alpha = 0.7f))
                .verticalScroll(rememberScrollState()),
        ) {

            val team = state.teams.find { it.team == name }
            if (team != null) {

                Image(
                    painter = rememberAsyncImagePainter(
                        "https://raw.githubusercontent.com/mufratkarim/mufratkarim/main/flags/${
                            team.team.substring(
                                0,
                                3
                            ).lowercase()
                        }.png"
                    ),
                    contentDescription = "Team Image",
                    modifier = Modifier
                        .fillMaxWidth(1f)
                        .height(250.dp),
                    contentScale = ContentScale.Crop
                )

                TeamsVerticalDividers(title1 = "Team ", title2 = team.team)
                TeamsVerticalDividers(title1 = "Players Used ", title2 = "${team.players_used}")
                TeamsVerticalDividers(title1 = "Average Age ", title2 = "${team.avg_age}")
                TeamsVerticalDividers(title1 = "Games ", title2 = "${team.games}")
                TeamsVerticalDividers(title1 = "Possession ", title2 = "${team.possession}%")
                Divider(color = Color.LightGray)

                TeamsVerticalDividers(title1 = "Minutes ", title2 = "${team.minutes}")
                TeamsVerticalDividers(title1 = "Minutes Per Game ", title2 = "${team.minutes_90s}")
                TeamsVerticalDividers(title1 = "Minutes Per Sub ", title2 = "${team.minutes_per_sub}")
                Divider(color = Color.Yellow)

                TeamsVerticalDividers(title1 = "Goals ", title2 = "${team.goals}")
                TeamsVerticalDividers(title1 = "Goals Per Game ", title2 = "${team.goals_per90}")
                TeamsVerticalDividers(title1 = "Goals Per Shot ", title2 = "${team.goals_per_shot}")
                TeamsVerticalDividers(title1 = "Goals Per Shot on Target ", title2 = "${team.goals_per_shot_on_target}")
                Divider(color = Color.LightGray)

                TeamsVerticalDividers(title1 = "Total Penalties ", title2 = "${team.pens_att}")
                TeamsVerticalDividers(title1 = "Successful Penalties ", title2 = "${team.pens_made}")
                TeamsVerticalDividers(title1 = "Missed Penalties ", title2 = "${team.pens_conceded}")
                Divider(color = Color.LightGray)

                TeamsVerticalDividers(title1 = "Shots ", title2 = "${team.shots}")
                TeamsVerticalDividers(title1 = "Shots Per Game ", title2 = "${team.shots_per90}")
                TeamsVerticalDividers(title1 = "Shots on Target ", title2 = "${team.shots_on_target}")
                TeamsVerticalDividers(title1 = "Shots on Target Per Game ", title2 = "${team.shots_per90}")
                TeamsVerticalDividers(title1 = "Shots on Target Percentage", title2 = "${team.shots_on_target_pct}")
                Divider(color = Color.Yellow)



                TeamsVerticalDividers(title1 = "Assists ", title2 = "${team.assists}")
                TeamsVerticalDividers(title1 = "Assists per shot ", title2 = "${team.assists_per90}")
                TeamsVerticalDividers(title1 = "Assisted Shots ", title2 = "${team.assisted_shots}")
                Divider(color = Color.LightGray)
                TeamsVerticalDividers(title1 = "Total Passes ", title2 = "${team.passes}")
                TeamsVerticalDividers(title1 = "Successful Passes ", title2 = "${team.passes_completed}")
                TeamsVerticalDividers(title1 = "Passes Blocked ", title2 = "${team.passes_blocked}")
                Divider(color = Color.Yellow)



                TeamsVerticalDividers(title1 = "Corner Kicks ", title2 = "${team.corner_kicks}")
                TeamsVerticalDividers(title1 = "Corner Kicks In ", title2 = "${team.corner_kicks_in}")
                TeamsVerticalDividers(title1 = "Corner Kicks Out ", title2 = "${team.corner_kicks_out}")
                TeamsVerticalDividers(title1 = "Corner Kicks Straight ", title2 = "${team.corner_kicks_straight}")
                Divider(color = Color.LightGray)


                TeamsVerticalDividers(title1 = "Free Kicks ", title2 = "${team.shots_free_kicks}")
                TeamsVerticalDividers(title1 = "Crosses ", title2 = "${team.crosses}")
                TeamsVerticalDividers(title1 = "Crosses Into Penalty ", title2 = "${team.crosses_into_penalty_area}")
                Divider(color = Color.Yellow)

                TeamsVerticalDividers(title1 = "Clearances ", title2 = "${team.clearances}")
                TeamsVerticalDividers(title1 = "Interceptions ", title2 = "${team.interceptions}")
                TeamsVerticalDividers(title1 = "Attempted Tackles ", title2 = "${team.tackles}")
                TeamsVerticalDividers(title1 = "Tackles Won ", title2 = "${team.tackles_won}")
                Divider(color = Color.LightGray)

                TeamsVerticalDividers(title1 = "Yellow Cards ", title2 = "${team.cards_yellow}")
                TeamsVerticalDividers(title1 = "Red Cards ", title2 = "${team.cards_red}")
                TeamsVerticalDividers(title1 = "Fouls ", title2 = "${team.fouls}")
                TeamsVerticalDividers(title1 = "Fouled", title2 = "${team.fouled}")
                TeamsVerticalDividers(title1 = "Offsides", title2 = "${team.offsides}")
                Divider(color = Color.LightGray)


            }
        }

    }

}

@Composable
fun TeamsVerticalDividers(
    title1: String,
    title2: String,
) {
    VerticalDividerTwoRows(
        title1 = title1,
        title2 = title2,
        screenSize1 = 0.6f,
        screenSize2 = 0.8f,
        style1 = MaterialTheme.typography.body1,
        style2 = MaterialTheme.typography.body1,
        color1 = colorResource(id = R.color.light_cyan),
        color2 = colorResource(id = R.color.lavender),
        dividerColor = Color.Green,
        padding = 8
    )
}