package com.example.easyweather.di

import com.example.domains.architecture.coroutine.CoroutineContextProvider
import com.example.domains.architecture.usecase.UseCaseExecutor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class ArchitectureModule {
    @Provides
    fun providesCoroutineContextProvider(): CoroutineContextProvider =
        CoroutineContextProvider.Default

    @Provides
    fun providesUseCaseExecutor() = UseCaseExecutor()
}