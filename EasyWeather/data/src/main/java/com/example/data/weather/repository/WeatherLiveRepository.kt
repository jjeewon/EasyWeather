package com.example.data.weather.repository

import com.example.data.weather.datasource.WeatherDataSource
import com.example.data.weather.mapper.WeatherDataToDomainMapper
import com.example.domains.weather.model.WeatherDomainModel
import com.example.domains.weather.repository.WeatherRepository

class WeatherLiveRepository(
    private val weatherDataSource: WeatherDataSource,
    private val weatherDataToDomainMapper: WeatherDataToDomainMapper,
): WeatherRepository {
    override suspend fun getWeather(q: String): WeatherDomainModel {
        return weatherDataToDomainMapper.toDomain(
            weatherDataSource.getWeather(q)
        )
    }
}