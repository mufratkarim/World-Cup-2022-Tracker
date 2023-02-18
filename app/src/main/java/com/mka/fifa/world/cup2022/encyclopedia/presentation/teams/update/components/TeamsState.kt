package com.mka.fifa.world.cup2022.encyclopedia.presentation.teams.update.components

import com.mka.fifa.world.cup2022.encyclopedia.data.remote.model.update.Teams

data class TeamsState(
    val isLoading: Boolean = false,
    val teams: List<Teams> = emptyList(),
    val error: String = ""
)