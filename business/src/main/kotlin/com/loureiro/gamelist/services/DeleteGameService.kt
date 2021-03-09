package com.loureiro.gamelist.services

import com.loureiro.gamelist.repository.GamelistRepository
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.util.*

class DeleteGameService(private val gamelistRepository: GamelistRepository) {
    private val logger: Logger = LoggerFactory.getLogger(javaClass)

    fun deleteGame(gameId: UUID) {
        logger.info("Deleting game: $gameId")
        gamelistRepository.findById(gameId)?.apply {
            gamelistRepository.delete(this.id)
        }
    }
}