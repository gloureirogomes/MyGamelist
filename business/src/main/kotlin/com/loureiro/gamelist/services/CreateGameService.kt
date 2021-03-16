package com.loureiro.gamelist.services

import com.loureiro.gamelist.domain.Game
import com.loureiro.gamelist.repository.GameRepository

class CreateGameService(private val gameRepository: GameRepository) {

    fun createGame(gameToBeInserted: Game): String {
        return gameRepository.create(gameToBeInserted)
    }
}