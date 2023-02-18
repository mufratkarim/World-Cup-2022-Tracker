package com.mka.fifa.world.cup2022.encyclopedia.domain.repository.update.get_updated_matches

import com.mka.fifa.world.cup2022.encyclopedia.common.Constants
import com.mka.fifa.world.cup2022.encyclopedia.common.Resource
import com.mka.fifa.world.cup2022.encyclopedia.data.remote.dto.update.matches.toUpdated_Matches
import com.mka.fifa.world.cup2022.encyclopedia.data.remote.model.update.Updated_Matches
import com.mka.fifa.world.cup2022.encyclopedia.domain.repository.WorldCupRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetUpdatedMatchesUseCase @Inject constructor(
    private val repository: WorldCupRepository
) {
    operator fun invoke(): Flow<Resource<List<Updated_Matches>>> = flow {
        try {
            emit(Resource.Loading<List<Updated_Matches>>())
            val matches = repository.getUpdatedMatches().map { it.toUpdated_Matches(); }
            emit(Resource.Success<List<Updated_Matches>>(matches))
        } catch (e: HttpException) {
            emit(Resource.Error<List<Updated_Matches>>(e.localizedMessage ?: Constants.HTTP_ERROR_TEXT))
        } catch (e: IOException) {
            emit(Resource.Error<List<Updated_Matches>>(Constants.SERVER_ERROR_TEXT))
        }
    }
}