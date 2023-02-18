package com.mka.fifa.world.cup2022.encyclopedia.data.remote

import com.mka.fifa.world.cup2022.encyclopedia.data.remote.dto.update.events.EventsByIdDto
import com.mka.fifa.world.cup2022.encyclopedia.data.remote.dto.update.groups.GroupsDto
import com.mka.fifa.world.cup2022.encyclopedia.data.remote.dto.update.groups.Update_GroupsByIdDto
import com.mka.fifa.world.cup2022.encyclopedia.data.remote.dto.update.matches.Updated_MatchesDto
import com.mka.fifa.world.cup2022.encyclopedia.data.remote.dto.update.players.PlayersDto
import com.mka.fifa.world.cup2022.encyclopedia.data.remote.dto.update.teams.TeamsDto
import retrofit2.http.GET

interface WorldCupApi {

//    @GET("/matches/")
//    suspend fun getMatches(): List<MatchesDto>
//
//    @GET("/matches/")
//    suspend fun getMatchesByDate(@Query("by_date") matchesByDate: String): List<MatchesDto>
//
//    @GET("/matches/")
//    suspend fun getMatchesByGoals(@Query("by") matchesByGoals: String): List<MatchesDto>
//
//    @GET("/matches/{matchesById}")
//    suspend fun getMatchesById(@Path(Constants.PARAM_MATCHES_BY_ID) matchesById: Int): MatchesByIdDto
//
//    @GET("/teams/")
//    suspend fun getGroups(): GroupsDto
//
//    @GET("/teams/{teamId}")
//    suspend fun getTeamById(@Path(Constants.PARAM_TEAM_BY_ID) teamId: String): TeamByIdDto
//
//    @GET("/matches/country/{teamId}")
//    suspend fun getTeamUpdatesById(@Path(Constants.PARAM_TEAM_BY_ID) teamId: String): List<MatchesByIdDto>

    @GET("mufratkarim/mufratkarim/main/json/World%20Cup%202022/UpdateMatches.json")
    suspend fun getUpdatedMatches(): List<Updated_MatchesDto>

    @GET("mufratkarim/mufratkarim/main/json/World%20Cup%202022/PlayerStats.json")
    suspend fun getPlayers(): List<PlayersDto>

    @GET("mufratkarim/mufratkarim/main/json/World%20Cup%202022/Teams.json")
    suspend fun getTeams(): List<TeamsDto>

    @GET("mufratkarim/mufratkarim/main/json/World%20Cup%202022/Update_Events.json")
    suspend fun getEvents(): EventsByIdDto

    @GET("https://raw.githubusercontent.com/mufratkarim/mufratkarim/main/json/World%20Cup%202022/Groups.json")
    suspend fun getGroups(): Update_GroupsByIdDto




}