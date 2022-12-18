package com.mka.fifa.world.cup2022.encyclopedia.presentation

sealed class Screen(val route: String) {
    object InitialScreen: Screen("initial")
    object MatchesScreen: Screen("matches")
    object MatchesByDateScreen: Screen("matches_by_date")
    object MatchesByGoalsScreen: Screen("matches_by_goals")
    object MatchesByIdScreen: Screen("matches_by_id")
    object MatchesByIdLineupScreen: Screen("matches_by_id_lineup")
    object GroupsScreen: Screen("groups")
    object TeamsScreen: Screen("teams")
    object PlayersScreen: Screen("players")
    object TeamById: Screen("team_by_id")
    object TeamUpdatesById: Screen("team_updates_by_id")
}
