package com.example.data.api

import com.example.data.model.book.BookEntity
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("search/book")
    suspend fun getSearchBook(
        @Query("query") query: String,
        @Query("sort") sort: String?,
        @Query("page") page: Int?,
        @Query("size") size: Int?,
        @Query("target") target: String?,
    ): Response<BookEntity.adas>

}