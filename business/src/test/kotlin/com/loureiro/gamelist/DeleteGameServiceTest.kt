package com.loureiro.gamelist

import com.loureiro.gamelist.repository.GameRepository
import com.loureiro.gamelist.services.DeleteGameService
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.Test

class DeleteGameServiceTest {

    private val mockGamelistRepository = mockk<GameRepository>()
    private val service = DeleteGameService(mockGamelistRepository)

    @Test
    fun `delete game`() {
        //Setup
        val mockGame = mockGame()

        every { mockGame.id?.let { mockGamelistRepository.findById(it) } } returns mockGame
        every { mockGamelistRepository.delete(any()) } returns Unit

        //Execution
        mockGame.id?.let { service.deleteGame(it) }

        //Assertion
        verify(exactly = 1) { mockGamelistRepository.findById(any()) }
        verify(exactly = 1) { mockGamelistRepository.delete(any()) }
    }
}