package com.loureiro.gamelist.handler

import io.javalin.http.Context

fun liveness(ctx: Context) {
    ctx.status(200).json("Health")
}