package br.com.books.util.exception

class BadRequestException(override val message: String, val errorCode: String) : Exception()