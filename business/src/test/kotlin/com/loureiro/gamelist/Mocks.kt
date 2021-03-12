package com.loureiro.gamelist

import com.loureiro.gamelist.domain.Game
import java.util.*

internal fun mockGame() = Game(
    id = UUID.randomUUID().toString(),
    name = "The Last of Us",
    producer = "Naughty Dog",
    platform = "Playstation",
    parentalRating = 18,
    cooperative = false,
    rating = 5,
    comment = "The best game!!!"
)