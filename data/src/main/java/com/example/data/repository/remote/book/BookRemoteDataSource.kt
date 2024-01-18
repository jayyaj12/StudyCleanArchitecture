package com.example.data.repository.remote.book

import com.example.data.model.book.BookEntity
import retrofit2.Response

interface BookRemoteDataSource {

    suspend fun getSearchBook(
        token: String,
        query: String,
        sort: String,
        page: Int,
        size: Int,
        target: String,
    ): Response<BookEntity.GetSearchBookResponse>

}