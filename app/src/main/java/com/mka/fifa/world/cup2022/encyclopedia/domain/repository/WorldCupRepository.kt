package com.mka.fifa.world.cup2022.encyclopedia.domain.repository

import com.mka.fifa.world.cup2022.encyclopedia.data.remote.dto.update.events.EventsByIdDto
import com.mka.fifa.world.cup2022.encyclopedia.data.remote.dto.update.events.EventsDto
import com.mka.fifa.world.cup2022.encyclopedia.data.remote.dto.update.groups.GroupsDto
import com.mka.fifa.world.cup2022.encyclopedia.data.remote.dto.update.matches.Updated_MatchesDto
import com.mka.fifa.world.cup2022.encyclopedia.data.remote.dto.update.players.PlayersDto
import com.mka.fifa.world.cup2022.encyclopedia.data.remote.dto.update.teams.TeamsDto

interface WorldCupRepository {

//    suspend fun getMatches(): List<MatchesDto>
//
//    suspend fun getMatchesByDate(matchesByDate: String): List<MatchesDto>
//
//    suspend fun getMatchesByGoals(matchesByGoals: String): List<MatchesDto>
//
//    suspend fun getMatchesById(matchesById: Int): MatchesByIdDto
//
//    suspend fun getGroups(): GroupsDto
//
//    suspend fun getTeamById(teamId: String): TeamByIdDto
//
//    suspend fun getTeamUpdatesById(teamId: String): List<MatchesByIdDto>

    suspend fun getUpdatedMatches(): List<Updated_MatchesDto>
    suspend fun getPlayers(): List<PlayersDto>
    suspend fun getTeams(): List<TeamsDto>
    suspend fun getEvents(eventId: Int): List<EventsDto>
    suspend fun getGroups(): List<GroupsDto>
}