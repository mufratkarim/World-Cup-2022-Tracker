package com.mka.fifa.world.cup2022.encyclopedia.data.remote.dto.old.groups_dto

import com.mka.fifa.world.cup2022.encyclopedia.data.remote.model.old.Groups

data class GroupsDto(
    val groups: List<Group>
)

fun GroupsDto.toGroups(): Groups {
    return Groups(groups = groups)
}