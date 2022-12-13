package com.mka.fifa.world.cup2022.encyclopedia.presentation.initial_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.mka.fifa.world.cup2022.encyclopedia.data.remote.model.TeamById
import com.mka.fifa.world.cup2022.encyclopedia.presentation.Screen
import com.mka.fifa.world.cup2022.encyclopedia.presentation.groups.GroupsViewModel
import com.mka.fifa.world.cup2022.encyclopedia.presentation.initial_screen.components.InitialGroupsCol
import com.mka.fifa.world.cup2022.encyclopedia.presentation.initial_screen.components.InitialMatchesCol
import com.mka.fifa.world.cup2022.encyclopedia.presentation.initial_screen.components.InitialPlayersCol
import com.mka.fifa.world.cup2022.encyclopedia.presentation.initial_screen.components.InitialTeamsCol
import com.mka.fifa.world.cup2022.encyclopedia.presentation.matches.MatchesViewModel
import com.mka.fifa.world.cup2022.encyclopedia.presentation.team_by_id.TeamByIdViewModel

@Composable
fun InitialScreen(
    navController: NavController
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.linearGradient(
                    listOf(
                        Color.Gray,
                        Color.LightGray,
                        Color.White,
                        Color.Transparent
                    )
                )
            )
    ) {
        InitialMatchesCol(navController)
        InitialGroupsCol(navController)
        InitialTeamsCol(navController)
        InitialPlayersCol(navController)

    }

}