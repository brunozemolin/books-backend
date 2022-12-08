package br.com.books.data.controller.request.book

import javax.validation.constraints.NotEmpty

data class PostBookRequest(

    @field:NotEmpty(message = "Book's name is required.")
    val name: String,

    @field:NotEmpty(message = "Book's cover URL is required.")
    val url: String,

    @field:NotEmpty(message = "Author's name is required.")
    val author: String,

    @field:NotEmpty(message = "Book's genre is required.")
    val genre: String,
)
