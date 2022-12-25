package com.mka.fifa.world.cup2022.encyclopedia.presentation.teams

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.mka.fifa.world.cup2022.encyclopedia.R
import com.mka.fifa.world.cup2022.encyclopedia.presentation.Screen
import com.mka.fifa.world.cup2022.encyclopedia.presentation.common.ScreenText
import com.mka.fifa.world.cup2022.encyclopedia.presentation.common.VerticalDivider
import com.mka.fifa.world.cup2022.encyclopedia.presentation.common.VerticalDividerThreeRows
import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter
import java.util.*

@Composable
fun TeamUpdatesScreen(
    navController: NavController,
    viewModel: TeamUpdatesViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    Image(
        painter = painterResource(id = R.drawable.teams3),
        contentDescription = "Team Updates Image",
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .fillMaxSize(),
        contentScale = ContentScale.Crop
    )
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        item {
            
            VerticalDividerThreeRows(
                title1 = "Match",
                title2 = "Result",
                title3 = "Winner",
                screenSize1 = 0.3f,
                screenSize2 = 0.60f,
                screenSize3 = 1f,
                style = MaterialTheme.typography.h5,
                color1 = Color.White,
                color2 = Color.White,
                color3 = Color.White,
                dividerColor = Color.Yellow,
                padding = 6
            )
            Divider(color = Color.LightGray)
        }

        items(state.matches) { match ->

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.DarkGray.copy(alpha = 0.8f))
                    .padding(6.dp)
                    .height(120.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Column {
                    Text(
                        text = "${match.home_team.name} - ${match.away_team.name}",
                        modifier = Modifier
                            .fillMaxWidth(0.3f)
                            .padding(6.dp),
                        textAlign = TextAlign.Center,
                        fontFamily = FontFamily.Serif,
                        color = Color.Green,
                        fontSize = 15.sp
                    )
                    OutlinedButton(
                        onClick = { navController.navigate(Screen.MatchesByIdScreen.route + "/${match.id}") },
                        colors = ButtonDefaults.buttonColors(
                            Color.Green.copy(alpha = 0.6f)
                        ),
                        shape = RectangleShape,
                        modifier = Modifier.fillMaxWidth(0.3f)
                    ) {
                        Text(
                            text = "Stats",
                            style = MaterialTheme.typography.subtitle1,
                            color = Color.Black,
                            overflow = TextOverflow.Ellipsis,
                            textDecoration = TextDecoration.Underline,
                            fontFamily = FontFamily.Monospace,
                        )
                    }

                }

                VerticalDivider(color = Color.Yellow)

                Text(
                    text = "Score: ${match.home_team.goals} - ${match.away_team.goals}"
                            + (if (match.home_team.penalties > 0 || match.away_team.penalties > 0) "\r\nPenalties: ${match.home_team.penalties} - ${match.away_team.penalties}" else "")
                            + "\r\nTime: ${
                        match.datetime.let { date ->
                            val odt = OffsetDateTime.parse(date)
                            val dtf =
                                DateTimeFormatter.ofPattern("h:mm a, MMM dd", Locale.ENGLISH)
                            dtf.format(odt)
                        }
                    }",
                    modifier = Modifier
                        .fillMaxWidth(0.60f)
                        .padding(6.dp),
                    textAlign = TextAlign.Center,
                    fontFamily = FontFamily.Serif,
                    color = Color.Cyan,
                    fontSize = 15.sp
                )
                VerticalDivider(color = Color.Yellow)
                Column  {
                    Text(
                        text = match.winner, modifier = Modifier
                            .fillMaxWidth()
                            .padding(6.dp),
                        textAlign = TextAlign.Center,
                        fontFamily = FontFamily.Serif,
                        color = Color.Yellow,
                        fontSize = 15.sp
                    )

                    OutlinedButton(
                        onClick = { navController.navigate(Screen.MatchesByIdLineupScreen.route + "/${match.id}") },
                        colors = ButtonDefaults.buttonColors(
                            Color.Yellow.copy(alpha = 0.6f)
                        ),
                        shape = RectangleShape,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = "Lineup",
                            style = MaterialTheme.typography.subtitle1,
                            color = Color.Black,
                            overflow = TextOverflow.Ellipsis,
                            textDecoration = TextDecoration.Underline,
                            fontFamily = FontFamily.Monospace,
                        )
                    }
                }

            }

            Divider(color = Color.LightGray)


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
            ScreenText(title = state.error, screenSize = 1f, padding = 20)
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