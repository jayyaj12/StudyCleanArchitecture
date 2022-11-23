package com.example.searchbookapp.data.repository

import com.example.searchbookapp.data.model.SearchBookResponse
import retrofit2.Response

interface SearchBookRepository {
    suspend fun searchBooks(
        query: String,
        sort: String,
        page: Int,
        size: Int
    ): Response<SearchBookResponse>
}