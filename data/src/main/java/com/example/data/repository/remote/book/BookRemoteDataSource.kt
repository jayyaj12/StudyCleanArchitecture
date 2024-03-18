package com.example.data.repository.remote.book

import com.example.domain.NetworkState
import com.example.data.model.book.BookEntity

interface BookRemoteDataSource {

    suspend fun getSearchBook(
        token: String,
        query: String,
        sort: String?,
        page: Int?,
        size: Int?,
        target: String?,
    ): NetworkState<BookEntity>

}