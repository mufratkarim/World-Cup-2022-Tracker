package com.mka.fifa.world.cup2022.encyclopedia.presentation

sealed class Screen(val route: String) {
    // Old and outdated
    object MatchesByDateScreen: Screen("matches_by_date")
    object MatchesByGoalsScreen: Screen("matches_by_goals")
    object MatchesByIdScreen: Screen("matches_by_id")
    object MatchesByIdLineupScreen: Screen("matches_by_id_lineup")
    object TeamById: Screen("team_by_id")
    object TeamUpdatesById: Screen("team_updates_by_id")

    // Working
    object InitialScreen: Screen("initial")
    object MatchesInitialScreen: Screen("matches")
    object MatchesReverseScreen: Screen("matches_reverse")
    object GroupsScreen: Screen("groups")
    object TeamsScreen: Screen("teams")
    object TeamScreen: Screen("team/{teamName}")
    object PlayersScreen: Screen("players")
    object PlayerScreen: Screen("player/{playerName}")
    object MatchesStatsScreen: Screen("matches_stats/{statId}")
    object MatchesEventsScreen: Screen("matches_events/{eventId}")

}
