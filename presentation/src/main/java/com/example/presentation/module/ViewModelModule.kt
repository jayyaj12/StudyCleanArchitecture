package com.example.presentation.module

import com.example.domain.usecase.BookUseCase
import com.example.presentation.view.book.BookViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ViewModelModule {

    @Singleton
    @Provides
    fun provideBookViewModel(bookUseCase: BookUseCase) = BookViewModel(bookUseCase)

}