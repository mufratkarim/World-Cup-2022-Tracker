package com.mka.fifa.world.cup2022.encyclopedia.presentation.matches

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.mka.fifa.world.cup2022.encyclopedia.presentation.matches.components.old.MatchesByIdItems
import com.mka.fifa.world.cup2022.encyclopedia.presentation.matches.viewmodel.old.MatchesByIdViewModel

@Composable
fun MatchesByIdScreen(
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
