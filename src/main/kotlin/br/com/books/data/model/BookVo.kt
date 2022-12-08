package br.com.books.data.model

import org.hibernate.annotations.GenericGenerator
import javax.persistence.*

@Entity
@Table(name = "book")
data class BookVo(
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    var uuid: String? = null,

    @Column(name = "name")
    val name: String,

    @Column(name = "url")
    var url: String? = "",

    @Column(name = "author")
    var author: String,

    @Column(name = "genre")
    var genre: String,

    var isFavorite: Boolean = false
)
