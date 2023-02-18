package com.mka.fifa.world.cup2022.encyclopedia.presentation.teams.old.components

import com.mka.fifa.world.cup2022.encyclopedia.data.remote.model.old.TeamById

data class TeamByIdState(
    val isLoading: Boolean = false,
    val teamById: TeamById? = null,
    val error: String = ""
)