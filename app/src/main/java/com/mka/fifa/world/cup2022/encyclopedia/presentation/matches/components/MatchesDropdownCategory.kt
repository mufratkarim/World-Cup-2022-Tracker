package com.mka.fifa.world.cup2022.encyclopedia.presentation.matches.components

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.rounded.DateRange
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.mka.fifa.world.cup2022.encyclopedia.presentation.Screen

@Composable
fun MatchesDropdownCategory(
    navController: NavController
) {
    var expanded by remember { mutableStateOf(false) }
    val items = listOf("↑Date", "↓Date", "Most Goals", "Closest Game", "↑Home Team", "↑Away Team")
    Box(
        modifier = Modifier
            .fillMaxWidth(1f)
            .wrapContentSize(Alignment.TopEnd)


    ) {
        // options button
        IconButton(onClick = {
            expanded = true
        }) {
            Icon(
                imageVector = Icons.Filled.Refresh ,
                contentDescription = "Open Options",
                tint = Color.White
            )
        }

        // drop down menu
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = {
                expanded = false
            }
        ) {
            // adding items
            items.forEachIndexed { itemIndex, itemValue ->
                DropdownMenuItem(
                    onClick = {
                        when (itemIndex) {
                            0 -> {
                                navController.popBackStack()
                                navController.navigate(Screen.MatchesByDateScreen.route + "/AESC")
                            }
                            1 -> {
                                navController.popBackStack()
                                navController.navigate(Screen.MatchesByDateScreen.route + "/DESC")

                                //Toast.makeText(context, "Sorting by Date", Toast.LENGTH_SHORT).show()
                            }
                            2 -> {
                                navController.popBackStack()
                                navController.navigate(Screen.MatchesByGoalsScreen.route + "/total_goals")

                            }
                            3 -> {
                                navController.popBackStack()
                                navController.navigate(Screen.MatchesByGoalsScreen.route + "/closest_scores")

                            }
                            4 -> {
                                navController.popBackStack()
                                navController.navigate(Screen.MatchesByGoalsScreen.route + "/home_team_goals")
                            }
                            5 -> {
                                navController.popBackStack()
                                navController.navigate(Screen.MatchesByGoalsScreen.route + "/away_team_goals")
                            }
                        }
                        expanded = false
                    },
                    enabled = true
                ) {
                    Text(text = itemValue)
                }
            }
        }
    }
}