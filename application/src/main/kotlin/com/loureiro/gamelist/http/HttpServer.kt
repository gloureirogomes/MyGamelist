package com.loureiro.gamelist.http

import com.loureiro.gamelist.openApi.getConfiguredOpenApiPlugin
import io.javalin.Javalin

fun startHttpServer(port: String = "8080") {
    val mustServeOpenAPIDocs: Boolean = System.getenv().getOrDefault("ENABLE_OPEN_API_DOCS", "false")!!
        .toBoolean()
    val httpPort = System.getenv().getOrDefault("HTTP_PORT", port).toInt()
    val apiVersion = "v1"
    val appContext = "gamelist"

    Javalin.create { config ->
        config.contextPath = "/$appContext/$apiVersion"
        config.showJavalinBanner = false
        if (mustServeOpenAPIDocs) {
            config.registerPlugin(getConfiguredOpenApiPlugin())
        }
        config.enableCorsForAllOrigins()
        config.defaultContentType = "application/json"
    }.also {
        mountRoutes(it)
    }.start(httpPort).apply {
        Runtime.getRuntime().addShutdownHook(Thread { this.stop() })
    }
}
