package com.mka.fifa.world.cup2022.encyclopedia.data.remote.dto.update.players

import com.mka.fifa.world.cup2022.encyclopedia.data.remote.model.update.Players

data class PlayersDto(
    val age: String,
    val assists: Int,
    val assists_per90: Double,
    val birth_year: Int,
    val cards_red: Int,
    val cards_yellow: Int,
    val club: String,
    val games: Int,
    val games_starts: Int,
    val goals: Int,
    val goals_assists_pens_per90: Double,
    val goals_assists_per90: Double,
    val goals_pens: Int,
    val goals_pens_per90: Double,
    val goals_per90: Double,
    val minutes: Int,
    val minutes_90s: Double,
    val npxg: Double,
    val npxg_per90: Double,
    val npxg_xg_assist: Double,
    val npxg_xg_assist_per90: Double,
    val pens_att: Int,
    val pens_made: Int,
    val player: String,
    val position: String,
    val team: String,
    val xg: Double,
    val xg_assist: Double,
    val xg_assist_per90: Double,
    val xg_per90: Double,
    val xg_xg_assist_per90: Double
)

fun PlayersDto.toPlayers(): Players {
    return Players(
        games_starts,
        age,
        assists,
        assists_per90,
        goals_per90,
        birth_year,
        cards_red,
        cards_yellow,
        club,
        games,
        goals,
        minutes,
        minutes_90s,
        pens_att,
        pens_made,
        position,
        player,
        team
    );
}