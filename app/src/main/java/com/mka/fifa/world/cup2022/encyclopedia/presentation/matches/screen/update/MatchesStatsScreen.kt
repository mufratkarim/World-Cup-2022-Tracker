@file:Suppress("RemoveRedundantQualifierName")

package com.mka.fifa.world.cup2022.encyclopedia.presentation.matches

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.mka.fifa.world.cup2022.encyclopedia.presentation.matches.components.update.Updated_MatchesStats
import com.mka.fifa.world.cup2022.encyclopedia.presentation.matches.viewmodel.update.MatchesViewModel

@Composable
fun MatchesStatsScreen(
    args: Int,
    viewModel: MatchesViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    if (state.matches.isNotEmpty()) {
        Updated_MatchesStats(state.matches[args]);

    }


}