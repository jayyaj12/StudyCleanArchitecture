package com.example.data.mapper

import com.example.data.model.book.BookEntity
import com.example.domain.model.UiBookModel

fun BookEntity.toUiBookModel(): List<UiBookModel> {
    return this.documents.toList().map {
        UiBookModel(
            title = it.title,
            contents = it.contents,
            url = it.url,
            datetime = it.datetime,
            authors = it.authors,
            publisher = it.publisher,
            price = it.price,
            salePrice = it.salePrice,
            thumbnail = it.thumbnail,
            status = it.status
        )
    }
}