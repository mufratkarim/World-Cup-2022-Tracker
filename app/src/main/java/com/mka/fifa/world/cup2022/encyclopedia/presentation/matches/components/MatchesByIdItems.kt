package com.mka.fifa.world.cup2022.encyclopedia.presentation.matches.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.mka.fifa.world.cup2022.encyclopedia.R
import com.mka.fifa.world.cup2022.encyclopedia.common.Constants
import com.mka.fifa.world.cup2022.encyclopedia.presentation.common.*

@Composable
fun MatchesByIdItems(
    state: MatchesByIdState
) {
    Image(
        painter = painterResource(id = R.drawable.team4),
        contentDescription = "Matches Image",
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth(),
        contentScale = ContentScale.Crop
    )
    state.matches?.let { match ->
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
                .verticalScroll(rememberScrollState()),
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = rememberAsyncImagePainter("https://raw.githubusercontent.com/mufratkarim/mufratkarim/main/flags/${match.home_team.country.lowercase()}.png"),
                    contentDescription = "Matches Image",
                    modifier = Modifier
                        .fillMaxWidth(0.3f)
                        .height(75.dp),
                    contentScale = ContentScale.Crop
                )

                ScreenText(
                    title = " ${match.stage_name} ",
                    screenSize = 0.6f,
                    style = MaterialTheme.typography.h5,
                    color = Color.White,
                    padding = 3,
                    fontWeight = FontWeight.Bold
                )

                Image(
                    painter = rememberAsyncImagePainter("https://raw.githubusercontent.com/mufratkarim/mufratkarim/main/flags/${match.away_team.country.lowercase()}.png"),
                    contentDescription = "Matches Image",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(75.dp),
                    contentScale = ContentScale.Crop
                )
            }

            Heading(
                title1 = " ${match.home_team.name}",
                title2 = " VS ",
                title3 = " ${match.away_team.name}",
                backgroundColor = colorResource(id = R.color.light_cyan),
                screenSize1 = 0.4f,
                screenSize2 = 0.35f,
                screenSize3 = 1f,
                style = MaterialTheme.typography.h6,
                color = Color.Black,
                padding = 12,
                fontWeight = FontWeight.Bold
            )

            VerticalDividerTwoRows(
                title1 = "Winner",
                title2 = match.winner,
                screenSize1 = 0.5f,
                screenSize2 = 1f,
                style1 = MaterialTheme.typography.body1,
                style2 = MaterialTheme.typography.body2,
                color1 = colorResource(id = R.color.lavender),
                color2 = colorResource(id = R.color.light_cyan),
                dividerColor = Color.Yellow,
                padding = 6,
                fontWeight = FontWeight.Bold
            )
            Divider(color = Color.LightGray)
            VerticalDividerTwoRows(
                title1 = "Venue",
                title2 = match.venue,
                screenSize1 = 0.5f,
                screenSize2 = 1f,
                style1 = MaterialTheme.typography.body1,
                style2 = MaterialTheme.typography.body2,
                color1 = colorResource(id = R.color.lavender),
                color2 = colorResource(id = R.color.light_cyan),
                dividerColor = Color.Yellow,
                padding = 6,
                fontWeight = FontWeight.Bold
            )
            Divider(color = Color.LightGray)
            VerticalDividerTwoRows(
                title1 = "Location",
                title2 = match.location,
                screenSize1 = 0.5f,
                screenSize2 = 1f,
                style1 = MaterialTheme.typography.body1,
                style2 = MaterialTheme.typography.body2,
                color1 = colorResource(id = R.color.lavender),
                color2 = colorResource(id = R.color.light_cyan),
                dividerColor = Color.Yellow,
                padding = 6,
                fontWeight = FontWeight.Bold
            )
            Divider(color = Color.LightGray)
            VerticalDividerTwoRows(
                title1 = "Attendance",
                title2 = match.attendance,
                screenSize1 = 0.5f,
                screenSize2 = 1f,
                style1 = MaterialTheme.typography.body1,
                style2 = MaterialTheme.typography.body2,
                color1 = colorResource(id = R.color.lavender),
                color2 = colorResource(id = R.color.light_cyan),
                dividerColor = Color.Yellow,
                padding = 6,
                fontWeight = FontWeight.Bold
            )
            Divider(color = Color.LightGray)
            val time = Constants.returnDate(match.datetime, "h:mm a, MMM dd")
            VerticalDividerTwoRows(
                title1 = "Time",
                title2 = time,
                screenSize1 = 0.5f,
                screenSize2 = 1f,
                style1 = MaterialTheme.typography.body1,
                style2 = MaterialTheme.typography.body2,
                color1 = colorResource(id = R.color.lavender),
                color2 = colorResource(id = R.color.light_cyan),
                dividerColor = Color.Yellow,
                padding = 6,
                fontWeight = FontWeight.Bold
            )
            Divider(color = Color.LightGray)
            VerticalDividerThreeRows(
                title1 = " ${match.home_team.goals} ",
                title2 = " Goals ",
                title3 = " ${match.away_team.goals} ",
                screenSize1 = 0.3f,
                screenSize2 = 0.6f,
                screenSize3 = 1f,
                style = MaterialTheme.typography.body1,
                color1 = colorResource(id = R.color.light_cyan),
                color2 = colorResource(id = R.color.lavender),
                color3 = colorResource(id = R.color.light_cyan),
                dividerColor = Color.Yellow,
                padding = 0
            )

            if (match.home_team.penalties > 0 || match.away_team.penalties > 0) {
                VerticalDividerThreeRows(
                    title1 = " ${match.home_team.penalties} ",
                    title2 = " Penalties ",
                    title3 = " ${match.away_team.penalties} ",
                    screenSize1 = 0.3f,
                    screenSize2 = 0.6f,
                    screenSize3 = 1f,
                    style = MaterialTheme.typography.body1,
                    color1 = colorResource(id = R.color.light_cyan),
                    color2 = colorResource(id = R.color.lavender),
                    color3 = colorResource(id = R.color.light_cyan),
                    dividerColor = Color.Yellow,
                    padding = 0
                )
            }
            Divider(color = Color.LightGray)
            VerticalDividerThreeRows(
                title1 = " ${match.home_team_statistics.attempts_on_goal} ",
                title2 = " Shot Attempts ",
                title3 = " ${match.away_team_statistics.attempts_on_goal} ",
                screenSize1 = 0.3f,
                screenSize2 = 0.6f,
                screenSize3 = 1f,
                style = MaterialTheme.typography.body1,
                color1 = colorResource(id = R.color.light_cyan),
                color2 = colorResource(id = R.color.lavender),
                color3 = colorResource(id = R.color.light_cyan),
                dividerColor = Color.Yellow,
                padding = 0
            )

            VerticalDividerThreeRows(
                title1 = " ${match.home_team_statistics.on_target} ",
                title2 = " On Target ",
                title3 = " ${match.away_team_statistics.on_target} ",
                screenSize1 = 0.3f,
                screenSize2 = 0.6f,
                screenSize3 = 1f,
                style = MaterialTheme.typography.body1,
                color1 = colorResource(id = R.color.light_cyan),
                color2 = colorResource(id = R.color.lavender),
                color3 = colorResource(id = R.color.light_cyan),
                dividerColor = Color.Yellow,
                padding = 0
            )

            VerticalDividerThreeRows(
                title1 = " ${match.home_team_statistics.off_target} ",
                title2 = " Off Target ",
                title3 = " ${match.away_team_statistics.off_target} ",
                screenSize1 = 0.3f,
                screenSize2 = 0.6f,
                screenSize3 = 1f,
                style = MaterialTheme.typography.body1,
                color1 = colorResource(id = R.color.light_cyan),
                color2 = colorResource(id = R.color.lavender),
                color3 = colorResource(id = R.color.light_cyan),
                dividerColor = Color.Yellow,
                padding = 0
            )

            VerticalDividerThreeRows(
                title1 = " ${match.home_team_statistics.blocked} ",
                title2 = " Blocked ",
                title3 = " ${match.away_team_statistics.blocked} ",
                screenSize1 = 0.3f,
                screenSize2 = 0.6f,
                screenSize3 = 1f,
                style = MaterialTheme.typography.body1,
                color1 = colorResource(id = R.color.light_cyan),
                color2 = colorResource(id = R.color.lavender),
                color3 = colorResource(id = R.color.light_cyan),
                dividerColor = Color.Yellow,
                padding = 0
            )
            Divider(color = Color.LightGray)

            VerticalDividerThreeRows(
                title1 = " ${match.home_team_statistics.num_passes} ",
                title2 = " Total Passes ",
                title3 = " ${match.away_team_statistics.num_passes} ",
                screenSize1 = 0.3f,
                screenSize2 = 0.6f,
                screenSize3 = 1f,
                style = MaterialTheme.typography.body1,
                color1 = colorResource(id = R.color.light_cyan),
                color2 = colorResource(id = R.color.lavender),
                color3 = colorResource(id = R.color.light_cyan),
                dividerColor = Color.Yellow,
                padding = 0
            )

            VerticalDividerThreeRows(
                title1 = " ${match.home_team_statistics.passes_completed} ",
                title2 = " Successful Passes ",
                title3 = " ${match.away_team_statistics.passes_completed} ",
                screenSize1 = 0.3f,
                screenSize2 = 0.6f,
                screenSize3 = 1f,
                style = MaterialTheme.typography.body1,
                color1 = colorResource(id = R.color.light_cyan),
                color2 = colorResource(id = R.color.lavender),
                color3 = colorResource(id = R.color.light_cyan),
                dividerColor = Color.Yellow,
                padding = 0
            )

            Divider(color = Color.LightGray)
            VerticalDividerThreeRows(
                title1 = " ${match.home_team_statistics.fouls_committed} ",
                title2 = " Fouls ",
                title3 = " ${match.away_team_statistics.fouls_committed} ",
                screenSize1 = 0.3f,
                screenSize2 = 0.6f,
                screenSize3 = 1f,
                style = MaterialTheme.typography.body1,
                color1 = colorResource(id = R.color.light_cyan),
                color2 = colorResource(id = R.color.lavender),
                color3 = colorResource(id = R.color.light_cyan),
                dividerColor = Color.Yellow,
                padding = 0
            )

            VerticalDividerThreeRows(
                title1 = " ${match.home_team_statistics.yellow_cards} ",
                title2 = " Yellow Cards ",
                title3 = " ${match.away_team_statistics.yellow_cards} ",
                screenSize1 = 0.3f,
                screenSize2 = 0.6f,
                screenSize3 = 1f,
                style = MaterialTheme.typography.body1,
                color1 = colorResource(id = R.color.light_cyan),
                color2 = colorResource(id = R.color.lavender),
                color3 = colorResource(id = R.color.light_cyan),
                dividerColor = Color.Yellow,
                padding = 0
            )

            VerticalDividerThreeRows(
                title1 = " ${match.home_team_statistics.red_cards} ",
                title2 = " Red Cards ",
                title3 = " ${match.away_team_statistics.red_cards} ",
                screenSize1 = 0.3f,
                screenSize2 = 0.6f,
                screenSize3 = 1f,
                style = MaterialTheme.typography.body1,
                color1 = colorResource(id = R.color.light_cyan),
                color2 = colorResource(id = R.color.lavender),
                color3 = colorResource(id = R.color.light_cyan),
                dividerColor = Color.Yellow,
                padding = 0
            )

            VerticalDividerThreeRows(
                title1 = " ${match.home_team_statistics.offsides} ",
                title2 = " Offsides ",
                title3 = " ${match.away_team_statistics.offsides} ",
                screenSize1 = 0.3f,
                screenSize2 = 0.6f,
                screenSize3 = 1f,
                style = MaterialTheme.typography.body1,
                color1 = colorResource(id = R.color.light_cyan),
                color2 = colorResource(id = R.color.lavender),
                color3 = colorResource(id = R.color.light_cyan),
                dividerColor = Color.Yellow,
                padding = 0
            )

            Divider(color = Color.LightGray)

            VerticalDividerThreeRows(
                title1 = " ${match.home_team_statistics.corners} ",
                title2 = " Corners ",
                title3 = " ${match.away_team_statistics.corners} ",
                screenSize1 = 0.3f,
                screenSize2 = 0.6f,
                screenSize3 = 1f,
                style = MaterialTheme.typography.body1,
                color1 = colorResource(id = R.color.light_cyan),
                color2 = colorResource(id = R.color.lavender),
                color3 = colorResource(id = R.color.light_cyan),
                dividerColor = Color.Yellow,
                padding = 0
            )

            VerticalDividerThreeRows(
                title1 = " ${match.home_team_statistics.free_kicks} ",
                title2 = " Free Kicks ",
                title3 = " ${match.away_team_statistics.free_kicks} ",
                screenSize1 = 0.3f,
                screenSize2 = 0.6f,
                screenSize3 = 1f,
                style = MaterialTheme.typography.body1,
                color1 = colorResource(id = R.color.light_cyan),
                color2 = colorResource(id = R.color.lavender),
                color3 = colorResource(id = R.color.light_cyan),
                dividerColor = Color.Yellow,
                padding = 0
            )

            VerticalDividerThreeRows(
                title1 = " ${match.home_team_statistics.penalties} ",
                title2 = " In-game Penalties ",
                title3 = " ${match.away_team_statistics.penalties} ",
                screenSize1 = 0.3f,
                screenSize2 = 0.6f,
                screenSize3 = 1f,
                style = MaterialTheme.typography.body1,
                color1 = colorResource(id = R.color.light_cyan),
                color2 = colorResource(id = R.color.lavender),
                color3 = colorResource(id = R.color.light_cyan),
                dividerColor = Color.Yellow,
                padding = 0
            )

            VerticalDividerThreeRows(
                title1 = " ${match.home_team_statistics.penalties_scored} ",
                title2 = " Successful Penalties ",
                title3 = " ${match.away_team_statistics.penalties_scored} ",
                screenSize1 = 0.3f,
                screenSize2 = 0.6f,
                screenSize3 = 1f,
                style = MaterialTheme.typography.body1,
                color1 = colorResource(id = R.color.light_cyan),
                color2 = colorResource(id = R.color.lavender),
                color3 = colorResource(id = R.color.light_cyan),
                dividerColor = Color.Yellow,
                padding = 0
            )


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
            ScreenText(
                title = state.error,
                color = MaterialTheme.colors.error,
                screenSize = 1f,
                padding = 20,
                fontWeight = FontWeight.Bold
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