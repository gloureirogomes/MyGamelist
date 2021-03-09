package com.loureiro.gamelist

import com.loureiro.gamelist.repository.GamelistRepository
import com.loureiro.gamelist.service.GameListService
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.Test

class GamelistServiceTest {

    private val gamelistRepository = mockk<GamelistRepository>()
    private val service = GameListService(gamelistRepository)

    @Test
    fun `create game`() {
        //Setup
        val mockGame = mockGame()

        every { gamelistRepository.createGame(any()) } returns mockGame.id

        //Execution
        service.createGame(mockGame)

        //Assertion
        verify(exactly = 1) { gamelistRepository.createGame(any()) }
    }

    @Test
    fun `update game`() {
        //Setup
        val mockGame = mockGame()

        every { gamelistRepository.findGameById(mockGame.id) } returns mockGame
        every { gamelistRepository.updateGame(any(), any()) } returns mockGame.id

        //Execution
        service.updateGame(mockGame.id, mockGame)

        //Assertion
        verify(exactly = 1) { gamelistRepository.findGameById(any()) }
        verify(exactly = 1) { gamelistRepository.updateGame(any(), any()) }
    }

    @Test
    fun `delete game`() {
        //Setup
        val mockGame = mockGame()

        every { gamelistRepository.findGameById(mockGame.id) } returns mockGame
        every { gamelistRepository.deleteGame(any()) } returns Unit

        //Execution
        service.deleteGame(mockGame.id)

        //Assertion
        verify(exactly = 1) { gamelistRepository.findGameById(any()) }
        verify(exactly = 1) { gamelistRepository.deleteGame(any()) }
    }

    @Test
    fun `find all games`() {
        //Setup
        val mockGame = mockGame()

        every { gamelistRepository.findAllGames() } returns listOf(mockGame)

        //Execution
        service.findAllGames()

        //Assertion
        verify(exactly = 1) { gamelistRepository.findAllGames() }
    }

    @Test
    fun `find game by id`() {
        //Setup
        val mockGame = mockGame()

        every { gamelistRepository.findGameById(any()) } returns mockGame

        //Execution
        service.findGameById(mockGame.id)

        //Assertion
        verify(exactly = 1) { gamelistRepository.findGameById(any()) }
    }

    @Test
    fun `find game by name`() {
        //Setup
        val mockGame = mockGame()

        every { gamelistRepository.findGameByName(any()) } returns mockGame

        //Execution
        service.findGameByName(mockGame.name)

        //Assertion
        verify(exactly = 1) { gamelistRepository.findGameByName(any()) }
    }
}