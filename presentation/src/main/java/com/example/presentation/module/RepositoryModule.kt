package com.example.presentation.module

import com.example.data.repository.remote.book.BookRemoteDataSource
import com.example.data.repository.remote.book.BookRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideBookRepositoryImpl(bookRemoteDataSource: BookRemoteDataSource) =
        BookRepositoryImpl(bookRemoteDataSource)

}