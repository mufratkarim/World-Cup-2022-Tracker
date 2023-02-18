package com.mka.fifa.world.cup2022.encyclopedia.domain.repository.update.get_teams

import com.mka.fifa.world.cup2022.encyclopedia.common.Constants
import com.mka.fifa.world.cup2022.encyclopedia.common.Resource
import com.mka.fifa.world.cup2022.encyclopedia.data.remote.dto.update.matches.toUpdated_Matches
import com.mka.fifa.world.cup2022.encyclopedia.data.remote.dto.update.teams.toTeams
import com.mka.fifa.world.cup2022.encyclopedia.data.remote.model.update.Teams
import com.mka.fifa.world.cup2022.encyclopedia.data.remote.model.update.Updated_Matches
import com.mka.fifa.world.cup2022.encyclopedia.domain.repository.WorldCupRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetTeamsUseCase @Inject constructor(
    private val repository: WorldCupRepository
) {
    operator fun invoke(): Flow<Resource<List<Teams>>> = flow {
        try {
            emit(Resource.Loading<List<Teams>>())
            val teams = repository.getTeams().map { it.toTeams(); }
            emit(Resource.Success<List<Teams>>(teams))
        } catch (e: HttpException) {
            emit(Resource.Error<List<Teams>>(e.localizedMessage ?: Constants.HTTP_ERROR_TEXT))
        } catch (e: IOException) {
            emit(Resource.Error<List<Teams>>(Constants.SERVER_ERROR_TEXT))
        }
    }
}