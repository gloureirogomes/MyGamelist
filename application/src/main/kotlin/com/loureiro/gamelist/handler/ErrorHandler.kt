package com.loureiro.gamelist.handler

class HttpClientException(statusCode: Int, httpMessage: String) :
    Exception("HTTP Exception $statusCode $httpMessage")

class BadRequestException(message: String, val messages: List<String>? = null) : RuntimeException(message)