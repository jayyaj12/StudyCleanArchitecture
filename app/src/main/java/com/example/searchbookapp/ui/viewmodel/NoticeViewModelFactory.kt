package com.example.searchbookapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class NoticeViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(NoticeViewModel::class.java)) {
            return NoticeViewModel() as T
        }
        throw java.lang.IllegalArgumentException("ViewModel class is not found")
    }
}