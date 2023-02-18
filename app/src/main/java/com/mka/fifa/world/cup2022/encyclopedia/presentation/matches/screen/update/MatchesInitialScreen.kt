@file:Suppress("RemoveRedundantQualifierName")

package com.mka.fifa.world.cup2022.encyclopedia.presentation.matches

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.mka.fifa.world.cup2022.encyclopedia.presentation.matches.components.update.MatchesListTop
import com.mka.fifa.world.cup2022.encyclopedia.presentation.matches.viewmodel.update.MatchesViewModel

@Composable
fun MatchesInitialScreen(
    navController: NavController,
    viewModel: MatchesViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        MatchesListTop(navController, state)
    }

}