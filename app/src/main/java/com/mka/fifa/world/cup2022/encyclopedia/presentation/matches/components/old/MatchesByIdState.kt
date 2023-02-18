package com.mka.fifa.world.cup2022.encyclopedia.presentation.matches.components.old

import com.mka.fifa.world.cup2022.encyclopedia.data.remote.model.old.MatchesById

data class MatchesByIdState(
    val isLoading: Boolean = false,
    val matches: MatchesById? = null,
    val error: String = ""
)