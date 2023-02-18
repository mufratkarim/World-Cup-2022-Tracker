package com.mka.fifa.world.cup2022.encyclopedia.presentation.players.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mka.fifa.world.cup2022.encyclopedia.common.Constants
import com.mka.fifa.world.cup2022.encyclopedia.common.Resource
import com.mka.fifa.world.cup2022.encyclopedia.domain.repository.update.get_players.GetPlayersUseCase
import com.mka.fifa.world.cup2022.encyclopedia.domain.repository.update.get_teams.GetTeamsUseCase
import com.mka.fifa.world.cup2022.encyclopedia.domain.repository.update.get_updated_matches.GetUpdatedMatchesUseCase
import com.mka.fifa.world.cup2022.encyclopedia.presentation.matches.components.update.MatchesListState
import com.mka.fifa.world.cup2022.encyclopedia.presentation.players.components.PlayersState
import com.mka.fifa.world.cup2022.encyclopedia.presentation.teams.update.components.TeamsState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class PlayersViewModel @Inject constructor(
    private val getPlayersUseCase: GetPlayersUseCase
): ViewModel() {

    private val _state = mutableStateOf(PlayersState())
    val state: State<PlayersState> = _state

    init {
        getPlayers()

    }
    private fun getPlayers() {
        getPlayersUseCase().onEach { result ->
            when(result) {
                is Resource.Success -> {
                    _state.value = PlayersState(players = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _state.value = PlayersState(error = result.message ?: Constants.HTTP_ERROR_TEXT)
                }
                is Resource.Loading -> {
                    _state.value = PlayersState(isLoading = true)
                }
            }

        }.launchIn(viewModelScope)




    }


}