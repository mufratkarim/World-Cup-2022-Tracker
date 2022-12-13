package com.mka.fifa.world.cup2022.encyclopedia.presentation.groups.components

import com.mka.fifa.world.cup2022.encyclopedia.data.remote.model.Groups
import com.mka.fifa.world.cup2022.encyclopedia.data.remote.model.Matches
import com.mka.fifa.world.cup2022.encyclopedia.data.remote.model.TeamById

data class GroupsState(
    val isLoading: Boolean = false,
    val groups: Groups? = null,
    val error: String = ""
)