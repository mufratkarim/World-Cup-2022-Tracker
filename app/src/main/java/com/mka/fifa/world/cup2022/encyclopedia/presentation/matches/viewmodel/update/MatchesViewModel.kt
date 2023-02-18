package com.mka.fifa.world.cup2022.encyclopedia.presentation.matches.viewmodel.update

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mka.fifa.world.cup2022.encyclopedia.common.Constants
import com.mka.fifa.world.cup2022.encyclopedia.common.Resource
import com.mka.fifa.world.cup2022.encyclopedia.domain.repository.update.get_updated_matches.GetUpdatedMatchesUseCase
import com.mka.fifa.world.cup2022.encyclopedia.presentation.matches.components.update.MatchesListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MatchesViewModel @Inject constructor(
    private val getUpdatedMatchesUseCase: GetUpdatedMatchesUseCase
): ViewModel() {

    private val _state = mutableStateOf(MatchesListState())
    val state: State<MatchesListState> = _state

    init {
        getMatches()

    }
    private fun getMatches() {
        getUpdatedMatchesUseCase().onEach { result ->
            when(result) {
                is Resource.Success -> {
                    _state.value = MatchesListState(matches = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _state.value = MatchesListState(error = result.message ?: Constants.HTTP_ERROR_TEXT)
                }
                is Resource.Loading -> {
                    _state.value = MatchesListState(isLoading = true)
                }
            }

        }.launchIn(viewModelScope)




    }


}