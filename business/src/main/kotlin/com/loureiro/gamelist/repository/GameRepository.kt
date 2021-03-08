package com.loureiro.gamelist.repository

import com.loureiro.gamelist.domain.Game
import java.util.*

interface GameRepository {

    fun findAllGames(): List<Game>?

    fun findGameById(gameId: UUID): Game?

    fun findGameByName(gameName: String): Game?

    fun createGame(gameToInsert: Game): UUID

    fun updateGame(gameId: UUID, gameToUpdate: Game): UUID

    fun deleteGame(gameId: UUID)
}