package com.loureiro.gamelist.services

import com.loureiro.gamelist.domain.Game
import com.loureiro.gamelist.repository.GamelistRepository
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.util.*

class CreateGameService(private val gamelistRepository: GamelistRepository) {
    private val logger: Logger = LoggerFactory.getLogger(javaClass)

    fun createGame(gameToBeInserted: Game): UUID {
        logger.info("Creating new game: ${gameToBeInserted.id}")
        return gamelistRepository.create(gameToBeInserted)
    }
}