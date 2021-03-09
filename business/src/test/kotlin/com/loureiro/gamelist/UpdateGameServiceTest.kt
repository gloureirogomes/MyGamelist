package com.loureiro.gamelist

import com.loureiro.gamelist.repository.GamelistRepository
import com.loureiro.gamelist.services.UpdateGameService
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.Test

class UpdateGameServiceTest {

    private val mockGamelistRepository = mockk<GamelistRepository>()
    private val service = UpdateGameService(mockGamelistRepository)

    @Test
    fun `update game`() {
        //Setup
        val mockGame = mockGame()

        every { mockGamelistRepository.findById(mockGame.id) } returns mockGame
        every { mockGamelistRepository.update(any(), any()) } returns mockGame.id

        //Execution
        service.updateGame(mockGame.id, mockGame)

        //Assertion
        verify(exactly = 1) { mockGamelistRepository.findById(any()) }
        verify(exactly = 1) { mockGamelistRepository.update(any(), any()) }
    }
}