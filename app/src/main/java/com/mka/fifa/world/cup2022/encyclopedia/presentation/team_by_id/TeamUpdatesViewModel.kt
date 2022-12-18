package com.mka.fifa.world.cup2022.encyclopedia.presentation.team_by_id

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mka.fifa.world.cup2022.encyclopedia.common.Constants
import com.mka.fifa.world.cup2022.encyclopedia.common.Resource
import com.mka.fifa.world.cup2022.encyclopedia.domain.repository.get_matches.GetMatchesUseCase
import com.mka.fifa.world.cup2022.encyclopedia.domain.repository.get_team_by_id.GetTeamUpdatesUseCase
import com.mka.fifa.world.cup2022.encyclopedia.presentation.matches.components.MatchesState
import com.mka.fifa.world.cup2022.encyclopedia.presentation.team_by_id.components.TeamUpdatesState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class TeamUpdatesViewModel @Inject constructor(
    private val getTeamUpdatesUseCase: GetTeamUpdatesUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = mutableStateOf(TeamUpdatesState())
    val state: State<TeamUpdatesState> = _state

    init {
        savedStateHandle.get<String>(Constants.PARAM_TEAM_BY_ID)?.let { teamId ->
            getTeamUpdates(teamId)
        }
    }

    private fun getTeamUpdates(teamId: String) {
        getTeamUpdatesUseCase(teamId).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = TeamUpdatesState(matches = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _state.value =
                        TeamUpdatesState(error = result.message ?: Constants.HTTP_ERROR_TEXT)
                }
                is Resource.Loading -> {
                    _state.value = TeamUpdatesState(isLoading = true)
                }
            }

        }.launchIn(viewModelScope)
    }


}