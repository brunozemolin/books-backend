package br.com.books.data.model

import org.hibernate.annotations.GenericGenerator
import javax.persistence.*

@Entity
@Table(name = "favorite")
data class FavoriteVo(
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    var uuid: String? = null,

    @Column(name = "user_uuid")
    val userId: String,

    @Column(name = "book_uuid")
    var bookId: String,
)
