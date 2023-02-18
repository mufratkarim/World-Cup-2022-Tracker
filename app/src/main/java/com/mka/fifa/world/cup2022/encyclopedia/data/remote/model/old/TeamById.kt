package com.mka.fifa.world.cup2022.encyclopedia.data.remote.model.old

import com.mka.fifa.world.cup2022.encyclopedia.data.remote.dto.old.team_by_id_dto.LastMatch

data class TeamById(
    val country: String,
    val draws: Int,
    val games_played: Int,
    val goals_against: Int,
    val goals_for: Int,
    val group_points: Int,
    val last_match: LastMatch,
    val losses: Int,
    val name: String,
    val wins: Int,
    val goal_differential: Int
)