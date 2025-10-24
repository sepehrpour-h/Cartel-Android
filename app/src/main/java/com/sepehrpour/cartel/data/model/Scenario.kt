package com.sepehrpour.cartel.data.model

data class Scenario(
    val id: String,
    val title: String,
    val description: String,
    val roles: List<Role>
)
