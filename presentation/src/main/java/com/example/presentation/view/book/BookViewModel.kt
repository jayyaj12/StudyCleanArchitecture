package com.example.presentation.view.book

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecase.SearchBookUseCase
import com.example.presentation.util.GetAuthorization
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class BookViewModel @Inject constructor(
    private val searchBookUseCase: SearchBookUseCase,
) : ViewModel() {

    fun getSearchBook(
        query: String,
        sort: String?,
        page: Int?,
        size: Int?,
        target: String?,
    ) {
        try {
            viewModelScope.launch {
                searchBookUseCase(
                    "123",
                    query,
                    sort,
                    page,
                    size,
                    target
                ).onSuccess {
                    Timber.e("result = $it")
                }.onFailure {
                    Timber.e("message: ${it.message}, code: ${it.cause}")
                }
            }
        } catch (e: Exception) {
            Timber.e("Exception ${e.message}")

        }
    }
}