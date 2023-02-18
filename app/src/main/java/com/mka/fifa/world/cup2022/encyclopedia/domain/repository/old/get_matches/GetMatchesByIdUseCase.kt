package com.mka.fifa.world.cup2022.encyclopedia.domain.repository.old.get_matches

import com.mka.fifa.world.cup2022.encyclopedia.common.Constants
import com.mka.fifa.world.cup2022.encyclopedia.common.Resource
import com.mka.fifa.world.cup2022.encyclopedia.data.remote.dto.old.matches_dto.toMatchesById
import com.mka.fifa.world.cup2022.encyclopedia.data.remote.model.old.MatchesById
import com.mka.fifa.world.cup2022.encyclopedia.domain.repository.WorldCupRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetMatchesByIdUseCase @Inject constructor(
    private val repository: WorldCupRepository
) {
//    operator fun invoke(matchesById: Int): Flow<Resource<MatchesById>> = flow {
//        try {
//            emit(Resource.Loading<MatchesById>())
//            val matches = repository.getMatchesById(matchesById).toMatchesById()
//            emit(Resource.Success<MatchesById>(matches))
//        } catch (e: HttpException) {
//            emit(Resource.Error<MatchesById>(e.localizedMessage ?: Constants.HTTP_ERROR_TEXT))
//        } catch (e: IOException) {
//            emit(Resource.Error<MatchesById>(Constants.SERVER_ERROR_TEXT))
//        }
//    }
}