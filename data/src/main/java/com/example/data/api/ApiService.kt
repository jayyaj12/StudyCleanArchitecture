package com.example.data.api

import com.example.data.model.book.BookEntity
import com.example.domain.NetworkState
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface ApiService {

    @GET("search/book")
    suspend fun getSearchBook(
        @Header("Authorization") token: String,
        @Query("query") query: String,
        @Query("sort") sort: String?,
        @Query("page") page: Int?,
        @Query("size") size: Int?,
        @Query("target") target: String?,
    ): NetworkState<BookEntity>

}