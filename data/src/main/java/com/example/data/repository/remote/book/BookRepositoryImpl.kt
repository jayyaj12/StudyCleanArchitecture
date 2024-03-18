package com.example.data.repository.remote.book

import com.example.data.util.RetrofitFailureStateException
import com.example.domain.NetworkState
import com.example.data.mapper.toUiBookModel
import com.example.domain.model.UiBookModel
import com.example.domain.repository.BookRepository
import timber.log.Timber
import javax.inject.Inject

class BookRepositoryImpl @Inject constructor(
    private val bookRemoteDataSource: BookRemoteDataSource,
) : BookRepository {

    override suspend fun getSearchBook(
        token: String,
        query: String,
        sort: String?,
        page: Int?,
        size: Int?,
        target: String?
    ): Result<List<UiBookModel>> {

        when (val searchBookList =
            bookRemoteDataSource.getSearchBook(token, query, sort, page, size, target)) {
            is NetworkState.Success -> return Result.success(searchBookList.body.toUiBookModel())
            is NetworkState.Failure -> return Result.failure(
                RetrofitFailureStateException(searchBookList.error, searchBookList.code)
            )
            is NetworkState.NetworkError -> return Result.failure(IllegalStateException("NetworkError"))
            is NetworkState.UnknownError -> return Result.failure(IllegalStateException("UnKnownError"))
        }
    }
}