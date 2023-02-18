package com.mka.fifa.world.cup2022.encyclopedia.data.remote.model.update


data class Events(
    val match_id: Int,
    val action_player_1: String,
    val action_player_2: String,
    val event_time: Int,
    val event_type: String,
    val team: String

)
