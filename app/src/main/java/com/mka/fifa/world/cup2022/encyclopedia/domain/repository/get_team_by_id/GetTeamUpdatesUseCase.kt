package com.mka.fifa.world.cup2022.encyclopedia.domain.repository.get_team_by_id

import com.mka.fifa.world.cup2022.encyclopedia.common.Constants
import com.mka.fifa.world.cup2022.encyclopedia.common.Resource
import com.mka.fifa.world.cup2022.encyclopedia.data.remote.dto.matches_dto.toMatchesById
import com.mka.fifa.world.cup2022.encyclopedia.data.remote.model.MatchesById
import com.mka.fifa.world.cup2022.encyclopedia.domain.repository.WorldCupRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetTeamUpdatesUseCase @Inject constructor(
    private val repository: WorldCupRepository
) {
    operator fun invoke(teamId: String): Flow<Resource<List<MatchesById>>> = flow {
        try {
            emit(Resource.Loading<List<MatchesById>>())
            val matches = repository.getTeamUpdatesById(teamId).map { it.toMatchesById() }
            emit(Resource.Success<List<MatchesById>>(matches))
        } catch (e: HttpException) {
            emit(Resource.Error<List<MatchesById>>(e.localizedMessage ?: Constants.HTTP_ERROR_TEXT))
        } catch (e: IOException) {
            emit(Resource.Error<List<MatchesById>>(Constants.SERVER_ERROR_TEXT))
        }
    }
}