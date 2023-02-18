package com.mka.fifa.world.cup2022.encyclopedia.data.remote.model.old

import com.mka.fifa.world.cup2022.encyclopedia.data.remote.dto.old.matches_dto.AwayTeam
import com.mka.fifa.world.cup2022.encyclopedia.data.remote.dto.old.matches_dto.HomeTeam

data class Matches(
    val id: Int?,
    val attendance: String?,
    val away_team: AwayTeam?,
    val datetime: String?,
    val home_team: HomeTeam?,
    val location: String?,
    val stage_name: String?,
    val status: String?,
    val venue: String?,
    val winner: String?
)
