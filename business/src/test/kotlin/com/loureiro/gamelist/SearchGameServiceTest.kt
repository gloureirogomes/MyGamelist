package com.loureiro.gamelist

import com.loureiro.gamelist.repository.GameRepository
import com.loureiro.gamelist.services.SearchGameService
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.Test

class SearchGameServiceTest {

    private val mockGamelistRepository = mockk<GameRepository>()
    private val service = SearchGameService(mockGamelistRepository)

    @Test
    fun `find all games`() {
        //Setup
        val mockGame = mockGame()

        every { mockGamelistRepository.findAll() } returns listOf(mockGame)

        //Execution
        service.findAllGames()

        //Assertion
        verify(exactly = 1) { mockGamelistRepository.findAll() }
    }

    @Test
    fun `find game by id`() {
        //Setup
        val mockGame = mockGame()

        every { mockGamelistRepository.findById(any()) } returns mockGame

        //Execution
        mockGame.id?.let { service.findGameById(it) }

        //Assertion
        verify(exactly = 1) { mockGamelistRepository.findById(any()) }
    }

    @Test
    fun `find game by name`() {
        //Setup
        val mockGame = mockGame()

        every { mockGamelistRepository.findByName(any()) } returns mockGame

        //Execution
        service.findGameByName(mockGame.name)

        //Assertion
        verify(exactly = 1) { mockGamelistRepository.findByName(any()) }
    }
}