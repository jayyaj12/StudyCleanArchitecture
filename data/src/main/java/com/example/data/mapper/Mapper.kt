package com.example.data.mapper

import com.example.data.model.book.BookEntity
import com.example.domain.model.Book

fun mapperToBook(book: BookEntity.GetSearchBookResponse): List<Book> {
    return book.documents.toList().map {
        Book(
            title = it.title,
            contents = it.contents,
            datetime = it.datetime,
            authors = it.authors,
            salePrice = it.salePrice,
            thumbnail = it.thumbnail,
            status = it.status

        )
    }
}