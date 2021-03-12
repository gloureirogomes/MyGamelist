package com.loureiro.gamelist.http

import com.loureiro.gamelist.domain.Game
import com.loureiro.gamelist.handler.BadRequestException
import org.valiktor.ConstraintViolationException
import org.valiktor.functions.isNotBlank
import org.valiktor.functions.isNotNull
import org.valiktor.i18n.mapToMessage
import org.valiktor.validate

data class CreateOrUpdateGameRequest(
    val id: String?,
    val name: String,
    val producer: String,
    val platform: String,
    val parentalRating: Int,
    val cooperative: Boolean,
    val rating: Int,
    val comment: String?
) {
    fun validatePayload() = performValidation {
        validate(this) {
            validate(CreateOrUpdateGameRequest::name).isNotNull().isNotBlank()
            validate(CreateOrUpdateGameRequest::producer).isNotNull().isNotBlank()
            validate(CreateOrUpdateGameRequest::platform).isNotNull().isNotBlank()
            validate(CreateOrUpdateGameRequest::parentalRating).isNotNull()
            validate(CreateOrUpdateGameRequest::cooperative).isNotNull()
            validate(CreateOrUpdateGameRequest::rating).isNotNull()
        }
        this
    }

    fun toGame() = Game(
        id = id,
        name = name,
        producer = producer,
        platform = platform,
        parentalRating = parentalRating,
        cooperative = cooperative,
        rating = rating,
        comment = comment
    )
}

fun <T> performValidation(validate: () -> T) =
    try {
        validate()
    } catch (ex: ConstraintViolationException) {
        throw BadRequestException(
            "Invalid content",
            ex.constraintViolations
                .mapToMessage()
                .map { "${it.property}: ${it.message}" }
        )
    }