package com.mka.fifa.world.cup2022.encyclopedia.presentation.team_by_id

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.mka.fifa.world.cup2022.encyclopedia.R

@Composable
fun TeamByIdScreen(
    viewModel: TeamByIdViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    Box(modifier = Modifier.fillMaxSize()) {
        state.teamById?.let { team ->
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.linearGradient(
                            listOf(
                                colorResource(id = androidx.appcompat.R.color.material_deep_teal_200),
                                colorResource(id = R.color.teal_200)
                            )
                        )
                    )
            ) {
                item {
                    Column(modifier = Modifier.padding(8.dp)) {
                        Text(text = "Team: ${team.name}")
                        Spacer(modifier = Modifier.height(5.dp))
                        Text(text = "Goals For: ${team.goals_for}")
                        Spacer(modifier = Modifier.height(5.dp))
                        Text(text = "Goals Against: ${team.goals_against}")
                        Spacer(modifier = Modifier.height(5.dp))
                        Text(text = "Wins: ${team.wins}")
                        Spacer(modifier = Modifier.height(5.dp))
                        Text(text = "Draws: ${team.draws}")
                        Spacer(modifier = Modifier.height(5.dp))
                        Text(text = "Losses: ${team.losses}")
                        Spacer(modifier = Modifier.height(5.dp))
                        Text(text = "Group Points: ${team.group_points}")
                        Spacer(modifier = Modifier.height(5.dp))
                        Text(text = "Final Match: ${team.last_match.stage_name}")
                    }
                }

            }
        }
    }
}