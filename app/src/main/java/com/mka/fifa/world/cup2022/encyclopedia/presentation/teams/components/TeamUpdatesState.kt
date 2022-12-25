package com.mka.fifa.world.cup2022.encyclopedia.presentation.teams.components

import com.mka.fifa.world.cup2022.encyclopedia.data.remote.model.MatchesById

data class TeamUpdatesState(
    val isLoading: Boolean = false,
    val matches: List<MatchesById> = emptyList(),
    val error: String = ""
)