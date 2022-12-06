package com.example.searchbookapp.data.repository

import androidx.lifecycle.LiveData
import com.example.searchbookapp.data.model.Document
import com.example.searchbookapp.data.model.SearchBookResponse
import retrofit2.Response

interface SearchBookRepository {
    suspend fun searchBooks(
        query: String,
        sort: String,
        page: Int,
        size: Int
    ): Response<SearchBookResponse>

    suspend fun insertBook(book: Document)

    suspend fun deleteBook(book: Document)

    fun selectBook(): LiveData<List<Document>>

}