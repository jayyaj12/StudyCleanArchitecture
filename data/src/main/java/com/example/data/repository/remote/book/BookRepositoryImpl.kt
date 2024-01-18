package com.example.data.repository.remote.book

import com.example.data.model.book.BookEntity
import com.example.domain.repository.BookRepository
import retrofit2.Response
import javax.inject.Inject

class BookRepositoryImpl @Inject constructor(
    private val bookRemoteDataSource: BookRemoteDataSource,
) : BookRepository {

    override suspend fun getSearchBook(
        token: String,
        query: String,
        sort: String,
        page: Int,
        size: Int,
        target: String,
    ): Response<BookEntity.GetSearchBookResponse> {
        return bookRemoteDataSource.getSearchBook(token, query, sort, page, size, target)
    }
}