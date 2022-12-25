package com.mka.fifa.world.cup2022.encyclopedia.presentation.matches.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.mka.fifa.world.cup2022.encyclopedia.R
import com.mka.fifa.world.cup2022.encyclopedia.data.remote.model.Matches
import com.mka.fifa.world.cup2022.encyclopedia.presentation.common.Heading
import com.mka.fifa.world.cup2022.encyclopedia.presentation.common.ScreenText

@Composable
fun MatchesScreenItems(
    navController: NavController,
    state: MatchesState
) {
    Image(
        painter = painterResource(id = R.drawable.matches),
        contentDescription = "Matches Image",
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth(),
        contentScale = ContentScale.Crop
    )

    Heading(
        title1 = "Button",
        title2 = "Home-Away",
        title3 = "Sort",
        backgroundColor = Color.DarkGray.copy(0.5f),
        screenSize1 = 0.3f,
        screenSize2 = 0.65f,
        screenSize3 = 0.85f,
        padding = 10,
        color = Color.White,
        style = MaterialTheme.typography.h6,
        textAlign1 = TextAlign.Center,
        textAlign2 = TextAlign.Start,
        textAlign3 = TextAlign.Start
    )
    MatchesDropdownCategory(navController)
    Divider(color = colorResource(id = R.color.lime), thickness = 2.dp, modifier = Modifier.offset(y = 48.dp))
    Divider(color = colorResource(id = R.color.lavender), thickness = 2.dp, modifier = Modifier.offset(y = 50.dp))
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 60.dp)
            .offset(y = 60.dp)
    ) {
        items(state.matches) { item: Matches ->
            MatchesItem(matches = item, navController = navController)
        }
    }

    if (state.error.isNotBlank()) {
        Row(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            ScreenText(title = state.error, screenSize = 1f, padding = 20, fontWeight = FontWeight.Bold)
        }

    }

    if (state.isLoading) {
        Row(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            CircularProgressIndicator()
        }

    }
}