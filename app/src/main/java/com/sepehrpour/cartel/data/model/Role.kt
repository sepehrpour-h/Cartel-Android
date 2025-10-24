package com.sepehrpour.cartel.data.model

data class Role(
    val name: String,
    val description: String,
    val team: TeamType // MAFIA, CITIZEN, NEUTRAL
)
