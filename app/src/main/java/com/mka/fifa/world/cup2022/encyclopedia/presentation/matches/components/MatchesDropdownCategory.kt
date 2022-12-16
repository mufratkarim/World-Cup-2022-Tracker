package com.mka.fifa.world.cup2022.encyclopedia.presentation.matches.components

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun MatchesDropdownCategory() {
    var expanded by remember { mutableStateOf(false) }
    val items = listOf("↑Date", "↓Date", "Most Goals", "Closest Game")
    val context = LocalContext.current.applicationContext
    var selectedIndex by remember { mutableStateOf(0) }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .fillMaxWidth()
            .wrapContentSize(Alignment.TopStart)
            .padding(top = 12.dp, start = 12.dp)
    ) {
        Text(
            items[selectedIndex],
            modifier = Modifier
                .fillMaxWidth()
                .clickable(onClick = { expanded = true }),
            style = MaterialTheme.typography.caption,
            color = Color.White,
            fontWeight = FontWeight.Bold
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    Color.Cyan
                )
        ) {
            items.forEachIndexed { index, item ->
                DropdownMenuItem(onClick = {
                    selectedIndex = index
                    expanded = false
                }) {
                    Text(text = item)
                    when (selectedIndex) {
                        1 -> {
                            Toast.makeText(context, "Sorting by Date", Toast.LENGTH_SHORT).show()
                        }
                        2 -> {
                            Toast.makeText(context, "Sorting by Total Goals", Toast.LENGTH_SHORT).show()
                        }
                        3 -> {
                            Toast.makeText(context, "Sorting by Closest Games", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            }
        }
    }
}