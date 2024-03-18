package com.example.domain.repository

import com.example.domain.model.UiBookModel

interface BookRepository {

    // 책 검색하기 api
    suspend fun getSearchBook(
        token: String,
        query: String,
        sort: String?,
        page: Int?,
        size: Int?,
        target: String?,
    ): Result<List<UiBookModel>>

}