package com.example.presentation.module

import com.example.data.api.ApiService
import com.example.data.repository.remote.book.BookRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {

    @Singleton
    @Provides
    fun provideBookRemoteDataSourceImpl(apiService: ApiService) = BookRemoteDataSourceImpl(apiService)


}