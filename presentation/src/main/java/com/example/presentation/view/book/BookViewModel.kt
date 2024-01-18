package com.example.presentation.view.book

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecase.BookUseCase
import com.example.presentation.util.GetAuthorization
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BookViewModel @Inject constructor(
    private val bookUseCase: BookUseCase,
) : ViewModel() {

    fun getSearchBook(
        query: String,
        sort: String,
        page: Int,
        size: Int,
        target: String,
    ) {
        viewModelScope.launch {
            bookUseCase.getSearchBook(GetAuthorization.getAuthorizationToken(),
                query,
                sort,
                page,
                size,
                target)
        }
    }

}