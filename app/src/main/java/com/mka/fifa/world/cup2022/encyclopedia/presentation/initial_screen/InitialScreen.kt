package com.mka.fifa.world.cup2022.encyclopedia.presentation.initial_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.LinearGradient
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
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
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.world_cup_image),
            contentDescription = "World Cup Image",
            modifier = Modifier.matchParentSize(),
            contentScale = ContentScale.Crop
        )
        Column(modifier = Modifier.fillMaxSize().fillMaxWidth(), verticalArrangement = Arrangement.Center) {
            InitialMatchesCol(navController)
            InitialGroupsCol(navController)
            InitialTeamsCol(navController)
            InitialPlayersCol(navController)
        }




    }

}