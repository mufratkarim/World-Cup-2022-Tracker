package com.mka.fifa.world.cup2022.encyclopedia.domain.repository

import com.mka.fifa.world.cup2022.encyclopedia.data.remote.dto.groups_dto.GroupsDto
import com.mka.fifa.world.cup2022.encyclopedia.data.remote.dto.matches_dto.MatchesByIdDto
import com.mka.fifa.world.cup2022.encyclopedia.data.remote.dto.matches_dto.MatchesDto
import com.mka.fifa.world.cup2022.encyclopedia.data.remote.dto.team_by_id_dto.TeamByIdDto

interface WorldCupRepository {

    suspend fun getMatches(): List<MatchesDto>

    suspend fun getMatchesByDate(matchesByDate: String): List<MatchesDto>

    suspend fun getMatchesByGoals(matchesByGoals: String): List<MatchesDto>

    suspend fun getMatchesById(matchesById: Int): MatchesByIdDto

    suspend fun getGroups(): GroupsDto

    suspend fun getTeamById(teamId: String): TeamByIdDto

    suspend fun getTeamUpdatesById(teamId: String): List<MatchesByIdDto>
}