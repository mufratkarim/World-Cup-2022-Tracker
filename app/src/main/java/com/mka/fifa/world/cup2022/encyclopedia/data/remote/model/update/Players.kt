package com.mka.fifa.world.cup2022.encyclopedia.data.remote.model.update


data class Players(
    val games_starts: Int,
    val age: String,
    val assists: Int,
    val assists_per90: Double,
    val goals_per90: Double,
    val birth_year: Int,
    val cards_red: Int,
    val cards_yellow: Int,
    val club: String,
    val games: Int,
    val goals: Int,
    val minutes: Int,
    val minutes_90s: Double,
    val pens_att: Int,
    val pens_made: Int,
    val position: String,
    val player: String,
    val team: String,

)
