package com.mka.fifa.world.cup2022.encyclopedia.data.remote.dto.team_by_id_dto

data class LastMatch(
    val away_team: String,
    val away_team_penalties: Int,
    val away_team_score: Int,
    val datetime: String,
    val draw: Boolean,
    val home_team: String,
    val home_team_penalties: Int,
    val home_team_score: Int,
    val id: Int,
    val location: String,
    val stage_name: String,
    val venue: String,
    val winner: String
)