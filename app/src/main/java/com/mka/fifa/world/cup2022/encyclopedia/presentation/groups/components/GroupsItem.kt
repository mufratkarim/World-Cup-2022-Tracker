@file:Suppress("RemoveRedundantQualifierName")

package com.mka.fifa.world.cup2022.encyclopedia.presentation.groups.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.mka.fifa.world.cup2022.encyclopedia.R
import com.mka.fifa.world.cup2022.encyclopedia.data.remote.model.Groups
import com.mka.fifa.world.cup2022.encyclopedia.presentation.Screen
import com.mka.fifa.world.cup2022.encyclopedia.presentation.common.Heading
import com.mka.fifa.world.cup2022.encyclopedia.presentation.common.VerticalDivider

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

                Heading(
                    title1 = "Group ${group.letter} ",
                    title2 = "Points",
                    title3 = "BTN",
                    backgroundColor = colorResource(id = R.color.lavender),
                    screenSize1 = 0.5f,
                    screenSize2 = 0.7f,
                    screenSize3 = 1f,
                    style = MaterialTheme.typography.h6,
                    color = Color.Black,
                    padding = 6,
                    textAlign1 = TextAlign.Center,
                    textAlign2 = TextAlign.Center
                )
                Divider(color = Color.DarkGray, thickness = 2.dp)
                group.teams.map {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(colorResource(id = R.color.light_cyan).copy(0.6f))
                            .height(50.dp)
                    ) {
                        Text(
                            text = it.name, style = MaterialTheme.typography.h6,
                            color = Color.DarkGray,
                            modifier = Modifier
                                .fillMaxWidth(0.5f)
                                .padding(12.dp),
                            fontWeight = FontWeight.Bold,
                            textDecoration = TextDecoration.Underline,
                            textAlign = TextAlign.Center
                        )
                        VerticalDivider(color = Color.Gray)
                        Text(
                            text = "${it.group_points}",
                            color = Color.DarkGray,
                            modifier = Modifier
                                .fillMaxWidth(0.7f)
                                .padding(12.dp),
                            textAlign = TextAlign.Center
                        )
                        VerticalDivider(color = Color.Gray)
                        OutlinedButton(
                            onClick = { navController.navigate(Screen.TeamById.route + "/${it.country}") },
                            modifier = Modifier
                                .fillMaxWidth()
                        ) {
                            Text(text ="\uD83D\uDDB2️️", color = Color.Red)
                        }

                    }

                    Divider(color = Color.Gray)
                }
                Spacer(modifier = Modifier.size(4.dp))
            }
        }
    }
}