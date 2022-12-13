package com.mka.fifa.world.cup2022.encyclopedia.domain.repository.get_team_by_id

import com.mka.fifa.world.cup2022.encyclopedia.common.Constants
import com.mka.fifa.world.cup2022.encyclopedia.common.Resource
import com.mka.fifa.world.cup2022.encyclopedia.data.remote.dto.groups_dto.toGroups
import com.mka.fifa.world.cup2022.encyclopedia.data.remote.dto.team_by_id_dto.toTeamById
import com.mka.fifa.world.cup2022.encyclopedia.data.remote.model.Groups
import com.mka.fifa.world.cup2022.encyclopedia.data.remote.model.TeamById
import com.mka.fifa.world.cup2022.encyclopedia.domain.repository.WorldCupRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetTeamByIdUseCase @Inject constructor(
    private val repository: WorldCupRepository
) {

    operator fun invoke(teamId: String): Flow<Resource<TeamById>> = flow {
        try {
            emit(Resource.Loading<TeamById>())
            val teamById = repository.getTeamById(teamId).toTeamById()
            emit(Resource.Success<TeamById>(teamById))
        } catch (e: HttpException) {
            emit(Resource.Error<TeamById>(e.localizedMessage ?: Constants.HTTP_ERROR_TEXT))
        } catch (e: IOException) {
            emit(Resource.Error<TeamById>(Constants.HTTP_ERROR_TEXT))
        }
    }

}