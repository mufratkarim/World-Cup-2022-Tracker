package com.mka.fifa.world.cup2022.encyclopedia.presentation.team_by_id

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mka.fifa.world.cup2022.encyclopedia.common.Constants
import com.mka.fifa.world.cup2022.encyclopedia.common.Resource
import com.mka.fifa.world.cup2022.encyclopedia.domain.repository.get_team_by_id.GetTeamByIdUseCase
import com.mka.fifa.world.cup2022.encyclopedia.presentation.team_by_id.components.TeamByIdState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class TeamByIdViewModel @Inject constructor(
    private val getTeamByIdUseCase: GetTeamByIdUseCase,
    savedStateHandle: SavedStateHandle
): ViewModel() {

    private val _state = mutableStateOf(TeamByIdState())
    val state: State<TeamByIdState> = _state

    init {
        savedStateHandle.get<String>(Constants.PARAM_TEAM_ID)?.let { teamId ->
            getTeamById(teamId)
        }
    }
    private fun getTeamById(teamId: String) {
        getTeamByIdUseCase(teamId).onEach { result ->
            when(result) {
                is Resource.Success -> {
                    _state.value = TeamByIdState(teamById = result.data)
                }
                is Resource.Error -> {
                    _state.value = TeamByIdState(error = result.message ?: Constants.HTTP_ERROR_TEXT)
                }
                is Resource.Loading -> {
                    _state.value = TeamByIdState(isLoading = true)
                }
            }

        }.launchIn(viewModelScope)
    }


}