package com.loureiro.gamelist.database

import com.loureiro.gamelist.config.DatabaseFactory.database
import com.loureiro.gamelist.domain.Game
import com.loureiro.gamelist.repository.GameRepository
import com.mongodb.client.model.Filters
import org.bson.Document
import org.bson.types.ObjectId


object GameRepositoryImpl : GameRepository {

    private val mongoCollection = database.getCollection("gamelist")

    override fun findAll(): List<Game> {
        return mongoCollection.find().map {
            mapToFindGame(it)
        }.toList()
    }

    override fun findById(gameId: String): Game? = mongoCollection.find(Filters.eq("_id", ObjectId(gameId))).map {
        mapToFindGame(it)
    }.first()


    override fun findByName(gameName: String): Game? = mongoCollection.find(Filters.eq("name", gameName)).map {
        mapToFindGame(it)
    }.first()

    override fun create(gameToBeInserted: Game): String {
        val document = Document()
        mapToCreateOrUpdateGame(document, gameToBeInserted)
        mongoCollection.insertOne(document)
        return document.getObjectId("_id").toHexString()
    }

    override fun update(gameId: String, gameToBeUpdated: Game): String {
        val document = Document()
        mapToCreateOrUpdateGame(document, gameToBeUpdated)
        mongoCollection.replaceOne(Filters.eq("_id", ObjectId(gameId)), document)
        return gameId
    }

    override fun delete(gameId: String) {
        mongoCollection.deleteOne(Filters.eq("_id", ObjectId(gameId)))
    }

    private fun mapToFindGame(document: Document) = Game(
        document.getObjectId("_id").toHexString(),
        document.getString("name"),
        document.getString("producer"),
        document.getString("platform"),
        document.getInteger("parentalRating"),
        document.getBoolean("cooperative"),
        document.getDouble("rating"),
        document.getString("comment")
    )

    private fun mapToCreateOrUpdateGame(document: Document, game: Game) {
        document.let {
            it.append("name", game.name)
            it.append("producer", game.producer)
            it.append("platform", game.platform)
            it.append("parentalRating", game.parentalRating)
            it.append("cooperative", game.cooperative)
            it.append("rating", game.rating)
            it.append("comment", game.comment)
        }
    }
}