package com.mka.fifa.world.cup2022.encyclopedia.presentation.matches.viewmodel.old

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.mka.fifa.world.cup2022.encyclopedia.common.Constants
import com.mka.fifa.world.cup2022.encyclopedia.domain.repository.old.get_matches.GetMatchesByIdUseCase
import com.mka.fifa.world.cup2022.encyclopedia.presentation.matches.components.old.MatchesByIdState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MatchesByIdViewModel @Inject constructor(
    private val getMatchesByIdUseCase: GetMatchesByIdUseCase,
    savedStateHandle: SavedStateHandle
): ViewModel() {

    private val _state = mutableStateOf(MatchesByIdState())
    val state: State<MatchesByIdState> = _state

    init {
        savedStateHandle.get<String>(Constants.PARAM_MATCHES_BY_ID)?.let { matchesById ->
            getMatchesById(Integer.parseInt(matchesById))
        }

    }
    private fun getMatchesById(matchesById: Int) {
//        getMatchesByIdUseCase(matchesById).onEach { result ->
//            when(result) {
//                is Resource.Success -> {
//                    _state.value = MatchesByIdState(matches = result.data)
//                }
//                is Resource.Error -> {
//                    _state.value = MatchesByIdState(error = result.message ?: Constants.HTTP_ERROR_TEXT)
//                }
//                is Resource.Loading -> {
//                    _state.value = MatchesByIdState(isLoading = true)
//                }
//            }
//
//        }.launchIn(viewModelScope)
    }


}