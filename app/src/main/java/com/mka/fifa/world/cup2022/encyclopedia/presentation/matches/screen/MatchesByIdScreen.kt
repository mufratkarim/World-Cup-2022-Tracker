package com.mka.fifa.world.cup2022.encyclopedia.presentation.matches

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.mka.fifa.world.cup2022.encyclopedia.presentation.matches.components.MatchesByIdItems
import com.mka.fifa.world.cup2022.encyclopedia.presentation.matches.viewmodel.MatchesByIdViewModel

@Composable
fun MatchesByIdScreen(
    navController: NavController,
    viewModel: MatchesByIdViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        MatchesByIdItems(state)
    }

}
