package com.mka.fifa.world.cup2022.encyclopedia.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mka.fifa.world.cup2022.encyclopedia.common.Constants
import com.mka.fifa.world.cup2022.encyclopedia.presentation.groups.GroupsScreen
import com.mka.fifa.world.cup2022.encyclopedia.presentation.groups.GroupsViewModel
import com.mka.fifa.world.cup2022.encyclopedia.presentation.initial_screen.InitialScreen
import com.mka.fifa.world.cup2022.encyclopedia.presentation.matches.MatchesByDateScreen
import com.mka.fifa.world.cup2022.encyclopedia.presentation.matches.MatchesByGoalsScreen
import com.mka.fifa.world.cup2022.encyclopedia.presentation.matches.MatchesByIdScreen
import com.mka.fifa.world.cup2022.encyclopedia.presentation.matches.MatchesScreen
import com.mka.fifa.world.cup2022.encyclopedia.presentation.matches.components.MatchesByIdLineup
import com.mka.fifa.world.cup2022.encyclopedia.presentation.players.PlayersScreen
import com.mka.fifa.world.cup2022.encyclopedia.presentation.team_by_id.TeamByIdScreen
import com.mka.fifa.world.cup2022.encyclopedia.presentation.team_by_id.TeamUpdatesScreen
import com.mka.fifa.world.cup2022.encyclopedia.presentation.team_by_id.TeamsScreen
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
                    NavHost(navController = navController, startDestination = Screen.InitialScreen.route) {
                        composable(route = Screen.InitialScreen.route) { InitialScreen(navController)}
                        composable(route = Screen.MatchesScreen.route) { MatchesScreen(navController)}
                        composable(route = Screen.MatchesByDateScreen.route + "/{matchesByDate}") { MatchesByDateScreen(navController) }
                        composable(route = Screen.MatchesByGoalsScreen.route + "/{matchesByGoals}") { MatchesByGoalsScreen(navController) }
                        composable(route = Screen.MatchesByIdScreen.route + "/{matchesById}") { MatchesByIdScreen(navController) }
                        composable(route = Screen.MatchesByIdLineupScreen.route + "/{matchesById}") { MatchesByIdLineup() }
                        composable(route = Screen.GroupsScreen.route) { GroupsScreen(navController) }
                        composable(route = Screen.TeamsScreen.route) { TeamsScreen(navController) }
                        composable(route = Screen.TeamById.route + "/{teamId}") { TeamByIdScreen() }
                        composable(route = Screen.TeamUpdatesById.route + "/{teamId}") { TeamUpdatesScreen(navController) }
                        composable(route = Screen.PlayersScreen.route) { PlayersScreen() }
                    }
                }
            }
        }
    }
}