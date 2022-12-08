package br.com.books.data.controller

import br.com.books.data.controller.request.favorite.PostFavoriteRequest
import br.com.books.data.controller.response.book.BookResponse
import br.com.books.data.controller.response.favorite.FavoriteResponse
import br.com.books.data.service.BookService
import br.com.books.data.service.FavoriteService
import br.com.books.data.service.UserService
import br.com.books.mapper.BookMapper
import br.com.books.mapper.FavoriteMapper
import br.com.books.util.exception.Errors
import br.com.books.util.exception.NotFoundException
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("favorites")
@Api(tags = ["Favorites"])
class FavoriteController(
        private val favoriteService: FavoriteService,
        private val favoriteMapper: FavoriteMapper,
        private val bookMapper: BookMapper,
        private val bookService: BookService,
        private val userService: UserService
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Method to set a favorite Book to User")
    fun create(@RequestBody @Valid request: PostFavoriteRequest): FavoriteResponse {
        val favoriteSaved = favoriteService.findByUserUuidAndBookUuid(request.userId, request.bookId)
        favoriteSaved?.let {
            throw NotFoundException(Errors.BOOKS601.message.format(request.bookId), Errors.BOOKS601.code)
        } ?: run {
            val favoriteVo = favoriteService.create(favoriteMapper.toFavoriteModel(request))
            val bookVo = bookService.findByUuid(favoriteVo.bookId)
            bookVo.isFavorite = true
            val userVo = userService.findByUuid(favoriteVo.userId)
            return favoriteMapper.toFavoriteResponse(favoriteVo, bookVo, userVo.name)
        }
    }

    @DeleteMapping("/{userUuid}/{bookUuid}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Method from remove favorite Book")
    fun delete(@PathVariable userUuid: String,
               @PathVariable bookUuid: String) {
        val favoriteSaved = favoriteService.findByUserUuidAndBookUuid(userUuid, bookUuid)
        favoriteSaved?.let {
            favoriteService.delete(favoriteSaved)
        }
    }

    @GetMapping
    @ApiOperation(value = "Method from find all favorite Books by User")
    fun findAll(@RequestParam(required = false) name: String? = null,
                @RequestParam userUuid: String): List<FavoriteResponse> {
        val favorites = favoriteService.findAllByUserUuid(userUuid)
        val favoriteResponse = mutableListOf<FavoriteResponse>()
        favorites.forEach { favorite ->
            val bookSaved = bookService.findFavoriteBookByUuid(favorite.bookId)
            val userSaved = userService.findByUuid(userUuid)
            val toFavoriteResponse = favoriteMapper.toFavoriteResponse(favorite, bookSaved, userSaved.name)
            favoriteResponse.add(toFavoriteResponse)
        }
        return favoriteResponse
    }

}