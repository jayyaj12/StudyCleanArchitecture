package com.example.domain.usecase

import com.example.domain.model.UiBookModel
import com.example.domain.repository.BookRepository
import java.lang.Exception
import javax.inject.Inject

class SearchBookUseCase @Inject constructor(private val bookRepository: BookRepository) {

    suspend operator fun invoke(
        token: String,
        query: String,
        sort: String?,
        page: Int?,
        size: Int?,
        target: String?
    ): Result<List<UiBookModel>> {
        return if(token == "") {
            Result.failure(IllegalStateException("토큰이 비어 있습니다."))
        } else {
            bookRepository.getSearchBook(token, query, sort, page, size, target)
        }
    }
}