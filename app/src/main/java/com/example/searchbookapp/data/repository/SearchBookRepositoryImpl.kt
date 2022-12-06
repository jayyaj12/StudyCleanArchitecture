package com.example.searchbookapp.data.repository

import androidx.lifecycle.LiveData
import com.example.searchbookapp.data.api.RetrofitInstance.api
import com.example.searchbookapp.data.db.SearchBookDatabase
import com.example.searchbookapp.data.model.Document
import com.example.searchbookapp.data.model.SearchBookResponse
import retrofit2.Response

class SearchBookRepositoryImpl(private val db: SearchBookDatabase) : SearchBookRepository {
    override suspend fun searchBooks(
        query: String,
        sort: String,
        page: Int,
        size: Int
    ): Response<SearchBookResponse> {
        return api.searchBooks(query, sort, page, size)
    }

    override suspend fun insertBook(book: Document) {
        db.bookSearchDao().insertBook(book)
    }

    override suspend fun deleteBook(book: Document) {
        db.bookSearchDao().deleteBook(book)
    }

    override fun selectBook(): LiveData<List<Document>> = db.bookSearchDao().selectBooks()
}