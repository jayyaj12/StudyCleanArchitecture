package com.example.sample.base

import androidx.annotation.StringRes
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.presentation.util.MutableEventFlow
import com.example.presentation.util.asEventFlow
import kotlinx.coroutines.launch
import timber.log.Timber

abstract class BaseViewModel : ViewModel() {
    private val _baseEventFlow = MutableEventFlow<Event>()
    val baseEventFlow = _baseEventFlow.asEventFlow()
    protected fun baseEvent(event: Event) {
        viewModelScope.launch {
            _baseEventFlow.emit(event)
        }
    }

    sealed class Event {
        data class ShowToast(val message: String) : Event()
        data class ShowToastRes(@StringRes val message: Int) : Event()
        object ShowLoading: Event()
        object HideLoading: Event()
    }

}