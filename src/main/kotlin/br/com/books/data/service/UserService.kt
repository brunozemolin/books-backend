package br.com.books.data.service

import br.com.books.data.model.UserVo
import br.com.books.data.repository.IUserRepository
import br.com.books.util.exception.Errors
import br.com.books.util.exception.NotFoundException
import org.springframework.stereotype.Service

@Service
class UserService(
        private val userRepository: IUserRepository,
) {
    fun create(userVo: UserVo): UserVo {
        return userRepository.save(userVo)
    }

    fun loginAvailable(login: String): Boolean {
        return !userRepository.existsByLogin(login)
    }

    fun findByUuid(uuid: String): UserVo {
        return userRepository.findByUuid(uuid)
    }

    fun login(userVo: UserVo): UserVo {
        return userRepository.findByLoginAndPassword(userVo.login, userVo.password)
                ?: throw NotFoundException(Errors.BOOKS101.message, Errors.BOOKS101.code)
    }

}

