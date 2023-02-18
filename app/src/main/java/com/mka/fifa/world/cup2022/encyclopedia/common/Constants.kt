package com.mka.fifa.world.cup2022.encyclopedia.common

import java.time.LocalDate
import java.time.LocalDateTime
import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter
import java.util.*

object Constants {

    const val SERVER_ERROR_TEXT = "Server is down"
    const val WORLD_CUP_JSON = "https://worldcupjson.net/"
    const val MY_WORLD_CUP_JSON = "https://raw.githubusercontent.com/"
    const val PLAYERS_STATS_URL = "https://www.theguardian.com/football/ng-interactive/2022/nov/16/world-cup-2022-player-profiles-qatar-match-ratings"
    const val HTTP_ERROR_TEXT = "An unexpected error has occurred"
    const val PARAM_TEAM_BY_ID = "teamId"
    const val PARAM_MATCHES_BY_ID = "matchesById"
    const val PARAM_MATCHES_BY_DATE = "matchesByDate"
    const val PARAM_MATCHES_BY_GOALS = "matchesByGoals"

    const val PARAM_EVENTS = "eventId"
    const val PARAM_STATS = "statId"
    const val PARAM_TEAM = "teamName"
    const val PARAM_PLAYER = "playerName"

    fun toLocalDateTime(date: String, pattern: String): LocalDateTime {
        return LocalDateTime.parse(date, DateTimeFormatter.ofPattern(pattern))

    }

}