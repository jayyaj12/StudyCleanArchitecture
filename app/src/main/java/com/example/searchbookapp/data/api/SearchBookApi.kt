package com.example.searchbookapp.data.api

import com.example.searchbookapp.BuildConfig.KAKAO_API_KEY
import com.example.searchbookapp.data.model.SearchBookResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface SearchBookApi {
    @Headers("Authorization: KakaoAK $KAKAO_API_KEY")
    @GET("v3/search/book")
    suspend fun searchBooks(
        @Query("query") query: String,
        @Query("sort") sort: String,
        @Query("page") page: Int,
        @Query("size") size: Int,
    ): Response<SearchBookResponse>
}