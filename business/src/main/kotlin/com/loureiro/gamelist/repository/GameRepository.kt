package com.loureiro.gamelist.repository

import com.loureiro.gamelist.domain.Game
import java.util.*

interface GameRepository {

    fun findAll(): List<Game>?

    fun findById(gameId: String): Game?

    fun findByName(gameName: String): Game?

    fun create(gameToBeInserted: Game): String

    fun update(gameId: String, gameToBeUpdated: Game)

    fun delete(gameId: String)
}