package com.loureiro.gamelist.domain

import java.util.*

data class Game(
    val id: UUID,
    val name: String,
    val producer: String,
    val platform: String,
    val parentalRating: String,
    val cooperative: Boolean,
    val rating: Int,
    val comment: String?
)