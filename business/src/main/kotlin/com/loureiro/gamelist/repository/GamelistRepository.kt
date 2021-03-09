package com.loureiro.gamelist.repository

import com.loureiro.gamelist.domain.Game
import java.util.*

interface GamelistRepository {

    fun findAllGames(): List<Game>?

    fun findGameById(gameId: UUID): Game?

    fun findGameByName(gameName: String): Game?

    fun createGame(gameToBeInserted: Game): UUID

    fun updateGame(gameId: UUID, gameToBeUpdated: Game): UUID

    fun deleteGame(gameId: UUID)
}