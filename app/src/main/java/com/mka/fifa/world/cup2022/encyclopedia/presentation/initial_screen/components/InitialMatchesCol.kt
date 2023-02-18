package com.mka.fifa.world.cup2022.encyclopedia.presentation.initial_screen.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.mka.fifa.world.cup2022.encyclopedia.R
import com.mka.fifa.world.cup2022.encyclopedia.presentation.Screen
import com.mka.fifa.world.cup2022.encyclopedia.presentation.common.ButtonText

@Composable
fun InitialMatchesCol(
    navController: NavController
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp),
        contentAlignment = Alignment.TopStart
    ) {
        OutlinedButton(
            onClick = { navController.navigate(Screen.MatchesInitialScreen.route) },
            colors = ButtonDefaults.buttonColors(
                colorResource(id = R.color.purple_500).copy(0.6f),
                Color.Blue.copy(alpha = 0.4f)),
            modifier = Modifier.fillMaxWidth()
        ) {
            ButtonText(title = "Matches", style = MaterialTheme.typography.h4, color = colorResource(id = R.color.light_cyan))
        }

    }
}