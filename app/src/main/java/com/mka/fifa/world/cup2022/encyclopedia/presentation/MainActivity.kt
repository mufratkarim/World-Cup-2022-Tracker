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
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mka.fifa.world.cup2022.encyclopedia.presentation.groups.GroupsScreen
import com.mka.fifa.world.cup2022.encyclopedia.presentation.initial_screen.InitialScreen
import com.mka.fifa.world.cup2022.encyclopedia.presentation.matches.MatchesScreen
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
                        composable(route = Screen.InitialScreen.route) { InitialScreen(navController = navController)}
                        composable(route = Screen.MatchesScreen.route) { MatchesScreen()}
                        //composable(route = Screen.GroupsScreen.route) { GroupsScreen() }
                        //composable(route = Screen.TeamById.route + "/{teamId}") { TeamByIdScreen()}
                        //composable(route = Screen.PlayersScreen.route) { PlayerScreen()}
                    }
                }
            }
        }
    }
}