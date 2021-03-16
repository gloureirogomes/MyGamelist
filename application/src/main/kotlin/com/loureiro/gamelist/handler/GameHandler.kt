package com.loureiro.gamelist.handler

import com.loureiro.gamelist.config.createGameService
import com.loureiro.gamelist.config.deleteGameService
import com.loureiro.gamelist.config.searchGameService
import com.loureiro.gamelist.config.updateGameService
import com.loureiro.gamelist.http.CreateOrUpdateGameRequest
import io.javalin.http.Context

private const val NOT_FOUND_GAME = "There is no game registered with this ID"
private const val NOT_FOUND = 404

fun createGame(ctx: Context) {
    val data = ctx.body<CreateOrUpdateGameRequest>().validatePayload()
    val id = createGameService.createGame(data.toGame())
    ctx.status(201).json(id)
}

fun updateGame(ctx: Context) {
    val gameId = ctx.pathParam("id")
    val data = ctx.body<CreateOrUpdateGameRequest>().validatePayload()
    val id = updateGameService.updateGame(gameId, data.toGame())
    ctx.status(202).json(id)
}

fun deleteGame(ctx: Context) {
    val gameId = ctx.pathParam("id")
    deleteGameService.deleteGame(gameId)
    ctx.status(204)
}

fun findAllGames(ctx: Context) {
    val data = searchGameService.findAllGames() ?: emptyList()
    ctx.status(200).json(data)
}

fun findGameById(ctx: Context) {
    val gameId = ctx.pathParam("id")
    val data = searchGameService.findGameById(gameId) ?: throw HttpClientException(NOT_FOUND, NOT_FOUND_GAME)
    ctx.status(200).json(data)
}

fun findGameByName(ctx: Context) {
    val gameId = ctx.pathParam("name")
    val data = searchGameService.findGameByName(gameId) ?: throw HttpClientException(NOT_FOUND, NOT_FOUND_GAME)
    ctx.status(200).json(data)
}