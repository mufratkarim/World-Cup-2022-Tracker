package com.mka.fifa.world.cup2022.encyclopedia.domain.repository

import com.mka.fifa.world.cup2022.encyclopedia.data.remote.dto.groups_dto.GroupsDto
import com.mka.fifa.world.cup2022.encyclopedia.data.remote.dto.matches_dto.MatchesDto
import com.mka.fifa.world.cup2022.encyclopedia.data.remote.dto.team_by_id_dto.TeamByIdDto

interface WorldCupRepository {

    suspend fun getMatches(): List<MatchesDto>

    suspend fun getGroups(): GroupsDto

    suspend fun getTeamById(teamId: String): TeamByIdDto
}