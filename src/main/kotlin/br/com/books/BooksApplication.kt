package br.com.books

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableAsync
import org.springframework.web.servlet.config.annotation.EnableWebMvc

@EnableAsync
@EnableWebMvc
@SpringBootApplication
class BooksApplication

fun main(args: Array<String>) {

	runApplication<BooksApplication>(*args)

}
