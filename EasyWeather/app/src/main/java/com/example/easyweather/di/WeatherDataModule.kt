package com.example.easyweather.di

import com.example.data.weather.datasource.WeatherDataSource
import com.example.data.weather.mapper.WeatherDataToDomainMapper
import com.example.data.weather.repository.WeatherLiveRepository
import com.example.domains.weather.repository.WeatherRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
abstract class WeatherDataModule {
    companion object {
        @Provides
        fun providesWeatherDataToDomainMapper() =
            WeatherDataToDomainMapper()

        @Singleton
        @Provides
        fun provideWeatherRepository(
            weatherDataSource: WeatherDataSource,
            weatherDataToDomainMapper: WeatherDataToDomainMapper,
        ): WeatherRepository {
            return WeatherLiveRepository(
                weatherDataSource = weatherDataSource,
                weatherDataToDomainMapper = weatherDataToDomainMapper,
            )
        }
    }
}