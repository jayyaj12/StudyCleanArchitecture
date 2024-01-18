package com.example.domain.model

data class Book(
    val title: String,
    val contents: String,
    val datetime: String,
    val authors: List<String>,
    val salePrice: Int,
    val thumbnail: String,
    val status: String,
)
