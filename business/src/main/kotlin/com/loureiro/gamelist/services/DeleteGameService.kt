package com.loureiro.gamelist.services

import com.loureiro.gamelist.repository.GameRepository
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.util.*

class DeleteGameService(private val gameRepository: GameRepository) {
    private val logger: Logger = LoggerFactory.getLogger(javaClass)

    fun deleteGame(gameId: UUID) {
        logger.info("Deleting game: $gameId")
        gameRepository.findById(gameId)?.apply {
            gameRepository.delete(this.id)
        }
    }
}