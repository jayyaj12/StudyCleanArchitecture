package com.example.data.repository.remote.book

import com.example.data.util.RetrofitFailureStateException
import com.example.domain.NetworkState
import com.example.data.mapper.mapperToBook
import com.example.domain.model.Book
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
    ): Result<List<Book>> {

        when (val searchBookList =
            bookRemoteDataSource.getSearchBook(token, query, sort, page, size, target)) {
            is NetworkState.Success -> return Result.success(mapperToBook(searchBookList.body))
            is NetworkState.Failure -> return Result.failure(
                RetrofitFailureStateException(searchBookList.error, searchBookList.code)
            )
            is NetworkState.NetworkError -> Timber.tag("${this.javaClass.name}_getSearchBook").d(searchBookList.error)
            is NetworkState.UnknownError -> Timber.tag("${this.javaClass.name}_getSearchBook").d(searchBookList.t)
        }

        return Result.failure(IllegalStateException("NetworkError or UnKnownError please check timber"))
    }
}