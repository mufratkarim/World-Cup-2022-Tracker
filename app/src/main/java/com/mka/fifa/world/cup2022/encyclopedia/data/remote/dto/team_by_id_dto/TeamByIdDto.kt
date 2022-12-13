package com.mka.fifa.world.cup2022.encyclopedia.data.remote.dto.team_by_id_dto

import com.mka.fifa.world.cup2022.encyclopedia.data.remote.model.TeamById

data class TeamByIdDto(
    val country: String,
    val draws: Int,
    val games_played: Int,
    val goal_differential: Int,
    val goals_against: Int,
    val goals_for: Int,
    val group_points: Int,
    val id: Int,
    val last_match: LastMatch,
    val losses: Int,
    val name: String,
    val wins: Int
)

fun TeamByIdDto.toTeamById(): TeamById {
    return TeamById(
        draws = draws,
        games_played = games_played,
        goals_against = goals_against,
        goals_for = goals_for,
        group_points = group_points,
        last_match = last_match,
        losses = losses,
        name = name,
        wins = wins,
        goal_differential = goal_differential
    )

}