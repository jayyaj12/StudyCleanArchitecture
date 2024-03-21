package com.example.presentation.view.book.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.domain.model.UiBookModel
import com.example.domain.usecase.SearchBookUseCase
import com.example.presentation.util.GetAuthorization
import com.example.sample.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class BookListViewModel @Inject constructor(
    private val searchBookUseCase: SearchBookUseCase,
) : BaseViewModel() {

    private var _getBookList = MutableLiveData<List<UiBookModel>>()
    val getBookList: LiveData<List<UiBookModel>> get() = _getBookList
    fun getSearchBook(
        query: String,
        sort: String?,
        page: Int?,
        size: Int?,
        target: String?,
    ) {
        viewModelScope.launch {
            searchBookUseCase(
                "",
                query,
                sort,
                page,
                size,
                target
            ).onSuccess {
                _getBookList.postValue(it)
            }.onFailure {
                baseEvent(Event.ShowToast(it.message.toString()))
            }
        }

    }
}