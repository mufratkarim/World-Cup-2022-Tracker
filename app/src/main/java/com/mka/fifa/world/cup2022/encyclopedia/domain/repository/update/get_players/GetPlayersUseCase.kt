package com.mka.fifa.world.cup2022.encyclopedia.domain.repository.update.get_players

import com.mka.fifa.world.cup2022.encyclopedia.common.Constants
import com.mka.fifa.world.cup2022.encyclopedia.common.Resource
import com.mka.fifa.world.cup2022.encyclopedia.data.remote.dto.update.matches.toUpdated_Matches
import com.mka.fifa.world.cup2022.encyclopedia.data.remote.dto.update.players.toPlayers
import com.mka.fifa.world.cup2022.encyclopedia.data.remote.model.update.Players
import com.mka.fifa.world.cup2022.encyclopedia.data.remote.model.update.Updated_Matches
import com.mka.fifa.world.cup2022.encyclopedia.domain.repository.WorldCupRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetPlayersUseCase @Inject constructor(
    private val repository: WorldCupRepository
) {
    operator fun invoke(): Flow<Resource<List<Players>>> = flow {
        try {
            emit(Resource.Loading<List<Players>>())
            val players = repository.getPlayers().map { it.toPlayers(); }
            emit(Resource.Success<List<Players>>(players))
        } catch (e: HttpException) {
            emit(Resource.Error<List<Players>>(e.localizedMessage ?: Constants.HTTP_ERROR_TEXT))
        } catch (e: IOException) {
            emit(Resource.Error<List<Players>>(Constants.SERVER_ERROR_TEXT))
        }
    }
}