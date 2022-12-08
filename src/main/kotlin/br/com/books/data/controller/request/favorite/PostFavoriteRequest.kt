package br.com.books.data.controller.request.favorite

import br.com.books.util.LoginAvailable
import javax.validation.constraints.NotEmpty

data class PostFavoriteRequest(
    @field:NotEmpty(message = "UserId is required.")
    val userId: String,

    @field:NotEmpty(message = "BookId is required.")
    val bookId: String
)
