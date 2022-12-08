package br.com.books.data.controller

import br.com.books.data.controller.request.book.PostBookRequest
import br.com.books.data.controller.response.book.BookResponse
import br.com.books.data.service.BookService
import br.com.books.data.service.FavoriteService
import br.com.books.mapper.BookMapper
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("books")
@Api(tags = ["Books"])
class BookController(
        private val bookService: BookService,
        private val bookMapper: BookMapper,
        private val favoriteService: FavoriteService
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Method from create a new Book")
    fun create(@RequestBody @Valid request: PostBookRequest): BookResponse {
        return bookMapper.toBookResponse(bookService.create(bookMapper.toBookModel(request)))
    }

    @GetMapping
    @ApiOperation(value = "Method from find all or specific book by Name or Author")
    fun findAll(@RequestParam(required = false) name: String? = null,
                @RequestParam userUuid: String): List<BookResponse> {
        return bookService.getAll(name, userUuid).map { bookMapper.toBookResponse(it) }
    }

    @GetMapping("/{uuid}")
    @ApiOperation(value = "Method from find book by id")
    fun findById(@PathVariable uuid: String): BookResponse {
        return bookMapper.toBookResponse(bookService.findByUuid(uuid))
    }

}