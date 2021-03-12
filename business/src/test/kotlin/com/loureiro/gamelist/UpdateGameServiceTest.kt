package com.loureiro.gamelist

import com.loureiro.gamelist.repository.GameRepository
import com.loureiro.gamelist.services.UpdateGameService
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.Test

class UpdateGameServiceTest {

    private val mockGamelistRepository = mockk<GameRepository>()
    private val service = UpdateGameService(mockGamelistRepository)

    @Test
    fun `update game`() {
        //Setup
        val mockGame = mockGame()

        every { mockGame.id?.let { mockGamelistRepository.findById(it) } } returns mockGame
        every { mockGamelistRepository.update(any(), any()) } returns Unit

        //Execution
        service.updateGame(mockGame.id!!, mockGame)

        //Assertion
        verify(exactly = 1) { mockGamelistRepository.findById(any()) }
        verify(exactly = 1) { mockGamelistRepository.update(any(), any()) }
    }
}