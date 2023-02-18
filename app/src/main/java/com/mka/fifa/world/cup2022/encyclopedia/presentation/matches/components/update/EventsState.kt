package com.mka.fifa.world.cup2022.encyclopedia.presentation.matches.components.update

import com.mka.fifa.world.cup2022.encyclopedia.data.remote.model.update.Events

data class EventsState(
    val isLoading: Boolean = false,
    val events: List<Events>? = null,
    val error: String = ""
)