package com.loureiro.gamelist.service

import com.loureiro.gamelist.domain.Game
import com.loureiro.gamelist.repository.GamelistRepository
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.util.*

class GameListService(private val gamelistRepository: GamelistRepository) {
    private val logger: Logger = LoggerFactory.getLogger(javaClass)

    fun createGame(gameToBeInserted: Game): UUID {
        logger.info("Creating new game: ${gameToBeInserted.id}")
        return gamelistRepository.createGame(gameToBeInserted)
    }

    fun updateGame(gameId: UUID, gameToBeUpdated: Game): UUID? {
        logger.info("Updating game: ${gameToBeUpdated.id}")
        return gamelistRepository.findGameById(gameId)?.let { game ->
            val updateGameId = gamelistRepository.updateGame(gameId, game)
            updateGameId
        }
    }

    fun deleteGame(gameId: UUID) {
        logger.info("Deleting game: $gameId")
        gamelistRepository.findGameById(gameId)?.apply {
            gamelistRepository.deleteGame(this.id)
        }
    }

    fun findAllGames(): List<Game>? {
        logger.info("Listing all games")
        return gamelistRepository.findAllGames()
    }

    fun findGameById(gameId: UUID): Game? {
        logger.info("searching game by id: $gameId")
        return gamelistRepository.findGameById(gameId)
    }

    fun findGameByName(gameName: String): Game? {
        logger.info("Searching game by name: $gameName")
        return gamelistRepository.findGameByName(gameName)
    }
}