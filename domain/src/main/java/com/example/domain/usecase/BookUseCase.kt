package com.example.domain.usecase

import com.example.domain.model.Book
import com.example.domain.repository.BookRepository
import dagger.hilt.android.HiltAndroidApp
import retrofit2.Response
import javax.inject.Inject

class BookUseCase @Inject constructor(private val bookRepository: BookRepository) {

    suspend fun getSearchBook(
        token: String,
        query: String,
        sort: String?,
        page: Int?,
        size: Int?,
        target: String?,
    ): List<Book> {
        return bookRepository.getSearchBook(token, query, sort, page, size, target)
    }

}