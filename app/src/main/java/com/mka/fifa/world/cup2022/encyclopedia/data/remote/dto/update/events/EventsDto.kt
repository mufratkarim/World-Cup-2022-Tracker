package com.mka.fifa.world.cup2022.encyclopedia.data.remote.dto.update.events

import com.mka.fifa.world.cup2022.encyclopedia.data.remote.model.update.Events

data class EventsDto(
    val action_player_1: String,
    val action_player_2: String,
    val event_id: Int,
    val event_team: String,
    val event_time: Int,
    val event_type: String,
    val match_id: Int,
    val team: String
)

fun EventsDto.toEvents(): Events {
    return Events(match_id, action_player_1, action_player_2, event_time, event_type, team)
}