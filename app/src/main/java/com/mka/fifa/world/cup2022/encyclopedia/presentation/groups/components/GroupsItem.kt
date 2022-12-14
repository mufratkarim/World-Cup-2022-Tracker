package com.mka.fifa.world.cup2022.encyclopedia.presentation.groups.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import com.mka.fifa.world.cup2022.encyclopedia.R
import com.mka.fifa.world.cup2022.encyclopedia.data.remote.model.Groups

@Composable
fun GroupsItem(
    groups: Groups
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(4.dp)
            .background(
                Brush.linearGradient(
                    listOf(
                        colorResource(id = R.color.purple_200),
                        colorResource(id = R.color.teal_700)
                    )
                )
            )
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(4.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            items(groups.groups) { group ->
                Text(
                    text = "Group ${group.letter}",
                    style = MaterialTheme.typography.h3,
                    fontFamily = FontFamily.Monospace,
                    color = Color.Green.copy(alpha = 0.8f)
                )
                Divider(color = Color.DarkGray, thickness = 3.dp)
                Spacer(modifier = Modifier.size(4.dp))
                group.teams.map {
                    Column {
                        Text(
                            text = it.name, style = MaterialTheme.typography.body2,
                            fontStyle = FontStyle.Italic,
                            color = Color.White,
                            modifier = Modifier.padding(4.dp)
                        )
                    }
                }
                Divider()
                Spacer(modifier = Modifier.size(3.dp))
            }
        }
    }
}