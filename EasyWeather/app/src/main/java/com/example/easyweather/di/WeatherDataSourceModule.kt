package com.example.easyweather.di

import com.example.data.weather.datasource.WeatherDataSource
import com.example.datasource.WeatherApi
import com.example.datasource.weather.datasource.WeatherDataSourceImpl
import com.example.datasource.weather.mapper.FutureWeatherToDataMapper
import com.example.datasource.weather.mapper.WeatherToDataMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
object WeatherDataSourceModule {
    @Provides
    fun providesWeatherApi(
        retrofit: Retrofit
    ): WeatherApi {
        return retrofit.create(WeatherApi::class.java)
    }

    @Provides
    fun providesWeatherToDataMapper() = WeatherToDataMapper()

    @Provides
    fun providesFutureWeatherToDataMapper() = FutureWeatherToDataMapper()

    @Provides
    fun providesWeatherDataSource(
        weatherApi: WeatherApi,
        weatherToDataMapper: WeatherToDataMapper,
        futureWeatherToDataMapper: FutureWeatherToDataMapper,
    ): WeatherDataSource = WeatherDataSourceImpl(
        weatherApi,
        weatherToDataMapper,
        futureWeatherToDataMapper
    )
}
