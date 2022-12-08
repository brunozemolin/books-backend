package br.com.books.mapper

import br.com.books.data.controller.request.favorite.PostFavoriteRequest
import br.com.books.data.controller.response.favorite.FavoriteResponse
import br.com.books.data.model.BookVo
import br.com.books.data.model.FavoriteVo
import org.springframework.stereotype.Component

@Component
class FavoriteMapper {

    fun toFavoriteModel(postFavoriteRequest: PostFavoriteRequest) = FavoriteVo(
        userId = postFavoriteRequest.userId,
        bookId = postFavoriteRequest.bookId
    )

    fun toFavoriteResponse(favoriteVo: FavoriteVo, bookVo: BookVo, name: String?): FavoriteResponse {
        return FavoriteResponse(
            uuid = favoriteVo.uuid,
            book = bookVo,
            userName = name,
        )
    }
}