package com.example.easyweather.di

import com.example.domains.architecture.usecase.UseCaseExecutor
import com.example.domains.weather.usecase.GetWeatherUseCase
import com.example.presentation.weather.mapper.WeatherDomainToPresentationMapper
import com.example.presentation.weather.viewmodel.WeatherViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
object WeatherPresentationModule {
    @Provides
    fun providesWeatherDomainToPresentationMapper() = WeatherDomainToPresentationMapper()

    @Provides
    fun providesPhoneDetailViewModel(
        getWeatherUseCase: GetWeatherUseCase,
        weatherDomainToPresentationMapper: WeatherDomainToPresentationMapper,
        useCaseExecutor: UseCaseExecutor,
    ) = WeatherViewModel(
        getWeatherUseCase,
        weatherDomainToPresentationMapper,
        useCaseExecutor,
    )
}