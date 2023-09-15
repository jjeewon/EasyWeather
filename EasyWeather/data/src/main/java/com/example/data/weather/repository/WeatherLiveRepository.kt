package com.example.data.weather.repository

import com.example.data.weather.datasource.WeatherDataSource
import com.example.data.weather.mapper.FutureWeatherDataToDomainMapper
import com.example.data.weather.mapper.LocationAutoCompleteDataToDomainMapper
import com.example.data.weather.mapper.WeatherDataToDomainMapper
import com.example.domains.weather.model.FutureWeatherDomainModel
import com.example.domains.weather.model.LocationAutoCompleteDomainModel
import com.example.domains.weather.model.WeatherDomainModel
import com.example.domains.weather.repository.WeatherRepository

class WeatherLiveRepository(
    private val weatherDataSource: WeatherDataSource,
    private val weatherDataToDomainMapper: WeatherDataToDomainMapper,
    private val futureWeatherDataToDomainMapper: FutureWeatherDataToDomainMapper,
    private val locationAutoCompleteDataToDomainMapper: LocationAutoCompleteDataToDomainMapper,
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

    override suspend fun getLocationAutoComplete(q: String): LocationAutoCompleteDomainModel {
        return locationAutoCompleteDataToDomainMapper.toDomain(
            weatherDataSource.getAutoCompleteLocation(q)
        )
    }
}