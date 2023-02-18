package com.mka.fifa.world.cup2022.encyclopedia.presentation.teams.update.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mka.fifa.world.cup2022.encyclopedia.common.Constants
import com.mka.fifa.world.cup2022.encyclopedia.common.Resource
import com.mka.fifa.world.cup2022.encyclopedia.domain.repository.update.get_teams.GetTeamsUseCase
import com.mka.fifa.world.cup2022.encyclopedia.domain.repository.update.get_updated_matches.GetUpdatedMatchesUseCase
import com.mka.fifa.world.cup2022.encyclopedia.presentation.matches.components.update.MatchesListState
import com.mka.fifa.world.cup2022.encyclopedia.presentation.teams.update.components.TeamsState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class TeamsViewModel @Inject constructor(
    private val getTeamsUseCase: GetTeamsUseCase
): ViewModel() {

    private val _state = mutableStateOf(TeamsState())
    val state: State<TeamsState> = _state

    init {
        getTeams()

    }
    private fun getTeams() {
        getTeamsUseCase().onEach { result ->
            when(result) {
                is Resource.Success -> {
                    _state.value = TeamsState(teams = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _state.value = TeamsState(error = result.message ?: Constants.HTTP_ERROR_TEXT)
                }
                is Resource.Loading -> {
                    _state.value = TeamsState(isLoading = true)
                }
            }

        }.launchIn(viewModelScope)




    }


}