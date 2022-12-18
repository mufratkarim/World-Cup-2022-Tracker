package com.mka.fifa.world.cup2022.encyclopedia.data.remote.model

import com.mka.fifa.world.cup2022.encyclopedia.data.remote.dto.matches_dto.*

data class MatchesById(
    val attendance: String,
    val away_team: MatchesAwayTeam,
    val away_team_statistics: AwayTeamStatistics,
    val datetime: String,
    val home_team: MatchesHomeTeam,
    val home_team_statistics: HomeTeamStatistics,
    val id: Int,
    val location: String,
    val stage_name: String,
    val venue: String,
    val winner: String,
    val home_team_lineup: HomeTeamLineup,
    val away_team_lineup: AwayTeamLineup,
    val home_team_events: List<HomeTeamEvent>,
    val away_team_events: List<AwayTeamEvent>
)