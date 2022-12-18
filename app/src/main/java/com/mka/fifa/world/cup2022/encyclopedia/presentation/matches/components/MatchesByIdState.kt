package com.mka.fifa.world.cup2022.encyclopedia.presentation.matches.components

import com.mka.fifa.world.cup2022.encyclopedia.data.remote.model.MatchesById

data class MatchesByIdState(
    val isLoading: Boolean = false,
    val matches: MatchesById? = null,
    val error: String = ""
)