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
import com.mka.fifa.world.cup2022.encyclopedia.presentation.players.viewmodel.PlayersViewModel
import com.mka.fifa.world.cup2022.encyclopedia.presentation.teams.update.viewmodel.TeamsViewModel
import java.time.LocalDate

@Composable
fun PlayerScreen(
    name: String,
    viewModel: PlayersViewModel = hiltViewModel()
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
                .padding(vertical = 6.dp)
                .verticalScroll(rememberScrollState()),
        ) {

            val player = state.players.find { it.player == name }
            if (player != null) {
                PlayerVerticalDividers(title1 = "Name ", title2 = player.player)
                PlayerVerticalDividers(title1 = "Birth Year ", title2 = player.birth_year.toString())
                PlayerVerticalDividers(title1 = "Age ", title2 = (LocalDate.now().year - player.birth_year).toString())
                Divider(color = Color.Yellow)

                PlayerVerticalDividers(title1 = "Country ", title2 = player.team)
                PlayerVerticalDividers(title1 = "Club ", title2 = player.club)
                PlayerVerticalDividers(title1 = "Position ", title2 = player.position)
                Divider(color = Color.Yellow)

                PlayerVerticalDividers(title1 = "Games ", title2 = player.games.toString())
                PlayerVerticalDividers(title1 = "Goals ", title2 = player.games.toString())
                PlayerVerticalDividers(title1 = "Assists ", title2 = player.assists.toString())
                Divider(color = Color.Yellow)

                PlayerVerticalDividers(title1 = "Goals Per Game ", title2 = player.goals_per90.toString())
                PlayerVerticalDividers(title1 = "Assists Per Game ", title2 = player.assists_per90.toString())
                Divider(color = Color.Yellow)

                PlayerVerticalDividers(title1 = "Game Starts ", title2 = player.games_starts.toString())
                PlayerVerticalDividers(title1 = "Minutes ", title2 = player.minutes.toString())
                PlayerVerticalDividers(title1 = "Minutes Per Game ", title2 = player.minutes_90s.toString())
                Divider(color = Color.Yellow)

                PlayerVerticalDividers(title1 = "Total Penalties ", title2 = player.pens_att.toString())
                PlayerVerticalDividers(title1 = "Successful Penalties ", title2 = player.pens_made.toString())
                PlayerVerticalDividers(title1 = "Missed Penalties ", title2 = (player.pens_att-player.pens_made).toString())
                Divider(color = Color.Yellow)

                PlayerVerticalDividers(title1 = "Yellow Cards ", title2 = player.cards_yellow.toString())
                PlayerVerticalDividers(title1 = "Red Cards ", title2 = player.cards_red.toString())
                Divider(color = Color.Yellow)




            }
        }

    }

}

@Composable
fun PlayerVerticalDividers(
    title1: String,
    title2: String
) {
    VerticalDividerTwoRows(
        title1 = title1,
        title2 = title2,
        screenSize1 = 0.4f,
        screenSize2 = 0.8f,
        style1 = MaterialTheme.typography.body1,
        style2 = MaterialTheme.typography.body1,
        color1 = colorResource(id = R.color.light_cyan),
        color2 = colorResource(id = R.color.lavender),
        dividerColor = Color.Green,
        padding = 0
    )

}