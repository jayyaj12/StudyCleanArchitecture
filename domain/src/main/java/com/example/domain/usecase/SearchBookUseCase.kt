package com.example.domain.usecase

import com.example.domain.model.Book
import com.example.domain.repository.BookRepository
import javax.inject.Inject

class SearchBookUseCase @Inject constructor(private val bookRepository: BookRepository) {

    suspend operator fun invoke(
        token: String,
        query: String,
        sort: String?,
        page: Int?,
        size: Int?,
        target: String?
    ): Result<List<Book>> {
        return bookRepository.getSearchBook(token, query, sort, page, size, target)
    }
}