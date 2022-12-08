package br.com.books.mapper

import br.com.books.data.controller.request.book.PostBookRequest
import br.com.books.data.controller.response.book.BookResponse
import br.com.books.data.model.BookVo
import org.springframework.stereotype.Component

@Component
class BookMapper {

    fun toBookModel(postBookRequest: PostBookRequest) = BookVo(
        name = postBookRequest.name,
        url = postBookRequest.url,
        author = postBookRequest.author,
        genre = postBookRequest.genre
    )

    fun toBookResponse(bookVo: BookVo): BookResponse {
        return BookResponse(
            uuid = bookVo.uuid,
            name = bookVo.name,
            url = bookVo.url,
            author = bookVo.author,
            genre = bookVo.genre,
            isFavorite = bookVo.isFavorite
        )
    }
}