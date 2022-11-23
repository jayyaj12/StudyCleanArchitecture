package com.example.searchbookapp.data.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SearchBookResponse(
    @SerialName("documents")
    val documents: List<Document>,
    @SerialName("meta")
    val meta: Meta
)