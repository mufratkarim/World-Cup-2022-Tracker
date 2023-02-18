package com.mka.fifa.world.cup2022.encyclopedia.data.remote.dto.update.groups

import com.mka.fifa.world.cup2022.encyclopedia.data.remote.model.update.Updated_Groups

data class GroupsDto(
    val draws: Int,
    val exp_goal_conceded: Double,
    val exp_goal_difference: Double,
    val exp_goal_difference_per_90: Double,
    val expected_goal_scored: Double,
    val goal_difference: Int,
    val goals_against: Int,
    val goals_scored: Int,
    val losses: Int,
    val matches_played: Int,
    val points: Int,
    val rank: Int,
    val team: String,
    val wins: Int
)

fun GroupsDto.toGroups(): Updated_Groups {
    return Updated_Groups(draws, goal_difference, goals_against, goals_scored, losses, matches_played, points, rank, team, wins);
}
