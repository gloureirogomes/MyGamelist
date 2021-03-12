package com.loureiro.gamelist.config

import com.loureiro.gamelist.database.GameRepositoryImpl
import com.loureiro.gamelist.services.CreateGameService
import com.loureiro.gamelist.services.DeleteGameService
import com.loureiro.gamelist.services.SearchGameService
import com.loureiro.gamelist.services.UpdateGameService

val createGameService = CreateGameService(GameRepositoryImpl)
val updateGameService = UpdateGameService(GameRepositoryImpl)
val deleteGameService = DeleteGameService(GameRepositoryImpl)
val searchGameService = SearchGameService(GameRepositoryImpl)