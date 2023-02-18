package com.mka.fifa.world.cup2022.encyclopedia.presentation.players

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.util.Log
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
import androidx.compose.runtime.R
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.compose.ui.window.Dialog
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.mka.fifa.world.cup2022.encyclopedia.common.Constants
import com.mka.fifa.world.cup2022.encyclopedia.data.remote.model.update.Players
import com.mka.fifa.world.cup2022.encyclopedia.presentation.common.ButtonText
import com.mka.fifa.world.cup2022.encyclopedia.presentation.common.ScreenText
import com.mka.fifa.world.cup2022.encyclopedia.presentation.common.VerticalDividerThreeRows
import com.mka.fifa.world.cup2022.encyclopedia.presentation.common.VerticalDividerTwoRows
import com.mka.fifa.world.cup2022.encyclopedia.presentation.players.components.FloatingSearchButton
import com.mka.fifa.world.cup2022.encyclopedia.presentation.players.viewmodel.PlayersViewModel
import org.apache.commons.text.similarity.JaroWinklerDistance
import org.apache.commons.text.similarity.JaroWinklerSimilarity

@SuppressLint("SetJavaScriptEnabled")
@Composable
fun PlayersScreen(
    navController: NavController,
    viewModel: PlayersViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    var showNoMatchDialog by remember { mutableStateOf(false) }
    var searchQuery by remember { mutableStateOf("") }
    var showMultipleMatchDialog by remember { mutableStateOf(false) }
    var selectedPlayer by remember { mutableStateOf<Players?>(null) }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .fillMaxHeight()
            .fillMaxWidth()
    ) {

        var searchResult by remember { mutableStateOf<Players?>(null) }
        Scaffold(
            content = {
                // your screen content here
                Image(
                    painter = painterResource(id = com.mka.fifa.world.cup2022.encyclopedia.R.drawable.team4),
                    contentDescription = "Teams Image",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.FillBounds,
                    alpha = 0.5f
                )
                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                ) {
                    item {
                        Row {
                            VerticalDividerThreeRows(
                                title1 = "Position",
                                title2 = "Player Name",
                                title3 = "Country",
                                screenSize1 = 0.25f,
                                screenSize2 = 0.7f,
                                screenSize3 = 1f,
                                style = MaterialTheme.typography.subtitle1,
                                style2 = MaterialTheme.typography.subtitle1,
                                style3 = MaterialTheme.typography.subtitle1,
                                color1 = Color.Green,
                                color2 = colorResource(id = com.mka.fifa.world.cup2022.encyclopedia.R.color.light_cyan),
                                color3 = colorResource(id = com.mka.fifa.world.cup2022.encyclopedia.R.color.lavender),
                                dividerColor = Color.Transparent,
                                fontWeight = FontWeight.Bold,
                                padding = 8,
                                textDecoration = TextDecoration.Underline,
                            )
                        }
                    }
                    items(state.players) { player ->
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(Color.DarkGray.copy(alpha = 0.7f)),
                        ) {

                            Row(
                                modifier = Modifier
                                    .fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                OutlinedButton(
                                    onClick = { navController.navigate("player/" + player.player) },
                                    modifier = Modifier
                                        .fillMaxWidth(0.25f)
                                        .fillMaxHeight()
                                        .padding(horizontal = 8.dp),
                                    shape = RoundedCornerShape(8.dp),
                                    colors = ButtonDefaults.buttonColors(
                                        backgroundColor = Color.Green.copy(0.3f),
                                    )
                                ) {
                                    ButtonText(
                                        title = player.position,
                                        style = MaterialTheme.typography.subtitle1,
                                        color = Color.White
                                    )

                                }
                                VerticalDividerTwoRows(
                                    title1 = "${player.player}\n${player.games} games, ${player.goals} goals, ${player.assists} assists",
                                    title2 = player.team,
                                    screenSize1 = 0.7f,
                                    screenSize2 = 1f,
                                    style1 = MaterialTheme.typography.body1,
                                    style2 = MaterialTheme.typography.body1,
                                    color1 = colorResource(id = com.mka.fifa.world.cup2022.encyclopedia.R.color.light_cyan),
                                    color2 = colorResource(id = com.mka.fifa.world.cup2022.encyclopedia.R.color.lavender),
                                    dividerColor = Color.Yellow,
                                    padding = 8,
                                    height = 100.dp
                                )


                            }

                            Divider(color = Color.Yellow)
                        }

                    }
                }
            },
            floatingActionButton = {
                FloatingSearchButton { searchText ->
                    searchQuery = searchText
                    val filteredPlayers =
                        state.players.filter { it.player.contains(searchQuery, ignoreCase = true) }
                    searchResult =
                        filteredPlayers.maxByOrNull { it.player.count { c -> c in searchQuery } }
                    Log.e("TAG", "Filtered Players: " + filteredPlayers)
                    Log.e("TAG", "Player: " + searchResult)

                    if (searchResult == null) {
                        showNoMatchDialog = true
                    } else if (filteredPlayers.size == 1) {
                        navController.navigate("player/" + searchResult?.player)
                    } else {
                        showMultipleMatchDialog = true
                    }

                }
            }
        )

        if (showNoMatchDialog) {
            AlertDialog(
                onDismissRequest = { showNoMatchDialog = false },
                title = { Text("No matching players found") },
                confirmButton = {
                    Button(onClick = { showNoMatchDialog = false }) {
                        Text("OK")
                    }
                }
            )
        }

        if (showMultipleMatchDialog) {
            Dialog(
                onDismissRequest = { showMultipleMatchDialog = false },
                content = {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.DarkGray.copy(alpha = 0.7f))
                    ) {
                        ScreenText(
                            "Select a player",
                            style = MaterialTheme.typography.h4,
                            padding = 0,
                            screenSize = 1f,
                            color = Color.White
                        )
                        state.players.filter { it.player.contains(searchQuery, ignoreCase = true) }
                            .forEach { player ->
                                TextButton(
                                    onClick = {
                                        selectedPlayer = player
                                        showMultipleMatchDialog = false
                                        navController.navigate("player/" + selectedPlayer?.player)
                                    },
                                    modifier = Modifier.fillMaxWidth()
                                ) {
                                    ScreenText(
                                        title = "Player: ${player.player}, Team: ${player.team}",
                                        textAlign = TextAlign.Start,
                                        screenSize = 1f,
                                        padding = 8,
                                        color = colorResource(
                                            id = com.mka.fifa.world.cup2022.encyclopedia.R.color.light_cyan
                                        )
                                    )
                                }
                                Divider()
                            }
//                        navController.popBackStack()
//                        navController.navigate("player/" + selectedPlayer?.player)
                    }
                }
            )
        }


    }


}

@Composable
fun oldPlayersScreen() {
    val url = Constants.PLAYERS_STATS_URL
    var backEnabled by remember { mutableStateOf(false) }
    var webView: WebView? = null
    AndroidView(factory = { context ->
        WebView(context).apply {
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
            settings.loadsImagesAutomatically = true
            settings.javaScriptEnabled = true
            settings.builtInZoomControls = true
            scrollBarStyle = View.SCROLLBARS_INSIDE_OVERLAY
            webViewClient = object : WebViewClient() {
                override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                    if (view != null) {
                        backEnabled = view.canGoBack()
                    }
                }
            }
            loadUrl(url)
            webView = this
        }
    }, update = {
        webView = it
    })
    BackHandler(enabled = backEnabled) {
        webView?.goBack()
    }
}