package com.example.searchbookapp.data.model


import com.google.gson.annotations.SerializedName

data class SearchBookResponse(
    @SerializedName("documents")
    val documents: List<Document>,
    @SerializedName("meta")
    val meta: Meta
)