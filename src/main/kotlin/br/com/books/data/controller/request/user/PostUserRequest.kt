package br.com.books.data.controller.request.user

import br.com.books.util.LoginAvailable
import javax.validation.constraints.NotEmpty

data class PostUserRequest(

        @field:NotEmpty(message = "Login is required.")
        @LoginAvailable(message = "Login is already registered.")
        val login: String,

        @field:NotEmpty(message = "Password is required.")
        val password: String,

        @field:NotEmpty(message = "Name is required.")
        val name: String
)
