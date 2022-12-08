package br.com.books.data.controller.response.book

data class BookResponse(
    var uuid: String? = null,
    var name: String,
    var url: String? = "",
    var author: String? = "",
    var genre: String? = "",
    var isFavorite: Boolean = false
)