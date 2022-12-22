package com.mka.fifa.world.cup2022.encyclopedia.presentation.matches.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.mka.fifa.world.cup2022.encyclopedia.R
import com.mka.fifa.world.cup2022.encyclopedia.data.remote.model.Matches
import com.mka.fifa.world.cup2022.encyclopedia.presentation.matches.common.MatchesScreenText

@Composable
fun MatchesItems(
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
    Row {

        MatchesScreenText(title = "Match #", screenSize = 0.15f, padding = 6, fontWeight = FontWeight.Bold)
        MatchesScreenText(title = "Home - Away", screenSize = 0.7f, 12, fontWeight = FontWeight.Bold)
        MatchesScreenText(title = "Button", screenSize = 1f , padding = 12, fontWeight = FontWeight.Bold)

        MatchesDropdownCategory(navController)

    }
    Divider(color = Color.Cyan, thickness = 4.dp, modifier = Modifier.offset(y = 48.dp))
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
            MatchesScreenText(title = state.error, screenSize = 1f, padding = 20, fontWeight = FontWeight.Bold)
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