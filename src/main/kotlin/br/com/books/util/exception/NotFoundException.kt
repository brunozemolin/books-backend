package br.com.books.util.exception

class NotFoundException(override val message: String, val errorCode: String) : Exception()