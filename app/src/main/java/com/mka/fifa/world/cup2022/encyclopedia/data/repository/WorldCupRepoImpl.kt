package com.mka.fifa.world.cup2022.encyclopedia.data.repository

import com.mka.fifa.world.cup2022.encyclopedia.data.remote.WorldCupApi
import com.mka.fifa.world.cup2022.encyclopedia.data.remote.dto.update.events.EventsByIdDto
import com.mka.fifa.world.cup2022.encyclopedia.data.remote.dto.update.events.EventsDto
import com.mka.fifa.world.cup2022.encyclopedia.data.remote.dto.update.groups.GroupsDto
import com.mka.fifa.world.cup2022.encyclopedia.data.remote.dto.update.matches.Updated_MatchesDto
import com.mka.fifa.world.cup2022.encyclopedia.data.remote.dto.update.players.PlayersDto
import com.mka.fifa.world.cup2022.encyclopedia.data.remote.dto.update.teams.TeamsDto
import com.mka.fifa.world.cup2022.encyclopedia.domain.repository.WorldCupRepository
import javax.inject.Inject

class WorldCupRepoImpl @Inject constructor(
    private val api: WorldCupApi
) : WorldCupRepository {

    //    override suspend fun getMatches(): List<MatchesDto> {
//        return api.getMatches()
//    }
//
//    override suspend fun getMatchesByDate(matchesByDate: String): List<MatchesDto> {
//        return api.getMatchesByDate(matchesByDate)
//    }
//
//    override suspend fun getMatchesByGoals(matchesByGoals: String): List<MatchesDto> {
//        return api.getMatchesByGoals(matchesByGoals)
//    }
//
//    override suspend fun getMatchesById(matchesById: Int): MatchesByIdDto {
//        return api.getMatchesById(matchesById)
//    }
//
//    override suspend fun getGroups(): GroupsDto {
//        return api.getGroups()
//    }
//
//    override suspend fun getTeamById(teamId: String): TeamByIdDto {
//        return api.getTeamById(teamId)
//    }
//
//    override suspend fun getTeamUpdatesById(teamId: String): List<MatchesByIdDto> {
//        return api.getTeamUpdatesById(teamId)
//    }
    override suspend fun getUpdatedMatches(): List<Updated_MatchesDto> {
        return api.getUpdatedMatches();
    }

    override suspend fun getPlayers(): List<PlayersDto> {
        return api.getPlayers();
    }

    override suspend fun getTeams(): List<TeamsDto> {
        return api.getTeams();
    }

    override suspend fun getGroups(): List<GroupsDto> {
        val groupsByIdDto = api.getGroups();
        val groupsById = mutableMapOf<Int, List<GroupsDto>>()
        groupsById[1] = groupsByIdDto.`1`;
        groupsById[2] = groupsByIdDto.`2`;
        groupsById[3] = groupsByIdDto.`3`;
        groupsById[4] = groupsByIdDto.`4`;
        groupsById[5] = groupsByIdDto.`5`;
        groupsById[6] = groupsByIdDto.`6`;
        groupsById[7] = groupsByIdDto.`7`;
        groupsById[8] = groupsByIdDto.`8`;

        val allGroups = mutableListOf<GroupsDto>()
        groupsById.values.forEach { allGroups.addAll(it) }
        return allGroups;
    }

    override suspend fun getEvents(eventId: Int): List<EventsDto> {
        val eventsByIdDto = api.getEvents();
        return when (eventId) {

            1 -> eventsByIdDto.`1`
            2 -> eventsByIdDto.`2`
            3 -> eventsByIdDto.`3`
            4 -> eventsByIdDto.`4`
            5 -> eventsByIdDto.`5`
            6 -> eventsByIdDto.`6`
            7 -> eventsByIdDto.`7`
            8 -> eventsByIdDto.`8`
            9 -> eventsByIdDto.`9`
            10 -> eventsByIdDto.`10`
            11 -> eventsByIdDto.`11`
            12 -> eventsByIdDto.`12`
            13 -> eventsByIdDto.`13`
            14 -> eventsByIdDto.`14`
            15 -> eventsByIdDto.`15`
            16 -> eventsByIdDto.`16`
            17 -> eventsByIdDto.`17`
            18 -> eventsByIdDto.`18`
            19 -> eventsByIdDto.`19`
            20 -> eventsByIdDto.`20`
            21 -> eventsByIdDto.`21`
            22 -> eventsByIdDto.`22`
            23 -> eventsByIdDto.`23`
            24 -> eventsByIdDto.`24`
            25 -> eventsByIdDto.`25`
            26 -> eventsByIdDto.`26`
            27 -> eventsByIdDto.`27`
            28 -> eventsByIdDto.`28`
            29 -> eventsByIdDto.`29`
            30 -> eventsByIdDto.`30`
            31 -> eventsByIdDto.`31`
            32 -> eventsByIdDto.`32`
            33 -> eventsByIdDto.`33`
            34 -> eventsByIdDto.`34`
            35 -> eventsByIdDto.`35`
            36 -> eventsByIdDto.`36`
            37 -> eventsByIdDto.`37`
            38 -> eventsByIdDto.`38`
            39 -> eventsByIdDto.`39`
            40 -> eventsByIdDto.`40`
            41 -> eventsByIdDto.`41`
            42 -> eventsByIdDto.`42`
            43 -> eventsByIdDto.`43`
            44 -> eventsByIdDto.`44`
            45 -> eventsByIdDto.`45`
            46 -> eventsByIdDto.`46`
            47 -> eventsByIdDto.`47`
            48 -> eventsByIdDto.`48`
            49 -> eventsByIdDto.`49`
            50 -> eventsByIdDto.`50`
            51 -> eventsByIdDto.`51`
            52 -> eventsByIdDto.`52`
            53 -> eventsByIdDto.`53`
            54 -> eventsByIdDto.`54`
            55 -> eventsByIdDto.`55`
            56 -> eventsByIdDto.`56`
            57 -> eventsByIdDto.`57`
            58 -> eventsByIdDto.`58`
            59 -> eventsByIdDto.`59`
            60 -> eventsByIdDto.`60`
            61 -> eventsByIdDto.`61`
            62 -> eventsByIdDto.`62`
            63 -> eventsByIdDto.`63`
            64 -> eventsByIdDto.`64`

            else -> {
                emptyList()
            }
        }
    }
}
