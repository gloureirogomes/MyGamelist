package com.loureiro.gamelist.http

import com.loureiro.gamelist.handler.liveness
import com.loureiro.gamelist.openApi.healthDocumentation
import io.javalin.Javalin
import io.javalin.core.util.Header
import io.javalin.apibuilder.ApiBuilder.*
import io.javalin.plugin.openapi.dsl.documented

fun mountRoutes(app: Javalin) {
    app.before { ctx ->
        val host = ctx.header("Origin") ?: "*"
        ctx.header(Header.ACCESS_CONTROL_ALLOW_ORIGIN, host)
        ctx.header(Header.ACCESS_CONTROL_ALLOW_HEADERS, "Authorization, Content-Type, Accept")
    }

    app.routes {
        get("/health", documented(healthDocumentation(), ::liveness))
    }
}
