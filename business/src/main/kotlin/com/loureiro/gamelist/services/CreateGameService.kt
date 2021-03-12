package com.loureiro.gamelist.services

import com.loureiro.gamelist.domain.Game
import com.loureiro.gamelist.repository.GameRepository
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class CreateGameService(private val gameRepository: GameRepository) {
    private val logger: Logger = LoggerFactory.getLogger(javaClass)

    fun createGame(gameToBeInserted: Game): String {
        logger.info("Creating new game: ${gameToBeInserted.id}")
        return gameRepository.create(gameToBeInserted)
    }
}