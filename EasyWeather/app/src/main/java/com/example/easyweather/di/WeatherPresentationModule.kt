package com.example.easyweather.di

import com.example.domains.architecture.usecase.UseCaseExecutor
import com.example.domains.weather.usecase.GetFutureWeatherUseCase
import com.example.domains.weather.usecase.GetWeatherUseCase
import com.example.presentation.weather.mapper.FutureWeatherDomainToPresentationMapper
import com.example.presentation.weather.mapper.WeatherDomainToPresentationMapper
import com.example.presentation.weather.viewmodel.WeatherViewModel
import com.example.presentation.weatherdetail.mapper.WeatherDetailToPresentationMapper
import com.example.presentation.weatherdetail.viewmodel.WeatherDetailViewModel
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
    fun providesFutureWeatherDomainToPresentationMapper() = FutureWeatherDomainToPresentationMapper()

    @Provides
    fun providesPhoneDetailViewModel(
        getWeatherUseCase: GetWeatherUseCase,
        getFutureWeatherUseCase: GetFutureWeatherUseCase,
        weatherDomainToPresentationMapper: WeatherDomainToPresentationMapper,
        futureWeatherDomainToPresentationMapper: FutureWeatherDomainToPresentationMapper,
        useCaseExecutor: UseCaseExecutor,
    ) = WeatherViewModel(
        getWeatherUseCase,
        getFutureWeatherUseCase,
        weatherDomainToPresentationMapper,
        futureWeatherDomainToPresentationMapper,
        useCaseExecutor,
    )

    @Provides
    fun providesWeatherDetailToPresentationMapper() = WeatherDetailToPresentationMapper()

    @Provides
    fun providesWeatherDetailViewModel(
        getWeatherUseCase: GetWeatherUseCase,
        weatherDetailToPresentationMapper: WeatherDetailToPresentationMapper,
        useCaseExecutor: UseCaseExecutor,
    ) = WeatherDetailViewModel(
        getWeatherUseCase,
        weatherDetailToPresentationMapper,
        useCaseExecutor,
    )
}