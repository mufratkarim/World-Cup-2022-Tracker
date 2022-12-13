package com.mka.fifa.world.cup2022.encyclopedia.presentation.groups

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mka.fifa.world.cup2022.encyclopedia.common.Constants
import com.mka.fifa.world.cup2022.encyclopedia.common.Resource
import com.mka.fifa.world.cup2022.encyclopedia.domain.repository.get_groups.GetGroupsUseCase
import com.mka.fifa.world.cup2022.encyclopedia.domain.repository.get_matches.GetMatchesUseCase
import com.mka.fifa.world.cup2022.encyclopedia.presentation.groups.components.GroupsState
import com.mka.fifa.world.cup2022.encyclopedia.presentation.matches.components.MatchesState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class GroupsViewModel @Inject constructor(
    private val getGroupsUseCase: GetGroupsUseCase
): ViewModel() {

    private val _state = mutableStateOf(GroupsState())
    val state: State<GroupsState> = _state

    init {
        getGroups()
    }
    private fun getGroups() {
        getGroupsUseCase().onEach { result ->
            when(result) {
                is Resource.Success -> {
                    _state.value = GroupsState(groups = result.data)
                }
                is Resource.Error -> {
                    _state.value = GroupsState(error = result.message ?: Constants.HTTP_ERROR_TEXT)
                }
                is Resource.Loading -> {
                    _state.value = GroupsState(isLoading = true)
                }
            }

        }.launchIn(viewModelScope)
    }


}