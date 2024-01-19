package com.example.presentation.module

import com.example.data.repository.remote.book.BookRemoteDataSource
import com.example.data.repository.remote.book.BookRemoteDataSourceImpl
import com.example.data.repository.remote.book.BookRepositoryImpl
import com.example.domain.repository.BookRepository
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
    fun provideBookRepository(
        bookRemoteDataSourceImpl: BookRemoteDataSourceImpl
    ) : BookRepository {
        return BookRepositoryImpl(
            bookRemoteDataSourceImpl
        )
    }

}