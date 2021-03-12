package com.loureiro.gamelist.services

import com.loureiro.gamelist.domain.Game
import com.loureiro.gamelist.repository.GameRepository
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class UpdateGameService(private val gameRepository: GameRepository) {
    private val logger: Logger = LoggerFactory.getLogger(javaClass)

    fun updateGame(gameId: String, gameToBeUpdated: Game) {
        logger.info("Updating game: ${gameToBeUpdated.id}")
        gameRepository.findById(gameId)?.let { game ->
            gameRepository.update(gameId, game)
        }
    }
}