package br.com.books.util.exception

class AuthenticationException(override val message: String, val errorCode: String) : Exception()