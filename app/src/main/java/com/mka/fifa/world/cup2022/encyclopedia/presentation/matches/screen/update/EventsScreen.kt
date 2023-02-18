@file:Suppress("RemoveRedundantQualifierName")

package com.mka.fifa.world.cup2022.encyclopedia.presentation.matches

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.mka.fifa.world.cup2022.encyclopedia.R
import com.mka.fifa.world.cup2022.encyclopedia.data.remote.model.update.Events
import com.mka.fifa.world.cup2022.encyclopedia.presentation.common.Heading
import com.mka.fifa.world.cup2022.encyclopedia.presentation.common.ScreenText
import com.mka.fifa.world.cup2022.encyclopedia.presentation.common.VerticalDividerThreeRows
import com.mka.fifa.world.cup2022.encyclopedia.presentation.common.VerticalDividerTwoRows
import com.mka.fifa.world.cup2022.encyclopedia.presentation.matches.viewmodel.update.EventsViewModel

@Composable
fun EventsScreen(
    eventId: Int,
    viewModel: EventsViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()

        ) {
            if (state.events != null) {
                item {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.DarkGray.copy(alpha = 0.6f)),
                    ) {
                        Heading(
                            title1 = "Time",
                            title2 = "Team",
                            title3 = "Type",
                            backgroundColor = colorResource(id = R.color.light_cyan),
                            screenSize1 = 0.2f,
                            screenSize2 = 0.6f,
                            screenSize3 = 1f,
                            style = MaterialTheme.typography.h6,
                            color = Color.Black,
                            padding = 6,
                            textAlign1 = TextAlign.Center
                        )

                        Divider(color = Color.Yellow)
                    }
                }
                items(state.events) { event ->

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.DarkGray.copy(alpha = 0.6f)),
                    ) {

                        VerticalDividerThreeRows(
                            title1 = event.event_time.toString(),
                            title2 = event.team,
                            title3 = event.event_type,
                            screenSize1 = 0.2f,
                            screenSize2 = 0.6f,
                            screenSize3 = 1f,
                            style = MaterialTheme.typography.body1,
                            color1 = colorResource(id = R.color.light_cyan),
                            color2 = colorResource(id = R.color.light_cyan),
                            color3 = colorResource(id = R.color.light_cyan),
                            dividerColor = colorResource(id = R.color.light_cyan) ,
                            padding = 6
                        )
                        val secondAction = if (event.action_player_2 != "") {", ${event.action_player_2}"} else "";
                        ScreenText(
                            title = "Action By: ${event.action_player_1}" + secondAction,
                            screenSize = 1f,
                            padding = 0,
                            fontWeight = FontWeight.SemiBold,
                            textDecoration = TextDecoration.Underline,
                            color = colorResource(id = R.color.lavender)
                        )

                        Divider(color = Color.Yellow)
                    }
                }
            }
        }
    }

}