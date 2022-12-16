@file:Suppress("RemoveRedundantQualifierName")

package com.mka.fifa.world.cup2022.encyclopedia.presentation.matches

import android.widget.Spinner
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.HorizontalAlignmentLine
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.mka.fifa.world.cup2022.encyclopedia.R
import com.mka.fifa.world.cup2022.encyclopedia.data.remote.model.Matches
import com.mka.fifa.world.cup2022.encyclopedia.presentation.Screen
import com.mka.fifa.world.cup2022.encyclopedia.presentation.matches.components.MatchesDropdownCategory
import com.mka.fifa.world.cup2022.encyclopedia.presentation.matches.components.MatchesItem

@Composable
fun MatchesScreen(
    viewModel: MatchesViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.matches),
            contentDescription = "Matches Image",
            modifier = Modifier.matchParentSize(),
            contentScale = ContentScale.Crop
        )
        Row {
            Text(
                text = "Match Num",
                color = Color.White,
                modifier = Modifier
                    .fillMaxSize(0.15f)
                    .padding(top = 6.dp),
                textAlign = TextAlign.Center,
                fontFamily = FontFamily.Serif,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Home - Away",
                color = Color.White,
                modifier = Modifier
                    .fillMaxSize(0.7f)
                    .padding(top = 12.dp),
                textAlign = TextAlign.Center,
                fontFamily = FontFamily.Serif,
                fontWeight = FontWeight.Bold
            )

            MatchesDropdownCategory()

        }
        Divider(color = Color.Cyan, thickness = 4.dp, modifier = Modifier.offset(y = 48.dp))

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 60.dp)
                .offset(y = 60.dp)
        ) {
            items(state.matches) { item: Matches ->
                MatchesItem(matches = item)
            }
        }

        if (state.error.isNotBlank()) {
            Text(
                text = state.error,
                color = MaterialTheme.colors.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .align(Alignment.Center)

            )
        }

        if (state.isLoading) {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }

}