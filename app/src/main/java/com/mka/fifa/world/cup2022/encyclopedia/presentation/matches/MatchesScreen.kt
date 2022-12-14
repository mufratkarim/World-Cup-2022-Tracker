package com.mka.fifa.world.cup2022.encyclopedia.presentation.matches

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.mka.fifa.world.cup2022.encyclopedia.data.remote.model.Matches
import com.mka.fifa.world.cup2022.encyclopedia.presentation.Screen
import com.mka.fifa.world.cup2022.encyclopedia.presentation.matches.components.MatchesItem

@Composable
fun MatchesScreen(
    viewModel: MatchesViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.linearGradient(
                    listOf(
                        Color.Gray,
                        Color.LightGray,
                        Color.White,
                        Color.Transparent
                    )
                )
            )
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(4.dp)
        ) {
            Text(text = "Match Num", color = Color.Red, modifier = Modifier.fillMaxSize(0.2f), textAlign = TextAlign.Center)
            Text(text = "HOME - AWAY", color = Color.Blue, modifier = Modifier.fillMaxSize(0.5f), textAlign = TextAlign.Center)
            Text(text = "Information", color = Color.Green, modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center)
        }
        Divider(color = Color.DarkGray, thickness = 4.dp, modifier = Modifier.offset(y = 48.dp))

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .offset(y = 60.dp)
        ) {
            items(state.matches) { item: Matches ->
                MatchesItem(matches = item)
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
                    .align(Alignment.Center)

            )
        }

        if (state.isLoading) {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }

}