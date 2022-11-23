package com.example.searchbookapp.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.searchbookapp.data.model.SearchBookResponse
import com.example.searchbookapp.data.repository.SearchBookRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SearchBookViewModel(private val searchBookRepository: SearchBookRepository) : ViewModel() {

    private val _searchResult = MutableLiveData<SearchBookResponse>()
    val searchResult: LiveData<SearchBookResponse> get() = _searchResult

    fun searchBooks(query: String) = viewModelScope.launch(Dispatchers.IO) {
        val response = searchBookRepository.searchBooks(query, "accuracy", 1, 10)
        if (response.isSuccessful) {
            response.body()?.let { body ->
                _searchResult.postValue(body)
            }
        }
    }

}