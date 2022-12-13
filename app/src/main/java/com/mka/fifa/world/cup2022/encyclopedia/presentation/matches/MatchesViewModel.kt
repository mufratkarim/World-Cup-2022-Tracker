package com.mka.fifa.world.cup2022.encyclopedia.presentation.matches

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mka.fifa.world.cup2022.encyclopedia.common.Constants
import com.mka.fifa.world.cup2022.encyclopedia.common.Resource
import com.mka.fifa.world.cup2022.encyclopedia.domain.repository.get_matches.GetMatchesUseCase
import com.mka.fifa.world.cup2022.encyclopedia.presentation.matches.components.MatchesState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MatchesViewModel @Inject constructor(
    private val getMatchesUseCase: GetMatchesUseCase
): ViewModel() {

    private val _state = mutableStateOf(MatchesState())
    val state: State<MatchesState> = _state

    init {
        getMatches()
    }
    private fun getMatches() {
        getMatchesUseCase().onEach { result ->
            when(result) {
                is Resource.Success -> {
                    _state.value = MatchesState(matches = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _state.value = MatchesState(error = result.message ?: Constants.HTTP_ERROR_TEXT)
                }
                is Resource.Loading -> {
                    _state.value = MatchesState(isLoading = true)
                }
            }

        }.launchIn(viewModelScope)
    }


}