package com.loureiro.gamelist.services

import com.loureiro.gamelist.domain.Game
import com.loureiro.gamelist.repository.GameRepository

class SearchGameService(private val gameRepository: GameRepository) {

    fun findAllGames(): List<Game>? {
        return gameRepository.findAll()
    }

    fun findGameById(gameId: String): Game? {
        return gameRepository.findById(gameId)
    }

    fun findGameByName(gameName: String): Game? {
        return gameRepository.findByName(gameName)
    }
}