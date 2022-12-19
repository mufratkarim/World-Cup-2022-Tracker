package com.mka.fifa.world.cup2022.encyclopedia.presentation.matches.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.mka.fifa.world.cup2022.encyclopedia.R
import com.mka.fifa.world.cup2022.encyclopedia.data.remote.model.Matches
import com.mka.fifa.world.cup2022.encyclopedia.presentation.matches.viewmodel.MatchesByDateViewModel
import com.mka.fifa.world.cup2022.encyclopedia.presentation.matches.viewmodel.MatchesByGoalsViewModel
import com.mka.fifa.world.cup2022.encyclopedia.presentation.matches.viewmodel.MatchesViewModel
import dagger.hilt.android.lifecycle.HiltViewModel

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
        Text(
            text = "Match #",
            color = Color.White,
            modifier = Modifier
                .fillMaxSize(0.15f)
                .padding(top = 6.dp),
            textAlign = TextAlign.Center,
            fontFamily = FontFamily.Serif,
            fontWeight = FontWeight.Bold,
            fontSize = 15.sp
        )
        Text(
            text = "Home - Away",
            color = Color.White,
            modifier = Modifier
                .fillMaxSize(0.7f)
                .padding(top = 12.dp),
            textAlign = TextAlign.Center,
            fontFamily = FontFamily.Serif,
            fontWeight = FontWeight.Bold,
            fontSize = 15.sp
        )
        Text(
            text = "Button",
            color = Color.White,
            modifier = Modifier
                .padding(top = 12.dp, start = 12.dp),
            fontFamily = FontFamily.Serif,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            fontSize = 15.sp
        )

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
            Text(
                text = state.error,
                color = MaterialTheme.colors.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
            )
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