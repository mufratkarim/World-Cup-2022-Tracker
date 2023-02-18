package com.mka.fifa.world.cup2022.encyclopedia.data.remote.dto.old.matches_dto

import com.mka.fifa.world.cup2022.encyclopedia.data.remote.model.old.Matches

data class MatchesDto(
    val attendance: String?,
    val away_team: AwayTeam?,
    val away_team_country: String?,
    val datetime: String?,
    val home_team: HomeTeam?,
    val home_team_country: String?,
    val id: Int?,
    val last_changed_at: String?,
    val last_checked_at: String?,
    val location: String?,
    val stage_name: String?,
    val status: String?,
    val venue: String?,
    val winner: String?,
    val winner_code: String?
)

fun MatchesDto.toMatches(): Matches {
    return Matches(
        id = id,
        attendance = attendance,
        away_team = away_team,
        datetime = datetime,
        home_team = home_team,
        location = location,
        stage_name = stage_name,
        status = status,
        venue = venue,
        winner = winner
    )
}