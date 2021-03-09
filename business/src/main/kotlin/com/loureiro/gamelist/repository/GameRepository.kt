package com.loureiro.gamelist.repository

import com.loureiro.gamelist.domain.Game
import java.util.*

interface GameRepository {

    fun findAll(): List<Game>?

    fun findById(gameId: UUID): Game?

    fun findByName(gameName: String): Game?

    fun create(gameToBeInserted: Game): UUID

    fun update(gameId: UUID, gameToBeUpdated: Game): UUID

    fun delete(gameId: UUID)
}