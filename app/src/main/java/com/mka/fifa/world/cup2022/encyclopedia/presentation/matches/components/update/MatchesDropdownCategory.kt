package com.mka.fifa.world.cup2022.encyclopedia.presentation.matches.components.old

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.mka.fifa.world.cup2022.encyclopedia.presentation.Screen

@Composable
fun MatchesDropdownCategory(
    navController: NavController
) {
    var expanded by remember { mutableStateOf(false) }
    val items = listOf("↑Date", "↓Date")
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
                                navController.navigate(Screen.MatchesInitialScreen.route)
                            }
                            1 -> {
                                navController.popBackStack()
                                navController.navigate(Screen.MatchesReverseScreen.route)

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