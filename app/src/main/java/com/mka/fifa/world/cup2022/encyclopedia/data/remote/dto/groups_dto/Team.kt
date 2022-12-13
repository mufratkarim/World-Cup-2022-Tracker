package com.mka.fifa.world.cup2022.encyclopedia.data.remote.dto.groups_dto

data class Team(
    val country: String,
    val draws: Int,
    val games_played: Int,
    val goal_differential: Int,
    val goals_against: Int,
    val goals_for: Int,
    val group_points: Int,
    val losses: Int,
    val name: String,
    val wins: Int
)