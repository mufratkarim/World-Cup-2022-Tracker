package com.mka.fifa.world.cup2022.encyclopedia.presentation.matches.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.HorizontalAlignmentLine
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
        Text(
            text = "${matches.id}.",
            color = Color.Red,
            modifier = Modifier
                .fillMaxSize(0.1f)
                .align(CenterVertically)
                .padding(4.dp),
            textAlign = TextAlign.End
        )
        Text(
            text = "${matches.home_team?.name} - ${matches.away_team?.name}\r\n${matches.home_team?.goals} - ${matches.away_team?.goals}\r\nWinner: ${matches.winner}",
            color = Color.Blue,
            modifier = Modifier
                .fillMaxSize(0.6f)
                .align(CenterVertically)
                .padding(4.dp),
            textAlign = TextAlign.Center,
            lineHeight = 24.sp
        )
        Text(
            text = "Attend: ${matches.attendance} \r\nVen: ${matches.venue}\r\nCity: ${matches.location}",
            color = Color.Magenta,
            modifier = Modifier
                .fillMaxWidth()
                .align(CenterVertically),
            textAlign = TextAlign.Center,
            lineHeight = 24.sp
        )
    }
    Divider(color = Color.LightGray, thickness = 2.dp)
    Divider(color = Color.DarkGray, thickness = 6.dp)
}