package br.com.books.data.controller.response.favorite

import br.com.books.data.model.BookVo
import br.com.books.data.model.UserVo

data class FavoriteResponse(
    var uuid: String? = null,
    var book: BookVo,
    var userName: String? = ""
)