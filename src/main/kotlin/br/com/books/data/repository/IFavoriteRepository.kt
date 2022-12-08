package br.com.books.data.repository

import br.com.books.data.model.BookVo
import br.com.books.data.model.FavoriteVo
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface IFavoriteRepository : JpaRepository<FavoriteVo, String> {
    fun findByUuid(uuid: String): FavoriteVo?


    @Query("from FavoriteVo where userId like %:userUuid% and bookId like %:bookUuid%")
    fun findByUserUuidAndBookUuid(bookUuid: String?, userUuid: String): FavoriteVo?

    @Query("from FavoriteVo where userId like %:userUuid%")
    fun findAllByUserUuid(userUuid: String): List<FavoriteVo>
//
//    @Query("from BookVo where name like %:name% or author like %:name%")
//    fun findByNameOrAuthor(name: String): Iterable<BookVo>
}