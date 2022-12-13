package com.mka.fifa.world.cup2022.encyclopedia.presentation.matches.components

import com.mka.fifa.world.cup2022.encyclopedia.data.remote.model.Matches

data class MatchesState(
    val isLoading: Boolean = false,
    val matches: List<Matches> = emptyList(),
    val error: String = ""
)