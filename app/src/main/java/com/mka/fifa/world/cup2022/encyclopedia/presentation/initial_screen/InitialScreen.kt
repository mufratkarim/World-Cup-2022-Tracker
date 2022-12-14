package com.mka.fifa.world.cup2022.encyclopedia.presentation.initial_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.LinearGradient
import androidx.compose.ui.res.colorResource
import androidx.navigation.NavController
import com.mka.fifa.world.cup2022.encyclopedia.R
import com.mka.fifa.world.cup2022.encyclopedia.presentation.Screen
import com.mka.fifa.world.cup2022.encyclopedia.presentation.initial_screen.components.InitialGroupsCol
import com.mka.fifa.world.cup2022.encyclopedia.presentation.initial_screen.components.InitialMatchesCol
import com.mka.fifa.world.cup2022.encyclopedia.presentation.initial_screen.components.InitialPlayersCol
import com.mka.fifa.world.cup2022.encyclopedia.presentation.initial_screen.components.InitialTeamsCol

@Composable
fun InitialScreen(
    navController: NavController
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.sweepGradient(
                    listOf(
                        colorResource(id = com.google.android.material.R.color.material_blue_grey_800),
                        colorResource(id = androidx.appcompat.R.color.background_material_light)
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