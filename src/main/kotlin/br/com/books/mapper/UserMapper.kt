package br.com.books.mapper

import br.com.books.data.controller.request.user.PostLoginRequest
import br.com.books.data.controller.request.user.PostUserRequest
import br.com.books.data.controller.response.user.UserResponse
import br.com.books.data.model.UserVo
import org.springframework.stereotype.Component

@Component
class UserMapper {

    fun toUserModel(postUserRequest: PostUserRequest) = UserVo(
            login = postUserRequest.login,
            name = postUserRequest.name,
            password = postUserRequest.password
    )

    fun fromLoginToUserModel(postLoginRequest: PostLoginRequest) = UserVo(
            login = postLoginRequest.login,
            password = postLoginRequest.password
    )

    fun toUserResponse(userVo: UserVo) = UserResponse(
            uuid = userVo.uuid,
            name = userVo.name,
            login = userVo.login
    )

}