package com.example.data.repository.remote.book

import com.example.data.model.book.BookEntity
import com.example.domain.model.Book
import retrofit2.Response

interface BookRemoteDataSource {

    suspend fun getSearchBook(
        token: String,
        query: String,
        sort: String?,
        page: Int?,
        size: Int?,
        target: String?,
    ): BookEntity.GetSearchBookResponse

}