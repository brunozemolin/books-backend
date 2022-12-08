package br.com.books.data.controller.response.user

data class UserResponse(
    val uuid: String? = null,
    val login: String,
    val name: String? = ""
)