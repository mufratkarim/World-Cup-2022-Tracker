@file:Suppress("RemoveRedundantQualifierName")

package com.mka.fifa.world.cup2022.encyclopedia.presentation.groups.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.mka.fifa.world.cup2022.encyclopedia.R
import com.mka.fifa.world.cup2022.encyclopedia.data.remote.model.Groups
import com.mka.fifa.world.cup2022.encyclopedia.presentation.Screen

@Composable
fun GroupsItem(
    groups: Groups,
    navController: NavController
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
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
                    color = Color.DarkGray,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.background(Color.White.copy(0.5f))
                )
                Divider(color = Color.DarkGray, thickness = 2.dp)
                group.teams.map {
                    Row(
                        modifier = Modifier
                            .fillMaxSize()
                            .fillMaxWidth()
                            .background(Color.White.copy(0.8f))
                            .padding(6.dp),
                        horizontalArrangement = Arrangement.SpaceAround
                    ) {
                        OutlinedButton(
                            onClick = { navController.navigate(Screen.TeamById.route + "/${it.country}") },
                            colors = ButtonDefaults.buttonColors(MaterialTheme.colors.secondaryVariant),
                            shape = CircleShape
                        ) {
                            Text(
                                text = it.name, style = MaterialTheme.typography.h5,
                                color = Color.DarkGray,
                                modifier = Modifier
                                    .fillMaxWidth(0.6f)
                                    .padding(vertical = 6.dp),
                                fontWeight = FontWeight.Bold,
                                textDecoration = TextDecoration.Underline,
                                textAlign = TextAlign.Center
                            )
                        }

                        Text(
                            text = "${it.group_points} points", style = MaterialTheme.typography.h6,
                            color = Color.DarkGray,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(12.dp)
                        )

                    }
                }
                Spacer(modifier = Modifier.size(4.dp))
            }
        }
    }
}