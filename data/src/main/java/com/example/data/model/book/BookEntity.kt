package com.example.data.model.book

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BookEntity(
    val meta: Meta,
    val documents: List<Documents>,
)

@Serializable
data class Meta(
    @SerialName("total_count")
    val totalCount: Int,
    @SerialName("pageable_count")
    val pageableCount: Int,
    @SerialName("is_end")
    val isEnd: Boolean,
)

@Serializable
data class Documents(
    val title: String,
    val contents: String,
    val url: String,
    val isbn: String,
    val datetime: String,
    val authors: List<String>,
    val publisher: String,
    val translators: List<String>,
    val price: Int,
    @SerialName("sale_price")
    val salePrice: Int,
    val thumbnail: String,
    val status: String,
)