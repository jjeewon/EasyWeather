package com.example.data.weather.repository

import com.example.data.weather.datasource.WeatherDataSource
import com.example.data.weather.mapper.FutureWeatherDataToDomainMapper
import com.example.data.weather.mapper.WeatherDataToDomainMapper
import com.example.domains.weather.model.FutureWeatherDomainModel
import com.example.domains.weather.model.WeatherDomainModel
import com.example.domains.weather.repository.WeatherRepository

class WeatherLiveRepository(
    private val weatherDataSource: WeatherDataSource,
    private val weatherDataToDomainMapper: WeatherDataToDomainMapper,
    private val futureWeatherDataToDomainMapper: FutureWeatherDataToDomainMapper,
): WeatherRepository {
    override suspend fun getWeather(q: String): WeatherDomainModel {
        return weatherDataToDomainMapper.toDomain(
            weatherDataSource.getWeather(q)
        )
    }

    override suspend fun getFutureWeather(q: String, dt: String): FutureWeatherDomainModel {
        return futureWeatherDataToDomainMapper.toDomain(
            weatherDataSource.getFutureWeather(q, dt)
        )
    }
}