package com.loureiro.gamelist.services

import com.loureiro.gamelist.domain.Game
import com.loureiro.gamelist.repository.GameRepository
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.util.*

class UpdateGameService(private val gameRepository: GameRepository) {
    private val logger: Logger = LoggerFactory.getLogger(javaClass)

    fun updateGame(gameId: UUID, gameToBeUpdated: Game): UUID? {
        logger.info("Updating game: ${gameToBeUpdated.id}")
        return gameRepository.findById(gameId)?.let { game ->
            val updateGameId = gameRepository.update(gameId, game)
            updateGameId
        }
    }
}