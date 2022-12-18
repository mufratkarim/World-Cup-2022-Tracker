package com.mka.fifa.world.cup2022.encyclopedia.data.remote

import com.mka.fifa.world.cup2022.encyclopedia.common.Constants
import com.mka.fifa.world.cup2022.encyclopedia.data.remote.dto.groups_dto.GroupsDto
import com.mka.fifa.world.cup2022.encyclopedia.data.remote.dto.matches_dto.MatchesByIdDto
import com.mka.fifa.world.cup2022.encyclopedia.data.remote.dto.matches_dto.MatchesDto
import com.mka.fifa.world.cup2022.encyclopedia.data.remote.dto.team_by_id_dto.TeamByIdDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface WorldCupApi {

    @GET("/matches/")
    suspend fun getMatches(): List<MatchesDto>

    @GET("/matches/")
    suspend fun getMatchesByDate(@Query("by_date") matchesByDate: String): List<MatchesDto>

    @GET("/matches/")
    suspend fun getMatchesByGoals(@Query("by") matchesByGoals: String): List<MatchesDto>

    @GET("/matches/{matchesById}")
    suspend fun getMatchesById(@Path(Constants.PARAM_MATCHES_BY_ID) matchesById: Int): MatchesByIdDto

    @GET("/teams/")
    suspend fun getGroups(): GroupsDto

    @GET("/teams/{teamId}")
    suspend fun getTeamById(@Path(Constants.PARAM_TEAM_BY_ID) teamId: String): TeamByIdDto

    @GET("/matches/country/{teamId}")
    suspend fun getTeamUpdatesById(@Path(Constants.PARAM_TEAM_BY_ID) teamId: String): List<MatchesByIdDto>

}