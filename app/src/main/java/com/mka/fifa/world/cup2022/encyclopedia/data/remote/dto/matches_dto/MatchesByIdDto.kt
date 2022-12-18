package com.mka.fifa.world.cup2022.encyclopedia.data.remote.dto.matches_dto

import com.mka.fifa.world.cup2022.encyclopedia.data.remote.model.MatchesById

data class MatchesByIdDto(
    val attendance: String,
    val away_team: MatchesAwayTeam,
    val away_team_country: String,
    val away_team_events: List<AwayTeamEvent>,
    val away_team_lineup: AwayTeamLineup,
    val away_team_statistics: AwayTeamStatistics,
    val datetime: String,
    val detailed_time: DetailedTime,
    val home_team: MatchesHomeTeam,
    val home_team_country: String,
    val home_team_events: List<HomeTeamEvent>,
    val home_team_lineup: HomeTeamLineup,
    val home_team_statistics: HomeTeamStatistics,
    val id: Int,
    val last_changed_at: String,
    val last_checked_at: String,
    val location: String,
    val officials: List<Official>,
    val stage_name: String,
    val status: String,
    val time: String,
    val venue: String,
    val weather: Weather,
    val winner: String,
    val winner_code: String
)

fun MatchesByIdDto.toMatchesById(): MatchesById {
    return MatchesById(
        attendance = attendance,
        away_team = away_team,
        away_team_statistics = away_team_statistics,
        datetime = datetime,
        home_team = home_team,
        home_team_statistics = home_team_statistics,
        id = id,
        location = location,
        stage_name = stage_name,
        venue = venue,
        winner = winner,
        home_team_lineup = home_team_lineup,
        away_team_lineup = away_team_lineup,
        home_team_events = home_team_events,
        away_team_events = away_team_events
    )
}