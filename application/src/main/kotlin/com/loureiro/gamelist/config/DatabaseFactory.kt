package com.loureiro.gamelist.config

import com.mongodb.MongoClient
import com.mongodb.client.MongoDatabase

object DatabaseFactory {

    private val mongoHost = System.getenv().getOrDefault("MONGO_HOST", "127.0.0.1")
    private val mongoPort = System.getenv().getOrDefault("MONGO_PORT", "27017").toInt()
    private val mongoDatabase = System.getenv().getOrDefault("MONGO_DATABASE", "Gamelist")

    val database: MongoDatabase = MongoClient(mongoHost, mongoPort).getDatabase(mongoDatabase)
}