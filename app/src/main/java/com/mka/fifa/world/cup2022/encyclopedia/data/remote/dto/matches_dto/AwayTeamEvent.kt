package com.mka.fifa.world.cup2022.encyclopedia.data.remote.dto.matches_dto

data class AwayTeamEvent(
    val extra_info: String,
    val id: Int,
    val player: String,
    val time: String,
    val type_of_event: String
)