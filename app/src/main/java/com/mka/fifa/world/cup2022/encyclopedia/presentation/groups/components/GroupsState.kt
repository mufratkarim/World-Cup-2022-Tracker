package com.mka.fifa.world.cup2022.encyclopedia.presentation.groups.components

import com.mka.fifa.world.cup2022.encyclopedia.data.remote.model.old.Groups
import com.mka.fifa.world.cup2022.encyclopedia.data.remote.model.update.Updated_Groups

data class GroupsState(
    val isLoading: Boolean = false,
    val groups: List<Updated_Groups> = emptyList(),
    val error: String = ""
)