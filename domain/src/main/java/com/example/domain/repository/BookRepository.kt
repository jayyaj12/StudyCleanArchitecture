package com.example.domain.repository

import com.example.data.model.book.BookEntity
import retrofit2.Response

interface BookRepository {

    // 책 검색하기 api
    suspend fun getSearchBook(
        token: String,
        query: String,
        sort: String,
        page: Int,
        size: Int,
        target: String,
    ): Response<BookEntity.GetSearchBookResponse>

}