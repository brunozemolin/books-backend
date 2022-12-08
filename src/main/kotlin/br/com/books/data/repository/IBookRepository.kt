package br.com.books.data.repository

import br.com.books.data.model.BookVo
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface IBookRepository : JpaRepository<BookVo, String> {
    fun findByUuid(uuid: String): BookVo?

    @Query("from BookVo where name like %:name% or author like %:name%")
    fun findByNameOrAuthor(name: String): Iterable<BookVo>

}