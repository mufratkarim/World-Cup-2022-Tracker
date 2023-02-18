package com.mka.fifa.world.cup2022.encyclopedia.presentation.players.components

import com.mka.fifa.world.cup2022.encyclopedia.data.remote.model.update.Players
import com.mka.fifa.world.cup2022.encyclopedia.data.remote.model.update.Teams

data class PlayersState(
    val isLoading: Boolean = false,
    val players: List<Players> = emptyList(),
    val error: String = ""
)