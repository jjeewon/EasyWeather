package com.example.easyweather.di

import com.example.domains.architecture.coroutine.CoroutineContextProvider
import com.example.domains.weather.repository.WeatherRepository
import com.example.domains.weather.usecase.GetWeatherUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@InstallIn(SingletonComponent::class)
@Module
object UseCaseModule {
    @Provides
    fun providesGetWeatherUseCase(
        coroutineContextProvider: CoroutineContextProvider,
        weatherRepository: WeatherRepository,
    ): GetWeatherUseCase =
        GetWeatherUseCase(coroutineContextProvider, weatherRepository)
}