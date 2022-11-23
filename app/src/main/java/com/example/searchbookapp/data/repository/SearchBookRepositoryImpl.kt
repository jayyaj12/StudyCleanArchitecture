package com.example.searchbookapp.data.repository

import com.example.searchbookapp.data.api.RetrofitInstance.api
import com.example.searchbookapp.data.model.SearchBookResponse
import retrofit2.Response

class SearchBookRepositoryImpl : SearchBookRepository {
    override suspend fun searchBooks(
        query: String,
        sort: String,
        page: Int,
        size: Int
    ): Response<SearchBookResponse> {
        return api.searchBooks(query, sort, page, size)
    }
}