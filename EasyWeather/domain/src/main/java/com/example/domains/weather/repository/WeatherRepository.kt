package com.example.domains.weather.repository

import com.example.domains.weather.model.FutureWeatherDomainModel
import com.example.domains.weather.model.LocationAutoCompleteDomainModel
import com.example.domains.weather.model.WeatherDomainModel

interface WeatherRepository {
    suspend fun getWeather(q: String): WeatherDomainModel

    suspend fun getFutureWeather(q: String, dt: String): FutureWeatherDomainModel

    suspend fun getLocationAutoComplete(q: String): LocationAutoCompleteDomainModel
}