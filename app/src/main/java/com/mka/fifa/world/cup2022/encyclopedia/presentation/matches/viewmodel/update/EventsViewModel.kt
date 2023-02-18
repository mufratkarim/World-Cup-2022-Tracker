package com.mka.fifa.world.cup2022.encyclopedia.presentation.matches.viewmodel.update

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mka.fifa.world.cup2022.encyclopedia.common.Constants
import com.mka.fifa.world.cup2022.encyclopedia.common.Resource
import com.mka.fifa.world.cup2022.encyclopedia.domain.repository.update.get_events.GetEventsUseCase
import com.mka.fifa.world.cup2022.encyclopedia.presentation.matches.components.old.MatchesByIdState
import com.mka.fifa.world.cup2022.encyclopedia.presentation.matches.components.update.EventsState
import com.mka.fifa.world.cup2022.encyclopedia.presentation.matches.components.update.MatchesListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class EventsViewModel @Inject constructor(
    private val getEventsUseCase: GetEventsUseCase,
    savedStateHandle: SavedStateHandle
): ViewModel() {

    private val _state = mutableStateOf(EventsState())
    val state: State<EventsState> = _state

    init {
        savedStateHandle.get<Int>(Constants.PARAM_EVENTS)?.let { eventId ->
            getEventsById(eventId)
        }

    }
    private fun getEventsById(eventId: Int) {
        getEventsUseCase(eventId).onEach { result ->
            when(result) {
                is Resource.Success -> {
                    _state.value = EventsState(events = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _state.value = EventsState(error = result.message ?: Constants.HTTP_ERROR_TEXT)
                }
                is Resource.Loading -> {
                    _state.value = EventsState(isLoading = true)
                }
            }

        }.launchIn(viewModelScope)
    }


}