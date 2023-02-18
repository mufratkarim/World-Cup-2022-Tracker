package com.mka.fifa.world.cup2022.encyclopedia.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.mka.fifa.world.cup2022.encyclopedia.common.Constants
import com.mka.fifa.world.cup2022.encyclopedia.presentation.groups.GroupsScreen
import com.mka.fifa.world.cup2022.encyclopedia.presentation.initial_screen.InitialScreen
import com.mka.fifa.world.cup2022.encyclopedia.presentation.matches.*
import com.mka.fifa.world.cup2022.encyclopedia.presentation.matches.components.old.MatchesByIdLineup
import com.mka.fifa.world.cup2022.encyclopedia.presentation.players.PlayerScreen
import com.mka.fifa.world.cup2022.encyclopedia.presentation.players.PlayersScreen
import com.mka.fifa.world.cup2022.encyclopedia.presentation.players.TeamScreen
import com.mka.fifa.world.cup2022.encyclopedia.presentation.players.TeamsScreen
import com.mka.fifa.world.cup2022.encyclopedia.presentation.teams.old.TeamByIdScreen
import com.mka.fifa.world.cup2022.encyclopedia.presentation.teams.old.TeamUpdatesScreen
import com.mka.fifa.world.cup2022.encyclopedia.presentation.ui.theme.FIFAWorldCup2022EncyclopediaTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FIFAWorldCup2022EncyclopediaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.InitialScreen.route
                    ) {
                        composable(route = Screen.InitialScreen.route) { InitialScreen(navController) }
                        composable(route = Screen.MatchesInitialScreen.route) { MatchesInitialScreen(navController) }
                        composable(route = Screen.MatchesReverseScreen.route) { MatchesReverseScreen(navController) }
                        composable(
                            route = Screen.MatchesStatsScreen.route, arguments = listOf(
                                navArgument(Constants.PARAM_STATS) {
                                    type = NavType.IntType
                                })
                        ) { MatchesStatsScreen(it.arguments?.getInt(Constants.PARAM_STATS)!!) }

                        composable(
                            route = Screen.MatchesEventsScreen.route, arguments = listOf(
                                navArgument(Constants.PARAM_EVENTS) {
                                    type = NavType.IntType
                                })
                        ) { EventsScreen(it.arguments?.getInt(Constants.PARAM_EVENTS)!!) }

                        composable(route = Screen.MatchesByDateScreen.route + "/{matchesByDate}") {
                            MatchesByDateScreen(
                                navController
                            )
                        }
                        composable(route = Screen.MatchesByGoalsScreen.route + "/{matchesByGoals}") {
                            MatchesByGoalsScreen(
                                navController
                            )
                        }
                        composable(route = Screen.MatchesByIdScreen.route + "/{matchesById}") {
                            MatchesByIdScreen(
                            )
                        }
                        composable(route = Screen.MatchesByIdLineupScreen.route + "/{matchesById}") { MatchesByIdLineup() }
                        composable(route = Screen.GroupsScreen.route) { GroupsScreen(navController) }
                        composable(route = Screen.TeamsScreen.route) { TeamsScreen(navController) }
                        composable(
                            route = Screen.TeamScreen.route, arguments = listOf(
                                navArgument(Constants.PARAM_TEAM) {
                                    type = NavType.StringType
                                })
                        ) {
                            it.arguments?.getString(Constants.PARAM_TEAM)
                                ?.let { key ->
                                    TeamScreen(
                                        name = key,
                                    )
                                }
                        }
                        composable(
                            route = Screen.PlayerScreen.route, arguments = listOf(
                                navArgument(Constants.PARAM_PLAYER) {
                                    type = NavType.StringType
                                })
                        ) {
                            it.arguments?.getString(Constants.PARAM_PLAYER)
                                ?.let { key ->
                                    PlayerScreen(
                                        name = key,
                                    )
                                }
                        }
                        composable(route = Screen.TeamById.route + "/{teamId}") { TeamByIdScreen() }
                        composable(route = Screen.TeamUpdatesById.route + "/{teamId}") {
                            TeamUpdatesScreen(
                                navController
                            )
                        }
                        composable(route = Screen.PlayersScreen.route) { PlayersScreen(navController) }
                    }
                }
            }
        }
    }
}