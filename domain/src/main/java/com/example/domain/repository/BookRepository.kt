package com.example.domain.repository

import com.example.domain.model.Book
import retrofit2.Response

interface BookRepository {

    // 책 검색하기 api
    suspend fun getSearchBook(
        token: String,
        query: String,
        sort: String?,
        page: Int?,
        size: Int?,
        target: String?,
    ): List<Book>

}