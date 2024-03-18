package com.example.presentation.view.book.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.domain.model.UiBookModel
import com.example.sample.base.BaseViewModel

class BookDetailViewModel(stateHandle: SavedStateHandle) : BaseViewModel() {

    var bookItem: LiveData<UiBookModel> = stateHandle.getLiveData("book")

}