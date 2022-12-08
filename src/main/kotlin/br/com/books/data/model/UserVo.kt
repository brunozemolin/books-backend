package br.com.books.data.model

import org.hibernate.annotations.GenericGenerator
import javax.persistence.*

@Entity
@Table(name = "user")
data class UserVo(
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    var uuid: String? = null,

    @Column(name = "login")
    val login: String,

    @Column(name = "password")
    val password: String,

    @Column(name = "name")
    val name: String? = ""
)

