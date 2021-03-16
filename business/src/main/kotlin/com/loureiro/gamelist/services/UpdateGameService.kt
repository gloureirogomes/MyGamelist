package com.loureiro.gamelist.services

import com.loureiro.gamelist.domain.Game
import com.loureiro.gamelist.repository.GameRepository

class UpdateGameService(private val gameRepository: GameRepository) {

    fun updateGame(gameId: String, gameToBeUpdated: Game): String {
        return gameRepository.findById(gameId).let {
            gameRepository.update(gameId, gameToBeUpdated)
        }
    }
}