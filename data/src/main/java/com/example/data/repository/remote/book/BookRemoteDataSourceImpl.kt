package com.example.data.repository.remote.book

import com.example.data.api.ApiService
import com.example.data.model.book.BookEntity
import com.example.domain.model.Book
import retrofit2.Response
import javax.inject.Inject

class BookRemoteDataSourceImpl @Inject constructor(private val apiService: ApiService) :
    BookRemoteDataSource {

    override suspend fun getSearchBook(
        token: String,
        query: String,
        sort: String?,
        page: Int?,
        size: Int?,
        target: String?
    ): BookEntity.GetSearchBookResponse {
        return apiService.getSearchBook(token, query, sort, page, size, target)
    }
}