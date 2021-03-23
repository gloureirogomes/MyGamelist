package com.loureiro.gamelist.config

import com.mongodb.MongoClient
import com.mongodb.MongoClientURI
import com.mongodb.client.MongoDatabase

object DatabaseFactory {

    private val mongoDatabase = System.getenv().getOrDefault("MONGO_DATABASE", "Gamelist")
    private val mongoHost = System.getenv().getOrDefault("MONGO_HOST", "127.0.0.1:27001")
    private val uri: MongoClientURI = MongoClientURI(mongoHost)

    val database: MongoDatabase = MongoClient(uri).getDatabase(mongoDatabase)
}