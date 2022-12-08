package br.com.books.data.controller.request.user

import br.com.books.util.LoginAvailable
import javax.validation.constraints.NotEmpty

data class PostLoginRequest(

        @field:NotEmpty(message = "Login is required.")
        val login: String,

        @field:NotEmpty(message = "Password is required.")
        val password: String

)
