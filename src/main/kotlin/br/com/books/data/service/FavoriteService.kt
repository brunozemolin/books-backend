package br.com.books.data.service

import br.com.books.data.model.BookVo
import br.com.books.data.model.FavoriteVo
import br.com.books.data.repository.IFavoriteRepository
import br.com.books.util.exception.Errors
import br.com.books.util.exception.NotFoundException
import org.springframework.stereotype.Service

@Service
class FavoriteService(
        private val iFavoriteRepository: IFavoriteRepository,
) {
    fun create(favoriteVo: FavoriteVo): FavoriteVo {
        return iFavoriteRepository.save(favoriteVo)
    }

    fun findByUuid(uuid: String): FavoriteVo? {
       return iFavoriteRepository.findByUuid(uuid)
    }
    fun findByUserUuidAndBookUuid(userUuid: String, bookUuid: String): FavoriteVo? {
       return iFavoriteRepository.findByUserUuidAndBookUuid(bookUuid, userUuid)
    }

    fun delete(favoriteSaved: FavoriteVo) {
        iFavoriteRepository.delete(favoriteSaved)
    }

    fun findAllByUserUuid(userUuid: String): List<FavoriteVo> {
        return iFavoriteRepository.findAllByUserUuid(userUuid)
    }

}
