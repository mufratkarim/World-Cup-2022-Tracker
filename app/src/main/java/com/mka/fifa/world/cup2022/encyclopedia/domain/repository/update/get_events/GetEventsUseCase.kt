package com.mka.fifa.world.cup2022.encyclopedia.domain.repository.update.get_events

import com.mka.fifa.world.cup2022.encyclopedia.common.Constants
import com.mka.fifa.world.cup2022.encyclopedia.common.Resource
import com.mka.fifa.world.cup2022.encyclopedia.data.remote.dto.update.events.EventsByIdDto
import com.mka.fifa.world.cup2022.encyclopedia.data.remote.dto.update.events.EventsDto
import com.mka.fifa.world.cup2022.encyclopedia.data.remote.dto.update.events.toEvents
import com.mka.fifa.world.cup2022.encyclopedia.data.remote.dto.update.matches.toUpdated_Matches
import com.mka.fifa.world.cup2022.encyclopedia.data.remote.model.update.Events
import com.mka.fifa.world.cup2022.encyclopedia.data.remote.model.update.Updated_Matches
import com.mka.fifa.world.cup2022.encyclopedia.domain.repository.WorldCupRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetEventsUseCase @Inject constructor(
    private val repository: WorldCupRepository
) {
    operator fun invoke(eventId: Int): Flow<Resource<List<Events>>> = flow {
        try {
            emit(Resource.Loading<List<Events>>())
            val events = repository.getEvents(eventId).map { it.toEvents() }
            emit(Resource.Success<List<Events>>(events))
        } catch (e: HttpException) {
            emit(Resource.Error<List<Events>>(e.localizedMessage ?: Constants.HTTP_ERROR_TEXT))
        } catch (e: IOException) {
            emit(Resource.Error<List<Events>>(Constants.SERVER_ERROR_TEXT))
        }
    }
}