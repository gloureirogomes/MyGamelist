package com.loureiro.gamelist.services

import com.loureiro.gamelist.domain.Game
import com.loureiro.gamelist.repository.GameRepository
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.util.*

class SearchGameService(private val gameRepository: GameRepository) {
    private val logger: Logger = LoggerFactory.getLogger(javaClass)

    fun findAllGames(): List<Game>? {
        logger.info("Listing all games")
        return gameRepository.findAll()
    }

    fun findGameById(gameId: UUID): Game? {
        logger.info("searching game by id: $gameId")
        return gameRepository.findById(gameId)
    }

    fun findGameByName(gameName: String): Game? {
        logger.info("Searching game by name: $gameName")
        return gameRepository.findByName(gameName)
    }
}