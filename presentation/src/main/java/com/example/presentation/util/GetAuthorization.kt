package com.example.presentation.util

import com.example.presentation.BuildConfig

object GetAuthorization {

    const val kakaoRestApi = BuildConfig.KAKAO_REST_API_KEY

    fun getAuthorizationToken() = "KakaoAK $kakaoRestApi"

}