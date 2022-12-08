package br.com.books.data.repository

import br.com.books.data.model.UserVo
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface IUserRepository : JpaRepository<UserVo, String> {

    fun existsByLogin(login: String): Boolean
    fun findByUuid(uuid: String): UserVo
    @Query("from UserVo where login = :login and password = :password")
    fun findByLoginAndPassword(login: String, password: String): UserVo?

}