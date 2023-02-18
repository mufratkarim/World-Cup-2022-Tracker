package com.mka.fifa.world.cup2022.encyclopedia.presentation.matches.components.update

import com.mka.fifa.world.cup2022.encyclopedia.data.remote.model.update.Updated_Matches

data class MatchesListState(
    val isLoading: Boolean = false,
    val matches: List<Updated_Matches> = emptyList(),
    val error: String = ""
)