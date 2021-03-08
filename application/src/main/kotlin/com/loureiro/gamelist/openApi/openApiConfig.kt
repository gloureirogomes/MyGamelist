package com.loureiro.gamelist.openApi

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

const val TAG = "Invoices"

fun healthDocumentation() = document().operation { operation ->
    operation.description = ""
    operation.operationId = "health"
    operation.summary = "Health Check"
    operation.addTagsItem(TAG)
}.json("200", String::class.java)