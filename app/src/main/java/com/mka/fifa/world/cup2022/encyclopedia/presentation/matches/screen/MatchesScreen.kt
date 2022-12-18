@file:Suppress("RemoveRedundantQualifierName")

package com.mka.fifa.world.cup2022.encyclopedia.presentation.matches

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.mka.fifa.world.cup2022.encyclopedia.data.remote.model.Matches
import com.mka.fifa.world.cup2022.encyclopedia.presentation.matches.components.MatchesItems
import com.mka.fifa.world.cup2022.encyclopedia.presentation.matches.components.MatchesItem
import com.mka.fifa.world.cup2022.encyclopedia.presentation.matches.viewmodel.MatchesViewModel

@Composable
fun MatchesScreen(
    navController: NavController,
    viewModel: MatchesViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        MatchesItems(navController, state)
    }

}