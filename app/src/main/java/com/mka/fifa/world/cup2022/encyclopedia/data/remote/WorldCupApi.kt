package com.mka.fifa.world.cup2022.encyclopedia.data.remote

import com.mka.fifa.world.cup2022.encyclopedia.data.remote.dto.groups_dto.GroupsDto
import com.mka.fifa.world.cup2022.encyclopedia.data.remote.dto.matches_dto.MatchesDto
import com.mka.fifa.world.cup2022.encyclopedia.data.remote.dto.team_by_id_dto.TeamByIdDto
import retrofit2.http.GET
import retrofit2.http.Path

interface WorldCupApi {

    @GET("/matches/")
    suspend fun getMatches(): List<MatchesDto>

    @GET("/teams/")
    suspend fun getGroups(): GroupsDto

    @GET("/teams/{teamId}")
    suspend fun getTeamById(@Path("teamId") teamId: String): TeamByIdDto
}