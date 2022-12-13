package com.mka.fifa.world.cup2022.encyclopedia.data.repository

import com.mka.fifa.world.cup2022.encyclopedia.data.remote.WorldCupApi
import com.mka.fifa.world.cup2022.encyclopedia.data.remote.dto.groups_dto.GroupsDto
import com.mka.fifa.world.cup2022.encyclopedia.data.remote.dto.matches_dto.MatchesDto
import com.mka.fifa.world.cup2022.encyclopedia.data.remote.dto.team_by_id_dto.TeamByIdDto
import com.mka.fifa.world.cup2022.encyclopedia.domain.repository.WorldCupRepository
import javax.inject.Inject

class WorldCupRepoImpl @Inject constructor(
    private val api: WorldCupApi
) : WorldCupRepository {
    override suspend fun getMatches(): List<MatchesDto> {
        return api.getMatches()
    }

    override suspend fun getGroups(): GroupsDto {
        return api.getGroups()
    }

    override suspend fun getTeamById(teamId: String): TeamByIdDto {
        return api.getTeamById(teamId)
    }
}