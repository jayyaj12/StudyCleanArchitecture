package com.example.presentation.module

import com.example.domain.repository.BookRepository
import com.example.domain.usecase.SearchBookUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Singleton
    @Provides
    fun provideBookUseCase(bookRepository: BookRepository) = SearchBookUseCase(bookRepository)

}