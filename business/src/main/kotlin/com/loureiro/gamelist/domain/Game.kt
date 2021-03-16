package com.loureiro.gamelist.domain

data class Game(
    val id: String?,
    val name: String,
    val producer: String,
    val platform: String,
    val parentalRating: Int,
    val cooperative: Boolean,
    val rating: Double,
    val comment: String?
)