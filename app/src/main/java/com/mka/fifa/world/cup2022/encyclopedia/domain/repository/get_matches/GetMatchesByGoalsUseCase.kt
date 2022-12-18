package com.mka.fifa.world.cup2022.encyclopedia.domain.repository.get_matches

import com.mka.fifa.world.cup2022.encyclopedia.common.Constants
import com.mka.fifa.world.cup2022.encyclopedia.common.Resource
import com.mka.fifa.world.cup2022.encyclopedia.data.remote.dto.matches_dto.toMatches
import com.mka.fifa.world.cup2022.encyclopedia.data.remote.model.Groups
import com.mka.fifa.world.cup2022.encyclopedia.data.remote.model.Matches
import com.mka.fifa.world.cup2022.encyclopedia.domain.repository.WorldCupRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetMatchesByGoalsUseCase @Inject constructor(
    private val repository: WorldCupRepository
) {
    operator fun invoke(matchesByGoals: String): Flow<Resource<List<Matches>>> = flow {
        try {
            emit(Resource.Loading<List<Matches>>())
            val matches = repository.getMatchesByGoals(matchesByGoals).map { it.toMatches() }
            emit(Resource.Success<List<Matches>>(matches))
        } catch (e: HttpException) {
            emit(Resource.Error<List<Matches>>(e.localizedMessage ?: Constants.HTTP_ERROR_TEXT))
        } catch (e: IOException) {
            emit(Resource.Error<List<Matches>>(Constants.SERVER_ERROR_TEXT))
        }
    }
}