package com.mka.fifa.world.cup2022.encyclopedia.domain.repository.get_groups

import com.mka.fifa.world.cup2022.encyclopedia.common.Constants
import com.mka.fifa.world.cup2022.encyclopedia.common.Resource
import com.mka.fifa.world.cup2022.encyclopedia.data.remote.dto.groups_dto.toGroups
import com.mka.fifa.world.cup2022.encyclopedia.data.remote.model.Groups
import com.mka.fifa.world.cup2022.encyclopedia.domain.repository.WorldCupRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetGroupsUseCase @Inject constructor(
    private val repository: WorldCupRepository
) {

    operator fun invoke(): Flow<Resource<Groups>> = flow {
        try {
            emit(Resource.Loading<Groups>())
            val groups = repository.getGroups().toGroups()
            emit(Resource.Success<Groups>(groups))
        } catch (e: HttpException) {
            emit(Resource.Error<Groups>(e.localizedMessage ?: Constants.HTTP_ERROR_TEXT))
        } catch (e: IOException) {
            emit(Resource.Error<Groups>(Constants.SERVER_ERROR_TEXT))
        }
    }

}