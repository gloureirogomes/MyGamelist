package com.loureiro.gamelist.services

import com.loureiro.gamelist.repository.GameRepository

class DeleteGameService(private val gameRepository: GameRepository) {

    fun deleteGame(gameId: String) {
        gameRepository.findById(gameId)?.apply {
            gameRepository.delete(gameId)
        }
    }
}