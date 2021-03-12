package com.loureiro.gamelist

import com.loureiro.gamelist.repository.GameRepository
import com.loureiro.gamelist.services.CreateGameService
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.Test

class CreateGameServiceTest {

    private val mockGamelistRepository = mockk<GameRepository>()
    private val service = CreateGameService(mockGamelistRepository)

    @Test
    fun `create game`() {
        //Setup
        val mockGame = mockGame()

        every { mockGamelistRepository.create(any()) } returns mockGame.id.toString()

        //Execution
        service.createGame(mockGame)

        //Assertion
        verify(exactly = 1) { mockGamelistRepository.create(any()) }
    }
}
