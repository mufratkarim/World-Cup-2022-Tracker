package com.mka.fifa.world.cup2022.encyclopedia.presentation.matches.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.mka.fifa.world.cup2022.encyclopedia.data.remote.model.Matches

@Composable
fun MatchesItem(
    matches: Matches
) {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .padding(4.dp)
    ) {
        Text(text = "Match Number", color = Color.Red, modifier = Modifier.fillMaxSize(0.2f))
        Text(text = "HOME - AWAY", color = Color.Blue, modifier = Modifier.fillMaxSize(0.6f))
        Text(text = "Category", color = Color.Green)
    }
    Divider(color = Color.Gray, thickness = 4.dp)
    Row(
        modifier = Modifier
            .fillMaxSize()
            .padding(4.dp)
    ) {
        Text(text = "${matches.id}.", color = Color.Red, modifier = Modifier.fillMaxSize(0.2f))
        Text(
            text = "${matches.home_team.name} - ${matches.away_team.name}\r\n${matches.home_team.goals} - ${matches.away_team.goals}\r\nWinner: ${matches.winner}",
            color = Color.Blue,
            modifier = Modifier.fillMaxSize(0.6f)
        )
    }
    Divider(color = Color.LightGray, thickness = 2.dp)
    Row(
        modifier = Modifier
            .fillMaxSize()
            .padding(4.dp)
    ) {
        Text(text = "${matches.attendance}\r\nPeople", color = Color.Red, modifier = Modifier.fillMaxSize(0.2f))
        Text(
            text = "${matches.venue}, ${matches.location}\r\n${matches.stage_name}",
            color = Color.Blue,
            modifier = Modifier.fillMaxSize(0.6f)
        )
    }
    Divider(color = Color.DarkGray, thickness = 6.dp)
}