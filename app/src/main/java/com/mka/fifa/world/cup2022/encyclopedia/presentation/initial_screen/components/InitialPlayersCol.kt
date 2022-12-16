package com.mka.fifa.world.cup2022.encyclopedia.presentation.initial_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.mka.fifa.world.cup2022.encyclopedia.data.remote.model.TeamById
import com.mka.fifa.world.cup2022.encyclopedia.presentation.Screen

@Composable
fun InitialPlayersCol(
    navController: NavController
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
            .clickable { navController.navigate(Screen.PlayersScreen.route) },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Players",
            style = MaterialTheme.typography.h4,
            color = Color.White,
            overflow = TextOverflow.Ellipsis,
            textDecoration = TextDecoration.Underline,
            fontFamily = FontFamily.Monospace,
            modifier = Modifier.background(Color.Blue.copy(alpha = 0.15f))
        )
    }
}