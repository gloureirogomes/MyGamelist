package com.loureiro.gamelist.openApi

import com.loureiro.gamelist.domain.Game
import com.loureiro.gamelist.http.CreateOrUpdateGameRequest
import io.javalin.plugin.openapi.OpenApiOptions
import io.javalin.plugin.openapi.OpenApiPlugin
import io.javalin.plugin.openapi.dsl.document
import io.javalin.plugin.openapi.ui.SwaggerOptions
import io.swagger.v3.oas.models.info.Info

fun getConfiguredOpenApiPlugin() = OpenApiPlugin(
    OpenApiOptions(
        Info().apply {
            title("My Gamelist")
            version("1.0.0")
            description("My Gamelist API documentation")
        }
    ).apply {
        path("/swagger-docs")
        swagger(SwaggerOptions("/swagger-ui").title("My Gamelist Swagger Documentation"))
        defaultDocumentation { doc ->
            doc.json("500", String::class.java)
        }
    }
)

const val TAG = "Gamelist"

fun healthDocumentation() = document().operation { operation ->
    operation.summary = "Health Check"
    operation.description = ""
    operation.operationId = "health"
    operation.addTagsItem(TAG)
}.json("200", String::class.java)

fun createGameDocumentation() = document().operation { operation ->
    operation.summary = "Create Game"
    operation.operationId = "createGame"
    operation.description = "Create a new game"
    operation.addTagsItem(TAG)
}.body<CreateOrUpdateGameRequest>()
    .json("200", String::class.java)

fun deleteGameDocumentation() = document().operation { oper ->
    oper.summary = "Delete game"
    oper.operationId = "deleteGame"
    oper.description = "Delete game by id on database"
    oper.addTagsItem(TAG)
}.json("204", Game::class.java)

fun findAllGamesDocumentation() = document().operation { oper ->
    oper.summary = "Get all games"
    oper.operationId = "findAllGames"
    oper.description = "Get all games on database"
    oper.addTagsItem(TAG)
}.jsonArray("200", Game::class.java)

fun findGameByIdDocumentation() = document().operation { oper ->
    oper.summary = "Get game by ID"
    oper.operationId = "findGameById"
    oper.description = "Get game by id on database"
    oper.addTagsItem(TAG)
}.json("200", Game::class.java)

fun findGameByNameDocumentation() = document().operation { oper ->
    oper.summary = "Get game by name"
    oper.operationId = "findGameByName"
    oper.description = "Get game by name on database"
    oper.addTagsItem(TAG)
}.json("200", Game::class.java)
