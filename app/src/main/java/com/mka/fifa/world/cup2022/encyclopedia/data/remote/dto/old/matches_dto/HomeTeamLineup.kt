package com.mka.fifa.world.cup2022.encyclopedia.data.remote.dto.old.matches_dto

data class HomeTeamLineup(
    val country: String,
    val starting_eleven: List<StartingEleven>,
    val substitutes: List<Substitute>,
    val tactics: String
)