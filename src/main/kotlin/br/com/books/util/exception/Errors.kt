package br.com.books.util.exception

enum class Errors(val code: String, val message: String) {

    BOOKS000("BOOKS-000", "Access Denied"),
    BOOKS001("BOOKS-001", "Invalid Request"),
    BOOKS101("BOOKS-101", "Usuário ou Senha inválidos."),
    BOOKS201("BOOKS-201", "Book [%s] not exists"),

    BOOKS301("BOOKS-301", "User [%s] not exists"),

    BOOKS601("BOOKS-501", "The Book [%s] is already favorite."),

}