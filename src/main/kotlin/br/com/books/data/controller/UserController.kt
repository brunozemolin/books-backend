package br.com.books.data.controller

import br.com.books.data.controller.request.user.PostLoginRequest
import br.com.books.data.controller.request.user.PostUserRequest
import br.com.books.data.controller.response.user.UserResponse
import br.com.books.data.service.UserService
import br.com.books.mapper.UserMapper
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("users")
@Api(tags = ["Users"])
class UserController(
        private val userService: UserService,
        private val userMapper: UserMapper,
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Method to create a new user")
    fun create(@RequestBody @Valid request: PostUserRequest): UserResponse {
        return userMapper.toUserResponse(userService.create(userMapper.toUserModel(request)))
    }

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Method to request login from user")
    fun login(@RequestBody @Valid request: PostLoginRequest): UserResponse {
        return userMapper.toUserResponse(userService.login(userMapper.fromLoginToUserModel(request)))
    }

}