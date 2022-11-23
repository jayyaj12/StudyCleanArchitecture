package com.example.searchbookapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.searchbookapp.data.repository.SearchBookRepository

class SearchBookViewModelFactory(private val searchBookRepository: SearchBookRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SearchBookViewModel::class.java)) {
            return SearchBookViewModel(searchBookRepository) as T
        }
        throw java.lang.IllegalArgumentException("ViewModel class now found")
    }
}