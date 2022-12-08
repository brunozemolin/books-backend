package br.com.books.data.service

import br.com.books.data.model.BookVo
import br.com.books.data.repository.IBookRepository
import br.com.books.data.repository.IFavoriteRepository
import br.com.books.util.exception.Errors
import br.com.books.util.exception.NotFoundException
import org.springframework.stereotype.Service

@Service
class BookService(
    private val bookRepository: IBookRepository,
    private val favoriteRepository: IFavoriteRepository
) {
    fun create(bookVo: BookVo): BookVo {
        return bookRepository.save(bookVo)
    }
    fun findByUuid(uuid: String): BookVo {
        return bookRepository.findByUuid(uuid)
            ?: throw NotFoundException(Errors.BOOKS201.message.format(uuid), Errors.BOOKS201.code)
    }

    fun getAll(name: String?, userUuid: String): List<BookVo> {
        var books = mutableListOf<BookVo>()
        name?.let {
            books = bookRepository.findByNameOrAuthor(it).toMutableList()
        } ?: run {
            books = bookRepository.findAll().toMutableList()
        }
        books.forEach{ book ->
            val hasFavorite = favoriteRepository.findByUserUuidAndBookUuid(book.uuid, userUuid)
            hasFavorite?.let { book.isFavorite = true }
        }
        return books
    }

    fun findFavoriteBookByUuid(bookId: String): BookVo {
        val bookSaved = bookRepository.findByUuid(bookId)
        bookSaved?.isFavorite = true
        return bookSaved ?: throw NotFoundException(Errors.BOOKS201.message.format(bookId), Errors.BOOKS201.code)
    }

}
