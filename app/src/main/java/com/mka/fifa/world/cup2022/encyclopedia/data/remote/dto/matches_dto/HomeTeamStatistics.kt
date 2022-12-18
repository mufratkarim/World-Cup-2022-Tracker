package com.mka.fifa.world.cup2022.encyclopedia.data.remote.dto.matches_dto

data class HomeTeamStatistics(
    val attempts_on_goal: Int,
    val attempts_on_goal_against: Int,
    val blocked: Int,
    val corners: Int,
    val country: String,
    val fouls_committed: Int,
    val free_kicks: Int,
    val goal_kicks: Int,
    val num_passes: Int,
    val off_target: Int,
    val offsides: Int,
    val on_target: Int,
    val passes_completed: Int,
    val penalties: Int,
    val penalties_scored: Int,
    val red_cards: Int,
    val tackles: Int,
    val throw_ins: Int,
    val yellow_cards: Int
)