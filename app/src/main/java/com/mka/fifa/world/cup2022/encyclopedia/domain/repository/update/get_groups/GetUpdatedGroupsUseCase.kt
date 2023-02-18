package com.mka.fifa.world.cup2022.encyclopedia.domain.repository.update.get_groups

import com.mka.fifa.world.cup2022.encyclopedia.common.Constants
import com.mka.fifa.world.cup2022.encyclopedia.common.Resource
import com.mka.fifa.world.cup2022.encyclopedia.data.remote.dto.update.events.EventsByIdDto
import com.mka.fifa.world.cup2022.encyclopedia.data.remote.dto.update.events.EventsDto
import com.mka.fifa.world.cup2022.encyclopedia.data.remote.dto.update.events.toEvents
import com.mka.fifa.world.cup2022.encyclopedia.data.remote.dto.update.groups.toGroups
import com.mka.fifa.world.cup2022.encyclopedia.data.remote.dto.update.matches.toUpdated_Matches
import com.mka.fifa.world.cup2022.encyclopedia.data.remote.model.update.Events
import com.mka.fifa.world.cup2022.encyclopedia.data.remote.model.update.Updated_Groups
import com.mka.fifa.world.cup2022.encyclopedia.data.remote.model.update.Updated_Matches
import com.mka.fifa.world.cup2022.encyclopedia.domain.repository.WorldCupRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetUpdatedGroupsUseCase @Inject constructor(
    private val repository: WorldCupRepository
) {
    operator fun invoke(): Flow<Resource<List<Updated_Groups>>> = flow {
        try {
            emit(Resource.Loading<List<Updated_Groups>>())
            val groups = repository.getGroups().map { it.toGroups() }
            emit(Resource.Success<List<Updated_Groups>>(groups))
        } catch (e: HttpException) {
            emit(Resource.Error<List<Updated_Groups>>(e.localizedMessage ?: Constants.HTTP_ERROR_TEXT))
        } catch (e: IOException) {
            emit(Resource.Error<List<Updated_Groups>>(Constants.SERVER_ERROR_TEXT))
        }
    }
}