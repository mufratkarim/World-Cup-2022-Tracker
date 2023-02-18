package com.mka.fifa.world.cup2022.encyclopedia.presentation.players

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.mka.fifa.world.cup2022.encyclopedia.R
import com.mka.fifa.world.cup2022.encyclopedia.common.Constants
import com.mka.fifa.world.cup2022.encyclopedia.presentation.Screen
import com.mka.fifa.world.cup2022.encyclopedia.presentation.common.ButtonText
import com.mka.fifa.world.cup2022.encyclopedia.presentation.players.viewmodel.PlayersViewModel
import com.mka.fifa.world.cup2022.encyclopedia.presentation.teams.update.viewmodel.TeamsViewModel

@SuppressLint("SetJavaScriptEnabled")
@Composable
fun TeamsScreen(
    navController: NavController,
    viewModel: TeamsViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    Box(
        modifier = Modifier
            .fillMaxSize()

    ) {
        Image(
            painter = painterResource(id = R.drawable.teams3),
            contentDescription = "Teams Image",
            modifier = Modifier.matchParentSize(),
            contentScale = ContentScale.FillBounds,
            alpha = 0.5f
        )

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
        ) {
            items(state.teams) { team ->
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.DarkGray.copy(alpha = 0.7f))
                        .padding(6.dp)
                    ,
                ) {

                    Row(modifier = Modifier
                        .fillMaxWidth()
                        .padding(6.dp)
                    ) {

                        Image(
                            painter = rememberAsyncImagePainter(
                                "https://raw.githubusercontent.com/mufratkarim/mufratkarim/main/flags/${
                                    team.team.substring(
                                        0,
                                        3
                                    ).lowercase()
                                }.png"
                            ),
                            contentDescription = "Team Image",
                            modifier = Modifier
                                .fillMaxWidth(0.3f)
                                .height(50.dp),
                            contentScale = ContentScale.Crop
                        )

                        OutlinedButton(
                            onClick = { navController.navigate("team/" + team.team) },
                            modifier = Modifier
                                .fillMaxWidth()
                                .fillMaxHeight()
                                .padding(horizontal = 8.dp),
                            shape = RoundedCornerShape(8.dp),
                            colors = ButtonDefaults.buttonColors(
                                backgroundColor = Color.Green.copy(0.3f),
                            )
                        ) {
                            ButtonText(
                                title = team.team,
                                style = MaterialTheme.typography.h6,
                                color = Color.Yellow
                            )

                        }


                    }

                    Divider(color = Color.Yellow)
                }
            }
        }

    }


}