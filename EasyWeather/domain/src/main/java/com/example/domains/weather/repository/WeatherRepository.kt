package com.example.domains.weather.repository

import com.example.domains.weather.model.WeatherDomainModel

interface WeatherRepository {
    suspend fun getWeather(q: String): WeatherDomainModel
}