package com.mka.fifa.world.cup2022.encyclopedia.presentation.matches.components.update

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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
import coil.compose.rememberAsyncImagePainter
import com.mka.fifa.world.cup2022.encyclopedia.R
import com.mka.fifa.world.cup2022.encyclopedia.common.Constants
import com.mka.fifa.world.cup2022.encyclopedia.data.remote.model.update.Updated_Matches
import com.mka.fifa.world.cup2022.encyclopedia.presentation.common.Heading
import com.mka.fifa.world.cup2022.encyclopedia.presentation.common.ScreenText
import com.mka.fifa.world.cup2022.encyclopedia.presentation.common.VerticalDividerThreeRows
import com.mka.fifa.world.cup2022.encyclopedia.presentation.common.VerticalDividerTwoRows
import java.time.format.TextStyle
import java.util.*

@Composable
fun StatsVerticalDividerTwoRows(title1: String, title2: String) {
    VerticalDividerTwoRows(
        title1 = title1,
        title2 = title2,
        screenSize1 = 0.5f,
        screenSize2 = 1f,
        style1 = MaterialTheme.typography.h6,
        style2 = MaterialTheme.typography.subtitle1,
        color1 = colorResource(id = R.color.lavender),
        color2 = colorResource(id = R.color.light_cyan),
        dividerColor = Color.Green,
        padding = 6,
        fontWeight = FontWeight.Bold
    )
}

@Composable
fun StatsVerticalDividerThreeRows(title1: String, title2: String, title3: String) {
    VerticalDividerThreeRows(
        title1 = title1,
        title2 = title2,
        title3 = title3,
        screenSize1 = 0.3f,
        screenSize2 = 0.6f,
        screenSize3 = 1f,
        style = MaterialTheme.typography.body1,
        color1 = colorResource(id = R.color.light_cyan),
        color2 = colorResource(id = R.color.lavender),
        color3 = colorResource(id = R.color.light_cyan),
        dividerColor = Color.Yellow,
        padding = 6,
        fontWeight = FontWeight.Bold
    )
}

@Composable
fun Updated_MatchesStats(match: Updated_Matches) {

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.matches),
            contentDescription = "Matches Image",
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(),
            contentScale = ContentScale.Crop
        )

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
                    painter = rememberAsyncImagePainter(
                        "https://raw.githubusercontent.com/mufratkarim/mufratkarim/main/flags/${
                            match.home_team?.substring(
                                0,
                                3
                            )?.lowercase()
                        }.png"
                    ),
                    contentDescription = "Home Team Image",
                    modifier = Modifier
                        .fillMaxWidth(0.3f)
                        .height(75.dp),
                    contentScale = ContentScale.Crop
                )

                ScreenText(
                    title = " Match: ${match.id} ",
                    screenSize = 0.6f,
                    style = MaterialTheme.typography.h5,
                    color = Color.White,
                    padding = 3,
                    fontWeight = FontWeight.Bold
                )

                Image(
                    painter = rememberAsyncImagePainter(
                        "https://raw.githubusercontent.com/mufratkarim/mufratkarim/main/flags/${
                            match.away_team?.substring(
                                0,
                                3
                            )?.lowercase()
                        }.png"
                    ),
                    contentDescription = "Away Team Image",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(75.dp),
                    contentScale = ContentScale.Crop
                )
            }

            Heading(
                title1 = " ${match.home_team}",
                title2 = " VS ",
                title3 = " ${match.away_team}",
                backgroundColor = colorResource(id = R.color.light_cyan),
                screenSize1 = 0.4f,
                screenSize2 = 0.35f,
                screenSize3 = 1f,
                color = Color.Black,
                padding = 6,
                textAlign1 = TextAlign.Center,
                style = MaterialTheme.typography.h6
            )

            Divider(color = Color.LightGray)
            match.venue?.let {
                StatsVerticalDividerTwoRows("Venue", it)
            }
            Divider(color = Color.LightGray)
            StatsVerticalDividerTwoRows("Attendance", match.attendance.toString())
            Divider(color = Color.LightGray)
            val dateTime =
                match.time?.let { Constants.toLocalDateTime(it, "yyyy-MM-dd HH:mm:ss") }
            val output = dateTime?.month?.getDisplayName(
                TextStyle.SHORT,
                Locale.ENGLISH
            ) + " " + dateTime?.dayOfMonth + ", " + match.day + " at " + dateTime?.toLocalTime()
            StatsVerticalDividerTwoRows("Time", output)
            Divider(color = Color.Yellow)

            StatsVerticalDividerThreeRows(
                title1 = " ${match.home_captain} ",
                title2 = " Captain ",
                title3 = " ${match.away_captain} "
            )
            StatsVerticalDividerThreeRows(
                title1 = " ${match.home_manager} ",
                title2 = " Coach ",
                title3 = " ${match.away_manager} ",
            )
            Divider(color = Color.LightGray)

            val scores = match.score?.split("–")
            val homeScore = scores?.get(0);
            val awayScore = scores?.get(1);
            StatsVerticalDividerThreeRows(
                title1 = " $homeScore ",
                title2 = " Score ",
                title3 = " $awayScore ",
            )
            StatsVerticalDividerThreeRows(
                title1 = " ${match.home_possession}% ",
                title2 = " Possession ",
                title3 = " ${match.away_possession}% ",
            )
            Divider(color = Color.LightGray)

            StatsVerticalDividerThreeRows(
                title1 = " ${match.home_total_shots} ",
                title2 = " Total Shots ",
                title3 = " ${match.away_total_shots} ",
            )
            StatsVerticalDividerThreeRows(
                title1 = " ${match.home_sot} ",
                title2 = " On Target ",
                title3 = " ${match.away_sot} ",
            )

            if (match.home_sot != null && match.home_total_shots != null && match.away_sot != null && match.away_total_shots != null) {
                val homeShotsPercentage =
                    Math.round(
                        match.home_sot.toDouble().div(match.home_total_shots.toDouble())
                            .times(1000.0)
                    ) / 10.0
                val awayShotsPercentage =
                    Math.round(
                        match.away_sot.toDouble().div(match.away_total_shots.toDouble())
                            .times(1000.0)
                    ) / 10.0
                StatsVerticalDividerThreeRows(
                    title1 = " ${homeShotsPercentage}% ",
                    title2 = " Shots Percentage ",
                    title3 = " ${awayShotsPercentage}% ",
                )
            }


            Divider(color = Color.LightGray)
            StatsVerticalDividerThreeRows(
                title1 = " ${match.home_attempted_pases} ",
                title2 = " Attempted Passes ",
                title3 = " ${match.away_attempted_pases} ",
            )
            StatsVerticalDividerThreeRows(
                title1 = " ${match.home_completed_passes} ",
                title2 = " Completed Passes ",
                title3 = " ${match.away_completed_passes} ",
            )
            if (match.home_attempted_pases != null && match.home_completed_passes != null && match.away_attempted_pases != null && match.away_completed_passes != null) {
                val homePassesPercentage = Math.round(
                    match.home_completed_passes.toDouble()
                        .div(match.home_attempted_pases.toDouble())
                        .times(1000.0)
                ) / 10.0
                val awayPassesPercentage = Math.round(
                    match.away_completed_passes.toDouble()
                        .div(match.away_attempted_pases.toDouble())
                        .times(1000.0)
                ) / 10.0
                StatsVerticalDividerThreeRows(
                    title1 = " ${homePassesPercentage}% ",
                    title2 = " Passes Percent ",
                    title3 = " ${awayPassesPercentage}% ",
                )

            }

            Divider(color = Color.LightGray)
            StatsVerticalDividerThreeRows(
                title1 = " ${match.home_corners} ",
                title2 = " Corners ",
                title3 = " ${match.away_corners} ",
            )
            StatsVerticalDividerThreeRows(
                title1 = " ${match.home_fouls} ",
                title2 = " Fouls ",
                title3 = " ${match.away_fouls} ",
            )
            StatsVerticalDividerThreeRows(
                title1 = " ${match.home_tackles} ",
                title2 = " Tackles ",
                title3 = " ${match.away_tackles} ",
            )
            StatsVerticalDividerThreeRows(
                title1 = " ${match.home_interceptions} ",
                title2 = " Interceptions ",
                title3 = " ${match.away_interceptions} ",
            )
            StatsVerticalDividerThreeRows(
                title1 = " ${match.home_clearances} ",
                title2 = " Clearances ",
                title3 = " ${match.away_clearances} ",
            )
            Divider(color = Color.LightGray)

            StatsVerticalDividerThreeRows(
                title1 = " ${match.home_touches} ",
                title2 = " Touches ",
                title3 = " ${match.away_touches} ",
            )
            StatsVerticalDividerThreeRows(
                title1 = " ${match.home_aerials_won} ",
                title2 = " Aerials Won ",
                title3 = " ${match.away_aerials_won} ",
            )
            StatsVerticalDividerThreeRows(
                title1 = " ${match.home_long_balls} ",
                title2 = " Long Balls ",
                title3 = " ${match.away_long_balls} ",
            )
            StatsVerticalDividerThreeRows(
                title1 = " ${match.home_throw_ins} ",
                title2 = " Throw Ins ",
                title3 = " ${match.away_throw_ins} ",
            )
            Divider(color = Color.LightGray)


        }

    }


}