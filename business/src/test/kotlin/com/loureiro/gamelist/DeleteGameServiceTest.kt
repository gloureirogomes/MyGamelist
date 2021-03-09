package com.loureiro.gamelist

import com.loureiro.gamelist.repository.GamelistRepository
import com.loureiro.gamelist.services.DeleteGameService
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.Test

class DeleteGameServiceTest {

    private val mockGamelistRepository = mockk<GamelistRepository>()
    private val service = DeleteGameService(mockGamelistRepository)

    @Test
    fun `delete game`() {
        //Setup
        val mockGame = mockGame()

        every { mockGamelistRepository.findById(mockGame.id) } returns mockGame
        every { mockGamelistRepository.delete(any()) } returns Unit

        //Execution
        service.deleteGame(mockGame.id)

        //Assertion
        verify(exactly = 1) { mockGamelistRepository.findById(any()) }
        verify(exactly = 1) { mockGamelistRepository.delete(any()) }
    }
}