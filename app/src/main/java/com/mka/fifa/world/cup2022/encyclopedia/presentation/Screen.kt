package com.mka.fifa.world.cup2022.encyclopedia.presentation

sealed class Screen(val route: String) {
    object InitialScreen: Screen("initial")
    object MatchesScreen: Screen("matches")
    object GroupsScreen: Screen("groups")
    object TeamsScreen: Screen("teams")
    object PlayersScreen: Screen("players")
    object TeamById: Screen("team_by_id")
}
